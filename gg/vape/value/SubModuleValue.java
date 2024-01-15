package gg.vape.value;

import gg.vape.module.SubModule;
import gg.vape.unmap.ModeSelection;

public class SubModuleValue extends ModeSelection {
   public final SubModule instance;

   public SubModuleValue(String var1, SubModule var2) {
      super(var1);
      this.instance = var2;
   }

   public SubModule getInstance() {
      return this.instance;
   }
}
