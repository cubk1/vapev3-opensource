package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.wrapper.impl.ForgeVersion;

public class MSharedMonsterAttributes extends Mapping {
   public final MappingField c7518;

   public MSharedMonsterAttributes() {
      super(MappedClasses.SharedMonsterAttributes);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c7518 = this.getMappingField("MOVEMENT_SPEED", true, MappedClasses.IAttribute);
      } else {
         this.c7518 = this.getMappingField("movementSpeed", true, MappedClasses.IAttribute);
      }

   }

   public Object c6031() {
      return this.c7518.getObject(null);
   }
}
