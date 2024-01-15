package gg.vape.module.render;

import func.skidline.c5273;
import gg.vape.event.impl.EventRender3D;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.utils.MathUtil;
import gg.vape.utils.render.RenderUtils;
import gg.vape.value.BooleanValue;
import gg.vape.value.ColorValue;
import gg.vape.wrapper.impl.*;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Trajectories extends Mod {
   public final RenderManager c757;
   public final BooleanValue c647 = BooleanValue.create(this, "Ghost Bow Charge", false, "Draws a ghost trajectory of a fully charged\nshot when not pulling back bow");
   public final ColorValue c4699 = ColorValue.c7407(this, "Trajectory Color", 128.0);
   public final ColorValue c1390 = ColorValue.c7407(this, "Target Color", 64.0);

   public Trajectories() {
      super("Trajectories", -16535661, Category.Render, "Shows a path of where your projectile will land\nTarget Color will only be used on the cross if there is an entity intersecting it");
      this.addValue(this.c4699, this.c1390, this.c647);
      this.c757 = Minecraft.c5612();
   }

   public List c433(AxisAlignedBB var1) {
      ArrayList var2 = new ArrayList();
      int var3 = MathUtil.c5621((var1.minX() - 2.0) / 16.0);
      int var4 = MathUtil.c5621((var1.c63() + 2.0) / 16.0);
      int var5 = MathUtil.c5621((var1.c7584() - 2.0) / 16.0);
      int var6 = MathUtil.c5621((var1.c1898() + 2.0) / 16.0);
      WorldClient var7 = Minecraft.theWorld();

      for(int var8 = var3; var8 <= var4; ++var8) {
         for(int var9 = var5; var9 <= var6; ++var9) {
            if (var7.getChunkProvider().c7161(var8, var9)) {
               var7.c8950(var8, var9).c4578(Minecraft.thePlayer(), var1, var2, null);
            }
         }
      }

      return var2;
   }

   public void onRender3D(EventRender3D event) {
      boolean var2 = false;
      EntityPlayerSP var3 = Minecraft.thePlayer();
      if (var3.getHeldItemHand().isNotNull()) {
         Item var4 = var3.getHeldItemHand().getItem();
         if (var4.isInstance(MappedClasses.ItemBow) || var4.isInstance(MappedClasses.ItemSnowball) || var4.isInstance(MappedClasses.ItemEnderPearl) || var4.isInstance(MappedClasses.ItemEgg)) {
            if (var4.isInstance(MappedClasses.ItemBow)) {
               var2 = true;
            }

            double var41 = this.c757.c1779() - (double)(MathUtil.c1554(var3.rotationYaw() / 180.0F * 3.1415927F) * 0.16F);
            double var6 = this.c757.c7584() + (double)var3.getEyeHeight() - 0.10000000149011612;
            double var8 = this.c757.c63() - (double)(MathUtil.c1000(var3.rotationYaw() / 180.0F * 3.1415927F) * 0.16F);
            double var10 = (double)(-MathUtil.c1000(var3.rotationYaw() / 180.0F * 3.1415927F) * MathUtil.c1554(var3.rotationPitch() / 180.0F * 3.1415927F)) * (var2 ? 1.0 : 0.4);
            double var12 = (double)(-MathUtil.c1000(var3.rotationPitch() / 180.0F * 3.1415927F)) * (var2 ? 1.0 : 0.4);
            double var14 = (double)(MathUtil.c1554(var3.rotationYaw() / 180.0F * 3.1415927F) * MathUtil.c1554(var3.rotationPitch() / 180.0F * 3.1415927F)) * (var2 ? 1.0 : 0.4);
            boolean var16 = false;
            int var17 = 40;
            if (this.c647.getValue() || var3.c3213() > 0 || !var2) {
               if (var3.c3213() > 0 && var2) {
                  var17 = var3.c3213();
                  var16 = true;
               }

               int var18 = 72000 - var17;
               float var19 = (float)var18 / 20.0F;
               var19 = (var19 * var19 + var19 * 2.0F) / 3.0F;
               if (!((double)var19 < 0.1)) {
                  if (var19 > 1.0F) {
                     var19 = 1.0F;
                  }

                  Color var20 = this.c4699.getAsColor();
                  Color var21 = new Color(var20.getRed(), var20.getGreen(), var20.getBlue(), !var16 && var2 ? 100 : 255);
                  RenderUtils.setColor(var21);
                  GL11.glPushMatrix();
                  Minecraft.c2698().c6766(0.0);
                  boolean var22 = GL11.glIsEnabled(2929);
                  boolean var23 = GL11.glIsEnabled(GL11.GL_TEXTURE_2D);
                  boolean var24 = GL11.glIsEnabled(GL11.GL_BLEND);
                  if (var22) {
                     GL11.glDisable(2929);
                  }

                  if (var23) {
                     GL11.glDisable(GL11.GL_TEXTURE_2D);
                  }

                  GL11.glEnable(2848);
                  GL11.glBlendFunc(770, 771);
                  if (!var24) {
                     GL11.glEnable(GL11.GL_BLEND);
                  }

                  float var25 = MathUtil.sqrt(var10 * var10 + var12 * var12 + var14 * var14);
                  var10 /= var25;
                  var12 /= var25;
                  var14 /= var25;
                  var10 *= (double)(var2 ? var19 * 2.0F : 1.0F) * 1.5;
                  var12 *= (double)(var2 ? var19 * 2.0F : 1.0F) * 1.5;
                  var14 *= (double)(var2 ? var19 * 2.0F : 1.0F) * 1.5;
                  GL11.glLineWidth(1.5F);
                  GL11.glBegin(3);
                  boolean var26 = false;
                  boolean var27 = false;
                  RayTraceResult var28 = new RayTraceResult(null);
                  float var29 = (float)(var2 ? 0.3 : 0.25);

                  for(int var30 = 0; var30 <= 999 && !var26; ++var30) {
                     Vec3 var31 = Vec3.create(var41, var6, var8);
                     Vec3 var32 = Vec3.create(var41 + var10, var6 + var12, var8 + var14);
                     RayTraceResult var33 = Minecraft.theWorld().c3811(var31, var32, false, true, false);
                     var31 = Vec3.create(var41, var6, var8);
                     var32 = Vec3.create(var41 + var10, var6 + var12, var8 + var14);
                     if (var33.isNotNull()) {
                        var26 = true;
                        var28 = var33;
                     }

                     AxisAlignedBB var34 = AxisAlignedBB.c2682(var41 - (double)var29, var6 - (double)var29, var8 - (double)var29, var41 + (double)var29, var6 + (double)var29, var8 + (double)var29);
                     List var35 = this.c433(var34.c8708(var10, var12, var14).c6096(1.0, 1.0, 1.0));

                     for(int var36 = 0; var36 < var35.size(); ++var36) {
                        Entity var37 = new Entity(var35.get(var36));
                        if (var37.c1797() && var37 != var3) {
                           float var38 = 0.3F;
                           AxisAlignedBB var39 = var37.boundingBox().c6096(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
                           RayTraceResult var40 = var39.c2786(var31, var32);
                           if (var40.isNotNull()) {
                              var26 = true;
                              var27 = true;
                              var28 = var40;
                           }
                        }
                     }

                     if (var27) {
                        RenderUtils.setColor(this.c1390.getAsColor());
                     }

                     var41 += var10;
                     var6 += var12;
                     var8 += var14;
                     float var42 = 0.99F;
                     var10 *= var42;
                     var12 *= var42;
                     var14 *= var42;
                     var12 -= var2 ? 0.05 : 0.03;
                     GL11.glVertex3d(var41 - this.c757.c1779(), var6 - this.c757.c7584(), var8 - this.c757.c63());
                  }

                  GL11.glEnd();
                  GL11.glDisable(2929);
                  GL11.glDisable(GL11.GL_BLEND);
                  GL11.glTranslated(var41 - this.c757.c1779(), var6 - this.c757.c7584(), var8 - this.c757.c63());
                  if (var28.isNotNull()) {
                     switch (var28.c7217()) {
                        case 2:
                           GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                           break;
                        case 3:
                           GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                           break;
                        case 4:
                           GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
                           break;
                        case 5:
                           GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
                     }

                     if (var27) {
                        RenderUtils.setColor(this.c1390.getAsColor());
                     }
                  }

                  this.c8116();
                  GL11.glDisable(2848);
                  if (var22) {
                     GL11.glEnable(2929);
                  }

                  if (var23) {
                     GL11.glEnable(GL11.GL_TEXTURE_2D);
                  }

                  if (!var24) {
                     GL11.glDisable(GL11.GL_BLEND);
                  }

                  Minecraft.c2698().c4997(0.0);
                  GL11.glPopMatrix();
               }
            }
         }
      }
   }

   public boolean c6428(AxisAlignedBB var1, Material var2) {
      int var3 = MathUtil.c5621(var1.minX());
      int var4 = MathUtil.c5621(var1.c63() + 1.0);
      int var5 = MathUtil.c5621(var1.minY());
      int var6 = MathUtil.c5621(var1.c8246() + 1.0);
      int var7 = MathUtil.c5621(var1.c7584());
      int var8 = MathUtil.c5621(var1.c1898() + 1.0);
      if (!Minecraft.theWorld().c7029(var3, var5, var7, var4, var6, var8)) {
         return false;
      } else {
         boolean var9 = false;
         Vec3.create(0.0, 0.0, 0.0);

         for(int var10 = var3; var10 < var4; ++var10) {
            for(int var11 = var5; var11 < var6; ++var11) {
               for(int var12 = var7; var12 < var8; ++var12) {
                  Block var13 = Minecraft.theWorld().getBlockByPos(var10, var11, var12);
                  if (var13.isNotNull() && var13.c4045() == var2) {
                     double var14 = (float)(var11 + 1) - c5273.re(Minecraft.theWorld().c4491(var10, var11, var12));
                     if ((double)var6 >= var14) {
                        var9 = true;
                     }
                  }
               }
            }
         }

         return var9;
      }
   }

   public void c8116() {
      GL11.glBegin(1);
      GL11.glVertex3d(-0.25, 0.0, 0.0);
      GL11.glVertex3d(0.0, 0.0, 0.0);
      GL11.glVertex3d(0.0, 0.0, -0.25);
      GL11.glVertex3d(0.0, 0.0, 0.0);
      GL11.glVertex3d(0.25, 0.0, 0.0);
      GL11.glVertex3d(0.0, 0.0, 0.0);
      GL11.glVertex3d(0.0, 0.0, 0.25);
      GL11.glVertex3d(0.0, 0.0, 0.0);
      GL11.glEnd();
   }
}
