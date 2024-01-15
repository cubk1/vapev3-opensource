package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MRenderManager;
import gg.vape.wrapper.Wrapper;

public class RenderManager extends Wrapper {
   public RenderManager(Object var1) {
      super(var1);
   }

   public static RenderManager c816() {
      return new RenderManager(MRenderManager.c6913(vape.getMappings().renderManager));
   }

   public double c1779() {
      return MRenderManager.c4698(vape.getMappings().renderManager, this.obj);
   }

   public double c7584() {
      return MRenderManager.c4274(vape.getMappings().renderManager, this.obj);
   }

   public double c63() {
      return MRenderManager.c4871(vape.getMappings().renderManager, this.obj);
   }

   public float c8901() {
      return MRenderManager.c8190(vape.getMappings().renderManager, this.obj);
   }

   public float c4311() {
      return MRenderManager.c7353(vape.getMappings().renderManager, this.obj);
   }

   public double c5286() {
      return MRenderManager.c4034(vape.getMappings().renderManager, this.obj);
   }

   public double c3147() {
      return MRenderManager.c8769(vape.getMappings().renderManager, this.obj);
   }

   public double c2235() {
      return MRenderManager.c863(vape.getMappings().renderManager, this.obj);
   }

   public Render c225(Entity var1) {
      return new Render(MRenderManager.c6307(vape.getMappings().renderManager, this.obj, var1.getObject()));
   }
}
