package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MGameProfile;
import gg.vape.wrapper.Wrapper;

import java.util.UUID;

public class GameProfile extends Wrapper {
   public GameProfile(Object var1) {
      super(var1);
   }

   public UUID getUUID() {
      return MGameProfile.getUUID(vape.getMappings().gameProfile, this.obj);
   }
}
