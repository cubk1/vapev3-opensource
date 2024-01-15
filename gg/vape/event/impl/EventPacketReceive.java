package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.event.Event;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.Packet;

import java.util.Iterator;

public class EventPacketReceive extends Event {
   public Packet c4490;

   public EventPacketReceive(Object var1) {
      this.c4490 = new Packet(var1);
   }

   public Object getPacketInstance() {
      return this.c4490.getObject();
   }

   public Packet getPacket() {
      return this.c4490;
   }

   public void c4693(Packet var1) {
      this.c4490 = var1;
   }

   public boolean fire() {

      for (Mod var2 : Vape.instance.getModManager().collectMods()) {
         if (var2.getState()) {
            var2.onPacketReceive(this);
         }
      }

      return this.c5586();
   }
}
