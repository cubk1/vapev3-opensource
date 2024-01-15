package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MRayTraceResult_Type extends Mapping {
   public final MappingField c6907;
   public final MappingField c6279;

   public MRayTraceResult_Type() {
      super(MappedClasses.RayTraceResult$Type);
      this.c6907 = this.getMappingField("MISS", false, MappedClasses.RayTraceResult$Type);
      this.c6279 = this.getMappingField("BLOCK", false, MappedClasses.RayTraceResult$Type);
   }

   public Object c6031() {
      return this.c6907.getObject(null);
   }

   public Object c7468() {
      return this.c6279.getObject(null);
   }

   // $FF: synthetic method
   public static Object c1882(MRayTraceResult_Type var0) {
      return var0.c7468();
   }
}
