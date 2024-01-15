package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MEntityFishHook extends Mapping {
   public final MappingField c6108;
   public final MappingField c3676;

   public MEntityFishHook() {
      super(MappedClasses.EntityFishHook);
      this.c6108 = this.getMappingFieldNoRemap("field_146043_c", false, MappedClasses.Entity);
      this.c3676 = this.getMappingFieldNoRemap("field_146051_au", false, Boolean.TYPE);
   }

   public Object c6780(Object var1) {
      return this.c6108.getObject(var1);
   }

   public boolean c5419(Object var1) {
      return this.c3676.getBoolean(var1);
   }

}
