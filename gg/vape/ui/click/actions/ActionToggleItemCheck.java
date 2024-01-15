package gg.vape.ui.click.actions;

import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.frame.impl.FrameItemLimitList;

public class ActionToggleItemCheck implements IButtonOnClick {
   // $FF: synthetic field
   final FrameItemLimitList limitList;

   public ActionToggleItemCheck(FrameItemLimitList var1) {
      this.limitList = var1;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      if (mouseBn == 0) {
         this.limitList.toggle();
      }

   }
}
