package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MItemArmor;
import gg.vape.wrapper.Wrapper;

public class ItemArmor extends Wrapper {
   public ItemArmor(Object var1) {
      super(var1);
   }

   public int c1744() {
      return MItemArmor.c3829(vape.getMappings().itemArmor, this.obj);
   }

   public int c3715() {
      if (ForgeVersion.minorVersion() >= 23) {
         EntityEquipmentSlot var1 = new EntityEquipmentSlot(MItemArmor.c3484(vape.getMappings().itemArmor, this.obj));
         return var1.c3715();
      } else {
         return MItemArmor.c5622(vape.getMappings().itemArmor, this.obj);
      }
   }

   public ArmorMaterial c7332() {
      return new ArmorMaterial(MItemArmor.c5063(vape.getMappings().itemArmor, this.obj));
   }
}
