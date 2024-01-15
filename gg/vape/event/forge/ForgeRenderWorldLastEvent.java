package gg.vape.event.forge;

import gg.vape.event.impl.EventRender3D;
import gg.vape.wrapper.impl.RenderWorldLastEvent;

public class ForgeRenderWorldLastEvent extends ForgeEventHook {
   public ForgeRenderWorldLastEvent() {
      super("net/minecraftforge/client/event/RenderWorldLastEvent", 0);
   }

   public void call(Object var1) {
      RenderWorldLastEvent var2 = new RenderWorldLastEvent(var1);
      (new EventRender3D(var2.c6299())).fire();
   }
}
