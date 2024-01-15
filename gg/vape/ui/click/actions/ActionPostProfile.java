package gg.vape.ui.click.actions;

import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.impl.profile.FrameProfilesExplorer;
import pub.nextsense.Tweaker;

class ActionPostProfile implements IButtonOnClick {
   // $FF: synthetic field
   final IntractiveComponent c4801;
   // $FF: synthetic field
   final IntractiveComponent c5745;
   // $FF: synthetic field
   final FrameProfilesExplorer c8476;

   ActionPostProfile(FrameProfilesExplorer var1, IntractiveComponent var2, IntractiveComponent var3) {
      this.c8476 = var1;
      this.c4801 = var2;
      this.c5745 = var3;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      if (mouseBn == 0) {
         int var4 = FrameProfilesExplorer.c7230(this.c8476).c199() ? 0 : 1;
         String var5 = Tweaker.post("/config/pub/like.php", "profile_id=" + FrameProfilesExplorer.c7230(this.c8476).c208().toString() + "&type=" + var4);
         if (var5.length() != 0) {
            if (var5.contains("success")) {
               FrameProfilesExplorer.c7230(this.c8476).c7829();
               this.c4801.setName(String.valueOf(FrameProfilesExplorer.c7230(this.c8476).c581()));
               this.c5745.setName(String.valueOf(FrameProfilesExplorer.c7230(this.c8476).c3883()));
            }

         }
      }
   }
}
