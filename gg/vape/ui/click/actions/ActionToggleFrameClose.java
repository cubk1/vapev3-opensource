package gg.vape.ui.click.actions;

import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.frame.impl.FrameClosable;

public class ActionToggleFrameClose implements IButtonOnClick {
   // $FF: synthetic field
   final FrameClosable c4452;

   public ActionToggleFrameClose(FrameClosable var1) {
      this.c4452 = var1;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      if (mouseBn == 0) {
         this.c4452.toggle();
      }

   }
}