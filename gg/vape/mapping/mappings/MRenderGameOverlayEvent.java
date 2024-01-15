package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import pub.nextsense.Tweaker;

public class MRenderGameOverlayEvent extends Mapping {
   public final Class c4652 = Tweaker.getClazz("net/minecraftforge/client/event/RenderGameOverlayEvent$ElementType");
   public final MappingField ElementType;
   public final MappingField type;
   public final MappingField partialTicks;

   public MRenderGameOverlayEvent() {
      super("net/minecraftforge/client/event/RenderGameOverlayEvent");
      this.ElementType = new MappingField(this.c4652, "ALL", false, true, this.c4652);
      this.type = this.getMappingFieldNoRemap("type", false, this.c4652);
      this.partialTicks = this.getMappingFieldNoRemap("partialTicks", false, Float.TYPE);
   }

   public Object getElementType() {
      return this.ElementType.getObject(null);
   }

   public Object getType(Object object) {
      return this.type.getObject(object);
   }

   public float getPartialTicks(Object object) {
      return this.partialTicks.getFloat(object);
   }
}
