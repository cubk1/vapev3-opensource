package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MTextComponentTranslation;
import gg.vape.unmap.TextComponentBase;

public class TextComponentTranslation extends TextComponentBase {
   public TextComponentTranslation(Object var1) {
      super(var1);
   }

   public static TextComponentTranslation c86(String var0, Object... var1) {
      return new TextComponentTranslation(MTextComponentTranslation.c7492(vape.getMappings().textComponentTranslation, var0, var1));
   }
}
