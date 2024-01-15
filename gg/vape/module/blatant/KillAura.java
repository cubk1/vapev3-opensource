package gg.vape.module.blatant;

import gg.vape.Vape;
import gg.vape.event.impl.EventMotion;
import gg.vape.event.impl.EventPacketSend;
import gg.vape.event.impl.EventPlayerTick;
import gg.vape.event.impl.EventRender3D;
import gg.vape.friend.Friend;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.blatant.killaura.SwitchKillAura;
import gg.vape.module.none.ClientSettings;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.utils.MathUtil;
import gg.vape.utils.RotationUtil;
import gg.vape.utils.TimerUtil;
import gg.vape.utils.render.RenderUtil;
import gg.vape.value.*;
import gg.vape.wrapper.impl.*;
import pub.nextsense.Tweaker;

import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class KillAura extends Mod {
   public final RandomValue aps = RandomValue.create(this, "Attacks per Second", "#.#", "", 1.0, 6.0, 13.0, 20.0);
   public final NumberValue swingRange = NumberValue.create(this, "Swing range", "#.#", "", 0.0, 4.0, 6.0);
   public final NumberValue attackRange = NumberValue.create(this, "Attack range", "#.#", "", 0.0, 3.5, 6.0);
   public final NumberValue maxAngle = NumberValue.create(this, "Max angle", "#", "", 1.0, 90.0, 360.0, 5.0);
   public final NumberValue maxTargets = NumberValue.create(this, "Max targets", "#", "", 1.0, 1.0, 6.0, 1.0);
   public final NumberValue switchDelay = NumberValue.create(this, "Switch Delay", "#", "", 50.0, 400.0, 1000.0, 50.0);
   public final BooleanValue requireMouseDown = BooleanValue.create(this, "Require mouse down", false);
   public final BooleanValue attackInvisibles = BooleanValue.create(this, "Attack invisibles", false);
   public final BooleanValue attackThroughWalls = BooleanValue.create(this, "Attack through walls", false);
   public final BooleanValue showTarget = BooleanValue.create(this, "Show target", false);
   public final BooleanValue limitToItems = BooleanValue.create(this, "Limit to items", false, "Killaura functions only while holding selected items");
   public final BooleanValue autoBlock = BooleanValue.create(this, "AutoBlock", false, "Automatically blocks").setBlatant(true);
   public final BooleanValue guiCheck = BooleanValue.create(this, "GUI Check", true, "Does not attack when inside of a GUI.");
   public final BooleanValue legitAura = BooleanValue.create(this, "Legit Aura", false, "Use Legit Aura instead of Blatant Aura when blatant is enabled.").setBlatant(true);
   public final BooleanValue noSwing = BooleanValue.create(this, "No Swing", false, "Prevents you from swinging server side.").setBlatant(true);
   public final BooleanValue perfectSwing = BooleanValue.create(this, "Perfect Swing", false, "Attacks perfectly on 1.9+ combat servers.\n(1.12.2 Only)");
   public final SubModuleValue switchAura = new SubModuleValue("Switch", new SwitchKillAura(this, "Switch"));
   public final ModeValue blatantAura;
   public final LimitValue limits;
   public TimerUtil timer;
   public TimerUtil switchTimer;
   public List<EntityLivingBase> targets;
   public int switchTimes;
   public final Random random;
   public final Color currentTargetColor;
   public final Color switchTargetColor;
   public long attackPreSecond;
   public int attackTimes;
   public boolean isAttackInProgress;
   public int attackCountdown;

   public KillAura() {
      super("KillAura", -2420426, Category.Blatant, "Attack players around you\nwithout aiming at them.");
      this.blatantAura = ModeValue.create(this, "Blatant Mode", this.switchAura, this.switchAura);
      this.limits = LimitValue.create(this, "killaura-alloweditems", "Allowed Items", LimitValue.allowed, Collections.emptyList());
      this.timer = new TimerUtil();
      this.switchTimer = new TimerUtil();
      this.targets = new CopyOnWriteArrayList<>();
      this.random = new Random();
      this.currentTargetColor = new Color(255, 0, 0, 100);
      this.switchTargetColor = new Color(255, 112, 112, 100);
      this.blatantAura.getComponent().addAction(new ActionToggleBlatantAura(this));
      this.addValue(this.aps, this.switchDelay, this.swingRange, this.attackRange, this.maxAngle, this.maxTargets, this.blatantAura);
      if (ForgeVersion.minorVersion() <= 15) {
         this.addValue(this.autoBlock);
      } else {
         this.addValue(this.perfectSwing);
      }

      this.addValue(this.attackInvisibles, this.attackThroughWalls, this.requireMouseDown, this.guiCheck, this.showTarget, this.legitAura, this.noSwing, this.limitToItems.limitValues(this.limits), this.limits);
      this.swingRange.getComponent().addAction(new ActionEditRange(this));
   }

   public void onEnable() {
      super.onEnable();
      this.targets.clear();
   }

   public void onDisable() {
      super.onDisable();
      this.targets.clear();
   }

   public void onTick(EventPlayerTick event) {
      if (this.legitAura.checkValue() || !Tweaker.isBlatantMode()) {
         if (!this.guiCheck.getValue() || !Minecraft.currentScreen().isNotNull()) {
            if (!Minecraft.theWorld().isNull()) {
               if (this.switchTimer.hasTimeElapsed(this.getAttackPreDelay())) {
                  if (this.requireMouseDown.getValue() && !ClientSettings.isMouseDown()) {
                     this.targets.clear();
                  } else {
                     this.findTarget();
                     EntityPlayerSP player = Minecraft.thePlayer();
                     for (EntityLivingBase target : this.targets) {
                        if (this.isValid(target)) {
                           double distance = player.getDistanceToEntity(target);
                           if (distance <= this.swingRange.getValue()) {
                              player.swingItem();
                              if (distance <= this.attackRange.getValue()) {
                                 Minecraft.playerController().attackEntity(player, target);
                              }
                           }
                        }
                     }

                     this.switchTimer.reset();
                  }
               }
            }
         }
      }
   }

   public void onRender3D(EventRender3D event) {
      this.setSuffix(this.blatantAura.getValue().getName());
      if (this.showTarget.getValue() && !this.targets.isEmpty()) {
         EntityPlayerSP player = Minecraft.thePlayer();

         for (EntityLivingBase target : this.targets) {
            if ((double) player.getDistanceToEntity(target) <= this.attackRange.getValue() && (!Tweaker.isBlatantMode() || this.targets.get(this.switchTimes).equals(target))) {
               RenderUtil.drawESP(target, 0.0, null, this.currentTargetColor, event.getPartialTicks());
            } else {
               RenderUtil.drawESP(target, 0.0, null, this.switchTargetColor, event.getPartialTicks());
            }
         }

      }
   }

   public void onMotionUpdate(EventMotion event) {
      if(blatantAura.getValue().current.equalsIgnoreCase("Switch"))
         switchAura.getInstance().onMotionUpdate(event);
   }

   public void onPacketSend(EventPacketSend event) {
      if(blatantAura.getValue().current.equalsIgnoreCase("Switch"))
         switchAura.getInstance().onPacketSend(event);
   }

   public long getAttackPreDelay() {
      int minAps = this.aps.getValue()[0].intValue();
      int maxAps = this.aps.getValue()[1].intValue();
      int apsOffset = minAps - maxAps;
      int currentAps = apsOffset <= 0 ? maxAps : this.random.nextInt(apsOffset) + maxAps + 1;
      currentAps = Math.max(currentAps, 1);
      if (!this.isAttackInProgress) {
         this.attackPreSecond = 1000 / currentAps;
         if (this.random.nextInt(4) == 1) {
            this.isAttackInProgress = true;
            this.attackCountdown = 1 + this.random.nextInt(5);
         } else if (this.random.nextInt(10) != 1 && this.random.nextInt(10) == 1) {
            this.isAttackInProgress = true;
            this.attackCountdown = 5 + this.random.nextInt(10);
         }
      }

      if (this.isAttackInProgress) {
         ++this.attackTimes;
         if (this.attackTimes >= this.attackCountdown) {
            this.attackTimes = 0;
            this.isAttackInProgress = false;
         }
      }

      boolean hasLowAps = true;
      if (this.random.nextInt(48) % (!hasLowAps ? 4 : 10) == 0 && !this.isAttackInProgress) {
         maxAps = !hasLowAps ? 50 : 25;
         minAps = !hasLowAps ? 120 : 70;
         apsOffset = minAps - maxAps;
         this.attackPreSecond += this.random.nextInt(apsOffset) + maxAps;
      }

      return this.attackPreSecond;
   }

   public void findTarget() {
      this.targets.clear();
      ArrayList<Entity> loadedEntityList = new ArrayList<>(Minecraft.theWorld().loadedEntityList());
      Iterator<Entity> entityIterator = loadedEntityList.iterator();
      while(true) {
         Object nativeEntity;
         Entity entity;
         do {
            if (!entityIterator.hasNext()) {
               this.targets.sort(new TargetComparator(this, null));
               this.targets.sort(new DistanceComparator(this, null));
               ArrayList<EntityLivingBase> entities = new ArrayList<>(this.targets);
               this.targets.clear();

               for(int i = 0; i < this.maxTargets.getValue().intValue() && i < entities.size(); ++i) {
                  this.targets.add(entities.get(i));
               }

               return;
            }

            nativeEntity = entityIterator.next();
            entity = new Entity(nativeEntity);
         } while(ClientSettings.not1710 && entity.isInstance(MappedClasses.MouseEvent));

         if (entity.isInstance(MappedClasses.EntityLivingBase)) {
            EntityLivingBase ent = new EntityLivingBase(nativeEntity);
            if (this.isValid(ent)) {
               this.targets.add(ent);
            }
         }
      }
   }

   public boolean isInTargets(EntityLivingBase entity) {
      if (!this.limitToItems.getValue()) {
         return Vape.instance.getSettings().isTarget(entity, !this.attackInvisibles.getValue());
      } else {
         ItemStack itemStack = Minecraft.thePlayer().getHeldItemHand();
         if (itemStack.isNull()) {
            return false;
         } else {
            Item item = itemStack.getItem();
            if (item.isNull()) {
               return false;
            } else {
               return this.limits.isValid(itemStack, true) && Vape.instance.getSettings().isTarget(entity, !this.attackInvisibles.getValue());
            }
         }
      }
   }

   // isValid
   public boolean isValid(EntityLivingBase entity) {
      if (entity.isNull()) {
         return false;
      } else if (entity.equals(Minecraft.thePlayer())) {
         return false;
      } else if (!this.isInTargets(entity)) {
         return false;
      } else if (!(entity.getHealth() <= 0.0F) && !entity.isDead()) {
         if ((double) Minecraft.thePlayer().getDistanceToEntity(entity) >= this.swingRange.getValue()) {
            return false;
         } else if (RotationUtil.getAngleToEntity(Minecraft.thePlayer(), entity) > this.maxAngle.getValue().intValue() / 2) {
            return false;
         } else {
            Friend friend = Vape.instance.getFriendManager().getFriend(entity.getName());
            if (friend != null && !friend.inFriends()) {
               return false;
            } else {
               return this.attackThroughWalls.getValue() || Minecraft.thePlayer().canEntityBeSeen(entity);
            }
         }
      } else {
         return false;
      }
   }

   public float[] getRotations(double posX, double posZ, double posY) {
      EntityPlayerSP player = Minecraft.thePlayer();
      double x = posX - player.posX();
      double z = posZ - player.posZ();
      double y = posY - player.posY() - 1.2;
      double sqrt = MathUtil.sqrt(x * x + z * z);
      float yaw = (float)(Math.atan2(z, x) * 180.0 / Math.PI) - 90.0F;
      float pitch = (float)(-(Math.atan2(y, sqrt) * 180.0 / Math.PI));
      return new float[]{yaw, pitch};
   }

   public float[] getRotationsToEntity(EntityLivingBase entityLivingBase) {
      double posX = entityLivingBase.posX();
      double posZ = entityLivingBase.posZ();
      double posY = entityLivingBase.posY() + (double)(entityLivingBase.getEyeHeight() / 2.0F);
      return this.getRotations(posX, posZ, posY);
   }

   public float degrees(double posX, double posZ, float yaw) {
      EntityPlayerSP player = Minecraft.thePlayer();
      double x = posX - player.posX();
      double z = posZ - player.posZ();
      double atan;
      if (z < 0.0 && x < 0.0) {
         atan = 90.0 + Math.toDegrees(Math.atan(z / x));
      } else if (z < 0.0 && x > 0.0) {
         atan = -90.0 + Math.toDegrees(Math.atan(z / x));
      } else {
         atan = Math.toDegrees(-Math.atan(x / z));
      }

      return MathUtil.wrapAngleTo180(-(yaw - (float)atan));
   }

   // $FF: synthetic method
   static ModeValue getBlatantValue(KillAura killAura) {
      return killAura.blatantAura;
   }


   static class ActionToggleBlatantAura implements IGuiCallback {
      // $FF: synthetic field
      final KillAura killAura;

      ActionToggleBlatantAura(KillAura killAura) {
         this.killAura = killAura;
      }

      public void call(IGuiComponent inst) {
         ((Mod) KillAura.getBlatantValue(this.killAura).getOwner()).setSuffix(KillAura.getBlatantValue(this.killAura).getValue().getName());
      }
   }
   static class ActionEditRange implements IGuiCallback {
      // $FF: synthetic field
      final KillAura killAura;

      ActionEditRange(KillAura killAura) {
         this.killAura = killAura;
      }

      public void call(IGuiComponent inst) {
         if (this.killAura.swingRange.getValue() < this.killAura.attackRange.getValue()) {
            this.killAura.swingRange.setValue(this.killAura.attackRange.getValue() + 0.1);
         }

      }
   }


   static class TargetComparator implements Comparator {
      // $FF: synthetic field
      final KillAura killAura;

      public TargetComparator(KillAura killAura) {
         this.killAura = killAura;
      }

      public int compare(Object o1, Object o2) {
         EntityPlayerSP player = Minecraft.thePlayer();
         return Integer.compare(RotationUtil.getAngleToEntity(player, (Entity)o1), RotationUtil.getAngleToEntity(player, (Entity)o2));
      }

      // $FF: synthetic method
      TargetComparator(KillAura killAura, ActionToggleBlatantAura action) {
         this(killAura);
      }
   }

   static class DistanceComparator implements Comparator {
      // $FF: synthetic field
      final KillAura killAura;

      public DistanceComparator(KillAura killAura) {
         this.killAura = killAura;
      }

      public int compare(Object o1, Object o2) {
         EntityPlayerSP player = Minecraft.thePlayer();
         return Float.compare(player.getDistanceToEntity((Entity)o1), player.getDistanceToEntity((Entity)o2));
      }

      // $FF: synthetic method
      DistanceComparator(KillAura killAura, ActionToggleBlatantAura action) {
         this(killAura);
      }
   }



}
