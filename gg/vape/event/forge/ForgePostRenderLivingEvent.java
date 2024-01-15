package gg.vape.event.forge;

import gg.vape.event.impl.EventPostRenderLiving;
import gg.vape.wrapper.impl.RenderLivingEvent;

public class ForgePostRenderLivingEvent extends ForgeEventHook {
   public ForgePostRenderLivingEvent() {
      super("net/minecraftforge/client/event/RenderLivingEvent$Post", 0);
   }

   public void call(Object var1) {
      RenderLivingEvent var2 = new RenderLivingEvent(var1);
      (new EventPostRenderLiving(var2)).fire();
   }
}
