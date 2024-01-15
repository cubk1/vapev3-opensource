package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MRenderWorldLastEvent extends Mapping {
   public final MappingField c3347;

   public MRenderWorldLastEvent() {
      super("net/minecraftforge/client/event/RenderWorldLastEvent");
      this.c3347 = this.getMappingFieldNoRemap("partialTicks", false, Float.TYPE);
   }

   public float c8820(Object var1) {
      return this.c3347.getFloat(var1);
   }

   // $FF: synthetic method
   public static float c2584(MRenderWorldLastEvent var0, Object var1) {
      return var0.c8820(var1);
   }
}
