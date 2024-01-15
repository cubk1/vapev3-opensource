package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MIBlockState extends Mapping {
   public final MappingMethod c3277;

   public MIBlockState() {
      super("net/minecraft/block/state/IBlockState");
      this.c3277 = this.getMappingMethodNoRemap("getBlock", true, MappedClasses.Block);
   }

   public Object c6780(Object var1) {
      return this.c3277.invoke(var1);
   }
}
