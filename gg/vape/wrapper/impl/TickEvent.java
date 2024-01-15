package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MTickEvent;

public class TickEvent extends ForgeEvent {
   public TickEvent(Object var1) {
      super(var1);
   }

   public TickEventPhase c3827() {
      return new TickEventPhase(MTickEvent.c6828(vape.getMappings().tickEvent, this.obj));
   }
}
