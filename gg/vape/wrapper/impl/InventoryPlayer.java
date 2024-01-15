package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MInventoryPlayer;
import gg.vape.wrapper.Wrapper;

import java.util.AbstractList;

public class InventoryPlayer extends Wrapper {
   public InventoryPlayer(Object var1) {
      super(var1);
   }

   public int c1744() {
      return vape.getMappings().inventoryPlayer.c7740(this.obj);
   }

   public Object[] c596() {
      if (ForgeVersion.minorVersion() >= 23) {
         AbstractList var1 = vape.getMappings().inventoryPlayer.c2210(this.obj);
         return var1.toArray();
      } else {
         return vape.getMappings().inventoryPlayer.c772(this.obj);
      }
   }

   public Object[] c2542() {
      if (ForgeVersion.minorVersion() >= 23) {
         AbstractList var1 = MInventoryPlayer.c869(vape.getMappings().inventoryPlayer, this.obj);
         return var1.toArray();
      } else {
         return MInventoryPlayer.c2216(vape.getMappings().inventoryPlayer, this.obj);
      }
   }

   public void c33(int var1) {
      vape.getMappings().inventoryPlayer.c7403(this.obj, var1);
   }

   public ItemStack c5272(int var1) {
      return new ItemStack(vape.getMappings().inventoryPlayer.c3308(this.obj, var1));
   }

   public ItemStack c7824() {
      return new ItemStack(MInventoryPlayer.c4164(vape.getMappings().inventoryPlayer, this.obj));
   }
}
