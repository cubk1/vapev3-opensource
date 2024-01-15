package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class Blocks extends Wrapper {
   public static Block c2304;
   public static Block c7204;
   public static Block c8642;

   public Blocks(Object var1) {
      super(var1);
   }

   public static Block c4613() {
      if (c2304 == null) {
          c2304 = new Block(vape.getMappings().blocks.c7468());
      }

      return c2304;
   }

   public static Block c2456() {
      if (c7204 == null) {
         c7204 = new Block(vape.getMappings().blocks.c1225());
      }

      return c7204;
   }

   public static Block c8223() {
      if (c8642 == null) {
         c8642 = new Block(vape.getMappings().blocks.c6031());
      }

      return c8642;
   }
}
