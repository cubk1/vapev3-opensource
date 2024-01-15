package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class DamageSource extends Wrapper {
   public DamageSource(Object var1) {
      super(var1);
   }

   public static DamageSource c3654(EntityPlayer var0) {
       return new DamageSource(vape.getMappings().damageSource.c6780(var0.getObject()));
   }
}
