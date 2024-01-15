package gg.vape.wrapper.impl;

import gg.vape.Vape;
import gg.vape.mapping.mappings.MRenderBlockOverlayEvent;

public class RenderBlockOverlayEvent extends ForgeEvent {
   public RenderBlockOverlayEvent(Object var1) {
      super(var1);
   }

   public Object c5366() {
      return MRenderBlockOverlayEvent.overlayType(Vape.instance.getMappings().renderBlockOverlayEvent, this.obj);
   }
}
