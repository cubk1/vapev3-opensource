package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MPlayerControllerMP;
import gg.vape.utils.datas.BlockData;
import gg.vape.wrapper.Wrapper;

public class PlayerControllerMP extends Wrapper {
   public PlayerControllerMP(Object var1) {
      super(var1);
   }

   public float c6299() {
      return vape.getMappings().playerControllerMP.c7751(this.obj);
   }

   public boolean c6738() {
      return vape.getMappings().playerControllerMP.c2418(this.obj);
   }

   public ItemStack c7098(int var1, int var2, int var3, int var4, EntityPlayer var5) {
      return ForgeVersion.minorVersion() >= 23 ? new ItemStack(vape.getMappings().playerControllerMP.c3747(this.obj, var1, var2, var3, ClickType.c6267[var4].getObject(), var5.getObject())) : new ItemStack(vape.getMappings().playerControllerMP.c671(this.obj, var1, var2, var3, var4, var5.getObject()));
   }

   public boolean sendUseItem(EntityPlayer var1, World var2, ItemStack var3) {
      if (ForgeVersion.minorVersion() >= 23) {
         EnumActionResult var4 = new EnumActionResult(vape.getMappings().playerControllerMP.c3630(this.obj, var1.getObject(), var2.getObject(), EnumHead.c1307()));
         return var4.equals(EnumActionResult.c363());
      } else {
         return vape.getMappings().playerControllerMP.c2614(this.obj, var1.getObject(), var2.getObject(), var3.getObject());
      }
   }

   public void onStoppedUsingItem(EntityPlayer var1) {
      vape.getMappings().playerControllerMP.onStoppedUsingItem(this.obj, var1.getObject());
   }

   public boolean c1520(EntityPlayerSP var1, WorldClient var2, ItemStack var3, BlockData var4, EnumFacing var5, Vec3 var6) {
      if (ForgeVersion.minorVersion() > 13) {
         if (ForgeVersion.minorVersion() >= 23) {
            Boolean var7 = vape.getMappings().playerControllerMP.c8869(this.obj, var1.getObject(), var2.getObject(), BlockPos.c5782(var4).getObject(), var5.getObject(), var6.getObject(), EnumHead.c1307().getObject());
            EnumActionResult var8 = new EnumActionResult(var7);
            return var8.equals(EnumActionResult.c363());
         } else {
            return vape.getMappings().playerControllerMP.c7906(this.obj, var1.getObject(), var2.getObject(), var3.getObject(), BlockPos.c5782(var4).getObject(), var5.getObject(), var6.getObject());
         }
      } else {
         return vape.getMappings().playerControllerMP.c6306(this.obj, var1.getObject(), var2.getObject(), var3.getObject(), var4.c1368(), var4.c1908(), var4.c4775(), var5.c1744(), var6.getObject());
      }
   }

   public void attackEntity(EntityPlayer var1, Entity var2) {
      MPlayerControllerMP.attackEntity(vape.getMappings().playerControllerMP, this.obj, var1.getObject(), var2.getObject());
   }

   public void c2534() {
      MPlayerControllerMP.c2281(vape.getMappings().playerControllerMP, this.obj);
   }

   public void c7235() {
      vape.getMappings().playerControllerMP.c716(this.obj);
   }

   public NetHandlerPlayClientImpl c4186() {
      return new NetHandlerPlayClientImpl(MPlayerControllerMP.c7914(vape.getMappings().playerControllerMP, this.obj));
   }

   public boolean c7948() {
      return MPlayerControllerMP.c4497(vape.getMappings().playerControllerMP, this.obj);
   }
}
