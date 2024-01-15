package gg.vape.ui.click.frame.impl;

import gg.vape.Vape;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.wrapper.impl.Minecraft;

public class FrameEdit extends Frame {
   public final ClickGui c1183;

   public FrameEdit() {
      super("Edit", false);
      this.c1183 = Vape.instance.getModManager().getMod(ClickGui.class);
      this.getFramePage().onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      SquareButton var1 = new SquareButton("Finish editing", false);
      var1.setWidth(120.0);
      var1.onOffset(30.0);
      var1.addAction(new c2382(this));
      this.getFramePage().addComponent(var1);
      this.c840(true);
      this.c3664(true);
   }

   public void render(boolean flag) {
      super.render(true);
   }

   public void draw() {
      super.draw();
      this.setCloseStatus(false);
      this.c1042((double) Minecraft.c4912().getScaledWidth() - this.getWidth());
      this.c467(0.0);
      this.setWidth(100.0);
      this.onOffset(20.0);
      this.setDisplayable(this.c1183.getEditState());
   }

   public boolean loadRenderer() {
      return false;
   }

   class c2382 implements IButtonOnClick {
      // $FF: synthetic field
      final FrameEdit c840;

      c2382(FrameEdit var1) {
         this.c840 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (mouseBn == 0) {
            FrameEdit.c2800(this.c840).setEditState(false);
         }

      }
   }

   // $FF: synthetic method
   static ClickGui c2800(FrameEdit var0) {
      return var0.c1183;
   }
}
