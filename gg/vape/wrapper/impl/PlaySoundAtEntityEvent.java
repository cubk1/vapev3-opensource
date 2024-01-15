package gg.vape.wrapper.impl;

public class PlaySoundAtEntityEvent extends EntityEvent {
   public PlaySoundAtEntityEvent(Object var1) {
      super(var1);
   }

   public String c6376() {
      return ForgeVersion.minorVersion() >= 23 ? "" : vape.getMappings().playSoundAtEntityEvent.c68(this.getObject());
   }
}
