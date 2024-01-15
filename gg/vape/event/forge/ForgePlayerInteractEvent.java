package gg.vape.event.forge;

import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.PlayerInteractEvent;

import java.util.Iterator;

public class ForgePlayerInteractEvent extends ForgeEventHook {
   public ForgePlayerInteractEvent() {
      super("net/minecraftforge/event/entity/player/PlayerInteractEvent", 0);
   }

   public void call(Object var1) {
      PlayerInteractEvent var2 = new PlayerInteractEvent(var1);
      Iterator var3 = Vape.instance.getModManager().collectMods().iterator();

      while(var3.hasNext()) {
         Mod var4 = (Mod)var3.next();
         if (var4.getState()) {
            var4.onInteract(var2);
         }
      }

   }
}
