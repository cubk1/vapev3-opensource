package gg.vape.module.combat;

import gg.vape.Vape;
import gg.vape.event.impl.EventLivingUpdate;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.blatant.Scaffold;
import gg.vape.wrapper.impl.KeyBinding;
import gg.vape.wrapper.impl.Minecraft;

public class Sprint extends Mod {
   public Scaffold scaffold;

   public Sprint() {
      super("Sprint", -16711796, Category.Combat, "Sets your sprinting to true.");
   }

   public void onUpdate(EventLivingUpdate event) {
      if (this.scaffold == null) {
         this.scaffold = Vape.instance.getModManager().getMod(Scaffold.class);
      }

      if (Minecraft.currentScreen().isNull()) {
         KeyBinding.setKeyBindState(Minecraft.gameSettings().keyBinding().getKeyCode(), !this.scaffold.shouldStopSprinting() && !Minecraft.gameSettings().keyBinding().isPressed() && !Minecraft.thePlayer().isSprinting() && !Minecraft.thePlayer().isCollidedHorizontally());

      }
   }

   public void onDisable() {
      KeyBinding.setKeyBindState(Minecraft.gameSettings().keyBinding().getKeyCode(), false);
   }
}
