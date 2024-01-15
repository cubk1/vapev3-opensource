package gg.vape.utils.processors;

import gg.vape.Vape;
import gg.vape.module.Mod;

public class DisableModProcessor implements Runnable {
   public final Mod c8552;
   public final long c3686;
   public final boolean c5241;
   public boolean c1174 = true;

   public DisableModProcessor(Mod var1, long var2, boolean var4) {
      this.c8552 = var1;
      this.c3686 = var2;
      this.c5241 = var4;
   }

   public void run() {
      do {
         try {
            Thread.sleep(this.c3686);
            if (this.c8552.getState()) {
               this.c8552.c756();
            }
         } catch (Exception var2) {
         }
      } while(!Vape.instance.isDestroyed() && this.c5241 && this.c1174);

   }

   public boolean c373() {
      return this.c1174;
   }

   public void c4818(boolean var1) {
      this.c1174 = var1;
   }
}
