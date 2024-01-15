package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MRenderPlayerEvent_Specials_Pre extends Mapping {
   public final MappingField c7301;
   public final MappingField c6695;
   public final MappingField c6490;

   public MRenderPlayerEvent_Specials_Pre() {
      super("net/minecraftforge/client/event/RenderPlayerEvent$Specials$Pre");
      this.c7301 = this.getMappingFieldNoRemap("renderHelmet", true, Boolean.TYPE);
      this.c6695 = this.getMappingFieldNoRemap("renderCape", true, Boolean.TYPE);
      this.c6490 = this.getMappingFieldNoRemap("renderItem", true, Boolean.TYPE);
   }

   public void c3896(Object var1, boolean var2) {
      this.c7301.setBoolean(var1, var2);
   }

   public void c2771(Object var1, boolean var2) {
      this.c6695.setBoolean(var1, var2);
   }

   public void c879(Object var1, boolean var2) {
      this.c6490.setBoolean(var1, var2);
   }

   // $FF: synthetic method
   public static void c8518(MRenderPlayerEvent_Specials_Pre var0, Object var1, boolean var2) {
      var0.c3896(var1, var2);
   }

   // $FF: synthetic method
   public static void c4238(MRenderPlayerEvent_Specials_Pre var0, Object var1, boolean var2) {
      var0.c2771(var1, var2);
   }

   // $FF: synthetic method
   public static void c4833(MRenderPlayerEvent_Specials_Pre var0, Object var1, boolean var2) {
      var0.c879(var1, var2);
   }
}
