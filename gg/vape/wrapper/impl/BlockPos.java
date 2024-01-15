package gg.vape.wrapper.impl;

import gg.vape.utils.datas.BlockData;

public class BlockPos extends Vec3i {
   public BlockPos(Object var1) {
      super(var1);
   }

   public static BlockPos c6918(Vec3 var0) {
      return new BlockPos(vape.getMappings().blockPos.c6780(var0.getObject()));
   }

   public static BlockPos c5782(BlockData var0) {
      return create(var0.c1368(), var0.c1908(), var0.c4775());
   }

   public static BlockPos create(int var0, int var1, int var2) {
      return new BlockPos(vape.getMappings().blockPos.c4854(var0, var1, var2));
   }

   public static BlockPos c5088(double var0, double var2, double var4) {
      return new BlockPos(vape.getMappings().blockPos.c4583(var0, var2, var4));
   }

   public BlockPos c8900(int var1, int var2, int var3) {
      return create(this.c3715() + var1, this.c7544() + var2, this.c2021() + var3);
   }

   public BlockPos c2201() {
       return new BlockPos(vape.getMappings().blockPos.c8903(this.obj));
   }

   public BlockPos offset(EnumFacing ef) {
      if(vape.getMappings().blockPos == null){
         System.out.println("1");
      }
      if(this.obj == null){
         System.out.println("2");
      }
      if(ef == null){
         System.out.println("2.2");
      }
      if(ef.getObject() == null){
         System.out.println("3");
      }
      return new BlockPos(vape.getMappings().blockPos.offset(this.obj, ef.getObject(), 1));
   }

   public String toString() {
      return this.c3715() + " " + this.c7544() + " " + this.c2021();
   }
}
