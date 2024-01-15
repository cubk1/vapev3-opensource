package gg.vape.ui.click.actions;

import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;

public class ActionToggleSmoothFont implements IGuiCallback {
   // $FF: synthetic field
   final ClickGui c8082;

   public ActionToggleSmoothFont(ClickGui var1) {
      this.c8082 = var1;
   }

   public void call(IGuiComponent inst) {
      ClickGui.smoothFont = this.c8082.smooth_font.getValue();
   }
}
