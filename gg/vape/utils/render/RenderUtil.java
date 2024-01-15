package gg.vape.utils.render;

import gg.vape.Vape;
import gg.vape.module.none.ClientSettings;
import gg.vape.unmap.GLUtils;
import gg.vape.unmap.NumberFormat;
import gg.vape.utils.MathUtil;
import gg.vape.utils.datas.HSBAData;
import gg.vape.utils.datas.HSBData;
import gg.vape.wrapper.impl.*;
import org.lwjgl.opengl.GL11;
import pub.nextsense.Tweaker;

import java.awt.*;

public class RenderUtil {
   public static final GLUtils c2229;
   public static final GLUtils c7611;
   public static final boolean c6919 = ForgeVersion.minorVersion() > 13;
   public static final NumberFormat c3071 = new NumberFormat("#.#");

   public static void c5676(double var0, double var2, double var4, double var6, double var8, double var10, double var12, Color var14) {
      RenderManager var15 = Minecraft.c5612();
      FontRenderer var16 = Minecraft.getFontRenderer();
      EntityPlayerSP var17 = Minecraft.thePlayer();
      Minecraft.c2698().c6766(0.0);
      GL11.glPushMatrix();
      GL11.glTranslated(var0, var2 + 1.4, var4);
      GL11.glNormal3d(0.0, 1.0, 0.0);
      double var18 = 0.0;
      double var20 = var6 - Minecraft.thePlayer().posX();
      double var22 = var10 - Minecraft.thePlayer().posZ();
      if (var22 > 0.0 && var20 > 0.0) {
         var18 = Math.toDegrees(-Math.atan(var20 / var22));
      } else if (var22 > 0.0 && var20 < 0.0) {
         var18 = Math.toDegrees(-Math.atan(var20 / var22));
      } else if (var22 < 0.0 && var20 > 0.0) {
         var18 = -90.0 + Math.toDegrees(Math.atan(var22 / var20));
      } else if (var22 < 0.0 && var20 < 0.0) {
         var18 = 90.0 + Math.toDegrees(Math.atan(var22 / var20));
      }

      GL11.glRotated(-var18, 0.0, 1.0, 0.0);
      double var24 = var8 - var17.posY() + var12 / 2.0 + 0.2;
      if (ClientSettings.not1710) {
         var24 = var8 - 0.3 - var17.posY();
      }

      double var26 = var10 - var17.posZ();
      double var28 = MathUtil.sqrt(var20 * var20 + var26 * var26);
      float var30 = (float)(-(Math.atan2(var24, var28) * 180.0 / Math.PI));
      GL11.glRotated(var30, 1.0, 0.0, 0.0);
      GL11.glDisable(2896);
      GL11.glDisable(2929);
      double var31 = 0.5;
      double var33 = -1.0;
      GL11.glEnable(GL11.GL_BLEND);
      GL11.glDisable(GL11.GL_TEXTURE_2D);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4d((float)var14.getRed() / 255.0F, (float)var14.getGreen() / 255.0F, (float)var14.getBlue() / 255.0F, (float)var14.getAlpha() / 255.0F);
      GL11.glLineWidth(3.0F);
      GL11.glBegin(2);
      GL11.glVertex2d(-var31, -var33);
      GL11.glVertex2d(var31, -var33);
      GL11.glVertex2d(var31, var33);
      GL11.glVertex2d(-var31, var33);
      GL11.glEnd();
      GL11.glEnable(2929);
      GL11.glBegin(2);
      GL11.glVertex2d(-var31, -var33);
      GL11.glVertex2d(var31, -var33);
      GL11.glVertex2d(var31, var33);
      GL11.glVertex2d(-var31, var33);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(GL11.GL_TEXTURE_2D);
      GL11.glDisable(GL11.GL_BLEND);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glEnable(2896);
      GL11.glPopMatrix();
      Minecraft.c2698().c4997(0.0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c2609(double var0, double var2, double var4, double var6, double var8, double var10, double var12, Color var14, Color var15, double var16, double var18, double var20) {
      double var32;
      double var22;
      double var24;
      double var26;
      double var28;
      double var30;
      if (var15 != null) {
         GL11.glColor4d((float)var15.getRed() / 255.0F, (float)var15.getGreen() / 255.0F, (float)var15.getBlue() / 255.0F, (float)var15.getAlpha() / 255.0F);
         c7611.c4183();
         var22 = var0 + var6 - var16;
         var24 = var0 - var16;
         var26 = var2 + var8 - var18;
         var28 = var2 - var18;
         var30 = var4 + var10 - var20;
         var32 = var4 - var20;
         c7611.c8852(var24, var28, var32);
         c7611.c8852(var24, var26, var32);
         c7611.c8852(var22, var28, var32);
         c7611.c8852(var22, var26, var32);
         c7611.c8852(var22, var28, var30);
         c7611.c8852(var22, var26, var30);
         c7611.c8852(var24, var28, var30);
         c7611.c8852(var24, var26, var30);
         c7611.c8852(var22, var26, var32);
         c7611.c8852(var22, var28, var32);
         c7611.c8852(var24, var26, var32);
         c7611.c8852(var24, var28, var32);
         c7611.c8852(var24, var26, var30);
         c7611.c8852(var24, var28, var30);
         c7611.c8852(var22, var26, var30);
         c7611.c8852(var22, var28, var30);
         c7611.c8852(var24, var26, var32);
         c7611.c8852(var22, var26, var32);
         c7611.c8852(var22, var26, var30);
         c7611.c8852(var24, var26, var30);
         c7611.c8852(var24, var26, var32);
         c7611.c8852(var24, var26, var30);
         c7611.c8852(var22, var26, var30);
         c7611.c8852(var22, var26, var32);
         c7611.c8852(var24, var28, var32);
         c7611.c8852(var22, var28, var32);
         c7611.c8852(var22, var28, var30);
         c7611.c8852(var24, var28, var30);
         c7611.c8852(var24, var28, var32);
         c7611.c8852(var24, var28, var30);
         c7611.c8852(var22, var28, var30);
         c7611.c8852(var22, var28, var32);
         c7611.c8852(var24, var28, var32);
         c7611.c8852(var24, var26, var32);
         c7611.c8852(var24, var28, var30);
         c7611.c8852(var24, var26, var30);
         c7611.c8852(var22, var28, var30);
         c7611.c8852(var22, var26, var30);
         c7611.c8852(var22, var28, var32);
         c7611.c8852(var22, var26, var32);
         c7611.c8852(var24, var26, var30);
         c7611.c8852(var24, var28, var30);
         c7611.c8852(var24, var26, var32);
         c7611.c8852(var24, var28, var32);
         c7611.c8852(var22, var26, var32);
         c7611.c8852(var22, var28, var32);
         c7611.c8852(var22, var26, var30);
         c7611.c8852(var22, var28, var30);
         c7611.c8660();
      }

      if (var14 != null) {
         GL11.glColor4d((float)var14.getRed() / 255.0F, (float)var14.getGreen() / 255.0F, (float)var14.getBlue() / 255.0F, (float)var14.getAlpha() / 255.0F);
         c2229.c4183();
         var22 = var0 + var6 - var16;
         var24 = var0 - var16;
         var26 = var2 + var8 - var18;
         var28 = var2 - var18;
         var30 = var4 + var10 - var20;
         var32 = var4 - var20;
         c2229.c8852(var24, var28, var32);
         c2229.c8852(var22, var28, var32);
         c2229.c8852(var24, var28, var30);
         c2229.c8852(var22, var28, var30);
         c2229.c8852(var24, var28, var32);
         c2229.c8852(var24, var28, var30);
         c2229.c8852(var22, var28, var32);
         c2229.c8852(var22, var28, var30);
         c2229.c8852(var24, var26, var32);
         c2229.c8852(var22, var26, var32);
         c2229.c8852(var24, var26, var30);
         c2229.c8852(var22, var26, var30);
         c2229.c8852(var24, var26, var32);
         c2229.c8852(var24, var26, var30);
         c2229.c8852(var22, var26, var32);
         c2229.c8852(var22, var26, var30);
         c2229.c8852(var24, var28, var32);
         c2229.c8852(var24, var26, var32);
         c2229.c8852(var24, var28, var30);
         c2229.c8852(var24, var26, var30);
         c2229.c8852(var22, var28, var30);
         c2229.c8852(var22, var26, var30);
         c2229.c8852(var22, var28, var32);
         c2229.c8852(var22, var26, var32);
         c2229.c8660();
      }

   }

   public static void c1806(HSBData var0, double var1, double var3, double var5) {
      c2609(var0.c4291, var0.c6771, var0.c8812, 1.0, 1.0, 1.0, 0.1, var0.c7410, null, var1, var3, var5);
   }

   public static void c5751(double var0, double var2, double var4, HSBData var6, Color var7) {
      GL11.glColor4d((float)var6.c7410.getRed() / 255.0F, (float)var6.c7410.getGreen() / 255.0F, (float)var6.c7410.getBlue() / 255.0F, (float)var6.c7410.getAlpha() / 255.0F);
      c7611.c4183();
      double var8 = (double)(var6.c4291 + 1) - var0;
      double var10 = (double)var6.c4291 - var0;
      double var12 = (double)(var6.c6771 + 1) - var2;
      double var14 = (double)var6.c6771 - var2;
      double var16 = (double)(var6.c8812 + 1) - var4;
      double var18 = (double)var6.c8812 - var4;
      c7611.c8852(var10, var14, var18);
      c7611.c8852(var10, var12, var18);
      c7611.c8852(var8, var14, var18);
      c7611.c8852(var8, var12, var18);
      c7611.c8852(var8, var14, var16);
      c7611.c8852(var8, var12, var16);
      c7611.c8852(var10, var14, var16);
      c7611.c8852(var10, var12, var16);
      c7611.c8852(var8, var12, var18);
      c7611.c8852(var8, var14, var18);
      c7611.c8852(var10, var12, var18);
      c7611.c8852(var10, var14, var18);
      c7611.c8852(var10, var12, var16);
      c7611.c8852(var10, var14, var16);
      c7611.c8852(var8, var12, var16);
      c7611.c8852(var8, var14, var16);
      c7611.c8852(var10, var12, var18);
      c7611.c8852(var8, var12, var18);
      c7611.c8852(var8, var12, var16);
      c7611.c8852(var10, var12, var16);
      c7611.c8852(var10, var12, var18);
      c7611.c8852(var10, var12, var16);
      c7611.c8852(var8, var12, var16);
      c7611.c8852(var8, var12, var18);
      c7611.c8852(var10, var14, var18);
      c7611.c8852(var8, var14, var18);
      c7611.c8852(var8, var14, var16);
      c7611.c8852(var10, var14, var16);
      c7611.c8852(var10, var14, var18);
      c7611.c8852(var10, var14, var16);
      c7611.c8852(var8, var14, var16);
      c7611.c8852(var8, var14, var18);
      c7611.c8852(var10, var14, var18);
      c7611.c8852(var10, var12, var18);
      c7611.c8852(var10, var14, var16);
      c7611.c8852(var10, var12, var16);
      c7611.c8852(var8, var14, var16);
      c7611.c8852(var8, var12, var16);
      c7611.c8852(var8, var14, var18);
      c7611.c8852(var8, var12, var18);
      c7611.c8852(var10, var12, var16);
      c7611.c8852(var10, var14, var16);
      c7611.c8852(var10, var12, var18);
      c7611.c8852(var10, var14, var18);
      c7611.c8852(var8, var12, var18);
      c7611.c8852(var8, var14, var18);
      c7611.c8852(var8, var12, var16);
      c7611.c8852(var8, var14, var16);
      c7611.c8660();
      if (var6 instanceof HSBAData) {
         HSBAData var20 = (HSBAData)var6;
         if (var20.c4108() > 0.0F) {
            GL11.glColor4d((double)(255 - var20.c7410.getRed()) / 255.0, (255.0 - (double)var20.c7410.getGreen()) / 255.0, (255.0 - (double)var20.c7410.getBlue()) / 255.0, 0.7);
            GL11.glLineWidth(3.0F);
            c2229.c4183();
            c2229.c8852(var10, var14, var18);
            c2229.c8852(var10, var12, var18);
            c2229.c8852(var8, var14, var18);
            c2229.c8852(var8, var12, var18);
            c2229.c8852(var10, var14, var16);
            c2229.c8852(var10, var12, var16);
            c2229.c8852(var8, var14, var16);
            c2229.c8852(var8, var12, var16);
            c2229.c8852(var8, var14, var18);
            c2229.c8852(var8, var14, var16);
            c2229.c8852(var8, var12, var18);
            c2229.c8852(var8, var12, var16);
            c2229.c8852(var10, var14, var18);
            c2229.c8852(var10, var14, var16);
            c2229.c8852(var10, var12, var18);
            c2229.c8852(var10, var12, var16);
            c2229.c8852(var10, var14, var18);
            c2229.c8852(var8, var14, var18);
            c2229.c8852(var10, var12, var18);
            c2229.c8852(var8, var12, var18);
            c2229.c8852(var10, var14, var16);
            c2229.c8852(var8, var14, var16);
            c2229.c8852(var10, var12, var16);
            c2229.c8852(var8, var12, var16);
            c2229.c8660();
         }
      }

   }

   public static void drawESP(Entity var0, double var1, Color var3, Color var4, float var5) {
      RenderManager var6 = Minecraft.c5612();
      double var7 = var6.c1779();
      double var9 = var6.c7584();
      double var11 = var6.c63();
      double var13 = var0.c5823() + (var0.posX() - var0.c5823()) * (double)var5;
      double var15 = var0.c8561() + (var0.posY() - var0.c8561()) * (double)var5;
      double var17 = var0.c7002() + (var0.posZ() - var0.c7002()) * (double)var5;
      GL11.glPushMatrix();
      Minecraft.c2698().c6766(1.0);
      GL11.glEnable(GL11.GL_BLEND);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.5F);
      GL11.glDisable(GL11.GL_TEXTURE_2D);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      double var19 = 0.15;
      c2609(var13 - (double)(var0.c8958() / 2.0F) - var19, var15, var17 - (double)(var0.c8958() / 2.0F) - var19, (double)var0.c8958() + var19 * 2.0, var0.c1998(), (double)var0.c8958() + var19 * 2.0, var1, var3, var4, var7, var9, var11);
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glEnable(GL11.GL_TEXTURE_2D);
      GL11.glDisable(2848);
      GL11.glDisable(GL11.GL_BLEND);
      Minecraft.c2698().c4997(1.0);
      GL11.glPopMatrix();
   }

   public static void c4684(String var0, double var1, double var3, double var5, double var7, double var9, int var11, Color var12, double var13) {
      RenderManager var15 = Minecraft.c5612();
      FontRenderer var16 = Minecraft.getFontRenderer();
      Minecraft.c2698().c6766(0.0);
      GL11.glPushMatrix();
      GL11.glTranslated(var1, var3 + var13, var5);
      GL11.glNormal3d(0.0, 1.0, 0.0);
      GL11.glRotated(-var15.c4311(), 0.0, 1.0, 0.0);
      GL11.glRotated(var15.c8901(), 1.0, 0.0, 0.0);
      float var17 = var9 / 5.0 <= 2.0 ? 2.0F : (float)(var9 / 5.0);
      float var18 = (float)(0.01666666753590107 * (double)var17 * var7);
      GL11.glScaled(-var18, -var18, var18);
      boolean var19 = GL11.glIsEnabled(2896);
      if (var19) {
         GL11.glDisable(2896);
      }

      int var20 = var16.getStringWidth(var0) / 2;
      int var21 = -(var16.FONT_HEIGHT(var0) - 1);
      RenderUtils.c2096((double)(-var20) - 2.0, (double)var21 - 2.0, (double)var20 + 2.0, 2.0, var12);
      GL11.glDisable(2929);
      RenderUtils.c2096((double)(-var20) - 2.0, (double)var21 - 2.0, (double)var20 + 2.0, 2.0, var12);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      var16.c8629(var0, -var20, (double)var21 + 0.1, var11);
      GL11.glEnable(2929);
      var16.c8629(var0, -var20, (double)var21 + 0.1, var11);
      if (var19) {
         GL11.glEnable(2896);
      }

      GL11.glEnable(2929);
      GL11.glPopMatrix();
      Minecraft.c2698().c4997(0.0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static Color c7444(Color var0) {
      int var1 = var0.getRGB();
      var1 = 16777215 - var1;
      return new Color(var1);
   }

   public static double[] c6964(double var0, double var2, double var4) {
      return Tweaker.trn(var0, var2, var4);
   }

   static {
      c2229 = Vape.instance.c8466();
      c7611 = new GLUtils();
      c7611.c6803(48, 7);
   }
}
