package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MEntityEquipmentSlot extends Mapping {
   public final MappingField c980;
   public final MappingField c886;
   public final MappingField c4426;

   public MEntityEquipmentSlot() {
      super(MappedClasses.EntityEquipmentSlot);
      this.c980 = this.getMappingFieldNoRemap("slotIndex", true, Integer.TYPE);
      this.c886 = this.getMappingFieldNoRemap("index", true, Integer.TYPE);
      this.c4426 = this.getMappingField("MAINHAND", true, MappedClasses.EntityEquipmentSlot);
   }

   public int c7740(Object var1) {
      return this.c980.getInt(var1);
   }

   public int c4023(Object var1) {
      return this.c886.getInt(var1);
   }

   public Object c6031() {
      return this.c4426.getObject(null);
   }

}
