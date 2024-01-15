package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MIChunkProvider extends Mapping {
   public final MappingMethod c763;

   public MIChunkProvider() {
      super("net/minecraft/world/chunk/IChunkProvider");
      if (ForgeVersion.minorVersion() >= 23) {
         this.c763 = this.getMappingMethodNoRemap("func_191062_e", false, Boolean.TYPE, Integer.TYPE, Integer.TYPE);
      } else {
         this.c763 = this.getMappingMethodNoRemap("chunkExists", true, Boolean.TYPE, Integer.TYPE, Integer.TYPE);
      }

   }

   public boolean c6014(Object var1, int var2, int var3) {
      return this.c763.c5509(var1, var2, var3);
   }
}
