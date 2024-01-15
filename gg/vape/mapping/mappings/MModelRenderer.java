package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MModelRenderer extends Mapping {
   public final MappingField c5960;
   public final MappingField c1975;
   public final MappingField c1482;
   public final MappingField c4918;
   public final MappingField c1915;
   public final MappingField c6079;
   public final MappingField c5306;
   public final MappingField c4814;
   public final MappingField c6660;
   public final MappingField c8419;
   public final MappingField c3838;

   public MModelRenderer() {
      super("net/minecraft/client/model/ModelRenderer");
      this.c1482 = this.getMappingFieldNoRemap("rotateAngleX", true, Float.TYPE);
      this.c4918 = this.getMappingFieldNoRemap("rotateAngleY", true, Float.TYPE);
      this.c1915 = this.getMappingFieldNoRemap("rotateAngleZ", true, Float.TYPE);
      this.c6079 = this.getMappingFieldNoRemap("offsetX", true, Float.TYPE);
      this.c5306 = this.getMappingFieldNoRemap("offsetY", true, Float.TYPE);
      this.c4814 = this.getMappingFieldNoRemap("offsetZ", true, Float.TYPE);
      this.c6660 = this.getMappingFieldNoRemap("rotationPointX", true, Float.TYPE);
      this.c8419 = this.getMappingFieldNoRemap("rotationPointY", true, Float.TYPE);
      this.c3838 = this.getMappingFieldNoRemap("rotationPointZ", true, Float.TYPE);
      this.c5960 = this.getMappingFieldNoRemap("showModel", true, Boolean.TYPE);
      this.c1975 = this.getMappingFieldNoRemap("isHidden", true, Boolean.TYPE);
   }

   public float c8820(Object var1) {
      return this.c1482.getFloat(var1);
   }

   public float c7751(Object var1) {
      return this.c4918.getFloat(var1);
   }

   public float c6244(Object var1) {
      return this.c1915.getFloat(var1);
   }

   public float c735(Object var1) {
      return this.c6079.getFloat(var1);
   }

   public float c2374(Object var1) {
      return this.c5306.getFloat(var1);
   }

   public float c437(Object var1) {
      return this.c4814.getFloat(var1);
   }

   public float c443(Object var1) {
      return this.c6660.getFloat(var1);
   }

   public float c1721(Object var1) {
      return this.c8419.getFloat(var1);
   }

   public float c4020(Object var1) {
      return this.c3838.getFloat(var1);
   }

   public void c3896(Object var1, boolean var2) {
      this.c5960.setBoolean(var1, var2);
   }

   public void c2771(Object var1, boolean var2) {
      this.c1975.setBoolean(var1, var2);
   }

   // $FF: synthetic method
   public static float c7076(MModelRenderer var0, Object var1) {
      return var0.c8820(var1);
   }

   // $FF: synthetic method
   public static float c5013(MModelRenderer var0, Object var1) {
      return var0.c7751(var1);
   }

   // $FF: synthetic method
   public static float c272(MModelRenderer var0, Object var1) {
      return var0.c6244(var1);
   }

   // $FF: synthetic method
   public static float c1169(MModelRenderer var0, Object var1) {
      return var0.c735(var1);
   }

   // $FF: synthetic method
   public static float c2275(MModelRenderer var0, Object var1) {
      return var0.c2374(var1);
   }

   // $FF: synthetic method
   public static float c5054(MModelRenderer var0, Object var1) {
      return var0.c437(var1);
   }

   // $FF: synthetic method
   public static float c5950(MModelRenderer var0, Object var1) {
      return var0.c443(var1);
   }

   // $FF: synthetic method
   public static float c5094(MModelRenderer var0, Object var1) {
      return var0.c1721(var1);
   }

   // $FF: synthetic method
   public static float c8818(MModelRenderer var0, Object var1) {
      return var0.c4020(var1);
   }

   // $FF: synthetic method
   public static void c1917(MModelRenderer var0, Object var1, boolean var2) {
      var0.c3896(var1, var2);
   }

   // $FF: synthetic method
   public static void c3252(MModelRenderer var0, Object var1, boolean var2) {
      var0.c2771(var1, var2);
   }
}
