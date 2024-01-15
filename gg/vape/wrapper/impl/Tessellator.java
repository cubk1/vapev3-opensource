package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MTessellator;
import gg.vape.wrapper.Wrapper;

public class Tessellator extends Wrapper {
   public Tessellator(Object var1) {
      super(var1);
   }

   public static Tessellator getInstance() {
      return new Tessellator(MTessellator.c1005(vape.getMappings().tessellator));
   }

   public WorldRenderer getWorldRenderer() {
      return new WorldRenderer(MTessellator.c7502(vape.getMappings().tessellator, this.obj));
   }

   public void draw() {
      MTessellator.draw(vape.getMappings().tessellator, this.obj);
   }

   public void c7235() {
      MTessellator.c7145(vape.getMappings().tessellator, this.obj);
   }

   public void c1716(double var1, double var3, double var5) {
      MTessellator.c6941(vape.getMappings().tessellator, this.obj, var1, var3, var5);
   }

   public void c33(int var1) {
      MTessellator.c1889(vape.getMappings().tessellator, this.obj, var1);
   }

   public void c7967(double var1, double var3, double var5, double var7, double var9) {
      MTessellator.c3716(vape.getMappings().tessellator, this.obj, var1, var3, var5, var7, var9);
   }
}
