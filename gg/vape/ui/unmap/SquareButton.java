package gg.vape.ui.unmap;

import func.skidline.c963;
import gg.vape.ui.click.IActionComponent;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.IClickable;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.utils.render.RenderUtils;
import org.lwjgl.opengl.GL11;

public class SquareButton extends GuiComponent implements c963, IClickable {
   public final IntractiveComponent processor;
   public boolean enabled;
   public double sideLength;
   public IButtonOnClick c4751;
   class c8830 implements IActionComponent {
      // $FF: synthetic field
      final SquareButton c391;

      c8830(SquareButton var1) {
         this.c391 = var1;
      }

      public void c4493(IGuiComponent var1, int var2, int var3, int var4) {
         if (SquareButton.c1481(this.c391) != null && this.c391.displayable()) {
            SquareButton.c1481(this.c391).onClick(var2, var3, var4);
         }

      }
   }

//label???
   public SquareButton(String name, boolean enabled) {
      this.processor = new IntractiveComponent("", RenderFlag.Centered, 1.0);
      this.sideLength = 0.0;
      this.enabled = enabled;
      this.onRendererHandling(new PoseRenderer(0.0, 0.0, 1, 1, new PoseMatrix(0, 0, 0, 0)));
      this.c2888(null, new c8830(this));
      this.processor.setName(name);
      this.addComponent(this.processor);
   }
   class c8581 implements IActionComponent {
      // $FF: synthetic field
      final SquareButton c8403;

      c8581(SquareButton var1) {
         this.c8403 = var1;
      }

      public void c4493(IGuiComponent var1, int var2, int var3, int var4) {
         if (SquareButton.c1481(this.c8403) != null && this.c8403.displayable()) {
            SquareButton.c1481(this.c8403).onClick(var2, var3, var4);
         }

      }
   }

   public SquareButton(boolean var1) {
      this.processor = new IntractiveComponent("", RenderFlag.Centered, 1.0);
      this.sideLength = 0.0;
      this.enabled = var1;
      this.onRendererHandling(new PoseRenderer(0.0, 0.0, 1, 1, new PoseMatrix(0, 0, 0, 0)));
      this.c2888(null, new c8581(this));
   }


   public void setWidth(double var1) {
      super.setWidth(var1);
      this.processor.setWidth(this.getWidth());
   }


   public void setWidthSilent(double var1) {
      super.setWidth(var1);
      this.processor.setWidth(this.getWidth());
   }

   public void onOffset(double var1) {
      super.onOffset(var1);
      this.processor.onOffset(this.getHeight());
   }

   public void render(boolean flag) {
      if (this.displayable()) {
         boolean isBlendEnable = GL11.glIsEnabled(GL11.GL_BLEND);
         if (!isBlendEnable) {
            GL11.glEnable(GL11.GL_BLEND);
         }

         GL11.glDisable(GL11.GL_TEXTURE_2D);
         GL11.glBlendFunc(770, 771);
         if (this.sideLength > 0.0) {
            RenderUtils.drawComponentSquare(this.getBackGroundColor(), this.sideLength, this, 4);//allside
         }

         if (this.enabled) {
            RenderUtils.drawComponent(this.getBackGroundColor(), this);
         }

         if (this.isHovering()) {
            RenderUtils.drawRect(hoveringColor,
                    this.getX() + this.sideLength,
                    this.getY() + this.getHeight() - this.sideLength,

                    this.getX() + this.getWidth() - this.sideLength,
                    this.getY() + this.getHeight() - this.sideLength,

                    this.getX() + this.getWidth() - this.sideLength,
                    this.getY() + this.sideLength,

                    this.getX() + this.sideLength,
                    this.getY() + this.sideLength);
         }

         GL11.glEnable(GL11.GL_TEXTURE_2D);
         if (!isBlendEnable) {
            GL11.glDisable(GL11.GL_BLEND);
         }
      }

      super.render(flag);
   }

   public IButtonOnClick getClickEvent() {
      return this.c4751;
   }

   public void addAction(IButtonOnClick var1) {
      this.c4751 = var1;
   }

   public double c755() {
      return this.sideLength;
   }

   public void c707(double var1) {
      this.sideLength = var1;
   }

   public IntractiveComponent getGuiButton() {
      return this.processor;
   }

   public boolean c246() {
      return this.enabled;
   }

   public void c8923(boolean var1) {
      this.enabled = var1;
   }

   // $FF: synthetic method
   static IButtonOnClick c1481(SquareButton var0) {
      return var0.c4751;
   }
}
