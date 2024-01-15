package gg.vape.unmap;

import gg.vape.module.none.ClientSettings;
import gg.vape.module.utility.InvCleaner;
import gg.vape.wrapper.impl.ItemStack;

import java.util.Comparator;

public class ItemComparator implements Comparator {
   // $FF: synthetic field
   final InvCleaner c4641;

   public ItemComparator(InvCleaner var1) {
      this.c4641 = var1;
   }

   public int c5956(ItemStack var1, ItemStack var2) {
      return Double.compare(ClientSettings.c7384(var1), ClientSettings.c7384(var2));
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.c5956((ItemStack)var1, (ItemStack)var2);
   }
}
