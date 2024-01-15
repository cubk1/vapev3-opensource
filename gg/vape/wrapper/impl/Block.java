package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class Block extends Wrapper {
   public Block(Object var1) {
      super(var1);
   }

   public static int c3697(Block var0) {
      return vape.getMappings().block.c7740(var0.getObject());
   }

   public static Block c2509(String var0) {
      Object var1 = vape.getMappings().block.c5068(var0);
      return var1 == null ? null : new Block(var1);
   }

   public int c1744() {
      return vape.getMappings().block.c4023(this.obj);
   }

   public Material c4045() {
      return ForgeVersion.minorVersion() >= 23 ? new Material(vape.getMappings().block.c2076(this.obj, null)) : new Material(vape.getMappings().block.c5327(this.obj));
   }

   public void c5629(World var1, int var2, int var3, int var4, Entity var5) {
      vape.getMappings().block.c6203(this.obj, var1.getObject(), var2, var3, var4, var5.getObject());
   }

   public void c4225(World var1, Entity var2) {
      vape.getMappings().block.c8103(this.obj, var1.getObject(), var2.getObject());
   }

   public void c2944(World var1, BlockPos var2, Entity var3) {
      if (ForgeVersion.minorVersion() < 23) {
         vape.getMappings().block.c2824(this.obj, var1.getObject(), var2.getObject(), var3.getObject());
      }
   }

   public AxisAlignedBB c464(World var1, int var2, int var3, int var4) {
      return ForgeVersion.minorVersion() >= 23 ? null : new AxisAlignedBB(vape.getMappings().block.c4691(this.obj, var1.getObject(), var2, var3, var4));
   }

   public Boolean c987(BlockState var1, boolean var2) {
      return vape.getMappings().block.c1603(this.obj, var1, var2);
   }

   public boolean c983(int var1, boolean var2) {
      return vape.getMappings().block.c7961(this.obj, var1, var2);
   }

   public int c7737(int var1, int var2, int var3) {
      if (ForgeVersion.minorVersion() == 13) {
         return vape.getMappings().block.c1394(this.obj, Minecraft.theWorld().getObject(), var1, var2, var3);
      } else if (ForgeVersion.minorVersion() == 15) {
         return vape.getMappings().block.c2641(this.obj, Minecraft.theWorld().getObject(), BlockPos.create(var1, var2, var3).getObject());
      } else {
          return ForgeVersion.minorVersion() == 23 ? vape.getMappings().block.c2348(this.obj, Minecraft.theWorld()
                                                                                                       .getBlockState(BlockPos.create(var1, var2, var3))
                                                                                                       .getObject()) : 0;
      }
   }
}
