package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MShaderGroup extends Mapping {
   public final MappingMethod c8529;
   public final MappingMethod c3449;
   public final MappingMethod c701;

   public MShaderGroup() {
      super("net/minecraft/client/shader/ShaderGroup");
      this.c8529 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.TextureManager, MappedClasses.IResourceManager, MappedClasses.Framebuffer, MappedClasses.ResourceLocation);
      this.c3449 = this.getMappingMethodNoRemap("createBindFramebuffers", true, Void.TYPE, Integer.TYPE, Integer.TYPE);
      this.c701 = this.getMappingMethodNoRemap("deleteShaderGroup", true, Void.TYPE);
   }

   public Object c8549(Object var1, Object var2, Object var3, Object var4) {
      return this.c8529.c4955(var1, var2, var3, var4);
   }

   public void c5976(Object var1, int var2, int var3) {
      this.c3449.c2642(var1, var2, var3);
   }

   public void c716(Object var1) {
      this.c701.c2642(var1);
   }
}
