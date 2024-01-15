package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MRayTraceResult_Type;
import gg.vape.wrapper.Wrapper;

public class RayTraceResult_type extends Wrapper {
   public RayTraceResult_type(Object var1) {
      super(var1);
   }

   public static RayTraceResult_type c3161() {
      return new RayTraceResult_type(vape.getMappings().rayTraceResult_type.c6031());
   }

   public static RayTraceResult_type c3865() {
      return new RayTraceResult_type(MRayTraceResult_Type.c1882(vape.getMappings().rayTraceResult_type));
   }
}
