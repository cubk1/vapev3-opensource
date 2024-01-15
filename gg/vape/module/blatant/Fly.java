package gg.vape.module.blatant;

import gg.vape.Vape;
import gg.vape.event.impl.EventMotion;
import gg.vape.event.impl.EventMove;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.unmap.ModeSelection;
import gg.vape.utils.TimerUtil;
import gg.vape.value.BooleanValue;
import gg.vape.value.ModeValue;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.Potion;
import gg.vape.wrapper.impl.Timer;

public class Fly extends Mod {
   public final ModeSelection hypixel = new ModeSelection("Hypixel");
   public final ModeSelection normal = new ModeSelection("Normal");
   public final NumberValue speed = NumberValue.create(this, "Speed", "#.#", "", 0.1, 0.5, 5.0, 0.1, "Speed for Normal fly mode.");
   public final NumberValue vertical = NumberValue.create(this, "Vertical Speed", "#.#", "", 0.1, 0.2, 5.0, 0.1, "Speed for Normal vertical fly mode.");
   public final NumberValue boost = NumberValue.create(this, "Hy-Boost", "#.##", "x", 1.0, 1.25, 1.5, 0.01, "The boost value for Hypixel fly");
   public final ModeValue c8787;
   public final BooleanValue c6073;
   public final TimerUtil c1868;
   public int c472;
   public int c5513;
   public final double c3828;

   public Fly() {
      super("Fly", 49630, Category.Blatant, "Makes you go zoom.");
      this.c8787 = ModeValue.create(this, "Mode", this.normal, this.normal, this.hypixel);
      this.c6073 = BooleanValue.create(this, "Boost", false, "Increases Hypixel fly speed\nYou will not be able to fly\ninfinitely with this enabled.");
      this.c1868 = new TimerUtil();
      this.c6073.limitValues(this.boost);
      this.addValue(this.c8787, this.speed, this.vertical, this.c6073, this.boost);
      this.c3828 = this.c7020(6969.0, -6969.0) / 2.0E15;
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onEnable() {
      Vape.instance.getSettings().speedCheck(this);
      Minecraft.getTimer().setTimerSpeed(1.0F);
      this.c472 = -1;
      if (this.c6073.getValue() && this.c1868.hasTimeElapsed(5000L)) {
         this.c5513 = 30;
      }

   }

   public void onDisable() {
      Minecraft.getTimer().setTimerSpeed(1.0F);
   }

   public void onMotionUpdate(EventMotion event) {
      if (event.isPre() && this.c8787.getValue() == this.hypixel) {
         EntityPlayerSP var2 = Minecraft.thePlayer();
         event.setOnGround(false);
         var2.c3224(false);
      }

   }

   public void onMove(EventMove event) {
      if (event.isPre()) {
         this.setSuffix(this.c8787.getValue().getName());
         EntityPlayerSP var2 = Minecraft.thePlayer();
         Timer var3 = Minecraft.getTimer();
         if (this.c8787.getValue() == this.hypixel) {
            event.setY(0.0);
            var2.motionY(0.0);
            this.c5730(event, this.c3973());
            if (this.c6073.getValue()) {
               --this.c5513;
               if (this.c1868.hasTimeElapsed(7000L)) {
                  this.c1868.reset();
               }

               float var4 = this.boost.getValue().floatValue();
               if (this.c5513 > 0 && var4 > 1.0F && !this.c1868.hasTimeElapsed(7000L)) {
                  var3.setTimerSpeed(1.0F + var4);
                  if (this.c5513 < 10) {
                     float var5 = (float)(this.c5513 / 10);
                     if ((double)var5 > 0.5) {
                        var5 = 1.0F;
                     }

                     var3.setTimerSpeed(1.0F + var4 * var5);
                  }
               } else {
                  var3.setTimerSpeed(1.0F);
               }
            }

            ++this.c472;
            if (this.c472 == 1) {
               var2.c7698(var2.posX(), var2.boundingBox().minY() + 9.6918752349782E-13 + this.c3828, var2.posZ(), var2.rotationYaw(), var2.rotationPitch());
            }

            if (this.c472 == 2) {
               var2.c7698(var2.posX(), var2.boundingBox().minY() - (9.6918752349782E-13 + this.c3828), var2.posZ(), var2.rotationYaw(), var2.rotationPitch());
               this.c472 = 0;
            }
         } else if (this.c8787.getValue() == this.normal) {
            double var6 = Minecraft.gameSettings().c6247().c5354() ? this.vertical.getValue() : (Minecraft.gameSettings().c4298().c5354() ? -this.vertical.getValue() : 0.0);
            event.setY(var6);
            var2.motionY(var6);
            var2.c7698(var2.posX(), var2.boundingBox().minY(), var2.posZ(), var2.rotationYaw(), var2.rotationPitch());
            this.c5730(event, Math.max(this.speed.getValue(), this.c3973()));
         }

      }
   }

   public double c3973() {
      double var1 = 0.2873;
      if (Minecraft.thePlayer().isPotionActive(Potion.moveSpeed())) {
         int var3 = Minecraft.thePlayer().getActivePotionEffect(Potion.moveSpeed()).getAmplifier();
         var1 *= 1.0 + 0.2 * (double)(var3 + 1);
      }

      return var1;
   }

   public void c5730(EventMove var1, double var2) {
      EntityPlayerSP var4 = Minecraft.thePlayer();
      double var5 = var4.movementInput().moveForward();
      double var7 = var4.movementInput().moveStrafe();
      float var9 = var4.rotationYaw();
      if (var5 == 0.0 && var7 == 0.0) {
         var1.setX(0.0).setZ(0.0);
      } else {
         if (var5 != 0.0) {
            if (var7 > 0.0) {
               var9 += (float)(var5 > 0.0 ? -45 : 45);
            } else if (var7 < 0.0) {
               var9 += (float)(var5 > 0.0 ? 45 : -45);
            }

            var7 = 0.0;
            if (var5 > 0.0) {
               var5 = 1.0;
            } else if (var5 < 0.0) {
               var5 = -1.0;
            }
         }

         var1.setX(var5 * var2 * Math.cos(Math.toRadians(var9 + 90.0F)) + var7 * var2 * Math.sin(Math.toRadians(var9 + 90.0F)));
         var1.setZ(var5 * var2 * Math.sin(Math.toRadians(var9 + 90.0F)) - var7 * var2 * Math.cos(Math.toRadians(var9 + 90.0F)));
      }

   }

   public double c7020(double var1, double var3) {
      return Math.random() * (var1 - var3) + var3;
   }
}
