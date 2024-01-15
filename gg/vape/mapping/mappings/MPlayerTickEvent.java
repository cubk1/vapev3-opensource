package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MPlayerTickEvent extends Mapping {
   public final MappingField c6564;

   public MPlayerTickEvent() {
      super(MappedClasses.TickEvent$PlayerTickEvent);
      this.c6564 = this.getMappingFieldNoRemap("player", false, MappedClasses.EntityPlayer);
   }

   public Object c6780(Object var1) {
      return this.c6564.getObject(var1);
   }
}
