package gg.vape.ui.click.actions;

import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.frame.impl.FrameLimitManager;
import gg.vape.unmap.ItemLimitData;
import gg.vape.value.LimitValue;

public class ActionRemoveLimit implements IButtonOnClick {
   // $FF: synthetic field
   final LimitValue c8143;
   // $FF: synthetic field
   final ItemLimitData c6323;
   // $FF: synthetic field
   final FrameLimitManager c2367;

   public ActionRemoveLimit(FrameLimitManager var1, LimitValue var2, ItemLimitData var3) {
      this.c2367 = var1;
      this.c8143 = var2;
      this.c6323 = var3;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      if (mouseBn == 0) {
         this.c8143.c354(this.c6323);
      }

   }
}
