package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MTextComponentString;

public class TextComponentString extends ITextComponent {
   public TextComponentString(Object var1) {
      super(var1);
   }

   public static TextComponentString c546(String var0) {
      return new TextComponentString(MTextComponentString.c957(vape.getMappings().textComponentString, var0));
   }

   public String c6376() {
      return MTextComponentString.c3878(vape.getMappings().textComponentString, this.getObject());
   }

   public void c4845(String var1) {
      MTextComponentString.c993(vape.getMappings().textComponentString, this.getObject(), var1);
   }
}
