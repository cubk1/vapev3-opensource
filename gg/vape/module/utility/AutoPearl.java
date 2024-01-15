package gg.vape.module.utility;

import gg.vape.event.impl.EventLivingUpdate;
import gg.vape.event.impl.EventPlayerTick;
import gg.vape.event.impl.EventRenderTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.render.proj.IProjectile;
import gg.vape.module.render.proj.Projectile;
import gg.vape.unmap.ModeSelection;
import gg.vape.utils.MathUtil;
import gg.vape.utils.TimerUtil;
import gg.vape.utils.Vec3d;
import gg.vape.value.BooleanValue;
import gg.vape.value.ModeValue;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AutoPearl extends Mod {
   public boolean c8277;
   public boolean c6044;
   public boolean c5351;
   public final ModeSelection c3143 = new ModeSelection("On bind");
   public final ModeSelection c8344 = new ModeSelection("Aggro");
   public final ModeValue c4976;
   public final NumberValue c5985;
   public final NumberValue c3740;
   public final NumberValue c6284;
   public final NumberValue c4698;
   public final BooleanValue c7178;
   public final BooleanValue c7635;
   public EntityThrowable c531;
   public int c2204;
   public boolean c2188;
   public float c8933;
   public float c5418;
   public final TimerUtil c5713;
   public final Projectile c6406;

   public AutoPearl() {
      super("AutoPearl", -16711936, Category.Utility, "Aims and throws a pearl at an enemies pearl trajectory.");
      this.c4976 = ModeValue.create(this, "Mode", "On bind - searches for thrown pearls and throws upon pressing bind\nAggro - Throws pearl as soon as enemy throws theirs", this.c3143, this.c3143, this.c8344);
      this.c5985 = NumberValue.create(this, "Angle Limit", "#", "", 30.0, 180.0, 360.0, 5.0);
      this.c3740 = NumberValue.create(this, "Distance Limit", "#.#", "m", 0.0, 6.0, 10.0, 0.1, "The minimum distance a pearl needs to land away from you\nin order to pearl towards it.");
      this.c6284 = NumberValue.create(this, "Horizontal Speed", "#.#", "", 0.1, 5.0, 15.0, 0.5);
      this.c4698 = NumberValue.create(this, "Vertical Speed", "#.#", "", 0.1, 5.0, 15.0, 0.5);
      this.c7178 = BooleanValue.create(this, "Silent Throw", false, "Throws the enderpearl without swapping your hand.");
      this.c7635 = BooleanValue.create(this, "Vertical Check", false, "Checks if the pearl landing positions Y is higher a certain amount above you.");
      this.c5713 = new TimerUtil();
      this.c6406 = new Projectile(Collections.singleton(MappedClasses.EntityEnderPearl), Color.WHITE);
      this.addValue(this.c4976, this.c6284, this.c4698, this.c5985, this.c3740, this.c7635, this.c7178);
   }

   public void onEnable() {
      EntityPlayerSP var1 = Minecraft.thePlayer();
      if (var1.isNotNull()) {
         this.c8933 = var1.rotationYaw();
         this.c5418 = var1.rotationPitch();
      }

      if (this.c8277 && this.c4976.getValue().equals(this.c3143)) {
         this.setState(false);
      } else {
         if (!this.c4951() && !this.c4976.getValue().equals(this.c8344)) {
            this.setState(false);
         } else {
            this.c8277 = true;
         }

      }
   }

   public void onDisable() {
      this.c8277 = false;
   }

   public void c6336(InventoryPlayer var1, EntityPlayerSP var2, int var3) {
      var1.c33(var3);
      if (this.c7178.getValue()) {
         var2.sendQueue().addToSendQueue(S09PacketHeldItemChange.c134(var3));
         Minecraft.playerController().c7235();
      }

   }

   public IProjectile c3818(EntityThrowable var1) {
      if (var1.onGround()) {
         return null;
      } else {
         Iterator var2 = this.c8801().iterator();

         IProjectile var3;
         do {
            if (!var2.hasNext()) {
               return null;
            }

            var3 = (IProjectile)var2.next();
         } while(!var3.c2764(var1));

         return var3;
      }
   }

   public List c8801() {
      ArrayList var1 = new ArrayList();
      var1.add(this.c6406);
      return var1;
   }

   public Vec3 c6418(EntityThrowable var1) {
      if (!var1.isInstance(MappedClasses.IProjectile)) {
         return null;
      } else {
         WorldClient var2 = Minecraft.theWorld();
         double var3 = var1.posX();
         double var5 = var1.posY();
         double var7 = var1.posZ();
         double var9 = var1.c6344();
         double var11 = var1.motionY();
         double var13 = var1.c612();

         while(true) {
            Vec3 var16 = Vec3.create(var3, var5, var7);
            Vec3 var17 = Vec3.create(var3 + var9, var5 + var11, var7 + var13);
            RayTraceResult var15 = var2.c3811(var16, var17, false, var1.isInstance(MappedClasses.EntityArrow), false);
            var3 += var9;
            var5 += var11;
            var7 += var13;
            if (var15.isNotNull()) {
               var3 = var15.c1518().getX();
               var5 = var15.c1518().getY();
               var7 = var15.c1518().getZ();
               EntityPlayerSP var18 = Minecraft.thePlayer();
               return !((double)Math.abs(this.c7296(var3, var7)) <= this.c5985.getValue() / 2.0) || !(var18.c7689(var3, var5, var7) > this.c3740.getValue()) || this.c7635.getValue() && !(var5 - var18.posY() < 7.0) ? null : Vec3.create(var3, var5, var7);
            }

            if (var5 < -128.0) {
               return null;
            }

            var9 *= var1.isInWater() ? 0.8 : 0.99;
            var11 *= var1.isInWater() ? 0.8 : 0.99;
            var13 *= var1.isInWater() ? 0.8 : 0.99;
            var11 -= 0.05;
         }
      }
   }

   public float c7296(double var1, double var3) {
      EntityPlayerSP var5 = Minecraft.thePlayer();
      double var6 = var1 - var5.posX();
      double var8 = var3 - var5.posZ();
      double var10;
      if (var8 < 0.0 && var6 < 0.0) {
         var10 = 90.0 + Math.toDegrees(Math.atan(var8 / var6));
      } else if (var8 < 0.0 && var6 > 0.0) {
         var10 = -90.0 + Math.toDegrees(Math.atan(var8 / var6));
      } else {
         var10 = Math.toDegrees(-Math.atan(var6 / var8));
      }

      return MathUtil.wrapAngleTo180(-(var5.rotationYaw() - (float)var10));
   }

   public void onJoinWorld(EntityJoinWorldEvent event) {
      if (this.c4976.getValue().equals(this.c8344)) {
         Entity var2 = event.c4451();
         EntityPlayerSP var3 = Minecraft.thePlayer();
         if (var2.isInstance(MappedClasses.IProjectile)) {
            EntityEnderPearl var4 = new EntityEnderPearl(var2.getObject());
            EntityThrowable var5 = new EntityThrowable(var2.getObject());
            IProjectile var6 = this.c3818(var4);
            if (var6 != null) {
               EntityOtherPlayerMP var7 = this.c552();
               if (var7 == null || var7.isNull()) {
                  return;
               }

               float var8 = var3.getDistanceToEntity(var5);
               float var9 = var7.getDistanceToEntity(var5);
               if (var9 < var8) {
                  Vec3d var10 = new Vec3d(var5.posX(), var5.posY(), var2.posZ());
                  float var11 = c8446(var10, 1.5);
                  if (!Float.isNaN(var11)) {
                     this.c531 = var5;
                     this.c5713.reset();
                  }
               }
            }
         }

      }
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

   public EntityOtherPlayerMP c552() {
      float var1 = 999.0F;
      int var2 = 0;
      WorldClient var3 = Minecraft.theWorld();
      EntityPlayerSP var4 = Minecraft.thePlayer();
      Iterator var5 = var3.c4424().iterator();

      while(var5.hasNext()) {
         Object var6 = var5.next();
         Entity var7 = new Entity(var6);
         if (!var7.equals(var4) && var7.isInstance(MappedClasses.EntityOtherPlayerMP)) {
            float var8 = var4.getDistanceToEntity(var7);
            if (var8 < var1) {
               var2 = var7.getEntityID();
               var1 = var8;
            }
         }
      }

      if (var2 == 0) {
         return null;
      } else {
         return new EntityOtherPlayerMP(var3.c7325(var2));
      }
   }

   public void onTick(EventPlayerTick event) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      if (this.c5351) {
         for(int var3 = 36; var3 < 45; ++var3) {
            if (var2.c7368().c8687(var3).c5354()) {
               Item var4 = var2.c7368().c8687(var3).c4981().getItem();
               if (var4.isInstance(MappedClasses.ItemEnderPearl)) {
                  InventoryPlayer var5 = var2.c89();
                  this.c2204 = var5.c1744();
                  if (var5.c1744() != var3 - 36) {
                     this.c6336(var5, var2, var3 - 36);
                  }

                  if (Minecraft.playerController().sendUseItem(var2, var2.getWorld(), var2.c7368().c8687(var3).c4981())) {
                     if (this.c4976.getValue().equals(this.c3143)) {
                        if (this.c7178.getValue()) {
                           this.c6336(var5, var2, this.c2204);
                        }

                        this.setState(false);
                     } else {
                        this.c2188 = true;
                     }

                     this.c531 = null;
                     this.c6044 = false;
                     this.c5351 = false;
                     return;
                  }
               }
            }
         }

      }
   }

   public void onRenderTick(EventRenderTick event) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      if (!var2.isNull()) {
         if (this.c5713.hasTimeElapsed(1000L) && this.c531 != null) {
            this.c531 = null;
         }

         if (this.c2188) {
            InventoryPlayer var3 = var2.c89();
            this.c6336(var3, var2, this.c2204);
            this.c2188 = false;
            this.c531 = null;
         }

         WorldClient var11 = Minecraft.theWorld();
         Vec3 var4 = null;
         if (this.c4976.getValue().equals(this.c8344)) {
            if (this.c531 != null) {
               if (!this.c4951()) {
                  this.c531 = null;
                  return;
               }

               var4 = this.c6418(this.c531);
            }
         } else {
            Iterator var5 = var11.c4424().iterator();

            while(var5.hasNext()) {
               Object var6 = var5.next();
               Entity var7 = new Entity(var6);
               if (var7.isInstance(MappedClasses.IProjectile)) {
                  EntityEnderPearl var8 = new EntityEnderPearl(var7.getObject());
                  EntityThrowable var9 = new EntityThrowable(var7.getObject());
                  IProjectile var10 = this.c3818(var8);
                  if (var10 != null) {
                     var4 = this.c6418(var9);
                  }
               }
            }
         }

         if (var4 != null && var4.isNotNull()) {
            float var12 = this.c7296(var4.getX(), var4.getZ());
            if (var12 > this.c6284.getValue().floatValue()) {
               var12 = this.c6284.getValue().floatValue();
            } else if (var12 < -this.c6284.getValue().floatValue()) {
               var12 = -this.c6284.getValue().floatValue();
            }

            float var13 = this.c8933 + var12;
            float var14 = -(this.c5418 - c8446(var4.c1167(), 1.5));
            if (var14 > this.c4698.getValue().floatValue()) {
               var14 = this.c4698.getValue().floatValue();
            } else if (var14 < -this.c4698.getValue().floatValue()) {
               var14 = -this.c4698.getValue().floatValue();
            }

            float var15 = this.c5418 + var14;
            var2.c7293(this.c8933 = var13);
            if (!Float.isNaN(var15)) {
               var2.c834(this.c5418 = var15);
            }

            if (!this.c6044) {
               this.c6044 = (double)Math.abs(this.c7296(var4.getX(), var4.getZ())) < 0.5 && (double)Math.abs(var14) < 0.5;
               return;
            }

            if (!this.c5351) {
               return;
            }
         } else {
            this.c8933 = var2.rotationYaw();
            this.c5418 = var2.rotationPitch();
         }

         if (this.c4976.getValue().equals(this.c3143)) {
            this.setState(false);
         }

      }
   }

   public void onUpdate(EventLivingUpdate event) {
      if (this.c6044 && !this.c5351) {
         this.c5351 = true;
      }

   }

   public boolean c4951() {
      EntityPlayerSP var1 = Minecraft.thePlayer();

      for(int var2 = 36; var2 < 45; ++var2) {
         if (var1.c7368().c8687(var2).c5354()) {
            Item var3 = var1.c7368().c8687(var2).c4981().getItem();
            if (var3.isInstance(MappedClasses.ItemEnderPearl)) {
               return true;
            }
         }
      }

      return false;
   }
}
