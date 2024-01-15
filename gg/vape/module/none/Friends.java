package gg.vape.module.none;

import gg.vape.Vape;
import gg.vape.event.impl.EventChat;
import gg.vape.event.impl.EventNameFormat;
import gg.vape.friend.Friend;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.TextComponentString;

import java.util.Iterator;

public class Friends extends Mod {
   public Friends() {
      super("Friends", 0, 0, Category.None, null);
   }

   public void c8731() {
      this.c141();
   }

   public void onNameFormat(EventNameFormat event) {
      if (Vape.instance.getFriendManager().forceAlias.getValue()) {
         Friend var2 = Vape.instance.getFriendManager().c6216(event.c4561(), false);
         if (Vape.instance.getFriendManager().forceAlias.getValue()) {
            if (var2 != null && var2.inFriends()) {
               event.c6485(var2.c5811());
            }
         } else {
            event.c6485(event.c1336());
         }

      }
   }

   public void onChat(EventChat event) {
      if (Vape.instance.getFriendManager().forceAlias.getValue()) {
         Iterator var2 = Vape.instance.getFriendManager().getFriends().iterator();

         while(true) {
            Friend var3;
            do {
               do {
                  if (!var2.hasNext()) {
                     return;
                  }

                  var3 = (Friend)var2.next();
               } while(!var3.inFriends());
            } while(!event.c8633().c376().toLowerCase().contains(var3.c3125().toLowerCase()));

            String var4 = event.c8633().c693();

            for(int var5 = var4.toLowerCase().indexOf(var3.c3125().toLowerCase()); var5 >= 0; var5 = var4.toLowerCase().indexOf(var3.c3125())) {
               String var6 = var4.substring(var5, var5 + var3.c3125().toLowerCase().length());
               var4 = var4.replaceAll(var6, var3.c3501());
            }

            event.c4469(TextComponentString.c546(var4));
         }
      }
   }
}
