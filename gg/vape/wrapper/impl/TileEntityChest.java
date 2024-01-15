package gg.vape.wrapper.impl;

public class TileEntityChest extends TileEntity {
   public TileEntityChest(Object var1) {
      super(var1);
   }

   public float c8901() {
      return vape.getMappings().tileEntityChest.c8820(this.getObject());
   }

   public float c4311() {
      return (float) vape.getMappings().tileEntityChest.c4023(this.getObject());
   }
}
