package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MCPacketPlayer_PositionRotation extends Mapping {
   public MappingMethod c8481;
   public MappingMethod c312;

   public MCPacketPlayer_PositionRotation() {
      super(MappedClasses.C03PacketPlayer$C06PacketPlayerPosLook);
      if (ForgeVersion.minorVersion() > 13) {
         this.c312 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE, Boolean.TYPE);
      } else {
         this.c8481 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE, Boolean.TYPE);
      }

   }

   public Object c7425(double var1, double var3, double var5, double var7, float var9, float var10, boolean var11) {
      return this.c8481.c4955(var1, var3, var5, var7, var9, var10, var11);
   }

   public Object c2706(double var1, double var3, double var5, float var7, float var8, boolean var9) {
      return this.c312.c4955(var1, var3, var5, var7, var8, var9);
   }

}
