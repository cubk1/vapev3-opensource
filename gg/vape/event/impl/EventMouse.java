package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.config.Profile;
import gg.vape.event.Event;
import gg.vape.module.Macro;
import gg.vape.module.Mod;
import gg.vape.module.none.Macros;
import gg.vape.utils.RotationUtil;
import gg.vape.wrapper.impl.MouseEvent;

import java.util.Iterator;

public class EventMouse extends Event {
   public final Object c894;

   public EventMouse(Object var1) {
      this.c894 = var1;
   }

   public boolean fire() {
      MouseEvent var1 = new MouseEvent(this.c894);
      int var2 = -100 + var1.c3715();
      RotationUtil.c1890();
      if (!var1.c5354()) {
         return this.c5586();
      } else {
         if (Vape.instance.getSettings().mcf.getValue() && var1.c3715() == 2) {
            Vape.instance.getFriendManager().c5011();
         }

         Iterator var3 = Vape.instance.getProfilesManager().c6161().iterator();

         Profile var4;
         do {
            if (!var3.hasNext()) {
               var3 = Vape.instance.getModManager().collectMods().iterator();

               while(var3.hasNext()) {
                  Mod var6 = (Mod)var3.next();
                  if (!var6.c8399().isEmpty()) {
                     var6.c3059(var2);
                  }

                  if (var6.getState()) {
                     var6.onMouse(this);
                  }
               }

               if (var1.c5354()) {
                  Macro var5 = Vape.instance.getMacrosManager().c720(var2);
                  if (var5 == null) {
                     return this.c5586();
                  }

                  Vape.instance.getModManager().getMod(Macros.class).c1396(var5);
               }

               return this.c5586();
            }

            var4 = (Profile)var3.next();
         } while(!var4.c3059(var2));

         return this.c5586();
      }
   }
}
