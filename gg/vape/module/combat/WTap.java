package gg.vape.module.combat;

import gg.vape.Vape;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.threads.DestructThread;
import gg.vape.utils.MathUtil;
import gg.vape.utils.RotationUtil;
import gg.vape.value.NumberValue;
import gg.vape.value.RandomValue;
import gg.vape.wrapper.impl.EntityLivingBase;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.KeyBinding;
import gg.vape.wrapper.impl.Minecraft;
import org.lwjgl.input.Keyboard;

import java.util.Random;

public class WTap extends Mod {
   public boolean c1411;
   public final NumberValue c6698 = NumberValue.create(this, "Range", "#.#", "", 0.0, 3.5, 6.0);
   public final RandomValue c8644 = RandomValue.create(this, "Delay", "#.#", "", 0.0, 90.0, 120.0, 1000.0);
   public final Random c4327 = new Random();

   public WTap() {
      super("WTap", -5632000, Category.Combat);
      this.addValue(this.c6698, this.c8644);
   }

   public void c8116() {
      if (!Minecraft.theWorld().isNull()) {
         int var1 = Minecraft.gameSettings().c4590().getKeyCode();
         boolean var2 = Keyboard.isKeyDown(var1);
         EntityLivingBase var3 = RotationUtil.c7493(this.c6698.getValue(), 0.0F);
         EntityPlayerSP var4 = Minecraft.thePlayer();
         if (Minecraft.currentScreen().isNull()) {
            if (var4.c5048()) {
               if (var3 != null && !var3.isNull()) {
                  if (var3.isInstance(MappedClasses.EntityOtherPlayerMP)) {
                     if (Vape.instance.getSettings().isTarget(var3, false)) {
                        if (RotationUtil.c7639(var4, var3, 120.0)) {
                           if (var2) {
                              if ((double)var4.getDistanceToEntity(var3) < this.c6698.getValue()) {
                                 boolean var5 = var4.movementInput().moveForward() > 0.0F;

                                 try {
                                    if (var5) {
                                       KeyBinding.setKeyBindState(var1, false);
                                       KeyBinding.onTick(var1);
                                       Thread.sleep(MathUtil.c1673(this.c4327, 51, 75));
                                       KeyBinding.setKeyBindState(var1, true);
                                       KeyBinding.onTick(var1);
                                       Thread.sleep(MathUtil.c1673(this.c4327, 51, 75));
                                       KeyBinding.setKeyBindState(var1, false);
                                       KeyBinding.onTick(var1);
                                       Thread.sleep(MathUtil.c1673(this.c4327, 51, 75));
                                       KeyBinding.setKeyBindState(var1, Keyboard.isKeyDown(Minecraft.gameSettings().c4590().getKeyCode()));
                                       KeyBinding.onTick(var1);
                                       Thread.sleep((long)this.c8644.c7470());
                                    }
                                 } catch (InterruptedException var7) {
                                    var7.printStackTrace();
                                 }
                              }

                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   public void onEnable() {
      if (!this.c1411) {
         this.c1411 = true;
         (new DestructThread(this)).start();
      }

   }

   // $FF: synthetic method
   public static void c7797(WTap var0) {
      var0.c8116();
   }
}
