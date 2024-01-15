package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.wrapper.impl.ForgeVersion;

public class MArmorMaterial extends Mapping {
   public final MappingField CLOTH;
   public final MappingField CHAIN;
   public final MappingField IRON;
   public final MappingField GOLD;
   public final MappingField DIAMOND;

   public MArmorMaterial() {
      super(MappedClasses.ItemArmor$ArmorMaterial);
      if (ForgeVersion.minorVersion() == 13) {
         this.CLOTH = this.getMappingField("CLOTH", false, MappedClasses.ItemArmor$ArmorMaterial);
      } else {
         this.CLOTH = this.getMappingField("LEATHER", false, MappedClasses.ItemArmor$ArmorMaterial);
      }

      this.CHAIN = this.getMappingField("CHAIN", false, MappedClasses.ItemArmor$ArmorMaterial);
      this.IRON = this.getMappingField("IRON", false, MappedClasses.ItemArmor$ArmorMaterial);
      this.GOLD = this.getMappingField("GOLD", false, MappedClasses.ItemArmor$ArmorMaterial);
      this.DIAMOND = this.getMappingField("DIAMOND", false, MappedClasses.ItemArmor$ArmorMaterial);
   }

   public Object getCloth() {
      return this.CLOTH.getObject(null);
   }

   public Object getChain() {
      return this.CHAIN.getObject(null);
   }

   public Object getIron() {
      return this.IRON.getObject(null);
   }

   public Object getGold() {
      return this.GOLD.getObject(null);
   }

   public Object getDiamond() {
      return this.DIAMOND.getObject(null);
   }

   // $FF: synthetic method
   public static Object getCloth(MArmorMaterial var0) {
      return var0.getCloth();
   }

   // $FF: synthetic method
   public static Object getChain(MArmorMaterial var0) {
      return var0.getChain();
   }

   // $FF: synthetic method
   public static Object getIron(MArmorMaterial var0) {
      return var0.getIron();
   }

   // $FF: synthetic method
   public static Object getGold(MArmorMaterial var0) {
      return var0.getGold();
   }

   // $FF: synthetic method
   public static Object getDiamond(MArmorMaterial var0) {
      return var0.getDiamond();
   }
}
