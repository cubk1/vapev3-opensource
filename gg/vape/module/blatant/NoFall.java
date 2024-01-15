package gg.vape.module.blatant;

import gg.vape.Vape;
import gg.vape.event.impl.EventMotion;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.unmap.ModeSelection;
import gg.vape.value.ModeValue;
import gg.vape.wrapper.impl.*;

public class NoFall extends Mod {
   public final ModeSelection c3314 = new ModeSelection("Normal");
   public final ModeSelection c1503 = new ModeSelection("Hypixel");
   public final ModeValue c6009;

   public NoFall() {
      super("NoFall", 8919359, Category.Blatant, "Prevents taking fall damage.\nThis may not bypass AntiCheats.\n(Bypasses Hypixel)");
      this.c6009 = ModeValue.create(this, "Mode", "NoFall method to prevent you from taking fall damage.\nNormal - Works on vanilla/some anti-cheats (Does not Bypass Hypixel)\nHypixel - Bypasses Watchdog, may work on other anti-cheats", this.c3314, this.c3314, this.c1503);
      this.c6009.getComponent().addAction(new c5864(this));
      this.addValue(this.c6009);
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onMotionUpdate(EventMotion event) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      this.setSuffix(this.c6009.getValue().getName());
      if (!var2.isNull() && !var2.getWorld().isNull() && !var2.isDead() && !var2.capabilities().isCreativeMode() && !var2.capabilities().isFlying() && !Vape.instance
              .getModManager().getState(Fly.class)) {
         boolean var3 = (double)var2.c7206() > 2.224 && var2.motionY() < 0.0;
         if (this.c6009.getValue() == this.c3314) {
            if (event.getType() == EventType.PRE) {
               if (var3) {
                  event.setOnGround(true);
                  var2.setJumpTicks(10);
                  if (Minecraft.gameSettings().c6247().isPressed()) {
                     KeyBinding.setKeyBindState(Minecraft.gameSettings().c6247().getKeyCode(), false);
                     KeyBinding.onTick(Minecraft.gameSettings().c6247().getKeyCode());
                  }
               }
            } else if (var3) {
               var2.c3224(false);
            }
         }

         if (this.c6009.getValue() == this.c1503 && event.getType() == EventType.PRE && (double)var2.c7206() > 2.224 && var2.motionY() < 0.0) {
            var2.sendQueue().addToSendQueue(C03PacketPlayer.newInstance(true));
         }

      }
   }

   // $FF: synthetic method
   static ModeValue c7117(NoFall var0) {
      return var0.c6009;
   }
}
class c5864 implements IGuiCallback {
   // $FF: synthetic field
   final NoFall c726;

   c5864(NoFall var1) {
      this.c726 = var1;
   }

   public void call(IGuiComponent inst) {
      ((Mod) NoFall.c7117(this.c726).getOwner()).setSuffix(NoFall.c7117(this.c726).getValue().getName());
   }
}