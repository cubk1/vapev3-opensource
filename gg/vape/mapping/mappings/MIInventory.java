package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MIInventory extends Mapping {
   public final MappingMethod c2377;
   public final MappingMethod c6026;
   public MappingMethod c7863;
   public MappingMethod c7964;

   public MIInventory() {
      super(MappedClasses.IInventory);
      this.c2377 = this.getMappingMethodNoRemap("getSizeInventory", true, Integer.TYPE);
      this.c6026 = this.getMappingMethodNoRemap("getStackInSlot", true, MappedClasses.ItemStack, Integer.TYPE);
      if (ForgeVersion.minorVersion() == 13) {
         this.c7863 = this.getMappingMethodNoRemap("getInventoryName", true, String.class);
         this.c7964 = this.getMappingMethodNoRemap("hasCustomInventoryName", true, Boolean.TYPE);
      }

   }

   public int c7740(Object var1) {
      return this.c2377.c2555(var1);
   }

   public Object c2260(Object var1, int var2) {
      return this.c6026.invoke(var1, var2);
   }

   public String c4340(Object var1) {
      return this.c7863.invoke(var1).toString();
   }

   public boolean c2418(Object var1) {
      return this.c7964.c5509(var1);
   }

   // $FF: synthetic method
   public static String c330(MIInventory var0, Object var1) {
      return var0.c4340(var1);
   }

   // $FF: synthetic method
   public static int c2894(MIInventory var0, Object var1) {
      return var0.c7740(var1);
   }

   // $FF: synthetic method
   public static Object c196(MIInventory var0, Object var1, int var2) {
      return var0.c2260(var1, var2);
   }

   // $FF: synthetic method
   public static boolean c4909(MIInventory var0, Object var1) {
      return var0.c2418(var1);
   }
}
