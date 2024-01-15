package gg.vape.unmap;

import gg.vape.mapping.MappedClasses;
import gg.vape.wrapper.impl.Item;
import gg.vape.wrapper.impl.ItemSplashPotion;
import gg.vape.wrapper.impl.ItemStack;
import gg.vape.wrapper.impl.PotionEffect;

import java.util.Iterator;

public class HealItemUtil {
   public static boolean c573(ItemStack var0) {
      return c5367(var0, false);
   }

   public static boolean c5367(ItemStack var0, boolean var1) {
      if (!var0.isNull() && !var0.getItem().isNull()) {
         if (var1 && var0.getItem().isInstance(MappedClasses.ItemSoup)) {
            return true;
         } else if (!var0.getItem().isInstance(MappedClasses.ItemPotion)) {
            return false;
         } else {
            ItemSplashPotion var2 = new ItemSplashPotion(var0.getItem().getObject());
            if (var2.c5965(var0) == null) {
               return false;
            } else {
               if (ItemSplashPotion.c6888(var0)) {
                  Iterator var3 = var2.c3477(var0).iterator();

                  while(var3.hasNext()) {
                     PotionEffect var4 = (PotionEffect)var3.next();
                     if (var4.c3715() == 6) {
                        return true;
                     }
                  }
               }

               return false;
            }
         }
      } else {
         return false;
      }
   }

   public static boolean c7037(Item var0) {
      return var0.isInstance(MappedClasses.ItemSnowball) || var0.isInstance(MappedClasses.ItemEgg);
   }
}
