package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class EntityEquipmentSlot extends Wrapper {
   public EntityEquipmentSlot(Object var1) {
      super(var1);
   }

   public int c1744() {
       return vape.getMappings().entityEquipmentSlot.c7740(this.obj);
   }

   public int c3715() {
      return vape.getMappings().entityEquipmentSlot.c4023(this.obj);
   }

   public static EntityEquipmentSlot c2128() {
      return new EntityEquipmentSlot(vape.getMappings().entityEquipmentSlot.c6031());
   }
}
