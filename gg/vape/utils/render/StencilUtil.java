package gg.vape.utils.render;

import gg.vape.unmap.Stencil;
import gg.vape.wrapper.impl.Framebuffer;
import gg.vape.wrapper.impl.Minecraft;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;

public final class StencilUtil {
   public static final StencilUtil c8374 = new StencilUtil();
   public final HashMap c5568 = new HashMap();
   public int c7616 = 1;
   public boolean c4729;

   public static StencilUtil c7754() {
      return c8374;
   }

   public void c4316(boolean var1) {
      this.c4729 = var1;
   }

   public static void c8373() {
      Framebuffer var0 = Minecraft.getFrameBuffer();
      if (var0.isNotNull() && var0.depthBuffer() > -1) {
         c7013(var0);
         var0.depthBuffer(-1);
      }

   }

   public static void c7013(Framebuffer var0) {
      EXTFramebufferObject.glDeleteRenderbuffersEXT(var0.depthBuffer());
      int var1 = EXTFramebufferObject.glGenRenderbuffersEXT();
      EXTFramebufferObject.glBindRenderbufferEXT(36161, var1);
      EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, Minecraft.displayWidth(), Minecraft.displayHeight());
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, var1);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, var1);
   }

   public void c6883() {
      if (this.c7616 == 1) {
         GL11.glClearStencil(0);
         GL11.glClear(1024);
      }

      GL11.glEnable(2960);
      ++this.c7616;
      if (this.c7616 > this.c1315()) {
         System.out.println("StencilUtil: Reached maximum amount of layers!");
         this.c7616 = 1;
      }

   }

   public void c482() {
      if (this.c7616 == 1) {
         System.out.println("StencilUtil: No layers found!");
      } else {
         --this.c7616;
         if (this.c7616 == 1) {
            GL11.glDisable(2960);
         } else {
            Stencil var1 = (Stencil)this.c5568.remove(this.c7616);
            if (var1 != null) {
               var1.c1205();
            }
         }

      }
   }

   public void c4617() {
      GL11.glClearStencil(0);
      GL11.glClear(1024);
      this.c5568.clear();
      this.c7616 = 1;
   }

   public void c631() {
      this.c2261(new Stencil(this.c4729 ? 519 : 512, this.c7616, this.c1315(), 7681, 7680, 7680));
   }

   public void c2499(boolean var1) {
      this.c2261(new Stencil(this.c4729 ? 519 : 512, var1 ? this.c7616 : this.c7616 - 1, this.c1315(), 7681, 7681, 7681));
   }

   public void c3895() {
      this.c2261(new Stencil(517, this.c7616, this.c1315(), 7680, 7680, 7680));
   }

   public void c6241() {
      this.c2261(new Stencil(514, this.c7616, this.c1315(), 7680, 7680, 7680));
   }

   public void c2261(Stencil var1) {
      GL11.glStencilFunc(Stencil.c1949, Stencil.c1585, Stencil.c170);
      GL11.glStencilOp(Stencil.c663, Stencil.c7638, Stencil.c5154);
      this.c5568.put(this.c7616, var1);
   }

   public Stencil c3049() {
      return (Stencil)this.c5568.get(this.c7616);
   }

   public int c1085() {
      return this.c7616;
   }

   public int c587() {
      return GL11.glGetInteger(3415);
   }

   public int c1315() {
      return (int)(Math.pow(2.0, this.c587()) - 1.0);
   }

   public void c6425(double var1, double var3, double var5) {
      GL11.glBegin(6);

      for(int var7 = 0; var7 <= 360; ++var7) {
         double var8 = Math.sin((double)var7 * Math.PI / 180.0) * var5;
         double var10 = Math.cos((double)var7 * Math.PI / 180.0) * var5;
         GL11.glVertex2d(var1 + var8, var3 + var10);
      }

      GL11.glEnd();
   }

   public void c8128(double var1, double var3, double var5, double var7) {
      GL11.glBegin(7);
      GL11.glVertex2d(var1, var7);
      GL11.glVertex2d(var5, var7);
      GL11.glVertex2d(var5, var3);
      GL11.glVertex2d(var1, var3);
      GL11.glEnd();
   }
}
