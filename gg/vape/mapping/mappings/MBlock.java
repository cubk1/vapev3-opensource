package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.BlockPos;
import gg.vape.wrapper.impl.ForgeVersion;

public class MBlock extends Mapping {
   public final MappingMethod c6287;
   public MappingMethod c6372;
   public final MappingMethod c1647;
   public final MappingMethod c5046;
   public MappingMethod c879;
   public MappingMethod c1569;
   public MappingMethod c3554;
   public final MappingMethod c4494;
   public final MappingMethod c3040;
   public final MappingMethod c4951;

   public MBlock() {
      super(MappedClasses.Block);
      this.c6287 = this.getMappingMethod("getIdFromBlock", true, Integer.TYPE, MappedClasses.Block);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c1647 = this.getMappingMethodNoRemap("getMaterial", true, MappedClasses.Material, MappedClasses.IBlockState);
      } else {
         this.c6372 = this.getMappingMethodNoRemap("getRenderType", true, Integer.TYPE);
         this.c1647 = this.getMappingMethodNoRemap("getMaterial", true, MappedClasses.Material);
      }

      this.c5046 = this.getMappingMethod("getBlockFromName", true, MappedClasses.Block, String.class);
      if (ForgeVersion.minorVersion() == 13) {
         this.c879 = this.getMappingMethodNoRemap("onEntityWalking", true, Void.TYPE, MappedClasses.World, Integer.TYPE, Integer.TYPE, Integer.TYPE, MappedClasses.Entity);
         this.c4494 = this.getMappingMethodNoRemap("getCollisionBoundingBoxFromPool", true, MappedClasses.AxisAlignedBB, MappedClasses.World, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         this.c3040 = this.getMappingMethodNoRemap("canCollideCheck", true, Boolean.TYPE, Integer.TYPE, Boolean.TYPE);
      } else {
         this.c1569 = this.getMappingMethodNoRemap("onLanded", true, Void.TYPE, MappedClasses.World, MappedClasses.Entity);
         this.c3040 = this.getMappingMethodNoRemap("canCollideCheck", true, Boolean.TYPE, MappedClasses.IBlockState, Boolean.TYPE);
         if (ForgeVersion.minorVersion() >= 23) {
            this.c3554 = this.getMappingMethodNoRemap("onEntityCollidedWithBlock", true, Void.TYPE, MappedClasses.World, MappedClasses.BlockPos, MappedClasses.IBlockState, MappedClasses.Entity);
            this.c4494 = this.getMappingMethodNoRemap("getCollisionBoundingBox", true, MappedClasses.AxisAlignedBB, MappedClasses.IBlockState, MappedClasses.IBlockAccess, MappedClasses.BlockPos);
         } else {
            this.c3554 = this.getMappingMethodNoRemap("onEntityCollidedWithBlock", true, Void.TYPE, MappedClasses.World, MappedClasses.BlockPos, MappedClasses.Entity);
            this.c4494 = this.getMappingMethodNoRemap("getCollisionBoundingBox", true, MappedClasses.AxisAlignedBB, MappedClasses.World, MappedClasses.BlockPos, MappedClasses.IBlockState);
         }
      }

      if (ForgeVersion.minorVersion() <= 15) {
         if (ForgeVersion.minorVersion() == 13) {
            this.c4951 = this.getMappingMethodNoRemap("getDamageValue", true, Integer.TYPE, MappedClasses.World, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         } else {
            this.c4951 = this.getMappingMethodNoRemap("getDamageValue", true, Integer.TYPE, MappedClasses.World, MappedClasses.BlockPos);
         }
      } else {
         this.c4951 = this.getMappingMethodNoRemap("getMetaFromState", true, Integer.TYPE, MappedClasses.IBlockState);
      }

   }

   public int c1394(Object var1, Object var2, int var3, int var4, int var5) {
      return this.c4951.c2555(var1, var2, var3, var4, var5);
   }

   public int c2641(Object var1, Object var2, Object var3) {
      return this.c4951.c2555(var1, var2, var3);
   }

   public int c2348(Object var1, Object var2) {
      return this.c4951.c2555(var1, var2);
   }

   public boolean c1603(Object var1, Object var2, boolean var3) {
      return this.c3040.c5509(var1, var2, var3);
   }

   public boolean c7961(Object var1, int var2, boolean var3) {
      return this.c3040.c5509(var1, var2, var3);
   }

   public int c7740(Object var1) {
      return this.c6287.c2555(null, var1);
   }

   public int c4023(Object var1) {
      return this.c6372.c2555(var1);
   }

   public Object c5068(String var1) {
      return this.c5046.invoke(null, var1);
   }

   public Object c5327(Object var1) {
      return this.c1647.invoke(var1);
   }

   public Object c2076(Object var1, Object var2) {
      return this.c1647.invoke(var1, var2);
   }

   public void c6203(Object var1, Object var2, int var3, int var4, int var5, Object var6) {
      this.c879.c2642(var1, var2, var3, var4, var5, var6);
   }

   public void c8103(Object var1, Object var2, Object var3) {
      this.c1569.c2642(var1, var2, var3);
   }

   public void c2824(Object var1, Object var2, Object var3, Object var4) {
      this.c3554.c2642(var1, var2, var3, var4);
   }

   public Object c4691(Object var1, Object var2, int var3, int var4, int var5) {
      return ForgeVersion.minorVersion() == 13 ? this.c4494.invoke(var1, var2, var3, var4, var5) : this.c4494.invoke(var1, var2, BlockPos
              .create(var3, var4, var5).getObject(), null);
   }

}
