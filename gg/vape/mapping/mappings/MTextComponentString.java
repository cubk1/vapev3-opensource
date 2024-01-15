package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;

public class MTextComponentString extends Mapping {
   public final MappingMethod c8108;
   public final MappingField c6342;

   public MTextComponentString() {
      super(MappedClasses.TextComponentString);
      this.c8108 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, String.class);
      this.c6342 = this.getMappingFieldNoRemap("text", true, String.class);
   }

   public Object c5068(String var1) {
      return this.c8108.c4955(var1);
   }

   public void c2338(Object var1, String var2) {
      this.c6342.setObject(var1, var2);
   }

   public String c68(Object var1) {
      return this.c6342.getObject(var1).toString();
   }

   // $FF: synthetic method
   public static Object c957(MTextComponentString var0, String var1) {
      return var0.c5068(var1);
   }

   // $FF: synthetic method
   public static String c3878(MTextComponentString var0, Object var1) {
      return var0.c68(var1);
   }

   // $FF: synthetic method
   public static void c993(MTextComponentString var0, Object var1, String var2) {
      var0.c2338(var1, var2);
   }
}
