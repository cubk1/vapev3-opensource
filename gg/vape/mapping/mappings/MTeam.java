package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MTeam extends Mapping {
   public final MappingMethod c6476;

   public MTeam() {
      super(MappedClasses.Team);
      this.c6476 = this.getMappingMethodNoRemap("isSameTeam", true, Boolean.TYPE, MappedClasses.Team);
   }

   public boolean c948(Object var1, Object var2) {
      return this.c6476.c5509(var1, var2);
   }

   // $FF: synthetic method
   public static boolean c5251(MTeam var0, Object var1, Object var2) {
      return var0.c948(var1, var2);
   }
}
