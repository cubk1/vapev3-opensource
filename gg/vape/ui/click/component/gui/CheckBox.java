package gg.vape.ui.click.component.gui;

import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.frame.ButtonFrame;
import gg.vape.ui.click.component.value.BooleanComponent;
import gg.vape.utils.render.ImageRenderer;
import gg.vape.utils.render.RenderUtils;
import gg.vape.value.BooleanValue;
import gg.vape.value.Value;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class CheckBox extends ButtonFrame {
   public static final double c2299 = 1.0;

   public CheckBox() {
      super("", false);
      this.c707(0.4);
      this.setColor(accentColor);
      this.setBackGroundColor(new Color(55, 55, 55, 70));
   }

   public void render(boolean flag) {
      super.render(flag);
      if (this.displayable()) {
         GL11.glEnable(GL11.GL_BLEND);
         GL11.glDisable(GL11.GL_TEXTURE_2D);
         GL11.glBlendFunc(770, 771);
         if (this.handler() != null && this.handler().c5999() != null && this.handler() instanceof BooleanComponent) {
            BooleanComponent bc = (BooleanComponent)this.handler();
            BooleanValue bv = (BooleanValue)this.handler().c5999();
            if (bv != null && !bv.getLimits().isEmpty()) {
               Value<?, ?> limit = bv.getALimit();
               if (limit != null) {
                  IGuiComponent component = bv.getALimit().getComponent();
                  if (component != null) {
                     if (!bv.getValue()) {
                        component = bc;
                     }

                     GL11.glColor4d(0.25, 0.25, 0.25, 0.3);
                     GL11.glBegin(7);
                     GL11.glVertex2d(bc.getX(), component.getY() + component.getHeight());
                     GL11.glVertex2d(bc.getX() + bc.getWidth(), component.getY() + component.getHeight());
                     GL11.glVertex2d(bc.getX() + bc.getWidth(), bc.getY());
                     GL11.glVertex2d(bc.getX(), bc.getY());
                     GL11.glEnd();
                     GL11.glLineWidth(1.0F);
                     GL11.glColor4d(0.0, 0.0, 0.0, 0.25);
                     GL11.glBegin(2);
                     GL11.glVertex2d(bc.getX(), component.getY() + component.getHeight());
                     GL11.glVertex2d(bc.getX() + bc.getWidth(), component.getY() + component.getHeight());
                     GL11.glVertex2d(bc.getX() + bc.getWidth(), bc.getY());
                     GL11.glVertex2d(bc.getX(), bc.getY());
                     GL11.glEnd();
                  }
               }
            }
         }

         RenderUtils.drawRect(hoveringColor, this.getX() + 1.0, this.getY() + this.getHeight() - 1.0, this.getX() + this.getWidth() - 1.0, this.getY() + this.getHeight() - 1.0, this.getX() + this.getWidth() - 1.0, this.getY() + 1.0, this.getX() + 1.0, this.getY() + 1.0);
         if (this.c2346()) {
            float var6 = 0.3F;
            if (this.getWidth() > 18.0) {
               var6 = 0.62F;
            } else if (this.getWidth() > 16.0) {
               var6 = 0.56F;
            }

            ImageRenderer.drawRes(this.getColor(), (float)(this.getX() + 1.0), (float)(this.getY() - 1.0), "check", var6);
         }
      }

      GL11.glEnable(GL11.GL_TEXTURE_2D);
      GL11.glDisable(GL11.GL_BLEND);
   }
}
