package gg.vape.value;

import gg.vape.ui.click.component.value.NumberComponent;

public class NumberValue extends Value<Double, NumberComponent> {
   public NumberValue(Object var1, String var2, NumberComponent var3) {
      super(var1, var2, var3);
   }

   public static NumberValue create(Object var0, String var1, String var2, String var3, String var4, double var5, double var7, double var9) {
      NumberComponent var11 = new NumberComponent(var9, var5, 0.01, var3, var4, var2);
      var11.setWidth(100.0);
      var11.onOffset(7.0);
      var11.c8030(var7);
      NumberValue var12 = new NumberValue(var0, var1, var11);
      var12.c2026(var7);
      var11.c8376(var12);
      return var12;
   }

   public static NumberValue create(Object var0, String var1, String var2, String var3, double var4, double var6, double var8, double var10, String var12) {
      NumberComponent var13 = new NumberComponent(var8, var4, var10, var2, " " + var3, var1);
      var13.setWidth(100.0);
      var13.onOffset(7.0);
      var13.c8030(var6);
      NumberValue var14 = new NumberValue(var0, var1, var13);
      var14.c2026(var6);
      var13.c8376(var14);
      var13.setText(var12);
      return var14;
   }

   public static NumberValue create(Object var0, String var1, String var2, String var3, double var4, double var6, double var8, double var10) {
      NumberComponent var12 = new NumberComponent(var8, var4, var10, var2, " " + var3, var1);
      var12.setWidth(100.0);
      var12.onOffset(7.0);
      var12.c8030(var6);
      NumberValue var13 = new NumberValue(var0, var1, var12);
      var13.c2026(var6);
      var12.c8376(var13);
      return var13;
   }

   public static NumberValue c8404(Object var0, String var1, String var2, String var3, double var4, double var6, double var8, String var10) {
      NumberComponent var11 = new NumberComponent(var8, var4, 0.01, var2, " " + var3, var1);
      var11.setWidth(100.0);
      var11.onOffset(7.0);
      var11.c8030(var6);
      NumberValue var12 = new NumberValue(var0, var1, var11);
      var12.c2026(var6);
      var11.c8376(var12);
      var11.setText(var10);
      return var12;
   }

   public static NumberValue create(Object var0, String var1, String var2, String var3, double var4, double var6, double var8) {
      NumberComponent var10 = new NumberComponent(var8, var4, 0.01, var2, " " + var3, var1);
      var10.setWidth(100.0);
      var10.onOffset(7.0);
      var10.c8030(var6);
      NumberValue var11 = new NumberValue(var0, var1, var10);
      var10.c8376(var11);
      var11.c2026(var6);
      return var11;
   }

   public Double getValue() {
      return ((NumberComponent)this.getComponent()).c5180();
   }

   public void setValue(Double var1) {
      if (this.c1672() == null) {
         this.c2026(var1);
      }

      if (var1 > ((NumberComponent)this.getComponent()).c858()) {
         this.setValue(((NumberComponent)this.getComponent()).c858());
      } else if (var1 < ((NumberComponent)this.getComponent()).c5846()) {
         this.setValue(((NumberComponent)this.getComponent()).c5846());
      }

      ((NumberComponent)this.getComponent()).c8030(var1);
   }

   public void parse(String var1) {
      this.setValue(Double.parseDouble(var1));
   }

   // $FF: synthetic method
   public Object c2908() {
      return this.getValue();
   }
}
