package gg.vape.ui.click.actions;

import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.frame.Frame;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.ScaledResolution;

public class ActionRescaleFrame implements IButtonOnClick {
   // $FF: synthetic field
   final Frame c288;

   public ActionRescaleFrame(Frame var1) {
      this.c288 = var1;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      if (mouseBn == 0) {
         ScaledResolution var4 = Minecraft.c4912();
         this.c288.c888(var4);
         this.c288.c6393(var4);
      }

   }
}
