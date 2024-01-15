package gg.vape.threads;

import func.skidline.KeyBindRunner;

import java.util.Collections;

public class BindThread extends Thread {
   // $FF: synthetic field
   final KeyBindRunner c6881;

   public BindThread(KeyBindRunner var1) {
      this.c6881 = var1;
   }

   public void run() {
      KeyBindRunner.c6626(this.c6881).c2585(Collections.emptyList());
      this.c6881.c7213("Unbound");
      KeyBindRunner.c4792(this.c6881).interrupt();

      try {
         Thread.sleep(1000L);
      } catch (InterruptedException var2) {
         return;
      }

      this.c6881.c8071();
   }

   // $FF: synthetic method
   public BindThread(KeyBindRunner var1, Object var2) {
      this(var1);
   }
}
