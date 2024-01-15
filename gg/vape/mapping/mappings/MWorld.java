package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.BlockPos;
import gg.vape.wrapper.impl.ForgeVersion;

import java.util.List;

public class MWorld extends Mapping {
   public final MappingMethod c7704;
   public final MappingMethod c6214;
   public final MappingMethod c900;
   public final MappingField loadedEntityList = this.getMappingFieldNoRemap("loadedEntityList", true, List.class);
   public final MappingField c2278 = this.getMappingFieldNoRemap("playerEntities", true, List.class);
   public final MappingField c5096 = this.getMappingFieldNoRemap("loadedTileEntityList", true, List.class);
   public final MappingField c8594;
   public MappingMethod c1260;
   public MappingMethod c7844;
   public MappingMethod c1856;
   public final MappingMethod c173;
   public final MappingMethod c5881;
   public final MappingMethod c2588;
   public final MappingMethod c4805;
   public final MappingMethod c8887;
   public MappingMethod c6708;
   public final MappingMethod c4926;
   public final MappingMethod c8073;

   public MWorld() {
      super(MappedClasses.World);
      this.c8594 = this.getMappingFieldNoRemap("provider", true, MappedClasses.WorldProvider);
      this.c7704 = this.getMappingMethodNoRemap("getEntitiesWithinAABBExcludingEntity", true, List.class, MappedClasses.Entity, MappedClasses.AxisAlignedBB);
      this.c900 = this.getMappingMethodNoRemap("func_147470_e", false, Boolean.TYPE, MappedClasses.AxisAlignedBB);
      this.c173 = this.getMappingMethodNoRemap("removeEntity", true, Void.TYPE, MappedClasses.Entity);
      this.c4805 = this.getMappingMethodNoRemap("getChunkFromChunkCoords", true, MappedClasses.Chunk, Integer.TYPE, Integer.TYPE);
      this.c8887 = this.getMappingMethodNoRemap("getChunkProvider", true, MappedClasses.IChunkProvider);
      this.c8073 = this.getMappingMethodNoRemap("getEntityByID", true, MappedClasses.Entity, Integer.TYPE);
      if (ForgeVersion.minorVersion() == 13) {
         this.c2588 = this.getMappingMethodNoRemap("checkChunksExist", true, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         this.c1260 = this.getMappingMethodNoRemap("getBlock", true, MappedClasses.Block, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         this.c5881 = this.getMappingMethodNoRemap("func_147447_a", false, MappedClasses.RayTraceResult, MappedClasses.Vec3d, MappedClasses.Vec3d, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE);
         this.c6708 = this.getMappingMethodNoRemap("getBlockMetadata", true, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         this.c4926 = this.getMappingMethodNoRemap("blockExists", true, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
      } else {
         this.c2588 = this.getMappingMethodNoRemap("func_175707_a", false, Boolean.TYPE, MappedClasses.BlockPos, MappedClasses.BlockPos);
         this.c7844 = this.getMappingMethodNoRemap("getBlockState", true, MappedClasses.IBlockState, MappedClasses.BlockPos);
         this.c1856 = this.getMappingMethodNoRemap("isFlammableWithin", true, Boolean.TYPE, MappedClasses.AxisAlignedBB);
         this.c5881 = this.getMappingMethodNoRemap("rayTraceBlocks", true, MappedClasses.RayTraceResult, MappedClasses.Vec3d, MappedClasses.Vec3d, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE);
         this.c4926 = this.getMappingMethodNoRemap("isValid", true, Boolean.TYPE, MappedClasses.BlockPos);
      }

      if (ForgeVersion.minorVersion() >= 23) {
         this.c6214 = this.getMappingMethodNoRemap("getCollisionBoxes", true, List.class, MappedClasses.Entity, MappedClasses.AxisAlignedBB);
      } else {
         this.c6214 = this.getMappingMethodNoRemap("getCollidingBoundingBoxes", true, List.class, MappedClasses.Entity, MappedClasses.AxisAlignedBB);
      }

   }

   public Object c6780(Object var1) {
      return this.c8887.invoke(var1);
   }

   public Object c2277(Object var1, Object var2, Object var3, boolean var4, boolean var5, boolean var6) {
      return this.c5881.invoke(var1, var2, var3, var4, var5, var6);
   }

   public List loadedEntityList(Object var1) {
      return (List)this.loadedEntityList.getObject(var1);
   }

   public List c1013(Object var1) {
      return (List)this.c2278.getObject(var1);
   }

   public List c203(Object var1) {
      return (List)this.c5096.getObject(var1);
   }

   public List c7149(Object var1, Object var2, Object var3) {
      return (List)this.c7704.invoke(var1, var2, var3);
   }

   public Object c441(Object var1, int var2, int var3, int var4) {
      return this.c1260.invoke(var1, var2, var3, var4);
   }

   public Object c1352(Object var1, Object var2) {
      return this.c7844.invoke(var1, var2);
   }

   public List c421(Object var1, Object var2, Object var3) {
      return (List)this.c6214.invoke(var1, var2, var3);
   }

   public boolean c7780(Object var1, Object var2) {
      return this.c900.c5509(var1, var2);
   }

   public boolean c4408(Object var1, Object var2) {
      return this.c1856.c5509(var1, var2);
   }

   public void c4067(Object var1, Object var2) {
      this.c173.c2642(var1, var2);
   }

   public Object c5156(Object var1) {
      return this.c8594.getObject(var1);
   }

   public boolean c1540(Object var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      return this.c2588.c5509(var1, var2, var3, var4, var5, var6, var7);
   }

   public boolean c2573(Object var1, Object var2, Object var3) {
      return this.c2588.c5509(var1, var2, var3);
   }

   public Object c672(Object var1, int var2, int var3) {
      return this.c4805.invoke(var1, var2, var3);
   }

   public int c6319(Object var1, int var2, int var3, int var4) {
      return this.c6708.c2555(var1, var2, var3, var4);
   }

   public boolean c300(Object var1, int var2, int var3, int var4) {
      return ForgeVersion.minorVersion() == 13 ? this.c4926.c5509(var1, var2, var3, var4) : this.c4926.c5509(var1, BlockPos
              .create(var2, var3, var4).getObject());
   }

   public Object c2260(Object var1, int var2) {
      return this.c8073.invoke(var1, var2);
   }

   // $FF: synthetic method
   public static boolean c353(MWorld var0, Object var1, Object var2) {
      return var0.c7780(var1, var2);
   }

   // $FF: synthetic method
   public static boolean c3471(MWorld var0, Object var1, Object var2) {
      return var0.c4408(var1, var2);
   }

   // $FF: synthetic method
   public static void c8081(MWorld var0, Object var1, Object var2) {
      var0.c4067(var1, var2);
   }

   // $FF: synthetic method
   public static Object c6679(MWorld var0, Object var1) {
      return var0.c5156(var1);
   }

   // $FF: synthetic method
   public static boolean c2657(MWorld var0, Object var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      return var0.c1540(var1, var2, var3, var4, var5, var6, var7);
   }

   // $FF: synthetic method
   public static boolean c6235(MWorld var0, Object var1, Object var2, Object var3) {
      return var0.c2573(var1, var2, var3);
   }

   // $FF: synthetic method
   public static Object c7140(MWorld var0, Object var1, int var2, int var3) {
      return var0.c672(var1, var2, var3);
   }

   // $FF: synthetic method
   public static int c4280(MWorld var0, Object var1, int var2, int var3, int var4) {
      return var0.c6319(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static boolean c8937(MWorld var0, Object var1, int var2, int var3, int var4) {
      return var0.c300(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static Object c5990(MWorld var0, Object var1, int var2) {
      return var0.c2260(var1, var2);
   }
}
