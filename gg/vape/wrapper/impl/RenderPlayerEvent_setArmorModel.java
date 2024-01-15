package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MRenderPlayerEvent_SetArmorModel;

public class RenderPlayerEvent_setArmorModel extends RenderPlayerEvent {
   public RenderPlayerEvent_setArmorModel(Object var1) {
      super(var1);
   }

   public void c33(int var1) {
      MRenderPlayerEvent_SetArmorModel.c8663(vape.getMappings().renderPlayerEvent_setArmorModel, this.obj, var1);
   }

   public int c7544() {
      return MRenderPlayerEvent_SetArmorModel.c8859(vape.getMappings().renderPlayerEvent_setArmorModel, this.obj);
   }
}
