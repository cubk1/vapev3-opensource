package gg.vape.event.forge;

import gg.vape.event.impl.EventPlayerTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.wrapper.impl.*;

public class ForgePlayerTickEvent extends ForgeEventHook {
   public ForgePlayerTickEvent() {
      super(MappedClasses.TickEvent$PlayerTickEvent, ForgeVersion.minorVersion() == 13 ? 3 : 0);
   }

   public void call(Object var1) {
      PlayerTickEvent var2 = new PlayerTickEvent(var1);
      if (var2.c1170().equals(Minecraft.thePlayer())) {
         EventPlayerTick var3;
         if (var2.c3827().equals(TickEventPhase.c5866())) {
            var3 = new EventPlayerTick(var2.c1170(), EventType.PRE);
         } else {
            var3 = new EventPlayerTick(var2.c1170(), EventType.POST);
         }

         var3.fire();
      }
   }
}
