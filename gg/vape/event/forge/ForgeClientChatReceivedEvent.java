package gg.vape.event.forge;

import gg.vape.event.impl.EventChat;
import gg.vape.mapping.MappedClasses;
import gg.vape.wrapper.impl.ClientChatReceivedEvent;

public class ForgeClientChatReceivedEvent extends ForgeEventHook {
   public ForgeClientChatReceivedEvent() {
      super(MappedClasses.ClientChatReceivedEvent, 0);
   }

   public void call(Object var1) {
      ClientChatReceivedEvent var2 = new ClientChatReceivedEvent(var1);
      EventChat var3 = new EventChat(var2.c8173());
      var3.fire();
      var2.c1209(var3.c8633());
   }
}
