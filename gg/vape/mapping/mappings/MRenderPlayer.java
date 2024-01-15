package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MRenderPlayer extends Mapping {
   public MappingField c6303;
   public MappingMethod c3649;

   public MRenderPlayer() {
      super(MappedClasses.RenderPlayer);
      if (ForgeVersion.minorVersion() > 13) {
         this.c3649 = this.getMappingMethodNoRemap("getMainModel", true, MappedClasses.ModelPlayer);
      } else {
         this.c6303 = this.getMappingFieldNoRemap("modelBipedMain", true, MappedClasses.ModelBiped);
      }

   }

   public Object c6780(Object var1) {
      return ForgeVersion.minorVersion() > 13 ? this.c3649.invoke(var1) : this.c6303.getObject(var1);
   }

   // $FF: synthetic method
   public static Object c4127(MRenderPlayer var0, Object var1) {
      return var0.c6780(var1);
   }
}
