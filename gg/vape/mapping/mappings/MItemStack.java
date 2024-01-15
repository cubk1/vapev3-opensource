package gg.vape.mapping.mappings;

import com.google.common.collect.Multimap;
import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MItemStack extends Mapping {
   public final MappingField c5340;
   public final MappingMethod getItem;
   public final MappingMethod c5391;
   public final MappingMethod c121;
   public final MappingMethod c4804;
   public final MappingMethod c5507;
   public final MappingMethod c3699;
   public final MappingMethod c1451;
   public final MappingMethod c5122;

   public MItemStack() {
      super("net/minecraft/item/ItemStack");
      this.c5340 = this.getMappingFieldNoRemap("stackSize", true, Integer.TYPE);
      this.getItem = this.getMappingMethodNoRemap("getItem", true, MappedClasses.Item);
      this.c5391 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.Item);
      this.c121 = this.getMappingMethodNoRemap("getUnlocalizedName", true, String.class);
      this.c4804 = this.getMappingMethodNoRemap("getDisplayName", true, String.class);
      this.c5507 = this.getMappingMethodNoRemap("getItemDamage", true, Integer.TYPE);
      this.c3699 = this.getMappingMethodNoRemap("getEnchantmentTagList", true, MappedClasses.NBTTagList);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c5122 = this.getMappingMethodNoRemap("func_150997_a", false, Float.TYPE, MappedClasses.IBlockState);
         this.c1451 = this.getMappingMethodNoRemap("getAttributeModifiers", true, Multimap.class, MappedClasses.EntityEquipmentSlot);
      } else {
         this.c5122 = this.getMappingMethodNoRemap("func_150997_a", false, Float.TYPE, MappedClasses.Block);
         this.c1451 = this.getMappingMethodNoRemap("getAttributeModifiers", true, Multimap.class);
      }

   }

   public int c7740(Object var1) {
      return this.c5340.getInt(var1);
   }

   public Object getItem(Object var1) {
      return this.getItem.invoke(var1);
   }

   public Object c5327(Object var1) {
      return this.c5391.c4955(var1);
   }

   public String c4474(Object var1) {
      return this.c121.invoke(var1).toString();
   }

   public String c3369(Object var1) {
      return (String)this.c4804.invoke(var1);
   }

   public int c2521(Object var1) {
      return this.c5507.c2555(var1);
   }

   public Object c6946(Object var1) {
      return this.c3699.invoke(var1);
   }

   public Multimap c549(Object var1) {
      return (Multimap)this.c1451.invoke(var1);
   }

   public Multimap c3285(Object var1, Object var2) {
      return (Multimap)this.c1451.invoke(var1, var2);
   }

   public float c675(Object var1, Object var2) {
      return this.c5122.c3639(var1, var2);
   }

   // $FF: synthetic method
   public static String c6020(MItemStack var0, Object var1) {
      return var0.c3369(var1);
   }

   // $FF: synthetic method
   public static int c7893(MItemStack var0, Object var1) {
      return var0.c2521(var1);
   }

   // $FF: synthetic method
   public static Object c8454(MItemStack var0, Object var1) {
      return var0.c6946(var1);
   }

   // $FF: synthetic method
   public static Multimap c7763(MItemStack var0, Object var1, Object var2) {
      return var0.c3285(var1, var2);
   }

   // $FF: synthetic method
   public static Multimap c6113(MItemStack var0, Object var1) {
      return var0.c549(var1);
   }

   // $FF: synthetic method
   public static float c6753(MItemStack var0, Object var1, Object var2) {
      return var0.c675(var1, var2);
   }
}
