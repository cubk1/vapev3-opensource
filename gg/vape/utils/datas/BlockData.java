package gg.vape.utils.datas;

import gg.vape.utils.MathUtil;
import gg.vape.wrapper.impl.BlockPos;
import gg.vape.wrapper.impl.EnumFacing;

public class BlockData {
   public final int c7499;
   public final int c8433;
   public final int c1538;

   public static BlockData c5803(BlockPos var0) {
      return new BlockData(var0.c3715(), var0.c7544(), var0.c2021());
   }

   public BlockData(int var1, int var2, int var3) {
      this.c7499 = var1;
      this.c8433 = var2;
      this.c1538 = var3;
   }

   public BlockData(double var1, double var3, double var5) {
      this(MathUtil.c5621(var1), MathUtil.c5621(var3), MathUtil.c5621(var5));
   }

   public int c1368() {
      return this.c7499;
   }

   public int c1908() {
      return this.c8433;
   }

   public int c4775() {
      return this.c1538;
   }

   public BlockData c430(EnumFacing var1) {
      return new BlockData(this.c1368() + var1.c7219(), this.c1908() + var1.c5705(), this.c4775() + var1.c7217());
   }

   public BlockData c4178(int var1, int var2, int var3) {
      return new BlockData(this.c1368() + var1, this.c1908() + var2, this.c4775() + var3);
   }
}
