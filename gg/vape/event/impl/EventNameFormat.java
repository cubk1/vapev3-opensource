package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.event.Event;
import gg.vape.module.Mod;

import java.util.Iterator;

public class EventNameFormat extends Event {
   public final String c7002;
   public String c3100;

   public EventNameFormat(String var1, String var2) {
      this.c7002 = var1;
      this.c3100 = var2;
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         if (var2.getState()) {
            var2.onNameFormat(this);
         }
      }

      return this.c5586();
   }

   public String c4561() {
      return this.c7002;
   }

   public String c1336() {
      return this.c3100;
   }

   public void c6485(String var1) {
      this.c3100 = var1;
   }
}
