package gg.vape.ui.click.component.gui;

import gg.vape.ui.click.component.value.NumberComponent;
import gg.vape.ui.click.component.value.TextComponent;
import gg.vape.unmap.ItemLimitData;
import gg.vape.value.LimitValue;

public final class InputBox extends TextComponent {
   // $FF: synthetic field
   final boolean c2225;
   // $FF: synthetic field
   final LimitValue c2868;
   // $FF: synthetic field
   final NumberComponent c2892;

   public InputBox(int var1, boolean var2, LimitValue var3, NumberComponent var4) {
      super(var1);
      this.c2225 = var2;
      this.c2868 = var3;
      this.c2892 = var4;
   }

   public boolean c3210(char var1, int var2) {
      if (var2 == 28 && !this.c8589().getName().equals("")) {
         String var3 = this.c8589().getName().replace("_", " ");
         if (this.c2225) {
            this.c2868.c230(new ItemLimitData(var3, this.c2892.c5180().intValue()));
         } else {
            this.c2868.c230(new ItemLimitData(var3, -1));
         }

         this.c8589().setName("");
         return true;
      } else {
         return super.c3210(var1, var2);
      }
   }
}
