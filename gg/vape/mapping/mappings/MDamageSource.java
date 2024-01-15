package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MDamageSource extends Mapping {
   public final MappingMethod c4344;

   public MDamageSource() {
      super(MappedClasses.DamageSource);
      this.c4344 = this.getMappingMethod("causePlayerDamage", true, MappedClasses.DamageSource, MappedClasses.EntityPlayer);
   }

   public Object c6780(Object var1) {
      return this.c4344.invoke(null, var1);
   }

}
