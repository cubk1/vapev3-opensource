package gg.vape.event;

import gg.vape.wrapper.impl.EventType;

public class Event {
   protected int eventType;
   public boolean c5505;

   public Event() {
      this.eventType = EventType.PRE;
   }

   public boolean fire() {
      return this.c5505;
   }

   public boolean isPre() {
      return this.eventType == EventType.PRE;
   }

   public boolean c5586() {
      return this.c5505;
   }

   public void setCancelled(boolean var1) {
      this.c5505 = var1;
   }

   public int getType() {
      return this.eventType;
   }
}
