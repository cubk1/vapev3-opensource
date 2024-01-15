package gg.vape.event.forge;

import gg.vape.event.impl.EventLivingUpdate;
import gg.vape.wrapper.impl.LivingUpdateEvent;

public class ForgeLivingUpdateEvent extends ForgeEventHook {
   public ForgeLivingUpdateEvent() {
      super("net/minecraftforge/event/entity/living/LivingEvent$LivingUpdateEvent", 0);
   }

   public void call(Object var1) {
      LivingUpdateEvent var2 = new LivingUpdateEvent(var1);
      (new EventLivingUpdate(var2.c4451())).fire();
   }
}
