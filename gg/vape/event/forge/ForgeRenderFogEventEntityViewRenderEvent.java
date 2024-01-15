package gg.vape.event.forge;

import gg.vape.event.impl.EventRenderFog;
import gg.vape.wrapper.impl.EntityViewRenderEventRenderFogEvent;

public class ForgeRenderFogEventEntityViewRenderEvent extends ForgeEventHook {
   public ForgeRenderFogEventEntityViewRenderEvent() {
      super("net/minecraftforge/client/event/EntityViewRenderEvent$RenderFogEvent", 0);
   }

   public void call(Object var1) {
      EntityViewRenderEventRenderFogEvent var2 = new EntityViewRenderEventRenderFogEvent(var1);
      (new EventRenderFog(var2, var2.c8487(), var2.c861(), var2.c8223(), var2.c63(), var2.c341(), var2.c4311())).fire();
   }
}
