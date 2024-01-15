package gg.vape.wrapper.impl;

import gg.vape.utils.Vec3d;
import gg.vape.wrapper.Wrapper;

public class Vec3 extends Wrapper {
   public Vec3(Object var1) {
      super(var1);
   }

   public static Vec3 create(double var0, double var2, double var4) {
      return new Vec3(vape.getMappings().vec3d.c4583(var0, var2, var4));
   }

   public Vec3 c6302(double var1) {
      return create(this.getX() * var1, this.getY() * var1, this.getZ() * var1);
   }

   public Vec3 c8894(Vec3 var1) {
      return this.c5090(var1.getX(), var1.getY(), var1.getZ());
   }

   public Vec3 c5090(double var1, double var3, double var5) {
      return new Vec3(vape.getMappings().vec3d.c1466(this.obj, var1, var3, var5));
   }

   public double getX() {
      return vape.getMappings().vec3d.c3661(this.obj);
   }

   public double getY() {
      return vape.getMappings().vec3d.c83(this.obj);
   }

   public double getZ() {
      return vape.getMappings().vec3d.c3650(this.obj);
   }

   public double c3571(Vec3 var1) {
      return vape.getMappings().vec3d.c3970(this.obj, var1.getObject());
   }

   public double squareDistanceTo(Vec3 var1) {
      return vape.getMappings().vec3d.squareDistanceTo(this.obj, var1.getObject());
   }

   public String toString() {
      return "[" + this.getX() + "," + this.getY() + "," + this.getZ() + "]";
   }

   public Vec3d c1167() {
      return new Vec3d(this.getX(), this.getY(), this.getZ());
   }
}
