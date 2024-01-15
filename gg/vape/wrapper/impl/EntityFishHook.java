package gg.vape.wrapper.impl;

public class EntityFishHook extends Entity {
   public EntityFishHook(Object var1) {
      super(var1);
   }

   public Entity c4157() {
       return new Entity(vape.getMappings().entityFishHook.c6780(this.obj));
   }

   public boolean c6738() {
      return vape.getMappings().entityFishHook.c5419(this.obj);
   }
}
