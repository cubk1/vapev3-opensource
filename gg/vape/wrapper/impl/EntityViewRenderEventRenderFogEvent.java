package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MEntityViewRenderEvent_RenderFogEvent;

public class EntityViewRenderEventRenderFogEvent extends BaseEntityViewRenderEvent {
   public EntityViewRenderEventRenderFogEvent(Object var1) {
      super(var1);
   }

   public int c341() {
      return MEntityViewRenderEvent_RenderFogEvent.c8675(vape.getMappings().entityViewRenderEvent_renderFogEvent, this.obj);
   }

   public float c4311() {
      return MEntityViewRenderEvent_RenderFogEvent.c2789(vape.getMappings().entityViewRenderEvent_renderFogEvent, this.obj);
   }
}
