package gg.vape.ui.click.component;

import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.unmap.ModButton;
import pub.nextsense.Tweaker;

public class ToolTips extends IntractiveComponent {
   // $FF: synthetic field
   final GuiComponent gui;

   public ToolTips(GuiComponent gui, String var2, int var3, double var4) {
      super(var2, var3, var4);
      this.gui = gui;
   }

   public String getName() {
      boolean var1 = Tweaker.isBlatantMode();
      if (this.gui instanceof ModButton) {
         ModButton var2 = (ModButton)this.gui;
         if (var2.c6646() != null && var2.c6646().isBlatantMod() && !var1) {
            return "Requires blatant mode";
         }

         if (var2.c6646() != null && var2.c6646().c199() && var2.c6646().c8399().isEmpty()) {
            return "Must be bound";
         }
      }

      return this.gui.c3617() && !var1 ? "Requires blatant mode" : super.getName();
   }
}
