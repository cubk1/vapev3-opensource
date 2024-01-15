package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MRenderPlayer;

public class RenderPlayer extends RenderLivingBase {
   public RenderPlayer(Object var1) {
      super(var1);
   }

   public ModelPlayer c516() {
      return new ModelPlayer(MRenderPlayer.c4127(vape.getMappings().renderPlayer, this.obj));
   }

   public ModelBiped c1057() {
      return new ModelBiped(MRenderPlayer.c4127(vape.getMappings().renderPlayer, this.obj));
   }
}
