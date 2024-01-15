package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.event.Event;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.EventType;

import java.util.Iterator;

public class EventRenderTick extends Event {
   public final float c1673;

   public EventRenderTick(int var1, float var2) {
      this.eventType = var1;
      this.c1673 = var2;
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         if (var2.getState()) {
            if (this.getType() == EventType.PRE) {
               var2.onRenderTick(this);
            } else {
               var2.onPostRenderTick(this);
            }
         }
      }

      return this.c5586();
   }

   public float c6102() {
      return this.c1673;
   }
}
