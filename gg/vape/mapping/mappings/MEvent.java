package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MEvent extends Mapping {
   public final MappingMethod isCancelable;
   public final MappingMethod setCanceled;

   public MEvent() {
      super(MappedClasses.Event);
      this.isCancelable = this.getMappingMethodNoRemap("isCancelable", false, Boolean.TYPE);
      this.setCanceled = this.getMappingMethodNoRemap("setCanceled", false, Void.TYPE, Boolean.TYPE);
   }

   public boolean isCancelable(Object object) {
      return this.isCancelable.c5509(object);
   }

   public void setCanceled(Object object, boolean canceled) {
      this.setCanceled.c2642(object, canceled);
   }
}
