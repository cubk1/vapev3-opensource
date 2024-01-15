package gg.vape.ui.click.actions;

import gg.vape.Vape;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.FrameButtonGroup;

public class ActionToggleDisplay implements IGuiCallback {
   // $FF: synthetic field
   final ClickGui c2984;
   // $FF: synthetic field
   final Frame c2685;
   // $FF: synthetic field
   final FrameButtonGroup c234;

   public ActionToggleDisplay(FrameButtonGroup var1, ClickGui var2, Frame var3) {
      this.c234 = var1;
      this.c2984 = var2;
      this.c2685 = var3;
   }

   public void call(IGuiComponent inst) {
      if (this.c2984.getEditState()) {
         this.c234.setDisplayable(true);
      } else {
         this.c234.setDisplayable(this.c234.c5615().c2346());
         if (!this.c234.displayable()) {
            this.c2685.setDisplayable(false);
         }
      }

      this.c234.c5615().setColor(Vape.instance.getSettings().guiColor.getAsColor());
   }
}
