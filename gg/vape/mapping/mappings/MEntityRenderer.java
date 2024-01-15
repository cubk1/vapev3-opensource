package gg.vape.mapping.mappings;

import gg.vape.asm.helper.DescUtils;
import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MEntityRenderer extends Mapping {
   public final MappingField c5591;
   public final MappingField c3020;
   public final MappingField c5553;
   public final MappingField c6959;
   public final MappingField c7681;
   public MappingField c93;
   public final MappingMethod c2478;
   public final MappingMethod c8668;
   public final MappingMethod c7390;
   public final MappingMethod c4453;
   public final MappingMethod c4469;

   public MEntityRenderer() {
      super("net/minecraft/client/renderer/EntityRenderer");
      this.c5591 = this.getMappingFieldNoRemap("pointedEntity", true, MappedClasses.Entity);
      this.c3020 = this.getMappingFieldNoRemap("resourceManager", true, MappedClasses.IResourceManager);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c5553 = this.getMappingField("SHADERS_TEXTURES", true, DescUtils.getArrayType(MappedClasses.ResourceLocation));
      } else {
         this.c5553 = this.getMappingField("shaderResourceLocations", true, DescUtils.getArrayType(MappedClasses.ResourceLocation));
      }

      this.c6959 = this.getMappingFieldNoRemap("theShaderGroup", true, MappedClasses.ShaderGroup);
      this.c7681 = this.getMappingFieldNoRemap("fogStandard", true, Boolean.TYPE);
      this.c2478 = this.getMappingMethodNoRemap("setupCameraTransform", true, Void.TYPE, Float.TYPE, Integer.TYPE);
      this.c4453 = this.getMappingMethodNoRemap("updateShaderGroupSize", true, Void.TYPE, Integer.TYPE, Integer.TYPE);
      if (ForgeVersion.minorVersion() > 13) {
         this.c8668 = this.getMappingMethodNoRemap("disableLightmap", true, Void.TYPE);
         this.c7390 = this.getMappingMethodNoRemap("enableLightmap", true, Void.TYPE);
         this.c93 = this.getMappingFieldNoRemap("useShader", true, Boolean.TYPE);
         this.c4469 = this.getMappingMethodNoRemap("func_181560_a", false, Void.TYPE, Float.TYPE, Long.TYPE);
      } else {
         this.c8668 = this.getMappingMethodNoRemap("disableLightmap", true, Void.TYPE, Double.TYPE);
         this.c7390 = this.getMappingMethodNoRemap("enableLightmap", true, Void.TYPE, Double.TYPE);
         this.c4469 = this.getMappingMethodNoRemap("func_78480_b", false, Void.TYPE, Float.TYPE);
      }

   }

   public Object c6780(Object var1) {
      return this.c5591.getObject(var1);
   }

   public void c6771(Object var1, Object var2) {
      this.c5591.setObject(var1, var2);
   }

   public void c1254(Object var1, float var2, int var3) {
      this.c2478.c2642(var1, var2, var3);
   }

   public void c2636(Object var1, double var2) {
      if (ForgeVersion.minorVersion() > 13) {
         this.c8668.c2642(var1);
      } else {
         this.c8668.c2642(var1, var2);
      }

   }

   public void c1122(Object var1, double var2) {
      if (ForgeVersion.minorVersion() > 13) {
         this.c7390.c2642(var1);
      } else {
         this.c7390.c2642(var1, var2);
      }

   }

   public Object c8903(Object var1) {
      return this.c3020.getObject(var1);
   }

   public Object[] c7079() {
      return this.c5553.getObjectArray(null);
   }

   public void c5700(Object var1, Object var2) {
      this.c6959.setObject(var1, var2);
   }

   public void c3896(Object var1, boolean var2) {
      this.c93.setBoolean(var1, var2);
   }

   public boolean c2418(Object var1) {
      return this.c93.getBoolean(var1);
   }

   public void c5976(Object var1, int var2, int var3) {
      this.c4453.c2642(var1, var2, var3);
   }

   public void c7815(Object var1, float var2, long var3) {
      this.c4469.c2642(var1, var2);
   }

   public void c2771(Object var1, boolean var2) {
      this.c7681.setBoolean(var1, var2);
   }

   // $FF: synthetic method
   public static Object c6686(MEntityRenderer var0, Object var1) {
      return var0.c6780(var1);
   }

   // $FF: synthetic method
   public static void c553(MEntityRenderer var0, Object var1, Object var2) {
      var0.c6771(var1, var2);
   }

   // $FF: synthetic method
   public static void c4950(MEntityRenderer var0, Object var1, float var2, int var3) {
      var0.c1254(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void c233(MEntityRenderer var0, Object var1, double var2) {
      var0.c2636(var1, var2);
   }

   // $FF: synthetic method
   public static void c5004(MEntityRenderer var0, Object var1, double var2) {
      var0.c1122(var1, var2);
   }

   // $FF: synthetic method
   public static Object c2961(MEntityRenderer var0, Object var1) {
      return var0.c8903(var1);
   }

   // $FF: synthetic method
   public static Object[] c5608(MEntityRenderer var0) {
      return var0.c7079();
   }

   // $FF: synthetic method
   public static void c7136(MEntityRenderer var0, Object var1, Object var2) {
      var0.c5700(var1, var2);
   }

   // $FF: synthetic method
   public static void c1006(MEntityRenderer var0, Object var1, boolean var2) {
      var0.c3896(var1, var2);
   }

   // $FF: synthetic method
   public static boolean c8101(MEntityRenderer var0, Object var1) {
      return var0.c2418(var1);
   }

   // $FF: synthetic method
   public static void c6695(MEntityRenderer var0, Object var1, int var2, int var3) {
      var0.c5976(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void c3877(MEntityRenderer var0, Object var1, float var2, long var3) {
      var0.c7815(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void c1519(MEntityRenderer var0, Object var1, boolean var2) {
      var0.c2771(var1, var2);
   }
}
