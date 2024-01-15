package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MTextComponentTranslation extends Mapping {
   public final MappingMethod c7907;

   public MTextComponentTranslation() {
      super(MappedClasses.TextComponentTranslation);
      this.c7907 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, String.class, Object[].class);
   }

   public Object c6675(String var1, Object... var2) {
      return this.c7907.c4955(var1, var2);
   }

   // $FF: synthetic method
   public static Object c7492(MTextComponentTranslation var0, String var1, Object[] var2) {
      return var0.c6675(var1, var2);
   }
}
