package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MWorld;
import gg.vape.wrapper.Wrapper;

import java.util.List;

public class World extends Wrapper {
   public World(Object var1) {
      super(var1);
   }

   public List<Entity> loadedEntityList() {
      return vape.getMappings().world.loadedEntityList(this.obj);
   }

   public List c8905() {
      return vape.getMappings().world.c1013(this.obj);
   }

   public List c1445() {
      return vape.getMappings().world.c203(this.obj);
   }

   public List c7700(Entity var1, AxisAlignedBB var2) {
      return vape.getMappings().world.c7149(this.obj, var1.getObject(), var2.getObject());
   }

   public Block getBlock(double var1, double var3, double var5) {
      if (ForgeVersion.minorVersion() == 13) {
         return new Block(vape.getMappings().world.c441(this.obj, (int)var1, (int)var3, (int)var5));
      } else {
         BlockPos var7 = BlockPos.c5088(var1, var3, var5);
         BlockState var8 = new BlockState(vape.getMappings().world.c1352(this.obj, var7.getObject()));
         return var8.c4613();
      }
   }

   public Block getBlockByPos(int var1, int var2, int var3) {
      if (ForgeVersion.minorVersion() == 13) {
         return new Block(vape.getMappings().world.c441(this.obj, var1, var2, var3));
      } else {
         BlockPos var4 = BlockPos.create(var1, var2, var3);
         BlockState var5 = new BlockState(vape.getMappings().world.c1352(this.obj, var4.getObject()));
         return var5.c4613();
      }
   }

   public List<AxisAlignedBB> getCollisionBoxes(Entity var1, AxisAlignedBB var2) {
      return vape.getMappings().world.c421(this.obj, var1.getObject(), var2.getObject());
   }

   public boolean c4757(AxisAlignedBB var1) {
      return MWorld.c353(vape.getMappings().world, this.obj, var1.getObject());
   }

   public BlockState getBlockState(BlockPos var1) {
      return new BlockState(vape.getMappings().world.c1352(this.obj, var1.getObject()));
   }

   public boolean c6520(AxisAlignedBB var1) {
      return MWorld.c3471(vape.getMappings().world, this.obj, var1.getObject());
   }

   public void c7364(Entity var1) {
      MWorld.c8081(vape.getMappings().world, this.obj, var1.getObject());
   }

   public WorldProvider getWorldProvider() {
      return new WorldProvider(MWorld.c6679(vape.getMappings().world, this.obj));
   }

   public RayTraceResult c3811(Vec3 var1, Vec3 var2, boolean var3, boolean var4, boolean var5) {
      return new RayTraceResult(vape.getMappings().world.c2277(this.obj, var1.getObject(), var2.getObject(), var3, var4, var5));
   }

   public boolean c7029(int var1, int var2, int var3, int var4, int var5, int var6) {
      return ForgeVersion.minorVersion() == 13 ? MWorld.c2657(vape.getMappings().world, this.obj, var1, var2, var3, var4, var5, var6) : MWorld.c6235(vape.getMappings().world, this.obj, BlockPos.create(var1, var2, var3), BlockPos.create(var4, var5, var6));
   }

   public Chunk c8950(int var1, int var2) {
      return new Chunk(MWorld.c7140(vape.getMappings().world, this.obj, var1, var2));
   }

   public ChunkProvider getChunkProvider() {
      return new ChunkProvider(vape.getMappings().world.c6780(this.obj));
   }

   public int c4491(int var1, int var2, int var3) {
      return MWorld.c4280(vape.getMappings().world, this.obj, var1, var2, var3);
   }

   public boolean c240(int var1, int var2, int var3) {
      return MWorld.c8937(vape.getMappings().world, this.obj, var1, var2, var3);
   }

   public Entity c7325(int var1) {
      return new Entity(MWorld.c5990(vape.getMappings().world, this.obj, var1));
   }
}
