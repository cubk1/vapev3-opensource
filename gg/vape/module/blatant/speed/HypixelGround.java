package gg.vape.module.blatant.speed;

import gg.vape.event.impl.EventMove;
import gg.vape.module.Mod;
import gg.vape.module.SubModule;
import gg.vape.utils.PlayerUtil;
import gg.vape.wrapper.impl.Minecraft;

public class HypixelGround extends SubModule {
   public HypixelGround(Mod speed, String name) {
      super(speed, name);
   }

   public void onMove(EventMove event) {
      if (event.isPre()) {
         if (Minecraft.thePlayer().isInWater()) return;
         if (Minecraft.thePlayer().onGround()) {
            PlayerUtil.strafe(PlayerUtil.getAllowedHorizontalDistance() - Math.random() / 1000f);
         }
      }
   }

}
