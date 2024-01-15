package gg.vape.module.other;

import gg.vape.Vape;
import gg.vape.event.impl.EventTick;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.none.ClickGui;
import gg.vape.value.BooleanValue;
import gg.vape.wrapper.impl.Minecraft;
import pub.nextsense.common.d;

public class SelfDestruct extends Mod {
   public final BooleanValue disableAuth = BooleanValue.create(this, "Temp Disable", false, "Temporarily disable account from authentication");

   public SelfDestruct() {
      super("SelfDestruct", 1, Category.Other, "You can press LEFT CONTROL + HOME on your keyboard to self destruct at any time, including while in a portal, GUI, or menu");
      this.getValues().add(this.disableAuth);
   }

   public void onTick(EventTick event) {
   }

   public void onEnable() {
      Vape.instance.destructed = true;
      if (!Minecraft.thePlayer().isNull()) {
         Minecraft.currentScreen(null);
         Minecraft.setIngameFocus();
         d.onGuiClosed(d.getGuiObject());
      }

      for (Mod mod : Vape.instance.getModManager().collectMods()) {
         if (mod.getState() && !mod.getClass().equals(ClickGui.class)) {
            mod.setState(false);
         }
      }

      try {
         Thread.sleep(500L);
      } catch (InterruptedException var3) {
      }

      Vape.instance.destruct(this.disableAuth.getValue());
   }
}
