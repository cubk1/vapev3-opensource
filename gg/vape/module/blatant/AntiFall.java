package gg.vape.module.blatant;

import gg.vape.Vape;
import gg.vape.event.impl.EventMotion;
import gg.vape.event.impl.EventPacketReceive;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.utils.TimerUtil;
import gg.vape.value.BooleanValue;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.*;

public class AntiFall extends Mod {
   public final BooleanValue speedCheck = BooleanValue.create(this, "Speed Check", false, "Ignore falling when Speed is enabled.");
   public final NumberValue fallDistance = NumberValue.c8404(this, "Fall Dist", "#.#", "m", 0.1, 2.0, 5.0, "The amount of blocks to fall before attempting to lag back.");
   public final TimerUtil timer = new TimerUtil();
   public boolean save;

   public AntiFall() {
      super("AntiFall", 16028225, Category.Blatant, "Helps you with your Parkinson's\nPrevents you from falling into the void.");
      this.addValue(this.speedCheck, this.fallDistance);
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onMotionUpdate(EventMotion event) {
      EntityPlayerSP player = Minecraft.thePlayer();
      World world = player.getWorld();
      if (!player.isNull() && !world.isNull() && !player.isDead() && !player.capabilities().isCreativeMode() && !player.capabilities().isFlying() && !Vape.instance
              .getModManager().getState(Fly.class) && (!this.speedCheck.getValue() || !Vape.instance.getModManager().getState(Speed.class))) {
         if (event.getType() == EventType.PRE) {
            if (!this.save && this.c5373()) {
               return;
            }

            if (this.save && this.timer.hasTimeElapsed(250L) || player.isCollidedVertically()) {
               this.save = false;
               this.timer.reset();
               return;
            }

            double var4 = this.fallDistance.getValue();
            if ((double)player.c7206() >= var4 && !Vape.instance.getModManager().getMod(Fly.class).getState()) {
               Block block = world.getBlock(player.posX(), player.posY() - 1.0, player.posZ());
               if (block.isNull() || block.c4045().isInstance(Blocks.c2456().c4045().getObject().getClass())) {
                  if (!this.save) {
                     this.save = true;
                     this.timer.reset();
                  } else {
                     player.movementInput().moveForward(0.0F);
                     player.movementInput().moveStrafe(0.0F);
                     player.motionX(0.0);
                     player.motionZ(0.0);
                     player.motionY(0.61765834912346);
                  }
               }
            }
         }

      }
   }

   public void onPacketReceive(EventPacketReceive event) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      if (!event.getPacket().isNull() && !var2.isNull() && !var2.getWorld().isNull()) {
         if (event.getPacket().isInstance(MappedClasses.SPacketPlayerPosLook)) {
            var2.c1995(0.0F);
            var2.motionX(0.0);
            var2.motionZ(0.0);
            this.save = false;
            this.timer.reset();
         }

      }
   }

   public boolean c5373() {
      EntityPlayerSP var1 = Minecraft.thePlayer();
      World var2 = var1.getWorld();

      for(double var3 = var1.posY() - 1.0; var3 > 0.0; --var3) {
         Block var5 = var2.getBlock(var1.posX(), var3, var1.posZ());
         if (!var5.isNull() && !var5.c4045().isInstance(Blocks.c2456().c4045().getObject().getClass())) {
            return true;
         }
      }

      return false;
   }
}
