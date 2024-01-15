package gg.vape.unmap;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import java.nio.FloatBuffer;

public class GLUtils {
   public FloatBuffer c8244;
   public int c462;
   public int c7372 = 2;
   public int c5297 = 7;
   public int c366 = -1;
   public float[] c7779;

   public void c6803(int var1, int var2) {
      this.c462 = var1;
      this.c5297 = var2;
      this.c7372 = 3;
      this.c7779 = new float[var1 * this.c7372];
      this.c8244 = BufferUtils.createFloatBuffer(var1 * this.c7372);
   }

   public void c8045(int var1) {
      this.c6803(var1, 7);
   }

   public void c1732() {
      GL11.glEnableClientState(32884);
      GL11.glVertexPointer(this.c7372, 0, this.c8244);
      GL11.glDrawArrays(this.c5297, 0, this.c462);
      GL11.glDisableClientState(32884);
      this.c366 = 0;
   }

   public void c4183() {
      this.c366 = 0;
      this.c7779 = new float[this.c462 * this.c7372];
      this.c8244.clear();
   }

   public void c8660() {
      this.c8244.put(this.c7779);
      this.c8244.flip();
      this.c1732();
   }

   public void c6007(float var1, float var2) {
      this.c7779[this.c366++] = var1;
      this.c7779[this.c366++] = var2;
   }

   public void c8852(double var1, double var3, double var5) {
      this.c7779[this.c366++] = (float)var1;
      this.c7779[this.c366++] = (float)var3;
      this.c7779[this.c366++] = (float)var5;
   }
}
