package gg.vape.ui.click.frame.impl;

import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.gui.CheckBox;
import gg.vape.ui.click.frame.Frame;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;

public class FrameGUI extends Frame {
   public final CheckBox button = new CheckBox();

   public FrameGUI() {
      super("GUI", false);
      this.getFramePage().onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      this.button.setDisplayable(true);
      this.button.c8121(true);
      this.button.setWidth(10.0);
      this.button.onOffset(10.0);
      this.setWidth(87.0);
      this.onOffset(20.0);
   }

   public void setWidth(double width) {
      super.setWidth(width);
      for (IGuiComponent component : this.getFramePage().getComponents()) {
         component.setWidth(width - 4.0);
      }
   }

   public boolean loadRenderer() {
      return false;
   }
}
