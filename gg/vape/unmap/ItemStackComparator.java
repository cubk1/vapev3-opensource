package gg.vape.unmap;

import gg.vape.module.none.ClientSettings;
import gg.vape.module.utility.InvCleaner;
import gg.vape.wrapper.impl.ItemStack;

import java.util.Comparator;

public class ItemStackComparator implements Comparator {
   // $FF: synthetic field
   final InvCleaner c7008;

   public ItemStackComparator(InvCleaner var1) {
      this.c7008 = var1;
   }

   public int c4362(ItemStack var1, ItemStack var2) {
      return Double.compare(ClientSettings.c6304(var1), ClientSettings.c6304(var2));
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.c4362((ItemStack)var1, (ItemStack)var2);
   }
}
