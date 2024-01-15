package gg.vape.event.forge;

import gg.vape.event.impl.EventFogDensity;
import gg.vape.wrapper.impl.EntityViewRenderEvent;

public class ForgeFogDensityEntityViewRenderEvent extends ForgeEventHook {
   public ForgeFogDensityEntityViewRenderEvent() {
      super("net/minecraftforge/client/event/EntityViewRenderEvent$FogDensity", 0);
   }

   public void call(Object var1) {
      EntityViewRenderEvent var2 = new EntityViewRenderEvent(var1);
      EventFogDensity var3 = new EventFogDensity(var2, var2.c8487(), var2.c861(), var2.c8223(), var2.c63(), var2.c8901());
      var3.fire();
      var2.c6025(var3.c1081());
   }
}
