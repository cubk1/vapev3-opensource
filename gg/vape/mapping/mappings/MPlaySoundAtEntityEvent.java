package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.wrapper.impl.ForgeVersion;

public class MPlaySoundAtEntityEvent extends Mapping {
   public final MappingField c771;

   public MPlaySoundAtEntityEvent() {
      super("net/minecraftforge/event/entity/PlaySoundAtEntityEvent");
      if (ForgeVersion.minorVersion() >= 23) {
         this.c771 = this.getMappingFieldNoRemap("name", false, MappedClasses.SoundEvent);
      } else {
         this.c771 = this.getMappingFieldNoRemap("name", false, String.class);
      }

   }

   public String c68(Object var1) {
      return this.c771.getObject(var1).toString();
   }
}
