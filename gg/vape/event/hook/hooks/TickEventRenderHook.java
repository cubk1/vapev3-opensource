package gg.vape.event.hook.hooks;

import gg.vape.Vape;
import gg.vape.event.forge.ForgeEventHook;
import gg.vape.event.hook.HookProcessor;

public class TickEventRenderHook extends HookProcessor {
   public boolean c1171 = false;

   public TickEventRenderHook(ForgeEventHook var1) {
      super(var1);
   }

   public void c6176(Object var1) {
      if (!this.c1171) {
         Vape.instance.c4956();
         Vape.instance.getEventManager().c5069(true);
         this.c1171 = true;
      }

   }
}
