package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MRenderHandEvent;

public class RenderHandEvent extends ForgeEvent {
   public RenderHandEvent(Object var1) {
      super(var1);
   }

   public float c6299() {
      return MRenderHandEvent.c2254(vape.getMappings().renderHandEvent, this.obj);
   }
}
