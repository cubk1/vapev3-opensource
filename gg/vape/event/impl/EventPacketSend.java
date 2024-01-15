package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.event.Event;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.Packet;

public class EventPacketSend extends Event {
   public Packet c2472;

   public EventPacketSend(Object var1) {
      this.c2472 = new Packet(var1);
   }

   public Object getPacketInstance() {
      return this.c2472.getObject();
   }

   public Packet getPacket() {
      return this.c2472;
   }

   public void setPacket(Packet var1) {
      this.c2472 = var1;
   }

   public boolean fire() {

      for (Mod var2 : Vape.instance.getModManager().collectMods()) {
         if (var2.getState()) {
            var2.onPacketSend(this);
         }
      }

      return this.c5586();
   }
}
