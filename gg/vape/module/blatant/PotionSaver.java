package gg.vape.module.blatant;

import gg.vape.event.impl.EventPacketSend;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.unmap.ColorUtil;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.Minecraft;

public class PotionSaver extends Mod {
   public boolean c989;

   public PotionSaver() {
      super("PotionSaver", -256, Category.Blatant, "Saves your potion effect(s) duration when standing still");
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onPacketSend(EventPacketSend event) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      if (var2.isNotNull() && !var2.c808().isEmpty() && !this.c2088(var2) && (var2.onGround() || var2.isCollidedVertically())) {
         if (event.getPacket().isInstance(MappedClasses.CPacketPlayer)) {
            this.c989 = true;
            event.setCancelled(true);
         }
      } else {
         this.c989 = false;
      }

   }

   public boolean c2088(EntityPlayerSP var1) {
      return var1.c6344() != 0.0 || var1.c612() != 0.0;
   }

   public int c5275() {
      return this.c989 ? -256 : ColorUtil.c313(160);
   }
}
