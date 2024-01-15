package gg.vape.wrapper.impl;

public class PlayerEventNameFormat extends ForgeEvent {
   public PlayerEventNameFormat(Object var1) {
      super(var1);
   }

   public String c6376() {
      return vape.getMappings().mPlayerEventNameFormat.c68(this.getObject());
   }

   public String c693() {
      return vape.getMappings().mPlayerEventNameFormat.c4340(this.getObject());
   }

   public void c6694(String var1) {
      vape.getMappings().mPlayerEventNameFormat.c2338(this.getObject(), var1);
   }
}
