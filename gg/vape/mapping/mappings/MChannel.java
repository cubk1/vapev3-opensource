package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MChannel extends Mapping {
   public final MappingMethod c827;

   public MChannel() {
      super(MappedClasses.Channel);
      this.c827 = this.getMappingMethodNoRemap("isOpen", false, Boolean.TYPE);
   }

   public boolean c4246(Object var1) {
      return this.c827.c5509(var1);
   }
}
