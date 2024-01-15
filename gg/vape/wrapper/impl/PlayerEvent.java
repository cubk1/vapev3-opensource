package gg.vape.wrapper.impl;

public class PlayerEvent extends EntityEvent {
   public PlayerEvent(Object var1) {
      super(var1);
   }

   public EntityPlayer c8294() {
      return new EntityPlayer(vape.getMappings().playerEvent.c6780(this.obj));
   }
}
