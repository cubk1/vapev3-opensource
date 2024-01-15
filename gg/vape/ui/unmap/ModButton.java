package gg.vape.ui.unmap;

import func.skidline.KeyBindRunner;
import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.frame.ButtonGroup;
import gg.vape.ui.click.component.gui.CheckBox;
import gg.vape.unmap.Bendable;
import org.lwjgl.input.Keyboard;
import pub.nextsense.Tweaker;

import java.awt.*;

public class ModButton extends ButtonGroup {
   public final Mod mod;
   public final KeyBindRunner c5958;
   public boolean c6696;
   class c7812 extends KeyBindRunner {
      // $FF: synthetic field
      final Mod c2471;
      // $FF: synthetic field
      final ModButton c516;

      c7812(ModButton var1, Bendable var2, IGuiComponent var3, Mod var4) {
         super(var2, var3);
         this.c516 = var1;
         this.c2471 = var4;
      }

      public void c8071() {
         this.c516.Frame().getGuiButton().setName(this.c2471.getName());
      }
   }
   class c2886 implements IButtonOnClick {
      // $FF: synthetic field
      final Mod c639;
      // $FF: synthetic field
      final IButtonOnClick c4070;
      // $FF: synthetic field
      final ModButton c6064;

      c2886(ModButton var1, Mod var2, IButtonOnClick var3) {
         this.c6064 = var1;
         this.c639 = var2;
         this.c4070 = var3;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (this.c639.c199() && mouseBn == 0) {
            if (this.c639.c8399().isEmpty()) {
               ModButton.c4035(this.c6064, "Must be bound", 1500L);
            } else {
               ModButton.c4035(this.c6064, "Must use bind", 1500L);
            }
         }

         if (Keyboard.isKeyDown(42)) {
            ModButton.c8751(this.c6064).run();
         } else if (this.c6064.c5615().c2346()) {
            this.c4070.onClick(mouseX, mouseY, mouseBn);
         }

      }
   }

   class c1055 implements IGuiCallback {
      // $FF: synthetic field
      final Mod c0;
      // $FF: synthetic field
      final ClickGui c3255;
      // $FF: synthetic field
      final ModButton c7019;

      c1055(ModButton var1, Mod var2, ClickGui var3) {
         this.c7019 = var1;
         this.c0 = var2;
         this.c3255 = var3;
      }

      public void call(IGuiComponent inst) {
         if (!ModButton.c8751(this.c7019).c3709()) {
            if (Keyboard.isKeyDown(15)) {
               if (!ModButton.c8179(this.c7019)) {
                  if (this.c0.c3344()) {
                     this.c7019.Frame().getGuiButton().setName(this.c0.c407());
                     this.c7019.Frame().getGuiButton().c2404(RenderFlag.Regular);
                  }

                  ModButton.c3542(this.c7019, true);
               }
            } else {
               if (ModButton.c7499(this.c7019)) {
                  if (this.c3255.getEditState()) {
                     this.c7019.Frame().getGuiButton().c2404(RenderFlag.Regular);
                  } else {
                     this.c7019.Frame().getGuiButton().c2404(RenderFlag.Centered);
                  }
               }

               if (ModButton.c8179(this.c7019)) {
                  this.c7019.Frame().getGuiButton().setName(this.c0.getName());
                  ModButton.c3542(this.c7019, false);
                  this.c7019.Frame().getGuiButton().c2404(RenderFlag.Centered);
               }
            }
         }

         if (this.c0.getState()) {
            this.c7019.Frame().getGuiButton().setColor(this.c7019.getColor());
         } else if ((!this.c0.isBlatantMod() || Tweaker.isBlatantMode()) && (!this.c0.c199() || !this.c0.c8399().isEmpty())) {
            this.c7019.Frame().getGuiButton().setColor(Color.WHITE);
         } else {
            this.c7019.Frame().getGuiButton().setColor(Color.GRAY);
         }

         if (ModButton.c7130(this.c7019)) {
            if (!this.c3255.getEditState()) {
               this.c7019.setDisplayable(ModButton.c6360(this.c7019).c2346());
            } else {
               this.c7019.setDisplayable(true);
            }
         }

      }
   }
   public ModButton(Mod var1) {
      super(var1.getName(), null);
      this.mod = var1;
      this.setText(this.mod.c2139());
      this.c5958 = new c7812(this, var1, this.Frame(), var1);
      IButtonOnClick var2 = this.Frame().getClickEvent();
      this.Frame().addAction(new c2886(this, var1, var2));
      ClickGui var3 = Vape.instance.getModManager().getMod(ClickGui.class);
      this.addAction(new c1055(this, var1, var3));

      for (Object value : this.mod.c5526()) {
         IGuiComponent var5 = (IGuiComponent) value;
         this.addSubComponent(var5);
      }

      this.onOffset(17.0);
      this.c5615().addAction(new c7015(this, var1));
      this.c2367(true);
   }
   class c7015 implements IGuiCallback {
      // $FF: synthetic field
      final Mod c2859;
      // $FF: synthetic field
      final ModButton c5768;

      c7015(ModButton var1, Mod var2) {
         this.c5768 = var1;
         this.c2859 = var2;
      }

      public void call(IGuiComponent inst) {
         if (!this.c5768.c5615().c2346() && this.c2859.getState()) {
            this.c2859.setState(false);
         }

         this.c5768.c5615().setColor(Vape.instance.getSettings().guiColor.getAsColor());
      }
   }

   public void c8104(String var1, long var2) {
      (new c3167(this, var1, var2)).start();
   }
   class c3167 extends Thread {
      // $FF: synthetic field
      final String c3293;
      // $FF: synthetic field
      final long c8365;
      // $FF: synthetic field
      final ModButton c2348;

      c3167(ModButton var1, String var2, long var3) {
         this.c2348 = var1;
         this.c3293 = var2;
         this.c8365 = var3;
      }

      public void run() {
         this.c2348.Frame().getGuiButton().setName(this.c3293);

         try {
            Thread.sleep(this.c8365);
         } catch (InterruptedException var2) {
            var2.printStackTrace();
         }

         this.c2348.Frame().getGuiButton().setName(ModButton.c7873(this.c2348).getName());
      }
   }

   public void render(boolean var1) {
      super.render(var1);
   }

   public void toggle() {
      if (!this.mod.c199()) {
         this.mod.c141();
      }
   }

   public boolean c2346() {
      return this.mod != null && this.mod.getState();
   }

   public void c8121(boolean var1) {
      this.mod.setState(var1);
   }

   public Mod c6646() {
      return this.mod;
   }

   // $FF: synthetic method
   static void c4035(ModButton var0, String var1, long var2) {
      var0.c8104(var1, var2);
   }

   // $FF: synthetic method
   static KeyBindRunner c8751(ModButton var0) {
      return var0.c5958;
   }

   // $FF: synthetic method
   static boolean c8179(ModButton var0) {
      return var0.c6696;
   }

   // $FF: synthetic method
   static boolean c3542(ModButton var0, boolean var1) {
      return var0.c6696 = var1;
   }

   // $FF: synthetic method
   static boolean c7499(ModButton var0) {
      return var0.needDisplay();
   }

   // $FF: synthetic method
   static boolean c7130(ModButton var0) {
      return var0.needDisplay();
   }

   // $FF: synthetic method
   static CheckBox c6360(ModButton var0) {
      return var0.c5615();
   }

   // $FF: synthetic method
   static Mod c7873(ModButton var0) {
      return var0.mod;
   }
}
