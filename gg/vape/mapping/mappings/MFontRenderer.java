package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MFontRenderer extends Mapping {
   public MappingMethod c7750;
   public MappingMethod drawStringWithShadow;
   public final MappingMethod c6731;
   public final MappingMethod c521;
   public final MappingField c8297;

   public MFontRenderer() {
      super("net/minecraft/client/gui/FontRenderer");
      if (ForgeVersion.minorVersion() == 13) {
         this.c7750 = this.getMappingMethodNoRemap("drawStringWithShadow", true, Integer.TYPE, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         this.c6731 = this.getMappingMethodNoRemap("drawString", true, Integer.TYPE, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
      } else {
         this.drawStringWithShadow = this.getMappingMethodNoRemap("drawStringWithShadow", true, Integer.TYPE, String.class, Float.TYPE, Float.TYPE, Integer.TYPE);
         this.c6731 = this.getMappingMethodNoRemap("func_78276_b", false, Integer.TYPE, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
      }

      this.c8297 = this.getMappingFieldNoRemap("locationFontTexture", true, MappedClasses.ResourceLocation);
      this.c521 = this.getMappingMethodNoRemap("getStringWidth", true, Integer.TYPE, String.class);
   }

   public int c7312(Object var1, String var2, int var3, int var4, int var5) {
      return this.c7750.c2555(var1, var2, var3, var4, var5);
   }

   public int drawStringWithShadow(Object var1, String var2, float var3, float var4, int var5) {
      return this.drawStringWithShadow.c2555(var1, var2, var3, var4, var5);
   }

   public int c2145(Object var1, String var2, int var3, int var4, int var5) {
      return this.c6731.c2555(var1, var2, var3, var4, var5);
   }

   public int c2000(Object var1, String var2) {
      return this.c521.c2555(var1, var2);
   }

   public int c7740(Object var1) {
      return 10;
   }

   public Object c8903(Object var1) {
      return this.c8297.getObject(var1);
   }
}
