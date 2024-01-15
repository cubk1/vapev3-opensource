package gg.vape.module.blatant;

import gg.vape.event.impl.EventPlayerTick;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.value.BooleanValue;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.Minecraft;

public class Timer extends Mod {
   public boolean tick;
   public final BooleanValue tickDisable = BooleanValue.create(this,"Tick Disable",true);
   public final NumberValue timerSpeed = NumberValue.create(this, "Speed", "#.##", "", 0.1, 1.07, 2.0, 0.01);

   public Timer() {
      super("Timer", 16715792, Category.Blatant, "Modifies game timer");
      this.addValue(this.timerSpeed,this.tickDisable);
   }

   public void onTick(EventPlayerTick event) {
      this.tick = !this.tick;
      Minecraft.getTimer().setTimerSpeed(tickDisable.getValue() ? this.tick ? 1.0F : this.timerSpeed.getValue().floatValue() : this.timerSpeed.getValue().floatValue());
   }

   public void onDisable() {
      Minecraft.getTimer().setTimerSpeed(1.0F);
   }
}
