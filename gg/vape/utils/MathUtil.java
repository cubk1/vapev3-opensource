package gg.vape.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class MathUtil {
   public static final float[] c5766 = new float[65536];
   public static final int[] c6985;

   public static final float c1000(float var0) {
      return c5766[(int)(var0 * 10430.378F) & '\uffff'];
   }

   public static final float c1554(float var0) {
      return c5766[(int)(var0 * 10430.378F + 16384.0F) & '\uffff'];
   }

   public static final float c7163(float var0) {
      return (float)Math.sqrt(var0);
   }

   public static final float sqrt(double var0) {
      return (float)Math.sqrt(var0);
   }

   public static int c4838(float var0) {
      int var1 = (int)var0;
      return var0 < (float)var1 ? var1 - 1 : var1;
   }

   public static int c6998(double var0) {
      return (int)(var0 + 1024.0) - 1024;
   }

   public static int c5621(double var0) {
      int var2 = (int)var0;
      return var0 < (double)var2 ? var2 - 1 : var2;
   }

   public static long c7428(double var0) {
      long var2 = (long)var0;
      return var0 < (double)var2 ? var2 - 1L : var2;
   }

   public static int c7872(double var0) {
      return (int)(var0 >= 0.0 ? var0 : -var0 + 1.0);
   }

   public static float c4527(float var0) {
      return var0 >= 0.0F ? var0 : -var0;
   }

   public static int c628(int var0) {
      return var0 >= 0 ? var0 : -var0;
   }

   public static int c8955(float var0) {
      int var1 = (int)var0;
      return var0 > (float)var1 ? var1 + 1 : var1;
   }

   public static int c3823(double var0) {
      int var2 = (int)var0;
      return var0 > (double)var2 ? var2 + 1 : var2;
   }

   public static int c3515(int var0, int var1, int var2) {
      return var0 < var1 ? var1 : (var0 > var2 ? var2 : var0);
   }

   public static float round(float var0, float var1, float var2) {
      return var0 < var1 ? var1 : (var0 > var2 ? var2 : var0);
   }

   public static double c4052(double var0, double var2, double var4) {
      return var0 < var2 ? var2 : (var0 > var4 ? var4 : var0);
   }

   public static double c8640(double var0, double var2, double var4) {
      return var4 < 0.0 ? var0 : (var4 > 1.0 ? var2 : var0 + (var2 - var0) * var4);
   }

   public static double c6851(double var0, double var2) {
      if (var0 < 0.0) {
         var0 = -var0;
      }

      if (var2 < 0.0) {
         var2 = -var2;
      }

      return var0 > var2 ? var0 : var2;
   }

   public static int c8490(int var0, int var1) {
      return var0 < 0 ? -((-var0 - 1) / var1) - 1 : var0 / var1;
   }

   public static boolean c8652(String var0) {
      return var0 == null || var0.length() == 0;
   }

   public static int c652(Random var0, int var1, int var2) {
      return var1 >= var2 ? var1 : var0.nextInt(var2 - var1 + 1) + var1;
   }

   public static float c7323(Random var0, float var1, float var2) {
      return var1 >= var2 ? var1 : var0.nextFloat() * (var2 - var1) + var1;
   }

   public static double c3031(Random var0, double var1, double var3) {
      return var1 >= var3 ? var1 : var0.nextDouble() * (var3 - var1) + var1;
   }

   public static double c6157(long[] var0) {
      long var1 = 0L;
      long[] var3 = var0;
      int var4 = var0.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         long var6 = var3[var5];
         var1 += var6;
      }

      return (double)var1 / (double)var0.length;
   }

   public static float wrapAngleTo180(float var0) {
      var0 %= 360.0F;
      if (var0 >= 180.0F) {
         var0 -= 360.0F;
      }

      if (var0 < -180.0F) {
         var0 += 360.0F;
      }

      return var0;
   }

   public static double c5162(double var0) {
      var0 %= 360.0;
      if (var0 >= 180.0) {
         var0 -= 360.0;
      }

      if (var0 < -180.0) {
         var0 += 360.0;
      }

      return var0;
   }

   public static int c7660(String var0, int var1) {
      int var2 = var1;

      try {
         var2 = Integer.parseInt(var0);
      } catch (Throwable var4) {
      }

      return var2;
   }

   public static int c6516(String var0, int var1, int var2) {
      int var3 = var1;

      try {
         var3 = Integer.parseInt(var0);
      } catch (Throwable var5) {
      }

      if (var3 < var2) {
         var3 = var2;
      }

      return var3;
   }

   public static double c5628(String var0, double var1) {
      double var3 = var1;

      try {
         var3 = Double.parseDouble(var0);
      } catch (Throwable var6) {
      }

      return var3;
   }

   public static double c8582(String var0, double var1, double var3) {
      double var5 = var1;

      try {
         var5 = Double.parseDouble(var0);
      } catch (Throwable var8) {
      }

      if (var5 < var3) {
         var5 = var3;
      }

      return var5;
   }

   public static int c4162(int var0) {
      int var1 = var0 - 1;
      var1 |= var1 >> 1;
      var1 |= var1 >> 2;
      var1 |= var1 >> 4;
      var1 |= var1 >> 8;
      var1 |= var1 >> 16;
      return var1 + 1;
   }

   public static boolean c8740(int var0) {
      return var0 != 0 && (var0 & var0 - 1) == 0;
   }

   public static int c1660(int var0) {
      var0 = c8740(var0) ? var0 : c4162(var0);
      return c6985[(int)((long)var0 * 125613361L >> 27) & 31];
   }

   public static int c1999(int var0) {
      return c1660(var0) - (c8740(var0) ? 0 : 1);
   }

   public static int c8863(int var0, int var1) {
      if (var1 == 0) {
         return 0;
      } else {
         if (var0 < 0) {
            var1 *= -1;
         }

         int var2 = var0 % var1;
         return var2 == 0 ? var0 : var0 + var1 - var2;
      }
   }

   public static double c3905(double var0, double var2) {
      double var4;
      if (var0 > 0.0) {
         var4 = var0 + Math.abs(var2);
      } else {
         var4 = var0 - Math.abs(var2);
      }

      return var4;
   }

   public static int c6900(int var0, int var1) {
      int var2;
      if (var0 > 0) {
         var2 = var0 + Math.abs(var1);
      } else {
         var2 = var0 - Math.abs(var1);
      }

      return var2;
   }

   public static double c7159(double var0, double var2) {
      double var4 = var0;
      if (var0 > 0.0) {
         if (var0 < var2) {
            var4 = var0 + var2;
         }
      } else if (var0 > -var2) {
         var4 = var0 - var2;
      }

      return var4;
   }

   public static int c1673(Random var0, int var1, int var2) {
      return var0.nextInt(var2 - var1) + var1;
   }

   public static double c1009(Random var0, double var1, double var3) {
      return var1 + (var3 - var1) * var0.nextDouble();
   }

   public static double c1305(double var0, double var2) {
      double var4 = 1.0 / var2;
      return (double)Math.round(var0 * var4) / var4;
   }

   public static double c2080(double var0, int var2) {
      if (var2 < 0) {
         return var0;
      } else {
         BigDecimal var3 = new BigDecimal(var0);
         var3 = var3.setScale(var2, RoundingMode.HALF_UP);
         return var3.doubleValue();
      }
   }

   static {
      for(int var0 = 0; var0 < 65536; ++var0) {
         c5766[var0] = (float)Math.sin((double)var0 * Math.PI * 2.0 / 65536.0);
      }

      c6985 = new int[]{0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9};
   }
}
