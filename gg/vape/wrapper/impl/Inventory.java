package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MIInventory;
import gg.vape.wrapper.Wrapper;

public class Inventory extends Wrapper {
   public Inventory(Object var1) {
      super(var1);
   }

   public String c6376() {
      return ForgeVersion.minorVersion() > 13 ? (new WorldNameable(this.obj)).c7508().c376() : MIInventory.c330(vape.getMappings().inventory, this.obj);
   }

   public int c3715() {
      return MIInventory.c2894(vape.getMappings().inventory, this.obj);
   }

   public ItemStack c4875(int var1) {
      return new ItemStack(MIInventory.c196(vape.getMappings().inventory, this.obj, var1));
   }

   public boolean c5354() {
      return ForgeVersion.minorVersion() > 13 ? (new WorldNameable(this.obj)).c6738() : MIInventory.c4909(vape.getMappings().inventory, this.obj);
   }
}
