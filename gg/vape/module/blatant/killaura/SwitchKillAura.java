package gg.vape.module.blatant.killaura;

import gg.vape.Vape;
import gg.vape.event.impl.EventMotion;
import gg.vape.event.impl.EventPacketSend;
import gg.vape.manager.ModManager;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Mod;
import gg.vape.module.SubModule;
import gg.vape.module.blatant.*;
import gg.vape.module.none.ClientSettings;
import gg.vape.utils.MathUtil;
import gg.vape.wrapper.impl.*;

public class SwitchKillAura extends SubModule {
   public final KillAura killaura = (KillAura)this.getParent();
   public float yaw;
   public final double critOffset = (double)this.randomOffset(1969.0, -1969.0) / 2000000.0;
   public boolean collidedVertically;
   public boolean unblocking;
   public boolean blocking;

   public SwitchKillAura(Mod module, String modeName) {
      super(module, modeName);
   }

   public void onEnable() {
      this.blocking = false;
      this.unblocking = false;
   }

   public void onDisable() {
      this.blocking = false;
      this.unblocking = false;
   }

   public void onMotionUpdate(EventMotion event) {
      ModManager moduleManager = Vape.instance.getModManager();
      if (!moduleManager.getState(Scaffold.class) && !this.killaura.legitAura.getValue()) {
         if (!this.killaura.requireMouseDown.getValue() || ClientSettings.isMouseDown()) {
            if (!this.killaura.guiCheck.getValue() || !Minecraft.currentScreen().isNotNull()) {
               boolean oldForge = ForgeVersion.minorVersion() < 23;
               boolean jumpCrit = Vape.instance.getModManager().getMod(Criticals.class).shouldCrit() && !moduleManager.getState(Speed.class) && !moduleManager.getState(Fly.class) && !moduleManager.getState(LongJump.class);
               EntityPlayerSP player = Minecraft.thePlayer();
               EntityLivingBase target;
               if (event.getType() == EventType.PRE) {
                  if (this.killaura.timer.hasTimeElapsed(this.killaura.switchDelay.getValue().intValue())) {
                     this.killaura.findTarget();
                  }

                  if (this.killaura.switchTimes >= this.killaura.targets.size()) {
                     this.killaura.switchTimes = 0;
                  }

                  if (this.killaura.targets.size() > 0) {
                     if (this.killaura.timer.hasTimeElapsed(this.killaura.switchDelay.getValue().intValue())) {
                        this.resetSwitchs();
                        this.killaura.timer.reset();
                     }

                     target = (EntityLivingBase)this.killaura.targets.get(this.killaura.switchTimes);
                     if (target != null) {
                        if (!this.killaura.isValid(target)) {
                           this.killaura.findTarget();
                           this.resetSwitchs();
                           return;
                        }

                        double distance = player.getDistanceToEntity(target);
                        if (distance <= this.killaura.swingRange.getValue()) {
                           float[] rotations = this.killaura.getRotationsToEntity(target);
                           float roundYaw = MathUtil.round(this.killaura.degrees(target.posX(), target.posZ(), this.yaw) + this.randomOffset(-5.0, 5.0), -180.0F, 180.0F);
                           byte validYaw = 70;
                           if (roundYaw > (float)validYaw) {
                              roundYaw = validYaw;
                           } else if (roundYaw < (float)(-validYaw)) {
                              roundYaw = (float)(-validYaw);
                           }

                           if (Vape.instance.getModManager().getState(Criticals.class) && target.hurtResistantTime() <= 15 && jumpCrit && !player.isOnLadder()) {
                              if (player.ticksExisted() % 2 == 0) {
                                 if (player.isCollidedVertically()) {
                                    this.collidedVertically = true;
                                    player.setJumpTicks(2);
                                    event.setY(event.getY() + 0.0672268904 + this.critOffset);
                                    event.setOnGround(false);
                                 }
                              } else if (event.getY() == player.posY() && event.isOnGround()) {
                                 event.setOnGround(false);
                              }
                           }

                           event.setYaw(this.yaw += roundYaw / 1.1F);
                           event.setPitch(rotations[1] / 1.15F + this.randomOffset(-5.0, 5.0));
                           if (this.killaura.autoBlock.checkValue() && oldForge && player.getHeldItemHand().isNotNull() && player.getHeldItemHand().getItem().isNotNull() && player.getHeldItemHand().getItem().isInstance(MappedClasses.ItemSword)) {
                              player.setItemInUse(player.getHeldItemHand(), 99999);
                              this.blocking = false;
                           }
                        }
                     }
                  } else {
                     this.yaw = player.rotationYaw();
                  }
               } else if (event.getType() == EventType.POST) {
                  if (this.killaura.targets.size() > 0 && this.killaura.targets.get(this.killaura.switchTimes) != null) {
                     target = (EntityLivingBase)this.killaura.targets.get(this.killaura.switchTimes);
                     boolean perfectSwing = this.killaura.perfectSwing.getValue() ? player.getCooledAttackStrength(0.0F) == 1.0F : this.killaura.switchTimer.hasTimeElapsed(this.killaura.getAttackPreDelay());
                     if (perfectSwing && (!player.isBlocking() || player.ticksExisted() % 2 != 0) && (!jumpCrit || player.ticksExisted() % 2 != 0 && (!player.onGround() || this.collidedVertically || target.hurtResistantTime() > 15)) && Math.abs(this.killaura.degrees(target.posX(), target.posZ(), this.yaw)) < 10.0F) {
                        double distance = player.getDistanceToEntity(target);
                        if (this.unblocking && player.isBlocking() && oldForge) {
                           this.blocking = true;
                           this.unblocking = false;
                           Minecraft.playerController().onStoppedUsingItem(player);
                           this.blocking = false;
                           player.setItemInUse(player.getHeldItemHand(), 99999);
                        }

                        if (distance <= this.killaura.swingRange.getValue()) {
                           if (oldForge) {
                              player.swingItem();
                           }

                           if (distance <= this.killaura.attackRange.getValue()) {
                              Minecraft.playerController().attackEntity(player, target);
                              if (!oldForge) {
                                 player.swingItem();
                                 player.resetCooldown();
                              }

                              if (!this.unblocking && player.isBlocking() && oldForge) {
                                 Minecraft.playerController().sendUseItem(player, player.getWorld(), player.getHeldItemHand());
                                 this.unblocking = true;
                              }
                           }
                        }

                        this.killaura.switchTimer.reset();
                     }
                  } else if (this.unblocking && this.killaura.switchTimer.hasTimeElapsed(200L) && oldForge) {
                     this.blocking = true;
                     Minecraft.playerController().onStoppedUsingItem(player);
                     this.blocking = false;
                     this.unblocking = false;
                  }
               }

            }
         }
      }
   }

   public void onPacketSend(EventPacketSend event) {
      if (!this.killaura.legitAura.checkValue()) {
         if (event.getPacket().isInstance(MappedClasses.CPacketAnimation) && this.killaura.noSwing.getValue()) {
            event.setCancelled(true);
         }
      }
   }

   public float randomOffset(double min, double max) {
      return (float)(Math.random() * (min - max) + max);
   }

   public void resetSwitchs() {
      ++this.killaura.switchTimes;
      if (this.killaura.switchTimes >= this.killaura.targets.size()) {
         this.killaura.switchTimes = 0;
      }

   }
}
