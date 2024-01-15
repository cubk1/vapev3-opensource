package gg.vape.ui.click.frame.impl;

import func.skidline.c7721;
import gg.vape.Vape;
import gg.vape.module.none.Search;
import gg.vape.ui.click.actions.ActionToggleFrameClose;
import gg.vape.ui.click.actions.ActionUpdateSearch;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.IFrameComponent;
import gg.vape.ui.unmap.SearchBlock;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.ImageRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.utils.render.RenderUtils;
import gg.vape.wrapper.impl.Minecraft;

import java.awt.*;

public class FrameClosable extends SquareButton implements IFrameComponent {
   public boolean c2571 = true;
   public final String c914;
   public final Color c3351;
   public final c7721 c3938;
   public final SearchBlock c2776;

   public FrameClosable(c7721 var1, SearchBlock var2) {
      super("", true);
      this.c3938 = var1;
      this.c914 = var2.c6807();
      this.c3351 = var2.c6427();
      this.c2776 = var2;
      this.setBackGroundColor(this.c3351);
      this.onRendererHandling(new PoseRenderer(2.0, 10.0, 1, 1, new PoseMatrix(0, 0, 0, 0)));
      this.onOffset(12.0);
      this.setWidth(var1.getWidth());
      this.addAction(new ActionToggleFrameClose(this));
      SquareButton var3 = new SquareButton("x", true);
      var3.onOffset(12.0);
      var3.setWidth(12.0);
      var3.addAction(new ActionUpdateSearch(this, this));
      var1.addComponent(this);
      var1.addComponent(var3);
      IntractiveComponent var5 = new IntractiveComponent("", RenderFlag.Regular, 1.0);
      var5.onOffset(2.0);
      var1.addComponent(var5);
   }

   public void render(boolean flag) {
      super.render(flag);
      double var2 = this.getX() + 15.0;
      double var4 = this.getY() + this.getHeight() / 2.0 - (double)(Minecraft.getFontRenderer().FONT_HEIGHT(this.c914) / 4);
      RenderUtils.c403(var2 - 1.0, var4 - 1.0, var2 + (double)(Minecraft.getFontRenderer().getStringWidth(this.c914) / 2), var4 + (double) Minecraft.getFontRenderer().FONT_HEIGHT(this.c914) * 0.5, 0.0, 0.0, 0.0, 0.35);
      Minecraft.getFontRenderer().c3769(this.c914, var2, var4, -1, 0.5);
      RenderUtils.c7048(this.getX(), this.getY(), this.getX() + 12.0, this.getY() + 12.0, -16777216);
      if (this.c2571) {
         ImageRenderer.drawRes(Vape.instance.getSettings().guiColor.getAsColor(), (float)this.getX() + 1.0F, (float)this.getY() - 1.0F, "check", 0.38F);
      }

   }

   public void toggle() {
      this.c2571 = !this.c2571;
      if (this.c2571) {
         Vape.instance.getModManager().getMod(Search.class).c6140(this.c2776);
      } else {
         Vape.instance.getModManager().getMod(Search.class).c4868(this.c2776);
      }

   }

   public boolean c2346() {
      return false;
   }

   public void c8121(boolean var1) {
   }

   public c7721 c6944() {
      return this.c3938;
   }

   public SearchBlock c305() {
      return this.c2776;
   }
}
