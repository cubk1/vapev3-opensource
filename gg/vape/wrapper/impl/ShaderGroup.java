package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class ShaderGroup extends Wrapper {
   public ShaderGroup(Object var1) {
      super(var1);
   }

   public static ShaderGroup c2339(TextureManager var0, sb var1, Framebuffer var2, ResourceLocation var3) {
      return new ShaderGroup(vape.getMappings().shaderGroup.c8549(var0.getObject(), var1.getObject(), var2.getObject(), var3.getObject()));
   }

   public void c6395() {
      vape.getMappings().shaderGroup.c716(this.obj);
   }

   public void c4879(int var1, int var2) {
      vape.getMappings().shaderGroup.c5976(this.obj, var1, var2);
   }
}
