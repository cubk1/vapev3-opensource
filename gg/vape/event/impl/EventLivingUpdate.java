package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.event.Event;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.Entity;

import java.util.Iterator;

public class EventLivingUpdate extends Event {
   public final Entity c8360;

   public EventLivingUpdate(Entity var1) {
      this.c8360 = var1;
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         if (var2.getState()) {
            var2.onUpdate(this);
         }
      }

      return this.c5586();
   }

   public Entity getEntity() {
      return this.c8360;
   }
}
