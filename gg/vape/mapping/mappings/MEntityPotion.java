package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;
//todo #2
public class MEntityPotion extends Mapping {
   public MappingField c4602;
   public MappingMethod c5148;

   public MEntityPotion() {
      super("net/minecraft/entity/projectile/EntityPotion");
      if (ForgeVersion.minorVersion() >= 23) {
         this.c5148 = this.getMappingMethodNoRemap("getPotion", true, MappedClasses.ItemStack);
      } else {
         this.c4602 = this.getMappingFieldNoRemap("potionDamage", true, MappedClasses.ItemStack);
      }

   }

   public Object c6780(Object var1) {
      return ForgeVersion.minorVersion() >= 23 ? this.c5148.invoke(var1) : this.c4602.getObject(var1);
   }

}
