package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MPlayerControllerMP extends Mapping {
   public final MappingField c2666;
   public final MappingField c8889;
   public final MappingMethod c5237;
   public final MappingMethod c3930;
   public final MappingMethod c3896;
   public final MappingMethod attackEntity;
   public final MappingMethod c6967;
   public final MappingMethod c7842;
   public final MappingMethod sendUseItem;
   public final MappingMethod c1069;
   public final MappingMethod onStoppedUsingItem;

   public MPlayerControllerMP() {
      super("net/minecraft/client/multiplayer/PlayerControllerMP");
      if (ForgeVersion.minorVersion() >= 23) {
         this.c2666 = this.getMappingFieldNoRemap("connection", true, MappedClasses.NetHandlerPlayClient);
         this.c3896 = this.getMappingMethodNoRemap("windowClick", true, MappedClasses.ItemStack, Integer.TYPE, Integer.TYPE, Integer.TYPE, MappedClasses.ClickType, MappedClasses.EntityPlayer);
         this.sendUseItem = this.getMappingMethodNoRemap("processRightClick", true, MappedClasses.EnumActionResult, MappedClasses.EntityPlayer, MappedClasses.World, MappedClasses.EnumHand);
      } else {
         this.c2666 = this.getMappingFieldNoRemap("netClientHandler", true, MappedClasses.NetHandlerPlayClient);
         this.c3896 = this.getMappingMethodNoRemap("windowClick", true, MappedClasses.ItemStack, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, MappedClasses.EntityPlayer);
         this.sendUseItem = this.getMappingMethodNoRemap("sendUseItem", true, Boolean.TYPE, MappedClasses.EntityPlayer, MappedClasses.World, MappedClasses.ItemStack);
      }

      this.c8889 = this.getMappingFieldNoRemap("isHittingBlock", true, Boolean.TYPE);
      this.c5237 = this.getMappingMethodNoRemap("getBlockReachDistance", true, Float.TYPE);
      this.c3930 = this.getMappingMethodNoRemap("extendedReach", true, Boolean.TYPE);
      this.attackEntity = this.getMappingMethodNoRemap("attackEntity", true, Void.TYPE, MappedClasses.EntityPlayer, MappedClasses.Entity);
      this.c6967 = this.getMappingMethodNoRemap("syncCurrentPlayItem", true, Void.TYPE);
      this.c1069 = this.getMappingMethodNoRemap("updateController", true, Void.TYPE);
      this.onStoppedUsingItem = this.getMappingMethodNoRemap("onStoppedUsingItem", true, Void.TYPE, MappedClasses.EntityPlayer);
      if (ForgeVersion.minorVersion() > 13) {
         if (ForgeVersion.minorVersion() >= 23) {
            this.c7842 = this.getMappingMethodNoRemap("processRightClickBlock", true, MappedClasses.EnumActionResult, MappedClasses.EntityPlayerSP, MappedClasses.WorldClient, MappedClasses.BlockPos, MappedClasses.EnumFacing, MappedClasses.Vec3d, MappedClasses.EnumHand);
         } else {
            this.c7842 = this.getMappingMethodNoRemap("onPlayerRightClick", true, Boolean.TYPE, MappedClasses.EntityPlayerSP, MappedClasses.WorldClient, MappedClasses.ItemStack, MappedClasses.BlockPos, MappedClasses.EnumFacing, MappedClasses.Vec3d);
         }
      } else {
         this.c7842 = this.getMappingMethodNoRemap("onPlayerRightClick", true, Boolean.TYPE, MappedClasses.EntityPlayer, MappedClasses.World, MappedClasses.ItemStack, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, MappedClasses.Vec3d);
      }

   }

   public void c716(Object var1) {
      this.c1069.c2642(var1);
   }

   public boolean c2614(Object var1, Object var2, Object var3, Object var4) {
      return this.sendUseItem.c5509(var1, var2, var3, var4);
   }

   public Object c3630(Object var1, Object var2, Object var3, Object var4) {
      return this.sendUseItem.invoke(var1, var2, var3, var4);
   }

   public void onStoppedUsingItem(Object var1, Object var2) {
      this.onStoppedUsingItem.c2642(var1, var2);
   }

   public boolean c7906(Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7) {
      return this.c7842.c5509(var1, var2, var3, var4, var5, var6, var7);
   }

   public boolean c6306(Object var1, Object var2, Object var3, Object var4, int var5, int var6, int var7, int var8, Object var9) {
      return this.c7842.c5509(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public boolean c8869(Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7) {
      return this.c7842.c5509(var1, var2, var3, var4, var5, var6, var7);
   }

   public float c7751(Object var1) {
      return this.c5237.c3639(var1);
   }

   public boolean c2418(Object var1) {
      return this.c3930.c5509(var1);
   }

   public Object c671(Object var1, int var2, int var3, int var4, int var5, Object var6) {
      return this.c3896.invoke(var1, var2, var3, var4, var5, var6);
   }

   public Object c3747(Object var1, int var2, int var3, int var4, Object var5, Object var6) {
      return this.c3896.invoke(var1, var2, var3, var4, var5, var6);
   }

   public void c4839(Object var1, Object var2, Object var3) {
      this.attackEntity.c2642(var1, var2, var3);
   }

   public void c5234(Object var1) {
      this.c6967.c2642(var1);
   }

   public Object c5156(Object var1) {
      return this.c2666.getObject(var1);
   }

   public boolean c2162(Object var1) {
      return this.c8889.getBoolean(var1);
   }

   // $FF: synthetic method
   public static void attackEntity(MPlayerControllerMP var0, Object var1, Object var2, Object var3) {
      var0.c4839(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void c2281(MPlayerControllerMP var0, Object var1) {
      var0.c5234(var1);
   }

   // $FF: synthetic method
   public static Object c7914(MPlayerControllerMP var0, Object var1) {
      return var0.c5156(var1);
   }

   // $FF: synthetic method
   public static boolean c4497(MPlayerControllerMP var0, Object var1) {
      return var0.c2162(var1);
   }
}
