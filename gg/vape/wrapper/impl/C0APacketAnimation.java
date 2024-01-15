package gg.vape.wrapper.impl;

public class C0APacketAnimation extends Packet {
   public C0APacketAnimation(Object var1) {
      super(var1);
   }

   public static C0APacketAnimation c8590() {
       return ForgeVersion.minorVersion() >= 23 ? new C0APacketAnimation(vape.getMappings().packetAnimation.c6780(EnumHead.c1307()
                                                                                                                          .getObject())) : new C0APacketAnimation(vape.getMappings().packetAnimation.c6031());
   }
}
