package gg.vape.event.forge;

import gg.vape.event.impl.EventRenderHand;
import gg.vape.wrapper.impl.RenderHandEvent;

public class ForgeRenderHandEvent extends ForgeEventHook {
   public ForgeRenderHandEvent() {
      super("net/minecraftforge/client/event/RenderHandEvent", 0);
   }

   public void call(Object var1) {
      RenderHandEvent var2 = new RenderHandEvent(var1);
      (new EventRenderHand(var2.c6299())).fire();
   }
}
