package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MMinecraftForge extends Mapping {
   public final MappingField c8891;

   public MMinecraftForge() {
      super(MappedClasses.MinecraftForge);
      this.c8891 = this.getMappingField("EVENT_BUS", false, MappedClasses.EventBus);
   }

   public Object c6031() {
      return this.c8891.getObject(null);
   }
}
