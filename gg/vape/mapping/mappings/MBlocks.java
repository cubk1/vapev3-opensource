package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.wrapper.impl.ForgeVersion;

public class MBlocks extends Mapping {
   public final MappingField c7015;
   public final MappingField c7206;
   public final MappingField c5433;

   public MBlocks() {
      super(MappedClasses.Blocks);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c7015 = this.getMappingField("LADDER", true, MappedClasses.Block);
         this.c7206 = this.getMappingField("STONE", true, MappedClasses.Block);
         this.c5433 = this.getMappingField("AIR", true, MappedClasses.Block);
      } else {
         this.c7015 = this.getMappingField("ladder", true, MappedClasses.Block);
         this.c7206 = this.getMappingField("stone", true, MappedClasses.Block);
         this.c5433 = this.getMappingField("air", true, MappedClasses.Block);
      }

   }

   public Object c6031() {
      return this.c7015.getObject(null);
   }

   public Object c7468() {
      return this.c7206.getObject(null);
   }

   public Object c1225() {
      return this.c5433.getObject(null);
   }

}
