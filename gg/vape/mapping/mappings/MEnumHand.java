package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MEnumHand extends Mapping {
   public final MappingField c5573;

   public MEnumHand() {
      super(MappedClasses.EnumHand);
      this.c5573 = this.getMappingField("MAIN_HAND", false, MappedClasses.EnumHand);
   }

   public Object c6031() {
      return this.c5573.getObject(null);
   }
}
