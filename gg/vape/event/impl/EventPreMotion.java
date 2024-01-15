package gg.vape.event.impl;

import gg.vape.wrapper.impl.Entity;
import gg.vape.wrapper.impl.EventType;

public class EventPreMotion extends EventMotion {
   public EventPreMotion(Object var1) {
      super(new Entity(var1), EventType.PRE);
      this.setY(this.entity.boundingBox().minY());
   }

   public double getY() {
      return super.getY();
   }

   public float getYaw() {
      return super.getYaw();
   }

   public float getPitch() {
      return super.getPitch();
   }

   public boolean isOnGround() {
      return super.isOnGround();
   }
}
