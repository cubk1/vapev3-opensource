package gg.vape.wrapper.impl;

import java.util.List;

public class RenderLivingBase extends Render {
   public RenderLivingBase(Object var1) {
      super(var1);
   }

   public ModelBase c2490() {
      return new ModelBase(vape.getMappings().renderLivingBase.c8903(this.obj));
   }

   public List c1445() {
      return (List) vape.getMappings().renderLivingBase.c6780(this.obj);
   }

   public void c1460(List var1) {
      vape.getMappings().renderLivingBase.c6771(this.obj, var1);
   }

   public void c911() {
      vape.getMappings().renderLivingBase.c7511(this.obj);
   }

   public boolean c4789(EntityLivingBase var1, float var2, boolean var3) {
      return vape.getMappings().renderLivingBase.c3500.c5509(this.obj, var1.getObject(), var2, var3);
   }
}
