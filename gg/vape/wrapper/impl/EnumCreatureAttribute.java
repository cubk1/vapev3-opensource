package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MEnumCreatureAttribute;
import gg.vape.wrapper.Wrapper;

public class EnumCreatureAttribute extends Wrapper {
   public EnumCreatureAttribute(Object var1) {
      super(var1);
   }

   public static EnumCreatureAttribute c3198() {
      return new EnumCreatureAttribute(MEnumCreatureAttribute.c5235(vape.getMappings().enumCreatureAttribute));
   }
}
