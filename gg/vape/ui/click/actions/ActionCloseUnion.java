package gg.vape.ui.click.actions;

import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.component.gui.GuiComponentUnion;

public class ActionCloseUnion implements IButtonOnClick {
   // $FF: synthetic field
   final Object c4701;
   // $FF: synthetic field
   final GuiComponentUnion c2176;

   public ActionCloseUnion(GuiComponentUnion var1, Object var2) {
      this.c2176 = var1;
      this.c4701 = var2;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      if (mouseBn == 0) {
         this.c2176.setCloseStatus(true);
         this.c2176.c3997(this.c4701);
      }

   }
}
