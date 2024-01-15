package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MSPacketEntityVelocity extends Mapping {
   public final MappingField c5208;
   public final MappingField c2596;
   public final MappingField c6395;
   public final MappingField c7732;

   public MSPacketEntityVelocity() {
      super(MappedClasses.SPacketEntityVelocity);
      this.c5208 = this.getMappingFieldNoRemap("field_149417_a", false, Integer.TYPE);
      this.c2596 = this.getMappingFieldNoRemap("field_149415_b", false, Integer.TYPE);
      this.c6395 = this.getMappingFieldNoRemap("field_149416_c", false, Integer.TYPE);
      this.c7732 = this.getMappingFieldNoRemap("field_149414_d", false, Integer.TYPE);
   }

   public int c7740(Object var1) {
      return this.c5208.getInt(var1);
   }

   public int c4023(Object var1) {
      return this.c2596.getInt(var1);
   }

   public int c6882(Object var1) {
      return this.c6395.getInt(var1);
   }

   public int c2099(Object var1) {
      return this.c7732.getInt(var1);
   }

   public void c7403(Object var1, int var2) {
      this.c2596.setInt(var1, var2);
   }

   public void c2803(Object var1, int var2) {
      this.c6395.setInt(var1, var2);
   }

   public void c2185(Object var1, int var2) {
      this.c7732.setInt(var1, var2);
   }

   // $FF: synthetic method
   public static int c5370(MSPacketEntityVelocity var0, Object var1) {
      return var0.c7740(var1);
   }

   // $FF: synthetic method
   public static int c583(MSPacketEntityVelocity var0, Object var1) {
      return var0.c4023(var1);
   }

   // $FF: synthetic method
   public static int c8602(MSPacketEntityVelocity var0, Object var1) {
      return var0.c6882(var1);
   }

   // $FF: synthetic method
   public static int c1060(MSPacketEntityVelocity var0, Object var1) {
      return var0.c2099(var1);
   }

   // $FF: synthetic method
   public static void c4282(MSPacketEntityVelocity var0, Object var1, int var2) {
      var0.c7403(var1, var2);
   }

   // $FF: synthetic method
   public static void c7283(MSPacketEntityVelocity var0, Object var1, int var2) {
      var0.c2803(var1, var2);
   }

   // $FF: synthetic method
   public static void c6367(MSPacketEntityVelocity var0, Object var1, int var2) {
      var0.c2185(var1, var2);
   }
}
