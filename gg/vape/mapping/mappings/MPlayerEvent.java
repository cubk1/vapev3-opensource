package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MPlayerEvent extends Mapping {
   public final MappingField c6506;

   public MPlayerEvent() {
      super("net/minecraftforge/event/entity/player/PlayerEvent");
      this.c6506 = this.getMappingFieldNoRemap("entityPlayer", false, MappedClasses.EntityPlayer);
   }

   public Object c6780(Object var1) {
      return this.c6506.getObject(var1);
   }
}
