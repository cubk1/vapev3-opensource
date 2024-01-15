package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.Entity;
import gg.vape.wrapper.impl.RenderLivingBase;
import gg.vape.wrapper.impl.RenderLivingEvent;

import java.util.Iterator;

public class EventPreRenderLiving extends EventRenderPlayer {
   public final RenderLivingEvent c3696;

   public EventPreRenderLiving(RenderLivingEvent var1) {
      super(var1);
      this.c3696 = var1;
   }

   public RenderLivingBase c8005() {
      return this.c3696.c1668();
   }

   public Entity c6138() {
      return this.c3696.c4157();
   }

   public double c6847() {
      return this.c3696.c7584();
   }

   public double c6093() {
      return this.c3696.c63();
   }

   public double c8401() {
      return this.c3696.c8246();
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().getMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         var2.onPreRenderLiving(this);
      }

      return this.c5586();
   }
}
