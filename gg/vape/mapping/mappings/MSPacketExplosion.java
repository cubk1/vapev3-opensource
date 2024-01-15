package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MSPacketExplosion extends Mapping {
   public final MappingField c4162;
   public final MappingField c8530;
   public final MappingField c7316;

   public MSPacketExplosion() {
      super(MappedClasses.SPacketExplosion);
      this.c4162 = this.getMappingFieldNoRemap("field_149152_f", false, Float.TYPE);
      this.c8530 = this.getMappingFieldNoRemap("field_149153_g", false, Float.TYPE);
      this.c7316 = this.getMappingFieldNoRemap("field_149159_h", false, Float.TYPE);
   }

   public float c8820(Object var1) {
      return this.c4162.getFloat(var1);
   }

   public float c7751(Object var1) {
      return this.c8530.getFloat(var1);
   }

   public float c6244(Object var1) {
      return this.c7316.getFloat(var1);
   }

   public void c7180(Object var1, float var2) {
      this.c4162.setFloat(var1, var2);
   }

   public void c3962(Object var1, float var2) {
      this.c8530.setFloat(var1, var2);
   }

   public void c3021(Object var1, float var2) {
      this.c7316.setFloat(var1, var2);
   }

   // $FF: synthetic method
   public static float c3380(MSPacketExplosion var0, Object var1) {
      return var0.c8820(var1);
   }

   // $FF: synthetic method
   public static float c3267(MSPacketExplosion var0, Object var1) {
      return var0.c7751(var1);
   }

   // $FF: synthetic method
   public static float c6682(MSPacketExplosion var0, Object var1) {
      return var0.c6244(var1);
   }

   // $FF: synthetic method
   public static void c3839(MSPacketExplosion var0, Object var1, float var2) {
      var0.c7180(var1, var2);
   }

   // $FF: synthetic method
   public static void c2436(MSPacketExplosion var0, Object var1, float var2) {
      var0.c3962(var1, var2);
   }

   // $FF: synthetic method
   public static void c3359(MSPacketExplosion var0, Object var1, float var2) {
      var0.c3021(var1, var2);
   }
}
