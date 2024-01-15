package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

import java.util.Set;

public class MRegistrySimple extends Mapping {
   public final MappingMethod c296 = this.getMappingMethodNoRemap("getKeys", true, Set.class);
   public final MappingMethod c4281 = this.getMappingMethodNoRemap("getObject", true, Object.class, Object.class);

   public MRegistrySimple() {
      super(MappedClasses.RegistrySimple);
   }

   public Set c1062(Object var1) {
      return (Set)this.c296.invoke(var1);
   }

   public Object c1352(Object var1, Object var2) {
      return this.c4281.invoke(var1, var2);
   }

   // $FF: synthetic method
   public static Object c5183(MRegistrySimple var0, Object var1, Object var2) {
      return var0.c1352(var1, var2);
   }
}
