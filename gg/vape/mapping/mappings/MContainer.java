package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;

import java.util.List;

public class MContainer extends Mapping {
   public final MappingField c7903 = this.getMappingFieldNoRemap("inventorySlots", true, List.class);
   public final MappingField c8333;
   public final MappingMethod c4906;

   public MContainer() {
      super(MappedClasses.Container);
      this.c8333 = this.getMappingFieldNoRemap("windowId", true, Integer.TYPE);
      this.c4906 = this.getMappingMethodNoRemap("getSlot", true, MappedClasses.Slot, Integer.TYPE);
   }

   public List c7156(Object var1) {
      return (List)this.c7903.getObject(var1);
   }

   public int c4023(Object var1) {
      return this.c8333.getInt(var1);
   }

   public Object c2260(Object var1, int var2) {
      return this.c4906.invoke(var1, var2);
   }

}
