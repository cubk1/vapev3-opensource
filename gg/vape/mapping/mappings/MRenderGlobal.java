package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MRenderGlobal extends Mapping {
   public final MappingMethod c77;

   public MRenderGlobal() {
      super(MappedClasses.RenderGlobal);
      this.c77 = this.getMappingMethodNoRemap("loadRenderers", true, Void.TYPE);
   }

   public void c716(Object var1) {
      this.c77.c2642(var1);
   }

   // $FF: synthetic method
   public static void c7371(MRenderGlobal var0, Object var1) {
      var0.c716(var1);
   }
}
