package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MNetHandlerPlayClient;

import java.util.Collection;

public class NetHandlerPlayClientImpl extends NetHandlerPlayClient {
   public NetHandlerPlayClientImpl(Object var1) {
      super(var1);
   }

   public void addToSendQueue(Packet var1) {
      MNetHandlerPlayClient.c1224(vape.getMappings().netHandlerPlayClient, this.obj, var1.getObject());
   }

   public Collection c8291() {
      return MNetHandlerPlayClient.c3137(vape.getMappings().netHandlerPlayClient, this.obj);
   }
}
