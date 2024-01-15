package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class ScaledResolution extends Wrapper {
   public ScaledResolution(Object var1) {
      super(var1);
   }

   public static ScaledResolution create(Minecraft var0, int var1, int var2) {
      return ForgeVersion.minorVersion() == 13 ? new ScaledResolution(vape.getMappings().scaledResolution.c672(Minecraft.c5366(), var1, var2)) : new ScaledResolution(vape.getMappings().scaledResolution.c5143(var0.getObject()));
   }

   public int c1744() {
      return vape.getMappings().scaledResolution.c7740(this.getObject());
   }

   public int getScaledWidth() {
      return vape.getMappings().scaledResolution.getScaledWidth(this.obj);
   }

   public int getScaledHeight() {
      return vape.getMappings().scaledResolution.getScaledHeight(this.obj);
   }
}
