package gg.vape.module.combat;

import gg.vape.Vape;
import gg.vape.event.impl.EventRenderTick;
import gg.vape.friend.Friend;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.none.ClientSettings;
import gg.vape.unmap.ItemLimitData;
import gg.vape.utils.MathUtil;
import gg.vape.utils.RotationUtil;
import gg.vape.value.BooleanValue;
import gg.vape.value.LimitValue;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.*;

import java.util.Iterator;
import java.util.Random;

public class AimAssist extends Mod {
   public float c1145 = 0.0F;
   public float c5635 = 0.0F;
   public boolean c877;
   public int c5111;
   public int c1016;
   public float c6993;
   public float c5080;
   public float c5423;
   public float c930;
   public boolean c5572;
   public boolean c3181;
   public double c508;
   public double c1852;
   public double c6146;
   public double c8328;
   public double c4232;
   public int c6166;
   public int c8435;
   public final int c6359 = 0;
   public final BooleanValue c5895 = BooleanValue.create(this, "Click Aim", true, "Only aim while mouse is down");
   public final BooleanValue c7232 = BooleanValue.create(this, "Aim Vertically", false, "Aims up and down as well");
   public final BooleanValue c4165 = BooleanValue.create(this, "Invisibles", false, "Aim at invisible entities");
   public final BooleanValue c721 = BooleanValue.create(this, "Through Blocks", false, "Aim through blocks at entities");
   public final BooleanValue c6563 = BooleanValue.create(this, "Aim while on target", true, "Continue to adjust aim while hovering over target");
   public final BooleanValue c1726 = BooleanValue.create(this, "Strafe increase", false, "Increase speed whiling strafing away from target");
   public final BooleanValue c8180 = BooleanValue.create(this, "Check block break", false, "Prevents from aiming while breaking blocks");
   public final BooleanValue c4037 = BooleanValue.create(this, "Limit to items", false, "AimAssist functions only while holding selected items");
   public final LimitValue c6649;
   public final NumberValue c6242;
   public final NumberValue c22;
   public final NumberValue c2970;
   public final NumberValue c650;
   public boolean c5031;
   public float c2198;
   public float c1027;
   public float c291;
   public float c7546;
   public int c5793;
   public int c149;
   public double c6715;
   public boolean c8690;
   public Entity c4040;
   public final Random c3066;
   public final Random c2953;
   public int c2919;
   public int c1408;
   int c4675;

   public AimAssist() {
      super("AimAssist", -327674, Category.Combat, "Smoothly aims to closest valid target");
      this.c6649 = LimitValue.create(this, "aimassist-alloweditems", "Allowed Items", LimitValue.allowed, new ItemLimitData("swords"));
      this.c6242 = NumberValue.create(this, "Vertical Speed", "#.#", "", 1.0, 5.0, 10.0);
      this.c22 = NumberValue.create(this, "Horizontal Speed", "#.#", "", 1.0, 5.0, 10.0);
      this.c2970 = NumberValue.create(this, "Max Angle", "#", "", 1.0, 180.0, 360.0, 1.0, "Maximum allowed angle to still aim at target");
      this.c650 = NumberValue.create(this, "Distance", "#.#", "", 1.0, 5.0, 8.0, 0.1, "Maximum distance allowed to still aim at target");
      this.c4040 = null;
      this.c3066 = new Random();
      this.c2953 = new Random();
      this.c4675 = 0;
      this.c7232.limitValues(this.c6242);
      this.c4037.limitValues(this.c6649);
      this.addValue(this.c5895, this.c4165, this.c721, this.c6563, this.c1726, this.c8180, this.c7232, this.c6242, this.c22, this.c2970, this.c650, this.c4037, this.c6649);
   }

   public void c3934() {
      if (!Minecraft.theWorld().isNull() && !Minecraft.thePlayer().isNull()) {
         if (!this.c3166()) {
            this.c8116();
         } else if (this.c5895.getValue() && !ClientSettings.isMouseDown()) {
            this.c4040 = null;
            this.c8116();
         } else {
            if (this.c4040 != null && (RotationUtil.c5613(this.c4040) || (double) Minecraft.thePlayer().getDistanceToEntity(this.c4040) > this.c650.getValue())) {
               this.c8116();
               this.c4040 = null;
            }

            if (this.c5895.getValue() && ClientSettings.isMouseDown() && this.c4040 == null || !this.c5895.getValue()) {
               EntityLivingBase var1 = this.c6713();
               if (!this.c5895.getValue()) {
                  ++this.c149;
                  if (this.c149 > 700 || this.c4040 == null) {
                     this.c4040 = var1;
                     this.c149 = 0;
                  }
               } else {
                  this.c4040 = var1;
               }
            }

            if (Minecraft.theWorld().getObject() != null) {
               if (this.c4040 != null && Minecraft.currentScreen().getObject() == null) {
                  this.c7363(this.c8690);
                  this.c2272();
               } else {
                  this.c8116();
               }

            }
         }
      }
   }

   void c7363(boolean var1) {
      ++this.c5793;
      if (this.c5793 > 10) {
         this.c1027 = this.c2198;
         this.c7546 = this.c291;
         this.c291 = 0.0F;
         this.c2198 = 0.0F;
         this.c5793 = 0;
      }

   }

   public void c8116() {
      this.c6993 = 0.0F;
      this.c5080 = 0.0F;
      this.c2919 = 0;
      this.c1408 = 0;
      this.c5111 = 0;
      this.c1016 = 0;
      this.c5423 = 0.0F;
   }

   void c51(float var1) {
      if (var1 != 0.0F) {
         var1 *= 5.0F;
         float var2 = this.c6242.getValue().floatValue();
         float var3 = (float) RotationUtil.c7991(Minecraft.thePlayer(), this.c4040);
         if (var3 <= 10.0F) {
            this.c5635 = var2;
         }

         if (this.c5635 > 0.0F) {
            var2 -= this.c5635 / 3.0F;
            this.c5635 -= var3 / 200.0F;
         }

         float var4 = 1.0F * var2 * var1;
         this.c5080 += var4;
      } else {
         this.c5080 = 0.0F;
      }

   }

   void c1920(float var1) {
      if (var1 != 0.0F) {
         var1 *= 5.0F;
         float var2 = this.c22.getValue().floatValue();
         float var3 = (float) RotationUtil.getAngleToEntity(Minecraft.thePlayer(), this.c4040);
         if (var3 <= 10.0F) {
            this.c1145 = var2;
         }

         if (this.c1145 > 0.0F) {
            var2 -= this.c1145 / 3.0F;
            this.c1145 -= var3 / 200.0F;
         }

         float var4 = 1.0F * var2 * var1;
         this.c6993 += var4;
      } else {
         this.c6993 = 0.0F;
      }

   }

   public void onRenderTick(EventRenderTick event) {
      if (!Minecraft.theWorld().isNull()) {
         float var2 = Minecraft.gameSettings().c6231();
         this.c6993 += (float)this.c5111;
         this.c5080 += (float)this.c1016;
         int var3 = (int)this.c6993;
         int var4 = (int)(-this.c5080);
         float var5 = var2 * 0.6F + 0.2F;
         float var6 = var5 * var5 * var5 * 8.0F;
         float var7 = (float)var3 * var6;
         float var8 = (float)var4 * var6;
         this.c3735(var7, var8);
         this.c6993 = 0.0F;
         this.c5080 = 0.0F;
         this.c5111 = 0;
         this.c1016 = 0;
      }
   }

   public void c2272() {
      this.c3684();
      this.c6146 = this.c508;
      this.c8328 = this.c1852;
      this.c508 = this.c4040.c5823();
      this.c1852 = this.c4040.c7002();
      double var1 = this.c4040.posX() - this.c508;
      double var3 = this.c4040.posZ() - this.c1852;
      if (var1 == 0.0 || var3 == 0.0) {
         var1 = this.c4040.posX() - this.c6146;
         var3 = this.c4040.posZ() - this.c8328;
      }

      EntityPlayerSP var5 = Minecraft.thePlayer();
      double var6 = 1.6;
      EntityLivingBase var8 = RotationUtil.c7493(this.c650.getValue(), -0.15F);
      this.c877 = false;
      double var9 = RotationUtil.c5542(var5, this.c4040.posX() + var1 * var6, this.c4040.posZ() + var3 * var6);
      int var11 = Math.abs(RotationUtil.c7991(var5, this.c4040)) - 10;
      boolean var12 = RotationUtil.c1548(var5, this.c4040.posX() + var1 * var6, this.c4040.posZ() + var3 * var6);
      float var13 = 1.0F;
      float var14 = 1.0F;
      if (this.c877 && !this.c6563.getValue()) {
         this.c8116();
      } else {
         var13 = (float)((double)var13 + MathUtil.c1009(this.c3066, 0.0, 2.0));
         var13 = (float)((double)var13 + var9 / 50.0);
         if (Math.abs(var9 - this.c4232) > 6.0) {
            var13 = (float)((double)var13 + var9 / 35.0);
         }

         double var15 = (9.0F - var5.getDistanceToEntity(this.c4040)) / 2.5F - 2.0F;
         var15 = Math.max(0.0, var15);
         var13 = (float)((double)var13 + var15);
         if (this.c1726.getValue() && (!var12 && var5.movementInput().moveStrafe() > 0.0F || var12 && var5.movementInput().moveStrafe() < 0.0F)) {
            var13 = (float)((double)var13 * 1.3);
         }

         if (var5.getDistanceToEntity(this.c4040) < 0.5F) {
            var13 /= 5.0F;
         }

         var13 /= 90.0F;
         var14 /= 90.0F;
         float var17 = var12 ? -var13 : var13;
         boolean var18 = RotationUtil.c2525(var5, this.c4040);
         float var19 = var18 ? var14 : -var14;
         if (var9 < 5.0) {
            this.c8435 = 0;
            var17 = 0.0F;
            this.c7546 *= 0.7F;
            if (var12 && var5.movementInput().moveStrafe() > 0.0F || !var12 && var5.movementInput().moveStrafe() < 0.0F) {
               this.c7546 *= 0.5F;
            }

            if (this.c877) {
               var19 = 0.0F;
               this.c1027 = 0.0F;
            }
         } else {
            ++this.c8435;
         }

         if (var12 != this.c5572) {
            this.c7546 = -this.c7546;
            this.c291 = -this.c291;
            this.c6993 = 0.0F;
         }

         if (var18 != this.c3181) {
            this.c1027 = -this.c1027;
            this.c2198 = -this.c2198;
            this.c5080 = 0.0F;
         }

         if (var11 < 5) {
            var19 = 0.0F;
            this.c1027 *= 0.7F;
         }

         this.c291 += var17;
         this.c2198 += var19;
         var17 = this.c7546;
         var19 = this.c1027;
         if (Math.abs(var17) > 10.0F) {
            this.c291 = 0.0F;
            this.c7546 = 0.0F;
         } else {
            float var20 = var17 * 0.15F;
            if (var9 <= 9.0) {
               var20 = (float)((double)var20 / (10.0 - var9));
            }

            this.c8690 = var9 > 5.0;
            if (Float.isNaN(var20)) {
               this.c291 = 0.0F;
               this.c7546 = 0.0F;
            } else {
               this.c1920(var20);
               if (this.c7232.getValue()) {
                  float var21 = (float)((double)var19 * 0.15);
                  if (Float.isNaN(var21)) {
                     this.c2198 = 0.0F;
                     this.c1027 = 0.0F;
                     return;
                  }

                  this.c51(var21);
               }

               this.c3181 = var18;
               this.c5572 = var12;
               ++this.c6166;
               if (this.c6166 > 10) {
                  this.c4232 = var9;
                  this.c6166 = 0;
               }

            }
         }
      }
   }

   public void c3735(float var1, float var2) {
      EntityPlayerSP var3 = Minecraft.thePlayer();
      float var4 = var3.rotationPitch();
      float var5 = var3.rotationYaw();
      var3.c7293((float)((double)var3.rotationYaw() + (double)var1 * 0.15));
      var3.c834((float)((double)var3.rotationPitch() - (double)var2 * 0.15));
      if (var3.rotationPitch() < -90.0F) {
         var3.c834(-90.0F);
      }

      if (var3.rotationPitch() > 90.0F) {
         var3.c834(90.0F);
      }

      var3.c6100(var3.c301() + var3.rotationPitch() - var4);
      var3.c4743(var3.c3825() + var3.rotationYaw() - var5);
   }

   public void c3684() {
      ++this.c6715;
      if (this.c6715 >= (double)(250 + this.c2953.nextInt(50))) {
         this.c6715 = MathUtil.c1673(this.c2953, -100, -50);
         this.c2919 = MathUtil.c1673(this.c2953, -1, 2);
         this.c1408 = MathUtil.c1673(this.c2953, -1, 2);
      }

      int var1 = this.c2919;
      int var2 = this.c1408;
      if (this.c2953.nextInt(10) < 2) {
      }

      if (this.c2953.nextInt(10) < 2) {
      }

      if (this.c2953.nextInt(10) < 2) {
         var1 = 0;
      }

      if (this.c2953.nextInt(10) < 2) {
         var2 = 0;
      }

      if (this.c6715 < 0.0) {
         var1 = 0;
         var2 = 0;
      }

      if (this.c2953.nextInt(20) == 1) {
         this.c5111 += var1;
         this.c1016 += var2;
      }

      if (this.c6993 > 0.0F && this.c5111 < 0 || this.c6993 < 0.0F && this.c5111 > 0) {
         this.c5111 = 0;
      }

   }

   public boolean c6450() {
      if (!this.c4037.getValue()) {
         return true;
      } else {
         ItemStack var1 = Minecraft.thePlayer().getHeldItemHand();
         if (var1.isNull()) {
            return false;
         } else {
            Item var2 = var1.getItem();
            return !var2.isNull() && this.c6649.isValid(var1, true);
         }
      }
   }

   public boolean c3166() {
      if (Minecraft.thePlayer().isNull()) {
         return false;
      } else {
         if (this.c8180.getValue()) {
            if (Minecraft.playerController().c7948()) {
               this.c4675 = 250;
               return false;
            }

            if (this.c4675 > 0) {
               --this.c4675;
            }

            if (this.c4675 > 0) {
               return false;
            }
         }

         return this.c6450();
      }
   }

   public EntityLivingBase c6713() {
      EntityLivingBase var1 = null;
      EntityPlayerSP var2 = Minecraft.thePlayer();
      double var3 = 360.0;
      Iterator var5 = Minecraft.theWorld().loadedEntityList().iterator();

      while(true) {
         EntityLivingBase var7;
         Friend var8;
         do {
            do {
               do {
                  Object var6;
                  do {
                     if (!var5.hasNext()) {
                        return var1;
                     }

                     var6 = var5.next();
                  } while(!Vape.instance.getSettings().isTarget(new Entity(var6), !this.c4165.getValue()));

                  var7 = new EntityLivingBase(var6);
               } while((double)var2.getDistanceToEntity(var7) > this.c650.getValue());
            } while(!var2.canEntityBeSeen(var7) && !this.c721.getValue());

            var8 = Vape.instance.getFriendManager().getFriend(var7.getName());
         } while(var8 != null && !var8.inFriends());

         double var9 = RotationUtil.getAngleToEntity(var2, var7);
         if (var9 < var3 && var9 <= this.c2970.getValue() / 2.0) {
            var3 = var9;
            var1 = var7;
         }
      }
   }

   public Entity c7208() {
      return this.c4040;
   }

   public void onEnable() {
      if (!this.c5031) {
         this.c5031 = true;
         (new c2897(this)).start();
      }

   }
   class c2897 extends Thread {
      // $FF: synthetic field
      final AimAssist c4984;

      c2897(AimAssist var1) {
         this.c4984 = var1;
      }

      public void run() {
         while(!Vape.instance.isDestroyed()) {
            try {
               Thread.sleep(1L);
               if (this.c4984.getState()) {
                  AimAssist.c3028(this.c4984);
               }
            } catch (Exception var2) {
            }
         }

      }
   }
   // $FF: synthetic method
   static void c3028(AimAssist var0) {
      var0.c3934();
   }
}
