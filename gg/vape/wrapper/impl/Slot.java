package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MSlot;
import gg.vape.wrapper.Wrapper;

public class Slot extends Wrapper {
   public Slot(Object var1) {
      super(var1);
   }

   public ItemStack c4981() {
      return new ItemStack(vape.getMappings().slot.c6780(this.obj));
   }

   public int c3715() {
      return MSlot.c6448(vape.getMappings().slot, this.obj);
   }

   public boolean c5354() {
      return vape.getMappings().slot.c6780(this.obj) != null;
   }
}
