package gg.vape.utils;

import gg.vape.unmap.INamed;

import java.util.Comparator;

public class NameComparator implements Comparator {
   public int c1311(INamed var1, INamed var2) {
      return var1.getName().compareTo(var2.getName());
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.c1311((INamed)var1, (INamed)var2);
   }
}
