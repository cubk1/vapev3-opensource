package gg.vape.module.other;

import gg.vape.event.impl.EventPlayerTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.utils.TimerUtil;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.GameSettings;
import gg.vape.wrapper.impl.KeyBinding;
import gg.vape.wrapper.impl.Minecraft;

import java.util.Random;

public class AntiAFK extends Mod {
   public final TimerUtil c5891 = new TimerUtil();
   public final TimerUtil c6297 = new TimerUtil();
   public final KeyBinding[] c5924;
   public KeyBinding c3915;
   public final Random c1438 = new Random();
   public final NumberValue c7118 = NumberValue.c8404(this, "Frequency", "##", "", 1.0, 30.0, 200.0, "How often you will move");

   public AntiAFK() {
      super("Anti-AFK", 9782004, Category.Other);
      GameSettings var1 = Minecraft.gameSettings();
      this.c5924 = new KeyBinding[]{var1.c4590(), var1.c1091(), var1.c2387(), var1.c4599()};
      this.addValue(this.c7118);
   }

   public void onTick(EventPlayerTick event) {
      if (!Minecraft.currentScreen().isInstance(MappedClasses.GuiInventory)) {
         if (this.c3915 == null) {
            if (Minecraft.thePlayer().moveForward() != 0.0F || Minecraft.thePlayer().moveStrafe() != 0.0F) {
               return;
            }

            if (this.c5891.hasTimeElapsed(this.c7118.getValue().longValue() * 1000L + (long)this.c1438.nextInt(4000))) {
               this.c3915 = this.c5924[this.c1438.nextInt(this.c5924.length)];
               KeyBinding.setKeyBindState(this.c3915.getKeyCode(), true);
               KeyBinding.onTick(this.c3915.getKeyCode());
               this.c6297.reset();
            }
         } else if (this.c6297.hasTimeElapsed(this.c1438.nextInt(50))) {
            KeyBinding.setKeyBindState(this.c3915.getKeyCode(), false);
            this.c3915 = null;
            this.c5891.reset();
         }

      }
   }
}
