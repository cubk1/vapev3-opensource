package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MFoodStats extends Mapping {
   public final MappingMethod c3068;

   public MFoodStats() {
      super(MappedClasses.FoodStats);
      this.c3068 = this.getMappingMethodNoRemap("getFoodLevel", true, Integer.TYPE);
   }

   public int c7740(Object var1) {
      return this.c3068.c2555(var1);
   }

   // $FF: synthetic method
   public static int c3550(MFoodStats var0, Object var1) {
      return var0.c7740(var1);
   }
}
