package gg.vape.module.utility.invcleaner;

import gg.vape.module.none.ClientSettings;
import gg.vape.module.utility.InvCleaner;
import gg.vape.wrapper.impl.ItemStack;

import java.util.Comparator;

public class OldItemStackComparator implements Comparator {
   // $FF: synthetic field
   final InvCleaner c4075;

   public OldItemStackComparator(InvCleaner var1) {
      this.c4075 = var1;
   }

   public int c4201(ItemStack var1, ItemStack var2) {
      return Double.compare(ClientSettings.c7384(var1), ClientSettings.c7384(var2));
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.c4201((ItemStack)var1, (ItemStack)var2);
   }
}
