package gg.vape.module.utility.invcleaner;

import gg.vape.utils.datas.ItemStackData;

import java.util.Comparator;

public class ItemDataComparator implements Comparator {
   int c2275;

   public ItemDataComparator(int var1) {
      this.c2275 = var1;
   }

   public int c6735(ItemStackData var1, ItemStackData var2) {
      int var3 = this.c2275;
      int var4 = var1.c4518();
      int var5 = var2.c4518();
      int var6;
      if (var4 > var3) {
         var6 = var4 - var3;
      } else {
         var6 = var3 - var4;
      }

      int var7;
      if (var5 > var3) {
         var7 = var5 - var3;
      } else {
         var7 = var3 - var5;
      }

      return var6 < var7 ? -1 : 0;
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.c6735((ItemStackData)var1, (ItemStackData)var2);
   }
}
