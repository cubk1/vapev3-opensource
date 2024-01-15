package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.wrapper.impl.ForgeVersion;
import gg.vape.wrapper.impl.TileEntity;

public class MTileEntity extends Mapping {
   public MappingField c3307;
   public MappingField c3720;
   public MappingField c597;
   public MappingField c6500;

   public MTileEntity() {
      super(MappedClasses.TileEntity);
      TileEntity.c3363 = ForgeVersion.minorVersion() == 13;
      if (ForgeVersion.minorVersion() == 13) {
         this.c3307 = this.getMappingFieldNoRemap("xCoord", true, Integer.TYPE);
         this.c3720 = this.getMappingFieldNoRemap("yCoord", true, Integer.TYPE);
         this.c597 = this.getMappingFieldNoRemap("zCoord", true, Integer.TYPE);
      } else {
         this.c6500 = this.getMappingFieldNoRemap("pos", true, MappedClasses.BlockPos);
      }

   }

   public int c7740(Object var1) {
      return this.c3307.getInt(var1);
   }

   public int c4023(Object var1) {
      return this.c3720.getInt(var1);
   }

   public int c6882(Object var1) {
      return this.c597.getInt(var1);
   }

   public Object c5143(Object var1) {
      return this.c6500.getObject(var1);
   }
}
