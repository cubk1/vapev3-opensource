package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.event.Event;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.RenderBlockOverlayEvent;

import java.util.Iterator;

public class EventRenderBlockOverlay extends Event {
   public final RenderBlockOverlayEvent c7923;
   public final Object c5292;

   public EventRenderBlockOverlay(RenderBlockOverlayEvent var1) {
      this.c7923 = var1;
      this.c5292 = var1.c5366();
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         if (var2.getState()) {
            var2.onRenderBlockOverlay(this);
         }
      }

      return this.c5586();
   }

   public Object overlayType() {
      return this.c5292;
   }

   public RenderBlockOverlayEvent getNativeEvent() {
      return this.c7923;
   }
}
