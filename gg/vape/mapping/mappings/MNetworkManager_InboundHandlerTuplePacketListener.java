package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import io.netty.util.concurrent.GenericFutureListener;

public class MNetworkManager_InboundHandlerTuplePacketListener extends Mapping {
   public final MappingMethod c3403;

   public MNetworkManager_InboundHandlerTuplePacketListener() {
      super(MappedClasses.InboundHandlerTuplePacketListener);
      this.c3403 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.Packet, GenericFutureListener[].class);
   }

   public Object c5070(Object var1, Object[] var2) {
      return this.c3403.c4955(var1, var2);
   }

   // $FF: synthetic method
   public static Object c6595(MNetworkManager_InboundHandlerTuplePacketListener var0, Object var1, Object[] var2) {
      return var0.c5070(var1, var2);
   }
}
