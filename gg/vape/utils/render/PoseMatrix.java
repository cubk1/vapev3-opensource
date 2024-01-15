package gg.vape.utils.render;

public class PoseMatrix {
   public int c8953;
   public int c4060;
   public int c1252;
   public int c3697;

   public PoseMatrix(int x0, int var2, int var3, int var4) {
      this.c8953 = x0;
      this.c4060 = var2;
      this.c1252 = var3;
      this.c3697 = var4;
   }

   public void c8202(int var1, int var2, int var3, int var4) {
      this.c8953 = var1;
      this.c4060 = var2;
      this.c1252 = var3;
      this.c3697 = var4;
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof PoseMatrix)) {
         return false;
      } else {
         PoseMatrix var2 = (PoseMatrix)var1;
         return this.c8953 == var2.c8953 && this.c4060 == var2.c4060 && this.c1252 == var2.c1252 && this.c3697 == var2.c3697;
      }
   }

   public int hashCode() {
      int var1 = this.c4060 + this.c1252;
      int var2 = this.c3697 + this.c8953;
      int var3 = var1 * (var1 + 1) / 2 + this.c4060;
      int var4 = var2 * (var2 + 1) / 2 + this.c8953;
      int var5 = var3 + var4;
      return var5 * (var5 + 1) / 2 + var4;
   }
}
