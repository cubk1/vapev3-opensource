package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.module.other.SelfDestruct;
import gg.vape.module.none.ClickGui;
import gg.vape.wrapper.impl.ForgeEvent;
import org.lwjgl.input.Keyboard;

public class EventTick extends EventRenderPlayer {
   public EventTick(ForgeEvent var1, int var2) {
      super(var1);
      this.eventType = var2;
   }

   public boolean fire() {

      for (Mod mod : Vape.instance.getModManager().collectMods()) {
         if (mod instanceof ClickGui) {
            ((ClickGui) mod).processTick(this);
         }

         if (mod.getState()) {
            mod.onTick(this);
         }
      }

      if (Keyboard.isKeyDown(29) && Keyboard.isKeyDown(199) && this.eventType == 1) {
         try {
            Thread.sleep(1000L);
         } catch (InterruptedException var3) {
            var3.printStackTrace();
         }

         Vape.instance.getModManager().getMod(SelfDestruct.class).setState(true);
      }

      return this.c5586();
   }
}
