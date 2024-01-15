package gg.vape.ui.click.actions;

import gg.vape.module.Macro;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.impl.FrameMacrosEditor;

public class ActionSetMacroDoubleClickDelay implements IGuiCallback {
   // $FF: synthetic field
   final IntractiveComponent c8060;
   // $FF: synthetic field
   final Macro c3758;
   // $FF: synthetic field
   final FrameMacrosEditor c4431;

   public ActionSetMacroDoubleClickDelay(FrameMacrosEditor var1, IntractiveComponent var2, Macro var3) {
      this.c4431 = var1;
      this.c8060 = var2;
      this.c3758 = var3;
   }

   public void call(IGuiComponent inst) {
      this.c8060.setName("  Double click: " + this.c3758.c6968().c4968() + " - " + this.c3758.c6968().c5400());
      this.c8060.setDisplayable(this.c3758.c2906().getValue());
   }
}
