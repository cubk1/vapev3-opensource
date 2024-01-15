package gg.vape.wrapper.impl;

public class C06PacketPlayerPositionLook extends C03PacketPlayer {
   public C06PacketPlayerPositionLook(Object var1) {
      super(var1);
   }

   public static C06PacketPlayerPositionLook c7923(double var0, double var2, double var4, double var6, float var8, float var9, boolean var10) {
      return new C06PacketPlayerPositionLook(vape.getMappings().mcPacketPlayerPositionRotation.c7425(var0, var2, var4, var6, var8, var9, var10));
   }

   public static C06PacketPlayerPositionLook c2704(double var0, double var2, double var4, float var6, float var7, boolean var8) {
       return new C06PacketPlayerPositionLook(vape.getMappings().mcPacketPlayerPositionRotation.c2706(var0, var2, var4, var6, var7, var8));
   }
}
