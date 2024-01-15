package gg.vape.mapping.mappings;

import gg.vape.asm.helper.DescUtils;
import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

import java.util.AbstractList;

public class MInventoryPlayer extends Mapping {
   public final MappingField c3569;
   public final MappingField c8579;
   public final MappingField c6421;
   public final MappingMethod c8921;
   public final MappingMethod c3467;

   public MInventoryPlayer() {
      super("net/minecraft/entity/player/InventoryPlayer");
      this.c3569 = this.getMappingFieldNoRemap("currentItem", true, Integer.TYPE);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c8579 = this.getMappingFieldNoRemap("field_70462_a", true, MappedClasses.NonNullList);
         this.c6421 = this.getMappingFieldNoRemap("armorInventory", true, MappedClasses.NonNullList);
      } else {
         this.c8579 = this.getMappingFieldNoRemap("mainInventory", true, DescUtils.getArrayType(MappedClasses.ItemStack));
         this.c6421 = this.getMappingFieldNoRemap("armorInventory", true, DescUtils.getArrayType(MappedClasses.ItemStack));
      }

      this.c8921 = this.getMappingMethodNoRemap("getStackInSlot", true, MappedClasses.ItemStack, Integer.TYPE);
      this.c3467 = this.getMappingMethodNoRemap("getItemStack", true, MappedClasses.ItemStack);
   }

   public int c7740(Object var1) {
      return this.c3569.getInt(var1);
   }

   public void c7403(Object var1, int var2) {
      this.c3569.setInt(var1, var2);
   }

   public Object[] c772(Object var1) {
      return this.c8579.getObjectArray(var1);
   }

   public Object[] c1641(Object var1) {
      return this.c6421.getObjectArray(var1);
   }

   public AbstractList c2210(Object var1) {
      return (AbstractList)this.c8579.getObject(var1);
   }

   public AbstractList c5560(Object var1) {
      return (AbstractList)this.c6421.getObject(var1);
   }

   public Object c3308(Object var1, int var2) {
      return this.c8921.invoke(var1, var2);
   }

   public Object c6347(Object var1) {
      return this.c3467.invoke(var1);
   }

   // $FF: synthetic method
   public static AbstractList c869(MInventoryPlayer var0, Object var1) {
      return var0.c5560(var1);
   }

   // $FF: synthetic method
   public static Object[] c2216(MInventoryPlayer var0, Object var1) {
      return var0.c1641(var1);
   }

   // $FF: synthetic method
   public static Object c4164(MInventoryPlayer var0, Object var1) {
      return var0.c6347(var1);
   }
}
