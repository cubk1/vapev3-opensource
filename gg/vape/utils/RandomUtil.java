package gg.vape.utils;

import gg.vape.value.RandomValue;

import java.util.Random;

public class RandomUtil {
   public static final Random c3398 = new Random();

   public static int c5123(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 <= 0 ? var0 : c3398.nextInt(var2) + var0 + 1;
   }

   public static int c8609(RandomValue var0) {
      return c5123(var0.getValue()[0].intValue(), var0.getValue()[1].intValue());
   }
}
