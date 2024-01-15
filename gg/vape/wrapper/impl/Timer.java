package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MTimer;
import gg.vape.wrapper.Wrapper;

public class Timer extends Wrapper {
   public Timer(Object var1) {
      super(var1);
   }

   public void setTimerSpeed(float var1) {
      if (ForgeVersion.minorVersion() < 23) {
         MTimer.c3255(vape.getMappings().timer, this.obj, var1);
      }
   }

   public float renderPartialTicks() {
      return MTimer.c8872(vape.getMappings().timer, this.obj);
   }

   public float c6767() {
      return MTimer.c750(vape.getMappings().timer, this.obj);
   }
}
