package gg.vape.value;

import gg.vape.ui.click.actions.ActionSetComponentDisplayable;
import gg.vape.ui.click.component.gui.GuiComponentUnion;
import gg.vape.unmap.ModeSelection;

public class ModeValue extends Value<ModeSelection, GuiComponentUnion<ModeSelection>> {
   public ModeValue(Object var1, String var2, GuiComponentUnion<ModeSelection> var3) {
      super(var1, var2, var3);
   }

   public static ModeValue create(Object var0, String var1, String var2, String var3, ModeSelection var4, ModeSelection[] var5) {
      GuiComponentUnion<ModeSelection> var6 = new GuiComponentUnion<>(var2, var5);
      var6.onOffset(10.0);
      var6.c3997(var4);
      ModeValue var7 = new ModeValue(var0, var1, var6);
      ((GuiComponentUnion)var7.getComponent()).setText(var3);
      var7.c2026(var4);
      var6.c8376(var7);
      var6.c6740().add(new ActionSetComponentDisplayable());
      ModeSelection[] var8 = var5;
      int var9 = var5.length;

      for(int var10 = 0; var10 < var9; ++var10) {
         ModeSelection var11 = var8[var10];
         var11.c2742(var7);
      }

      return var7;
   }


   public static ModeValue create(Object var0, String var1, String var2, ModeSelection var3, ModeSelection... var4) {
      return create(var0, var1, var1, var2, var3, var4);
   }

   public static ModeValue create(Object var0, String var1, ModeSelection var2, ModeSelection... var3) {
      return create(var0, var1, var1, var2, var3);
   }

   public ModeSelection getValue() {
      return (ModeSelection)((GuiComponentUnion<ModeSelection>)this.getComponent()).c8470();
   }

   public void setValue(ModeSelection var1) {
      if (this.c1672() == null) {
         this.c2026(var1);
      }

      ((GuiComponentUnion<ModeSelection>)this.getComponent()).c3997(var1);
   }

   public void parse(String var1) {
      ModeValue var2 = this.getValue().getMode();
      if (var2 != null) {
         ModeSelection var3 = ModeSelection.c2599(var2, var1);
         if (var3 != null) {
            this.setValue(var3);
         }
      }
   }

}
