package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MTickEvent_RenderTickEvent;

public class RenderTickEvent extends TickEvent {
   public RenderTickEvent(Object var1) {
      super(var1);
   }

   public float c6299() {
      return MTickEvent_RenderTickEvent.c7730(vape.getMappings().tickEvent_renderTickEvent, this.obj);
   }
}
