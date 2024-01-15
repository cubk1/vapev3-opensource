package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MRenderWorldLastEvent;

public class RenderWorldLastEvent extends ForgeEvent {
   public RenderWorldLastEvent(Object var1) {
      super(var1);
   }

   public float c6299() {
      return MRenderWorldLastEvent.c2584(vape.getMappings().renderWorldLastEvent, this.obj);
   }
}
