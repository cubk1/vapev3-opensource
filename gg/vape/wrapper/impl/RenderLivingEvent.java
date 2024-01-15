package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MRenderLivingEvent;

public class RenderLivingEvent extends ForgeEvent {
   public RenderLivingEvent(Object var1) {
      super(var1);
   }

   public Entity c4157() {
      return new Entity(MRenderLivingEvent.c2872(vape.getMappings().renderLivingEvent, this.obj));
   }

   public RenderLivingBase c1668() {
      return new RenderLivingBase(MRenderLivingEvent.c2377(vape.getMappings().renderLivingEvent, this.obj));
   }

   public double c7584() {
      return MRenderLivingEvent.c3403(vape.getMappings().renderLivingEvent, this.obj);
   }

   public double c63() {
      return MRenderLivingEvent.c2483(vape.getMappings().renderLivingEvent, this.obj);
   }

   public double c8246() {
      return MRenderLivingEvent.c5879(vape.getMappings().renderLivingEvent, this.obj);
   }
}
