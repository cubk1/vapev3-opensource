package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MGuiChest extends Mapping {
   public final MappingField c1540;

   public MGuiChest() {
      super(MappedClasses.GuiChest);
      this.c1540 = this.getMappingFieldNoRemap("lowerChestInventory", true, MappedClasses.IInventory);
   }

   public Object c6780(Object var1) {
      return this.c1540.getObject(var1);
   }

   // $FF: synthetic method
   public static Object c5978(MGuiChest var0, Object var1) {
      return var0.c6780(var1);
   }
}
