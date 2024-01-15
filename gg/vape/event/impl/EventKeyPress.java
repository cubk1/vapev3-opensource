package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.config.Profile;
import gg.vape.event.Event;
import gg.vape.module.Mod;
import gg.vape.utils.RotationUtil;
import gg.vape.wrapper.impl.Minecraft;

import java.util.Iterator;

public class EventKeyPress extends Event {
   public final int c5229;
   public final boolean c7457;

   public EventKeyPress(int var1, boolean var2) {
      this.c5229 = var1;
      this.c7457 = var2;
   }

   public boolean c4942() {
      return this.c7457;
   }

   public int c6502() {
      return this.c5229;
   }

   public boolean fire() {
      RotationUtil.c1890();
      Iterator var1;
      if (this.c5229 > 0 && this.c7457 && Minecraft.currentScreen().getObject() == null) {
         var1 = Vape.instance.getProfilesManager().c6161().iterator();

         while(var1.hasNext()) {
            Profile var2 = (Profile)var1.next();
            if (var2.c3059(this.c5229)) {
               return this.c5586();
            }
         }
      }

      var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         Mod var3 = (Mod)var1.next();
         var3.c6085(this);
      }

      return this.c5586();
   }
}
