package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.event.Event;
import gg.vape.module.Mod;

import java.util.Iterator;

public class EventRenderHand extends Event {
   public final float c6537;

   public EventRenderHand(float var1) {
      this.c6537 = var1;
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         if (var2.getState()) {
            var2.c2965(this);
         }
      }

      return this.c5586();
   }

   public float c6102() {
      return this.c6537;
   }
}
