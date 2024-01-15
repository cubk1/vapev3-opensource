package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

import java.util.List;

public class Chunk extends Wrapper {
   public Chunk(Object var1) {
      super(var1);
   }

   public void c4578(Entity var1, AxisAlignedBB var2, List var3, Object var4) {
      vape.getMappings().chunk.c2280(this.obj, var1.getObject(), var2.getObject(), var3, var4);
   }
}
