package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MIRenderHandler extends Mapping {
   public final MappingMethod c2226;

   public MIRenderHandler() {
      super(MappedClasses.IRenderHandler);
      this.c2226 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE);
   }

   public Object c6031() {
      return this.c2226.c4955();
   }
}
