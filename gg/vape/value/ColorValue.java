package gg.vape.value;

import func.skidline.ColorPicker;
import gg.vape.ui.click.component.value.NumberComponent;
import gg.vape.unmap.ColorUtil;
import gg.vape.utils.MathUtil;

import java.awt.*;
import java.util.Random;

public class ColorValue extends Value<Double, ColorPicker> {
   public static final int c6422 = 96;
   public final NumberValue c7084;
   public final NumberValue c7647;
   public final NumberValue c3761;
   public final BooleanValue rainbow;
   public final Random c376 = new Random();

   public ColorValue(Object var1, String var2, ColorPicker var3) {
      super(var1, var2, var3);
      ((ColorPicker)this.getComponent()).setText("Double click for rainbow\nShift click to switch between hue, brightness, and saturation");
      this.c7084 = NumberValue.create(var1, var2 + " hue", var2 + " hue", var3.c3920(), var3.c5846(), 255.0, var3.c858());
      this.c7647 = NumberValue.create(var1, var2 + " brightness", var2 + " brightness", var3.c3920(), var3.c5846(), 87.0, var3.c858());
      this.c3761 = NumberValue.create(var1, var2 + " saturation", var2 + " saturation", var3.c3920(), var3.c5846(), 255.0, var3.c858());
      this.rainbow = BooleanValue.c7943(var1, var2 + " rainbow", var2 + " rainbow", false);
   }

   public static ColorValue c7407(Object var0, String var1, double var2) {
      ColorPicker var4 = new ColorPicker(96.0, 0.0, "", "", var1);
      var4.setWidth(92.0);
      var4.onOffset(7.0);
      ColorValue var5 = new ColorValue(var0, var1, var4);
      var5.c2026(var2);
      var4.c8376(var5);
      var4.c8030(var2);
      double var6 = var4.c5180() / 96.0;
      var5.c505().c2026(var6 * 100.0);
      return var5;
   }

   public static ColorValue create(Object var0, String var1, Color var2) {
      float var3 = Color.RGBtoHSB(var2.getRed(), var2.getGreen(), var2.getBlue(), null)[0];
      return c7407(var0, var1, var3 * 96.0F);
   }

   public Double getValue() {
      return ((ColorPicker)this.getComponent()).c5180();
   }

   public void setColor(Color var1) {
      ((ColorPicker)this.getComponent()).c8030(Color.RGBtoHSB(var1.getRed(), var1.getGreen(), var1.getBlue(), null)[0]);
   }

   public void c992() {
      this.setValue(MathUtil.c1009(this.c376, ((ColorPicker)this.getComponent()).c5846(), ((ColorPicker)this.getComponent()).c858()));
   }

   public void setValue(Double var1) {
      if (this.c1672() == null) {
         this.c2026(var1);
      }

      ((ColorPicker)this.getComponent()).c8030(var1);
   }

   public void parse(String var1) {
      this.setValue(Double.parseDouble(var1));
   }

   public Color getAsColor() {
      return ((ColorPicker)this.getComponent()).getValue();
   }
   public Color getAsColor(int alpha) {
      return new Color(ColorUtil.reAlpha(((ColorPicker)this.getComponent()).getValue().getRGB(),alpha),true);
   }
   public int HSBtoRGB() {
      return Color.HSBtoRGB(this.getHUE(), this.getS(), this.getB());
   }

   public boolean rainbow() {
      return this.rainbow.getValue();
   }

   public void setRainbow(boolean var1) {
      this.rainbow.setValue(var1);
   }

   public void continueHue() {
      this.setValue(this.getValue() + 1.0);
      if (this.getValue() >= ((ColorPicker)this.getComponent()).c858()) {
         this.setValue(((ColorPicker)this.getComponent()).c5846());
      }

   }

   public float getHUE() {
      return this.c7084.getValue().floatValue() / (float)((NumberComponent)this.c7084.getComponent()).c858();
   }

   public float getS() {
      return this.c3761.getValue().floatValue() / (float)((NumberComponent)this.c3761.getComponent()).c858();
   }

   public float getB() {
      return this.c7647.getValue().floatValue() / (float)((NumberComponent)this.c7647.getComponent()).c858();
   }

   public NumberValue c505() {
      return this.c7084;
   }

   public NumberValue c4785() {
      return this.c7647;
   }

   public NumberValue c7080() {
      return this.c3761;
   }

   // $FF: synthetic method
   public Object c2908() {
      return this.getValue();
   }
}
