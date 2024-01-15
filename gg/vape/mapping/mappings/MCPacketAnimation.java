package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MCPacketAnimation extends Mapping {
   public final MappingMethod c1740;
   public MappingMethod c8805;

   public MCPacketAnimation() {
      super(MappedClasses.CPacketAnimation);
      this.c1740 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c8805 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.EnumHand);
      }

   }

   public Object c6031() {
      return this.c1740.c4955();
   }

   public Object c6780(Object var1) {
      return this.c8805.c4955(var1);
   }

}
