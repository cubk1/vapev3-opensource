package gg.vape.ui.click.actions;

import gg.vape.Vape;
import gg.vape.friend.Friend;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.frame.impl.FrameFriend;

public class ActionRemoveFriend implements IButtonOnClick {
   // $FF: synthetic field
   final Friend c1778;
   // $FF: synthetic field
   final FrameFriend c3198;

   public ActionRemoveFriend(FrameFriend var1, Friend var2) {
      this.c3198 = var1;
      this.c1778 = var2;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      if (mouseBn == 0) {
         Vape.instance.getFriendManager().c2616(this.c1778);
      }

   }
}
