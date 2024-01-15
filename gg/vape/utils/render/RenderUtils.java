package gg.vape.utils.render;

import func.skidline.c5423;
import gg.vape.Vape;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.utils.BlurBuffer;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.ScaledResolution;
import gg.vape.wrapper.impl.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.HashSet;

import static org.lwjgl.opengl.GL11.GL_QUADS;

public final class RenderUtils {
   public static IntBuffer c3023;
   public static FloatBuffer c4100;
   public static FloatBuffer c6145;

   public RenderUtils() {
   }

   public static void setColor(Color color) {
      GL11.glColor4f((float)color.getRed() / 255.0F, (float)color.getGreen() / 255.0F, (float)color.getBlue() / 255.0F, (float)color.getAlpha() / 255.0F);
   }

   public static void drawBlurRect(Number x1, Number y1, Number x2, Number y2) {
      BlurBuffer.blurArea(x1.floatValue(), y1.floatValue(), x2.floatValue() - x1.floatValue(), y2.floatValue() - y1.floatValue());
   }

   public static void c2266(double var0, double var2, double var4, double var6) {
      GL11.glEnable(3089);
      ScaledResolution var8 = Minecraft.c4912();
      int var9 = Minecraft.displayHeight();
      int var10 = var8.c1744();
      int var11 = (int)(var4 * (double)var10);
      int var12 = (int)(var6 * (double)var10);
      double var13 = var0 * (double)var10;
      int var15 = (int)var13;
      double var16 = var2 * (double)var10;
      int var18 = (int)((double)var9 - var16 - (double)var12);
      GL11.glScissor(var15, var18, var11, var12);
   }
   /**该方法名为 drawRect，参数如下：
       @param color 颜色对象，表示矩形的填充色
       @param lx1 表示矩形左上角顶点的 x 坐标
       @param ly1 表示矩形左上角顶点的 y 坐标
       @param rx1 表示矩形右上角顶点的 x 坐标
       @param ry1 表示矩形右上角顶点的 y 坐标
       @param rx2 表示矩形右下角顶点的 x 坐标
       @param ry2 表示矩形右下角顶点的 y 坐标
       @param lx2 表示矩形左下角顶点的 x 坐标
       @param ly2 表示矩形左下角顶点的 y 坐标
    */
   public static void drawRect(
           Color color,
           double lx1,
           double ly1,
           double rx1,
           double ry1,
           double rx2,
           double ry2,
           double lx2,
           double ly2
   ) {
      setColor(color);
      GL11.glBegin(GL_QUADS);
      GL11.glVertex2d(lx1, ly1);
      GL11.glVertex2d(rx1, ry1);
      GL11.glVertex2d(rx2, ry2);
      GL11.glVertex2d(lx2, ly2);
      GL11.glEnd();
      GL11.glColor4d(1.0, 1.0, 1.0, 1.0);
   }



   public static void drawRect(double left, double top, double right, double bottom, int color) {
      if (left < right) {
         double i = left;
         left = right;
         right = i;
      }

      if (top < bottom) {
         double j = top;
         top = bottom;
         bottom = j;
      }

      float f3 = (float)(color >> 24 & 255) / 255.0F;
      float f = (float)(color >> 16 & 255) / 255.0F;
      float f1 = (float)(color >> 8 & 255) / 255.0F;
      float f2 = (float)(color & 255) / 255.0F;
      net.minecraft.client.renderer.Tessellator tessellator = net.minecraft.client.renderer.Tessellator.getInstance();
      WorldRenderer worldrenderer = tessellator.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(f, f1, f2, f3);
      worldrenderer.begin(7, DefaultVertexFormats.POSITION);
      worldrenderer.pos(left, bottom, 0.0D).endVertex();
      worldrenderer.pos(right, bottom, 0.0D).endVertex();
      worldrenderer.pos(right, top, 0.0D).endVertex();
      worldrenderer.pos(left, top, 0.0D).endVertex();
      tessellator.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void drawComponent(Color var0, IGuiComponent var1) {
      ClickGui gui = (ClickGui) Vape.instance.getModManager().getMod(ClickGui.class);

      if(gui.blur.getValue()){
         if(var0.equals(IGuiComponent.backGroundColor)){
            BlurBuffer.blurArea(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
         }
      }
      drawRect(var0, var1.getX(), var1.getY() + var1.getHeight(), var1.getX() + var1.getWidth(), var1.getY() + var1.getHeight(), var1.getX() + var1.getWidth(), var1.getY(), var1.getX(), var1.getY());

   }

   public static void drawComponentSquare(Color color, double sideLength, IGuiComponent component, Integer... flags) {
      //4 - ALLSIDE

      HashSet<Integer> set = new HashSet<>(Arrays.asList(flags));
      boolean flag_allside = set.contains(4);
      if (flag_allside || set.contains(0)) {
         drawRect(color, component.getX(), component.getY() + component.getHeight(), component.getX() + sideLength, component.getY() + component.getHeight(), component.getX() + sideLength, component.getY(), component.getX(), component.getY());
      }

      if (flag_allside || set.contains(3)) {
         drawRect(color, component.getX() + sideLength, component.getY() + component.getHeight(), component.getX() + component.getWidth() - sideLength, component.getY() + component.getHeight(), component.getX() + component.getWidth() - sideLength, component.getY() + component.getHeight() - sideLength, component.getX() + sideLength, component.getY() + component.getHeight() - sideLength);
      }

      if (flag_allside || set.contains(2)) {
         drawRect(color, component.getX() + component.getWidth() - sideLength, component.getY() + component.getHeight(), component.getX() + component.getWidth(), component.getY() + component.getHeight(), component.getX() + component.getWidth(), component.getY(), component.getX() + component.getWidth() - sideLength, component.getY());
      }

      if (flag_allside || set.contains(1)) {
         drawRect(color, component.getX() + sideLength, component.getY() + sideLength, component.getX() + component.getWidth() - sideLength, component.getY() + sideLength, component.getX() + component.getWidth() - sideLength, component.getY(), component.getX() + sideLength, component.getY());
      }

   }

   public static c5423 c7719() {
      int var0 = Minecraft.gameSettings().c5203();
      if (var0 == 0) {
         var0 = 1000;
      }

      int var1;
      for(var1 = 0; var1 < var0 && Minecraft.displayWidth() / (var1 + 1) >= 320 && Minecraft.displayHeight() / (var1 + 1) >= 240; ++var1) {
      }

      if (var1 == 0) {
         var1 = 2;
      }

      return new c5423(Mouse.getX() / var1, Minecraft.displayHeight() / var1 - Mouse.getY() / var1 - 1);
   }

   public static void c3062(double var0, double var2, double var4, double var6, Color var8, int var9) {
      GL11.glEnable(GL11.GL_BLEND);
      GL11.glDisable(GL11.GL_TEXTURE_2D);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4d(var8.getRed() / 255, var8.getGreen() / 255, var8.getBlue() / 255, var9 / 255);
      GL11.glBegin(9);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var0 + var4 / 2.0, var2 + var6);
      GL11.glVertex2d(var0 + var4, var2);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glDisable(2848);
      GL11.glEnable(GL11.GL_TEXTURE_2D);
      GL11.glDisable(GL11.GL_BLEND);
   }

   public static void c403(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14) {
      GL11.glEnable(GL11.GL_BLEND);
      GL11.glDisable(GL11.GL_TEXTURE_2D);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4d(var8, var10, var12, var14);
      GL11.glBegin(7);
      GL11.glVertex2d(var4, var2);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var0, var6);
      GL11.glVertex2d(var4, var6);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glDisable(2848);
      GL11.glEnable(GL11.GL_TEXTURE_2D);
      GL11.glDisable(GL11.GL_BLEND);
   }

   public static void c2096(double var0, double var2, double var4, double var6, Color var8) {
      GL11.glEnable(GL11.GL_BLEND);
      GL11.glDisable(GL11.GL_TEXTURE_2D);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4d((float)var8.getRed() / 255.0F, (float)var8.getGreen() / 255.0F, (float)var8.getBlue() / 255.0F, (float)var8.getAlpha() / 255.0F);
      GL11.glBegin(7);
      GL11.glVertex2d(var4, var2);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var0, var6);
      GL11.glVertex2d(var4, var6);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glDisable(2848);
      GL11.glEnable(GL11.GL_TEXTURE_2D);
      GL11.glDisable(GL11.GL_BLEND);
   }

   public static void c2538(double var0, double var2, double var4, double var6) {
   }

   public static void c1314(double var0, double var2, double var4, double var6) {
      Tessellator var8 = Tessellator.getInstance();
      var8.c33(7);
      var8.c7967(var0, var6, 0.0, 1.0, 0.0);
      var8.c7967(var4, var6, 0.0, 0.0, 0.0);
      var8.c7967(var4, var2, 0.0, 0.0, 1.0);
      var8.c7967(var0, var2, 0.0, 1.0, 1.0);
      var8.draw();
   }

   public static void c484(double var0, double var2, double var4, double var6) {
   }

   public static void c8275(double var0, double var2, double var4, double var6) {
      GL11.glBegin(7);
      GL11.glTexCoord2f(1.0F, 0.0F);
      GL11.glVertex3d(var0, var6, 0.0);
      GL11.glTexCoord2f(0.0F, 0.0F);
      GL11.glVertex3d(var4, var6, 0.0);
      GL11.glTexCoord2f(0.0F, 1.0F);
      GL11.glVertex3d(var4, var2, 0.0);
      GL11.glTexCoord2f(1.0F, 1.0F);
      GL11.glVertex3d(var0, var2, 0.0);
      GL11.glEnd();
   }

   public static void c2430(int var0) {
      float var1 = (float)(var0 >> 24 & 255) / 255.0F;
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
   }

   public static void c2754(int var0, int var1, int var2, int var3) {
      float var4 = 0.003921569F * (float)var0;
      float var5 = 0.003921569F * (float)var1;
      float var6 = 0.003921569F * (float)var2;
      float var7 = 0.003921569F * (float)var3;
      GL11.glColor4f(var4, var5, var6, var7);
   }

   public static void c3913(float var0, float var1, float var2, float var3, float var4, int var5) {
      float var6 = (var3 - var1) / 4.0F;
      float var7 = (var2 - var0) / 4.0F;
      c3291(var0 - var4, var1, var0, var1 + var6, var5);
      c3291(var0 - var4, var1 - var4, var0 + var7, var1, var5);
      c3291(var2, var1, var2 + var4, var1 + var6, var5);
      c3291(var2 - var7, var1 - var4, var2 + var4, var1, var5);
      c3291(var0 - var4, var3 - var6, var0, var3, var5);
      c3291(var0 - var4, var3, var0 + var7, var3 + var4, var5);
      c3291(var2, var3 - var6, var2 + var4, var3, var5);
      c3291(var2 - var7, var3, var2 + var4, var3 + var4, var5);
   }

   public static void c3291(float var0, float var1, float var2, float var3, int var4) {
      c8845();
      c2430(var4);
      c857(var0, var1, var2, var3);
      c5859();
   }

   public static void c7048(double var0, double var2, double var4, double var6, int var8) {
      c8845();
      c2430(var8);
      c857((float)var0, (float)var2, (float)var4, (float)var6);
      c5859();
   }

   public static void c3903(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      c8845();
      GL11.glColor4f(var4, var5, var6, var7);
      c857(var0, var1, var2, var3);
      c5859();
   }

   public static void c857(float var0, float var1, float var2, float var3) {
      GL11.glBegin(7);
      GL11.glVertex2f(var0, var3);
      GL11.glVertex2f(var2, var3);
      GL11.glVertex2f(var2, var1);
      GL11.glVertex2f(var0, var1);
      GL11.glEnd();
   }

   public static void c8845() {
      GL11.glEnable(GL11.GL_BLEND);
      GL11.glDisable(GL11.GL_TEXTURE_2D);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
   }

   public static void c5859() {
      GL11.glDisable(2848);
      GL11.glEnable(GL11.GL_TEXTURE_2D);
      GL11.glDisable(GL11.GL_BLEND);
   }
}
