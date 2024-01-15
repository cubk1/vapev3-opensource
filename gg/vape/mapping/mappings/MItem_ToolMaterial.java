package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MItem_ToolMaterial extends Mapping {
   public final MappingField c1667;

   public MItem_ToolMaterial() {
      super(MappedClasses.Item$ToolMaterial);
      this.c1667 = this.getMappingField("GOLD", false, MappedClasses.Item$ToolMaterial);
   }

   public Object c6031() {
      return this.c1667.getObject(null);
   }

   // $FF: synthetic method
   public static Object c7280(MItem_ToolMaterial var0) {
      return var0.c6031();
   }
}
