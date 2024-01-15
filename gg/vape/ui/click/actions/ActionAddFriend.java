package gg.vape.ui.click.actions;

import gg.vape.manager.client.FriendManager;
import gg.vape.ui.click.IButtonOnClick;

public class ActionAddFriend implements IButtonOnClick {
   // $FF: synthetic field
   final IButtonOnClick c8892;
   // $FF: synthetic field
   final FriendManager c2464;

   public ActionAddFriend(FriendManager var1, IButtonOnClick var2) {
      this.c2464 = var1;
      this.c8892 = var2;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      this.c8892.onClick(mouseX, mouseY, mouseBn);
      this.c2464.c2618();
   }
}
