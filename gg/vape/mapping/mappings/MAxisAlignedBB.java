package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MAxisAlignedBB extends Mapping {
   public final MappingField minX;
   public final MappingField minY;
   public final MappingField minZ;
   public final MappingField maxX;
   public final MappingField maxY;
   public final MappingField maxZ;
   public final MappingMethod init;
   public final MappingMethod addCoord;
   public final MappingMethod expand;
   public final MappingMethod calculateIntercept;
   public final MappingMethod isVecInside;
   public final MappingMethod offset;
   public final MappingMethod calculateYOffset;
   public final MappingMethod calculateXOffset;
   public final MappingMethod calculateZOffset;
   public MappingMethod contract;
   public final MappingMethod intersectsWith;
   public MappingMethod copy;
   public MappingMethod getOffsetBoundingBox;
   public MappingMethod setBB;

   public MAxisAlignedBB() {
      super(MappedClasses.AxisAlignedBB);
      this.minX = this.getMappingFieldNoRemap("minX", true, Double.TYPE);
      this.minY = this.getMappingFieldNoRemap("minY", true, Double.TYPE);
      this.minZ = this.getMappingFieldNoRemap("minZ", true, Double.TYPE);
      this.maxX = this.getMappingFieldNoRemap("maxX", true, Double.TYPE);
      this.maxY = this.getMappingFieldNoRemap("maxY", true, Double.TYPE);
      this.maxZ = this.getMappingFieldNoRemap("maxZ", true, Double.TYPE);
      this.addCoord = this.getMappingMethodNoRemap("addCoord", true, MappedClasses.AxisAlignedBB, Double.TYPE, Double.TYPE, Double.TYPE);
      this.expand = this.getMappingMethodNoRemap("expand", true, MappedClasses.AxisAlignedBB, Double.TYPE, Double.TYPE, Double.TYPE);
      this.calculateIntercept = this.getMappingMethodNoRemap("calculateIntercept", true, MappedClasses.RayTraceResult, MappedClasses.Vec3d, MappedClasses.Vec3d);
      this.isVecInside = this.getMappingMethodNoRemap("isVecInside", true, Boolean.TYPE, MappedClasses.Vec3d);
      if (ForgeVersion.minorVersion() >= 23) {
         this.offset = this.getMappingMethodNoRemap("func_72317_d", false, MappedClasses.AxisAlignedBB, Double.TYPE, Double.TYPE, Double.TYPE);
      } else {
         this.offset = this.getMappingMethodNoRemap("offset", true, MappedClasses.AxisAlignedBB, Double.TYPE, Double.TYPE, Double.TYPE);
         this.contract = this.getMappingMethodNoRemap("contract", true, MappedClasses.AxisAlignedBB, Double.TYPE, Double.TYPE, Double.TYPE);
      }

      this.calculateXOffset = this.getMappingMethodNoRemap("calculateXOffset", true, Double.TYPE, MappedClasses.AxisAlignedBB, Double.TYPE);
      this.calculateYOffset = this.getMappingMethodNoRemap("calculateYOffset", true, Double.TYPE, MappedClasses.AxisAlignedBB, Double.TYPE);
      this.calculateZOffset = this.getMappingMethodNoRemap("calculateZOffset", true, Double.TYPE, MappedClasses.AxisAlignedBB, Double.TYPE);
      this.intersectsWith = this.getMappingMethodNoRemap("intersectsWith", true, Boolean.TYPE, MappedClasses.AxisAlignedBB);
      if (ForgeVersion.minorVersion() == 13) {
         this.copy = this.getMappingMethodNoRemap("copy", true, MappedClasses.AxisAlignedBB);
         this.getOffsetBoundingBox = this.getMappingMethodNoRemap("getOffsetBoundingBox", true, MappedClasses.AxisAlignedBB, Double.TYPE, Double.TYPE, Double.TYPE);
         this.setBB = this.getMappingMethodNoRemap("setBB", true, Void.TYPE, MappedClasses.AxisAlignedBB);
      }

      this.init = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE);
   }

   public Object init(double var1, double var3, double var5, double var7, double var9, double var11) {
      return this.init.c4955(var1, var3, var5, var7, var9, var11);
   }

   public Object addCoord(Object var1, double var2, double var4, double var6) {
      return this.addCoord.invoke(var1, var2, var4, var6);
   }

   public Object expand(Object var1, double var2, double var4, double var6) {
      return this.expand.invoke(var1, var2, var4, var6);
   }

   public Object calculateIntercept(Object var1, Object var2, Object var3) {
      return this.calculateIntercept.invoke(var1, var2, var3);
   }

   public boolean isVecInside(Object var1, Object var2) {
      return this.isVecInside.c5509(var1, var2);
   }

   public Object offset(Object var1, double var2, double var4, double var6) {
      return this.offset.invoke(var1, var2, var4, var6);
   }

   public double minX(Object var1) {
      return this.minX.getDouble(var1);
   }

   public double minY(Object var1) {
      return this.minY.getDouble(var1);
   }

   public double minZ(Object var1) {
      return this.minZ.getDouble(var1);
   }

   public double maxX(Object var1) {
      return this.maxX.getDouble(var1);
   }

   public double maxY(Object var1) {
      return this.maxY.getDouble(var1);
   }

   public double maxZ(Object var1) {
      return this.maxZ.getDouble(var1);
   }

   public Object copy(Object var1) {
      return this.copy.invoke(var1);
   }

   public Object getOffsetBoundingBox(Object var1, double var2, double var4, double var6) {
      return this.getOffsetBoundingBox.invoke(var1, var2, var4, var6);
   }

   public double calculateXOffset(Object var1, Object var2, double var3) {
      return this.calculateXOffset.c4409(var1, var2, var3);
   }

   public double calculateYOffset(Object var1, Object var2, double var3) {
      return this.calculateYOffset.c4409(var1, var2, var3);
   }

   public double calculateZOffset(Object var1, Object var2, double var3) {
      return this.calculateZOffset.c4409(var1, var2, var3);
   }

   public void setBB(Object var1, Object var2) {
      this.setBB.c2642(var1, var2);
   }

   public Object contract(Object var1, double var2, double var4, double var6) {
      return this.contract.invoke(var1, var2, var4, var6);
   }

   public boolean intersectsWith(Object var1, Object var2) {
      return this.intersectsWith.c5509(var1, var2);
   }

}
