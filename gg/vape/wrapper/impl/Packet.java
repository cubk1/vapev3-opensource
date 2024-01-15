package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MPacket;
import gg.vape.wrapper.Wrapper;

public class Packet extends Wrapper {
   public Packet(Object var1) {
      super(var1);
   }

   public boolean c2913() {
      return MPacket.c6529(vape.getMappings().packet, this.obj);
   }

   public void c2949(INetHandlerPlayClient var1) {
      MPacket.c2245(vape.getMappings().packet, this.obj, var1.getObject());
   }
}
