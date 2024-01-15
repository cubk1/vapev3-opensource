package gg.vape.mapping.mappings;

import gg.vape.asm.helper.DescUtils;
import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MPotion extends Mapping {
   public MappingField c6223;
   public MappingField c3471;
   public MappingField c2329;
   public final MappingField c6162;
   public MappingField c8715;
   public MappingField c2109;
   public MappingField c8653;
   public MappingField c2934;
   public MappingField c397;
   public final MappingMethod c3486;
   public MappingMethod c6211;
   public MappingMethod c359;

   public MPotion() {
      super(MappedClasses.Potion);
      this.c3486 = this.getMappingMethodNoRemap("removeAttributesModifiersFromEntity", true, Void.TYPE, MappedClasses.EntityLivingBase, MappedClasses.AbstractAttributeMap, Integer.TYPE);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c397 = this.getMappingField("REGISTRY", true, MappedClasses.RegistryNamespaced);
         this.c6211 = this.getMappingMethod("getPotionById", true, MappedClasses.Potion, Integer.TYPE);
         this.c359 = this.getMappingMethod("getIdFromPotion", true, Integer.TYPE, MappedClasses.Potion);
      } else {
         this.c6223 = this.getMappingField("moveSpeed", true, MappedClasses.Potion);
         this.c8653 = this.getMappingField("blindness", true, MappedClasses.Potion);
         this.c3471 = this.getMappingField("moveSlowdown", true, MappedClasses.Potion);
         this.c2109 = this.getMappingField("jump", true, MappedClasses.Potion);
         this.c8715 = this.getMappingField("heal", true, MappedClasses.Potion);
         this.c2329 = this.getMappingField("potionTypes", true, DescUtils.getArrayType(MappedClasses.Potion));
         this.c2934 = this.getMappingFieldNoRemap("id", true, Integer.TYPE);
      }

      this.c6162 = this.getMappingFieldNoRemap("isBadEffect", true, Boolean.TYPE);
   }

   public Object c6031() {
      return this.c6223.getObject(null);
   }

   public Object c7468() {
      return this.c3471.getObject(null);
   }

   public void c1597(Object var1, Object var2, Object var3, int var4) {
      this.c3486.c2642(var1, var2, var3, var4);
   }

   public Object[] c2177() {
      return this.c2329.getObjectArray(null);
   }

   public boolean c4246(Object var1) {
      return this.c6162.getBoolean(var1);
   }

   public Object c8509() {
      return this.c8715.getObject(null);
   }

   public Object c8641() {
      return this.c2109.getObject(null);
   }

   public Object c6111() {
      return this.c8653.getObject(null);
   }

   public int c4023(Object var1) {
      return this.c2934.getInt(var1);
   }

   public Object c8737(int var1) {
      return this.c6211.invoke(null, var1);
   }

   public Object c3417() {
      return this.c397.getObject(null);
   }

   public int c6882(Object var1) {
      return this.c359.c2555(null, var1);
   }

   // $FF: synthetic method
   public static Object c1953(MPotion var0, int var1) {
      return var0.c8737(var1);
   }

   // $FF: synthetic method
   public static Object c814(MPotion var0) {
      return var0.c6031();
   }

   // $FF: synthetic method
   public static Object c4151(MPotion var0) {
      return var0.c7468();
   }

   // $FF: synthetic method
   public static Object c4840(MPotion var0) {
      return var0.c8509();
   }

   // $FF: synthetic method
   public static Object c1939(MPotion var0) {
      return var0.c8641();
   }

   // $FF: synthetic method
   public static Object c1260(MPotion var0) {
      return var0.c6111();
   }

   // $FF: synthetic method
   public static Object c759(MPotion var0) {
      return var0.c3417();
   }

   // $FF: synthetic method
   public static Object[] c3483(MPotion var0) {
      return var0.c2177();
   }

   // $FF: synthetic method
   public static boolean c88(MPotion var0, Object var1) {
      return var0.c4246(var1);
   }

   // $FF: synthetic method
   public static int c4330(MPotion var0, Object var1) {
      return var0.c6882(var1);
   }

   // $FF: synthetic method
   public static int c8957(MPotion var0, Object var1) {
      return var0.c4023(var1);
   }

   // $FF: synthetic method
   public static void c4318(MPotion var0, Object var1, Object var2, Object var3, int var4) {
      var0.c1597(var1, var2, var3, var4);
   }
}
