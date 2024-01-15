package gg.vape.module.blatant;

import gg.vape.Vape;
import gg.vape.event.impl.EventMotion;
import gg.vape.event.impl.EventPacketReceive;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.combat.Sprint;
import gg.vape.unmap.ItemLimitData;
import gg.vape.value.BooleanValue;
import gg.vape.value.LimitValue;
import gg.vape.wrapper.impl.*;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;

public class NoSlow extends Mod {
   public final BooleanValue limitItem = BooleanValue.create(this, "Limit Items", false, "Limits to whitelisted items only.");
   public final LimitValue limits;
   public boolean knockback;

   public NoSlow() {
      super("NoSlowdown", 14828276, Category.Blatant, "Prevents slowing down when\nblocking or using items.");
      this.limits = LimitValue.create(this, "noslowdown-whitelist", "Whitelisted", LimitValue.allowed, new ItemLimitData("swords"));
      this.limitItem.limitValues(this.limits);
      this.addValue(this.limitItem, this.limits);
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onPacketReceive(EventPacketReceive event) {
      Packet packet = event.getPacket();
      if (packet.isInstance(MappedClasses.SPacketExplosion)) {
         this.knockback = true;
      }

      if (packet.isInstance(MappedClasses.SPacketEntityVelocity)) {
         S12PacketEntityVelocity S12 = new S12PacketEntityVelocity(packet);
         EntityPlayerSP player = Minecraft.thePlayer();
         if (S12.getEntityID() == player.getEntityID()) {
            this.knockback = true;
         }
      }

   }

   public void onMotionUpdate(EventMotion event) {
      EntityPlayerSP player = Minecraft.thePlayer();



      if (this.knockback) {
         if (player.onGround()) {
            this.knockback = false;
         }
      } else if (!player.isInWater()) {
         if (event.getType() == EventType.PRE) {
            double forward = player.movementInput().moveForward();
            double strafe = player.movementInput().moveStrafe();
            float yaw = player.rotationYaw();
            if (player.isUsingItem() && (!this.limitItem.getValue() || this.limits.isValid(player.getHeldItemHand())) && (Math.abs(strafe) == 0.20000000298023224 || Math.abs(forward) == 0.20000000298023224)) {
               if (Vape.instance.getModManager().getState(Sprint.class)) {
                  player.setSprinting(true);
               }

               if (Math.abs(strafe) == 0.20000000298023224) {
                  if (strafe > 0.0) {
                     player.movementInput().moveStrafe(1.0F);
                  } else if (strafe < 0.0) {
                     player.movementInput().moveStrafe(-1.0F);
                  }
               }

               if (Math.abs(forward) == 0.20000000298023224) {
                  if (forward > 0.0) {
                     player.movementInput().moveForward(1.0F);
                  } else if (forward < 0.0) {
                     player.movementInput().moveForward(-1.0F);
                  }
               }

               if (Math.abs(player.movementInput().moveStrafe()) != 1.0F && forward > 0.0) {
                  forward *= 1.2999999523162842;
               }

               if (forward != 0.0) {
                  strafe *= 0.5;
               } else {
                  strafe *= 0.85;
               }

               player.motionX(forward * Math.cos(Math.toRadians(yaw + 90.0F)) + strafe * Math.sin(Math.toRadians(yaw + 90.0F)));
               player.motionZ(forward * Math.sin(Math.toRadians(yaw + 90.0F)) - strafe * Math.cos(Math.toRadians(yaw + 90.0F)));
            }
         }

      }

      KillAura ka = Vape.instance.getModManager().getMod(KillAura.class);

      if (!(mc.thePlayer.isBlocking() || mc.thePlayer.isUsingItem()) || mc.thePlayer.isSneaking() || ! MovementInput() || !ka.targets.isEmpty())
         return;
      if (event.isPre()) {
         mc.thePlayer.sendQueue.addToSendQueue(new C09PacketHeldItemChange(mc.thePlayer.inventory.currentItem % 8 + 1));
         mc.thePlayer.sendQueue.addToSendQueue(new C09PacketHeldItemChange(mc.thePlayer.inventory.currentItem));
      } else {
         mc.thePlayer.sendQueue.addToSendQueue(new C08PacketPlayerBlockPlacement(mc.thePlayer.inventory.getCurrentItem()));
      }
   }

   public static boolean MovementInput() {
      return mc.gameSettings.keyBindForward.isKeyDown() || mc.gameSettings.keyBindLeft.isKeyDown() || mc.gameSettings.keyBindRight.isKeyDown() || mc.gameSettings.keyBindBack.isKeyDown();
   }

}
