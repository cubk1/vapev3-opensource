package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MMobSpawnerBaseLogic;
import gg.vape.wrapper.Wrapper;

public class MobSpawnerBaseLogic extends Wrapper {
   public MobSpawnerBaseLogic(Object var1) {
      super(var1);
   }

   public String c6376() {
      if (ForgeVersion.minorVersion() >= 23) {
         Entity var1 = new Entity(MMobSpawnerBaseLogic.c4054(vape.getMappings().mobSpawnerBaseLogic, this.obj));
         return var1.isNotNull() ? var1.getName() : "";
      } else {
         return MMobSpawnerBaseLogic.c6132(vape.getMappings().mobSpawnerBaseLogic, this.obj);
      }
   }
}
