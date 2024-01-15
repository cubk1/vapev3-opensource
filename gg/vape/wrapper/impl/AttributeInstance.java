package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MIAttributeInstance;
import gg.vape.wrapper.Wrapper;

import java.util.UUID;

public class AttributeInstance extends Wrapper {
   public AttributeInstance(Object object) {
      super(object);
   }

   public AttributeModifier getModifier(UUID uuid) {
      return new AttributeModifier(MIAttributeInstance.getModifier(vape.getMappings().attributeInstance, this.obj, uuid));
   }

   public void c7209(AttributeModifier var1) {
      MIAttributeInstance.applyModifier(vape.getMappings().attributeInstance, this.obj, var1.getObject());
   }
}
