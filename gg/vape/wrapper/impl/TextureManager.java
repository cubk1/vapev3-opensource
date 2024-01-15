package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MTextureManager;
import gg.vape.wrapper.Wrapper;

public class TextureManager extends Wrapper {
   public TextureManager(Object var1) {
      super(var1);
   }

   public TextureObject c6024(ResourceLocation var1) {
      return new TextureObject(MTextureManager.c2214(vape.getMappings().textureManager, this.obj, var1.getObject()));
   }
}
