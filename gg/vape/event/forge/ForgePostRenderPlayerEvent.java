package gg.vape.event.forge;

import gg.vape.event.impl.EventPostRenderPlayer;
import gg.vape.wrapper.impl.RenderPlayerEvent;

public class ForgePostRenderPlayerEvent extends ForgeEventHook {
   public ForgePostRenderPlayerEvent() {
      super("net/minecraftforge/client/event/RenderPlayerEvent$Post", 0);
   }

   public void call(Object var1) {
      RenderPlayerEvent var2 = new RenderPlayerEvent(var1);
      (new EventPostRenderPlayer(var2)).fire();
   }
}
