package gg.vape.wrapper.impl;

public class C04PacketPlayerPosition extends C03PacketPlayer {
   public C04PacketPlayerPosition(Object var1) {
      super(var1);
   }

   public static C04PacketPlayerPosition newInstance(double var0, double var2, double var4, double var6, boolean var8) {
      return new C04PacketPlayerPosition(vape.getMappings().mcPacketPlayerPosition.c239(var0, var2, var4, var6, var8));
   }

   public static C04PacketPlayerPosition newInstance(double var0, double var2, double var4, boolean var6) {
       return new C04PacketPlayerPosition(vape.getMappings().mcPacketPlayerPosition.c2412(var0, var2, var4, var6));
   }
}
