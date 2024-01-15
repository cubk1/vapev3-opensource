package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MRayTraceResult;
import gg.vape.wrapper.Wrapper;

public class RayTraceResult extends Wrapper {
   public RayTraceResult(Object var1) {
      super(var1);
   }

   public static RayTraceResult c4244(Entity var0, Vec3 var1) {
      return new RayTraceResult(vape.getMappings().rayTraceResult.c1352(var0.getObject(), var1.getObject()));
   }

   public static RayTraceResult c7207(RayTraceResult_type var0, Vec3 var1, EnumFacing var2, BlockPos var3) {
      return new RayTraceResult(vape.getMappings().rayTraceResult.c8549(var0.getObject(), var1.getObject(), var2.getObject(), var3.getObject()));
   }

   public Entity c4157() {
      return new Entity(vape.getMappings().rayTraceResult.c8903(this.obj));
   }

   public void c7364(Entity var1) {
      vape.getMappings().rayTraceResult.c5700(this.obj, var1.getObject());
   }

   public Vec3 c1518() {
      return new Vec3(vape.getMappings().rayTraceResult.c6780(this.obj));
   }

   public RayTraceResult_type c213() {
      return new RayTraceResult_type(MRayTraceResult.c2450(vape.getMappings().rayTraceResult, this.obj));
   }

   public int c2021() {
      if (ForgeVersion.minorVersion() == 13) {
         return vape.getMappings().rayTraceResult.c6882(this.obj);
      } else {
         BlockPos var1 = new BlockPos(vape.getMappings().rayTraceResult.c6347(this.obj));
         return var1.c3715();
      }
   }

   public int c341() {
      if (ForgeVersion.minorVersion() == 13) {
         return vape.getMappings().rayTraceResult.c2099(this.obj);
      } else {
         BlockPos var1 = new BlockPos(vape.getMappings().rayTraceResult.c6347(this.obj));
         return var1.c7544();
      }
   }

   public int c7219() {
      if (ForgeVersion.minorVersion() == 13) {
         return vape.getMappings().rayTraceResult.c3817(this.obj);
      } else {
         BlockPos var1 = new BlockPos(vape.getMappings().rayTraceResult.c6347(this.obj));
         return var1.c2021();
      }
   }

   public Block c4337() {
      return Minecraft.theWorld().getBlockByPos(this.c2021(), this.c341(), this.c7219());
   }

   public int c7217() {
      return ForgeVersion.minorVersion() == 13 ? vape.getMappings().rayTraceResult.c4526(this.obj) : (new EnumFacing(vape.getMappings().rayTraceResult.c3024(this.obj))).c1744();
   }
}
