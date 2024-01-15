package gg.vape.module.utility.invcleaner;

import gg.vape.Vape;
import gg.vape.event.impl.EventRenderPlayer;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.RenderPlayer;
import gg.vape.wrapper.impl.EntityPlayer;
import gg.vape.wrapper.impl.RenderPlayerEvent;

import java.util.Iterator;

public class EventPreRenderPlayer extends EventRenderPlayer {
   public final RenderPlayerEvent c3820;

   public EventPreRenderPlayer(RenderPlayerEvent var1) {
      super(var1);
      this.c3820 = var1;
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().getMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         var2.onPreRenderPlayer(this);
      }

      return this.c5586();
   }

   public EntityPlayer c4894() {
      return this.c3820.c8294();
   }

   public RenderPlayer c7576() {
      return this.c3820.c7609();
   }

   public float c2202() {
      return this.c3820.c6767();
   }
}
