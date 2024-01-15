package gg.vape.ui.click.actions;

import gg.vape.config.Profile;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.frame.impl.profile.FramePublicProfile;
import pub.nextsense.Tweaker;

public class ActionRetriePublicProfile implements IButtonOnClick {
   // $FF: synthetic field
   final Profile c8088;
   // $FF: synthetic field
   final FramePublicProfile c8286;

   public ActionRetriePublicProfile(FramePublicProfile var1, Profile var2) {
      this.c8286 = var1;
      this.c8088 = var2;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      String var4 = Tweaker.post("/config/pub/store.php", "profile_id=" + this.c8088.c208().toString());
      if (!var4.isEmpty()) {
         if (var4.contains("success")) {
         }

      }
   }
}
