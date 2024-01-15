package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MPotionEffect;
import gg.vape.wrapper.Wrapper;

public class PotionEffect extends Wrapper {
   public PotionEffect(Object var1) {
      super(var1);
   }

   public int getAmplifier() {
      return MPotionEffect.c2036(vape.getMappings().potionEffect, this.obj);
   }

   public static PotionEffect c2829(int var0, int var1, int var2) {
      return ForgeVersion.minorVersion() >= 23 ? c1072(Potion.c6875(var0), var1, var2) : new PotionEffect(MPotionEffect.c1117(vape.getMappings().potionEffect, var0, var1, var2));
   }

   public static PotionEffect c1072(Potion var0, int var1, int var2) {
      return new PotionEffect(vape.getMappings().potionEffect.c672(var0.getObject(), var1, var2));
   }

   public int c3715() {
      return ForgeVersion.minorVersion() >= 23 ? (new Potion(MPotionEffect.c8056(vape.getMappings().potionEffect, this.obj))).c7217() : MPotionEffect.c729(vape.getMappings().potionEffect, this.obj);
   }

   public int c7544() {
      return MPotionEffect.c6004(vape.getMappings().potionEffect, this.obj);
   }
}
