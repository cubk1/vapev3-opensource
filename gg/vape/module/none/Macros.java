package gg.vape.module.none;

import gg.vape.Vape;
import gg.vape.event.impl.EventKeyPress;
import gg.vape.event.impl.EventPlayerTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Macro;
import gg.vape.module.Mod;
import gg.vape.module.macro.BaseMacroImpl;
import gg.vape.module.macro.RodMacro;
import gg.vape.threads.DisableMacrosThread;
import gg.vape.utils.RandomUtil;
import gg.vape.utils.TimerUtil;
import gg.vape.wrapper.impl.*;
import lombok.SneakyThrows;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Macros extends Mod {
   public static Queue c5401 = new ConcurrentLinkedQueue();
   public Macro c1907;
   public boolean c4550 = false;
   public final TimerUtil c4158 = new TimerUtil();
   public boolean c7998 = true;
   public boolean c7529 = false;
   public int c3614 = 0;
   public int c1818 = 0;

   public Macros() {
      super("Macros", 0, 0, Category.None, null);
      this.c141();
   }

   public void c141() {
      this.setState(true);
      if (!this.c7529) {
         this.c7529 = true;
         (new DisableMacrosThread(this)).start();
      }

   }

   public void c6085(EventKeyPress var1) {
      if (this.c1907 == null) {
         if (!var1.c4942()) {
            List var2 = Vape.instance.getMacrosManager().c7377(var1.c6502());
            if (!var2.isEmpty()) {
               Iterator var3 = var2.iterator();

               while(var3.hasNext()) {
                  Macro var4 = (Macro)var3.next();
                  if (this.c1907 == null) {
                     this.c1396(var4);
                  }
               }

            }
         }
      }
   }

   public void c1396(Macro var1) {
      if (var1 instanceof BaseMacroImpl) {
         Minecraft.thePlayer().c6694(var1.c3731());
      } else {
         this.c1907 = var1;
         if (this.c1509() == -1) {
            this.c1907 = null;
         } else {
            this.c1818 = Minecraft.thePlayer().c89().c1744();
            this.c3614 = RandomUtil.c8609(this.c1907.c2102());
            this.c7998 = true;
            this.c3934();
         }
      }
   }

   @SneakyThrows
   public void c8116() {
      if (this.c1907 != null) {
         if (!this.c4550) {
            this.c4550 = true;
            this.c2272();
            this.c4158.reset();
         }

         if (this.c7998) {
            if (this.c4158.hasTimeElapsed(this.c3614)) {
               if (this.c1907.c2906().getValue()) {
                  this.c3614 = RandomUtil.c8609(this.c1907.c6968());
                  this.c4158.reset();
                  this.c7998 = false;
               } else {
                  this.c3684();
               }
            }
         } else if (this.c1907 instanceof RodMacro && !this.c4158.hasTimeElapsed(this.c3614)) {
            EntityPlayerSP var1 = Minecraft.thePlayer();
            EntityFishHook var2 = var1.c1194();
            if (var1.isNotNull() && var2.isNotNull()) {
               Entity var3 = var1.c1194().c4157();
               if (var3.isNotNull() && var3.isInstance(MappedClasses.EntityOtherPlayerMP) || var2.c6738()) {
                  this.c2272();
                  Thread.sleep(RandomUtil.c5123(30, 60));
                  this.c3684();
               }
            }
         } else if (this.c4158.hasTimeElapsed(this.c3614)) {
            this.c2272();
            Thread.sleep(RandomUtil.c5123(30, 60));
            this.c3684();
         }

      }
   }

   public int c1509() {
      try {
         for(int var1 = 0; var1 < 9; ++var1) {
            ItemStack var2 = Minecraft.thePlayer().c89().c5272(var1);
            if (var2.getObject() != null && var2.getItem().getObject() != null) {
               if (String.valueOf(Item.c1501(var2.getItem())).equals(this.c1907.c3731())) {
                  return var1;
               }

               if (var2.c376().equalsIgnoreCase(this.c1907.c3731()) || var2.getItem().c2090(var2).equalsIgnoreCase(this.c1907.c3731())) {
                  return var1;
               }
            }
         }
      } catch (Exception var3) {
      }

      return -1;
   }

   public void c3934() {
      Minecraft.thePlayer().c89().c33(this.c1509());
   }

   @SneakyThrows
   public void c2272() {
      KeyBinding var1 = Minecraft.gameSettings().c3763();
      KeyBinding.setKeyBindState(var1.getKeyCode(), true);
      KeyBinding.setKeyBindState(var1.getKeyCode(), false);
      KeyBinding.onTick(var1.getKeyCode());
      Mouse.c8307().put(1, (byte)1);
      MouseEvent var2 = MouseEvent.c3437();
      var2.c33(1);
      var2.c175(true);
      c5401.add(var2);
      Thread.sleep(RandomUtil.c5123(10, 100));
      Mouse.c8307().put(1, (byte)0);
      var2 = MouseEvent.c3437();
      var2.c33(1);
      var2.c175(false);
      c5401.add(var2);
   }

   public void c3684() {
      this.c1907 = null;
      this.c7998 = true;
      this.c4550 = false;
      Minecraft.thePlayer().c89().c33(this.c1818);
   }

   public void onTick(EventPlayerTick event) {
      while(true) {
         try {
            if (c5401.peek() != null) {
               MinecraftForge.getEventBus().c5057((ForgeEvent)c5401.poll());
               continue;
            }
         } catch (Exception var3) {
         }

         return;
      }
   }
}
