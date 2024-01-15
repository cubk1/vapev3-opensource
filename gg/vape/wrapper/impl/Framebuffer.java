package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MFramebuffer;
import gg.vape.wrapper.Wrapper;

public class Framebuffer extends Wrapper {
   public Framebuffer(Object var1) {
      super(var1);
   }

   public static Framebuffer c1231(int var0, int var1, boolean var2) {
      return new Framebuffer(MFramebuffer.create(vape.getMappings().framebuffer, var0, var1, var2));
   }

   public void createBindFramebuffer(int var1, int var2) {
      MFramebuffer.createBindFramebuffer(vape.getMappings().framebuffer, this.obj, var1, var2);
   }

   public void createFramebuffer(int var1, int var2) {
      MFramebuffer.createFramebuffer(vape.getMappings().framebuffer, this.obj, var1, var2);
   }

   public void bindFramebuffer(boolean var1) {
      MFramebuffer.bindFramebuffer(vape.getMappings().framebuffer, this.obj, var1);
   }

   public void unbindFramebuffer() {
      MFramebuffer.unbindFramebuffer(vape.getMappings().framebuffer, this.obj);
   }

   public void bindFramebufferTexture() {
      MFramebuffer.bindFramebufferTexture(vape.getMappings().framebuffer, this.obj);
   }

   public int framebufferTexture() {
     return MFramebuffer.framebufferTexture(vape.getMappings().framebuffer, this.obj);
   }

   public void unbindFramebufferTexture() {
      MFramebuffer.unbindFramebufferTexture(vape.getMappings().framebuffer, this.obj);
   }

   public int depthBuffer() {
      return MFramebuffer.depthBuffer(vape.getMappings().framebuffer, this.obj);
   }

   public void framebufferClear() {
      MFramebuffer.framebufferClear(vape.getMappings().framebuffer, this.obj);
   }
   public void deleteFramebuffer() {
      MFramebuffer.deleteFramebuffer(vape.getMappings().framebuffer, this.obj);
   }
   public void depthBuffer(int var1) {
      MFramebuffer.depthBuffer(vape.getMappings().framebuffer, this.obj, var1);
   }
}
