package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.wrapper.impl.ForgeVersion;

public class MItemArmor extends Mapping {
   public final MappingField c2186;
   public final MappingField c7901;
   public final MappingField c5065;

   public MItemArmor() {
      super(MappedClasses.ItemArmor);
      this.c2186 = this.getMappingFieldNoRemap("damageReduceAmount", true, Integer.TYPE);
      this.c5065 = this.getMappingFieldNoRemap("material", true, MappedClasses.ItemArmor$ArmorMaterial);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c7901 = this.getMappingFieldNoRemap("armorType", true, MappedClasses.EntityEquipmentSlot);
      } else {
         this.c7901 = this.getMappingFieldNoRemap("armorType", true, Integer.TYPE);
      }

   }

   public int c7740(Object var1) {
      return this.c2186.getInt(var1);
   }

   public int c4023(Object var1) {
      return this.c7901.getInt(var1);
   }

   public Object c5327(Object var1) {
      return this.c7901.getObject(var1);
   }

   public Object c5143(Object var1) {
      return this.c5065.getObject(var1);
   }

   // $FF: synthetic method
   public static int c3829(MItemArmor var0, Object var1) {
      return var0.c7740(var1);
   }

   // $FF: synthetic method
   public static Object c3484(MItemArmor var0, Object var1) {
      return var0.c5327(var1);
   }

   // $FF: synthetic method
   public static int c5622(MItemArmor var0, Object var1) {
      return var0.c4023(var1);
   }

   // $FF: synthetic method
   public static Object c5063(MItemArmor var0, Object var1) {
      return var0.c5143(var1);
   }
}
