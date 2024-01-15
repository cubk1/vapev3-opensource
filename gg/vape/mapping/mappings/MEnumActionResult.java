package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MEnumActionResult extends Mapping {
   public final MappingField c5586;

   public MEnumActionResult() {
      super(MappedClasses.EnumActionResult);
      this.c5586 = this.getMappingField("SUCCESS", true, MappedClasses.EnumActionResult);
   }

   public Object c6031() {
      return this.c5586.getObject(null);
   }

   // $FF: synthetic method
   public static Object c7524(MEnumActionResult var0) {
      return var0.c6031();
   }
}
