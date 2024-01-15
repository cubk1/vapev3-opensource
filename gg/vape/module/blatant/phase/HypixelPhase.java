package gg.vape.module.blatant.phase;

import gg.vape.event.impl.EventMotion;
import gg.vape.module.Mod;
import gg.vape.module.SubModule;
import gg.vape.wrapper.impl.C04PacketPlayerPosition;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.ForgeVersion;
import gg.vape.wrapper.impl.Minecraft;

public class HypixelPhase extends SubModule {
   public HypixelPhase(Mod phase, String name) {
      super(phase, name);
   }

   public void onMotionUpdate(EventMotion event) {
      if (event.isPre()) {
         EntityPlayerSP player = Minecraft.thePlayer();
         if (player.isNull()) {
            return;
         }

         double phaseSpeed = 0.163;
         double cos = Math.cos(Math.toRadians(player.rotationYaw() + 90.0F));
         double sin = Math.sin(Math.toRadians(player.rotationYaw() + 90.0F));
         double forward = (double)player.movementInput().moveForward() * phaseSpeed * cos + (double)player.movementInput().moveStrafe() * phaseSpeed * sin;
         double strafe = (double)player.movementInput().moveForward() * phaseSpeed * sin - (double)player.movementInput().moveStrafe() * phaseSpeed * cos;
         if (player.isCollidedHorizontally() && !player.isOnLadder()) {
            if (ForgeVersion.minorVersion() > 13) {
               player.sendQueue().addToSendQueue(C04PacketPlayerPosition.newInstance(player.posX() + forward, player.posY(), player.posZ() + strafe, false));
               player.sendQueue().addToSendQueue(C04PacketPlayerPosition.newInstance(player.posX() - 0.4982374987, player.posY() - 0.4982374987, player.posZ(), false));
            } else {
               player.sendQueue().addToSendQueue(C04PacketPlayerPosition.newInstance(player.posX() + forward, player.boundingBox().minY(), player.posY(), player.posZ() + strafe, false));
               player.sendQueue().addToSendQueue(C04PacketPlayerPosition.newInstance(player.posX(), player.boundingBox().minY() - 0.4982374987, player.posY() - 0.4982374987, player.posZ(), false));
            }
         }
      }

   }
}
