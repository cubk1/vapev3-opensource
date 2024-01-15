package gg.vape.ui.click.frame.impl;

import func.skidline.c7721;
import gg.vape.Vape;
import gg.vape.friend.Friend;
import gg.vape.ui.click.actions.ActionRemoveFriend;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.IFrameComponent;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.ImageRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.utils.render.RenderUtils;
import gg.vape.wrapper.impl.Minecraft;

public class FrameFriend extends SquareButton implements IFrameComponent {
   public final Friend c7173;
   public boolean c49 = true;

   public FrameFriend(c7721 var1, Friend var2) {
      super("", true);
      this.c7173 = var2;
      this.onRendererHandling(new PoseRenderer(2.0, 10.0, 1, 1, new PoseMatrix(0, 0, 0, 0)));
      this.onOffset(12.0);
      this.setWidth(var1.getWidth());
      //this.addAction(new c3175(this));
      SquareButton var3 = new SquareButton("x", true);
      var3.onOffset(12.0);
      var3.setWidth(12.0);
      var3.addAction(new ActionRemoveFriend(this, var2));
      var1.addComponent(this);
      var1.addComponent(var3);
      IntractiveComponent var4 = new IntractiveComponent("", RenderFlag.Regular, 1.0);
      var4.onOffset(2.0);
      var1.addComponent(var4);
   }

   public void render(boolean flag) {
      super.render(flag);
      String var2 = this.c7173.c3125();
      if (!this.c7173.c3501().equals(this.c7173.c3125()) && !this.isHovering()) {
         var2 = "*" + this.c7173.c5811();
      }

      Minecraft.getFontRenderer().drawStringWithShadow(var2, this.getX() + 14.0, this.getY() + 2.0, -1);
      RenderUtils.c7048(this.getX(), this.getY(), this.getX() + 12.0, this.getY() + 12.0, -16777216);
      if (this.c49) {
         ImageRenderer.drawRes(Vape.instance.getSettings().guiColor.getAsColor(), (float)this.getX() + 1.0F, (float)this.getY() - 1.0F, "check", 0.38F);
      }

   }

   public void toggle() {
      this.c49 = !this.c49;
      this.c7173.c7228(this.c49);
   }

   public boolean c2346() {
      return this.c49;
   }

   public void c8121(boolean var1) {
   }

   public String c4393() {
      return this.c7173.c3125();
   }
}
