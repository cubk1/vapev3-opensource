package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MRenderHandEvent extends Mapping {
   public final MappingField c4270;

   public MRenderHandEvent() {
      super("net/minecraftforge/client/event/RenderHandEvent");
      this.c4270 = this.getMappingFieldNoRemap("partialTicks", false, Float.TYPE);
   }

   public float c8820(Object var1) {
      return this.c4270.getFloat(var1);
   }

   // $FF: synthetic method
   public static float c2254(MRenderHandEvent var0, Object var1) {
      return var0.c8820(var1);
   }
}
