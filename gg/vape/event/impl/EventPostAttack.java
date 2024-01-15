package gg.vape.event.impl;

import gg.vape.wrapper.impl.EventType;

public class EventPostAttack extends EventAttack {
   public EventPostAttack(Object o) {
      super(o, EventType.POST);
   }
}
