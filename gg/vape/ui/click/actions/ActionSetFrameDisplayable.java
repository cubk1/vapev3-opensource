package gg.vape.ui.click.actions;

import gg.vape.manager.FrameManager;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;

public class ActionSetFrameDisplayable implements IGuiCallback {
   // $FF: synthetic field
   final FrameManager frameManager;

   public ActionSetFrameDisplayable(FrameManager frameManager) {
      this.frameManager = frameManager;
   }

   public void call(IGuiComponent inst) {
      FrameManager.c1600.setDisplayable(FrameManager.c3462.displayable());
      FrameManager.c6371.setDisplayable(FrameManager.c3462.displayable());
   }
}
