package gg.vape.wrapper.impl;

public class C05PacketPlayerLook extends C03PacketPlayer {
   public C05PacketPlayerLook(Object var1) {
      super(var1);
   }

   public static C05PacketPlayerLook c7655(float var0, float var1, boolean var2) {
       return new C05PacketPlayerLook(vape.getMappings().mcPacketPlayerRotation.c1099(var0, var1, var2));
   }
}
