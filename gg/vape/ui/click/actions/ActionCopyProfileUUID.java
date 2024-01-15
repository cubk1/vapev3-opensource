package gg.vape.ui.click.actions;

import gg.vape.config.PublicProfile;
import gg.vape.threads.CopyUUIDThread;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.component.gui.ExpandableButton;
import gg.vape.ui.click.frame.impl.profile.FrameProfilesExplorer;
import pub.nextsense.Tweaker;

public class ActionCopyProfileUUID implements IButtonOnClick {
   // $FF: synthetic field
   final PublicProfile c2805;
   // $FF: synthetic field
   public final ExpandableButton c4862;
   // $FF: synthetic field
   final FrameProfilesExplorer c3972;

   public ActionCopyProfileUUID(FrameProfilesExplorer var1, PublicProfile var2, ExpandableButton var3) {
      this.c3972 = var1;
      this.c2805 = var2;
      this.c4862 = var3;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      Tweaker.copyString(this.c2805.c208().toString());
      this.c4862.setText("Copied!");
      (new CopyUUIDThread(this)).start();
   }
}
