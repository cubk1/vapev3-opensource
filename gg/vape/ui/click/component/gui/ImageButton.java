package gg.vape.ui.click.component.gui;

import gg.vape.ui.click.component.GuiComponent;
import gg.vape.utils.render.ImageRenderer;

import java.awt.*;

public class ImageButton extends GuiComponent {
   public final float c3732;
   public final boolean c6609;
   public final boolean c8782;
   public String c8270;
   public float c843;
   public float c7275;
   public Color c31;

   public ImageButton(String var1, float var2, boolean var3) {
      this(var1, var2, var3, true);
   }

   public ImageButton(String var1, float var2, boolean var3, boolean var4) {
      this.c31 = Color.WHITE;
      this.c8270 = var1;
      this.c3732 = var2;
      this.c6609 = var3;
      this.setColor(Color.WHITE);
      this.c8782 = var4;
   }

   public ImageButton(String var1, float var2) {
      this(var1, var2, false);
   }

   public void render(boolean var1) {
      super.render(var1);
      if (this.displayable()) {
         ImageRenderer.drawResWithShadow(this.c8782 ? this.getColor() : this.c31, (float)this.getX() + this.c28(), (float)this.getY() + this.c2502(), this.c8270, this.c3732, this.c6609);
      }

   }

   public float c28() {
      return this.c843;
   }

   public void c51(float var1) {
      this.c843 = var1;
   }

   public float c2502() {
      return this.c7275;
   }

   public void c1920(float var1) {
      this.c7275 = var1;
   }

   public void c4644(Color var1) {
      this.c31 = var1;
   }

   public void c7057(String var1) {
      this.c8270 = var1;
   }
}
