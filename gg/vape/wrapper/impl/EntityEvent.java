package gg.vape.wrapper.impl;

public class EntityEvent extends ForgeEvent {
   public EntityEvent(Object var1) {
      super(var1);
   }

   public Entity c4451() {
      return new Entity(vape.getMappings().entityEvent.c6780(this.obj));
   }
}
