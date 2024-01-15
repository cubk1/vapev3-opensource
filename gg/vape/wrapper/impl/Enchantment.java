package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

import java.util.ArrayList;
import java.util.Iterator;

public class Enchantment extends Wrapper {
   public Enchantment(Object var1) {
      super(var1);
   }

   public static Enchantment c8837() {
      return c5609(0);
   }

   public static Enchantment c8276() {
      return c5609(34);
   }

   public static Enchantment c5437() {
      return c5609(16);
   }

   public static Enchantment c1317() {
      return c5609(20);
   }

   public static Enchantment c107() {
      return c5609(32);
   }

   public static Enchantment c3365() {
      return c5609(2);
   }

   public static Enchantment c6820() {
      return c5609(48);
   }

   public static Enchantment c8208() {
      return c5609(50);
   }

   public static Enchantment c7838() {
      return c5609(49);
   }

   public static Enchantment c6364() {
      return c5609(35);
   }

   public static Enchantment c5219() {
      return c5609(51);
   }

   public static Enchantment c390() {
      return c5609(7);
   }

   public static Enchantment c1910() {
      return c5609(19);
   }

   public String c6150(int var1) {
       return vape.getMappings().enchantment.c1686(this.obj, var1);
   }

   public static Enchantment[] c2188() {
      if (ForgeVersion.minorVersion() >= 23) {
         Iterable var5 = (Iterable) vape.getMappings().enchantment.c7468();
         ArrayList var6 = new ArrayList();
         Iterator var7 = var5.iterator();

         while(var7.hasNext()) {
            Object var3 = var7.next();
            Enchantment var4 = new Enchantment(var3);
            var6.add(var4);
         }

         return (Enchantment[])var6.toArray(new Enchantment[var6.size()]);
      } else {
         Object[] var0 = vape.getMappings().enchantment.c7079();
         Enchantment[] var1 = new Enchantment[var0.length];

         for(int var2 = 0; var2 < var0.length; ++var2) {
            var1[var2] = new Enchantment(var0[var2]);
         }

         return var1;
      }
   }

   public static Enchantment c5609(int var0) {
      if (ForgeVersion.minorVersion() >= 23) {
         return new Enchantment(vape.getMappings().enchantment.c8737(var0));
      } else {
         Enchantment[] var1 = c2188();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            Enchantment var4 = var1[var3];
            if (var4 != null && !var4.isNull() && var4.c2605() == var0) {
               return var4;
            }
         }

         return null;
      }
   }

   public int c2605() {
      return vape.getMappings().enchantment.c7740(this.obj);
   }
}
