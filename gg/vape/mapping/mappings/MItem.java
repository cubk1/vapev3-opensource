package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MItem extends Mapping {
   public final MappingMethod c4560;
   public final MappingMethod c3261;
   public final MappingMethod c4507;
   public final MappingMethod c2932;
   public MappingMethod c4603;
   public MappingMethod c8242;
   public final MappingField c44;

   public MItem() {
      super("net/minecraft/item/Item");
      this.c4560 = this.getMappingMethodNoRemap("getUnlocalizedNameInefficiently", true, String.class, MappedClasses.ItemStack);
      this.c3261 = this.getMappingMethodNoRemap("getItemStackDisplayName", true, String.class, MappedClasses.ItemStack);
      this.c4507 = this.getMappingMethod("getIdFromItem", true, Integer.TYPE, MappedClasses.Item);
      this.c2932 = this.getMappingMethod("getItemById", true, MappedClasses.Item, Integer.TYPE);
      if (ForgeVersion.minorVersion() == 13) {
         this.c4603 = this.getMappingMethodNoRemap("getIconString", true, String.class);
      } else {
         this.c8242 = this.getMappingMethod("getByNameOrId", true, MappedClasses.Item, String.class);
      }

      if (ForgeVersion.minorVersion() >= 23) {
         this.c44 = this.getMappingField("REGISTRY", true, MappedClasses.RegistryNamespaced);
      } else {
         this.c44 = this.getMappingField("itemRegistry", true, MappedClasses.RegistryNamespaced);
      }

   }

   public Object c5068(String var1) {
      return this.c8242.invoke(null, var1);
   }

   public String c4297(Object var1, Object var2) {
      return this.c4560.invoke(var1, var2).toString();
   }

   public String c68(Object var1) {
      return this.c4603.invoke(var1).toString();
   }

   public String c7849(Object var1, Object var2) {
      return this.c3261.invoke(var1, var2).toString();
   }

   public int c4023(Object var1) {
      return this.c4507.c2555(null, var1);
   }

   public Object c8737(int var1) {
      return this.c2932.invoke(null, var1);
   }

   public Object c6031() {
      return this.c44.getObject(null);
   }

   // $FF: synthetic method
   public static Object c6228(MItem var0, String var1) {
      return var0.c5068(var1);
   }

   // $FF: synthetic method
   public static int c8085(MItem var0, Object var1) {
      return var0.c4023(var1);
   }

   // $FF: synthetic method
   public static Object c1412(MItem var0, int var1) {
      return var0.c8737(var1);
   }

   // $FF: synthetic method
   public static String c2191(MItem var0, Object var1) {
      return var0.c68(var1);
   }

   // $FF: synthetic method
   public static String c1921(MItem var0, Object var1, Object var2) {
      return var0.c4297(var1, var2);
   }

   // $FF: synthetic method
   public static String c2215(MItem var0, Object var1, Object var2) {
      return var0.c7849(var1, var2);
   }

   // $FF: synthetic method
   public static Object c4215(MItem var0) {
      return var0.c6031();
   }
}
