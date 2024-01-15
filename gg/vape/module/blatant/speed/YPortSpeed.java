package gg.vape.module.blatant.speed;

import gg.vape.event.impl.EventMotion;
import gg.vape.event.impl.EventMove;
import gg.vape.module.Mod;
import gg.vape.module.SubModule;
import gg.vape.module.blatant.Speed;
import gg.vape.wrapper.impl.*;

import java.util.List;

public class YPortSpeed extends SubModule {
   public final Speed speed = (Speed)this.getParent();

   public YPortSpeed(Mod speed, String name) {
      super(speed, name);
   }

   public void onMotionUpdate(EventMotion event) {
      if (this.speed.step == 3) {
         EntityPlayerSP player = Minecraft.thePlayer();
         double posY = 0.402312;
         if (player.isPotionActive(Potion.jump())) {
            posY = (float)(player.getActivePotionEffect(Potion.jump()).getAmplifier() + 1) * 0.1F;
         }

         event.setY(event.getY() + posY);
      }

   }

   public void onMove(EventMove event) {
      if (event.isPre()) {
         if (this.speed.step < 1) {
            ++this.speed.step;
            this.speed.sqrt = 0.0;
         }

         EntityPlayerSP player = Minecraft.thePlayer();
         if (!player.isInWater()) {
            if (player.onGround() || player.isCollidedVertically() || this.speed.step == 3) {
               if (!player.isCollidedHorizontally() && player.moveForward() != 0.0F || player.moveStrafe() != 0.0F) {
                  if (this.speed.step == 2) {
                     this.speed.strafeSpeed *= 2.149;
                     this.speed.step = 3;
                  } else if (this.speed.step == 3) {
                     this.speed.step = 2;
                     double strafe = 0.66 * (this.speed.sqrt - this.speed.defaultSpeed());
                     this.speed.strafeSpeed = this.speed.sqrt - strafe;
                  } else {
                     AxisAlignedBB axisAlignedBB;
                     if (ForgeVersion.minorVersion() == 13) {
                        axisAlignedBB = player.boundingBox().copy().offset(0.0, player.motionY(), 0.0);
                     } else {
                        axisAlignedBB = player.boundingBox().offset(0.0, player.motionY(), 0.0);
                     }

                     List<AxisAlignedBB> collisionBoxes = Minecraft.theWorld().getCollisionBoxes(player, axisAlignedBB);
                     if ((collisionBoxes.size() > 0 || player.isCollidedVertically()) && this.speed.step > 0) {
                        this.speed.step = 1;
                     }
                  }
               }

               this.speed.strafeSpeed = Math.max(this.speed.strafeSpeed, this.speed.defaultSpeed());
               this.speed.strafe(event, this.speed.strafeSpeed, player);
            }

         }
      }
   }
}
