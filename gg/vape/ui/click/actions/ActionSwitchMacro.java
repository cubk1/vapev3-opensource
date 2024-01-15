package gg.vape.ui.click.actions;

import gg.vape.module.Macro;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.frame.impl.FrameMacros;
import gg.vape.ui.click.frame.impl.FrameMacrosEditor;

public class ActionSwitchMacro implements IButtonOnClick {
   // $FF: synthetic field
   final FrameMacros c6526;
   // $FF: synthetic field
   final Macro c2523;
   // $FF: synthetic field
   final FrameMacrosEditor c6775;

   public ActionSwitchMacro(FrameMacrosEditor var1, FrameMacros var2, Macro var3) {
      this.c6775 = var1;
      this.c6526 = var2;
      this.c2523 = var3;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      if (mouseBn == 0) {
         this.c6526.c5559(this.c2523);
         this.c6526.c5470(true);
         this.c6526.c2085(true);
      }

   }
}
