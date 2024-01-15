package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MWorldRenderer;
import gg.vape.wrapper.Wrapper;

public class WorldRenderer extends Wrapper {
   public WorldRenderer(Object var1) {
      super(var1);
   }

   public WorldRenderer pos(double var1, double var3, double var5) {
      MWorldRenderer.pos(vape.getMappings().worldRenderer, this.obj, var1, var3, var5);
      return this;
   }

   public WorldRenderer color(float var1, float var2, float var3, float var4) {
      MWorldRenderer.color(vape.getMappings().worldRenderer, this.obj, var1, var2, var3, var4);
      return this;
   }

   public void begin(int var2, Object var3) {
      MWorldRenderer.begin(vape.getMappings().worldRenderer, this.obj, var2, var3);
   }

   public void endVertex() {
      MWorldRenderer.c2504(vape.getMappings().worldRenderer, this.obj);
   }
}
