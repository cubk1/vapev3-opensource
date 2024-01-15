package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MNBTTagList extends Mapping {
   public final MappingMethod c2125;
   public final MappingMethod c1874;

   public MNBTTagList() {
      super(MappedClasses.NBTTagList);
      this.c2125 = this.getMappingMethodNoRemap("tagCount", true, Integer.TYPE);
      this.c1874 = this.getMappingMethodNoRemap("getCompoundTagAt", true, MappedClasses.NBTTagCompound, Integer.TYPE);
   }

   public int c7740(Object var1) {
      return this.c2125.c2555(var1);
   }

   public Object c2260(Object var1, int var2) {
      return this.c1874.invoke(var1, var2);
   }

   // $FF: synthetic method
   public static int c891(MNBTTagList var0, Object var1) {
      return var0.c7740(var1);
   }

   // $FF: synthetic method
   public static Object c7390(MNBTTagList var0, Object var1, int var2) {
      return var0.c2260(var1, var2);
   }
}
