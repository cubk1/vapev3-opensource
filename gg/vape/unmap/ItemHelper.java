package gg.vape.unmap;

import func.skidline.c5732;
import gg.vape.mapping.MappedClasses;
import gg.vape.wrapper.impl.Item;
import gg.vape.wrapper.impl.ItemStack;

import java.util.HashSet;
import java.util.Iterator;

public class ItemHelper {
   public final HashSet c5801 = new HashSet();

   public ItemHelper() {
      this.c7514(new c5732(new String[]{"sword", "swords"}, null), MappedClasses.ItemSword);
      this.c7514(new c5732(new String[]{"shovel", "shovels", "spade", "spades"}, null), MappedClasses.ItemSpade);
      this.c7514(new c5732(new String[]{"axe", "axes"}, null), MappedClasses.ItemAxe);
      this.c7514(new c5732(new String[]{"pickaxe", "pickaxes"}, null), MappedClasses.ItemPickaxe);
      this.c7514(new c5732(new String[]{"block", "blocks"}, null), MappedClasses.ItemBlock);
      this.c7514(new c5732(new String[]{"fists", "none", "fist", "hand"}, null));
      this.c7514(new c5732(new String[]{"food", "foods"}, null), MappedClasses.ItemFood);
   }

   public void c7514(c5732 var1, Class... var2) {
      var1.c7124(var2);
      this.c5801.add(var1);
   }

   public boolean c1943(String var1, ItemStack var2) {
      Item var3 = null;
      if (var2.isNotNull()) {
         var3 = var2.getItem();
      }

      Iterator var4 = this.c5801.iterator();

      while(var4.hasNext()) {
         c5732 var5 = (c5732)var4.next();
         String[] var6 = var5.c3469();
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            String var9 = var6[var8];
            if (var9.equalsIgnoreCase(var1)) {
               if (var5.c75().length == 0) {
                  if (var2.isNull()) {
                     return true;
                  }
               } else {
                  Class[] var10 = var5.c75();
                  int var11 = var10.length;

                  for(int var12 = 0; var12 < var11; ++var12) {
                     Class var13 = var10[var12];
                     if (var3 != null && var3.isInstance(var13)) {
                        return true;
                     }
                  }
               }
            }
         }
      }

      return false;
   }
}
