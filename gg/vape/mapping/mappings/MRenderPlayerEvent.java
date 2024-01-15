package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MRenderPlayerEvent extends Mapping {
   public final MappingField c1132;
   public final MappingField c8765;

   public MRenderPlayerEvent() {
      super("net/minecraftforge/client/event/RenderPlayerEvent");
      this.c1132 = this.getMappingFieldNoRemap("partialRenderTick", false, Float.TYPE);
      this.c8765 = this.getMappingFieldNoRemap("renderer", false, MappedClasses.RenderPlayer);
   }

   public float c8820(Object var1) {
      return this.c1132.getFloat(var1);
   }

   public Object c8903(Object var1) {
      return this.c8765.getObject(var1);
   }

   // $FF: synthetic method
   public static Object c4984(MRenderPlayerEvent var0, Object var1) {
      return var0.c8903(var1);
   }

   // $FF: synthetic method
   public static float c3497(MRenderPlayerEvent var0, Object var1) {
      return var0.c8820(var1);
   }
}
