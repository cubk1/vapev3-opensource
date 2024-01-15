package gg.vape.wrapper.impl;

public class S08PacketPlayerPosLook extends Packet {
   public S08PacketPlayerPosLook(Object var1) {
      super(var1);
   }

   public float c6767() {
      return vape.getMappings().packetPlayerPosLook.c8820(this.obj);
   }

   public float c3455() {
      return vape.getMappings().packetPlayerPosLook.c7751(this.obj);
   }

   public void c6025(float var1) {
      vape.getMappings().packetPlayerPosLook.c7180(this.obj, var1);
   }

   public void c8528(float var1) {
      vape.getMappings().packetPlayerPosLook.c3962(this.obj, var1);
   }
}
