package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MMobSpawnerBaseLogic extends Mapping {
   public MappingMethod c518;
   public MappingMethod c6099;

   public MMobSpawnerBaseLogic() {
      super(MappedClasses.MobSpawnerBaseLogic);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c6099 = this.getMappingMethodNoRemap("getCachedEntity", true, MappedClasses.Entity);
      } else {
         this.c518 = this.getMappingMethodNoRemap("getEntityNameToSpawn", true, String.class);
      }

   }

   public String c68(Object var1) {
      return (String)this.c518.invoke(var1);
   }

   public Object c8903(Object var1) {
      return this.c6099.invoke(var1);
   }

   // $FF: synthetic method
   public static Object c4054(MMobSpawnerBaseLogic var0, Object var1) {
      return var0.c8903(var1);
   }

   // $FF: synthetic method
   public static String c6132(MMobSpawnerBaseLogic var0, Object var1) {
      return var0.c68(var1);
   }
}
