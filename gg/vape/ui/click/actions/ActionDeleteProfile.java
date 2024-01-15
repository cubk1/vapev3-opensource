package gg.vape.ui.click.actions;

import gg.vape.Vape;
import gg.vape.config.Profile;
import gg.vape.manager.FrameManager;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.frame.impl.profile.FramePublicProfile;
import pub.nextsense.Tweaker;

public class ActionDeleteProfile implements IButtonOnClick {
   // $FF: synthetic field
   final Profile c17;
   // $FF: synthetic field
   final FramePublicProfile c3127;

   public ActionDeleteProfile(FramePublicProfile var1, Profile var2) {
      this.c3127 = var1;
      this.c17 = var2;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      String var4 = Tweaker.post("/config/pub/delete.php", "profile_id=" + this.c17.c208().toString());
      if (!var4.isEmpty()) {
         if (var4.contains("success")) {
            Profile var5 = new Profile(this.c17.c1754(), this.c17.c2580(), this.c17.c5319());
            var5.c3055(this.c17.c6931());
            var5.c7575(this.c17.c208());
            ClickGui.c6033(null);
            Vape.instance.getProfilesManager().c7522(this.c17);
            Vape.instance.getProfilesManager().c2321(var5);
            FrameManager.c3462.c7575(this.c17.c208());
            FrameManager.c3462.renderFrame();
         }

      }
   }
}
