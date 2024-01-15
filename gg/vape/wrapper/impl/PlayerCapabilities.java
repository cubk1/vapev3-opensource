package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MPlayerCapabilities;
import gg.vape.wrapper.Wrapper;

public class PlayerCapabilities extends Wrapper {
   public PlayerCapabilities(Object var1) {
      super(var1);
   }

   public boolean isCreativeMode() {
      return MPlayerCapabilities.c3695(vape.getMappings().playerCapabilities, this.obj);
   }

   public boolean isFlying() {
      return MPlayerCapabilities.c3180(vape.getMappings().playerCapabilities, this.obj);
   }
}
