package gg.vape.ui.click.actions;

import gg.vape.module.Macro;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.impl.FrameMacrosEditor;
import org.lwjgl.input.Keyboard;

public class ActionBindMacro implements IGuiCallback {
   // $FF: synthetic field
   final Macro c5973;
   // $FF: synthetic field
   final IntractiveComponent c7470;
   // $FF: synthetic field
   final FrameMacrosEditor c7435;

   public ActionBindMacro(FrameMacrosEditor var1, Macro var2, IntractiveComponent var3) {
      this.c7435 = var1;
      this.c5973 = var2;
      this.c7470 = var3;
   }

   public void call(IGuiComponent inst) {
      if (this.c5973.c7728() < 0) {
         this.c7470.setName("  Bound to: " + c6652(this.c5973.c7728()));
      } else {
         this.c7470.setName("  Bound to: " + Keyboard.getKeyName(this.c5973.c7728()));
      }

   }

   public static String c6652(int var0) {
      if (var0 < 0) {
         var0 += 100;
      }

      return "M" + (var0 + 1);
   }
}
