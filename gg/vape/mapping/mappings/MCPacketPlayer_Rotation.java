package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MCPacketPlayer_Rotation extends Mapping {
   public final MappingMethod c7728;

   public MCPacketPlayer_Rotation() {
      super(MappedClasses.C03PacketPlayer$C05PacketPlayerLook);
      this.c7728 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, Float.TYPE, Float.TYPE, Boolean.TYPE);
   }

   public Object c1099(float var1, float var2, boolean var3) {
      return this.c7728.c4955(var1, var2, var3);
   }

}
