package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.Block;
import gg.vape.wrapper.impl.Entity;
import gg.vape.wrapper.impl.EntityRenderer;
import gg.vape.wrapper.impl.ForgeEvent;

import java.util.Iterator;

public class EventFogColors extends EventRenderPlayer {
   public final EntityRenderer c8785;
   public final Entity c280;
   public final Block c6243;
   public final double c4215;
   public float c8750;
   public float c669;
   public float c7023;

   public EventFogColors(ForgeEvent var1, EntityRenderer var2, Entity var3, Block var4, double var5, float var7, float var8, float var9) {
      super(var1);
      this.c8785 = var2;
      this.c280 = var3;
      this.c6243 = var4;
      this.c4215 = var5;
      this.c8750 = var7;
      this.c669 = var8;
      this.c7023 = var9;
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         if (var2.getState()) {
            var2.onFogColors(this);
         }
      }

      return this.c5586();
   }

   public EntityRenderer c7078() {
      return this.c8785;
   }

   public Entity c6138() {
      return this.c280;
   }

   public Block c7844() {
      return this.c6243;
   }

   public double c6093() {
      return this.c4215;
   }

   public float c1081() {
      return this.c8750;
   }

   public float c8948() {
      return this.c669;
   }

   public float c8599() {
      return this.c7023;
   }

   public void c8552(float var1) {
      this.c8750 = var1;
   }

   public void c217(float var1) {
      this.c669 = var1;
   }

   public void c7901(float var1) {
      this.c7023 = var1;
   }
}
