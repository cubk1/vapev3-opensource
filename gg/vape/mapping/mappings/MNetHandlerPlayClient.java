package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

import java.util.Collection;

public class MNetHandlerPlayClient extends Mapping {
   public final MappingMethod c7283;
   public MappingMethod c5974;

   public MNetHandlerPlayClient() {
      super(MappedClasses.NetHandlerPlayClient);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c7283 = this.getMappingMethodNoRemap("sendPacket", true, Void.TYPE, MappedClasses.Packet);
      } else {
         this.c7283 = this.getMappingMethodNoRemap("addToSendQueue", true, Void.TYPE, MappedClasses.Packet);
      }

      if (ForgeVersion.minorVersion() > 13) {
         this.c5974 = this.getMappingMethodNoRemap("getPlayerInfoMap", true, Collection.class);
      }

   }

   public void c6771(Object var1, Object var2) {
      this.c7283.c2642(var1, var2);
   }

   public Collection c6452(Object var1) {
      return (Collection)this.c5974.invoke(var1);
   }

   // $FF: synthetic method
   public static void c1224(MNetHandlerPlayClient var0, Object var1, Object var2) {
      var0.c6771(var1, var2);
   }

   // $FF: synthetic method
   public static Collection c3137(MNetHandlerPlayClient var0, Object var1) {
      return var0.c6452(var1);
   }
}
