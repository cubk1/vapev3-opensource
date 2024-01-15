package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

import java.nio.ByteBuffer;

public class Mouse extends Wrapper {
   public Mouse() {
      super(null);
   }

   public static ByteBuffer c8307() {
      return vape.getMappings().mouse.c6920(null);
   }
}
