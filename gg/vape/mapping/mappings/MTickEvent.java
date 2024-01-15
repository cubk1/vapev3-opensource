package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MTickEvent extends Mapping {
   public final MappingField c6237;

   public MTickEvent() {
      super(MappedClasses.TickEvent);
      this.c6237 = this.getMappingFieldNoRemap("phase", false, MappedClasses.TickEventPhase);
   }

   public Object c6780(Object var1) {
      return this.c6237.getObject(var1);
   }

   // $FF: synthetic method
   public static Object c6828(MTickEvent var0, Object var1) {
      return var0.c6780(var1);
   }
}
