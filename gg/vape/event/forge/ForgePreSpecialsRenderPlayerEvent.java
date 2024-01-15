package gg.vape.event.forge;

import gg.vape.event.impl.EventPreRenderPlayerSpec;
import gg.vape.wrapper.impl.RenderPlayerEventSpecialsPre;

public class ForgePreSpecialsRenderPlayerEvent extends ForgeEventHook {
   public ForgePreSpecialsRenderPlayerEvent() {
      super("net/minecraftforge/client/event/RenderPlayerEvent$Specials$Pre", 0);
   }

   public void call(Object var1) {
      RenderPlayerEventSpecialsPre var2 = new RenderPlayerEventSpecialsPre(var1);
      (new EventPreRenderPlayerSpec(var2, var2.c8294(), var2.c6767())).fire();
   }
}
