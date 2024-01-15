package gg.vape.wrapper.impl;

public class C03PacketPlayer extends Packet {
   public C03PacketPlayer(Object var1) {
      super(var1);
   }

   public static C03PacketPlayer newInstance(boolean onGround) {
       return new C03PacketPlayer(vape.getMappings().packetPlayer.c3890(onGround));
   }
}
