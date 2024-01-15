package gg.vape.wrapper.impl;

public class ClientChatReceivedEvent extends ForgeEvent {
   public ClientChatReceivedEvent(Object var1) {
      super(var1);
   }

   public ITextComponent c8173() {
      return vape.getMappings().clientChatReceivedEvent.c5451(this.getObject());
   }

   public void c1209(ITextComponent var1) {
      vape.getMappings().clientChatReceivedEvent.c6771(this.getObject(), var1.getObject());
   }
}
