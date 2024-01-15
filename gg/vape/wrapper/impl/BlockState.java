package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class BlockState extends Wrapper {
   public BlockState(Object var1) {
      super(var1);
   }

   public Block c4613() {
      return new Block(vape.getMappings().blockState.c6780(this.obj));
   }
}
