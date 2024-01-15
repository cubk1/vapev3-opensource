package gg.vape.ui.click.actions;

import gg.vape.config.Profile;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.frame.impl.profile.FramePublicProfile;
import pub.nextsense.Tweaker;

public class ActionCopyProfileString implements IButtonOnClick {
   // $FF: synthetic field
   final Profile c2522;
   // $FF: synthetic field
   final FramePublicProfile c6377;

   public ActionCopyProfileString(FramePublicProfile var1, Profile var2) {
      this.c6377 = var1;
      this.c2522 = var2;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      Tweaker.copyString(this.c2522.c208().toString());
   }
}
