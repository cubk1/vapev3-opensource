package gg.vape.wrapper.impl;

import gg.vape.Vape;

public class PlayerTickEvent extends TickEvent {
   public PlayerTickEvent(Object var1) {
      super(var1);
   }

   public EntityPlayer c1170() {
      return new EntityPlayer(Vape.instance.getMappings().playerTickEvent.c6780(this.obj));
   }
}
