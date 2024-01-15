package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MVec3I extends Mapping {
   public final MappingField c8273;
   public final MappingField c4503;
   public final MappingField c3639;

   public MVec3I() {
      super(MappedClasses.Vec3i);
      this.c8273 = this.getMappingFieldNoRemap("x", true, Integer.TYPE);
      this.c4503 = this.getMappingFieldNoRemap("y", true, Integer.TYPE);
      this.c3639 = this.getMappingFieldNoRemap("z", true, Integer.TYPE);
   }

   public int c7740(Object var1) {
      return this.c8273.getInt(var1);
   }

   public int c4023(Object var1) {
      return this.c4503.getInt(var1);
   }

   public int c6882(Object var1) {
      return this.c3639.getInt(var1);
   }
}
