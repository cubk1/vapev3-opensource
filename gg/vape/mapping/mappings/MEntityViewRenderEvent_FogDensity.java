package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MEntityViewRenderEvent_FogDensity extends Mapping {
   public final MappingField c3530;

   public MEntityViewRenderEvent_FogDensity() {
      super("net/minecraftforge/client/event/EntityViewRenderEvent$FogDensity");
      this.c3530 = this.getMappingFieldNoRemap("density", false, Float.TYPE);
   }

   public float c8820(Object var1) {
      return this.c3530.getFloat(var1);
   }

   public void c7180(Object var1, float var2) {
      this.c3530.setFloat(var1, var2);
   }

   // $FF: synthetic method
   public static float c1698(MEntityViewRenderEvent_FogDensity var0, Object var1) {
      return var0.c8820(var1);
   }

   // $FF: synthetic method
   public static void c4128(MEntityViewRenderEvent_FogDensity var0, Object var1, float var2) {
      var0.c7180(var1, var2);
   }
}
