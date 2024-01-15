package gg.vape.module.combat;

import gg.vape.Vape;
import gg.vape.event.impl.EventPlayerTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.none.ClientSettings;
import gg.vape.module.none.Macros;
import gg.vape.unmap.ItemLimitData;
import gg.vape.value.BooleanValue;
import gg.vape.value.LimitValue;
import gg.vape.value.RandomValue;
import gg.vape.wrapper.impl.*;
import lombok.SneakyThrows;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AutoClicker extends Mod {
   public final RandomValue c3240 = RandomValue.create(this, "CPS", "#.#", "", 1.0, 6.0, 13.0, 20.0);
   public int c2452;
   public final BooleanValue c751 = BooleanValue.create(this, "Inventory Fill", false, "AutoClicker functions while in inventory for refilling items");
   public final BooleanValue c8480 = BooleanValue.create(this, "Blockhit", false);
   public final BooleanValue c1666 = BooleanValue.create(this, "Right Click Mode", false);
   public final BooleanValue c113 = BooleanValue.create(this, "Break Blocks", false, "Allows you to break blocks");
   public final LimitValue c3785;
   public final RandomValue c3905;
   public final BooleanValue c3545;
   public final BooleanValue c4458;
   public final LimitValue c5475;
   public boolean c8310;
   public final c2499 c4820;
   public final c2499 c7926;
   public boolean c1170;
   public final Queue c6051;

   public AutoClicker() {
      super("AutoClicker", -62703, Category.Combat, "Hold attack button to automatically click");
      this.c3785 = LimitValue.create(this, "autoclicker-alloweditems", "Allowed Items", LimitValue.allowed, new ItemLimitData("swords"));
      this.c3905 = RandomValue.create(this, "Right CPS", "#.#", "", 1.0, 6.0, 13.0, 20.0);
      this.c3545 = BooleanValue.create(this, "Limit to items", false, "AutoClicker functions only while holding selected items");
      this.c4458 = BooleanValue.create(this, "Limit to items", false, "AutoClicker functions only while holding selected items");
      this.c5475 = LimitValue.create(this, "autoclicker-alloweditems-right", "Allowed Items", LimitValue.allowed, new ItemLimitData("blocks"));
      this.c4820 = new c2499(this, 0, true, true);
      this.c7926 = new c2499(this, 1, false, false);
      this.c1170 = false;
      this.c6051 = new ConcurrentLinkedQueue();
      this.c3545.limitValues(this.c5475);
      this.c4458.limitValues(this.c3785);
      this.c1666.limitValues(this.c3905, this.c3545);
      this.addValue(this.c751, this.c8480, this.c113, this.c3240, this.c1666, this.c3905, this.c3545, this.c5475, this.c4458, this.c3785);
   }

   public List c5201() {
      ArrayList var1 = new ArrayList();
      Object[] var2 = Minecraft.thePlayer().c89().c596();

      for(int var3 = 0; var3 < 9; ++var3) {
         ItemStack var4 = new ItemStack(var2[var3]);
         if (var4.isNull()) {
            var1.add(var3);
         }
      }

      return var1;
   }

   public boolean c4951() {
      if (this.c113.getValue() && Minecraft.c1367().isNotNull() && Minecraft.c1367().c213().equals(RayTraceResult_type.c3865())) {
         if (ClientSettings.isMouseDown()) {
            KeyBinding var1 = Minecraft.gameSettings().c210();
            KeyBinding.setKeyBindState(var1.getKeyCode(), true);
         }

         return true;
      } else {
         return false;
      }
   }

   public void onEnable() {
      if (!this.c8310) {
         this.c8310 = true;
         (new c4375(this)).start();
         (new c6548(this)).start();
      }

   }

   public boolean c2877() {
      if (Minecraft.currentScreen().isNotNull()) {
         return true;
      } else if (!this.c3617()) {
         return true;
      } else {
         ItemStack var1 = Minecraft.thePlayer().getHeldItemHand();
         return this.c3785.isValid(var1, true);
      }
   }

   public boolean c3617() {
      return this.c4458.getValue();
   }

   public boolean c5373() {
      return !Minecraft.thePlayer().isNull() && this.c2877();
   }

   public boolean c6450() {
      if (Minecraft.thePlayer().isNull()) {
         return false;
      } else if (!this.c3545.getValue()) {
         return true;
      } else {
         ItemStack var1 = Minecraft.thePlayer().getHeldItemHand();
         return this.c5475.isValid(var1, true);
      }
   }

   public void c2350(GuiContainer var1) {
      int var2 = org.lwjgl.input.Mouse.getEventX() * var1.c1744() / Minecraft.displayWidth();
      int var3 = var1.c3715() - org.lwjgl.input.Mouse.getEventY() * var1.c3715() / Minecraft.displayHeight() - 1;
      this.c6051.add(new c4988(var2, var3, null));
   }

   public void onTick(EventPlayerTick event) {
      GuiScreen var2 = Minecraft.currentScreen();
      if (var2.isInstance(MappedClasses.GuiContainer)) {
         if (!this.c6051.isEmpty()) {
            c4988 var3 = (c4988)this.c6051.poll();
            GuiContainer var4 = new GuiContainer(var2);
            this.c8851(var4, var3.c47(), var3.c1050());
         }

      }
   }

   public void c8851(GuiContainer var1, int var2, int var3) {
      Slot var4 = var1.c1577(var2, var3);
      long var5 = Minecraft.c657();
      var1.c175(false);
      var1.c335(false);
      byte var7 = 0;
      int var8 = var1.c341();
      int var9 = var1.c7219();
      boolean var10 = var2 < var8 || var3 < var9 || var2 >= var8 + var1.c5705() || var3 >= var9 + var1.c7217();
      int var11 = -1;
      if (!var4.isNull()) {
         var11 = var4.c3715();
      }

      if (var10) {
         var11 = -999;
      }

      if (var11 != -1) {
         if (Minecraft.thePlayer().c89().c7824().isNull()) {
            boolean var12 = var11 != -999 && Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
            byte var13 = 0;
            if (!var12) {
               if (var11 == -999) {
                  var13 = 4;
               }
            } else {
               var1.c7525(!var4.isNull() && var4.c5354() ? var4.c4981() : new ItemStack(null));
               var13 = 1;
            }

            if (!var4.isNull()) {
               if (this.c2452 != var4.c3715()) {
                  if (ForgeVersion.minorVersion() >= 17) {
                     ClickType var14 = var13 == 0 ? ClickType.c6725() : (var13 == 1 ? ClickType.c6048() : ClickType.c8000());
                     var1.c1619(var4, var11, var7, var14);
                  } else {
                     var1.c4051(var4, var11, var7, var13);
                  }
               }

               this.c2452 = var4.c3715();
            }

            var1.c335(true);
         } else {
            var1.c2112(true);
            var1.c2062(var7);
            var1.c2886().clear();
            var1.c5732(var7);
            if (this.c2452 != var4.c3715()) {
               if (var4.c4981().isNull()) {
                  try {
                     Thread.sleep(50L);
                  } catch (InterruptedException var15) {
                     var15.printStackTrace();
                  }

                  if (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54)) {
                     if (ForgeVersion.minorVersion() >= 17) {
                        var1.c1619(var4, var11, var7, ClickType.c6048());
                     } else {
                        var1.c4051(var4, var11, var7, 0);
                     }
                  }
               }

               this.c2452 = var4.c3715();
            }
         }
      }

      var1.c8768(var4);
      var1.c5892(var5);
      var1.c33(var7);
   }

   // $FF: synthetic method
   static boolean c6932(AutoClicker var0) {
      return var0.c3617();
   }

   // $FF: synthetic method
   static boolean c1124(AutoClicker var0) {
      return var0.c2877();
   }

   // $FF: synthetic method
   static boolean c5759(AutoClicker var0) {
      return var0.c4951();
   }

   // $FF: synthetic method
   static boolean c6584(AutoClicker var0) {
      return var0.c1170;
   }

   // $FF: synthetic method
   static boolean c3741(AutoClicker var0, boolean var1) {
      return var0.c1170 = var1;
   }

   // $FF: synthetic method
   static BooleanValue c493(AutoClicker var0) {
      return var0.c751;
   }

   // $FF: synthetic method
   static c2499 c3834(AutoClicker var0) {
      return var0.c4820;
   }

   // $FF: synthetic method
   static BooleanValue c2125(AutoClicker var0) {
      return var0.c1666;
   }

   // $FF: synthetic method
   static c2499 c4563(AutoClicker var0) {
      return var0.c7926;
   }

   // $FF: synthetic method
   static boolean c5750(AutoClicker var0) {
      return var0.c6450();
   }

   // $FF: synthetic method
   static List c7354(AutoClicker var0) {
      return var0.c5201();
   }

   // $FF: synthetic method
   static void c963(AutoClicker var0, GuiContainer var1) {
      var0.c2350(var1);
   }

   // $FF: synthetic method
   static BooleanValue c7930(AutoClicker var0) {
      return var0.c8480;
   }

   // $FF: synthetic method
   static RandomValue c665(AutoClicker var0) {
      return var0.c3240;
   }

   // $FF: synthetic method
   static RandomValue c2581(AutoClicker var0) {
      return var0.c3905;
   }
}

class c2499 {
   public final int c6669;
   public final boolean c2132;
   public final boolean c5836;
   public boolean c5358;
   public final Random c2697;
   public final Random c7020;
   public final Random c1510;
   public final Random c7297;
   public long c8267;
   public int c4265;
   public boolean c8133;
   public int c4058;
   public boolean c2090;
   public int c7291;
   public int c6047;
   public int c8453;
   public int c5329;
   public final Random c808;
   public Entity c3887;
   public int c4074;
   // $FF: synthetic field
   final AutoClicker c4218;

   public c2499(AutoClicker var1, int var2, boolean var3, boolean var4) {
      this.c4218 = var1;
      this.c2697 = new Random();
      this.c7020 = new Random();
      this.c1510 = new Random();
      this.c7297 = new Random();
      this.c2090 = true;
      this.c808 = new Random();
      this.c6669 = var2;
      this.c2132 = var3;
      this.c5836 = var4;
   }
   @SneakyThrows
   public void c180() {
      GuiScreen var1 = Minecraft.currentScreen();
      boolean var2 = this.c2132 && AutoClicker.c493(this.c4218).getValue() && var1.isInstance(MappedClasses.GuiContainer);
      if (Minecraft.currentScreen().getObject() != null && !var2) {
         this.c5358 = true;
      } else {
         KeyBinding var3 = Minecraft.gameSettings().c210();
         KeyBinding var4 = Minecraft.gameSettings().c3763();
         if (this.c6669 != 0 || this.c4218.c5373() || var2) {
            if (this.c6669 != 1 || AutoClicker.c5750(this.c4218)) {
               if (this.c6669 == 1) {
                  var3 = var4;
                  if (!ClientSettings.c2707()) {
                     this.c5358 = true;
                     Thread.sleep(50L);
                     return;
                  }
               } else if (!ClientSettings.isMouseDown()) {
                  if (!AutoClicker.c2125(this.c4218).getValue()) {
                     KeyBinding.setKeyBindState(var4.getKeyCode(), ClientSettings.c2707());
                  }

                  this.c5358 = true;
                  return;
               }

               long var5 = this.c406();
               if (var5 - 50L <= 0L) {
                  var5 = 51L;
               }

               var5 -= 30L;
               Thread.sleep(var5);
               if (this.c6669 == 1) {
                  if (!ClientSettings.c2707()) {
                     return;
                  }
               } else if (!ClientSettings.isMouseDown()) {
                  return;
               }

               if (this.c5358) {
                  this.c5358 = false;
                  Thread.sleep(50L);
               } else if (var2 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54) && AutoClicker.c7354(this.c4218).size() > 0)) {
                  AutoClicker.c963(this.c4218, new GuiContainer(var1.getObject()));
               } else {
                  if (var1.isNull()) {
                     MouseEvent var7 = MouseEvent.c3437();
                     var7.c33(this.c6669);
                     var7.c175(true);
                     Macros.c5401.add(var7);
                     Mouse.c8307().put(this.c6669, (byte)1);
                     KeyBinding.setKeyBindState(var3.getKeyCode(), true);
                     KeyBinding.onTick(var3.getKeyCode());
                     if (this.c5836 && AutoClicker.c7930(this.c4218).getValue() && ClientSettings.c2707()) {
                        KeyBinding.setKeyBindState(var4.getKeyCode(), true);
                        KeyBinding.onTick(var4.getKeyCode());
                     }

                     int var8 = this.c808.nextInt(20) + 8;
                     ++this.c4074;
                     if (this.c4074 >= this.c808.nextInt(8)) {
                        this.c4074 -= this.c808.nextInt(8) + 8;
                        var8 = 51;
                     }

                     Thread.sleep(var8);
                     if (this.c5836 && Minecraft.thePlayer().isBlocking() && AutoClicker.c7930(this.c4218).getValue()) {
                        KeyBinding.setKeyBindState(var4.getKeyCode(), false);
                     }

                     Mouse.c8307().put(this.c6669, (byte)0);
                     KeyBinding.setKeyBindState(var3.getKeyCode(), false);
                     var7 = MouseEvent.c3437();
                     var7.c33(this.c6669);
                     var7.c175(false);
                     Macros.c5401.add(var7);
                  }

               }
            }
         }
      }
   }

   long c406() {
      RandomValue random = AutoClicker.c665(this.c4218);
      if (this.c6669 == 1) {
         random = AutoClicker.c2581(this.c4218);
      }

      int var2 = random.getValue()[0].intValue();
      int var3 = random.getValue()[1].intValue();
      int var4 = var3 - var2;
      int var5 = var4 <= 0 ? var2 : this.c2697.nextInt(var4) + var2 + 1;
      if (var5 == 0) {
         var5 = 1;
      }

      if (!this.c8133) {
         this.c8267 = 1000 / var5;
         if (this.c7297.nextInt(4) == 1) {
            this.c8133 = true;
            this.c4058 = 1 + this.c7297.nextInt(5);
         } else if (this.c7297.nextInt(10) != 1 && this.c7297.nextInt(10) == 1) {
            this.c8133 = true;
            this.c4058 = 5 + this.c7297.nextInt(10);
         }
      }

      if (this.c8133) {
         ++this.c4265;
         if (this.c4265 >= this.c4058) {
            this.c4265 = 0;
            this.c8133 = false;
         }
      }

      boolean var6 = this.c3887 != null;
      if (this.c7020.nextInt(48) % (!var6 ? 4 : (this.c2090 ? 6 : 10)) == 0 && !this.c8133) {
         var2 = !var6 ? 50 : 25;
         var3 = !var6 ? 120 : 70;
         var4 = var3 - var2;
         this.c8267 += this.c1510.nextInt(var4) + var2;
      }

      if (this.c2090) {
         ++this.c6047;
         if (this.c6047 >= this.c8453) {
            this.c5329 = 75 + this.c2697.nextInt(125);
            this.c2090 = false;
            this.c6047 = 0;
         }

         int var7 = this.c7020.nextInt(5) == 3 ? 50 : 25;
         return this.c8267 + (long)var7;
      } else {
         ++this.c7291;
         if (this.c7291 >= this.c5329) {
            this.c2090 = true;
            this.c8453 = 7 + this.c2697.nextInt(8);
            this.c7291 = 0;
         }

         if (!Minecraft.c1367().isNull()) {
            this.c3887 = Minecraft.c1367().c4157();
         } else {
            this.c3887 = null;
         }

         return this.c8267;
      }
   }
}

class c4375 extends Thread {
   // $FF: synthetic field
   final AutoClicker c7057;

   c4375(AutoClicker var1) {
      this.c7057 = var1;
   }

   public void run() {
      while(!Vape.instance.isDestroyed()) {
         try {
            Thread.sleep(5L);
            if (this.c7057.getState()) {
               boolean var1 = AutoClicker.c6932(this.c7057) && !AutoClicker.c1124(this.c7057);
               if (!AutoClicker.c5759(this.c7057) && !var1) {
                  AutoClicker.c3741(this.c7057, false);
               } else {
                  KeyBinding var2 = Minecraft.gameSettings().c210();
                  if (var1 && ClientSettings.isMouseDown() && !var2.c5354() && !AutoClicker.c6584(this.c7057)) {
                     KeyBinding.setKeyBindState(var2.getKeyCode(), true);
                     KeyBinding.onTick(var2.getKeyCode());
                     AutoClicker.c3741(this.c7057, true);
                  }

                  boolean var3 = AutoClicker.c493(this.c7057).getValue() && Minecraft.currentScreen().isInstance(MappedClasses.GuiContainer);
                  if (!var3) {
                     continue;
                  }
               }

               AutoClicker.c3834(this.c7057).c180();
            }
         } catch (Exception var4) {
         }
      }

   }
}
class c4988 {
   int c2450;
   int c4826;

   public c4988(int var1, int var2) {
      this.c2450 = var1;
      this.c4826 = var2;
   }

   public int c47() {
      return this.c2450;
   }

   public int c1050() {
      return this.c4826;
   }

   // $FF: synthetic method
   c4988(int var1, int var2, c4375 var3) {
      this(var1, var2);
   }
}
class c6548 extends Thread {
   // $FF: synthetic field
   final AutoClicker c3553;

   c6548(AutoClicker var1) {
      this.c3553 = var1;
   }

   public void run() {
      while(!Vape.instance.isDestroyed()) {
         try {
            Thread.sleep(5L);
            if (this.c3553.getState() && AutoClicker.c2125(this.c3553).getValue()) {
               AutoClicker.c4563(this.c3553).c180();
            }
         } catch (Exception var2) {
         }
      }

   }
}
