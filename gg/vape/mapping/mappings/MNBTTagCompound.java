package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MNBTTagCompound extends Mapping {
   public final MappingMethod c6950;

   public MNBTTagCompound() {
      super(MappedClasses.NBTTagCompound);
      this.c6950 = this.getMappingMethodNoRemap("getShort", true, Short.TYPE, String.class);
   }

   public short c2333(Object var1, String var2) {
      return this.c6950.c5409(var1, var2);
   }

   // $FF: synthetic method
   public static short c7567(MNBTTagCompound var0, Object var1, String var2) {
      return var0.c2333(var1, var2);
   }
}
