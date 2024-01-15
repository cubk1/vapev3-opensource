package gg.vape.event.impl;

import gg.vape.wrapper.impl.Entity;
import gg.vape.wrapper.impl.EventType;

public class EventPostMotion extends EventMotion {
   public EventPostMotion(Object var1) {
      super(new Entity(var1), EventType.POST);
      this.setY(this.entity.posY());
   }
}
