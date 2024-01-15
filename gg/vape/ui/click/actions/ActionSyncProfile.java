package gg.vape.ui.click.actions;

import gg.vape.Vape;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.gui.ExpandableButton;
import gg.vape.ui.click.frame.impl.profile.FrameProfilesExplorer;

public class ActionSyncProfile implements IGuiCallback {
   // $FF: synthetic field
   final ExpandableButton c2048;
   // $FF: synthetic field
   final FrameProfilesExplorer c2453;

   public ActionSyncProfile(FrameProfilesExplorer var1, ExpandableButton var2) {
      this.c2453 = var1;
      this.c2048 = var2;
   }

   public void call(IGuiComponent inst) {
      if (Vape.instance.getProfilesManager().c6990(FrameProfilesExplorer.c7230(this.c2453).c208()) != null) {
         this.c2048.setText("Update this profile");
         this.c2048.c3376().c7057("sync");
      } else {
         this.c2048.setText("Download this profile");
         this.c2048.c3376().c7057("download");
      }

   }
}
