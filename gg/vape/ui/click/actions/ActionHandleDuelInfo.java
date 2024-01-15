package gg.vape.ui.click.actions;

import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.click.frame.impl.FrameDuelInfo;

import java.awt.*;

public class ActionHandleDuelInfo implements IGuiCallback {
   // $FF: synthetic field
   final FrameComponent c1321;
   // $FF: synthetic field
   final FrameDuelInfo c3849;

   public ActionHandleDuelInfo(FrameDuelInfo var1, FrameComponent var2) {
      this.c3849 = var1;
      this.c1321 = var2;
   }

   public void call(IGuiComponent inst) {
      if (FrameDuelInfo.c2334(this.c3849).c8174() == FrameDuelInfo.c2334(this.c3849).c190()) {
         this.c1321.setColor(IGuiComponent.l);
      } else {
         if (FrameDuelInfo.c2334(this.c3849).c8174() > FrameDuelInfo.c2334(this.c3849).c190()) {
            this.c1321.setColor(new Color(0, 100, 0, 125));
         } else {
            this.c1321.setColor(new Color(100, 0, 0, 125));
         }

      }
   }
}
