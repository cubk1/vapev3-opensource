package gg.vape.unmap;

import gg.vape.module.none.ClientSettings;
import gg.vape.module.utility.InvCleaner;
import gg.vape.wrapper.impl.ItemStack;

import java.util.Comparator;

public class InvComparator implements Comparator {
   // $FF: synthetic field
   final InvCleaner c5440;

   public InvComparator(InvCleaner var1) {
      this.c5440 = var1;
   }

   public int c1244(ItemStack var1, ItemStack var2) {
      return Double.compare(ClientSettings.c913(var1), ClientSettings.c913(var2));
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.c1244((ItemStack)var1, (ItemStack)var2);
   }
}
