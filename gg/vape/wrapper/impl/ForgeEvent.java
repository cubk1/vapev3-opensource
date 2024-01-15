package gg.vape.wrapper.impl;

import gg.vape.Vape;
import gg.vape.wrapper.Wrapper;

public class ForgeEvent extends Wrapper {
   public ForgeEvent(Object var1) {
      super(var1);
   }

   public boolean isCancelable() {
      return Vape.instance.getMappings().event.isCancelable(this.getObject());
   }

   public void setCancelled(boolean var1) {
      vape.getMappings().event.setCanceled(this.obj, var1);
   }
}
