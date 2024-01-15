package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.event.Event;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.Entity;

public class EventSetSprinting extends Event {
   public final Entity c8513;
   public final boolean c1328;

   public EventSetSprinting(Object var1, boolean var2) {
      this.c8513 = new Entity(var1);
      this.c1328 = var2;
   }

   public Entity c5925() {
      return this.c8513;
   }

   public boolean c1446() {
      return this.c1328;
   }

   public boolean fire() {

      for (Mod var2 : Vape.instance.getModManager().collectMods()) {
         if (var2.getState()) {
            var2.onSetSprinting(this);
         }
      }

      return this.c5586();
   }
}
