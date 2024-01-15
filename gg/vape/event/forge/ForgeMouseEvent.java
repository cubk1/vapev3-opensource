package gg.vape.event.forge;

import gg.vape.event.impl.EventMouse;

public class ForgeMouseEvent extends ForgeEventHook {
   public ForgeMouseEvent() {
      super("net/minecraftforge/client/event/MouseEvent", 0);
   }

   public void call(Object var1) {
      (new EventMouse(var1)).fire();
   }
}
