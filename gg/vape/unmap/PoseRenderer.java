package gg.vape.unmap;

import gg.vape.ui.click.IGuiRenderer;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.IGuiCompontHandler;
import gg.vape.utils.RendererException;
import gg.vape.utils.render.PoseMatrix;

import java.util.Iterator;

public class PoseRenderer implements IGuiRenderer {
   public static final int c4607 = 5000;
   public final int c3755;
   public final int c6390;
   public final double c5272;
   public final double c8725;
   public final PoseMatrix matrix;
   public boolean c4204 = true;
   public boolean c1858 = true;
   public IGuiCompontHandler handler;

   //todo SliderRenderer?
   public PoseRenderer(double var1, double var3, int var5, int var6, PoseMatrix poseMatrix) {
      this.c8725 = var1;
      this.c5272 = var3;
      this.c6390 = var5;
      this.c3755 = var6;
      this.matrix = poseMatrix;
   }

   public int c3017() {
      return this.c3755;
   }

   public int c2900() {
      if (this.c6390 == 5000) {
         double size = this.handler.getDisplayableComponents().size();
         double var3 = this.c3017();
         return (int)Math.ceil(size / var3);
      } else {
         return this.c6390;
      }
   }

   public double c5363() {
      return this.c5272;
   }

   public double c3600() {
      return this.c8725;
   }

   public PoseMatrix c1250() {
      return this.matrix;
   }

   public void adaptHandler(IGuiCompontHandler handler) {
      this.handler = handler;
   }

   public void c4895() {
      this.c4204 = false;
   }

   public void c2598() {
      this.c1858 = false;
   }

   public void c8084() {
      if (this.c2900() * this.c3017() < this.handler.getDisplayableComponents().size()) {
         throw new RendererException("Not enough cells to render all children!");
      } else {
         IGuiComponent[][] var1 = new IGuiComponent[this.c3017()][this.c2900()];
         IGuiComponent[][] var2 = new IGuiComponent[this.c2900()][this.c3017()];
         int var3 = 0;
         int var4 = 0;

         int var7;
         for(Iterator var5 = this.handler.getDisplayableComponents().iterator(); var5.hasNext(); ++var3) {
            IGuiComponent var6 = (IGuiComponent)var5.next();
            var7 = 0;
            if (var3 != 0) {
               var7 = var3 % this.c3017();
               if (var7 == 0) {
                  ++var4;
               }
            }

            var1[var7][var4] = var6;
            var2[var4][var7] = var6;
         }

         if (var3 > 0) {
            double[] var24 = new double[this.c3017()];

            IGuiComponent[] var8;
            int var10;
            for(int var25 = 0; var25 < var1.length; ++var25) {
               IGuiComponent[] var27 = var1[var25];
               var8 = var27;
               int var9 = var27.length;

               for(var10 = 0; var10 < var9; ++var10) {
                  IGuiComponent var11 = var8[var10];
                  if (var11 != null && var11.getWidth() > var24[var25]) {
                     var24[var25] = var11.getWidth();
                  }
               }
            }

            double[] var26 = new double[this.c2900()];

            int var32;
            for(var7 = 0; var7 < var2.length; ++var7) {
               var8 = var2[var7];
               IGuiComponent[] var29 = var8;
               var10 = var8.length;

               for(var32 = 0; var32 < var10; ++var32) {
                  IGuiComponent var12 = var29[var32];
                  if (var12 != null && var12.getWidth() > var26[var7]) {
                     var26[var7] = var12.getHeight();
                  }
               }
            }

            double var28 = 0.0;
            double[] var30 = var24;
            var10 = var24.length;

            for(var32 = 0; var32 < var10; ++var32) {
               double var33 = var30[var32];
               var28 += var33;
            }

            double var31 = 0.0;
            double[] var34 = var26;
            int var35 = var26.length;

            for(int var13 = 0; var13 < var35; ++var13) {
               double var14 = var34[var13];
               var31 += var14;
            }

            var32 = this.c2900() - 1;
            var35 = this.c3017() - 1;
            double var36 = (double)(this.matrix.c4060 + this.matrix.c3697) + var28 + (double)var35 * this.c8725;
            double var15 = (double)(this.matrix.c8953 + this.matrix.c1252) + var31 + (double)var32 * this.c5272;
            if (this.c1858) {
               this.handler.c740().setHeight(var15);
            }

            if (this.c4204) {
               this.handler.c740().setWidth(var36);
            }

            double var17 = this.handler.getX() + (double)this.matrix.c4060;
            double var19 = this.handler.getY() + (double)this.matrix.c8953;

            for(int var21 = 0; var21 < this.c2900(); ++var21) {
               for(int var22 = 0; var22 < this.c3017(); ++var22) {
                  IGuiComponent component = var2[var21][var22];
                  if (component != null) {
                     component.c1042(var17);
                     component.c467(var19);
                     var17 += var24[var22];
                     var17 += this.c3600();
                  }
               }

               var17 = this.handler.getX() + (double)this.matrix.c4060;
               var19 += var26[var21];
               var19 += this.c5363();
            }
         }

      }
   }
}
