package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MRender extends Mapping {
   public final MappingMethod c3306;

   public MRender() {
      super(MappedClasses.Render);
      this.c3306 = this.getMappingMethodNoRemap("doRender", true, Void.TYPE, MappedClasses.Entity, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
   }

   public void c6819(Object var1, Object var2, double var3, double var5, double var7, float var9, float var10) {
      this.c3306.c2642(var1, var2, var3, var5, var7, var9, var10);
   }
}
