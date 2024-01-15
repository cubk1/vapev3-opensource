package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.module.none.ClientSettings;

public class MTileEntityEnderChest extends Mapping {
   public final MappingField c1192;
   public final MappingField c5582;

   public MTileEntityEnderChest() {
      super("net/minecraft/tileentity/TileEntityEnderChest");
      this.c1192 = this.getMappingFieldNoRemap(ClientSettings.not1710 ? "lidAngle" : "field_145972_a", true, Float.TYPE);
      this.c5582 = this.getMappingFieldNoRemap(ClientSettings.not1710 ? "numPlayersUsing" : "field_145973_j", true, Integer.TYPE);
   }

   public float c8820(Object var1) {
      return this.c1192.getFloat(var1);
   }

   public int c4023(Object var1) {
      return this.c5582.getInt(var1);
   }
}
