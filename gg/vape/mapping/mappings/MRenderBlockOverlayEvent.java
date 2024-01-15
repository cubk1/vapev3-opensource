package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MRenderBlockOverlayEvent extends Mapping {
   public final MappingField c5286 = this.getMappingFieldNoRemap("overlayType", true, "Lnet/minecraftforge/client/event/RenderBlockOverlayEvent$OverlayType;");

   public MRenderBlockOverlayEvent() {
      super(MappedClasses.RenderBlockOverlayEvent);
   }

   public Object c6780(Object var1) {
      return this.c5286.getObject(var1);
   }

   // $FF: synthetic method
   public static Object overlayType(MRenderBlockOverlayEvent var0, Object var1) {
      return var0.c6780(var1);
   }
}
