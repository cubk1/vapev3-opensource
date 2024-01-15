package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MTileEntityChest extends Mapping {
   public final MappingField c2224;
   public final MappingField c8138;

   public MTileEntityChest() {
      super("net/minecraft/tileentity/TileEntityChest");
      this.c2224 = this.getMappingFieldNoRemap("lidAngle", true, Float.TYPE);
      this.c8138 = this.getMappingFieldNoRemap("numPlayersUsing", true, Integer.TYPE);
   }

   public float c8820(Object var1) {
      return this.c2224.getFloat(var1);
   }

   public int c4023(Object var1) {
      return this.c8138.getInt(var1);
   }
}
