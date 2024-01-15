package gg.vape.ui.click.component.gui;

import func.skidline.c6836;
import gg.vape.Vape;
import gg.vape.ui.click.IGuiNamed;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.font.SmoothFontRenderer;
import gg.vape.utils.render.RenderUtils;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class IntractiveComponent extends GuiComponent implements IGuiNamed {
   public int stringFlag;
   public int c3278;
   public final String c8663;
   public String name;
   public double c3091;
   public boolean c3443;
   public final boolean c4149;

   public IntractiveComponent(String var1, int var2, double var3) {
      this.c3278 = c6836.c7959;
      this.c3443 = false;
      this.c8663 = var1;
      this.name = var1;
      this.stringFlag = var2;
      this.c3091 = var3;
      this.setColor(Color.WHITE);
      this.c4149 = true;
   }

   public IntractiveComponent(String var1, int var2, double var3, boolean var5) {
      this.c3278 = c6836.c7959;
      this.c3443 = false;
      this.c8663 = var1;
      this.name = var1;
      this.stringFlag = var2;
      this.c3091 = var3;
      this.setColor(Color.WHITE);
      this.c4149 = var5;
   }

   public void render(boolean var1) {
      super.render(var1);
      if (this.displayable()) {
         GL11.glPushMatrix();
         Color var2 = this.c4149 ? this.getColor() : Color.white;
         if (this.c30()) {
            String[] var3 = this.getName().split("\n");
            double var4 = 0.0;
            String[] var6 = var3;
            int var7 = var3.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               String var9 = var6[var8];
               this.drawStr(var9, this.getX() + 1.0, this.getY() + var4, var2);
               var4 += this.getFont().getStringHeight(var9) + 1.0;
            }
         } else {
            this.drawStr(this.name, this.getX() + 1.0, this.getY(), var2);
         }

         GL11.glPopMatrix();
      }

   }

   public SmoothFontRenderer getFont() {
      return Vape.instance.getFont(this.c3091);
   }

   public void drawStr(String name, double x, double y, Color color) {
      RenderUtils.setColor(color);
      SmoothFontRenderer var7 = this.getFont();

      if (!this.c30()) {
         y += this.getHeight() / 2.0;
         y -= var7.getStringHeight(name) / 2.0;
      }

      if (this.stringFlag == RenderFlag.Centered) {
         if (this.c3278 == c6836.c7959) {
            var7.drawStringCentered(name, x + this.getWidth() / 2.0, y, color);
         } else if (this.c3278 == c6836.c2682) {
            var7.drawStringCenteredWithShadow(name, x + this.getWidth() / 2.0, y, color);
         }
      } else if (this.stringFlag == RenderFlag.Regular) {
         if (this.c3278 == c6836.c7959) {
            var7.drawString(name, x, y, color);
         } else if (this.c3278 == c6836.c2682) {
            var7.drawStringWithShadow(name, x, y, color);
         }
      } else if (this.c3278 == c6836.c7959) {
         var7.drawString(name, x + this.getWidth() - var7.getStringWidth(name), y, color);
      } else if (this.c3278 == c6836.c2682) {
         var7.drawStringWithShadow(name, x + this.getWidth() - var7.getStringWidth(name), y, color);
      }

   }

   public double getWidth() {
      if (this.c30()) {
         double var1 = 0.0;
         String[] var3 = this.getName().split("\n");
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            String var6 = var3[var5];
            double var7 = this.getFont().getStringWidth(var6);
            if (var7 > var1) {
               var1 = var7;
            }
         }

         return var1;
      } else {
         return super.getWidth();
      }
   }

   public double getNameWidth() {
      return this.getFont().getStringWidth(this.name);
   }

   public double getHeight() {
      if (!this.c30()) {
         return super.getHeight();
      } else {
         String[] var1 = this.getName().split("\n");
         if (var1.length == 0) {
            return super.getHeight();
         } else {
            double var2 = -1.0;
            String[] var4 = var1;
            int var5 = var1.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               String var7 = var4[var6];
               var2 += this.getFont().getStringHeight(var7);
            }

            return var2 + (double)var1.length;
         }
      }
   }

   public String c7304() {
      return this.c8663;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void c8030(double var1) {
      this.c3091 = var1;
   }

   public int c1696() {
      return this.c3278;
   }

   public void c5305(int var1) {
      this.c3278 = var1;
   }

   public boolean c30() {
      return this.c3443;
   }

   public void c8923(boolean var1) {
      this.c3443 = var1;
   }

   public void c2404(int var1) {
      this.stringFlag = var1;
   }

   // $FF: synthetic method
   public IGuiComponent c8735() {
      return super.c7995();
   }

   // $FF: synthetic method
   public Object clone() {
      return super.c7995();
   }
}
