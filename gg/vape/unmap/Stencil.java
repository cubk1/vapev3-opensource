package gg.vape.unmap;

import org.lwjgl.opengl.GL11;

public class Stencil {
   public static int c1949;
   public static int c1585;
   public static int c170;
   public static int c663;
   public static int c7638;
   public static int c5154;

   public Stencil(int var2, int var3, int var4, int var5, int var6, int var7) {
      c1949 = var2;
      c1585 = var3;
      c170 = var4;
      c663 = var5;
      c7638 = var6;
      c5154 = var7;
   }

   public void c1205() {
      GL11.glStencilFunc(c1949, c1585, c170);
      GL11.glStencilOp(c663, c7638, c5154);
   }
}
