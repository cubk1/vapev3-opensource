package gg.vape.event.forge;

import gg.vape.module.utility.invcleaner.EventPreRenderPlayer;
import gg.vape.wrapper.impl.RenderPlayerEvent;

public class ForgePreRenderPlayerEvent extends ForgeEventHook {
   public ForgePreRenderPlayerEvent() {
      super("net/minecraftforge/client/event/RenderPlayerEvent$Pre", 0);
   }

   public void call(Object var1) {
      RenderPlayerEvent var2 = new RenderPlayerEvent(var1);
      (new EventPreRenderPlayer(var2)).fire();
   }
}
