package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MTextureManager extends Mapping {
   public final MappingMethod c2548;

   public MTextureManager() {
      super(MappedClasses.TextureManager);
      this.c2548 = this.getMappingMethodNoRemap("getTexture", true, MappedClasses.ITextureObject, MappedClasses.ResourceLocation);
   }

   public Object c1352(Object var1, Object var2) {
      return this.c2548.invoke(var1, var2);
   }

   // $FF: synthetic method
   public static Object c2214(MTextureManager var0, Object var1, Object var2) {
      return var0.c1352(var1, var2);
   }
}
