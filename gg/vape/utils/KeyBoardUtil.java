package gg.vape.utils;

import pub.nextsense.Tweaker;

public class KeyBoardUtil {
   public static final int c4957 = 1;
   public static final int c283 = 2;

   public static boolean c6509() {
      return (Tweaker.isPressed(1) & 256) != 0;
   }

   public static boolean c2203() {
      return (Tweaker.isPressed(2) & 256) != 0;
   }
}
