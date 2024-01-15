package gg.vape.ui.unmap;

import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.ImageButton;
import gg.vape.unmap.ComponentCloseHandler;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;

import java.awt.*;

public class exButton extends SquareButton {
   public final ImageButton c13;
   public GuiComponent c4722;

   class c2097 implements IGuiCallback {
      // $FF: synthetic field
      final exButton c4938;

      c2097(exButton var1) {
         this.c4938 = var1;
      }

      public void call(IGuiComponent inst) {
         this.c4938.c13.c51((float) inst.getWidth() - 8.0F);
         this.c4938.c13.c1920((float)(-(inst.getHeight() / 2.0)) - 3.25F);
         if (this.c4938.c3816() != null) {
            if (ClickGui.c8213() != null && ClickGui.c8213().equals(this.c4938.c3816())) {
               this.c4938.getGuiButton().c7363(true);
               this.c4938.c13.c7363(true);
            } else {
               this.c4938.getGuiButton().setColor(Color.WHITE);
               this.c4938.getGuiButton().c7363(false);
               this.c4938.c13.c7363(false);
               this.c4938.c13.setColor(Color.WHITE);
            }
         }

      }
   }
   class c8052 implements ComponentCloseHandler {
      // $FF: synthetic field
      final exButton GuiScreen;

      c8052(exButton var1) {
         this.GuiScreen = var1;
      }

      public void onClose(boolean var1) {
         if (!var1 && ClickGui.c8213() != null && ClickGui.c8213().equals(this.GuiScreen.c3816())) {
            ClickGui.c2207(null);
         }

      }
   }

   class c4838 implements IButtonOnClick {
      // $FF: synthetic field
      final exButton c6185;

      c4838(exButton var1) {
         this.c6185 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (this.c6185.c3816() != null) {
            if (ClickGui.c8213() != null && ClickGui.c8213().equals(this.c6185.c3816())) {
               ClickGui.c2207(null);
            } else {
               ClickGui.c2207(this.c6185.c3816());
            }

         }
      }
   }

   class c6862 implements IGuiCallback {
      // $FF: synthetic field
      final exButton c1617;

      c6862(exButton var1) {
         this.c1617 = var1;
      }

      public void call(IGuiComponent inst) {
         if (!inst.displayable() && ClickGui.c8213() != null && ClickGui.c8213().equals(this.c1617.c3816())) {
            ClickGui.c2207(null);
         }

         if (inst.handler() != null && !inst.handler().displayable()) {
            ClickGui.c2207(null);
            inst.setDisplayable(false);
         }

      }
   }

   public exButton(String var1, GuiComponent var2) {
      super(var1, true);
      this.onRendererHandling(new PoseRenderer(0.0, 0.0, 2, 1, new PoseMatrix(0, 0, 0, 0)));
      this.c4722 = var2;
      this.c13 = new ImageButton("ex", 0.2F, true);
      this.addComponent(this.c13);
      this.getGuiButton().c2404(RenderFlag.Regular);
      this.getGuiButton().addAction(new c2097(this));
      this.onClose(new c8052(this));
      this.addAction(new c4838(this));
      this.addAction(new c6862(this));
   }

   public ImageButton c3376() {
      return this.c13;
   }

   public GuiComponent c3816() {
      return this.c4722;
   }

   public void c2207(GuiComponent var1) {
      this.c4722 = var1;
   }

}
