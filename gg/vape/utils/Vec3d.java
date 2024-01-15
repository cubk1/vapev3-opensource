package gg.vape.utils;

import gg.vape.wrapper.impl.Vec3;

public class Vec3d {
   public double xCoord;
   public double yCoord;
   public double zCorrd;

   public Vec3d() {
      this.xCoord = 0.0;
      this.yCoord = 0.0;
      this.zCorrd = 0.0;
   }

   public Vec3d(Vec3 vec3) {
      this.xCoord = vec3.getX();
      this.yCoord = vec3.getY();
      this.zCorrd = vec3.getZ();
   }

   public Vec3d(double var1, double var3, double var5) {
      this.xCoord = var1;
      this.yCoord = var3;
      this.zCorrd = var5;
   }

   public double c8935() {
      return this.xCoord;
   }

   public void c5332(double var1) {
      this.xCoord = var1;
   }

   public double c6718() {
      return this.yCoord;
   }

   public void c6155(double var1) {
      this.yCoord = var1;
   }

   public double c4080() {
      return this.zCorrd;
   }

   public void c3432(double var1) {
      this.zCorrd = var1;
   }

   public void c2566(float var1) {
      float var2 = (float)Math.cos(var1);
      float var3 = (float)Math.sin(var1);
      double var4 = this.xCoord;
      double var6 = this.yCoord * (double)var2 + this.zCorrd * (double)var3;
      double var8 = this.zCorrd * (double)var2 - this.yCoord * (double)var3;
      this.xCoord = var4;
      this.yCoord = var6;
      this.zCorrd = var8;
   }

   public void c2294(float var1) {
      float var2 = (float)Math.cos(var1);
      float var3 = (float)Math.sin(var1);
      double var4 = this.xCoord * (double)var2 + this.zCorrd * (double)var3;
      double var6 = this.yCoord;
      double var8 = this.zCorrd * (double)var2 - this.xCoord * (double)var3;
      this.xCoord = var4;
      this.yCoord = var6;
      this.zCorrd = var8;
   }
}
