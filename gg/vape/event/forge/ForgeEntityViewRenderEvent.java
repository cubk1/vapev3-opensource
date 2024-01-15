package gg.vape.event.forge;

import gg.vape.event.impl.EventFogColors;
import gg.vape.wrapper.impl.EntityViewRenderEventFogColors;

public class ForgeEntityViewRenderEvent extends ForgeEventHook {
   public ForgeEntityViewRenderEvent() {
      super("net/minecraftforge/client/event/EntityViewRenderEvent$FogColors", 0);
   }

   public void call(Object var1) {
      EntityViewRenderEventFogColors var2 = new EntityViewRenderEventFogColors(var1);
      EventFogColors var3 = new EventFogColors(var2, var2.c8487(), var2.c861(), var2.c8223(), var2.c63(), var2.c8901(), var2.c4311(), var2.c2646());
      var3.fire();
      var2.c6025(var3.c1081());
      var2.c8528(var3.c8948());
      var2.c8393(var3.c8599());
   }
}
