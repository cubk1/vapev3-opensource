package gg.vape.module.blatant;

import gg.vape.Vape;
import gg.vape.event.impl.EventStep;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.threads.ResetTimerThread;
import gg.vape.wrapper.impl.C04PacketPlayerPosition;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.Minecraft;

import java.awt.*;

public class Step extends Mod {
   public Step() {
      super("Step", (new Color(42, 175, 224)).getRGB(), Category.Blatant);
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onStep(EventStep event) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      if (event.isPre() && !var2.movementInput().c3624() && var2.isCollidedVertically()) {
         event.c8146(1.0);
      } else if (!event.isPre() && event.c8077() > 0.5 && event.c548() > 0.0 && !var2.movementInput().c3624() && var2.isCollidedVertically()) {
         Vape.instance.getModManager().getMod(Speed.class).setStep(-4);
         if (event.c8077() >= 0.87) {
            double var3 = event.c8077();
            double var5 = var3 * 0.42;
            double var7 = var3 * 0.75;
            var2.sendQueue().addToSendQueue(C04PacketPlayerPosition.newInstance(var2.posX(), var2.posY() + var5, var2.posZ(), var2.onGround()));
            var2.sendQueue().addToSendQueue(C04PacketPlayerPosition.newInstance(var2.posX(), var2.posY() + var7, var2.posZ(), var2.onGround()));
         }

         Minecraft.getTimer().setTimerSpeed(0.45F);
         ResetTimerThread var9 = new ResetTimerThread(this);
         var9.start();
      }

   }
}
