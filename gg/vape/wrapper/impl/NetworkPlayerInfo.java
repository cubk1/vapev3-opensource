package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MNetworkPlayerInfo;
import gg.vape.wrapper.Wrapper;

public class NetworkPlayerInfo extends Wrapper {
   public NetworkPlayerInfo(Object var1) {
      super(var1);
   }

   public GameProfile c304() {
      return new GameProfile(MNetworkPlayerInfo.c4885(vape.getMappings().networkPlayerInfo, this.obj));
   }
}
