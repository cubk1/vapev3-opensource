package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.RenderPlayer;
import gg.vape.wrapper.impl.EntityPlayer;
import gg.vape.wrapper.impl.RenderPlayerEvent;

import java.util.Iterator;

public class EventPostRenderPlayer extends EventRenderPlayer {
   public final RenderPlayerEvent event;

   public EventPostRenderPlayer(RenderPlayerEvent var1) {
      super(var1);
      this.event = var1;
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().getMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         var2.onPostRenderPlayer(this);
      }

      return this.c5586();
   }

   public EntityPlayer c4894() {
      return this.event.c8294();
   }

   public RenderPlayer c7576() {
      return this.event.c7609();
   }

   public float c2202() {
      return this.event.c6767();
   }
}
