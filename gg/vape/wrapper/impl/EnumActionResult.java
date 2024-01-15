package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MEnumActionResult;
import gg.vape.wrapper.Wrapper;

public class EnumActionResult extends Wrapper {
   public EnumActionResult(Object var1) {
      super(var1);
   }

   public static EnumActionResult c363() {
      return new EnumActionResult(MEnumActionResult.c7524(vape.getMappings().enumActionResult));
   }
}
