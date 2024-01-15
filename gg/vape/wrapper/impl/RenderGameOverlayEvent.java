package gg.vape.wrapper.impl;

import gg.vape.Vape;

public class RenderGameOverlayEvent extends ForgeEvent {
   public RenderGameOverlayEvent(Object var1) {
      super(var1);

   }

   public boolean c2913() {
      return Vape.instance.getMappings().renderGameOverlayEvent.getElementType() == Vape.instance.getMappings().renderGameOverlayEvent.getType(this.obj);
   }

   public Object getType() {
      return Vape.instance.getMappings().renderGameOverlayEvent.getType(this.obj);
   }

   public float getPartialTicks() {
      return Vape.instance.getMappings().renderGameOverlayEvent.getPartialTicks(this.obj);
   }
}
