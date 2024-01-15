package gg.vape.ui.click.component.value;

import func.skidline.c5423;
import func.skidline.c7011;
import func.skidline.c963;
import gg.vape.Vape;
import gg.vape.ui.click.IActionComponent;
import gg.vape.ui.click.IEditable;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.font.SmoothFontRenderer;
import gg.vape.unmap.NumberFormat;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.MathUtil;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.utils.render.RenderUtils;
import gg.vape.value.Value;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class NumberComponent extends GuiComponent implements IEditable, c963, c7011 {
   protected static final double c6201 = 0.5;
   protected final double c3125;
   protected final double c8646;
   protected final double c248;
   protected final String c6407;
   protected final String c2695;
   protected final String c861;
   protected NumberComponent c1298;
   protected boolean c3783;
   protected IntractiveComponent c1207;
   protected double c6925;
   protected double c1168;
   protected boolean c2189;
   protected boolean c3678;
   public boolean c8556;
   public NumberFormat c6909;

   public NumberComponent(double var1, double var3, double var5, String var7, String var8, String var9) {
      this.c6925 = 0.5;
      this.c1168 = 0.0;
      this.c2189 = false;
      this.c3678 = true;
      this.c8556 = false;
      this.c3125 = var1;
      this.c8646 = var3;
      this.c248 = var5;
      this.c6407 = var8;
      this.c861 = var9;
      this.c2695 = var7;
      if (var7 != null) {
         this.c6909 = new NumberFormat(var7);
      }

      if (var9 == null) {
         this.c1298 = this;
         this.c3783 = false;
      } else {
         this.c3783 = true;
         this.c1207 = new IntractiveComponent(var9, RenderFlag.Regular, 0.6, false);


         this.c1207.onOffset(this.getFont().getStringHeight(var9) * 0.5);

         this.c1298 = new NumberComponent(var1, var3, var5, var7, var8, null);
         this.onRendererHandling(new PoseRenderer(0.0, 0.0, 2, 1, new PoseMatrix(0, 0, 0, 0)));
         this.addComponent(this.c1207);
         this.addComponent(this.c1298);
      }

      this.c2888(null, new c8141(this));
      this.setColor(this.getColor());
      this.setBackGroundColor(new Color(110, 110, 110, 70));
   }

   class c8141 implements IActionComponent {
      // $FF: synthetic field
      final NumberComponent c4320;

      c8141(NumberComponent var1) {
         this.c4320 = var1;
      }

      public void c4493(IGuiComponent var1, int var2, int var3, int var4) {
         if (var4 == 0) {
            this.c4320.setDragState(true);
            this.c4320.setEditing(true);
         }

      }
   }

   public NumberComponent(double var1, double var3, String var5, String var6, String var7) {
      this(var1, var3, 0.1, var5, var6, var7);
   }

   public void setColor(Color var1) {
      super.setColor(var1);
      if (this.c3783) {
         this.c1298.setColor(var1);
      }

   }

   public void render(boolean var1) {
      if (this.isDragin() && !Mouse.isButtonDown(0)) {
         this.setDragState(false);
      }

      if (this.c3783) {
         this.c1207.onOffset(this.getFont().getStringHeight(this.c861) + 2.0);
      }

      if (this.displayable() && !this.c3783 && this.c3678) {
         GL11.glEnable(GL11.GL_BLEND);
         GL11.glBlendFunc(770, 771);
         GL11.glDisable(GL11.GL_TEXTURE_2D);
         RenderUtils.drawRect(hoveringColor, this.getX(), this.getY() + this.getHeight(), this.getX() + this.getWidth(), this.getY() + this.getHeight(), this.getX() + this.getWidth(), this.getY(), this.getX(), this.getY());
         RenderUtils.drawComponentSquare(this.isEditing() ? this.getColor().darker().darker().darker() : this.getBackGroundColor(), this.c755(), this, 4);
         RenderUtils.drawRect(this.getColor(), this.getX() + this.c755(), this.getY() + this.c755() + this.c2967(), this.getX() + this.c6647() - this.c755(), this.getY() + this.c755() + this.c2967(), this.getX() + this.c6647() - this.c755(), this.getY() + this.c755(), this.getX() + this.c755(), this.getY() + this.c755());
         double var2 = -2.5;
         double var4 = -1.0;
         if (this.c6647() <= 1.0) {
            var4 = -var2 - 1.0;
            var2 = 0.0;
         } else if (this.c6647() >= 1.0 && this.c6647() <= 3.0) {
            var4 = -var2 - 1.5;
            var2 = -0.5;
         } else if (this.c6647() >= 3.0 && this.c6647() <= 5.0) {
            var4 = -var2 - 2.0;
            var2 = -1.0;
         } else if (this.c6647() >= 5.0 && this.c6647() <= 7.0) {
            var4 = -var2 - 2.5;
            var2 = -1.5;
         }

         RenderUtils.drawRect(this.getColor().darker().darker().darker(), this.getX() + this.c6647() + this.c755() + var2, this.getY() + this.c755() + this.c2967(), this.getX() + this.c6647() + this.c755() + var4, this.getY() + this.c755() + this.c2967(), this.getX() + this.c6647() + this.c755() + var4, this.getY() + this.c755(), this.getX() + this.c6647() + this.c755() + var2, this.getY() + this.c755());
         GL11.glEnable(GL11.GL_TEXTURE_2D);
         String var6 = "";
         if (this.c6909 != null) {
            if (this.c2695.isEmpty()) {
               var6 = (int)this.c1168 + "";
            } else {
               var6 = this.c6909.c8033(this.c1168);
            }

            var6 = var6 + this.c6407;
         }
         this.getFont().drawString(var6, this.getX() + (this.getWidth() - this.getFont().getStringWidth(var6)) - this.c755(), this.getY() - this.c2967() + this.c755() + 1.0, -1);
         GL11.glDisable(GL11.GL_BLEND);
      }

      super.render(var1);
   }

   public SmoothFontRenderer getFont() {
      return Vape.instance.getF10();
   }

   public void draw() {
      super.draw();
      if (this.isDragin() && !this.c3783) {
         c5423 var1 = RenderUtils.c7719();
         double var2 = this.getX() - this.c755();
         double var4 = this.getWidth() - this.c755() * 2.0;
         if ((double)var1.c535 > var2 + var4) {
            this.c8030(this.c3125);
         } else if ((double)var1.c535 < var2) {
            this.c8030(this.c8646);
         } else {
            double var6 = (double)var1.c535 - var2;
            double var8 = var6 / var4;
            double var10 = this.c3125 - this.c8646;
            double var12 = var8 * var10;
            this.c8030(MathUtil.c1305(var12 + this.c8646, this.c248));
         }
      }

   }

   public void setWidth(double var1) {
      super.setWidth(var1);
      if (this.c3783) {
         this.c1207.setWidth(var1);
         this.c1298.setWidth(var1);
      }

   }

   public void onOffset(double var1) {
      super.onOffset(var1);
      if (this.c3783) {
         this.c1298.onOffset(var1);
      }

   }

   public boolean c4828(int var1, int var2, int var3) {
      if (!this.isHovering()) {
         this.setEditing(false);
      }

      return super.c4828(var1, var2, var3);
   }

   public Double c5180() {
      return this.c3783 ? this.c1298.c5180() : this.c1168;
   }

   public void c8030(double var1) {
      var1 = MathUtil.c1305(var1, this.c248);
      if (this.c3783) {
         this.c1298.c8030(var1);
      } else {
         if (var1 > this.c3125) {
            var1 = this.c3125;
         } else if (var1 < this.c8646) {
            var1 = this.c8646;
         }

         this.c1168 = var1;
      }

   }

   public boolean isDragin() {
      return this.c2189 && !this.c2877();
   }

   public void setDragState(boolean var1) {
      this.c2189 = var1;
   }

   public double c755() {
      return this.c6925;
   }

   public void c707(double var1) {
      this.c6925 = var1;
   }

   protected double c2967() {
      return this.getHeight() - this.c755() * 2.0;
   }

   protected double c6647() {
      return (this.c1168 - this.c8646) / (this.c3125 - this.c8646) * this.getWidth();
   }

   public double c858() {
      return this.c3125;
   }

   public double c5846() {
      return this.c8646;
   }

   public boolean isEditing() {
      if (this.c2877()) {
         return false;
      } else {
         return this.c3783 ? this.c1298.isEditing() : this.c8556;
      }
   }

   public void setEditing(boolean editing) {
      if (this.c3783) {
         this.c1298.setEditing(editing);
      } else {
         this.c8556 = editing;
      }

   }

   public boolean c3210(char var1, int var2) {
      double var3 = 1.0;
      if (this.c6909 != null && this.c6909.c8532() == 2) {
         var3 = 0.1;
      }

      double var5 = 10.0 * var3;
      double var7 = var3;
      double var9 = 0.1 * var3;
      if (this.isEditing()) {
         if (var2 == 203) {
            this.c8030(this.c5180() - (Keyboard.isKeyDown(29) ? var5 : (Keyboard.isKeyDown(42) ? var9 : var7)));
            return true;
         }

         if (var2 == 205) {
            this.c8030(this.c5180() + (Keyboard.isKeyDown(29) ? var5 : (Keyboard.isKeyDown(42) ? var9 : var7)));
            return true;
         }
      }

      return super.c3210(var1, var2);
   }

   public String c2495() {
      return this.c6407;
   }

   public String c3920() {
      return this.c2695;
   }

   public void c8376(Value var1) {
      super.c8376(var1);
      if (this.c3783) {
         this.c1298.c8376(var1);
      }

   }

   public void c4983(boolean var1) {
      super.c4983(var1);
      if (this.c3783) {
         this.c1298.c4983(var1);
      }

   }
}
