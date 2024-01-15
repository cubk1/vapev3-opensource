package gg.vape.module.blatant.speed;

import gg.vape.event.impl.EventMove;
import gg.vape.module.Mod;
import gg.vape.module.SubModule;
import gg.vape.module.blatant.Speed;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.Potion;

public class MineplexSpeed extends SubModule {
   public final Speed speed = (Speed)this.getParent();

   public MineplexSpeed(Mod speed, String name) {
      super(speed, name);
   }

   public void onMove(EventMove event) {
      if (event.isPre()) {
         EntityPlayerSP player = Minecraft.thePlayer();
         if (!player.isInWater()) {
            if ((player.moveForward() != 0.0F || player.moveStrafe() != 0.0F) && player.isCollidedVertically()) {
               double moveOffset = 0.41999998688697815;
               if (player.isPotionActive(Potion.jump())) {
                  moveOffset += (float)(player.getActivePotionEffect(Potion.jump()).getAmplifier() + 1) * 0.1F;
               }

               event.setY(moveOffset);
               player.motionY(moveOffset);
            }

            this.speed.strafe(event, 0.4399999976158142, player);
         }
      }
   }
}
