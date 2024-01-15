package gg.vape.module.blatant.speed;

import gg.vape.event.impl.EventMove;
import gg.vape.module.Mod;
import gg.vape.module.SubModule;
import gg.vape.module.blatant.Speed;
import gg.vape.wrapper.impl.*;

import java.util.List;

public class BhopSpeed extends SubModule {
   public final Speed speed = (Speed)this.getParent();

   public BhopSpeed(Mod speed, String name) {
      super(speed, name);
   }

   public void onMove(EventMove event) {
      if (event.isPre()) {
         EntityPlayerSP player = Minecraft.thePlayer();
         if (!player.isInWater()) {
            if (player.moveForward() == 0.0F && player.moveStrafe() == 0.0F) {
               this.speed.strafeSpeed = this.speed.defaultSpeed();
            }

            if (this.speed.step == 1 && player.isCollidedVertically() && (player.moveForward() != 0.0F || player.moveStrafe() != 0.0F)) {
               this.speed.strafeSpeed = 0.25 + this.speed.defaultSpeed() - 0.01;
            }

            double posY;
            if (this.speed.step == 2 && (player.moveForward() != 0.0F || player.moveStrafe() != 0.0F) && player.onGround()) {
               posY = 0.41999998688697815;
               if (player.isPotionActive(Potion.jump())) {
                  posY += (float)(player.getActivePotionEffect(Potion.jump()).getAmplifier() + 1) * 0.1F;
               }

               event.setY(posY);
               player.motionY(posY);
               this.speed.strafeSpeed *= 2.149;
            } else if (this.speed.step == 3) {
               posY = 0.66 * (this.speed.sqrt - this.speed.defaultSpeed());
               this.speed.strafeSpeed = this.speed.sqrt - posY;
            } else {
               AxisAlignedBB hitbox;
               if (ForgeVersion.minorVersion() == 13) {
                  hitbox = player.boundingBox().copy().offset(0.0, player.motionY(), 0.0);
               } else {
                  hitbox = player.boundingBox().offset(0.0, player.motionY(), 0.0);
               }

               List<AxisAlignedBB> collisionBoxes = Minecraft.theWorld().getCollisionBoxes(player, hitbox);
               if ((collisionBoxes.size() > 0 || player.isCollidedVertically()) && this.speed.step > 0) {
                  if (1.35 * this.speed.defaultSpeed() - 0.01 > this.speed.strafeSpeed) {
                     this.speed.step = 0;
                  } else {
                     this.speed.step = player.moveForward() == 0.0F && player.moveStrafe() == 0.0F ? 0 : 1;
                  }
               }

               this.speed.strafeSpeed = this.speed.sqrt - this.speed.sqrt / 159.0;
            }

            if (this.speed.step > 0) {
               this.speed.strafeSpeed = Math.max(this.speed.strafeSpeed, this.speed.defaultSpeed());
               this.speed.strafe(event, this.speed.strafeSpeed, player);
            }

            if (player.moveForward() != 0.0F || player.moveStrafe() != 0.0F) {
               ++this.speed.step;
            }

         }
      }
   }
}
