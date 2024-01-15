package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MC0BPacketEntityAction_Action extends Mapping {
   public final MappingField c7060;
   public final MappingField c7228;
   public final MappingField c5353;
   public final MappingField c3178;

   public MC0BPacketEntityAction_Action() {
      super(MappedClasses.CPacketEntityAction$Action);
      this.c7060 = this.getMappingField("START_SNEAKING", false, MappedClasses.CPacketEntityAction$Action);
      this.c7228 = this.getMappingField("STOP_SNEAKING", false, MappedClasses.CPacketEntityAction$Action);
      this.c5353 = this.getMappingField("START_SPRINTING", false, MappedClasses.CPacketEntityAction$Action);
      this.c3178 = this.getMappingField("STOP_SPRINTING", false, MappedClasses.CPacketEntityAction$Action);
   }

   public Object c6031() {
      return this.c7060.getObject(null);
   }

   public Object c7468() {
      return this.c7228.getObject(null);
   }

   public Object c1225() {
      return this.c5353.getObject(null);
   }

   public Object c8509() {
      return this.c3178.getObject(null);
   }
}
