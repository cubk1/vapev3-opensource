package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class TileEntity extends Wrapper {
   public static boolean c3363;

   public TileEntity(Object var1) {
      super(var1);
   }

   public int c1744() {
      return c3363 ? vape.getMappings().tileEntity.c7740(this.obj) : this.c4614().c3715();
   }

   public int c3715() {
      return c3363 ? vape.getMappings().tileEntity.c4023(this.obj) : this.c4614().c7544();
   }

   public int c7544() {
      return c3363 ? vape.getMappings().tileEntity.c6882(this.obj) : this.c4614().c2021();
   }

   public BlockPos c4614() {
      return new BlockPos(vape.getMappings().tileEntity.c5143(this.obj));
   }

}
