package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MEventBus extends Mapping {
   public final MappingMethod c7321;

   public MEventBus() {
      super(MappedClasses.EventBus);
      this.c7321 = this.getMappingMethodNoRemap("post", false, Boolean.TYPE, MappedClasses.Event);
   }

   public void c6771(Object var1, Object var2) {
      this.c7321.c5509(var1, var2);
   }
}
