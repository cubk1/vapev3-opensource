package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.Entity;
import gg.vape.wrapper.impl.ForgeEvent;

import java.util.Iterator;

public class EventSetArmorModel extends EventRenderPlayer {
   public Entity c7471;

   public EventSetArmorModel(ForgeEvent var1, Entity var2) {
      super(var1);
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         if (var2.getState()) {
            var2.onSetArmor(this);
         }
      }

      return this.c5586();
   }

   public Entity c4766() {
      return this.c7471;
   }
}
