package gg.vape.ui.click.frame.impl;

import gg.vape.module.Macro;
import gg.vape.module.macro.BaseMacroImpl;
import gg.vape.ui.click.actions.ActionBindMacro;
import gg.vape.ui.click.actions.ActionSetMacroDelay;
import gg.vape.ui.click.actions.ActionSetMacroDoubleClickDelay;
import gg.vape.ui.click.actions.ActionSwitchMacro;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.click.frame.IFrameComponent;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;

import java.awt.*;

public class FrameMacrosEditor extends SquareButton implements IFrameComponent {
   public FrameMacrosEditor(FrameComponent var1, FrameMacros var2, Macro var3) {
      super("", true);
      var3.c1406(var1);
      this.onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      this.setWidth(var1.getWidth());
      IntractiveComponent var4 = new IntractiveComponent("", RenderFlag.Regular, 1.0);
      var4.onOffset(2.0);
      var1.addComponent(var4);
      this.addAction(new ActionSwitchMacro(this, var2, var3));
      IntractiveComponent var5 = new IntractiveComponent(var3.c3731(), RenderFlag.Regular, 0.5);
      double var6 = this.getWidth() - 5.0 - (double)(2 * 4);
      var5.setColor(Color.WHITE);
      var5.c7363(false);
      var5.onOffset(8.0);
      var5.setWidth(var6);
      this.addComponent(var5);
      IntractiveComponent var8 = new IntractiveComponent("", RenderFlag.Regular, 0.5);
      var8.setColor(Color.LIGHT_GRAY);
      var8.c7363(false);
      var8.onOffset(6.0);
      var8.setWidth(var6);
      var8.addAction(new ActionBindMacro(this, var3, var8));
      this.addComponent(var8);
      IntractiveComponent var9 = new IntractiveComponent("", RenderFlag.Regular, 0.5);
      var9.setColor(Color.LIGHT_GRAY);
      var9.c7363(false);
      var9.onOffset(6.0);
      var9.setWidth(var6);
      var9.addAction(new ActionSetMacroDelay(this, var9, var3));
      if (!(var3 instanceof BaseMacroImpl)) {
         this.addComponent(var9);
      }

      IntractiveComponent var10 = new IntractiveComponent("", RenderFlag.Regular, 0.5);
      var10.setColor(Color.LIGHT_GRAY);
      var10.c7363(false);
      var10.onOffset(6.0);
      var10.setWidth(var6);
      var10.addAction(new ActionSetMacroDoubleClickDelay(this, var10, var3));
      if (!(var3 instanceof BaseMacroImpl)) {
         this.addComponent(var10);
      }

      var1.addComponent(this);
   }

   public void render(boolean flag) {
      super.render(flag);
   }

   public void toggle() {
   }

   public boolean c2346() {
      return false;
   }

   public void c8121(boolean var1) {
   }
}
