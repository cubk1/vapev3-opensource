package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

import java.util.Collection;

public class MEntityLivingBase extends Mapping {
   public final MappingMethod getHealth;
   public final MappingMethod c8704;
   public final MappingMethod c3886;
   public final MappingMethod canEntityBeSeen;
   public final MappingMethod c3786;
   public final MappingMethod c1550;
   public final MappingMethod getActivePotionEffect;
   public final MappingMethod c6194;
   public final MappingMethod swingItem;
   public final MappingMethod c3563;
   public final MappingMethod c8611;
   public final MappingMethod c6524;
   public final MappingMethod isOnLadder;
   public final MappingMethod c5204;
   public MappingMethod c7631;
   public final MappingMethod c2646;
   public final MappingMethod c2004;
   public final MappingMethod c8222;
   public final MappingMethod c3670;
   public final MappingField c4135;
   public final MappingField c8755;
   public final MappingField c3623;
   public final MappingField c4565;
   public final MappingField c8187;
   public final MappingField c244;
   public final MappingField c3934;
   public final MappingField c7249;
   public final MappingField c7793;
   public final MappingField c385;
   public final MappingField c2282;
   public final MappingField c4821;
   public final MappingField jumpTicks;

   public MEntityLivingBase() {
      super(MappedClasses.EntityLivingBase);
      this.c385 = this.getMappingFieldNoRemap("prevRenderYawOffset", true, Float.TYPE);
      this.c2282 = this.getMappingFieldNoRemap("prevRotationYawHead", true, Float.TYPE);
      this.c4135 = this.getMappingFieldNoRemap("moveForward", true, Float.TYPE);
      this.c8755 = this.getMappingFieldNoRemap("moveStrafing", true, Float.TYPE);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c3623 = this.getMappingField("SPRINTING_SPEED_BOOST", true, MappedClasses.AttributeModifier);
         this.c6194 = this.getMappingMethodNoRemap("getHeldItemMainhand", true, MappedClasses.ItemStack);
         this.swingItem = this.getMappingMethodNoRemap("swingArm", true, Void.TYPE, MappedClasses.EnumHand);
         this.c6524 = this.getMappingMethodNoRemap("removePotionEffect", true, Void.TYPE, MappedClasses.Potion);
      } else {
         this.c3623 = this.getMappingField("sprintingSpeedBoostModifier", true, MappedClasses.AttributeModifier);
         this.c6194 = this.getMappingMethodNoRemap("getHeldItem", true, MappedClasses.ItemStack);
         this.swingItem = this.getMappingMethodNoRemap("swingItem", true, Void.TYPE);
         this.c6524 = this.getMappingMethodNoRemap("removePotionEffect", true, Void.TYPE, Integer.TYPE);
      }

      this.c4565 = this.getMappingFieldNoRemap("rotationYawHead", true, Float.TYPE);
      this.c8187 = this.getMappingFieldNoRemap("isSwingInProgress", true, Boolean.TYPE);
      this.c4821 = this.getMappingFieldNoRemap("deathTime", true, Integer.TYPE);
      this.getHealth = this.getMappingMethodNoRemap("getHealth", true, Float.TYPE);
      this.c3886 = this.getMappingMethodNoRemap("getLook", true, MappedClasses.Vec3d, Float.TYPE);
      this.canEntityBeSeen = this.getMappingMethodNoRemap("canEntityBeSeen", true, Boolean.TYPE, MappedClasses.Entity);
      this.c1550 = this.getMappingMethodNoRemap("isPotionActive", true, Boolean.TYPE, MappedClasses.Potion);
      this.getActivePotionEffect = this.getMappingMethodNoRemap("getActivePotionEffect", true, MappedClasses.PotionEffect, MappedClasses.Potion);
      this.c2004 = this.getMappingMethodNoRemap("getActivePotionEffects", true, Collection.class);
      this.c3670 = this.getMappingMethodNoRemap("getAttributeMap", true, MappedClasses.AbstractAttributeMap);
      this.c8222 = this.getMappingMethodNoRemap("updatePotionEffects", true, Void.TYPE);
      this.c3563 = this.getMappingMethodNoRemap("getEntityAttribute", true, MappedClasses.IAttributeInstance, MappedClasses.IAttribute);
      this.c8611 = this.getMappingMethodNoRemap("addPotionEffect", true, Void.TYPE, MappedClasses.PotionEffect);
      this.isOnLadder = this.getMappingMethodNoRemap("isOnLadder", true, Boolean.TYPE);
      this.c5204 = this.getMappingMethodNoRemap("getMaxHealth", true, Float.TYPE);
      this.c2646 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.World);
      this.c244 = this.getMappingFieldNoRemap("limbSwing", true, Float.TYPE);
      this.c3934 = this.getMappingFieldNoRemap("limbSwingAmount", true, Float.TYPE);
      this.c7249 = this.getMappingFieldNoRemap("prevLimbSwingAmount", true, Float.TYPE);
      this.c7793 = this.getMappingFieldNoRemap("renderYawOffset", true, Float.TYPE);
      this.jumpTicks = this.getMappingFieldNoRemap("jumpTicks", true, Integer.TYPE);
      if (ForgeVersion.minorVersion() == 13) {
         this.c8704 = this.getMappingMethodNoRemap("getPosition", true, MappedClasses.Vec3d, Float.TYPE);
         this.c3786 = this.getMappingMethodNoRemap("rayTrace", true, MappedClasses.RayTraceResult, Double.TYPE, Float.TYPE);
      } else {
         this.c8704 = new MappingMethod(MappedClasses.Entity, "getPositionEyes", true, false, MappedClasses.Vec3d, Float.TYPE);
         this.c3786 = new MappingMethod(MappedClasses.Entity, "rayTrace", true, false, MappedClasses.RayTraceResult, Double.TYPE, Float.TYPE);
      }

   }

   public float c6244(Object var1) {
      return this.getHealth.c3639(var1);
   }

   public int c2099(Object var1) {
      return this.c4821.getInt(var1);
   }

   public void jumpTicks(Object var1, int var2) {
      this.jumpTicks.setInt(var1, var2);
   }

   public Object c5140(Object var1, float var2) {
      return this.c8704.invoke(var1, var2);
   }

   public Object c7269(Object var1, float var2) {
      return this.c3886.invoke(var1, var2);
   }

   public boolean c948(Object var1, Object var2) {
      return this.canEntityBeSeen.c5509(var1, var2);
   }

   public Object c1014(Object var1, double var2, float var4) {
      return this.c3786.invoke(var1, var2, var4);
   }

   public boolean c7780(Object var1, Object var2) {
      return this.c1550.c5509(var1, var2);
   }

   public Object c1690(Object var1, Object var2) {
      return this.getActivePotionEffect.invoke(var1, var2);
   }

   public Object c5156(Object var1) {
      return this.c2004.invoke(var1);
   }

   public float c437(Object var1) {
      return this.c8755.getFloat(var1);
   }

   public void c3021(Object var1, float var2) {
      this.c8755.setFloat(var1, var2);
   }

   public float c443(Object var1) {
      return this.c4135.getFloat(var1);
   }

   public void c8649(Object var1, float var2) {
      this.c4135.setFloat(var1, var2);
   }

   public Object c3024(Object var1) {
      return this.c6194.invoke(var1);
   }

   public void c5770(Object var1) {
      this.swingItem.c2642(var1);
   }

   public void c4067(Object var1, Object var2) {
      this.swingItem.c2642(var1, var2);
   }

   public Object c2332(Object var1, Object var2) {
      return this.c3563.invoke(var1, var2);
   }

   public Object c2141(Object var1) {
      return this.c3670.invoke(var1);
   }

   public Object c6031() {
      return this.c3623.getObject(null);
   }

   public float c677(Object var1) {
      return this.c4565.getFloat(var1);
   }

   public void c5412(Object var1, float var2) {
      this.c4565.setFloat(var1, var2);
   }

   public float c8820(Object var1) {
      return this.c385.getFloat(var1);
   }

   public float c7751(Object var1) {
      return this.c2282.getFloat(var1);
   }

   public void c1450(Object var1, Object var2) {
      this.c8611.c2642(var1, var2);
   }

   public void c2803(Object var1, int var2) {
      this.c6524.c2642(var1, var2);
   }

   public void c7916(Object var1, Object var2) {
      this.c6524.c2642(var1, var2);
   }

   public void c978(Object var1) {
      this.c8222.c2642(var1);
   }

   public boolean c4402(Object var1) {
      return this.c8187.getBoolean(var1);
   }

   public boolean c7358(Object var1) {
      return this.isOnLadder.c5509(var1);
   }

   public float c5834(Object var1) {
      return this.c5204.c3639(var1);
   }

   public float c2859(Object var1) {
      return this.c244.getFloat(var1);
   }

   public void c1776(Object var1, float var2) {
      this.c244.setFloat(var1, var2);
   }

   public float c6893(Object var1) {
      return this.c3934.getFloat(var1);
   }

   public void c6658(Object var1, float var2) {
      this.c3934.setFloat(var1, var2);
   }

   public float c2612(Object var1) {
      return this.c7249.getFloat(var1);
   }

   public void c766(Object var1, float var2) {
      this.c7249.setFloat(var1, var2);
   }

   public float c2405(Object var1) {
      return this.c7793.getFloat(var1);
   }

   public Object c6519(Object var1) {
      return this.c2646.c4955(var1);
   }

}
