package gg.vape.module.combat;

import gg.vape.event.impl.EventRenderTick;
import gg.vape.event.impl.EventTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.value.BooleanValue;
import gg.vape.value.RandomValue;
import gg.vape.wrapper.impl.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Reach extends Mod {
   public final RandomValue c7799 = RandomValue.create(this, "Range", "#.#", "blocks", 3.0, 3.0, 3.4, 6.0);
   public final BooleanValue c1825 = BooleanValue.create(this, "Misplace", false, "Pulls players towards you rather than giving you extra reach distance. Uses the minimum slider value.");
   public final BooleanValue c4834 = BooleanValue.create(this, "Disadvantage", false, "Moves misplaced players in opposite direction. Useful for framing other players");
   public final BooleanValue c1509 = BooleanValue.create(this, "Vertical Check", false, "Prevents hitting players which are y0.2 above or below you\nfor more legitimate use");
   public final BooleanValue c8405 = BooleanValue.create(this, "Only while sprinting", false, "Only give extra reach while sprinting");
   public final BooleanValue c5580 = BooleanValue.create(this, "Disable in water", false, "Won't give any extra reach while standing in water");
   public final Map c7999 = new HashMap();

   public Reach() {
      super("Reach", -16711936, Category.Combat, "Extends attack reach");
      this.c1825.limitValues(this.c4834);
      this.addValue(this.c7799, this.c1825, this.c4834, this.c1509, this.c8405, this.c5580);
   }

   public double c3973() {
      if (this.getState() && !this.c1825.checkValue() && (!this.c5580.getValue() || !Minecraft.thePlayer().isInWater())) {
         return this.c8405.getValue() && !Minecraft.thePlayer().isSprinting() ? 3.0 : this.c7799.c7470();
      } else {
         return 3.0;
      }
   }

   public float c7587(double var1, double var3, double var5, double var7) {
      double var9 = var5 - var1;
      double var11 = var7 - var3;
      float var13 = (float)Math.toDegrees(-Math.atan(var9 / var11));
      if (var11 < 0.0 && var9 < 0.0) {
         var13 = (float)(90.0 + Math.toDegrees(Math.atan(var11 / var9)));
      } else if (var11 < 0.0 && var9 > 0.0) {
         var13 = (float)(-90.0 + Math.toDegrees(Math.atan(var11 / var9)));
      }

      return var13;
   }

   public void c7363(boolean var1) {
      WorldClient var2 = Minecraft.theWorld();
      if (!var2.isNull()) {
         Iterator var3 = var2.loadedEntityList().iterator();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            Entity var5 = new Entity(var4);
            if (var5.isInstance(MappedClasses.EntityOtherPlayerMP)) {
               EntityOtherPlayerMP var6 = new EntityOtherPlayerMP(var4);
               int var7 = var5.getEntityID();
               double var8 = var5.posX();
               double var10 = var5.posZ();
               c458 var12 = null;
               if (this.c7999.containsKey(var7)) {
                  var12 = (c458)this.c7999.get(var7);
               } else {
                  var12 = new c458();
                  var12.c8319 = var7;
               }

               this.c7999.put(var7, var12);
               var12.c6717 = var8;
               var12.c272 = var10;
               var12.c469 = var5.c5823();
               var12.c3526 = var5.c7002();
               var12.c4721 = var6.c6049();
               var12.c1435 = var6.c6015();
               var12.c8629 = var6.c3475();
               var12.c3245 = var6.c3205();
               if (var1) {
                  var6.c7148(var12.c2812);
                  var6.c8899(var12.c2192);
                  var6.c4745(var12.c4181);
                  var6.c8766(var12.c7229);
                  var6.c8320(var12.c4363);
                  var6.c3078(var12.c6341);
                  var6.c8308(var5.posX(), var5.posY(), var5.posZ());
               } else {
                  var6.c7148(var12.c2812);
                  var6.c8899(var12.c2192);
                  var6.c8308(var5.posX(), var5.posY(), var5.posZ());
                  var6.c7148(var12.c6717);
                  var6.c8899(var12.c272);
               }
            }
         }

      }
   }

   public void c3934() {
      WorldClient var1 = Minecraft.theWorld();
      EntityPlayerSP var2 = Minecraft.thePlayer();
      if (!var1.isNull()) {
         float var3 = this.c4834.getValue() ? -90.0F : 90.0F;
         Iterator var4 = var1.loadedEntityList().iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            Entity var6 = new Entity(var5);
            if (var6.isInstance(MappedClasses.EntityOtherPlayerMP)) {
               EntityOtherPlayerMP var7 = new EntityOtherPlayerMP(var5);
               double var8 = this.c7799.c6465() - 3.0;
               double var10 = Math.hypot(var2.posX() - var6.posX(), var2.posZ() - var6.posZ());
               float var12 = this.c7587(var2.posX(), var2.posZ(), var6.posX(), var6.posZ());
               double var13 = var10 - var8;
               double var15;
               if (var13 < 0.5) {
                  var15 = var13 - 0.5;
                  var8 += var15;
                  if (var8 < 0.0) {
                     var8 = 0.0;
                  }
               }

               var15 = Math.cos(Math.toRadians(var12 + var3)) * var8;
               double var17 = Math.sin(Math.toRadians(var12 + var3)) * var8;
               int var19 = var6.getEntityID();
               double var20 = var6.posX();
               double var22 = var6.posZ();
               c458 var24 = null;
               boolean var25 = false;
               if (this.c7999.containsKey(var19)) {
                  var24 = (c458)this.c7999.get(var19);
                  var25 = true;
               } else {
                  var24 = new c458();
                  var24.c8319 = var19;
               }

               this.c7999.put(var19, var24);
               var24.c6717 = var20;
               var24.c272 = var22;
               var24.c469 = var6.c5823();
               var24.c3526 = var6.c7002();
               var24.c4721 = var7.c6049();
               var24.c1435 = var7.c6015();
               var24.c8629 = var7.c3475();
               var24.c3245 = var7.c3205();
               var24.c2812 = var24.c6717 - var15;
               var24.c2192 = var24.c272 - var17;
               var24.c4181 = var24.c469 - var15;
               var24.c7229 = var24.c3526 - var17;
               var24.c4363 = var24.c4721 - var15;
               var24.c6341 = var24.c1435 - var17;
               if (var25) {
                  var24.c4181 = var24.c3222;
                  var24.c7229 = var24.c5182;
               }
            }
         }

      }
   }

   public void c2272() {
      float var1 = this.c4834.getValue() ? -90.0F : 90.0F;
      double var2 = this.c7799.c6465() - 3.0;
      EffectRenderer var4 = Minecraft.c6818();
      if (!var4.isNull()) {
         try {
            List[][] var5 = var4.c1763();
            List[][] var6 = var5;
            int var7 = var5.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               List[] var9 = var6[var8];
               List[] var10 = var9;
               int var11 = var9.length;

               label54:
               for(int var12 = 0; var12 < var11; ++var12) {
                  List var13 = var10[var12];
                  Iterator var14 = var13.iterator();

                  while(true) {
                     EntityFX var15;
                     do {
                        do {
                           if (!var14.hasNext()) {
                              continue label54;
                           }

                           var15 = (EntityFX)var14.next();
                        } while(var15.isNull());
                     } while(!var15.isInstance(MappedClasses.EntityCrit2FX) && !var15.isInstance(MappedClasses.EntityCritFX));

                     EntityPlayerSP var16 = Minecraft.thePlayer();
                     if (!var16.isNull()) {
                        float var17 = this.c7587(var16.posX(), var16.posZ(), var15.posX(), var15.posZ());
                        double var18 = Math.cos(Math.toRadians(var17 + var1)) * var2;
                        double var20 = Math.sin(Math.toRadians(var17 + var1)) * var2;
                        var15.c7148(var15.posX() - var18);
                        var15.c8899(var15.posZ() - var20);
                        var15.c4745(var15.c5823() - var18);
                        var15.c8766(var15.c7002() - var20);
                     }
                  }
               }
            }
         } catch (Exception var22) {
         }

      }
   }

   public void c4983(boolean var1) {
      WorldClient var2 = Minecraft.theWorld();
      if (!var2.isNull()) {
         Iterator var3 = this.c7999.entrySet().iterator();

         while(var3.hasNext()) {
            Map.Entry var4 = (Map.Entry)var3.next();
            c458 var5 = (c458)var4.getValue();
            Entity var6 = new Entity(var2.c7325(var5.c8319));
            if (var6.isNotNull() && var6.isInstance(MappedClasses.EntityOtherPlayerMP)) {
               EntityOtherPlayerMP var7 = new EntityOtherPlayerMP(var2.c7325(var5.c8319));
               if (var1) {
                  var5.c3222 = var5.c2812;
                  var5.c5182 = var5.c2192;
                  var7.c7148(var5.c6717);
                  var7.c8899(var5.c272);
                  var7.c4745(var5.c469);
                  var7.c8766(var5.c3526);
                  var7.c8320(var5.c4721);
                  var7.c3078(var5.c1435);
               }

               var7.c8308(var7.posX(), var7.posY(), var7.posZ());
            }
         }

      }
   }

   public void onTick(EventTick event) {
      if (this.c1825.getValue()) {
         this.c3934();
         if (event.getType() == EventType.PRE) {
            this.c7363(false);
         } else {
            this.c4983(false);
            if (ForgeVersion.minorVersion() <= 15) {
               this.c2272();
            }
         }

      }
   }

   public void onRenderTick(EventRenderTick event) {
      if (this.c1825.getValue()) {
         this.c7363(true);
      }
   }

   public void onPostRenderTick(EventRenderTick event) {
      if (this.c1825.getValue()) {
         this.c4983(true);
      }
   }

   public void onDisable() {
      this.c7999.clear();
   }

   public BooleanValue c6232() {
      return this.c1825;
   }

   public boolean c3177(Entity var1) {
      if (!this.getState()) {
         return true;
      } else {
         EntityPlayerSP var2 = Minecraft.thePlayer();
         double var3 = var2.posY() - (var1.posY() + (double)var1.getEyeHeight());
         return !this.c1509.getValue() || !(var3 >= 0.2) && !(var3 <= -0.2);
      }
   }
}
class c458 {
   int c8319;
   double c6717;
   double c272;
   double c469;
   double c3526;
   double c2812;
   double c2192;
   double c4181;
   double c7229;
   double c3222;
   double c5182;
   double c4721;
   double c1435;
   double c4363;
   double c6341;
   double c8629;
   double c3245;
}
