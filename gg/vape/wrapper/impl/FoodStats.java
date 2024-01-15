package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MFoodStats;
import gg.vape.wrapper.Wrapper;

public class FoodStats extends Wrapper {
   public FoodStats(Object var1) {
      super(var1);
   }

   public int c1744() {
      return MFoodStats.c3550(vape.getMappings().foodStats, this.obj);
   }
}
