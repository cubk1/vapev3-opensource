package gg.vape.ui.click.actions;

import gg.vape.module.render.Fullbright;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.wrapper.impl.Minecraft;

public class ActionToggleFullbright implements IGuiCallback {
   // $FF: synthetic field
   final Fullbright c2769;

   public ActionToggleFullbright(Fullbright var1) {
      this.c2769 = var1;
   }

   public void call(IGuiComponent inst) {
      if (this.c2769.getState()) {
         if (Fullbright.c8277(this.c2769).getValue().equals(Fullbright.c3513(this.c2769))) {
            Minecraft.thePlayer().c4326(16);
         } else if (Fullbright.c6762(this.c2769) != -1.0F) {
            Minecraft.gameSettings().c6025(Fullbright.c6762(this.c2769));
         }

      }
   }
}
