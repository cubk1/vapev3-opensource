package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.event.Event;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.EntityPlayer;
import gg.vape.wrapper.impl.EventType;

import java.util.Iterator;

public class EventPlayerTick extends Event {
   public final EntityPlayer c4895;

   public EventPlayerTick(EntityPlayer var1, int var2) {
      this.c4895 = var1;
      this.eventType = var2;
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         if (var2.getState()) {
            if (this.getType() == EventType.PRE) {
               var2.onTick(this);
            } else {
               var2.onPlayerTick(this);
            }
         }
      }

      return this.c5586();
   }

   public EntityPlayer c4894() {
      return this.c4895;
   }
}
