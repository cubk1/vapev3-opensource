package gg.vape.unmap;

import gg.vape.utils.MathUtil;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class ColorUtil {
   public static final int RED = getRGB(255,0,0);
   public static final int GREED = getRGB(0,255,0);
   public static final int BLUE = getRGB(0,0,255);
   public static final int WHITE = getRGB(255,255,255);
   public static final int BLACK = getRGB(0,0,0);
   public static final int NO_COLOR = getRGB(0,0,0,0);


   public static int c5970(Color var0) {
      return c5639(var0.getRed(), var0.getGreen(), var0.getBlue(), var0.getAlpha());
   }

   public static void glColor(int hex) {
      float alpha = (float)(hex >> 24 & 0xFF) / 255.0f;
      float red = (float)(hex >> 16 & 0xFF) / 255.0f;
      float green = (float)(hex >> 8 & 0xFF) / 255.0f;
      float blue = (float)(hex & 0xFF) / 255.0f;
      GL11.glColor4f(red, green, blue, alpha);
   }


   public static int c313(int var0) {
      return c5639(var0, var0, var0, 255);
   }

   public static int c231(int var0, int var1) {
      return c5639(var0, var0, var0, var1);
   }

   public static int c7359(int var0, int var1, int var2) {
      return c5639(var0, var1, var2, 255);
   }

   public static int c5639(int var0, int var1, int var2, int var3) {
      int var4 = 0;
      var4 |= MathUtil.c3515(var3, 0, 255) << 24;
      var4 |= MathUtil.c3515(var0, 0, 255) << 16;
      var4 |= MathUtil.c3515(var1, 0, 255) << 8;
      var4 |= MathUtil.c3515(var2, 0, 255);
      return var4;
   }


   public static int getRGB(int r, int g, int b) {
      return getRGB(r,g,b,255);
   }

   public static int getRGB(int r, int g, int b, int a) {
      return ((a & 0xFF) << 24) |
              ((r & 0xFF) << 16) |
              ((g & 0xFF) << 8)  |
              (b & 0xFF);
   }

   public static int[] splitRGB(int rgb) {
      final int[] ints = new int[3];

      ints[0] = (rgb >> 16) & 0xFF;
      ints[1] = (rgb >> 8) & 0xFF;
      ints[2] = rgb & 0xFF;

      return ints;
   }

   public static int getRGB(int rgb) {
      return 0xff000000 | rgb;
   }

   public static int reAlpha(int rgb,int alpha) {
      return getRGB(getRed(rgb),getGreen(rgb),getBlue(rgb),alpha);
   }

   public static int getRed(int rgb) {
      return (rgb >> 16) & 0xFF;
   }

   public static int getGreen(int rgb) {
      return (rgb >> 8) & 0xFF;
   }

   public static int getBlue(int rgb) {
      return rgb & 0xFF;
   }

   public static int getAlpha(int rgb) {
      return (rgb >> 24) & 0xff;
   }
}
