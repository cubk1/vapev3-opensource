package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MCPacketPlayer_Position extends Mapping {
   public MappingMethod c2309;
   public MappingMethod c5873;

   public MCPacketPlayer_Position() {
      super(MappedClasses.C03PacketPlayer$C04PacketPlayerPosition);
      if (ForgeVersion.minorVersion() > 13) {
         this.c5873 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Boolean.TYPE);
      } else {
         this.c2309 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Boolean.TYPE);
      }

   }

   public Object c239(double var1, double var3, double var5, double var7, boolean var9) {
      return this.c2309.c4955(var1, var3, var5, var7, var9);
   }

   public Object c2412(double var1, double var3, double var5, boolean var7) {
      return this.c5873.c4955(var1, var3, var5, var7);
   }

}
