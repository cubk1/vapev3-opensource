package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

import java.util.ArrayList;

public class EnchantmentHelper extends Wrapper {
   public EnchantmentHelper(Object var1) {
      super(var1);
   }

   public static int c7113(int var0, ItemStack var1) {
      if (ForgeVersion.minorVersion() >= 23) {
         Enchantment var2 = Enchantment.c5609(var0);
          return vape.getMappings().enchantmentHelper.c2105(var2.getObject(), var1.getObject());
      } else {
         return vape.getMappings().enchantmentHelper.c940(var0, var1.getObject());
      }
   }

   public static float c2619(ItemStack var0, EnumCreatureAttribute var1) {
      return vape.getMappings().enchantmentHelper.c1624(var0.getObject(), var1.getObject());
   }

   public static int c3182(ItemStack[] var0, DamageSource var1) {
      if (ForgeVersion.minorVersion() >= 23) {
         ArrayList var7 = new ArrayList();
         ItemStack[] var8 = var0;
         int var4 = var0.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            ItemStack var6 = var8[var5];
            var7.add(var6.getObject());
         }

         return vape.getMappings().enchantmentHelper.c1755(var7, var1.getObject());
      } else {
         Object[] var2 = new Object[var0.length];

         for(int var3 = 0; var3 < var0.length; ++var3) {
            var2[var3] = var0[var3].getObject();
         }

         return vape.getMappings().enchantmentHelper.c234(var2, var1.getObject());
      }
   }
}
