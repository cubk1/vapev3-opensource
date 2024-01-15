package gg.vape.ui.click.actions;

import gg.vape.Vape;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.FrameButtonGroup;

public class ActionCloseFrame implements IButtonOnClick {
   // $FF: synthetic field
   final Frame c299;
   // $FF: synthetic field
   final ClickGui c1457;
   // $FF: synthetic field
   final FrameButtonGroup c7970;

   public ActionCloseFrame(FrameButtonGroup var1, Frame var2, ClickGui var3) {
      this.c7970 = var1;
      this.c299 = var2;
      this.c1457 = var3;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      if (mouseBn == 0) {
         if (this.c299.displayable()) {
            this.c299.setDisplayable(false);
         } else {
            if (this.c299.getX() < -100.0 || this.c299.getY() < -100.0) {
               this.c299.c1042(50.0);
               this.c299.c467(50.0);
            }

            this.c299.setDisplayable(true);
            if (this.c1457.getEditState()) {
               this.c299.setDisplayable(this.c7970.displayable());
            }

            Vape.instance.getFrameManager().getFrames().remove(this.c299);
            Vape.instance.getFrameManager().getFrames().add(0, this.c299);
         }
      }

   }
}
