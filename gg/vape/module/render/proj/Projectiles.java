package gg.vape.module.render.proj;

import gg.vape.event.impl.EventRender3D;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.utils.render.RenderUtils;
import gg.vape.value.BooleanValue;
import gg.vape.wrapper.impl.*;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Projectiles extends Mod {
   public final ArrowProjectile c5728 = new ArrowProjectile();
   public final PotionProjectile c287 = new PotionProjectile();
   public final Projectile pearl;
   public final Projectile egg;
   public final Projectile snowball;
   public final RenderManager c8304;
   public final BooleanValue c3324;
   public final BooleanValue c2530;
   public final BooleanValue c1792;
   public final BooleanValue c7852;
   public final BooleanValue c1185;

   public Projectiles() {
      super("Projectiles", -16535661, Category.Render, "Shows projectile trajectories while in air");
      this.pearl = new Projectile(Collections.singleton(MappedClasses.EntityEnderPearl), new Color(173, 12, 255));
      this.egg = new Projectile(Collections.singleton(MappedClasses.EntityEgg), new Color(255, 238, 154));
      this.snowball = new Projectile(Collections.singleton(MappedClasses.EntitySnowball), new Color(255, 255, 255));
      this.c3324 = BooleanValue.create(this, "Show Arrows", true);
      this.c2530 = BooleanValue.create(this, "Show Pearls", true);
      this.c1792 = BooleanValue.create(this, "Show Potions", false);
      this.c7852 = BooleanValue.create(this, "Show Eggs", false);
      this.c1185 = BooleanValue.create(this, "Show Snowballs", false);
      this.c8304 = Minecraft.c5612();
      this.addValue(this.c3324, this.c2530, this.c1792, this.c7852, this.c1185);
   }

   public void onRender3D(EventRender3D event) {
      WorldClient var2 = Minecraft.theWorld();
      Iterator var3 = var2.c4424().iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         Entity var5 = new Entity(var4);
         if (var5.isInstance(MappedClasses.IProjectile)) {
            EntityEnderPearl var6 = new EntityEnderPearl(var5.getObject());
            EntityThrowable var7 = new EntityThrowable(var5.getObject());
            IProjectile var8 = this.c3818(var6);
            if (var8 != null) {
               this.c8595(var7, var8);
            }
         }
      }

   }

   public List c8801() {
      ArrayList var1 = new ArrayList();
      if (this.c3324.getValue()) {
         var1.add(this.c5728);
      }

      if (this.c1792.getValue()) {
         var1.add(this.c287);
      }

      if (this.c2530.getValue()) {
         var1.add(this.pearl);
      }

      if (this.c7852.getValue()) {
         var1.add(this.egg);
      }

      if (this.c1185.getValue()) {
         var1.add(this.snowball);
      }

      return var1;
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

   public void c1037(double var1, double var3, double var5) {
      GL11.glVertex3d(var1 - this.c8304.c1779(), var3 - this.c8304.c7584(), var5 - this.c8304.c63());
   }

   public void c8595(EntityThrowable var1, IProjectile var2) {
      if (var1.isInstance(MappedClasses.IProjectile)) {
         EntityPlayerSP var3 = Minecraft.thePlayer();
         WorldClient var4 = Minecraft.theWorld();
         Color var5 = var2.c5715(var1.getObject());
         if (var5 == null) {
            var5 = new Color(255, 255, 255);
         }

         GL11.glPushMatrix();
         GL11.glLineWidth(1.5F);
         RenderUtils.setColor(var5);
         GL11.glEnable(2848);
         GL11.glEnable(GL11.GL_BLEND);
         GL11.glDisable(GL11.GL_TEXTURE_2D);
         GL11.glDisable(2929);
         GL11.glBegin(3);
         double var6 = var1.posX();
         double var8 = var1.posY();
         double var10 = var1.posZ();
         double var12 = var1.c6344();
         double var14 = var1.motionY();
         double var16 = var1.c612();
         this.c1037(var6, var8, var10);

         label86:
         while(true) {
            float var19 = var2.c3964();
            float var20 = var2.c1226();
            AxisAlignedBB var21 = AxisAlignedBB.c2682(var6 - (double)var19, var8, var10 - (double)var19, var6 + (double)var19, var8 + (double)var20, var10 + (double)var19);
            Vec3 var22 = Vec3.create(var6, var8, var10);
            Vec3 var23 = Vec3.create(var6 + var12, var8 + var14, var10 + var16);
            RayTraceResult var18 = var4.c3811(var22, var23, false, var1.isInstance(MappedClasses.EntityArrow), false);
            if (var18.isNotNull()) {
               var23 = Vec3.create(var18.c1518().getX(), var18.c1518().getY(), var18.c1518().getZ());
            }

            List var24 = var4.c7700(var3, var21.c8708(var12, var14, var16).c6096(1.0, 1.0, 1.0));
            double var25 = 0.0;
            Iterator var27 = var24.iterator();

            while(true) {
               Entity var29;
               RayTraceResult var30;
               double var31;
               do {
                  do {
                     do {
                        do {
                           do {
                              do {
                                 if (!var27.hasNext()) {
                                    var6 += var12;
                                    var8 += var14;
                                    var10 += var16;
                                    if (var18.isNotNull()) {
                                       var6 = var18.c1518().getX();
                                       var8 = var18.c1518().getY();
                                       var10 = var18.c1518().getZ();
                                       break label86;
                                    }

                                    if (var8 < -128.0) {
                                       break label86;
                                    }

                                    var12 *= var1.isInWater() ? 0.8 : 0.99;
                                    var14 *= var1.isInWater() ? 0.8 : 0.99;
                                    var16 *= var1.isInWater() ? 0.8 : 0.99;
                                    var14 -= 0.05;
                                    this.c1037(var6 + var12, var8 + var14, var10 + var16);
                                    continue label86;
                                 }

                                 Object var28 = var27.next();
                                 var29 = new Entity(var28);
                              } while(!var29.isInstance(MappedClasses.EntityLivingBase));
                           } while(var29.isInstance(MappedClasses.EntityEnderman));
                        } while(!var29.c1797());
                     } while(var29.equals(var3));

                     var21 = var29.boundingBox().c6096(0.3, 0.3, 0.3);
                     var30 = var21.c2786(var22, var23);
                  } while(!var30.isNotNull());

                  var31 = var22.c3571(var30.c1518());
               } while(!(var31 < var25) && var25 != 0.0);

               var25 = var31;
               var30.c7364(var29);
               var18 = var30;
            }
         }

         GL11.glEnd();
         GL11.glDisable(2848);
         GL11.glDisable(GL11.GL_BLEND);
         GL11.glEnable(GL11.GL_TEXTURE_2D);
         GL11.glEnable(2929);
         GL11.glPopMatrix();
      }
   }
}
