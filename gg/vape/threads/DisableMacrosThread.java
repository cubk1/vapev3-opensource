package gg.vape.threads;

import gg.vape.Vape;
import gg.vape.module.none.Macros;

public class DisableMacrosThread extends Thread {
   // $FF: synthetic field
   final Macros c2917;

   public DisableMacrosThread(Macros var1) {
      this.c2917 = var1;
   }

   public void run() {
      while(!Vape.instance.isDestroyed()) {
         try {
            Thread.sleep(5L);
            if (this.c2917.getState()) {
               this.c2917.c8116();
            }
         } catch (Exception var2) {
         }
      }

   }
}
