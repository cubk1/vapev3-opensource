package gg.vape.utils;

public class TimerUtil {
   long lastMS;

   public long getLastMS() {
      return System.currentTimeMillis() - this.lastMS;
   }

   public boolean hasTimeElapsed(long var1) {
      return this.getLastMS() >= var1;
   }

   public void reset() {
      this.lastMS = System.currentTimeMillis();
   }
}
