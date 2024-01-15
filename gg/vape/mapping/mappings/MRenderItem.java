package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MRenderItem extends Mapping {
   public MappingField c6167;
   public MappingMethod c2671;
   public MappingMethod c2069;
   public MappingMethod c7560;
   public MappingMethod c8950;
   public MappingMethod c4840;

   public MRenderItem() {
      super(MappedClasses.RenderItem);
      if (ForgeVersion.minorVersion() == 13) {
         this.c2671 = this.getMappingMethod("getInstance", false, MappedClasses.RenderItem);
         this.c2069 = this.getMappingMethodNoRemap("renderItemIntoGUI", true, Void.TYPE, MappedClasses.FontRenderer, MappedClasses.TextureManager, MappedClasses.ItemStack, Integer.TYPE, Integer.TYPE);
         this.c7560 = this.getMappingMethodNoRemap("renderItemOverlayIntoGUI", true, Void.TYPE, MappedClasses.FontRenderer, MappedClasses.TextureManager, MappedClasses.ItemStack, Integer.TYPE, Integer.TYPE);
      } else {
         this.c6167 = this.getMappingFieldNoRemap("zLevel", true, Float.TYPE);
         this.c8950 = this.getMappingMethodNoRemap("renderItemIntoGUI", true, Void.TYPE, MappedClasses.ItemStack, Integer.TYPE, Integer.TYPE);
         this.c4840 = this.getMappingMethodNoRemap("renderItemOverlays", true, Void.TYPE, MappedClasses.FontRenderer, MappedClasses.ItemStack, Integer.TYPE, Integer.TYPE);
      }

   }

   public Object c6031() {
      return this.c2671.invoke(null);
   }

   public void c8949(Object var1, Object var2, Object var3, Object var4, int var5, int var6) {
      this.c2069.c2642(var1, var2, var3, var4, var5, var6);
   }

   public void c1237(Object var1, Object var2, int var3, int var4) {
      this.c8950.c2642(var1, var2, var3, var4);
   }

   public void c5222(Object var1, Object var2, Object var3, Object var4, int var5, int var6) {
      this.c7560.c2642(var1, var2, var3, var4, var5, var6);
   }

   public void c6890(Object var1, Object var2, Object var3, int var4, int var5) {
      this.c4840.c2642(var1, var2, var3, var4, var5);
   }

   public float c8820(Object var1) {
      return this.c6167.getFloat(var1);
   }

   // $FF: synthetic method
   public static Object c1015(MRenderItem var0) {
      return var0.c6031();
   }

   // $FF: synthetic method
   public static void c7891(MRenderItem var0, Object var1, Object var2, Object var3, Object var4, int var5, int var6) {
      var0.c8949(var1, var2, var3, var4, var5, var6);
   }

   // $FF: synthetic method
   public static void c426(MRenderItem var0, Object var1, Object var2, int var3, int var4) {
      var0.c1237(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static void c8758(MRenderItem var0, Object var1, Object var2, Object var3, Object var4, int var5, int var6) {
      var0.c5222(var1, var2, var3, var4, var5, var6);
   }

   // $FF: synthetic method
   public static void c1727(MRenderItem var0, Object var1, Object var2, Object var3, int var4, int var5) {
      var0.c6890(var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   public static float c3987(MRenderItem var0, Object var1) {
      return var0.c8820(var1);
   }
}
