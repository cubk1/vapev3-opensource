package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class ForgeEventBus extends Wrapper {
   public ForgeEventBus(Object var1) {
      super(var1);
   }

   public void c5057(ForgeEvent var1) {
      try {
         vape.getMappings().eventBus.c6771(this.obj, var1.getObject());
      } catch (Exception var3) {
      }

   }
}
