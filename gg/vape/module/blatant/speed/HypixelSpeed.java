package gg.vape.module.blatant.speed;

import gg.vape.event.impl.EventMove;
import gg.vape.module.Mod;
import gg.vape.module.SubModule;
import gg.vape.module.blatant.Speed;
import gg.vape.wrapper.impl.AxisAlignedBB;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.ForgeVersion;
import gg.vape.wrapper.impl.Minecraft;

import java.util.List;

public class HypixelSpeed extends SubModule {
   public final Speed speed = (Speed)this.getParent();
   public final double moveSpeed = this.randomSpeed(1334.0, -1332.0) / 250000.0;

   public HypixelSpeed(Mod speed, String name) {
      super(speed, name);
   }

   public void onMove(EventMove event) {
      if (event.isPre()) {
         EntityPlayerSP player = Minecraft.thePlayer();
         if (!player.isInWater()) {
            double posY;
            if (this.speed.step == 2 && (player.moveForward() != 0.0F || player.moveStrafe() != 0.0F) && player.isCollidedVertically()) {
               posY = 0.405412 + this.moveSpeed;
               event.setY(posY);
               player.motionY(posY);
               this.speed.strafeSpeed *= 2.053859;
            } else if (this.speed.step == 3) {
               posY = 0.71 * (this.speed.sqrt - this.speed.defaultSpeed());
               this.speed.strafeSpeed = this.speed.sqrt - posY;
            } else {
               AxisAlignedBB axisAlignedBB;
               if (ForgeVersion.minorVersion() == 13) {
                  axisAlignedBB = player.boundingBox().copy().offset(0.0, player.motionY(), 0.0);
               } else {
                  axisAlignedBB = player.boundingBox().offset(0.0, player.motionY(), 0.0);
               }

               List<AxisAlignedBB> axisAlignedBBS = Minecraft.theWorld().getCollisionBoxes(player, axisAlignedBB);
               if ((axisAlignedBBS.size() > 0 || player.isCollidedVertically()) && this.speed.step > 0) {
                  this.speed.step = player.moveForward() == 0.0F && player.moveStrafe() == 0.0F ? 0 : 1;
               }

               this.speed.strafeSpeed = this.speed.sqrt - this.speed.sqrt / 156.0;
            }

            if (this.speed.step > 0) {
               this.speed.strafeSpeed = Math.max(this.speed.strafeSpeed, this.speed.defaultSpeed());
               this.speed.strafeSpeed = Math.max(this.speed.strafeSpeed, this.speed.defaultSpeed());
               posY = player.movementInput().moveForward();
               double strafe = player.movementInput().moveStrafe();
               float yaw = player.rotationYaw();
               if (posY == 0.0 && strafe == 0.0) {
                  event.setX(0.0);
                  event.setZ(0.0);
               } else if (posY != 0.0) {
                  if (strafe > 0.0) {
                     yaw += posY > 0.0 ? -45.0F : 45.0F;
                     strafe = 0.0;
                  } else if (strafe < 0.0) {
                     yaw += posY > 0.0 ? 45.0F : -45.0F;
                     strafe = 0.0;
                  }

                  if (posY > 0.0) {
                     posY = 1.0;
                  } else {
                     posY = -1.0;
                  }
               }

               double cos = Math.cos(Math.toRadians(yaw + 90.0F));
               double sin = Math.sin(Math.toRadians(yaw + 90.0F));
               event.setX((posY * this.speed.strafeSpeed * cos + strafe * this.speed.strafeSpeed * sin) * 0.99);
               event.setZ((posY * this.speed.strafeSpeed * sin - strafe * this.speed.strafeSpeed * cos) * 0.99);
            }

            if (player.moveForward() != 0.0F || player.moveStrafe() != 0.0F) {
               ++this.speed.step;
            }

         }
      }
   }

   public double randomSpeed(double min, double max) {
      return Math.random() * (min - max) + max;
   }
}
