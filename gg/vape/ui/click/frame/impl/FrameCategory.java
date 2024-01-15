package gg.vape.ui.click.frame.impl;

import gg.vape.Vape;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.unmap.ModButton;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.ui.unmap.SliderInFrame;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.value.Value;

import java.util.ArrayList;
import java.util.List;

public class FrameCategory extends Frame {
   public final Category category;
   public final SliderInFrame slider;
   public final List<Mod> categoryMods = new ArrayList();
   public final SquareButton c8299 = new SquareButton("test", true);
   public double width;

   public FrameCategory(Category cate) {
      super(cate.getName(), false);
      this.category = cate;
      this.slider = new SliderInFrame(false);
      this.slider.onOffset(250.0);
      this.getFramePage().addComponent(this.slider);
      this.c8299.onOffset(5.0);
      this.c8299.getGuiButton().c8030(0.5);
      this.c8299.addAction(
              (x,y,z)->{
                 ClickGui gui = Vape.instance.getModManager().getMod(ClickGui.class);
                 gui.setEditState(!gui.getEditState());
              }
      );
      this.getFramePage().addComponent(this.c8299);
      this.getFramePage().onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      this.setWidth(88.0);
      this.onOffset(20.0);
      this.c7694().setText(cate.getDesc());
   }


   public void render(boolean flag) {
      super.render(flag);
      if (this.slider.c2855()) {
         this.setWidth(this.width + 5.0);
      } else {
         this.setWidth(this.width);
      }

      int hidCount = 0;

      for (Mod mod : this.categoryMods) {
         if (!mod.isDisplayable()) {
            ++hidCount;
            if (mod.getState()) {
               mod.setState(false);
            }
         }
      }

      if (hidCount == 0) {
         this.c8299.setDisplayable(false);
      } else {
         this.c8299.setDisplayable(true);
         this.c8299.getGuiButton().setName(hidCount + " hidden modules");
      }

      this.c8299.setWidth(this.getWidth() - 3.0);
   }

   public Category c714() {
      return this.category;
   }

   public void c1458(Mod var1) {
      this.categoryMods.add(var1);
   }

   public void c270() {
      double targetWidth = this.getWidth();
      double maxWidth = 0.0;

      for(Mod mod : this.categoryMods) {
         ModButton modBn = new ModButton(mod);
         mod.bindTo(modBn);
         modBn.checkAva(mod.available());
         modBn.c7988(true);
         modBn.onOffset(17.0);
         double var8 = modBn.getWidth();
         if (var8 > maxWidth) {
            maxWidth = var8;
         }

         for (Value<?, ?> value : mod.getValues()) {
            if (value.getComponent() != null) {
               modBn.addSubComponent(value.getComponent());
            }
         }

         this.slider.c8120(modBn);
      }

      if (maxWidth > targetWidth) {
         targetWidth = maxWidth;
      }

      for(Mod mod : this.categoryMods) {
         mod.getButton().setWidth(targetWidth - 4.0);
      }


      this.setWidth(targetWidth);
      this.width = this.getWidth();
   }
}
