package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MEntityViewRenderEvent_RenderFogEvent extends Mapping {
   public final MappingField c4866;
   public final MappingField c4979;

   public MEntityViewRenderEvent_RenderFogEvent() {
      super("net/minecraftforge/client/event/EntityViewRenderEvent$RenderFogEvent");
      this.c4866 = this.getMappingFieldNoRemap("fogMode", false, Integer.TYPE);
      this.c4979 = this.getMappingFieldNoRemap("farPlaneDistance", false, Float.TYPE);
   }

   public int c7740(Object var1) {
      return this.c4866.getInt(var1);
   }

   public float c7751(Object var1) {
      return this.c4979.getFloat(var1);
   }

   // $FF: synthetic method
   public static int c8675(MEntityViewRenderEvent_RenderFogEvent var0, Object var1) {
      return var0.c7740(var1);
   }

   // $FF: synthetic method
   public static float c2789(MEntityViewRenderEvent_RenderFogEvent var0, Object var1) {
      return var0.c7751(var1);
   }
}
