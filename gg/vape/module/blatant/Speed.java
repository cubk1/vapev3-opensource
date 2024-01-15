package gg.vape.module.blatant;

import gg.vape.Vape;
import gg.vape.event.impl.EventMotion;
import gg.vape.event.impl.EventMove;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.blatant.speed.*;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.value.ModeValue;
import gg.vape.value.SubModuleValue;
import gg.vape.wrapper.impl.*;

public class Speed extends Mod {
   public double strafeSpeed;
   public double sqrt;
   public int step;
   public final SubModuleValue bhop = new SubModuleValue("Bhop", new BhopSpeed(this, "Bhop"));
   public final SubModuleValue hypixel = new SubModuleValue("Hypixel", new HypixelSpeed(this, "Hypixel"));
   public final SubModuleValue hypixelGround = new SubModuleValue("Hypixel Ground", new HypixelGround(this, "Hypixel Ground"));
   public final SubModuleValue yport = new SubModuleValue("Y-Port", new YPortSpeed(this, "Y-Port"));
   public final SubModuleValue mineplex = new SubModuleValue("Mineplex", new MineplexSpeed(this, "Mineplex"));
   public final ModeValue modeDesc;

   public Speed() {
      super("Speed", 49630, Category.Blatant, "Increases your movement with various methods.");
      this.modeDesc = ModeValue.create(this, "Mode",
              "Speed mode to use.\n" +
              "Bhop - Bypasses Old NCP\n" +
              "Y-Port - Bypasses Old NCP\n" +
              "Hypixel - Bhop that bypasses Watchdog", this.hypixel, this.hypixelGround, this.mineplex, this.bhop, this.yport);
      (this.modeDesc.getComponent()).addAction(new ActionChangeSpeedMode(this));
      this.addValue(this.modeDesc);
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void setStep(int step) {
      this.step = step;
   }

   public double defaultSpeed() {
      double baseSpeed = 0.2873;
      if (Minecraft.thePlayer().isPotionActive(Potion.moveSpeed())) {
         int amplifier = Minecraft.thePlayer().getActivePotionEffect(Potion.moveSpeed()).getAmplifier();
         baseSpeed *= 1.0 + 0.2 * (double)(amplifier + 1);
      }

      return baseSpeed;
   }

   public void onEnable() {
      Vape.instance.getSettings().speedCheck(this);
      this.strafeSpeed = this.defaultSpeed();
      this.sqrt = 0.0;
      this.step = 2;
   }

   public void onMove(EventMove event) {
      if (event.isPre()) {
         if (this.modeDesc.getValue() == this.hypixel) {
            this.hypixel.getInstance().onMove(event);
         } else if (this.modeDesc.getValue() == this.bhop) {
            this.bhop.getInstance().onMove(event);
         } else if (this.modeDesc.getValue() == this.yport) {
            this.yport.getInstance().onMove(event);
         } else if (this.modeDesc.getValue() == this.mineplex) {
            this.mineplex.getInstance().onMove(event);
         }else if (this.modeDesc.getValue() == this.hypixelGround) {
            this.hypixelGround.getInstance().onMove(event);
         }

      }
   }

   public void onMotionUpdate(EventMotion event) {
      this.setSuffix(this.modeDesc.getValue().getName());
      if (event.getType() == EventType.PRE) {
         Entity player = Minecraft.thePlayer();
         if (this.modeDesc.getValue() == this.yport) {
            this.yport.getInstance().onMotionUpdate(event);
         }

         double x = player.posX() - player.prevPosX();
         double z = player.posZ() - player.prevPosZ();
         this.sqrt = Math.sqrt(x * x + z * z);
      }

   }

   public void strafe(EventMove event, double speed, EntityPlayerSP player) {
      double forward = player.movementInput().moveForward();
      double strafe = player.movementInput().moveStrafe();
      float yaw = player.rotationYaw();
      if (forward == 0.0 && strafe == 0.0) {
         event.setX(0.0);
         event.setZ(0.0);
      } else if (forward != 0.0) {
         if (strafe != 0.0) {
            if (strafe > 0.0) {
               yaw += forward > 0.0 ? -45.0F : 45.0F;
               strafe = 0.0;
            } else {
               yaw += forward > 0.0 ? 45.0F : -45.0F;
               strafe = 0.0;
            }
         }

         if (forward > 0.0) {
            forward = 1.0;
         } else {
            forward = -1.0;
         }
      }

      double cos = Math.cos(Math.toRadians(yaw + 90.0F));
      double sin = Math.sin(Math.toRadians(yaw + 90.0F));
      event.setX(forward * speed * cos + strafe * speed * sin);
      event.setZ(forward * speed * sin - strafe * speed * cos);
   }

   // $FF: synthetic method
   static ModeValue getMode(Speed speed) {
      return speed.modeDesc;
   }

   static class ActionChangeSpeedMode implements IGuiCallback {
      // $FF: synthetic field
      final Speed speed;

      ActionChangeSpeedMode(Speed speed) {
         this.speed = speed;
      }

      public void call(IGuiComponent inst) {
         ((Mod) Speed.getMode(this.speed).getOwner()).setSuffix(Speed.getMode(this.speed).getValue().getName());
      }
   }




}
