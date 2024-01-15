package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MEntityEvent extends Mapping {
   public final MappingField c5441;

   public MEntityEvent() {
      super("net/minecraftforge/event/entity/EntityEvent");
      this.c5441 = this.getMappingFieldNoRemap("entity", false, MappedClasses.Entity);
   }

   public Object c6780(Object var1) {
      return this.c5441.getObject(var1);
   }
}
