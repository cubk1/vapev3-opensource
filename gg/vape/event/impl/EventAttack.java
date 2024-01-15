package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.event.Event;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.Entity;

import java.util.Iterator;

public class EventAttack extends Event {
   public final Entity c742;

   public EventAttack(Object var1, int var2) {
      this.c742 = new Entity(var1);
      this.eventType = var2;
   }

   public Entity c7685() {
      return this.c742;
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         if (var2.getState()) {
            var2.onAttack(this);
         }
      }

      return this.c5586();
   }
}
