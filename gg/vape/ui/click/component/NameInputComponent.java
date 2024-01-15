package gg.vape.ui.click.component;

import gg.vape.ui.click.component.value.TextComponent;
import gg.vape.value.OptionalLimitValue;

public final class NameInputComponent extends TextComponent {
   // $FF: synthetic field
   final OptionalLimitValue c2565;

   public NameInputComponent(int var1, OptionalLimitValue var2) {
      super(var1);
      this.c2565 = var2;
   }

   public boolean c3210(char var1, int var2) {
      if (var2 == 28 && !this.c8589().getName().equals("")) {
         String var3 = this.c8589().getName().replace("_", " ");
         this.c2565.c3429(var3);
         this.c8589().setName("");
         return true;
      } else {
         return super.c3210(var1, var2);
      }
   }
}
