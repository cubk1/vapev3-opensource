package gg.vape.event.forge;

import gg.vape.event.hook.HookProcessor;
import gg.vape.event.hook.IHook;
import pub.nextsense.Tweaker;
import pub.nextsense.common.ForgeListener;

public abstract class ForgeEventHook implements IHook {
   public final Class c7203;
   public HookProcessor c6853;

   public ForgeEventHook(String var1, int var2) {
      this.c7203 = Tweaker.getClazz(var1);
      ForgeListener.reg(this.c7203, var2);
   }

   public ForgeEventHook(Class var1, int var2) {
      this.c7203 = var1;
      ForgeListener.reg(this.c7203, var2);
   }

   public abstract void call(Object var1);

   public Class getTarget() {
      return this.c7203;
   }

   public void setHookProcessor(HookProcessor var1) {
      this.c6853 = var1;
   }

   public HookProcessor c3453() {
      return this.c6853;
   }
}
