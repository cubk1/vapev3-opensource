package gg.vape.unmap;

import func.skidline.NumberData;

public class NumberFormat {
   public final int c2307;

   public NumberFormat(int var1) {
      this.c2307 = var1;
   }

   public NumberFormat(String var1) {
      this.c2307 = var1.length() - (var1.indexOf(".") + 1);
   }

   public double c471(double var1) {
      return Double.valueOf(this.c8033(var1));
   }

   public double c4502(NumberData var1) {
      return this.c471(var1.doubleValue());
   }

   public String c8033(double var1) {
      String var3 = String.valueOf(var1).replaceAll(",", ".");
      if (var3.contains("E")) {
         return var3;
      } else if (var3.contains(".")) {
         int var4 = Math.min(var3.indexOf(46) + this.c2307 + 1, var3.length());
         return var3.substring(0, var4);
      } else {
         return var3;
      }
   }

   public String c3316(NumberData var1) {
      return this.c8033(var1.doubleValue());
   }

   public int c8532() {
      return this.c2307;
   }
}
