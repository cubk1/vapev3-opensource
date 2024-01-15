package gg.vape.module.combat;

import gg.vape.event.impl.EventLivingUpdate;
import gg.vape.event.impl.EventPacketReceive;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.unmap.NumberFormat;
import gg.vape.utils.MathUtil;
import gg.vape.utils.RotationUtil;
import gg.vape.value.BooleanValue;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.*;
import pub.nextsense.Tweaker;

import java.util.Random;

public class Velocity extends Mod {
   public final BooleanValue simple = BooleanValue.create(this, "Simple Mode", false, "Cancel all knockbacks.");
   public final BooleanValue targeting = BooleanValue.create(this, "Only when targeting", false, "Only reduce knockback while being face to face with opponent");
   public final BooleanValue waterCheck = BooleanValue.create(this, "Water check", false, "Won't reduce knockback if in water");
   public final BooleanValue kiteMode = BooleanValue.create(this, "Kite mode", false, "Increases knockback while not facing opponent");
   public final NumberValue horizontal = NumberValue.create(this, "Horizontal", "#", "%", 0.0, 90.0, 100.0);
   public final NumberValue vertical = NumberValue.create(this, "Vertical", "#", "%", 0.0, 100.0, 100.0);
   public final NumberValue chance = NumberValue.create(this, "Chance", "#", "%", 0.0, 90.0, 100.0);
   public final NumberValue kiteHorizontal = NumberValue.create(this, "Kite horizontal", "#", "%", 100.0, 120.0, 300.0);
   public final NumberValue kiteVertical = NumberValue.create(this, "Kite vertical", "#", "%", 100.0, 120.0, 300.0);
   public float c2598 = -999.0F;
   public World c6381;
   public EntityPlayerSP c3099;

   public Velocity() {
      super("Velocity", -65404, Category.Combat, "Reduces knockback taken");
      this.kiteMode.limitValues(this.kiteHorizontal, this.kiteVertical);
      this.addValue(this.simple,this.horizontal, this.vertical, this.chance, this.targeting, this.waterCheck, this.kiteMode, this.kiteHorizontal, this.kiteVertical);
   }

   public boolean canReduce() {
      EntityPlayerSP player = Minecraft.thePlayer();
      if (player.isNull()) {
         return false;
      } else {
         return !this.waterCheck.getValue() || !player.isInWater();
      }
   }

   public void onPacketReceive(EventPacketReceive event) {
      if(simple.getValue()){

         Packet packet = event.getPacket();
         if(packet.isInstance(MappedClasses.SPacketExplosion) || packet.isInstance(MappedClasses.SPacketEntityVelocity)){

            event.setCancelled(true);
            return;
         }
      }



      if (this.canReduce()) {
         try {
            if (event.getPacketInstance() == null) {
               return;
            }

            Packet packet = event.getPacket();
            EntityPlayerSP player;
            boolean var5;
            boolean var6;
            Random random;
            double var8;
            int var10;
            double var11;
            double var13;
            double var15;
            double var17;
            double var19;
            double var21;
            double var23;
            double var25;
            double var27;
            if (packet.isInstance(MappedClasses.SPacketExplosion)) {
               S27PacketExplosion var3 = new S27PacketExplosion(packet);
               player = Minecraft.thePlayer();
               var5 = RotationUtil.c1820(player);
               var6 = RotationUtil.c2049(player);
               if (!var5 && !var6 && !this.kiteMode.getValue() && this.targeting.getValue()) {
                  return;
               }

               random = new Random();
               var8 = random.nextDouble();
               var10 = MathUtil.c1673(random, 0, 100);
               if ((double)var10 > 100.0 - this.chance.getValue()) {
                  var11 = var3.c6767();
                  var13 = var3.c3455();
                  var15 = var3.c8279();
                  if (var5 && !var6 && this.kiteMode.getValue()) {
                     var17 = this.kiteHorizontal.getValue() / 100.0;
                     var19 = this.kiteVertical.getValue() / 100.0;
                     var21 = this.c7020(var11, var17);
                     var23 = this.c7020(var13, var19);
                     var25 = this.c7020(var15, var17);
                     var3.c6025((float)var21);
                     var3.c8528((float)var23);
                     var3.c8393((float)var25);
                     return;
                  }

                  var17 = this.horizontal.getValue();
                  var19 = var17 + (var17 + 5.0 - var17) * var8;
                  if (var19 >= 100.0) {
                     var19 = 100.0;
                  }

                  var21 = this.vertical.getValue();
                  var23 = var21 + (var21 + 5.0 - var21) * var8;
                  if (var23 >= 90.0) {
                     var23 = 100.0;
                  }

                  var25 = var19 / 100.0;
                  var27 = var23 / 100.0;
                  double var29 = this.c7020(var11, var25);
                  double var31 = this.c7020(var13, var27);
                  double var33 = this.c7020(var15, var25);
                  var3.c6025((float)var29);
                  var3.c8528((float)var31);
                  var3.c8393((float)var33);
                  if (var17 == 0.0 && var21 == 0.0) {
                     event.setCancelled(true);
                  }
               }
            }

            if (packet.isInstance(MappedClasses.SPacketEntityVelocity)) {
               S12PacketEntityVelocity S12 = new S12PacketEntityVelocity(packet);
               player = Minecraft.thePlayer();
               if (player.isNull()) {
                  return;
               }


               if (S12.getEntityID() == player.getEntityID()) {
                  var5 = RotationUtil.c1820(player);
                  var6 = RotationUtil.c2049(player);
                  if (!var5 && !var6 && !this.kiteMode.getValue() && this.targeting.getValue()) {
                     return;
                  }

                  random = new Random();
                  var8 = random.nextDouble();
                  var10 = MathUtil.c1673(random, 0, 100);
                  if ((double)var10 > 100.0 - this.chance.getValue()) {
                     var11 = S12.c7544();
                     var13 = S12.c2021();
                     var15 = S12.c341();
                     if (var5 && !var6 && this.kiteMode.getValue()) {
                        var17 = this.kiteHorizontal.getValue() / 100.0;
                        var19 = this.kiteVertical.getValue() / 100.0;
                        int var37 = (int)(var11 * var17);
                        int var22 = (int)(var13 * var19);
                        int var38 = (int)(var15 * var17);
                        S12.c33(var37);
                        S12.c2062(var22);
                        S12.c5732(var38);
                        return;
                     }

                     var17 = this.horizontal.getValue();
                     var19 = var17 + (var17 + 5.0 - var17) * var8;
                     if (var19 >= 100.0) {
                        var19 = 100.0;
                     }

                     var21 = this.vertical.getValue();
                     var23 = var21 + (var21 + 5.0 - var21) * var8;
                     if (var23 >= 90.0) {
                        var23 = 100.0;
                     }

                     var25 = var19 / 100.0;
                     var27 = var23 / 100.0;
                     int var39 = (int)(var11 * var25);
                     int var30 = (int)(var13 * var27);
                     int var40 = (int)(var15 * var25);
                     S12.c33(var39);
                     S12.c2062(var30);
                     S12.c5732(var40);
                     if (var17 == 0.0 && var21 == 0.0) {
                        event.setCancelled(true);
                     }
                  }
               }
            }
         } catch (Exception var35) {
         }

      }
   }

   public void onUpdate(EventLivingUpdate event) {


      if(simple.getValue()){
         this.setSuffix("Simple");
         return;
      }

      this.setSuffix("Basic");
      if (this.canReduce()) {
         if (!Tweaker.isBlatantMode()) {
            if (this.c6381 != null && this.c6381.equals(Minecraft.theWorld())) {
               if (this.c3099 != null && this.c3099.equals(Minecraft.thePlayer())) {
                  EntityPlayerSP var2 = Minecraft.thePlayer();
                  if (event.getEntity().equals(var2)) {
                     boolean var3 = RotationUtil.c1820(var2);
                     boolean var4 = RotationUtil.c2049(var2);
                     float var5 = var2.getHealth();
                     if (this.c2598 != -999.0F && !(var5 > this.c2598)) {
                        if (var5 < this.c2598 && (var2.c6344() != 0.0 || var2.motionY() != 0.0 || var2.c612() != 0.0)) {
                           this.c2598 = var5;
                           if (!var3 && !var4 && !this.kiteMode.getValue() && this.targeting.getValue()) {
                              return;
                           }

                           Random var6 = new Random();
                           double var7 = var6.nextDouble();
                           int var9 = var6.nextInt(100);
                           if ((double)var9 > 100.0 - this.chance.getValue()) {
                              double var10;
                              double var12;
                              if (var3 && !var4 && this.kiteMode.getValue()) {
                                 var10 = this.kiteHorizontal.getValue() / 100.0;
                                 var12 = this.kiteVertical.getValue() / 100.0;
                                 var2.motionX(this.c7020(var2.c6344(), var10));
                                 var2.motionY(this.c7020(var2.motionY(), var12));
                                 var2.motionZ(this.c7020(var2.c612(), var10));
                                 return;
                              }

                              var10 = this.horizontal.getValue();
                              var12 = var10 + (var10 + 5.0 - var10) * var7;
                              if (var12 >= 100.0) {
                                 var12 = 100.0;
                              }

                              double var14 = this.vertical.getValue();
                              double var16 = var14 + (var14 + 5.0 - var14) * var7;
                              if (var16 >= 90.0) {
                                 var16 = 100.0;
                              }

                              double var18 = var12 / 100.0;
                              double var20 = var16 / 100.0;
                              var2.motionX(this.c7020(var2.c6344(), var18));
                              var2.motionY(this.c7020(var2.motionY(), var20));
                              var2.motionZ(this.c7020(var2.c612(), var18));
                              if (var10 <= 1.0) {
                                 var2.motionX(0.0);
                                 var2.motionZ(0.0);
                              }

                              if (var14 <= 1.0) {
                                 var2.motionY(0.0);
                              }
                           }
                        }
                     } else {
                        this.c2598 = var5;
                     }
                  }

               } else {
                  this.c3099 = Minecraft.thePlayer();
                  this.c2598 = -999.0F;
               }
            } else {
               this.c6381 = Minecraft.theWorld();
               this.c2598 = -999.0F;
            }
         }
      }
   }

   public double c7020(double var1, double var3) {
      String var5 = Double.toString(Math.abs(var1));
      String var6 = var5.contains(",") ? "," : ".";
      int var7 = var5.indexOf(var6);
      int var8 = var5.length() - var7 - 1;
      NumberFormat var9 = new NumberFormat(var8);
      return var9.c471(var1 * var3);
   }
}
