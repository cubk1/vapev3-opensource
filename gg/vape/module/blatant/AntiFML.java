package gg.vape.module.blatant;

import gg.vape.event.impl.EventPacketReceive;
import gg.vape.event.impl.EventPacketSend;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;

public class AntiFML extends Mod {
   public AntiFML() {
      super("Anti-FML", 8919359, Category.Blatant, "Some servers prevent Forge from connecting\nthis will bypass that.\nYou must reconnect to the server inorder for this to work.");
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onPacketReceive(EventPacketReceive event) {
   }

   public void onPacketSend(EventPacketSend event) {
      if (event.getPacket().getObject().getClass().getName().toLowerCase().contains(MappedClasses.jforgePackagePrefix)) {
         event.setCancelled(true);
      }

   }
}
