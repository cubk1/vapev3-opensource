package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class AxisAlignedBB extends Wrapper {
   public AxisAlignedBB(Object object) {
      super(object);
   }

   public static AxisAlignedBB c2682(double var0, double var2, double var4, double var6, double var8, double var10) {
      return new AxisAlignedBB(vape.getMappings().axisAlignedBB.init(var0, var2, var4, var6, var8, var10));
   }

   public AxisAlignedBB c8708(double var1, double var3, double var5) {
      return new AxisAlignedBB(vape.getMappings().axisAlignedBB.addCoord(this.obj, var1, var3, var5));
   }

   public AxisAlignedBB c6096(double var1, double var3, double var5) {
      return new AxisAlignedBB(vape.getMappings().axisAlignedBB.expand(this.obj, var1, var3, var5));
   }

   public RayTraceResult c2786(Vec3 var1, Vec3 var2) {
      return new RayTraceResult(vape.getMappings().axisAlignedBB.calculateIntercept(this.obj, var1.getObject(), var2.getObject()));
   }

   public boolean c6966(Vec3 var1) {
      return vape.getMappings().axisAlignedBB.isVecInside(this.obj, var1.getObject());
   }

   public AxisAlignedBB offset(double var1, double var3, double var5) {
      return new AxisAlignedBB(vape.getMappings().axisAlignedBB.offset(this.obj, var1, var3, var5));
   }

   public double minX() {
      return vape.getMappings().axisAlignedBB.minX(this.obj);
   }

   public double minY() {
      return vape.getMappings().axisAlignedBB.minY(this.obj);
   }

   public double c7584() {
      return vape.getMappings().axisAlignedBB.minZ(this.obj);
   }

   public double c63() {
      return vape.getMappings().axisAlignedBB.maxX(this.obj);
   }

   public double c8246() {
      return vape.getMappings().axisAlignedBB.maxY(this.obj);
   }

   public double c1898() {
      return vape.getMappings().axisAlignedBB.maxZ(this.obj);
   }

   public AxisAlignedBB copy() {
       return new AxisAlignedBB(vape.getMappings().axisAlignedBB.copy(this.obj));
   }

   public AxisAlignedBB c1377(double var1, double var3, double var5) {
      return ForgeVersion.minorVersion() > 13 ? this.offset(var1, var3, var5) : new AxisAlignedBB(vape.getMappings().axisAlignedBB.getOffsetBoundingBox(this.obj, var1, var3, var5));
   }

   public double c2705(AxisAlignedBB var1, double var2) {
      return vape.getMappings().axisAlignedBB.calculateXOffset(this.obj, var1.getObject(), var2);
   }

   public double c8329(AxisAlignedBB var1, double var2) {
      return vape.getMappings().axisAlignedBB.calculateYOffset(this.obj, var1.getObject(), var2);
   }

   public double c4507(AxisAlignedBB var1, double var2) {
      return vape.getMappings().axisAlignedBB.calculateZOffset(this.obj, var1.getObject(), var2);
   }

   public void c1130(AxisAlignedBB var1) {
      vape.getMappings().axisAlignedBB.setBB(this.obj, var1.getObject());
   }

   public AxisAlignedBB c982(double var1, double var3, double var5) {
      return new AxisAlignedBB(vape.getMappings().axisAlignedBB.contract(this.obj, var1, var3, var5));
   }

   public boolean c6520(AxisAlignedBB var1) {
      return vape.getMappings().axisAlignedBB.intersectsWith(this.obj, var1.getObject());
   }
}
