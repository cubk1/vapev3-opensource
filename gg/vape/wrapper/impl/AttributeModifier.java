package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MAttributeModifier;
import gg.vape.wrapper.Wrapper;

import java.util.UUID;

public class AttributeModifier extends Wrapper {
   public AttributeModifier(Object var1) {
      super(var1);
   }

   public UUID c6604() {
      return MAttributeModifier.getID(vape.getMappings().attributeModifier, this.obj);
   }

   public double c1779() {
      return vape.getMappings().attributeModifier.getAmount(this.obj);
   }
}
