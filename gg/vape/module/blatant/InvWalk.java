package gg.vape.module.blatant;

import gg.vape.event.impl.EventLivingUpdate;
import gg.vape.event.impl.EventMotion;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.value.BooleanValue;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.GameSettings;
import gg.vape.wrapper.impl.KeyBinding;
import gg.vape.wrapper.impl.Minecraft;
import org.lwjgl.input.Keyboard;

import java.awt.*;

public class InvWalk extends Mod {
   public final BooleanValue sneak = BooleanValue.create(this, "Sneak", true, "Takes sneaking input");

   public InvWalk() {
      super("InvWalk", (new Color(193, 113, 0)).getRGB(), Category.Blatant, "Walk and look around in UI's\nUse arrow keys to look around\nDoes not bypass some anti-cheats!");
      this.addValue(this.sneak);
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onMotionUpdate(EventMotion event) {
      if (event.isPre()) {
         EntityPlayerSP var2 = Minecraft.thePlayer();
         if (Minecraft.currentScreen().isNotNull() && !Minecraft.currentScreen().isInstance(MappedClasses.GuiChat)) {
            if (Keyboard.isKeyDown(200) && var2.rotationPitch() - 3.0F > -90.0F) {
               var2.c834(var2.rotationPitch() - 3.0F);
            }

            if (Keyboard.isKeyDown(208) && var2.rotationPitch() + 3.0F < 90.0F) {
               var2.c834(var2.rotationPitch() + 3.0F);
            }

            if (Keyboard.isKeyDown(203)) {
               var2.c7293(var2.rotationYaw() - 5.0F);
            }

            if (Keyboard.isKeyDown(205)) {
               var2.c7293(var2.rotationYaw() + 5.0F);
            }
         }
      }

   }

   public void c3785(KeyBinding var1) {
      if (Keyboard.isKeyDown(var1.getKeyCode())) {
         KeyBinding.setKeyBindState(var1.getKeyCode(), true);
         KeyBinding.onTick(var1.getKeyCode());
      } else if (var1.c5354()) {
         KeyBinding.setKeyBindState(var1.getKeyCode(), false);
         KeyBinding.onTick(var1.getKeyCode());
      }

   }

   public void onUpdate(EventLivingUpdate event) {
      if (event.getEntity().isInstance(MappedClasses.EntityPlayerSP) && Minecraft.currentScreen().isNotNull() && !Minecraft.currentScreen().isInstance(MappedClasses.GuiChat)) {
         GameSettings var2 = Minecraft.gameSettings();
         this.c3785(var2.c4590());
         this.c3785(var2.c1091());
         this.c3785(var2.c2387());
         this.c3785(var2.c4599());
         this.c3785(var2.c6247());
         if (this.sneak.getValue()) {
            this.c3785(var2.c4298());
         }
      }

   }
}
