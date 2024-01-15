package gg.vape.ui.click.actions;

import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.component.gui.GuiComponentUnion;

public class ActionToggleClose implements IButtonOnClick {
   // $FF: synthetic field
   final GuiComponentUnion c5500;

   public ActionToggleClose(GuiComponentUnion var1) {
      this.c5500 = var1;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      if (mouseBn == 0) {
         this.c5500.setCloseStatus(!this.c5500.isClosed());
      }

   }
}
