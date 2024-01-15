package gg.vape.module.blatant;

import gg.vape.Vape;
import gg.vape.event.impl.EventMotion;
import gg.vape.event.impl.EventMove;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.value.BooleanValue;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.EventType;
import gg.vape.wrapper.impl.GameSettings;
import gg.vape.wrapper.impl.Minecraft;

public class LongJump extends Mod {
   public double c5883;
   public double c6216;
   public boolean c3829;
   public boolean c4077;
   public final NumberValue c1020 = NumberValue.create(this, "Boost", "#.#", "", 3.0, 4.1, 5.0);
   public final BooleanValue c7326 = BooleanValue.create(this, "Toggle", true, "Toggles off after touching the ground.");

   public LongJump() {
      super("LongJump", 16028225, Category.Blatant, "Do a jump that's long.");
      this.addValue(this.c1020, this.c7326);
      this.c5883 = 0.27999999999999997;
      this.c4077 = false;
      this.c6216 = 0.0;
   }

   public void onEnable() {
      Vape.instance.getSettings().speedCheck(this);
      this.c5883 = 0.27999999999999997;
      this.c4077 = false;
      this.c6216 = 0.0;
      this.c3829 = false;
   }

   public void onMove(EventMove event) {
      if (event.isPre()) {
         EntityPlayerSP var2 = Minecraft.thePlayer();
         if ((var2.moveForward() != 0.0F || var2.moveStrafe() != 0.0F) && !var2.getWorld().isNull() && !var2.isInWater()) {
            if (var2.isCollidedVertically()) {
               if (!this.c4077 && !(var2.motionY() < -0.3)) {
                  this.c5883 = this.c1020.getValue() * 0.27999999999999997;
               } else {
                  this.c5883 *= 2.15 - 1.0 / Math.pow(10.0, 5.0);
                  var2.motionY(0.4128938479875198);
                  event.setY(0.4128938479875198);
                  var2.c3224(true);
               }
            } else if (this.c4077) {
               if (this.c6216 < 2.147) {
                  this.c6216 = 2.147;
               }

               this.c5883 = this.c6216 - 0.66 * (this.c6216 - 0.27999999999999997);
            } else {
               this.c5883 = this.c6216 - this.c6216 / 155.0;
            }

            this.c4077 = var2.isCollidedVertically();
            this.c5883 = Math.max(this.c5883, 0.27999999999999997);
            event.setX(-(Math.sin(this.c5444(var2)) * this.c5883));
            event.setZ(Math.cos(this.c5444(var2)) * this.c5883);
         } else {
            this.c5883 = 0.27999999999999997;
         }
      }
   }

   public void onMotionUpdate(EventMotion event) {
      if (event.getType() == EventType.PRE) {
         EntityPlayerSP var2 = Minecraft.thePlayer();
         this.c6216 = Math.hypot(var2.posX() - var2.prevPosX(), var2.posZ() - var2.prevPosZ());
         if (this.c7326.getValue()) {
            if (!this.c4077 && var2.isCollidedVertically() && this.c3829) {
               this.c141();
            }

            if (!this.c3829 && this.c470(var2)) {
               this.c3829 = true;
            }
         }
      }

   }

   public float c5444(EntityPlayerSP var1) {
      float var2 = var1.rotationYaw();
      if (var1.moveForward() < 0.0F) {
         var2 += 180.0F;
      }

      float var3;
      if (var1.moveForward() < 0.0F) {
         var3 = -0.5F;
      } else if (var1.moveForward() > 0.0F) {
         var3 = 0.5F;
      } else {
         var3 = 1.0F;
      }

      if (var1.moveStrafe() > 0.0F) {
         var2 -= 90.0F * var3;
      }

      if (var1.moveStrafe() < 0.0F) {
         var2 += 90.0F * var3;
      }

      var2 *= 0.017453292F;
      return var2;
   }

   public boolean c470(EntityPlayerSP var1) {
      GameSettings var2 = Minecraft.gameSettings();
      return var2.c4590().c5354() || var2.c1091().c5354() || var2.c2387().c5354() || var2.c4599().c5354() || var1.movementInput().moveForward() != 0.0F || var1.movementInput().moveStrafe() != 0.0F;
   }
}
