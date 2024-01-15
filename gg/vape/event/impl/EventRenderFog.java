package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.Block;
import gg.vape.wrapper.impl.Entity;
import gg.vape.wrapper.impl.EntityRenderer;
import gg.vape.wrapper.impl.ForgeEvent;

import java.util.Iterator;

public class EventRenderFog extends EventRenderPlayer {
   public final EntityRenderer c3867;
   public final Entity c1151;
   public final Block c2866;
   public final double c5863;
   public final int c5709;
   public final float c6647;

   public EventRenderFog(ForgeEvent var1, EntityRenderer var2, Entity var3, Block var4, double var5, int var7, float var8) {
      super(var1);
      this.c3867 = var2;
      this.c1151 = var3;
      this.c2866 = var4;
      this.c5863 = var5;
      this.c5709 = var7;
      this.c6647 = var8;
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         if (var2.getState()) {
            var2.onRenderFog(this);
         }
      }

      return this.c5586();
   }

   public EntityRenderer c7078() {
      return this.c3867;
   }

   public Entity c6138() {
      return this.c1151;
   }

   public Block c7844() {
      return this.c2866;
   }

   public double c6093() {
      return this.c5863;
   }

   public int c4990() {
      return this.c5709;
   }

   public float c8948() {
      return this.c6647;
   }
}
