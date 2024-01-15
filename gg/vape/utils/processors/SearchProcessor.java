package gg.vape.utils.processors;

import gg.vape.Vape;
import gg.vape.ui.unmap.SearchBlock;
import gg.vape.utils.RotationUtil;
import gg.vape.utils.datas.HSBData;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.Block;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.WorldClient;

import java.awt.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SearchProcessor implements Runnable {
   public final List c5671;
   public final List c5931;
   public final NumberValue c6177;
   public boolean c1586;
   public boolean c3484;
   public final int[][] c3976 = new int[][]{{0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1}};
   public final List c4623 = Arrays.asList(0, 8, 9, 30);

   public SearchProcessor(List var1, List var2, NumberValue var3) {
      this.c5671 = var1;
      this.c5931 = var2;
      this.c6177 = var3;
   }

   public HSBData c3468(int var1, int var2, int var3) {
      Iterator var4 = this.c5671.iterator();

      HSBData var5;
      do {
         if (!var4.hasNext()) {
            return null;
         }

         var5 = (HSBData)var4.next();
      } while(var5.c4291 != var1 || var5.c6771 != var2 || var5.c8812 != var3);

      return var5;
   }

   public boolean c2228(int var1, int var2, int var3) {
      WorldClient var4 = Minecraft.theWorld();
      int[][] var5 = this.c3976;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         int[] var8 = var5[var7];
         Block var9 = var4.getBlockByPos(var1 + var8[0], var2 + var8[1], var3 + var8[2]);
         int var10 = Block.c3697(var9);
         if (this.c4623.contains(var10)) {
            return true;
         }
      }

      return false;
   }

   public Color c1828(int var1, int var2) {
      Iterator var3 = this.c5931.iterator();

      SearchBlock var4;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         var4 = (SearchBlock)var3.next();
      } while(!var4.c8575(var1, var2));

      return var4.c6427();
   }

   public void run() {
      try {
         label95:
         while(this.c1586) {
            try {
               Thread.sleep(50L);
            } catch (InterruptedException var16) {
            }

            if (!Minecraft.theWorld().isNull() && !Minecraft.thePlayer().isNull()) {
               EntityPlayerSP var1 = Minecraft.thePlayer();
               WorldClient var2 = Minecraft.theWorld();
               int var3 = this.c6177.getValue().intValue();
               this.c2228(0, 0, 0);

               for(int var4 = -var3; var4 < var3; ++var4) {
                  for(int var5 = -var3; var5 < var3; ++var5) {
                     for(int var6 = -var3; var6 < var3; ++var6) {
                        if (!this.c1586) {
                           return;
                        }

                        if (Minecraft.theWorld().isNull() || !Minecraft.theWorld().equals(var2) || Minecraft.thePlayer().isNull() || !Minecraft.thePlayer().equals(var1)) {
                           this.c5671.clear();
                           continue label95;
                        }

                        int var7 = (int)var1.posX() + var4;
                        int var8 = (int)var1.posY() + var6;
                        int var9 = (int)var1.posZ() + var5;
                        Block var10 = var2.getBlockByPos(var7, var8, var9);
                        int var11 = Block.c3697(var10);
                        int var12 = var10.c7737(var7, var8, var9);
                        HSBData var13 = this.c3468(var7, var8, var9);
                        boolean var14 = var13 != null;
                        if (!var14) {
                           Color var15 = this.c1828(var11, var12);
                           if (var15 != null && (!this.c3484 || this.c2228(var7, var8, var9))) {
                              this.c5671.add(new HSBData(var7, var8, var9, var11, var15));
                           }
                        } else if (var11 != var13.c2810 || RotationUtil.c582(var1, var7, var8, var9) > 200.0) {
                           this.c5671.remove(var13);
                        }
                     }
                  }
               }
            }
         }
      } catch (Exception var17) {
         Vape.throwEx(var17);
      }

   }

   public void c1028() {
      this.c1586 = true;
      (new Thread(this)).start();
   }

   public void c3944() {
      this.c1586 = false;
   }

   public void c1100(boolean var1) {
      this.c3484 = var1;
   }
}
