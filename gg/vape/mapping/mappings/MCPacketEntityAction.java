package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MCPacketEntityAction extends Mapping {
   public MappingMethod c309;
   public MappingMethod c7130;

   public MCPacketEntityAction() {
      super(MappedClasses.CPacketEntityAction);
      if (ForgeVersion.minorVersion() > 13) {
         this.c7130 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.Entity, MappedClasses.CPacketEntityAction$Action);
      } else {
         this.c309 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.Entity, Integer.TYPE);
      }

   }

   public Object c2260(Object var1, int var2) {
      return this.c309.c4955(var1, var2);
   }

   public Object c1352(Object var1, Object var2) {
      return this.c7130.c4955(var1, var2);
   }
}
