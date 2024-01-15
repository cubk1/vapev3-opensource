package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MRenderPlayerEvent;

public class RenderPlayerEvent extends PlayerEvent {
   public RenderPlayerEvent(Object var1) {
      super(var1);
   }

   public RenderPlayer c7609() {
      return new RenderPlayer(MRenderPlayerEvent.c4984(vape.getMappings().renderPlayerEvent, this.obj));
   }

   public float c6767() {
      return MRenderPlayerEvent.c3497(vape.getMappings().renderPlayerEvent, this.obj);
   }
}
