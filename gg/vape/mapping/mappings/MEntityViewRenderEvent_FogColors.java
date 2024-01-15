package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MEntityViewRenderEvent_FogColors extends Mapping {
   public final MappingField c6513;
   public final MappingField c2719;
   public final MappingField c2034;

   public MEntityViewRenderEvent_FogColors() {
      super("net/minecraftforge/client/event/EntityViewRenderEvent$FogColors");
      this.c6513 = this.getMappingFieldNoRemap("red", false, Float.TYPE);
      this.c2719 = this.getMappingFieldNoRemap("green", false, Float.TYPE);
      this.c2034 = this.getMappingFieldNoRemap("blue", false, Float.TYPE);
   }

   public float c8820(Object var1) {
      return this.c6513.getFloat(var1);
   }

   public float c7751(Object var1) {
      return this.c2719.getFloat(var1);
   }

   public float c6244(Object var1) {
      return this.c2034.getFloat(var1);
   }

   public void c7180(Object var1, float var2) {
      this.c6513.setFloat(var1, var2);
   }

   public void c3962(Object var1, float var2) {
      this.c2719.setFloat(var1, var2);
   }

   public void c3021(Object var1, float var2) {
      this.c2034.setFloat(var1, var2);
   }

   // $FF: synthetic method
   public static float c1587(MEntityViewRenderEvent_FogColors var0, Object var1) {
      return var0.c8820(var1);
   }

   // $FF: synthetic method
   public static float c7775(MEntityViewRenderEvent_FogColors var0, Object var1) {
      return var0.c7751(var1);
   }

   // $FF: synthetic method
   public static float c3091(MEntityViewRenderEvent_FogColors var0, Object var1) {
      return var0.c6244(var1);
   }

   // $FF: synthetic method
   public static void c4585(MEntityViewRenderEvent_FogColors var0, Object var1, float var2) {
      var0.c7180(var1, var2);
   }

   // $FF: synthetic method
   public static void c2733(MEntityViewRenderEvent_FogColors var0, Object var1, float var2) {
      var0.c3962(var1, var2);
   }

   // $FF: synthetic method
   public static void c3539(MEntityViewRenderEvent_FogColors var0, Object var1, float var2) {
      var0.c3021(var1, var2);
   }
}
