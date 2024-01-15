package gg.vape.event.impl;

import gg.vape.wrapper.impl.EventType;

public class EventPreMove extends EventMove {
   public EventPreMove(double x, double y, double z) {
      super(EventType.PRE, x, y, z);
   }

   public double getX() {
      return super.getX();
   }

   public double getY() {
      return super.getY();
   }

   public double getZ() {
      return super.getZ();
   }
}
