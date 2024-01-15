package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MCPacketUseEntity extends Mapping {
   public final MappingField c5074;
   public final MappingField TextComponent;

   public MCPacketUseEntity() {
      super(MappedClasses.CPacketUseEntity$Action);
      this.c5074 = this.getMappingField("ATTACK", false, MappedClasses.CPacketUseEntity$Action);
      this.TextComponent = this.getMappingField("INTERACT_AT", false, MappedClasses.CPacketUseEntity$Action);
   }

   public Object c6031() {
      return this.c5074.getObject(null);
   }

   public Object c7468() {
      return this.TextComponent.getObject(null);
   }

}
