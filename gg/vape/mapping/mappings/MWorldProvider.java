package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MWorldProvider extends Mapping {
   public final MappingField c1058;

   public MWorldProvider() {
      super(MappedClasses.WorldProvider);
      this.c1058 = this.getMappingFieldNoRemap("skyRenderer", false, MappedClasses.IRenderHandler);
   }

   public void c6771(Object var1, Object var2) {
      this.c1058.setObject(var1, var2);
   }
}
