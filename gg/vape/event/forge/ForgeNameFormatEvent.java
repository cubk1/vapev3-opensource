package gg.vape.event.forge;

import gg.vape.event.impl.EventNameFormat;
import gg.vape.wrapper.impl.PlayerEventNameFormat;

public class ForgeNameFormatEvent extends ForgeEventHook {
   public ForgeNameFormatEvent() {
      super("net/minecraftforge/event/entity/player/PlayerEvent$NameFormat", 0);
   }

   public void call(Object var1) {
      PlayerEventNameFormat var2 = new PlayerEventNameFormat(var1);
      EventNameFormat var3 = new EventNameFormat(var2.c6376(), var2.c693());
      var3.fire();
      var2.c6694(var3.c1336());
   }
}
