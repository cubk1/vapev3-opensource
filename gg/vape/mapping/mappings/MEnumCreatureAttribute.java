package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MEnumCreatureAttribute extends Mapping {
   public final MappingField c8257;

   public MEnumCreatureAttribute() {
      super(MappedClasses.EnumCreatureAttribute);
      this.c8257 = this.getMappingField("UNDEFINED", false, MappedClasses.EnumCreatureAttribute);
   }

   public Object c6031() {
      return this.c8257.getObject(null);
   }

   // $FF: synthetic method
   public static Object c5235(MEnumCreatureAttribute var0) {
      return var0.c6031();
   }
}
