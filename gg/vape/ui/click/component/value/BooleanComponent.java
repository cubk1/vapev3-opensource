package gg.vape.ui.click.component.value;

import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.CheckBox;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.IFrameComponent;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;

import java.awt.*;

public class BooleanComponent extends GuiComponent implements IFrameComponent {
   public final CheckBox checkbox;
   public final IntractiveComponent label;
   public double wid;

   public BooleanComponent(String var1, double width) {
      this(var1, new CheckBox());
      this.wid = width;
      this.checkbox.setWidth(width);
   }

   public BooleanComponent(String var1, CheckBox var2) {
      this.wid = var2.getWidth();
      PoseRenderer pose = new PoseRenderer(3.0, 0.0, 1, 2, new PoseMatrix(0, 0, 0, 0));
      this.onRendererHandling(pose);
      this.label = new IntractiveComponent(var1, RenderFlag.Regular, 0.65, false);
      this.checkbox = var2;
      var2.c707(0.5);
      this.addComponent(var2);
      this.addComponent(this.label);
   }

   public void setColor(Color var1) {
      super.setColor(var1);
      this.checkbox.setColor(var1);
   }

   public void setWidth(double var1) {
      super.setWidth(var1);
      this.label.setWidth(var1 - this.wid - ((PoseRenderer)this.getParent()).c3600());
      this.checkbox.setWidth(this.wid);
   }

   public void onOffset(double var1) {
      super.onOffset(var1);
      this.checkbox.onOffset(var1);
      this.label.onOffset(var1);
   }

   public boolean c4828(int var1, int var2, int var3) {
      if (this.c2877()) {
         return false;
      } else {
         if (this.isHovering() && !this.checkbox.isHovering()) {
            this.checkbox.getClickEvent().onClick(var1, var2, var3);
         }

         return super.c4828(var1, var2, var3);
      }
   }

   public void toggle() {
      this.checkbox.toggle();
   }

   public boolean c2346() {
      return this.checkbox.c2346();
   }

   public void c8121(boolean var1) {
      this.checkbox.c8121(var1);
   }

   public CheckBox getCheckBox() {
      return this.checkbox;
   }
}
