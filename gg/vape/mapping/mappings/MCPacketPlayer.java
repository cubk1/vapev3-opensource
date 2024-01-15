package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MCPacketPlayer extends Mapping {
   public final MappingMethod c3969;

   public MCPacketPlayer() {
      super(MappedClasses.CPacketPlayer);
      this.c3969 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, Boolean.TYPE);
   }

   public Object c3890(boolean var1) {
      return this.c3969.c4955(var1);
   }

}
