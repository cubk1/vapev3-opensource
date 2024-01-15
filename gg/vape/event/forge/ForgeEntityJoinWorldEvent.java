package gg.vape.event.forge;

import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.EntityJoinWorldEvent;

import java.util.Iterator;

public class ForgeEntityJoinWorldEvent extends ForgeEventHook {
   public ForgeEntityJoinWorldEvent() {
      super("net/minecraftforge/event/entity/EntityJoinWorldEvent", 0);
   }

   public void call(Object var1) {
      EntityJoinWorldEvent var2 = new EntityJoinWorldEvent(var1);
      Iterator var3 = Vape.instance.getModManager().collectMods().iterator();

      while(var3.hasNext()) {
         Mod var4 = (Mod)var3.next();
         if (var4.getState()) {
            var4.onJoinWorld(var2);
         }
      }

   }
}
