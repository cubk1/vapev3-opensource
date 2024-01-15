package gg.vape.event.forge;

import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.PlaySoundAtEntityEvent;

import java.util.Iterator;

public class ForgePlaySoundAtEntityEvent extends ForgeEventHook {
   public ForgePlaySoundAtEntityEvent() {
      super("net/minecraftforge/event/entity/PlaySoundAtEntityEvent", 0);
   }

   public void call(Object var1) {
      PlaySoundAtEntityEvent var2 = new PlaySoundAtEntityEvent(var1);
      Iterator var3 = Vape.instance.getModManager().collectMods().iterator();

      while(var3.hasNext()) {
         Mod var4 = (Mod)var3.next();
         if (var4.getState()) {
            var4.onPlaySoundAtEntity(var2);
         }
      }

   }
}
