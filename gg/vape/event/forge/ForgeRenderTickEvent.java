package gg.vape.event.forge;

import gg.vape.event.hook.hooks.TickEventRenderHook;
import gg.vape.mapping.MappedClasses;
import gg.vape.wrapper.impl.ForgeVersion;

public class ForgeRenderTickEvent extends ForgeEventHook {
   public ForgeRenderTickEvent() {
      super(MappedClasses.TickEvent$RenderTickEvent, ForgeVersion.minorVersion() == 13 ? 3 : 0);
      this.setHookProcessor(new TickEventRenderHook(this));
   }

   public void call(Object var1) {
      this.c3453().c6176(var1);
   }
}
