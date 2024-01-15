package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MPotionEffect extends Mapping {
   public MappingField c3674;
   public final MappingMethod getAmplifier;
   public MappingMethod c1021;
   public MappingMethod c6102;
   public MappingMethod c6611;
   public final MappingMethod c3154;

   public MPotionEffect() {
      super(MappedClasses.PotionEffect);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c6102 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.Potion, Integer.TYPE, Integer.TYPE);
         this.c3674 = this.getMappingFieldNoRemap("potion", true, MappedClasses.Potion);
      } else {
         this.c1021 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         this.c6611 = this.getMappingMethodNoRemap("getPotionID", true, Integer.TYPE);
      }

      this.getAmplifier = this.getMappingMethodNoRemap("getAmplifier", true, Integer.TYPE);
      this.c3154 = this.getMappingMethodNoRemap("getDuration", true, Integer.TYPE);
   }

   public int c7740(Object var1) {
      return this.getAmplifier.c2555(var1);
   }

   public Object c4854(int var1, int var2, int var3) {
      return this.c1021.c4955(var1, var2, var3);
   }

   public int c4023(Object var1) {
      return this.c6611.c2555(var1);
   }

   public int c6882(Object var1) {
      return this.c3154.c2555(var1);
   }

   public Object c672(Object var1, int var2, int var3) {
      return this.c6102.c4955(var1, var2, var3);
   }

   public Object c5143(Object var1) {
      return this.c3674.getObject(var1);
   }

   // $FF: synthetic method
   public static int c2036(MPotionEffect var0, Object var1) {
      return var0.c7740(var1);
   }

   // $FF: synthetic method
   public static Object c1117(MPotionEffect var0, int var1, int var2, int var3) {
      return var0.c4854(var1, var2, var3);
   }

   // $FF: synthetic method
   public static Object c8056(MPotionEffect var0, Object var1) {
      return var0.c5143(var1);
   }

   // $FF: synthetic method
   public static int c729(MPotionEffect var0, Object var1) {
      return var0.c4023(var1);
   }

   // $FF: synthetic method
   public static int c6004(MPotionEffect var0, Object var1) {
      return var0.c6882(var1);
   }
}
