package gg.vape.threads;

import gg.vape.module.blatant.Step;
import gg.vape.wrapper.impl.Minecraft;

public class ResetTimerThread extends Thread {
   // $FF: synthetic field
   final Step step;

   public ResetTimerThread(Step step) {
      this.step = step;
   }

   public void run() {
      try {
         Thread.sleep(100L);
      } catch (InterruptedException var2) {
      }

      Minecraft.getTimer().setTimerSpeed(1.0F);
   }
}
