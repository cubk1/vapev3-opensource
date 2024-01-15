package gg.vape.event.impl;

import gg.vape.wrapper.impl.EventType;

public class EventPostMove extends EventMove {
   public EventPostMove(double x, double y, double z) {
      super(EventType.POST, x, y, z);
   }
}
