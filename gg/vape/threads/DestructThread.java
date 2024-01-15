package gg.vape.threads;

import gg.vape.Vape;
import gg.vape.module.combat.WTap;

public class DestructThread extends Thread {
   // $FF: synthetic field
   final WTap c6829;

   public DestructThread(WTap var1) {
      this.c6829 = var1;
   }

   public void run() {
      while(!Vape.instance.isDestroyed()) {
         try {
            Thread.sleep(50L);
            if (this.c6829.getState()) {
               WTap.c7797(this.c6829);
            }
         } catch (Exception var2) {
         }
      }

   }
}
