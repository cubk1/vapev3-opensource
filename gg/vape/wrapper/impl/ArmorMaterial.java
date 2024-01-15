package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MArmorMaterial;
import gg.vape.wrapper.Wrapper;

public class ArmorMaterial extends Wrapper {
   public ArmorMaterial(Object object) {
      super(object);
   }

   public static ArmorMaterial CLOTH() {
      return new ArmorMaterial(MArmorMaterial.getCloth(vape.getMappings().itemArmor_armorMaterial));
   }

   public static ArmorMaterial CHAIN() {
      return new ArmorMaterial(MArmorMaterial.getChain(vape.getMappings().itemArmor_armorMaterial));
   }

   public static ArmorMaterial IRON() {
      return new ArmorMaterial(MArmorMaterial.getIron(vape.getMappings().itemArmor_armorMaterial));
   }

   public static ArmorMaterial GOLD() {
      return new ArmorMaterial(MArmorMaterial.getGold(vape.getMappings().itemArmor_armorMaterial));
   }

   public static ArmorMaterial DIAMOND() {
      return new ArmorMaterial(MArmorMaterial.getDiamond(vape.getMappings().itemArmor_armorMaterial));
   }
}
