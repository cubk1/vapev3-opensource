package gg.vape.wrapper.impl;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.mappings.MItemPotion;
import gg.vape.wrapper.Wrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemSplashPotion extends Wrapper {
   public ItemSplashPotion(Object var1) {
      super(var1);
   }

   public static boolean c6888(ItemStack var0) {
      if (ForgeVersion.minorVersion() < 23) {
         return (var0.c2021() & 16384) != 0;
      } else {
         return var0.getItem().isNotNull() && var0.getItem().isInstance(MappedClasses.ItemSplashPotion);
      }
   }

   public List c5965(ItemStack var1) {
      return MItemPotion.c3808(vape.getMappings().itemPotion, this.obj, var1.getObject());
   }

   public List c3477(ItemStack var1) {
      ArrayList var2 = new ArrayList();
      List var3 = MItemPotion.c3808(vape.getMappings().itemPotion, this.obj, var1.getObject());
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         var2.add(new PotionEffect(var5));
      }

      return var2;
   }

   public List c1423(int var1) {
      ArrayList var2 = new ArrayList();
      List var3 = MItemPotion.c3808(vape.getMappings().itemPotion, this.obj, var1);
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         var2.add(new PotionEffect(var5));
      }

      return var2;
   }

   public String c8079(ItemStack var1) {
      return MItemPotion.c2012(vape.getMappings().itemPotion, this.obj, var1.getObject());
   }
}
