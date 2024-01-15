package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MItemTool extends Mapping {
   public final MappingField c8013;

   public MItemTool() {
      super(MappedClasses.ItemTool);
      this.c8013 = this.getMappingFieldNoRemap("toolMaterial", true, MappedClasses.Item$ToolMaterial);
   }

   public Object c6780(Object var1) {
      return this.c8013.getObject(var1);
   }

   // $FF: synthetic method
   public static Object c4940(MItemTool var0, Object var1) {
      return var0.c6780(var1);
   }
}
