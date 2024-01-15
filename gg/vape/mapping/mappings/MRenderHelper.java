package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MRenderHelper extends Mapping {
   public final MappingMethod c3161;
   public final MappingMethod c7423;

   public MRenderHelper() {
      super(MappedClasses.RenderHelper);
      this.c3161 = this.getMappingMethod("disableStandardItemLighting", true, Void.TYPE);
      this.c7423 = this.getMappingMethod("enableStandardItemLighting", true, Void.TYPE);
   }

   public void c8481() {
      this.c3161.c2642(null);
   }

   public void c7951() {
      this.c7423.c2642(null);
   }

   // $FF: synthetic method
   public static void c6764(MRenderHelper var0) {
      var0.c8481();
   }

   // $FF: synthetic method
   public static void c4696(MRenderHelper var0) {
      var0.c7951();
   }
}
