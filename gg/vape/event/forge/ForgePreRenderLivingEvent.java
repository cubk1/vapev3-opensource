package gg.vape.event.forge;

import gg.vape.event.impl.EventPreRenderLiving;
import gg.vape.wrapper.impl.RenderLivingEvent;

public class ForgePreRenderLivingEvent extends ForgeEventHook {
   public ForgePreRenderLivingEvent() {
      super("net/minecraftforge/client/event/RenderLivingEvent$Pre", 0);
   }

   public void call(Object var1) {
      RenderLivingEvent var2 = new RenderLivingEvent(var1);
      (new EventPreRenderLiving(var2)).fire();
   }
}
