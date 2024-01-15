package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MEntityPlayer extends Mapping {
   public final MappingField c1886;
   public final MappingField c3634;
   public final MappingField capabilities;
   public final MappingField c4186;
   public final MappingField c4604;
   public final MappingField c623;
   public final MappingField c7502;
   public final MappingField c2995;
   public final MappingField c8664;
   public final MappingField c8428;
   public final MappingField c8040;
   public final MappingMethod c7918;
   public final MappingMethod jump;
   public final MappingMethod c4577;
   public final MappingMethod c6621;
   public final MappingMethod getHeldItemMainhand;
   public final MappingMethod c4927;
   public final MappingMethod c6256;
   public final MappingMethod isBlocking;
   public final MappingMethod c7640;
   public final MappingMethod c2943;
   public final MappingMethod isUsingItem;
   public MappingMethod setItemInUse;
   public MappingMethod c1204;
   public final MappingMethod getItemInUseMaxCount;
   public MappingMethod getCooledAttackStrength;
   public MappingMethod resetCooldown;

   public MEntityPlayer() {
      super(MappedClasses.EntityPlayer);
      this.c1886 = this.getMappingFieldNoRemap("inventory", true, MappedClasses.InventoryPlayer);
      this.c3634 = this.getMappingFieldNoRemap("inventoryContainer", true, MappedClasses.Container);
      this.capabilities = this.getMappingFieldNoRemap("capabilities", true, MappedClasses.PlayerCapabilities);
      this.c4186 = this.getMappingFieldNoRemap("openContainer", true, MappedClasses.Container);
      this.c4604 = this.getMappingFieldNoRemap("fishEntity", true, MappedClasses.EntityFishHook);
      this.c623 = this.getMappingFieldNoRemap("field_71094_bP", true, Double.TYPE);
      this.c7502 = this.getMappingFieldNoRemap("field_71095_bQ", true, Double.TYPE);
      this.c2995 = this.getMappingFieldNoRemap("field_71085_bR", true, Double.TYPE);
      this.c8664 = this.getMappingFieldNoRemap("field_71091_bM", true, Double.TYPE);
      this.c8428 = this.getMappingFieldNoRemap("field_71096_bN", true, Double.TYPE);
      this.c8040 = this.getMappingFieldNoRemap("field_71097_bO", true, Double.TYPE);
      if (ForgeVersion.minorVersion() >= 23) {
         this.resetCooldown = this.getMappingMethodNoRemap("resetCooldown", true, Void.TYPE);
         this.getCooledAttackStrength = this.getMappingMethodNoRemap("getCooledAttackStrength", true, Float.TYPE, Float.TYPE);
         this.getHeldItemMainhand = this.getMappingMethodNoRemap(MappedClasses.EntityLivingBase, "getHeldItemMainhand", true, MappedClasses.ItemStack);
         this.isBlocking = this.getMappingMethodNoRemap(MappedClasses.EntityLivingBase, "isActiveItemStackBlocking", true, Boolean.TYPE);
         this.c2943 = this.getMappingMethodNoRemap(MappedClasses.EntityLivingBase, "getItemInUseCount", true, Integer.TYPE);
         this.isUsingItem = this.getMappingMethodNoRemap(MappedClasses.EntityPlayerSP, "isHandActive", true, Boolean.TYPE);
         this.getItemInUseMaxCount = this.getMappingMethodNoRemap(MappedClasses.EntityLivingBase, "getItemInUseMaxCount", true, Integer.TYPE);
      } else {
         this.getHeldItemMainhand = this.getMappingMethodNoRemap("getCurrentEquippedItem", true, MappedClasses.ItemStack);
         this.isBlocking = this.getMappingMethodNoRemap("isBlocking", true, Boolean.TYPE);
         this.c2943 = this.getMappingMethodNoRemap("getItemInUseCount", true, Integer.TYPE);
         this.isUsingItem = this.getMappingMethodNoRemap("isUsingItem", true, Boolean.TYPE);
         this.setItemInUse = this.getMappingMethodNoRemap("setItemInUse", true, Void.TYPE, MappedClasses.ItemStack, Integer.TYPE);
         this.getItemInUseMaxCount = this.getMappingMethodNoRemap("getItemInUseDuration", true, Integer.TYPE);
      }

      this.c7918 = this.getMappingMethodNoRemap("closeScreen", true, Void.TYPE);
      this.jump = this.getMappingMethodNoRemap("jump", true, Void.TYPE);
      this.c4577 = this.getMappingMethodNoRemap("attackTargetEntityWithCurrentItem", true, Void.TYPE, MappedClasses.Entity);
      this.c6621 = this.getMappingMethodNoRemap("getFoodStats", true, MappedClasses.FoodStats);
      this.c4927 = this.getMappingMethodNoRemap("getTeam", true, MappedClasses.Team);
      this.c6256 = this.getMappingMethodNoRemap("getGameProfile", true, MappedClasses.GameProfile);
      this.c7640 = this.getMappingMethodNoRemap("refreshDisplayName", false, Void.TYPE);
   }

   public void c6265(Object var1) {
      this.c7918.c2642(var1);
   }

   public void c7249(Object var1, Object var2, int var3) {
      this.setItemInUse.c2642(var1, var2, var3);
   }

   public void c7511(Object var1) {
   }
   public void jump(Object var1) {
      this.jump.c2642(var1);
   }

   public Object c6780(Object var1) {
      return this.c1886.getObject(var1);
   }

   public Object c5143(Object var1) {
      return this.c3634.getObject(var1);
   }

   public void c6771(Object var1, Object var2) {
      this.c4577.c2642(var1, var2);
   }

   public Object c5156(Object var1) {
      return this.c4604.getObject(var1);
   }

   public int getItemInUseMaxCount(Object var1) {
      return this.getItemInUseMaxCount.c2555(var1);
   }

   public Object c6946(Object var1) {
      return this.c6621.invoke(var1);
   }

   public Object getHeldItemMainhand(Object var1) {
      return this.getHeldItemMainhand.invoke(var1);
   }

   public float c2842(Object var1, float var2) {
      return this.getCooledAttackStrength.c3639(var1, var2);
   }

   public void c5770(Object var1) {
      this.resetCooldown.c2642(var1);
   }

   public Object c2141(Object var1) {
      return this.c4927.invoke(var1);
   }

   public Object c593(Object var1) {
      return this.c6256.invoke(var1);
   }

   public Object c2100(Object var1) {
      return this.capabilities.getObject(var1);
   }

   public Object c648(Object var1) {
      return this.c4186.getObject(var1);
   }

   public boolean isBlocking(Object var1) {
      return this.isBlocking.c5509(var1);
   }

   public void c2694(Object var1) {
      this.c7640.c2642(var1);
   }

   public int c3820(Object var1) {
      return this.c2943.c2555(var1);
   }

   public boolean isUsingItem(Object var1) {
      return this.isUsingItem.c5509(var1);
   }

   public double c8309(Object var1) {
      return this.c623.getDouble(var1);
   }

   public double c7647(Object var1) {
      return this.c7502.getDouble(var1);
   }

   public double c2113(Object var1) {
      return this.c2995.getDouble(var1);
   }

   public double c6624(Object var1) {
      return this.c8664.getDouble(var1);
   }

   public double c973(Object var1) {
      return this.c8428.getDouble(var1);
   }

   public double c8365(Object var1) {
      return this.c8040.getDouble(var1);
   }

   public void c2636(Object var1, double var2) {
      this.c623.setDouble(var1, var2);
   }

   public void c1122(Object var1, double var2) {
      this.c7502.setDouble(var1, var2);
   }

   public void c4458(Object var1, double var2) {
      this.c2995.setDouble(var1, var2);
   }

   public void c7773(Object var1, double var2) {
      this.c8664.setDouble(var1, var2);
   }

   public void c765(Object var1, double var2) {
      this.c8428.setDouble(var1, var2);
   }

   public void c5802(Object var1, double var2) {
      this.c8040.setDouble(var1, var2);
   }

}
