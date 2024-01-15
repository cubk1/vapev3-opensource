package gg.vape.ui.click.actions;

import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.impl.profile.FramePublicProfile;
import gg.vape.config.Profile;

public class ActionSetProfile implements IGuiCallback {
   // $FF: synthetic field
   final Profile profile;
   // $FF: synthetic field
   final IntractiveComponent c1122;
   // $FF: synthetic field
   final FramePublicProfile c5748;

   public ActionSetProfile(FramePublicProfile var1, Profile var2, IntractiveComponent var3) {
      this.c5748 = var1;
      this.profile = var2;
      this.c1122 = var3;
   }

   public void call(IGuiComponent inst) {
      if (this.profile.c5319()) {
         this.c1122.setName(this.profile.c1754());
      }

   }
}
