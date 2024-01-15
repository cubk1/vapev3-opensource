package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MResourceLocation extends Mapping {
   public final MappingMethod c4407 = this.getMappingMethodNoRemap("getResourcePath", true, String.class);

   public MResourceLocation() {
      super(MappedClasses.ResourceLocation);
   }

   public String c68(Object var1) {
      return (String)this.c4407.invoke(var1);
   }
}
