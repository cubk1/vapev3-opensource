package gg.vape.module.render;

import gg.vape.event.impl.EventFogColors;
import gg.vape.event.impl.EventFogDensity;
import gg.vape.event.impl.EventPlayerTick;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.value.BooleanValue;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.Potion;
import gg.vape.wrapper.impl.PotionEffect;
import org.lwjgl.opengl.GL11;

public class AntiDebuff extends Mod {
   public final BooleanValue removeNausea = BooleanValue.create(this, "Remove Nausea", true);
   public final BooleanValue removeBlindness = BooleanValue.create(this, "Remove Blindness", true);
   public final BooleanValue removeSlowness = BooleanValue.create(this, "Remove Slowness", true);
   public final BooleanValue removeEffects = BooleanValue.create(this, "Remove Effects", false, "Removes non-visual effects from slowness\nCan be detected by anti-cheat");
   public float c5875;
   public float c3067;
   public float c5301;

   public AntiDebuff() {
      super("AntiDebuff", -256, Category.Render, "Removes negative visual potion effects");
      this.addValue(this.removeNausea, this.removeBlindness, this.removeSlowness, this.removeEffects);
   }

   public void onTick(EventPlayerTick event) {
      if (this.removeNausea.getValue()) {
         Minecraft.thePlayer().c4326(9);
      }

      if (this.removeBlindness.getValue() && this.removeEffects.getValue()) {
         Minecraft.thePlayer().c4326(15);
      }

      if (this.removeSlowness.getValue()) {
         EntityPlayerSP var2 = Minecraft.thePlayer();
         if (var2.isPotionActive(Potion.c8411())) {
            if (this.removeEffects.getValue()) {
               PotionEffect var3 = Minecraft.thePlayer().getActivePotionEffect(Potion.c8411());
               Potion[] var4 = Potion.c4310();
               var4[2].c1003(var2, var2.c8108(), var3.getAmplifier());
            }

            var2.c4326(2);
         }
      }

   }

   public void onFogDensity(EventFogDensity event) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      if (this.removeBlindness.getValue() && var2.isPotionActive(Potion.c5247()) && var2.getActivePotionEffect(Potion.c5247()).c7544() > 1) {
         event.c6796().setCancelled(true);
         event.c8552(0.1F);
      }

   }

   public void onFogColors(EventFogColors event) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      if (this.removeBlindness.getValue() && var2.isPotionActive(Potion.c5247()) && var2.getActivePotionEffect(Potion.c5247()).c7544() > 1) {
         GL11.glFogf(2915, 990.0F);
         GL11.glFogf(2916, 1000.0F);
         event.c7078().c335(true);
         if (event.c1081() == 0.0F) {
            event.c8552(this.c5875);
         }

         if (event.c8948() == 0.0F) {
            event.c217(this.c3067);
         }

         if (event.c8599() == 0.0F) {
            event.c7901(this.c5301);
         }
      } else {
         this.c5875 = event.c1081();
         this.c3067 = event.c8948();
         this.c5301 = event.c8599();
      }

   }
}
