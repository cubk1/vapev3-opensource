package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MEntityViewRenderEvent;

public class BaseEntityViewRenderEvent extends ForgeEvent {
   public BaseEntityViewRenderEvent(Object var1) {
      super(var1);
   }

   public EntityRenderer c8487() {
      return new EntityRenderer(MEntityViewRenderEvent.c4737(vape.getMappings().entityViewRenderEvent, this.obj));
   }

   public Entity c861() {
      return new Entity(MEntityViewRenderEvent.c1002(vape.getMappings().entityViewRenderEvent, this.obj));
   }

   public Block c8223() {
      return ForgeVersion.minorVersion() >= 23 ? (new BlockState(MEntityViewRenderEvent.c7705(vape.getMappings().entityViewRenderEvent, this.obj))).c4613() : new Block(MEntityViewRenderEvent.c7705(vape.getMappings().entityViewRenderEvent, this.obj));
   }

   public double c63() {
      return MEntityViewRenderEvent.c7747(vape.getMappings().entityViewRenderEvent, this.obj);
   }
}
