package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MITextureObject extends Mapping {
   public final MappingMethod c872;

   public MITextureObject() {
      super(MappedClasses.ITextureObject);
      this.c872 = this.getMappingMethodNoRemap("getGlTextureId", true, Integer.TYPE);
   }

   public int c7740(Object var1) {
      return this.c872.c2555(var1);
   }

   // $FF: synthetic method
   public static int c5938(MITextureObject var0, Object var1) {
      return var0.c7740(var1);
   }
}
