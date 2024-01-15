package gg.vape.wrapper.impl;

public class EntityPotion extends EntityThrowable {
   public EntityPotion(Object var1) {
      super(var1);
   }

   public ItemStack c4981() {
       return new ItemStack(vape.getMappings().entityPotion.c6780(this.getObject()));
   }
}
