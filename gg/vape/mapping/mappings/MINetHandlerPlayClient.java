package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MINetHandlerPlayClient extends Mapping {
   public final MappingMethod c14;

   public MINetHandlerPlayClient() {
      super(MappedClasses.INetHandlerPlayClient);
      this.c14 = this.getMappingMethodNoRemap("handleEntityTeleport", true, Void.TYPE, MappedClasses.SPacketEntityTeleport);
   }

   public void c6771(Object var1, Object var2) {
      this.c14.c2642(var1, var2);
   }

   // $FF: synthetic method
   public static void c3430(MINetHandlerPlayClient var0, Object var1, Object var2) {
      var0.c6771(var1, var2);
   }
}
