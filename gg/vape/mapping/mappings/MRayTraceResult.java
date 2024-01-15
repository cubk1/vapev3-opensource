package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MRayTraceResult extends Mapping {
   public final MappingMethod c1966;
   public MappingMethod c1258;
   public final MappingField c7977;
   public final MappingField c6310;
   public final MappingField c4679;
   public MappingField c2167;
   public MappingField c6362;
   public MappingField c3344;
   public MappingField c3346;
   public final MappingField c4338;

   public MRayTraceResult() {
      super(MappedClasses.RayTraceResult);
      this.c7977 = this.getMappingFieldNoRemap("hitVec", true, MappedClasses.Vec3d);
      this.c6310 = this.getMappingFieldNoRemap("entityHit", true, MappedClasses.Entity);
      this.c4679 = this.getMappingFieldNoRemap("typeOfHit", true, MappedClasses.RayTraceResult$Type);
      if (ForgeVersion.minorVersion() == 13) {
         this.c2167 = this.getMappingFieldNoRemap("blockX", true, Integer.TYPE);
         this.c6362 = this.getMappingFieldNoRemap("blockY", true, Integer.TYPE);
         this.c3344 = this.getMappingFieldNoRemap("blockZ", true, Integer.TYPE);
         this.c4338 = this.getMappingFieldNoRemap("sideHit", true, Integer.TYPE);
      } else {
         this.c3346 = this.getMappingFieldNoRemap("blockPos", true, MappedClasses.BlockPos);
         this.c4338 = this.getMappingFieldNoRemap("sideHit", true, MappedClasses.EnumFacing);
      }

      this.c1966 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.Entity, MappedClasses.Vec3d);
      if (ForgeVersion.minorVersion() > 13) {
         this.c1258 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.RayTraceResult$Type, MappedClasses.Vec3d, MappedClasses.EnumFacing, MappedClasses.BlockPos);
      }

   }

   public Object c6780(Object var1) {
      return this.c7977.getObject(var1);
   }

   public Object c1352(Object var1, Object var2) {
      return this.c1966.c4955(var1, var2);
   }

   public Object c8549(Object var1, Object var2, Object var3, Object var4) {
      return this.c1258.c4955(var1, var2, var3, var4);
   }

   public Object c8903(Object var1) {
      return this.c6310.getObject(var1);
   }

   public void c5700(Object var1, Object var2) {
      this.c6310.setObject(var1, var2);
   }

   public Object c984(Object var1) {
      return this.c4679.getObject(var1);
   }

   public int c6882(Object var1) {
      return this.c2167.getInt(var1);
   }

   public int c2099(Object var1) {
      return this.c6362.getInt(var1);
   }

   public int c3817(Object var1) {
      return this.c3344.getInt(var1);
   }

   public Object c6347(Object var1) {
      return this.c3346.getObject(var1);
   }

   public int c4526(Object var1) {
      return this.c4338.getInt(var1);
   }

   public Object c3024(Object var1) {
      return this.c4338.getObject(var1);
   }

   // $FF: synthetic method
   public static Object c2450(MRayTraceResult var0, Object var1) {
      return var0.c984(var1);
   }
}
