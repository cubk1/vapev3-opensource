package gg.vape.module.combat;

import com.google.common.collect.Lists;
import gg.vape.Vape;
import gg.vape.event.impl.EventMotion;
import gg.vape.event.impl.EventPlayerTick;
import gg.vape.friend.Friend;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.none.ClientSettings;
import gg.vape.unmap.ModeSelection;
import gg.vape.utils.MathUtil;
import gg.vape.utils.RotationUtil;
import gg.vape.utils.Vec3d;
import gg.vape.value.BooleanValue;
import gg.vape.value.ModeValue;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.Entity;
import gg.vape.wrapper.impl.EntityLivingBase;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.Minecraft;
import pub.nextsense.Tweaker;

import java.awt.*;
import java.util.List;
import java.util.*;

public class BowAimbot extends Mod {
   public final ModeSelection c579 = new ModeSelection("Distance");
   public final ModeSelection c8202 = new ModeSelection("FOV");
   public final ModeValue c3101;
   public final NumberValue c2389;
   public final NumberValue c910;
   public final NumberValue c7764;
   public final BooleanValue c3559;
   public final BooleanValue c4594;
   public float c2344;
   public float c6440;
   public final HashMap c6106;

   public BowAimbot() {
      super("BowAimbot", (new Color(198, 53, 53)).getRGB(), Category.Combat, "Aims at a target with prediction + correction.");
      this.c3101 = ModeValue.create(this, "Sort Target", this.c579, this.c579, this.c8202);
      this.c2389 = NumberValue.create(this, "Max angle", "#", "", 35.0, 90.0, 360.0, 5.0);
      this.c910 = NumberValue.create(this, "Horizontal Speed", "#.#", "", 0.1, 5.0, 15.0, 0.5);
      this.c7764 = NumberValue.create(this, "Vertical Speed", "#.#", "", 0.1, 5.0, 15.0, 0.5);
      this.c3559 = BooleanValue.create(this, "Target invisibles", false);
      this.c4594 = BooleanValue.create(this, "Silent Aim", false, "Aims silently server side\nMay not bypass anti-cheats well");
      this.c6106 = new HashMap();
      this.c4594.setBlatant(true);
      this.addValue(this.c3101, this.c4594, this.c3559, this.c910, this.c7764, this.c2389);
   }

   public void c6445(EventMotion var1) {
      EntityLivingBase var2 = this.c7361();
      EntityPlayerSP var3 = Minecraft.thePlayer();
      if (var2 != null && var2.isNotNull() && var3.isUsingItem() && var3.c6156().isNotNull() && var3.c6156().getItem().isInstance(MappedClasses.ItemBow)) {
         float[] var4 = this.c4510(var2, 1.0F, this.c2344);
         float var5 = var4[0];
         if (var5 > this.c910.getValue().floatValue()) {
            var5 = this.c910.getValue().floatValue();
         } else if (var5 < -this.c910.getValue().floatValue()) {
            var5 = -this.c910.getValue().floatValue();
         }

         float var6 = this.c2344 + var5;
         float var7 = -(this.c6440 - var4[1]);
         if (var7 > this.c7764.getValue().floatValue()) {
            var7 = this.c7764.getValue().floatValue();
         } else if (var7 < -this.c7764.getValue().floatValue()) {
            var7 = -this.c7764.getValue().floatValue();
         }

         float var8 = this.c6440 + var7;
         if (this.c4594.checkValue()) {
            var1.setYaw(this.c2344 = var6);
            if (!Float.isNaN(var8)) {
               var1.setPitch(this.c6440 = var8);
            }
         } else {
            var3.c7293(this.c2344 = var6);
            if (!Float.isNaN(var8)) {
               var3.c834(this.c6440 = var8);
            }
         }
      } else {
         this.c2344 = var3.rotationYaw();
         this.c6440 = var3.rotationPitch();
         this.c6106.clear();
      }

   }

   public void onTick(EventPlayerTick event) {
      if (!Tweaker.isBlatantMode()) {
         this.c6445(null);
      }
   }

   public void onMotionUpdate(EventMotion event) {
      if (event.isPre()) {
         this.c6445(event);
      }

   }

   public float[] c4510(EntityLivingBase var1, float var2, float var3) {
      double var4 = var1.posX() - var1.c5823();
      double var6 = var1.posZ() - var1.c7002();
      double var8 = var1.posY() - var1.c8561();
      EntityPlayerSP var10 = Minecraft.thePlayer();
      if (var4 != 0.0 || var6 != 0.0) {
         if (this.c6106.containsKey(var1.getEntityID())) {
            this.c6106.put(var1.getEntityID(), c238.c5408((c238)this.c6106.get(var1.getEntityID()), var4, var6, var10.ticksExisted()));
         } else {
            this.c6106.put(var1.getEntityID(), new c238(this, var4, var6, null));
         }
      }

      double[] var11 = var4 == 0.0 && var6 == 0.0 ? new double[]{0.0, 0.0} : c238.c7874((c238)this.c6106.get(var1.getEntityID()));
      double var12 = var10.getDistanceToEntity(var1);
      var12 -= var12 % 0.8;
      double var14 = var12 / 0.8 * var11[0] * 0.66;
      double var16 = var12 / 0.8 * var11[1] * 0.66;
      double var18 = 0.0;
      if (!var1.onGround() && !var1.isCollidedVertically() && var8 < 0.0 && var1.c7206() > 1.0F) {
         var14 *= 0.15;
         var16 *= 0.15;
         var18 = var12 / 0.8 * var8 * 0.5;
         var18 += var18 * 0.98 - 0.08;
      }

      double var20 = var1.posX() + var14 - var10.posX();
      double var22 = var1.posZ() + var16 - var10.posZ();
      float var24 = this.c8849(var20, var22, var3);
      float var25 = c8446(new Vec3d(var1.posX() + var14, var1.posY() + (double)var1.getEyeHeight() + var18, var1.posZ() + var16), (double)var2 * 2.93);
      return new float[]{var24, var25};
   }

   public static float c8446(Vec3d var0, double var1) {
      EntityPlayerSP var3 = Minecraft.thePlayer();
      double var4 = 0.05000000074505806;
      double var6 = var0.c8935() - var3.posX();
      double var8 = var0.c4080() - var3.posZ();
      double var10 = Math.sqrt(var6 * var6 + var8 * var8);
      double var12 = var0.c6718() - (var3.posY() + (double)var3.getEyeHeight());
      double var14 = 2.0 * var12 * var1 * var1;
      double var16 = var4 * var10 * var10;
      double var18 = Math.sqrt(var1 * var1 * var1 * var1 - var4 * (var16 + var14));
      double var20 = var1 * var1 + var18;
      double var22 = var1 * var1 - var18;
      double var24 = Math.atan2(var20, var4 * var10);
      double var26 = Math.atan2(var22, var4 * var10);
      return (float)(-Math.toDegrees(Math.min(var24, var26)));
   }

   public float c8849(double var1, double var3, float var5) {
      double var6;
      if (var3 < 0.0 && var1 < 0.0) {
         var6 = 90.0 + Math.toDegrees(Math.atan(var3 / var1));
      } else if (var3 < 0.0 && var1 > 0.0) {
         var6 = -90.0 + Math.toDegrees(Math.atan(var3 / var1));
      } else {
         var6 = Math.toDegrees(-Math.atan(var1 / var3));
      }

      return MathUtil.wrapAngleTo180(-(var5 - (float)var6));
   }

   public EntityLivingBase c7361() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList(Minecraft.theWorld().loadedEntityList());
      Iterator var3 = var2.iterator();

      while(true) {
         Object var4;
         Entity var5;
         do {
            if (!var3.hasNext()) {
               if (var1.isEmpty()) {
                  return null;
               }

               if (this.c3101.getValue() == this.c8202) {
                  var1.sort(new c2878(this, null));
               }

               if (this.c3101.getValue() == this.c579) {
                  var1.sort(new c8684(this, null));
               }

               return (EntityLivingBase)var1.get(0);
            }

            var4 = var3.next();
            var5 = new Entity(var4);
         } while(ClientSettings.not1710 && var5.isInstance(MappedClasses.MouseEvent));

         if (var5.isInstance(MappedClasses.EntityLivingBase)) {
            EntityLivingBase var6 = new EntityLivingBase(var4);
            if (this.c5752(var6)) {
               var1.add(var6);
            }
         }
      }
   }

   class c8684 implements Comparator {
      // $FF: synthetic field
      final BowAimbot c5459;

      public c8684(BowAimbot var1) {
         this.c5459 = var1;
      }

      public int compare(Object var1, Object var2) {
         EntityPlayerSP var3 = Minecraft.thePlayer();
         return Float.compare(var3.getDistanceToEntity((Entity)var1), var3.getDistanceToEntity((Entity)var2));
      }

      // $FF: synthetic method
      c8684(BowAimbot var1, c2852 var2) {
         this(var1);
      }
   }
   class c2878 implements Comparator {
      // $FF: synthetic field
      final BowAimbot c1833;

      public c2878(BowAimbot var1) {
         this.c1833 = var1;
      }

      public int compare(Object var1, Object var2) {
         EntityPlayerSP var3 = Minecraft.thePlayer();
         return Integer.compare(RotationUtil.getAngleToEntity(var3, (Entity)var1), RotationUtil.getAngleToEntity(var3, (Entity)var2));
      }

      // $FF: synthetic method
      c2878(BowAimbot var1, c2852 var2) {
         this(var1);
      }
   }

   public boolean c5752(EntityLivingBase var1) {
      if (var1.isNull()) {
         return false;
      } else if (var1.equals(Minecraft.thePlayer())) {
         return false;
      } else if (!this.c6253(var1)) {
         return false;
      } else if (!(var1.getHealth() <= 0.0F) && !var1.isDead()) {
         if (RotationUtil.getAngleToEntity(Minecraft.thePlayer(), var1) > this.c2389.getValue().intValue() / 2) {
            return false;
         } else {
            Friend var2 = Vape.instance.getFriendManager().getFriend(var1.getName());
            return (var2 == null || var2.inFriends()) && Minecraft.thePlayer().canEntityBeSeen(var1);
         }
      } else {
         return false;
      }
   }

   public boolean c6253(EntityLivingBase var1) {
      return Vape.instance.getSettings().isTarget(var1, !this.c3559.getValue());
   }
}

class c238 {
   public List c3086;
   public int c2382;
   // $FF: synthetic field
   final BowAimbot c2999;

   public c238(BowAimbot var1, double var2, double var4) {
      this.c2999 = var1;
      this.c3086 = new ArrayList();
      this.c3086.add(new double[]{var2, var4});
   }

   public c238 c5453(double var1, double var3, int var5) {
      if (var5 - this.c2382 > 5) {
         this.c3086.clear();
      }

      this.c2382 = var5;
      this.c3086.add(new double[]{var1, var3});
      if (this.c3086.size() > 6) {
         ArrayList var6 = new ArrayList(Lists.reverse(this.c3086));
         this.c3086.clear();

         for(int var7 = 0; var7 < 6 && var7 < var6.size(); ++var7) {
            this.c3086.add(var6.get(var7));
         }

         this.c3086 = Lists.reverse(this.c3086);
      }

      return this;
   }

   public double[] c6583() {
      int var1 = this.c3086.size();
      double var2 = 0.0;
      double var4 = 0.0;

      double[] var7;
      for(Iterator var6 = this.c3086.iterator(); var6.hasNext(); var4 += var7[1]) {
         var7 = (double[])var6.next();
         var2 += var7[0];
      }

      return new double[]{var2 / (double)var1, var4 / (double)var1};
   }

   // $FF: synthetic method
   static c238 c5408(c238 var0, double var1, double var3, int var5) {
      return var0.c5453(var1, var3, var5);
   }

   // $FF: synthetic method
   c238(BowAimbot var1, double var2, double var4, c2852 var6) {
      this(var1, var2, var4);
   }

   // $FF: synthetic method
   static double[] c7874(c238 var0) {
      return var0.c6583();
   }
}
class c2852 {
}