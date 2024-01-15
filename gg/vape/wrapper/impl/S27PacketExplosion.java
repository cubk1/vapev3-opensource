package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MSPacketExplosion;

public class S27PacketExplosion extends Packet {
   public S27PacketExplosion(Object var1) {
      super(var1);
   }

   public float c6767() {
      return MSPacketExplosion.c3380(vape.getMappings().packetExplosion, this.obj);
   }

   public float c3455() {
      return MSPacketExplosion.c3267(vape.getMappings().packetExplosion, this.obj);
   }

   public float c8279() {
      return MSPacketExplosion.c6682(vape.getMappings().packetExplosion, this.obj);
   }

   public void c6025(float var1) {
      MSPacketExplosion.c3839(vape.getMappings().packetExplosion, this.obj, var1);
   }

   public void c8528(float var1) {
      MSPacketExplosion.c2436(vape.getMappings().packetExplosion, this.obj, var1);
   }

   public void c8393(float var1) {
      MSPacketExplosion.c3359(vape.getMappings().packetExplosion, this.obj, var1);
   }
}
