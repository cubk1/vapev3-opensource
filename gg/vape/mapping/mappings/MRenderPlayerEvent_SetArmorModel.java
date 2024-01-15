package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MRenderPlayerEvent_SetArmorModel extends Mapping {
   public final MappingField c451;

   public MRenderPlayerEvent_SetArmorModel() {
      super("net/minecraftforge/client/event/RenderPlayerEvent$SetArmorModel");
      this.c451 = this.getMappingFieldNoRemap("result", true, Integer.TYPE);
   }

   public void c7403(Object var1, int var2) {
      this.c451.setInt(var1, var2);
   }

   public int c7740(Object var1) {
      return this.c451.getInt(var1);
   }

   // $FF: synthetic method
   public static void c8663(MRenderPlayerEvent_SetArmorModel var0, Object var1, int var2) {
      var0.c7403(var1, var2);
   }

   // $FF: synthetic method
   public static int c8859(MRenderPlayerEvent_SetArmorModel var0, Object var1) {
      return var0.c7740(var1);
   }
}
