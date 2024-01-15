package gg.vape.module.render;

import gg.vape.event.impl.EventPlayerTick;
import gg.vape.event.impl.EventRenderBlockOverlay;
import gg.vape.event.impl.EventRenderTick;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.none.ClientSettings;
import gg.vape.utils.TimerUtil;
import gg.vape.value.BooleanValue;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.*;
import org.lwjgl.input.Keyboard;
import pub.nextsense.Tweaker;

public class Freecam extends Mod {
   public boolean c3752;
   public int c895;
   public final TimerUtil c8585 = new TimerUtil();
   public EntityOtherPlayerMP c7032;
   public double c2618;
   public double c3310;
   public double c5516;
   public double c1860;
   public double c204;
   public double c7272;
   public float c4949;
   public float c4530;
   public double c6665;
   public double c1088;
   public double c4210;
   public double c5384;
   public double c6836;
   public RenderHandler c6675;
   public RenderHandler c5151;
   public double c765;
   public final NumberValue c5125 = NumberValue.create(this, "Speed", "#.#", "", 1.0, 3.0, 5.0, 0.1);
   public final BooleanValue c5773 = BooleanValue.create(this, "Spawn Fake", true, "Spawns an entity on where your player is server-sided.");

   public Freecam() {
      super("Freecam", 3248986, Category.World, "Lets you fly and clip through walls freely\nwithout moving your player server-sided.");
      this.addValue(this.c5125, this.c5773);
   }

   public void onRenderTick(EventRenderTick event) {
      if (Minecraft.theWorld().getObject() != null) {
         if (this.c5773.getValue() && Minecraft.theWorld().c7325(-420) == null) {
            Minecraft.theWorld().c1082(-420, this.c7032);
            this.c7032.c3662(this.c4949);
         }

         this.c2272();
         if (this.c8585.hasTimeElapsed(10L)) {
            this.c6857();
            this.c8585.reset();
         }

         this.c3934();
         Minecraft.c4087(null);
         if (this.c6675 == null) {
            this.c6675 = new RenderHandler(Tweaker.getRenderHandler());
         }

         Minecraft.theWorld().getWorldProvider().c7430(this.c6675);
      }
   }

   public void onPostRenderTick(EventRenderTick event) {
      if (Minecraft.theWorld().getObject() != null) {
         this.c3684();
         Minecraft.thePlayer().c4006(Minecraft.thePlayer().rotationPitch());
         Minecraft.thePlayer().c5528(Minecraft.thePlayer().rotationYaw());
         if (this.c7032 != null) {
            EntityPlayerSP var2 = Minecraft.thePlayer();
            this.c7032.c7698(var2.posX(), ClientSettings.not1710 ? var2.posY() : var2.posY() - 1.5, var2.posZ(), this.c4949, this.c4530);
         }

         Minecraft.theWorld().getWorldProvider().c7430(new RenderHandler(null));
      }
   }

   public void onEnable() {
      this.c6601();
      this.c3752 = true;
      this.c895 = Minecraft.gameSettings().c8694();
      Minecraft.gameSettings().c33(0);
      if (this.c5773.getValue()) {
         EntityPlayerSP var1 = Minecraft.thePlayer();
         this.c7032 = EntityOtherPlayerMP.c5474(Minecraft.theWorld(), Minecraft.thePlayer().c5323());
         this.c7032.c7981(var1, true);
         this.c8116();
         this.c7032.c3662(this.c4949);
         Minecraft.theWorld().c1082(-420, this.c7032);
         var1.motionX(0.0);
         var1.motionY(0.0);
         var1.motionZ(0.0);
      }

      Minecraft.c7806().c6395();
   }

   public void c8116() {
      EntityPlayerSP var1 = Minecraft.thePlayer();
      this.c7032.c7698(var1.posX(), ClientSettings.not1710 ? var1.posY() : var1.posY() - 1.5, var1.posZ(), var1.rotationYaw(), var1.rotationPitch());
   }

   public void onDisable() {
      Minecraft.thePlayer().c7293(this.c4949);
      Minecraft.thePlayer().c834(this.c4530);
      Minecraft.gameSettings().c33(this.c895);
      if (this.c7032 != null) {
         Minecraft.theWorld().c7364(this.c7032);
      }

   }

   public void c6601() {
      this.c6665 = Minecraft.thePlayer().posX();
      this.c1088 = Minecraft.thePlayer().posY();
      this.c4210 = Minecraft.thePlayer().posZ();
      this.c5384 = Minecraft.thePlayer().c5823();
      this.c6836 = Minecraft.thePlayer().c8561();
      this.c765 = Minecraft.thePlayer().c7002();
      this.c4949 = Minecraft.thePlayer().rotationYaw();
      this.c4530 = Minecraft.thePlayer().rotationPitch();
      this.c3752 = false;
   }

   public void onTick(EventPlayerTick event) {
      if (this.c3752) {
         this.c6601();
      }

      if (!Minecraft.currentScreen().isNotNull()) {
         int var2 = Minecraft.gameSettings().c4590().getKeyCode();
         int var3 = Minecraft.gameSettings().c1091().getKeyCode();
         int var4 = Minecraft.gameSettings().c2387().getKeyCode();
         int var5 = Minecraft.gameSettings().c4599().getKeyCode();
         int var6 = Minecraft.gameSettings().c6247().getKeyCode();
         int var7 = Minecraft.gameSettings().c4298().getKeyCode();
         KeyBinding.setKeyBindState(var2, false);
         KeyBinding.setKeyBindState(var3, false);
         KeyBinding.setKeyBindState(var4, false);
         KeyBinding.setKeyBindState(var5, false);
         KeyBinding.setKeyBindState(var6, false);
         KeyBinding.setKeyBindState(var7, false);
      }
   }

   public void onPlayerTick(EventPlayerTick event) {
      if (this.c3752) {
         this.c6601();
      }

   }

   public void c3934() {
      Minecraft.thePlayer().c7148(this.c6665);
      Minecraft.thePlayer().c4745(this.c5384);
      Minecraft.thePlayer().c4805(this.c1088);
      Minecraft.thePlayer().c2563(this.c6836);
      Minecraft.thePlayer().c8899(this.c4210);
      Minecraft.thePlayer().c8766(this.c765);
   }

   public void c2272() {
      this.c2618 = Minecraft.thePlayer().posX();
      this.c3310 = Minecraft.thePlayer().c5823();
      this.c5516 = Minecraft.thePlayer().posY();
      this.c1860 = Minecraft.thePlayer().c8561();
      this.c204 = Minecraft.thePlayer().posZ();
      this.c7272 = Minecraft.thePlayer().c7002();
   }

   public void c3684() {
      Minecraft.thePlayer().c7148(this.c2618);
      Minecraft.thePlayer().c4745(this.c3310);
      Minecraft.thePlayer().c4805(this.c5516);
      Minecraft.thePlayer().c2563(this.c1860);
      Minecraft.thePlayer().c8899(this.c204);
      Minecraft.thePlayer().c8766(this.c7272);
   }

   public void c6857() {
      if (!Minecraft.currentScreen().isNotNull()) {
         int var1 = Minecraft.gameSettings().c4590().getKeyCode();
         int var2 = Minecraft.gameSettings().c1091().getKeyCode();
         int var3 = Minecraft.gameSettings().c2387().getKeyCode();
         int var4 = Minecraft.gameSettings().c4599().getKeyCode();
         double var5 = this.c5125.getValue() / 5.0;
         if (ClientSettings.c7649(Minecraft.gameSettings().c6247()) && Minecraft.c8917()) {
            this.c1088 += var5;
            this.c6836 += var5;
         } else if (ClientSettings.c7649(Minecraft.gameSettings().c4298()) && Minecraft.c8917()) {
            this.c1088 -= var5;
            this.c6836 -= var5;
         }

         double var7 = Minecraft.thePlayer().rotationYaw() + 90.0F;
         boolean var9 = Keyboard.isKeyDown(var1) && Minecraft.c8917();
         boolean var10 = Keyboard.isKeyDown(var2) && Minecraft.c8917();
         boolean var11 = Keyboard.isKeyDown(var3) && Minecraft.c8917();
         boolean var12 = Keyboard.isKeyDown(var4) && Minecraft.c8917();
         if (var9) {
            if (var11) {
               var7 -= 45.0;
            } else if (var12) {
               var7 += 45.0;
            }
         } else if (var10) {
            var7 += 180.0;
            if (var11) {
               var7 += 45.0;
            } else if (var12) {
               var7 -= 45.0;
            }
         } else if (var11) {
            var7 -= 90.0;
         } else if (var12) {
            var7 += 90.0;
         }

         if (var9 || var11 || var10 || var12) {
            this.c6665 += Math.cos(Math.toRadians(var7)) * var5;
            this.c4210 += Math.sin(Math.toRadians(var7)) * var5;
            this.c5384 += Math.cos(Math.toRadians(var7)) * var5;
            this.c765 += Math.sin(Math.toRadians(var7)) * var5;
         }

      }
   }

   public void onRenderBlockOverlay(EventRenderBlockOverlay event) {
      if (event.overlayType().toString().equalsIgnoreCase("BLOCK")) {
         event.getNativeEvent().setCancelled(true);
      }

   }
}
