package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.Entity;
import gg.vape.wrapper.impl.RenderLivingEvent;

import java.util.Iterator;

public class EventPostRenderLiving extends EventRenderPlayer {
   public final RenderLivingEvent c2783;

   public EventPostRenderLiving(RenderLivingEvent var1) {
      super(var1);
      this.c2783 = var1;
   }

   public Entity c4766() {
      return this.c2783.c4157();
   }

   public double c8077() {
      return this.c2783.c7584();
   }

   public double c6847() {
      return this.c2783.c63();
   }

   public double c6093() {
      return this.c2783.c8246();
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().getMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         var2.onPostRenderLiving(this);
      }

      return this.c5586();
   }
}
