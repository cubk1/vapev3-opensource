package gg.vape.ui.click.actions;

import gg.vape.module.Macro;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.impl.FrameMacrosEditor;

public class ActionSetMacroDelay implements IGuiCallback {
   // $FF: synthetic field
   final IntractiveComponent c2015;
   // $FF: synthetic field
   final Macro c7184;
   // $FF: synthetic field
   final FrameMacrosEditor c8049;

   public ActionSetMacroDelay(FrameMacrosEditor var1, IntractiveComponent var2, Macro var3) {
      this.c8049 = var1;
      this.c2015 = var2;
      this.c7184 = var3;
   }

   public void call(IGuiComponent inst) {
      this.c2015.setName("  Delay: " + this.c7184.c2102().c4968() + " - " + this.c7184.c2102().c5400());
   }
}
