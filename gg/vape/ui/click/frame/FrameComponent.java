package gg.vape.ui.click.frame;

import func.skidline.c7721;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.utils.render.RenderUtils;
import org.lwjgl.opengl.GL11;

public class FrameComponent extends GuiComponent implements c7721 {
   public boolean opened;
   public double len = 0.0;

   public FrameComponent(boolean status) {
      this.opened = status;
   }

   public void render(boolean flag) {
      if (this.displayable() && this.opened) {
         GL11.glPushMatrix();
         boolean var2 = GL11.glIsEnabled(GL11.GL_BLEND);
         if (!var2) {
            GL11.glEnable(GL11.GL_BLEND);
         }

         GL11.glDisable(GL11.GL_TEXTURE_2D);
         GL11.glBlendFunc(770, 771);
         RenderUtils.drawComponent(this.getColor(), this);
         if (this.len > 0.0) {
            RenderUtils.drawComponentSquare(this.getBackGroundColor(), this.len, this, 4);
         }

         GL11.glEnable(GL11.GL_TEXTURE_2D);
         if (!var2) {
            GL11.glDisable(GL11.GL_BLEND);
         }

         GL11.glPopMatrix();
      }

      super.render(flag);
   }

   public void opened(boolean var1) {
      this.opened = var1;
   }

   public void c8030(double var1) {
      this.len = var1;
   }
}
