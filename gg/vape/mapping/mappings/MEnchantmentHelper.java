package gg.vape.mapping.mappings;

import gg.vape.asm.helper.DescUtils;
import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MEnchantmentHelper extends Mapping {
   public final MappingMethod c3422;
   public final MappingMethod c7467;
   public final MappingMethod c1594;

   public MEnchantmentHelper() {
      super(MappedClasses.EnchantmentHelper);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c3422 = this.getMappingMethod("getEnchantmentLevel", true, Integer.TYPE, MappedClasses.Enchantment, MappedClasses.ItemStack);
         this.c1594 = this.getMappingMethod("getEnchantmentModifierDamage", true, Integer.TYPE, Iterable.class, MappedClasses.DamageSource);
      } else {
         this.c3422 = this.getMappingMethod("getEnchantmentLevel", true, Integer.TYPE, Integer.TYPE, MappedClasses.ItemStack);
         this.c1594 = this.getMappingMethod("getEnchantmentModifierDamage", true, Integer.TYPE, DescUtils.getArrayType(MappedClasses.ItemStack), MappedClasses.DamageSource);
      }

      this.c7467 = this.getMappingMethod("func_152377_a", false, Float.TYPE, MappedClasses.ItemStack, MappedClasses.EnumCreatureAttribute);
   }

   public int c940(int var1, Object var2) {
      return this.c3422.c2555(null, var1, var2);
   }

   public int c2105(Object var1, Object var2) {
      return this.c3422.c2555(null, var1, var2);
   }

   public float c1624(Object var1, Object var2) {
      return this.c7467.c3639(null, var1, var2);
   }

   public int c234(Object[] var1, Object var2) {
      return this.c1594.c2555(null, var1, var2);
   }

   public int c1755(Iterable var1, Object var2) {
      return this.c1594.c2555(null, var1, var2);
   }

}
