package gg.vape.event.hook;

import gg.vape.event.forge.ForgeEventHook;

public abstract class HookProcessor {
   public final ForgeEventHook hook;

   public HookProcessor(ForgeEventHook hook) {
      this.hook = hook;
   }

   public abstract void c6176(Object var1);

   public ForgeEventHook c8478() {
      return this.hook;
   }
}
