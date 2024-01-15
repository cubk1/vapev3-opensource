package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MITextComponent;
import gg.vape.wrapper.Wrapper;

public class ITextComponent extends Wrapper {
   public ITextComponent(Object var1) {
      super(var1);
   }

   public String c693() {
      return MITextComponent.c5439(vape.getMappings().textComponent, this.obj);
   }

   public String c376() {
      return MITextComponent.c8090(vape.getMappings().textComponent, this.obj);
   }
}
