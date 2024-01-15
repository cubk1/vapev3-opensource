package gg.vape.event.forge;

import gg.vape.event.impl.EventPreRenderLivingEvent;
import gg.vape.wrapper.impl.RenderLivingEvent_Specials_Pre;

public class ForgePreRenderLivingEventPre extends ForgeEventHook {
   public ForgePreRenderLivingEventPre() {
      super("net/minecraftforge/client/event/RenderLivingEvent$Specials$Pre", 0);
   }

   public void call(Object var1) {
      RenderLivingEvent_Specials_Pre var2 = new RenderLivingEvent_Specials_Pre(var1);
      (new EventPreRenderLivingEvent(var2)).fire();
   }
}
