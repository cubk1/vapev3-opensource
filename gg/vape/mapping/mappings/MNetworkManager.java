package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MNetworkManager extends Mapping {
   public final MappingField c5938;
   public final MappingField c6936;
   public MappingField c2982;
   public MappingField c199;
   public MappingMethod c8599;
   public MappingMethod c4095;
   public final MappingMethod c6627;
   public final MappingMethod c4105;
   public final MappingMethod c8580;

   public MNetworkManager() {
      super(MappedClasses.NetworkManager);
      this.c5938 = this.getMappingFieldNoRemap("channel", true, MappedClasses.Channel);
      this.c6936 = this.getMappingFieldNoRemap("outboundPacketsQueue", true, Queue.class);
      if (ForgeVersion.minorVersion() == 13) {
         this.c2982 = this.getMappingFieldNoRemap("receivedPacketsQueue", true, Queue.class);
         this.c4095 = this.getMappingMethodNoRemap("func_150725_a", false, Void.TYPE, MappedClasses.Packet, GenericFutureListener[].class);
      } else {
         this.c199 = this.getMappingFieldNoRemap("field_181680_j", false, ReentrantReadWriteLock.class);
         this.c4095 = this.getMappingMethodNoRemap("func_179290_a", false, Void.TYPE, MappedClasses.Packet);
      }

      this.c6627 = this.getMappingMethodNoRemap("getNetHandler", true, MappedClasses.INetHandler);
      this.c4105 = this.getMappingMethodNoRemap("flushOutboundQueue", true, Void.TYPE);
      this.c8580 = this.getMappingMethodNoRemap("dispatchPacket", true, Void.TYPE, MappedClasses.Packet, GenericFutureListener[].class);
      this.c8599 = this.getMappingMethodNoRemap("channelRead0", false, Void.TYPE, MappedClasses.ChannelHandlerContext, MappedClasses.Packet);
   }

   public Object c6780(Object var1) {
      return this.c5938.getObject(var1);
   }

   public Object c8903(Object var1) {
      return this.c6627.invoke(var1);
   }

   public Queue c2186(Object var1) {
      return (Queue)this.c2982.getObject(var1);
   }

   public Queue c4503(Object var1) {
      return (Queue)this.c6936.getObject(var1);
   }

   public void c6279(Object var1) {
      this.c4105.c2642(var1);
   }

   public void c4449(Object var1, Object var2, Object[] var3) {
      this.c8580.c2642(var1, var2, var3);
   }

   public ReentrantReadWriteLock c8370(Object var1) {
      return (ReentrantReadWriteLock)this.c199.getObject(var1);
   }

   // $FF: synthetic method
   public static Object c7257(MNetworkManager var0, Object var1) {
      return var0.c6780(var1);
   }

   // $FF: synthetic method
   public static Object c5131(MNetworkManager var0, Object var1) {
      return var0.c8903(var1);
   }

   // $FF: synthetic method
   public static Queue c2(MNetworkManager var0, Object var1) {
      return var0.c2186(var1);
   }

   // $FF: synthetic method
   public static Queue c4347(MNetworkManager var0, Object var1) {
      return var0.c4503(var1);
   }

   // $FF: synthetic method
   public static void c1488(MNetworkManager var0, Object var1) {
      var0.c6279(var1);
   }

   // $FF: synthetic method
   public static void c1230(MNetworkManager var0, Object var1, Object var2, Object[] var3) {
      var0.c4449(var1, var2, var3);
   }

   // $FF: synthetic method
   public static ReentrantReadWriteLock c2793(MNetworkManager var0, Object var1) {
      return var0.c8370(var1);
   }
}
