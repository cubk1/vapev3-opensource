package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;

public class MSlot extends Mapping {
   public final MappingField c6401;
   public final MappingMethod c8956;

   public MSlot() {
      super(MappedClasses.Slot);
      this.c8956 = this.getMappingMethodNoRemap("getStack", true, MappedClasses.ItemStack);
      this.c6401 = this.getMappingFieldNoRemap("slotNumber", true, Integer.TYPE);
   }

   public Object c6780(Object var1) {
      return this.c8956.invoke(var1);
   }

   public int c4023(Object var1) {
      return this.c6401.getInt(var1);
   }

   // $FF: synthetic method
   public static int c6448(MSlot var0, Object var1) {
      return var0.c4023(var1);
   }
}
