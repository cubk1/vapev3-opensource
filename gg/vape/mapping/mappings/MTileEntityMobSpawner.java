package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MTileEntityMobSpawner extends Mapping {
   public final MappingMethod c519;

   public MTileEntityMobSpawner() {
      super(MappedClasses.TileEntityMobSpawner);
      this.c519 = this.getMappingMethodNoRemap("func_145881_a", false, MappedClasses.MobSpawnerBaseLogic);
   }

   public Object c6780(Object var1) {
      return this.c519.invoke(var1);
   }

   // $FF: synthetic method
   public static Object c5059(MTileEntityMobSpawner var0, Object var1) {
      return var0.c6780(var1);
   }
}
