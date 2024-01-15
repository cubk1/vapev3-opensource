package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class MinecraftForge extends Wrapper {
   public MinecraftForge() {
      super(null);
   }

   public static ForgeEventBus getEventBus() {
      return new ForgeEventBus(vape.getMappings().minecraftForge.c6031());
   }
}
