package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MSPacketEntityVelocity;

public class S12PacketEntityVelocity extends Packet {
   public S12PacketEntityVelocity(Object var1) {
      super(var1);
   }

   public int getEntityID() {
      return this.obj == null ? 0 : MSPacketEntityVelocity.c5370(vape.getMappings().packetEntityVelocity, this.obj);
   }

   public int c7544() {
      return this.obj == null ? 0 : MSPacketEntityVelocity.c583(vape.getMappings().packetEntityVelocity, this.obj);
   }

   public int c2021() {
      return this.obj == null ? 0 : MSPacketEntityVelocity.c8602(vape.getMappings().packetEntityVelocity, this.obj);
   }

   public int c341() {
      return this.obj == null ? 0 : MSPacketEntityVelocity.c1060(vape.getMappings().packetEntityVelocity, this.obj);
   }

   public void c33(int var1) {
      if (this.obj != null) {
         MSPacketEntityVelocity.c4282(vape.getMappings().packetEntityVelocity, this.obj, var1);
      }
   }

   public void c2062(int var1) {
      if (this.obj != null) {
         MSPacketEntityVelocity.c7283(vape.getMappings().packetEntityVelocity, this.obj, var1);
      }
   }

   public void c5732(int var1) {
      if (this.obj != null) {
         MSPacketEntityVelocity.c6367(vape.getMappings().packetEntityVelocity, this.obj, var1);
      }
   }
}
