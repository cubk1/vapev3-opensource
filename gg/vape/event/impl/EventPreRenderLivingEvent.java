package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.Entity;
import gg.vape.wrapper.impl.RenderLivingEvent_Specials_Pre;

import java.util.Iterator;

public class EventPreRenderLivingEvent extends EventRenderPlayer {
   public final RenderLivingEvent_Specials_Pre c8583;

   public EventPreRenderLivingEvent(RenderLivingEvent_Specials_Pre var1) {
      super(var1);
      this.c8583 = var1;
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().getMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         var2.onPreRenderLiving(this);
      }

      return this.c5586();
   }

   public Entity c4766() {
      return this.c8583.c4157();
   }

   public double c8077() {
      return this.c8583.c7584();
   }

   public double c6847() {
      return this.c8583.c63();
   }

   public double c6093() {
      return this.c8583.c8246();
   }
}
