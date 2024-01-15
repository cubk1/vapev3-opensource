package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.event.Event;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.Entity;
import gg.vape.wrapper.impl.EventType;

public class EventStep extends Event {
   public final Entity c270;
   public static float c788;

   public EventStep(int var1, Object var2) {
      this.c270 = new Entity(var2);
      this.eventType = var1;
      if (var1 == EventType.PRE) {
         c788 = this.c270.c3619();
      }

   }

   public boolean fire() {

      for (Mod var2 : Vape.instance.getModManager().collectMods()) {
         if (var2.getState()) {
            var2.onStep(this);
         }
      }

      return this.c5586();
   }

   public double c548() {
      return this.c270.c3619();
   }

   public void c8146(double var1) {
      this.c270.c7106((float)var1);
   }

   public double c8077() {
      return c788;
   }

   // $FF: synthetic method
   static float c2202() {
      return c788;
   }
}
