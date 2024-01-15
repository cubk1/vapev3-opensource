package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MEntityViewRenderEvent_FogDensity;

public class EntityViewRenderEvent extends BaseEntityViewRenderEvent {
   public EntityViewRenderEvent(Object var1) {
      super(var1);
   }

   public float c8901() {
      return MEntityViewRenderEvent_FogDensity.c1698(vape.getMappings().entityViewRenderEvent_fogDensity, this.obj);
   }

   public void c6025(float var1) {
      MEntityViewRenderEvent_FogDensity.c4128(vape.getMappings().entityViewRenderEvent_fogDensity, this.obj, var1);
   }
}
