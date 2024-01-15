package gg.vape.ui.click.component.gui;

import func.skidline.c1967;
import func.skidline.c963;
import gg.vape.ui.click.ICloseable;
import gg.vape.ui.click.actions.ActionCloseUnion;
import gg.vape.ui.click.actions.ActionToggleClose;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.unmap.INamed;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.utils.render.RenderUtils;
import org.lwjgl.opengl.GL11;

import java.util.Iterator;

public class GuiComponentUnion<T> extends GuiComponent implements c963, ICloseable {
   public static final int c4582 = 2;
   public final FrameComponent c6083 = new FrameComponent(false);
   public final FrameComponent c5025 = new FrameComponent(false);
   public final SquareButton c3626;
   public IntractiveComponent c504;
   public double c3167 = 0.5;
   public Object c1932;

   @SafeVarargs
   public GuiComponentUnion(String var1, T... var2) {
      this.onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      if (var1 != null) {
         this.c504 = new IntractiveComponent(var1, RenderFlag.Centered, 0.7);
      }

      this.c3626 = new SquareButton("", false);
      this.c3626.getGuiButton().setColor(accentColor);
      this.c3626.addAction(new ActionToggleClose(this));

      this.c6083.onRendererHandling(new PoseRenderer(0.0, 0.0, 1, 2, new PoseMatrix(0, 0, 0, 0)));
      this.c6083.addComponent(this.c3626);
      this.c6083.c7363(false);
      this.c6083.setColor(hoveringColor);

      this.c5025.setDisplayable(false);
      this.c5025.onRendererHandling(new PoseRenderer(0.0, 0.0, var2.length, 1, new PoseMatrix(0, 2, 0, 2)));

      Object[] var3 = var2;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Object var6 = var3[var5];
         SquareButton var7 = new SquareButton(this.c245(var6), false);
         var7.addAction(new ActionCloseUnion(this, var6));
         var7.addAction(new c1967(this, var6));
         this.c5025.addComponent(var7);
      }

      this.addComponent(this.c504);
      this.addComponent(this.c6083);
      this.addComponent(this.c5025);
   }

   public void setWidth(double var1) {
      super.setWidth(var1);
      this.c3626.setWidth(var1);

      for (IGuiComponent component : this.c5025.getComponents()) {
         component.setWidth(var1 - 4.0);
      }

      if (this.c504 != null) {
         this.c504.setWidth(var1);
      }

   }

   public void onOffset(double var1) {
      super.onOffset(var1);
      this.c3626.onOffset(var1);
      this.c6083.onOffset(var1);
      Iterator var3 = this.c5025.getComponents().iterator();

      while(var3.hasNext()) {
         IGuiComponent var4 = (IGuiComponent)var3.next();
         var4.onOffset(var1);
      }

      if (this.c504 != null) {
         this.c504.onOffset(var1 * 0.6);
      }

   }

   public void render(boolean var1) {
      super.render(var1);
      if (this.displayable()) {
         GL11.glEnable(GL11.GL_BLEND);
         GL11.glDisable(GL11.GL_TEXTURE_2D);
         GL11.glBlendFunc(770, 771);
         this.c6083.opened(!this.isClosed());
         if (this.isClosed()) {
            RenderUtils.drawComponentSquare(this.getColor().darker().darker().darker(), this.c755(), this.c6083, 4);
         } else {
            RenderUtils.drawComponentSquare(this.getColor().darker(), this.c755(), this.c6083, 0, 2, 1);
            RenderUtils.drawComponentSquare(this.getColor().darker(), this.c755(), this.c5025, 0, 2, 3);
         }

         GL11.glEnable(GL11.GL_TEXTURE_2D);
         GL11.glDisable(GL11.GL_BLEND);
      }

   }

   public boolean isClosed() {
      return !this.c5025.displayable();
   }

   public void setCloseStatus(boolean var1) {
      this.c5025.setDisplayable(!var1);
   }

   public Object c8470() {
      return this.c1932;
   }

   public void c3997(Object var1) {
      this.c1932 = var1;
      this.c3626.getGuiButton().setName(this.c245(var1));
   }

   public String c245(Object var1) {
      return var1 instanceof INamed ? ((INamed)var1).getName() : var1.toString();
   }

   public double c755() {
      return this.c3167;
   }

   public void c707(double var1) {
      this.c3167 = var1;
   }

   // $FF: synthetic method
   public static Object c1395(GuiComponentUnion var0) {
      return var0.c1932;
   }
}
