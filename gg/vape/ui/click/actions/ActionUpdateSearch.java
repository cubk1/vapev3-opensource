package gg.vape.ui.click.actions;

import gg.vape.Vape;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.frame.impl.FrameClosable;

public class ActionUpdateSearch implements IButtonOnClick {
   // $FF: synthetic field
   final FrameClosable c5251;
   // $FF: synthetic field
   final FrameClosable c952;

   public ActionUpdateSearch(FrameClosable var1, FrameClosable var2) {
      this.c952 = var1;
      this.c5251 = var2;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      if (mouseBn == 0) {
         Vape.instance.getSearch().c207(this.c5251);
      }

   }
}
