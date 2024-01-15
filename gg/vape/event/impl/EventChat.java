package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.event.Event;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.ITextComponent;

import java.util.Iterator;

public class EventChat extends Event {
   public ITextComponent c276;

   public EventChat(ITextComponent var1) {
      this.c276 = var1;
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         if (var2.getState()) {
            var2.onChat(this);
         }
      }

      return this.c5586();
   }

   public void c4469(ITextComponent var1) {
      this.c276 = var1;
   }

   public ITextComponent c8633() {
      return this.c276;
   }
}
