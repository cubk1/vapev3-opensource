package gg.vape.event.forge;

import gg.vape.event.hook.hooks.RenderGameOverlayEventHook;

public class ForgePostRenderGameOverlayEvent extends ForgeEventHook {
   public ForgePostRenderGameOverlayEvent() {
      super("net/minecraftforge/client/event/RenderGameOverlayEvent$Post", 0);
      this.setHookProcessor(new RenderGameOverlayEventHook(this));
   }

   public void call(Object var1) {
      this.c3453().c6176(var1);
   }
}
