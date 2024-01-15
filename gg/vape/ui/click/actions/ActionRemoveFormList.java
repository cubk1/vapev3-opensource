package gg.vape.ui.click.actions;

import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.frame.impl.FrameItemLimitList;
import gg.vape.value.OptionalLimitValue;

public class ActionRemoveFormList implements IButtonOnClick {
   // $FF: synthetic field
   final OptionalLimitValue limitButton;
   // $FF: synthetic field
   final FrameItemLimitList limitList;

   public ActionRemoveFormList(FrameItemLimitList var1, OptionalLimitValue var2) {
      this.limitList = var1;
      this.limitButton = var2;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      if (mouseBn == 0) {
         this.limitButton.c536(this.limitList);
      }

   }
}
