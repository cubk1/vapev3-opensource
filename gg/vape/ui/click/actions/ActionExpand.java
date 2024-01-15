package gg.vape.ui.click.actions;

import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.frame.Frame;

public class ActionExpand implements IGuiCallback {
   // $FF: synthetic field
   final Frame c2347;

   public ActionExpand(Frame var1) {
      this.c2347 = var1;
   }

   public void call(IGuiComponent inst) {
      Frame.c6910(this.c2347).setName(this.c2347.isClosed() ? "+" : "-");
   }
}
