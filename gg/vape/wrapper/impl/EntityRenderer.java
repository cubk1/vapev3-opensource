package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MEntityRenderer;
import gg.vape.wrapper.Wrapper;

public class EntityRenderer extends Wrapper {
   public EntityRenderer(Object var1) {
      super(var1);
   }

   public Entity c4157() {
      return new Entity(MEntityRenderer.c6686(vape.getMappings().entityRenderer, this.obj));
   }

   public void c7364(Entity var1) {
      MEntityRenderer.c553(vape.getMappings().entityRenderer, this.obj, var1.getObject());
   }

   public void c3776(float var1, int var2) {
      MEntityRenderer.c4950(vape.getMappings().entityRenderer, this.obj, var1, var2);
   }

   public void c6766(double var1) {
      MEntityRenderer.c233(vape.getMappings().entityRenderer, this.obj, var1);
   }

   public void c4997(double var1) {
      MEntityRenderer.c5004(vape.getMappings().entityRenderer, this.obj, var1);
   }

   public sb getEntityRenderer() {
      return new sb(MEntityRenderer.c2961(vape.getMappings().entityRenderer, this.obj));
   }

   public static Object[] c2542() {
      return MEntityRenderer.c5608(vape.getMappings().entityRenderer);
   }

   public void c5199(ShaderGroup var1) {
      MEntityRenderer.c7136(vape.getMappings().entityRenderer, this.obj, var1.getObject());
   }

   public void c175(boolean var1) {
      if (ForgeVersion.minorVersion() > 13) {
         MEntityRenderer.c1006(vape.getMappings().entityRenderer, this.obj, var1);
      }

   }

   public boolean c3300() {
      return ForgeVersion.minorVersion() > 13 && MEntityRenderer.c8101(vape.getMappings().entityRenderer, this.obj);
   }

   public void c4879(int var1, int var2) {
      MEntityRenderer.c6695(vape.getMappings().entityRenderer, this.obj, var1, var2);
   }

   public void c1825(float var1, long var2) {
      MEntityRenderer.c3877(vape.getMappings().entityRenderer, this.obj, var1, var2);
   }

   public void c335(boolean var1) {
      MEntityRenderer.c1519(vape.getMappings().entityRenderer, this.obj, var1);
   }
}
