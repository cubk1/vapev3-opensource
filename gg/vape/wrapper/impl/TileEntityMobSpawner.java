package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MTileEntityMobSpawner;

public class TileEntityMobSpawner extends TileEntity {
   public TileEntityMobSpawner(Object var1) {
      super(var1);
   }

   public MobSpawnerBaseLogic c439() {
      return new MobSpawnerBaseLogic(MTileEntityMobSpawner.c5059(vape.getMappings().tileEntityMobSpawner, this.obj));
   }
}
