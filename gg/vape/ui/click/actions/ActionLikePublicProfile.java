package gg.vape.ui.click.actions;

import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.impl.profile.FrameProfilesExplorer;
import pub.nextsense.Tweaker;

public class ActionLikePublicProfile implements IButtonOnClick {
   // $FF: synthetic field
   final IntractiveComponent c7496;
   // $FF: synthetic field
   final IntractiveComponent c5557;
   // $FF: synthetic field
   final FrameProfilesExplorer c1835;

   public ActionLikePublicProfile(FrameProfilesExplorer var1, IntractiveComponent var2, IntractiveComponent var3) {
      this.c1835 = var1;
      this.c7496 = var2;
      this.c5557 = var3;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      if (mouseBn == 0) {
         int var4 = FrameProfilesExplorer.c7230(this.c1835).c6051() ? 0 : 2;
         String var5 = Tweaker.post("/config/pub/like.php", "profile_id=" + FrameProfilesExplorer.c7230(this.c1835).c208().toString() + "&type=" + var4);
         if (var5.length() != 0) {
            if (var5.contains("success")) {
               FrameProfilesExplorer.c7230(this.c1835).c122();
               this.c7496.setName(String.valueOf(FrameProfilesExplorer.c7230(this.c1835).c581()));
               this.c5557.setName(String.valueOf(FrameProfilesExplorer.c7230(this.c1835).c3883()));
            }

         }
      }
   }
}
