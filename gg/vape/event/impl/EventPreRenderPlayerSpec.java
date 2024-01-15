package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.EntityPlayer;
import gg.vape.wrapper.impl.ForgeEvent;

import java.util.Iterator;

public class EventPreRenderPlayerSpec extends EventRenderPlayer {
   public final EntityPlayer c6209;
   public final float c2608;

   public EventPreRenderPlayerSpec(ForgeEvent var1, EntityPlayer var2, float var3) {
      super(var1);
      this.c6209 = var2;
      this.c2608 = var3;
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         if (var2.getState()) {
            var2.onSpecPreRenderLiving(this);
         }
      }

      return this.c5586();
   }

   public EntityPlayer c4894() {
      return this.c6209;
   }

   public float c2691() {
      return this.c2608;
   }
}
