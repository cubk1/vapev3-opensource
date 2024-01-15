package gg.vape.event.forge;

import gg.vape.Vape;
import gg.vape.event.impl.EventTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.wrapper.impl.*;
import pub.nextsense.common.d;

public class ForgeClientTickEvent extends ForgeEventHook {
   public ForgeClientTickEvent() {
      super(MappedClasses.TickEvent$ClientTickEvent, ForgeVersion.minorVersion() == 13 ? 3 : 0);
   }

   public void call(Object var1) {
      if (Vape.instance.c7302()) {
         Minecraft.c8115(new GuiScreen(d.getGuiObject()));
         Vape.instance.c8477(false);
      }

      TickEvent var2 = new TickEvent(var1);
      EventTick var3;
      if (var2.c3827().equals(TickEventPhase.c5866())) {
         var3 = new EventTick(var2, EventType.PRE);
      } else {
         var3 = new EventTick(var2, EventType.POST);
      }

      var3.fire();
   }
}
