package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.Block;
import gg.vape.wrapper.impl.Entity;
import gg.vape.wrapper.impl.EntityRenderer;
import gg.vape.wrapper.impl.ForgeEvent;

import java.util.Iterator;

public class EventFogDensity extends EventRenderPlayer {
   public final EntityRenderer c2554;
   public final Entity c5302;
   public final Block c6247;
   public final double c1364;
   public float c8359;

   public EventFogDensity(ForgeEvent var1, EntityRenderer var2, Entity var3, Block var4, double var5, float var7) {
      super(var1);
      this.c2554 = var2;
      this.c5302 = var3;
      this.c6247 = var4;
      this.c1364 = var5;
      this.c8359 = var7;
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         if (var2.getState()) {
            var2.onFogDensity(this);
         }
      }

      return this.c5586();
   }

   public EntityRenderer c7078() {
      return this.c2554;
   }

   public Entity c6138() {
      return this.c5302;
   }

   public Block c7844() {
      return this.c6247;
   }

   public double c6093() {
      return this.c1364;
   }

   public float c1081() {
      return this.c8359;
   }

   public void c8552(float var1) {
      this.c8359 = var1;
   }
}
