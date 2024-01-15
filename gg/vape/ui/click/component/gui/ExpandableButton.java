package gg.vape.ui.click.component.gui;

import gg.vape.ui.unmap.SquareButton;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;

import java.awt.*;

public class ExpandableButton extends SquareButton {
   public final ImageButton bn;

   public ExpandableButton(String var1, float var2, float var3, float var4) {
      this(var1, var2, var3, var4, false);
   }

   public ExpandableButton(String var1, float var2, float var3, float var4, boolean var5) {
      super(var5);
      this.onRendererHandling(new PoseRenderer(0.0, 0.0, 1, 1, new PoseMatrix(0, 0, 0, 0)));
      this.addComponent(this.bn = new ImageButton(var1, var2, false, false));
      this.bn.c51(var3);
      this.bn.c1920(var4);
   }

   public ExpandableButton(String var1, String var2, float var3, float var4, float var5, boolean var6) {
      super(var6);
      this.onRendererHandling(new PoseRenderer(0.0, 0.0, 1, 2, new PoseMatrix(0, 0, 0, 0)));
      this.addComponent(this.bn = new ImageButton(var1, var3, false, false));
      this.bn.c51(var4);
      this.bn.c1920(var5);
      this.getGuiButton().setName(var2);
      this.addComponent(this.getGuiButton());
   }

   public void setWidth(double var1) {
      super.setWidth(var1);
      if (this.getGuiButton().getName().equalsIgnoreCase("")) {
         this.bn.setWidth(var1);
      }

   }

   public void onOffset(double var1) {
      super.onOffset(var1);
      this.bn.onOffset(var1);
   }

   public void c4644(Color var1) {
      this.bn.c4644(var1);
   }

   public ImageButton c3376() {
      return this.bn;
   }
}
