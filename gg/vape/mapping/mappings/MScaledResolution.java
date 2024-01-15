package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MScaledResolution extends Mapping {
   public final MappingMethod c7536;
   public MappingMethod c4357;
   public MappingMethod c7614;
   public final MappingMethod getScaledWidth;
   public final MappingMethod getScaledHeight;

   public MScaledResolution() {
      super(MappedClasses.ScaledResolution);
      this.c7536 = this.getMappingMethodNoRemap("getScaleFactor", true, Integer.TYPE);
      this.getScaledHeight = this.getMappingMethodNoRemap("getScaledHeight", true, Integer.TYPE);
      this.getScaledWidth = this.getMappingMethodNoRemap("getScaledWidth", true, Integer.TYPE);
      if (ForgeVersion.minorVersion() > 13) {
         this.c7614 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.Minecraft);
      } else {
         this.c4357 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.Minecraft, Integer.TYPE, Integer.TYPE);
      }

   }

   public int c7740(Object var1) {
      return this.c7536.c2555(var1);
   }

   public int getScaledWidth(Object var1) {
      return this.getScaledWidth.c2555(var1);
   }

   public int getScaledHeight(Object var1) {
      return this.getScaledHeight.c2555(var1);
   }

   public Object c672(Object var1, int var2, int var3) {
      return this.c4357.c4955(var1, var2, var3);
   }

   public Object c5143(Object var1) {
      return this.c7614.c4955(var1);
   }
}
