package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;

public class MFramebuffer extends Mapping {
   public final MappingMethod createBindFramebuffer;
   public final MappingMethod init;
   public final MappingMethod bindFramebuffer;
   public final MappingMethod unbindFramebuffer;
   public final MappingMethod bindFramebufferTexture;
   public final MappingMethod unbindFramebufferTexture;
   public final MappingMethod createFramebuffer;
   public final MappingField depthBuffer;
   public final MappingMethod framebufferClear;
   public final MappingMethod deleteFramebuffer;
   public final MappingField framebufferTexture;
   public MFramebuffer() {
      super(MappedClasses.Framebuffer);
      this.init = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE);
      this.createBindFramebuffer = this.getMappingMethodNoRemap("createBindFramebuffer", true, Void.TYPE, Integer.TYPE, Integer.TYPE);
      this.bindFramebuffer = this.getMappingMethodNoRemap("bindFramebuffer", true, Void.TYPE, Boolean.TYPE);
      this.unbindFramebuffer = this.getMappingMethodNoRemap("unbindFramebuffer", true, Void.TYPE);
      this.bindFramebufferTexture = this.getMappingMethodNoRemap("bindFramebufferTexture", true, Void.TYPE);
      this.unbindFramebufferTexture = this.getMappingMethodNoRemap("unbindFramebufferTexture", true, Void.TYPE);
      this.createFramebuffer = this.getMappingMethodNoRemap("createFramebuffer", true, Void.TYPE, Integer.TYPE, Integer.TYPE);
      this.depthBuffer = this.getMappingFieldNoRemap("depthBuffer", true, Integer.TYPE);
      this.framebufferClear = this.getMappingMethodNoRemap("framebufferClear", true, Void.TYPE);
      this.deleteFramebuffer = this.getMappingMethodNoRemap("deleteFramebuffer", true, Void.TYPE);
      this.framebufferTexture = this.getMappingFieldNoRemap("framebufferTexture", true, Integer.TYPE);
   }

   public Object create(int var1, int var2, boolean var3) {
      return this.init.c4955(var1, var2, var3);
   }

   public void createBindFramebuffer(Object var1, int var2, int var3) {
      this.createBindFramebuffer.c2642(var1, var2, var3);
   }

   public void createFramebuffer(Object var1, int var2, int var3) {
      this.createFramebuffer.c2642(var1, var2, var3);
   }
   public void deleteFramebuffer(Object var1) {
      this.deleteFramebuffer.c2642(var1);
   }

   public void bindFramebuffer(Object var1, boolean var2) {
      this.bindFramebuffer.c2642(var1, var2);
   }

   public void unbindFramebuffer(Object var1) {
      this.unbindFramebuffer.c2642(var1);
   }

   public void bindFramebufferTexture(Object var1) {
      this.bindFramebufferTexture.c2642(var1);
   }
   public int framebufferTexture(Object var1) {
      return this.framebufferTexture.getInt(var1);
   }

   public void unbindFramebufferTexture(Object var1) {
      this.unbindFramebufferTexture.c2642(var1);
   }

   public int depthBuffer(Object var1) {
      return this.depthBuffer.getInt(var1);
   }
   public void framebufferClear(Object var1) {
      this.framebufferClear.c2642(var1);
   }

   public void depthBuffer(Object var1, int var2) {
      this.depthBuffer.setInt(var1, var2);
   }

   // $FF: synthetic method
   public static Object create(MFramebuffer var0, int var1, int var2, boolean var3) {
      return var0.create(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void createBindFramebuffer(MFramebuffer var0, Object var1, int var2, int var3) {
      var0.createBindFramebuffer(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void createFramebuffer(MFramebuffer var0, Object var1, int var2, int var3) {
      var0.createFramebuffer(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void bindFramebuffer(MFramebuffer var0, Object var1, boolean var2) {
      var0.bindFramebuffer(var1, var2);
   }

   // $FF: synthetic method
   public static void unbindFramebuffer(MFramebuffer var0, Object var1) {
      var0.unbindFramebuffer(var1);
   }

   public static int framebufferTexture(MFramebuffer var0, Object var1) {
      return var0.framebufferTexture(var1);
   }

   // $FF: synthetic method
   public static void bindFramebufferTexture(MFramebuffer var0, Object var1) {
      var0.bindFramebufferTexture(var1);
   }

   // $FF: synthetic method
   public static void unbindFramebufferTexture(MFramebuffer var0, Object var1) {
      var0.unbindFramebufferTexture(var1);
   }

   // $FF: synthetic method
   public static int depthBuffer(MFramebuffer var0, Object var1) {
      return var0.depthBuffer(var1);
   }

   public static void framebufferClear(MFramebuffer var0, Object var1) {
      var0.framebufferClear(var1);
   }

   public static void deleteFramebuffer(MFramebuffer var0, Object var1) {
      var0.deleteFramebuffer(var1);
   }


   // $FF: synthetic method
   public static void depthBuffer(MFramebuffer var0, Object var1, int var2) {
      var0.depthBuffer(var1, var2);
   }
}
