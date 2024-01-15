package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MModelBase;
import gg.vape.wrapper.Wrapper;

public class ModelBase extends Wrapper {
   public ModelBase(Object var1) {
      super(var1);
   }

   public void c642(EntityLivingBase var1, float var2, float var3, float var4) {
      MModelBase.c3265(vape.getMappings().modelBase, this.obj, var1.getObject(), var2, var3, var4);
   }

   public void c5801(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
      MModelBase.c5461(vape.getMappings().modelBase, this.obj, var1, var2, var3, var4, var5, var6, var7.getObject());
   }

   public void c4422(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      MModelBase.c5067(vape.getMappings().modelBase, this.obj, var1.getObject(), var2, var3, var4, var5, var6, var7);
   }
}
