package gg.vape.wrapper.impl;

public class S09PacketHeldItemChange extends Packet {
   public S09PacketHeldItemChange(Object var1) {
      super(var1);
   }

   public static S09PacketHeldItemChange c134(int var0) {
      return new S09PacketHeldItemChange(vape.getMappings().packetHeldItemChange.c8737(var0));
   }
}
