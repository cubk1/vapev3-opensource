package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MPacket extends Mapping {
   public final MappingMethod c5273;
   public MappingMethod c2363;

   public MPacket() {
      super(MappedClasses.Packet);
      if (ForgeVersion.minorVersion() == 13) {
         this.c2363 = this.getMappingMethodNoRemap("hasPriority", true, Boolean.TYPE);
      }

      this.c5273 = this.getMappingMethodNoRemap("processPacket", true, Void.TYPE, MappedClasses.INetHandler);
   }

   public boolean c4246(Object var1) {
      return this.c2363.c5509(var1);
   }

   public void c6771(Object var1, Object var2) {
      this.c5273.c2642(var1, var2);
   }

   // $FF: synthetic method
   public static boolean c6529(MPacket var0, Object var1) {
      return var0.c4246(var1);
   }

   // $FF: synthetic method
   public static void c2245(MPacket var0, Object var1, Object var2) {
      var0.c6771(var1, var2);
   }
}
