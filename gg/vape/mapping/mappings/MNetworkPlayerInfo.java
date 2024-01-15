package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MNetworkPlayerInfo extends Mapping {
   public final MappingMethod c7362;

   public MNetworkPlayerInfo() {
      super(MappedClasses.NetworkPlayerInfo);
      this.c7362 = this.getMappingMethodNoRemap("getGameProfile", true, MappedClasses.GameProfile);
   }

   public Object c6780(Object var1) {
      return this.c7362.invoke(var1);
   }

   // $FF: synthetic method
   public static Object c4885(MNetworkPlayerInfo var0, Object var1) {
      return var0.c6780(var1);
   }
}
