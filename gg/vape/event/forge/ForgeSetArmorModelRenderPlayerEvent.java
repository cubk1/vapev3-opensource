package gg.vape.event.forge;

import gg.vape.event.impl.EventSetArmorModel;
import gg.vape.wrapper.impl.RenderPlayerEvent_setArmorModel;

public class ForgeSetArmorModelRenderPlayerEvent extends ForgeEventHook {
   public ForgeSetArmorModelRenderPlayerEvent() {
      super("net/minecraftforge/client/event/RenderPlayerEvent$SetArmorModel", 0);
   }

   public void call(Object var1) {
      RenderPlayerEvent_setArmorModel var2 = new RenderPlayerEvent_setArmorModel(var1);
      (new EventSetArmorModel(var2, var2.c4451())).fire();
   }
}
