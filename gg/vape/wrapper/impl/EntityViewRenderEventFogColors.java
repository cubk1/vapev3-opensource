package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MEntityViewRenderEvent_FogColors;

public class EntityViewRenderEventFogColors extends BaseEntityViewRenderEvent {
   public EntityViewRenderEventFogColors(Object var1) {
      super(var1);
   }

   public float c8901() {
      return MEntityViewRenderEvent_FogColors.c1587(vape.getMappings().entityViewRenderEvent_fogColors, this.obj);
   }

   public float c4311() {
      return MEntityViewRenderEvent_FogColors.c7775(vape.getMappings().entityViewRenderEvent_fogColors, this.obj);
   }

   public float c2646() {
      return MEntityViewRenderEvent_FogColors.c3091(vape.getMappings().entityViewRenderEvent_fogColors, this.obj);
   }

   public void c6025(float var1) {
      MEntityViewRenderEvent_FogColors.c4585(vape.getMappings().entityViewRenderEvent_fogColors, this.obj, var1);
   }

   public void c8528(float var1) {
      MEntityViewRenderEvent_FogColors.c2733(vape.getMappings().entityViewRenderEvent_fogColors, this.obj, var1);
   }

   public void c8393(float var1) {
      MEntityViewRenderEvent_FogColors.c3539(vape.getMappings().entityViewRenderEvent_fogColors, this.obj, var1);
   }
}
