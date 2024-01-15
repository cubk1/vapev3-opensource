package gg.vape.wrapper.impl;

public class C02PacketEntityAction extends Packet {
   public C02PacketEntityAction(Object var1) {
      super(var1);
   }

   public static C02PacketEntityAction c1600(Entity var0, int var1) {
      return new C02PacketEntityAction(vape.getMappings().packetEntityAction.c2260(var0.getObject(), var1));
   }

   //public static c8910 c699(c6645 var0, iReSqtkUVghTviReSqtkUVg var1) {
   //   return new c8910(c3280.getMappings().c2678.c1352(var0.c8953(), var1.a()));
   //}
}
