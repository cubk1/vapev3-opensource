package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.event.Event;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.Minecraft;
import org.lwjgl.opengl.GL11;

import java.util.Iterator;

public class EventRender3D extends Event {
   public final float c986;

   public EventRender3D(float var1) {
      this.c986 = var1;
   }

   public boolean fire() {
      Iterator var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         Mod var2 = (Mod)var1.next();
         if (var2.getState()) {
            var2.onRender3D(this);
         }
      }

      boolean var4 = Minecraft.gameSettings().c100();
      Minecraft.gameSettings().c175(false);
      Minecraft.c2698().c3776(this.c986, 0);
      Iterator var5 = Vape.instance.getModManager().collectMods().iterator();

      while(var5.hasNext()) {
         Mod var3 = (Mod)var5.next();
         if (var3.getState()) {
            var3.onRender(this);
         }
      }

      Minecraft.gameSettings().c175(var4);
      if (Minecraft.gameSettings().c8517() > 0) {
         Minecraft.c2698().c6766(1.0);
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      return this.c5586();
   }

   public float getPartialTicks() {
      return this.c986;
   }
}
