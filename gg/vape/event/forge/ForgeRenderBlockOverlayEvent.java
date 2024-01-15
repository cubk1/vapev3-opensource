package gg.vape.event.forge;

import gg.vape.event.impl.EventRenderBlockOverlay;
import gg.vape.mapping.MappedClasses;
import gg.vape.wrapper.impl.RenderBlockOverlayEvent;

public class ForgeRenderBlockOverlayEvent extends ForgeEventHook {
   public ForgeRenderBlockOverlayEvent() {
      super(MappedClasses.RenderBlockOverlayEvent, 0);
   }

   public void call(Object var1) {
      RenderBlockOverlayEvent var2 = new RenderBlockOverlayEvent(var1);
      (new EventRenderBlockOverlay(var2)).fire();
   }
}
