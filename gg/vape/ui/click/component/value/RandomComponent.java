package gg.vape.ui.click.component.value;

import func.skidline.*;
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
import gg.vape.utils.render.PoseMatrix;
import gg.vape.utils.render.RenderUtils;
import gg.vape.value.RandomValue;
import gg.vape.value.Value;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class RandomComponent extends GuiComponent implements IEditable, c963, c7011 {
   public static final double c6942 = 0.5;
   public final RandomComponent c5450;
   public final NumberFormat c3033;
   public final double c1249;
   public final double c4318;
   public final String c4736;
   public final String c5621;
   public final boolean c578;
   public final String c695;
   public IntractiveComponent c2038;
   public double c369 = 1.0;
   public double c6002 = 0.0;
   public double c5218 = 0.0;
   public boolean c3030 = false;
   public int c6872 = 0;
   public boolean c1781 = false;
   public double c3304 = 0.0;

   public RandomComponent(double var1, double var3, String var5, String var6, String var7) {
      this.c1249 = var1;
      this.c4318 = var3;
      this.c4736 = var6;
      this.c5621 = var5;
      this.c695 = var7;
      this.c3033 = new NumberFormat(var5);
      if (var7 == null) {
         this.c5450 = this;
         this.c578 = false;
      } else {
         this.c578 = true;
         this.c2038 = new IntractiveComponent(var7, RenderFlag.Centered, 0.55, false);
         this.c2038.onOffset(this.getFont().getStringHeight(var7) * 0.5);
         this.c5450 = new RandomComponent(var1, var3, var5, var6, null);
         this.onRendererHandling(new PoseRenderer(0.0, 0.0, 2, 1, new PoseMatrix(0, 0, 0, 0)));
         this.addComponent(this.c2038);
         this.addComponent(this.c5450);
      }

      this.c2888(new c4974(this, 0.0, 0.0, 0.0, 100.0), new c2399(this));
      this.c2888(new c1889(this, 0.0, 0.0, 0.0, 100.0), new c4273(this));
      this.c707(0.5);
      this.setColor(Color.green);
      this.setBackGroundColor(new Color(110, 110, 110, 70));
   }
   class c4974 extends RectData {
      // $FF: synthetic field
      final RandomComponent c627;

      c4974(RandomComponent var1, double var2, double var4, double var6, double var8) {
         super(var2, var4, var6, var8);
         this.c627 = var1;
      }

      public double getWidth() {
         return RandomComponent.c3712(this.c627);
      }
   }

   class c1889 extends RectData {
      // $FF: synthetic field
      final RandomComponent c5443;

      c1889(RandomComponent var1, double var2, double var4, double var6, double var8) {
         super(var2, var4, var6, var8);
         this.c5443 = var1;
      }

      public double getX() {
         return RandomComponent.c3712(this.c5443);
      }

      public double getWidth() {
         return this.c5443.getWidth();
      }
   }

   class c4273 implements IActionComponent {
      // $FF: synthetic field
      final RandomComponent c5284;

      c4273(RandomComponent var1) {
         this.c5284 = var1;
      }

      public void c4493(IGuiComponent var1, int var2, int var3, int var4) {
         if (var4 == 0) {
            this.c5284.setDragState(true);
            this.c5284.setEditing(true);
            RandomComponent.c8003(this.c5284, 2);
         }

      }
   }

   class c2399 implements IActionComponent {
      // $FF: synthetic field
      final RandomComponent c5852;

      c2399(RandomComponent var1) {
         this.c5852 = var1;
      }

      public void c4493(IGuiComponent var1, int var2, int var3, int var4) {
         if (var4 == 0) {
            this.c5852.setDragState(true);
            this.c5852.setEditing(true);
            RandomComponent.c8003(this.c5852, 1);
         }

      }
   }

   public void setColor(Color var1) {
      super.setColor(var1);
      if (this.c578) {
         this.c5450.setColor(var1);
      }

   }

   public void render(boolean var1) {
      if (this.isDragin() && !Mouse.isButtonDown(0)) {
         this.setDragState(false);
      }

      if (this.c578) {
         this.c2038.onOffset(this.getFont().getStringHeight(this.c695) + this.c755());
      }

      if (this.displayable() && !this.c578) {
         GL11.glEnable(GL11.GL_BLEND);
         GL11.glBlendFunc(770, 771);
         GL11.glDisable(GL11.GL_TEXTURE_2D);
         RenderUtils.drawRect(hoveringColor, this.getX(), this.getY() + this.getHeight(), this.getX() + this.getWidth(), this.getY() + this.getHeight(), this.getX() + this.getWidth(), this.getY(), this.getX(), this.getY());
         RenderUtils.drawComponentSquare(this.isEditing() ? this.getColor().darker().darker().darker() : this.getBackGroundColor(), this.c755(), this, 4);
         RenderUtils.drawRect(this.getColor(), this.getX() + this.c2967() + this.c755(), this.getY() + this.c755() + this.c1212(), this.getX() + this.c6647() - this.c755(), this.getY() + this.c755() + this.c1212(), this.getX() + this.c6647() - this.c755(), this.getY() + this.c755(), this.getX() + this.c2967() + this.c755(), this.getY() + this.c755());
         RenderUtils.drawRect(this.getColor().darker(), this.getX() + this.c3304 + this.c755() - 1.0, this.getY() + this.c755() + this.c1212(), this.getX() + this.c3304 - this.c755() + 1.0, this.getY() + this.c755() + this.c1212(), this.getX() + this.c3304 - this.c755() + 1.0, this.getY() + this.c755(), this.getX() + this.c3304 + this.c755() - 1.0, this.getY() + this.c755());
         double var2 = -2.5;
         double var4 = -1.0;
         RenderUtils.drawRect(this.getColor().darker().darker().darker(), this.getX() + this.c6647() + this.c755() + var2, this.getY() + this.c755() + this.c1212(), this.getX() + this.c6647() + this.c755() + var4, this.getY() + this.c755() + this.c1212(), this.getX() + this.c6647() + this.c755() + var4, this.getY() + this.c755(), this.getX() + this.c6647() + this.c755() + var2, this.getY() + this.c755());
         double var6 = 0.0;
         double var8 = 1.5;
         RenderUtils.drawRect(this.getColor().darker().darker().darker(), this.getX() + this.c2967() + this.c755() + var6, this.getY() + this.c755() + this.c1212(), this.getX() + this.c2967() + this.c755() + var8, this.getY() + this.c755() + this.c1212(), this.getX() + this.c2967() + this.c755() + var8, this.getY() + this.c755(), this.getX() + this.c2967() + this.c755() + var6, this.getY() + this.c755());
         GL11.glEnable(GL11.GL_TEXTURE_2D);
         this.getFont().drawString(this.c3033.c8033(this.c6002), this.getX() + 2.0, this.getY() - this.c1212() + this.c755() + 1.0, -1);
         this.getFont().drawString(this.c3033.c8033(this.c5218), this.getX() + (this.getWidth() - this.getFont().getStringWidth(this.c3033.c8033(this.c5218))) - this.c755(), this.getY() - this.c1212() + this.c755() + 1.0, -1);
         GL11.glDisable(GL11.GL_BLEND);
      }

      super.render(var1);
   }

   public SmoothFontRenderer getFont() {
      return Vape.instance.getF10();
   }

   public void draw() {
      super.draw();
      if (!this.c578) {
         if (this.isDragin()) {
            c5423 var1 = RenderUtils.c7719();
            double var2 = this.getX() - this.c755();
            double var4 = this.getWidth() - this.c755() * 2.0;
            double var6;
            double var8;
            double var10;
            double var12;
            if (this.c6872 == 1) {
               --var1.c535;
               if ((double)var1.c535 >= var2 + this.c6647()) {
                  this.c8030(this.c5218 - 0.1);
               } else if ((double)var1.c535 < var2) {
                  this.c8030(this.c4318);
               } else {
                  var6 = (double)var1.c535 - var2;
                  var8 = var6 / var4;
                  var10 = this.c1249 - this.c4318;
                  var12 = var8 * var10;
                  this.c8030(var12 + this.c4318);
               }
            } else if (this.c6872 == 2) {
               --var1.c535;
               if ((double)var1.c535 > var2 + var4) {
                  this.c7591(this.c1249);
               } else if ((double)var1.c535 <= var2 + this.c2967()) {
                  this.c7591(this.c6002 + 0.1);
               } else {
                  var6 = (double)var1.c535 - var2;
                  var8 = var6 / var4;
                  var10 = this.c1249 - this.c4318;
                  var12 = var8 * var10;
                  this.c7591(var12 + this.c4318);
               }
            }
         }

         RandomValue var14 = (RandomValue)this.c5999();
         if (var14.c4968().equals(var14.c5400())) {
            if (this.c6872 == 2) {
               this.c7591(this.c1826() + 0.1);
            } else {
               this.c8030(this.c7481() - 0.1);
            }
         }

         this.c3304 = (this.c2967() + this.c6647()) / 2.0;
      }

   }

   public void setWidth(double var1) {
      super.setWidth(var1);
      if (this.c578) {
         this.c2038.setWidth(var1);
         this.c5450.setWidth(var1);
      }

   }

   public void onOffset(double var1) {
      super.onOffset(var1);
      if (this.c578) {
         this.c5450.onOffset(var1);
      }

   }

   public boolean c4828(int var1, int var2, int var3) {
      if (!this.isHovering()) {
         this.setEditing(false);
      }

      return super.c4828(var1, var2, var3);
   }

   public boolean c3210(char var1, int var2) {
      if (this.isEditing()) {
         if (var2 == 203) {
            if (this.c6872 == 1) {
               this.c8030(this.c7481() - (Keyboard.isKeyDown(29) ? 10.0 : (Keyboard.isKeyDown(42) ? 0.1 : 1.0)));
            } else {
               this.c7591(this.c1826() - (Keyboard.isKeyDown(29) ? 10.0 : (Keyboard.isKeyDown(42) ? 0.1 : 1.0)));
            }

            return true;
         }

         if (var2 == 205) {
            if (this.c6872 == 1) {
               this.c8030(this.c7481() + (Keyboard.isKeyDown(29) ? 10.0 : (Keyboard.isKeyDown(42) ? 0.1 : 1.0)));
            } else {
               this.c7591(this.c1826() + (Keyboard.isKeyDown(29) ? 10.0 : (Keyboard.isKeyDown(42) ? 0.1 : 1.0)));
            }

            return true;
         }
      }

      return super.c3210(var1, var2);
   }

   public Double c7481() {
      return this.c578 ? this.c5450.c7481() : this.c6002;
   }

   public void c8030(double var1) {
      if (this.c578) {
         this.c5450.c8030(var1);
      } else {
         if (var1 > this.c1249) {
            var1 = this.c1249;
         } else if (var1 < this.c4318) {
            var1 = this.c4318;
         } else if (var1 > this.c5846()) {
            var1 = this.c5846() - 0.1;
         }

         this.c6002 = var1;
      }

   }

   public Double c1826() {
      return this.c578 ? this.c5450.c1826() : this.c5218;
   }

   public double c5358() {
      return this.c4318;
   }

   public double c3425() {
      return this.c1249;
   }

   public void c7591(double var1) {
      if (this.c578) {
         this.c5450.c7591(var1);
      } else {
         if (var1 > this.c1249) {
            var1 = this.c1249;
         } else if (var1 < this.c4318) {
            var1 = this.c4318;
         } else if (var1 < this.c858()) {
            var1 = this.c858() + 0.1;
         }

         this.c5218 = var1;
      }

   }

   public boolean isDragin() {
      return this.c3030 && !this.c2877();
   }

   public void setDragState(boolean var1) {
      this.c3030 = var1;
   }

   public double c755() {
      return this.c369;
   }

   public void c707(double var1) {
      this.c369 = var1;
   }

   public boolean isEditing() {
      return this.c1781;
   }

   public void setEditing(boolean editing) {
      if (!this.c2877()) {
         this.c1781 = editing;
      }
   }

   public double c1212() {
      return this.getHeight() - this.c755() * 2.0;
   }

   public double c2967() {
      return (this.c6002 - this.c4318) / (this.c1249 - this.c4318) * this.getWidth();
   }

   public double c6647() {
      return (this.c5218 - this.c4318) / (this.c1249 - this.c4318) * this.getWidth();
   }

   public double c858() {
      return this.c6002;
   }

   public double c5846() {
      return this.c5218;
   }

   public NumberFormat c610() {
      return this.c3033;
   }

   public NumberData[] c8260() {
      return new NumberData[]{new NumberData(this.c7481()), new NumberData(this.c1826())};
   }

   public void c8376(Value var1) {
      if (this.c578) {
         this.c5450.c8376(var1);
      }

      super.c8376(var1);
   }

   public void c4983(boolean var1) {
      super.c4983(var1);
      if (this.c578) {
         this.c5450.c4983(var1);
      }

   }

   // $FF: synthetic method
   static double c3712(RandomComponent var0) {
      return var0.c3304;
   }

   // $FF: synthetic method
   static int c8003(RandomComponent var0, int var1) {
      return var0.c6872 = var1;
   }
}
