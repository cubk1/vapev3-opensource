package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class SharedMonsterAttributes extends Wrapper {
   public SharedMonsterAttributes(Object var1) {
      super(var1);
   }

   public static IAttributeModifier c660() {
      return new IAttributeModifier(vape.getMappings().sharedMonsterAttributes.c6031());
   }
}
