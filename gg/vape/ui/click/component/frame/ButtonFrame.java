package gg.vape.ui.click.component.frame;

import gg.vape.ui.click.frame.IFrameComponent;
import gg.vape.ui.unmap.SquareButton;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class ButtonFrame extends SquareButton implements IFrameComponent {
   public boolean c6450 = false;

   public ButtonFrame(String var1, boolean var2) {
      super(var1, var2);
      this.addAction((x, y, mouseBn)->{
         if (mouseBn == 0) {
            this.toggle();//todo
         }
      });
      this.addAction(c->{
         this.c7363(this.c2346());
         this.getGuiButton().c7363(this.c2346());
      });
      this.c7363(false);
      this.getGuiButton().c7363(false);
   }

   public void setColor(Color var1) {
      super.setColor(var1);
      this.getGuiButton().setColor(var1);
   }

   public void render(boolean flag) {
      if (this.displayable()) {
         GL11.glEnable(GL11.GL_BLEND);
         GL11.glDisable(GL11.GL_TEXTURE_2D);
         GL11.glBlendFunc(770, 771);
         GL11.glEnable(GL11.GL_TEXTURE_2D);
         GL11.glDisable(GL11.GL_BLEND);
      }

      super.render(flag);
   }

   public void toggle() {
      this.c8121(!this.c2346());
   }

   public boolean c2346() {
      return this.c6450;
   }

   public void c8121(boolean var1) {
      this.c6450 = var1;
      this.c7363(this.c2346());
      this.getGuiButton().c7363(this.c2346());
   }
}

