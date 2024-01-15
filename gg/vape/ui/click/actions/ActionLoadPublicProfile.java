package gg.vape.ui.click.actions;

import gg.vape.Vape;
import gg.vape.config.Profile;
import gg.vape.config.PublicProfile;
import gg.vape.manager.FrameManager;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.impl.profile.FramePublicProfile;
import pub.nextsense.Tweaker;

public class ActionLoadPublicProfile implements IButtonOnClick {
   // $FF: synthetic field
   final Profile c1353;
   // $FF: synthetic field
   final IntractiveComponent c3821;
   // $FF: synthetic field
   final FramePublicProfile c2134;

   public ActionLoadPublicProfile(FramePublicProfile var1, Profile var2, IntractiveComponent var3) {
      this.c2134 = var1;
      this.c1353 = var2;
      this.c3821 = var3;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      if (Vape.instance.getProfilesManager().c3809() < 10) {
         if (!this.c1353.c5319()) {
            Vape.instance.getSettings().syncSettingsButton.getClickEvent().onClick(0, 0, 0);

            try {
               Thread.sleep(200L);
            } catch (InterruptedException var6) {
               var6.printStackTrace();
            }
         }

         if (!this.c1353.c5319()) {
            this.c3821.setName("Must sync");
         } else {
            String var4 = Tweaker.post("/config/pub/store.php", "profile_id=" + this.c1353.c208().toString());
            if (!var4.isEmpty()) {
               if (var4.contains("success")) {
                  PublicProfile var5 = new PublicProfile(this.c1353.c1754(), this.c1353.c2580());
                  var5.c8827(true);
                  var5.c8121(true);
                  var5.c3055(this.c1353.c6931());
                  var5.c7575(this.c1353.c208());
                  ClickGui.c6033(null);
                  Vape.instance.getProfilesManager().c7522(this.c1353);
                  Vape.instance.getProfilesManager().c2321(var5);
                  FrameManager.c3462.c8255().add(var5);
                  FrameManager.c3462.renderFrame();
               }

            }
         }
      }
   }
}
