package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MPotion;
import gg.vape.wrapper.Wrapper;

import java.util.ArrayList;
import java.util.Iterator;

public class Potion extends Wrapper {
   public Potion(Object var1) {
      super(var1);
   }

   public static Potion moveSpeed() {
      return ForgeVersion.minorVersion() >= 23 ? new Potion(MPotion.c1953(vape.getMappings().potion, 1)) : new Potion(MPotion.c814(vape.getMappings().potion));
   }

   public static Potion c8411() {
      return ForgeVersion.minorVersion() >= 23 ? new Potion(MPotion.c1953(vape.getMappings().potion, 2)) : new Potion(MPotion.c4151(vape.getMappings().potion));
   }

   public static Potion c7850() {
      return ForgeVersion.minorVersion() >= 23 ? new Potion(MPotion.c1953(vape.getMappings().potion, 6)) : new Potion(MPotion.c4840(vape.getMappings().potion));
   }

   public static Potion jump() {
      return ForgeVersion.minorVersion() >= 23 ? new Potion(MPotion.c1953(vape.getMappings().potion, 8)) : new Potion(MPotion.c1939(vape.getMappings().potion));
   }

   public static Potion c6875(int var0) {
      return ForgeVersion.minorVersion() >= 23 ? new Potion(MPotion.c1953(vape.getMappings().potion, var0)) : c4310()[var0];
   }

   public static Potion c5247() {
      return ForgeVersion.minorVersion() >= 23 ? new Potion(MPotion.c1953(vape.getMappings().potion, 15)) : new Potion(MPotion.c1260(vape.getMappings().potion));
   }

   public static Potion[] c4310() {
      if (ForgeVersion.minorVersion() >= 23) {
         Iterable var5 = (Iterable) MPotion.c759(vape.getMappings().potion);
         ArrayList var6 = new ArrayList();
         var6.add(null);
         Iterator var7 = var5.iterator();

         while(var7.hasNext()) {
            Object var3 = var7.next();
            Potion var4 = new Potion(var3);
            var6.add(var4);
         }

         return (Potion[])var6.toArray(new Potion[var6.size()]);
      } else {
         Object[] var0 = MPotion.c3483(vape.getMappings().potion);
         Potion[] var1 = new Potion[var0.length];

         for(int var2 = 0; var2 < var0.length; ++var2) {
            var1[var2] = new Potion(var0[var2]);
         }

         return var1;
      }
   }

   public boolean c3624() {
      return MPotion.c88(vape.getMappings().potion, this.obj);
   }

   public int c7217() {
      return ForgeVersion.minorVersion() >= 23 ? MPotion.c4330(vape.getMappings().potion, this.getObject()) : MPotion.c8957(vape.getMappings().potion, this.obj);
   }

   public void c1003(EntityLivingBase var1, Object var2, int var3) {
      MPotion.c4318(vape.getMappings().potion, this.obj, var1.getObject(), var2, var3);
   }
}
