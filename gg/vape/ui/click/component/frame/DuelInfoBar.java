package gg.vape.ui.click.component.frame;

import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.component.value.NumberComponent;
import gg.vape.utils.render.RenderUtils;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class DuelInfoBar extends NumberComponent {
   public int c1154;
   public int c4748;
   public int c7169;
   public final IntractiveComponent c1834;
   public final IntractiveComponent c8124;
   public final IntractiveComponent c2709;
   public boolean c4853;
   public Color c1525 = new Color(101, 194, 152);
   public Color c5558 = new Color(208, 32, 38);

   public DuelInfoBar() {
      super(100.0, 0.0, null, null, null);
      this.c4983(true);
      this.c1834 = new IntractiveComponent("", RenderFlag.NoString, 0.6);
      this.c8124 = new IntractiveComponent("", RenderFlag.Centered, 0.6);
      this.c2709 = new IntractiveComponent("", RenderFlag.Regular, 0.6);
      this.c6219(0, 0);
   }

   public void render(boolean var1) {
      if (this.displayable() && !this.c3783 && this.c3678) {
         boolean var2 = GL11.glIsEnabled(GL11.GL_BLEND);
         if (!var2) {
            GL11.glEnable(GL11.GL_BLEND);
         }

         GL11.glBlendFunc(770, 771);
         GL11.glDisable(GL11.GL_TEXTURE_2D);
         if (this.getColor() != null) {
            RenderUtils.drawRect(this.getColor(), this.getX() - 2.0, this.getY() + this.getHeight(), this.getX() + this.getWidth() + 2.0, this.getY() + this.getHeight(), this.getX() + this.getWidth() + 2.0, this.getY(), this.getX() - 2.0, this.getY());
         }

         double var3 = 7.0;
         double var5 = 2.0;
         RenderUtils.drawRect(m, this.getX() + 0.5, this.getY() + this.c2967() + this.c755() + this.c755() - var5 - 0.5, this.getX() + this.getWidth() - 0.25, this.getY() + this.c2967() + this.c755() + this.c755() - var5 - 0.5, this.getX() + this.getWidth() - 0.25, this.getY() + var3 + 0.5, this.getX() + 0.5, this.getY() + var3 + 0.5);
         RenderUtils.drawRect(this.c4853 ? this.c1525 : this.c5558, this.getX() + this.c755(), this.getY() + this.c755() + this.c2967() - var5, this.getX() + this.getWidth() - this.c755(), this.getY() + this.c755() + this.c2967() - var5, this.getX() + this.getWidth() - this.c755(), this.getY() + this.c755() + var3, this.getX() + this.c755(), this.getY() + this.c755() + var3);
         RenderUtils.drawRect(this.c4853 ? this.c5558 : this.c1525, this.getX() + this.c755(), this.getY() + this.c755() + this.c2967() - var5, this.getX() + this.c6647() - this.c755(), this.getY() + this.c755() + this.c2967() - var5, this.getX() + this.c6647() - this.c755(), this.getY() + this.c755() + var3, this.getX() + this.c755(), this.getY() + this.c755() + var3);
         if (this.c1696() != 0) {
            RenderUtils.drawRect((this.c4853 ? this.c5558 : this.c1525).darker().darker().darker(), this.getX() + this.c6647() + this.c755() - 2.25, this.getY() + this.c755() + this.c2967() - var5, this.getX() + this.c6647() + this.c755() - 1.5, this.getY() + this.c755() + this.c2967() - var5, this.getX() + this.c6647() + this.c755() - 1.5, this.getY() + this.c755() + var3, this.getX() + this.c6647() + this.c755() - 2.25, this.getY() + this.c755() + var3);
         }

         double var7 = this.getWidth() / 2.0 + 1.0;
         RenderUtils.drawRect(hoveringColor, this.getX() + var7 + this.c755() - 0.5 - 2.0, this.getY() + this.c755() + this.c2967() - var5 + 1.5, this.getX() + var7 + this.c755() + 0.5 - 2.0, this.getY() + this.c755() + this.c2967() - var5 + 1.5, this.getX() + var7 + this.c755() + 0.5 - 2.0, this.getY() + this.c755() + var3 - 1.5, this.getX() + var7 + this.c755() - 0.5 - 2.0, this.getY() + this.c755() + var3 - 1.5);
         GL11.glEnable(GL11.GL_TEXTURE_2D);
         this.c1834.setWidth(10.0);
         this.c1834.onOffset(10.0);
         this.c1834.c1042(this.getX() + var7 - 16.0);
         this.c1834.c467(this.getY() - 1.0);
         this.c1834.render(false);
         this.c8124.setWidth(10.0);
         this.c8124.onOffset(10.0);
         this.c8124.c1042(this.getX() - 3.0);
         this.c8124.c467(this.getY() - 1.0);
         this.c8124.render(false);
         if (this.c8174() > this.c190()) {
            this.c8124.setColor(this.c4853 ? this.c5558 : this.c1525);
         } else if (this.c190() > this.c8174()) {
            this.c8124.setColor(this.c4853 ? this.c1525 : this.c5558);
         } else {
            this.c8124.setColor(Color.WHITE);
         }

         this.c2709.setWidth(10.0);
         this.c2709.onOffset(10.0);
         this.c2709.c1042(this.getX() + var7 + 3.0);
         this.c2709.c467(this.getY() - 1.0);
         this.c2709.render(false);
         if (!var2) {
            GL11.glDisable(GL11.GL_BLEND);
         }
      }

   }

   public void c6219(int var1, int var2) {
      this.c1154 = var1;
      this.c1834.setName(this.c1154 + "");
      this.c4748 = var2;
      this.c2709.setName(this.c4748 + "");
      this.c7169 = this.c4853 ? this.c4748 - this.c1154 : this.c1154 - this.c4748;
      this.c8124.setName(this.c7169 + "");
      if (this.c7169 > 0) {
         this.c8124.setName("+" + this.c7169);
      }

      double var3 = this.c1154 + this.c4748;
      if (var3 == 0.0) {
         this.c8030(50.0);
      } else {
         double var5 = (double)(var3 > 0.0 ? var1 : var2) / var3;
         this.c8030(100.0 * var5);
      }
   }

   public int c8174() {
      return this.c1154;
   }

   public int c190() {
      return this.c4748;
   }

   public int c1696() {
      return this.c7169;
   }

   public Color c2154() {
      return this.c1525;
   }

   public void c4644(Color var1) {
      this.c1525 = var1;
   }

   public Color c5487() {
      return this.c5558;
   }

   public void c6642(Color var1) {
      this.c5558 = var1;
   }

   public boolean c7880() {
      return this.c4853;
   }

   public void c8923(boolean var1) {
      this.c4853 = var1;
   }
}
