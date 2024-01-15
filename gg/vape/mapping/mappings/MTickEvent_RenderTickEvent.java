package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MTickEvent_RenderTickEvent extends Mapping {
   public final MappingField c7025;

   public MTickEvent_RenderTickEvent() {
      super(MappedClasses.TickEvent$RenderTickEvent);
      this.c7025 = this.getMappingFieldNoRemap("renderTickTime", false, Float.TYPE);
   }

   public float c8820(Object var1) {
      return this.c7025.getFloat(var1);
   }

   // $FF: synthetic method
   public static float c7730(MTickEvent_RenderTickEvent var0, Object var1) {
      return var0.c8820(var1);
   }
}
