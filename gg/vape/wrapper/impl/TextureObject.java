package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MITextureObject;
import gg.vape.wrapper.Wrapper;

public class TextureObject extends Wrapper {
   public TextureObject(Object var1) {
      super(var1);
   }

   public int c1744() {
      return MITextureObject.c5938(vape.getMappings().textureObject, this.obj);
   }
}
