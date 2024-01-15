package gg.vape.event.hook.hooks;

import gg.vape.event.forge.ForgeEventHook;
import gg.vape.event.hook.HookProcessor;
import gg.vape.event.impl.EventRenderTick;
import gg.vape.wrapper.impl.EventType;
import gg.vape.wrapper.impl.RenderTickEvent;
import gg.vape.wrapper.impl.TickEventPhase;

public class TickEventHook extends HookProcessor {
   public TickEventHook(ForgeEventHook var1) {
      super(var1);
   }

   public void c6176(Object var1) {
      RenderTickEvent var2 = new RenderTickEvent(var1);
      EventRenderTick var3;
      if (var2.c3827().equals(TickEventPhase.c5866())) {
         var3 = new EventRenderTick(EventType.PRE, var2.c6299());
      } else {
         var3 = new EventRenderTick(EventType.POST, var2.c6299());
      }

      var3.fire();
   }
}
