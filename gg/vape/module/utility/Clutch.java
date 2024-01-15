package gg.vape.module.utility;

import gg.vape.event.impl.EventPlayerTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.UtilityMod;
import gg.vape.module.none.ClientSettings;
import gg.vape.utils.TimerUtil;
import gg.vape.wrapper.impl.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Clutch extends UtilityMod {
   public Block c8705;
   public float c6572;
   public int c3506;
   public int c181;
   public int c7212;
   public final TimerUtil c522 = new TimerUtil();
   public int c7347 = 0;

   public Clutch() {
      super("Clutch");
   }

   public void onEnable() {
      try {
         List var1 = this.c5201();
         if (var1.isEmpty()) {
            this.c141();
            return;
         }

         Minecraft.thePlayer().c89().c33((Integer)var1.get(0));
         Block var2 = this.c8697();
         if (var2 == null) {
            this.c141();
            return;
         }

         this.c8705 = var2;
         this.c7347 = 1;
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   public void onDisable() {
      this.c8705 = null;
      this.c3506 = -1;
      this.c181 = -1;
      this.c7212 = -1;
      this.c7347 = 0;
      this.c6572 = 0.0F;
   }

   public void onTick(EventPlayerTick event) {
      if (this.c7347 == 1) {
         float var2 = ThreadLocalRandom.current().nextFloat() * 1.5F;
         if (ThreadLocalRandom.current().nextFloat() > 0.5F) {
            var2 = -var2;
         }

         float var3 = ThreadLocalRandom.current().nextFloat() * 1.5F;
         c7932(this.c6572 + var2, 80.0F + var3);
         this.c7347 = 2;
         this.c522.reset();
      } else if (this.c7347 == 2) {
         KeyBinding var4 = Minecraft.gameSettings().c3763();
         KeyBinding.setKeyBindState(var4.getKeyCode(), true);
         KeyBinding.onTick(var4.getKeyCode());
         if (this.c522.hasTimeElapsed(50L)) {
            KeyBinding.setKeyBindState(var4.getKeyCode(), false);
            this.c141();
         }
      }

   }

   public static void c7932(float var0, float var1) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      float var3 = var2.rotationPitch();
      float var4 = var2.rotationYaw();
      var2.c7293(var0);
      var2.c834(var1);
      if (var2.rotationPitch() < -90.0F) {
         var2.c834(-90.0F);
      }

      if (var2.rotationPitch() > 90.0F) {
         var2.c834(90.0F);
      }

      var2.c6100(var2.c301() + var2.rotationPitch() - var3);
      var2.c4743(var2.c3825() + var2.rotationYaw() - var4);
   }


   public Block c8697() {
      EntityPlayerSP var1 = Minecraft.thePlayer();
      World var2 = var1.getWorld();
      int var3 = (int)var1.posX();
      int var4 = (int)var1.posY();
      int var5 = (int)var1.posZ();
      if (!ClientSettings.not1710) {
         --var4;
         --var5;
      }

      this.c181 = var4;
      this.c3506 = var3 + 1;
      this.c7212 = var5;
      Block var6 = this.c3053(var2, this.c3506, this.c181, this.c7212);
      if (var6 != null) {
         this.c6572 = -90.0F;
         return var6;
      } else {
         this.c3506 = var3 - 1;
         this.c7212 = var5;
         var6 = this.c3053(var2, this.c3506, this.c181, this.c7212);
         if (var6 != null) {
            this.c6572 = 90.0F;
            return var6;
         } else {
            this.c3506 = var3;
            this.c7212 = var5 + 1;
            var6 = this.c3053(var2, this.c3506, this.c181, this.c7212);
            if (var6 != null) {
               this.c6572 = 0.0F;
               return var6;
            } else {
               this.c3506 = var3;
               this.c7212 = var5 - 1;
               var6 = this.c3053(var2, this.c3506, this.c181, this.c7212);
               if (var6 != null) {
                  this.c6572 = 180.0F;
                  return var6;
               } else {
                  return null;
               }
            }
         }
      }
   }

   public Block c3053(World var1, int var2, int var3, int var4) {
      Block var5 = var1.getBlockByPos(var2, var3, var4);
      return !var5.isNull() && !var5.c4045().isInstance(Blocks.c2456().c4045().getObject().getClass()) ? var5 : null;
   }

   public List c5201() {
      ArrayList var1 = new ArrayList();
      EntityPlayerSP var2 = Minecraft.thePlayer();

      for(int var3 = 0; var3 <= 8; ++var3) {
         ItemStack var4 = var2.c89().c5272(var3);
         if (!var4.isNull() && !var4.getItem().isNull() && var4.getItem().isInstance(MappedClasses.ItemBlock)) {
            String var5 = var4.getItem().getObject().toString();
            if (!var5.contains("Colored") && !var5.contains("Lily")) {
               var1.add(var3);
            }
         }
      }

      return var1;
   }
}
