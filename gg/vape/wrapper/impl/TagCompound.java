package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MNBTTagCompound;
import gg.vape.wrapper.Wrapper;

public class TagCompound extends Wrapper {
   public TagCompound(Object var1) {
      super(var1);
   }

   public short c3599(String var1) {
      return MNBTTagCompound.c7567(vape.getMappings().tagCompound, this.obj, var1);
   }
}
