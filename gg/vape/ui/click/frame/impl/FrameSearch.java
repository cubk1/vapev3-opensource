package gg.vape.ui.click.frame.impl;

import gg.vape.Vape;
import gg.vape.module.none.Search;
import gg.vape.module.none.XRay;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.component.value.TextComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.unmap.ModButton;
import gg.vape.ui.unmap.SearchBlock;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.ui.unmap.SliderInFrame;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.TimerUtil;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.value.ColorValue;
import gg.vape.wrapper.impl.Block;

import java.awt.*;
import java.util.Iterator;

public class FrameSearch extends Frame {
   public static final double c8793 = 20.0;
   public static final double c8421 = 18.0;
   public final FrameComponent c5268;
   public final TextComponent c5005;
   public final IntractiveComponent c5;
   public final SliderInFrame c6163;
   public final ColorValue nbc;
   public final TimerUtil c1166 = new TimerUtil();

   class c5921 implements IButtonOnClick {
      // $FF: synthetic field
      final FrameSearch c8381;

      c5921(FrameSearch var1) {
         this.c8381 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         FrameSearch.c8811(this.c8381, FrameSearch.c2656(this.c8381).c8589().getName());
      }
   }

   class c1162 extends TextComponent {
      // $FF: synthetic field
      final SquareButton c991;
      // $FF: synthetic field
      final FrameSearch c6869;

      c1162(FrameSearch var1, int var2, SquareButton var3) {
         super(var2);
         this.c6869 = var1;
         this.c991 = var3;
      }

      public boolean c3210(char var1, int var2) {
         if (this.isEditing() && var2 == 28) {
            this.c991.getClickEvent().onClick(0, 0, 0);
            return true;
         } else {
            return super.c3210(var1, var2);
         }
      }
   }

   public FrameSearch() {
      super("Search", false);
      this.getFramePage().onRendererHandling(new PoseRenderer(0.0, 1.0, 5, 1, new PoseMatrix(0, 0, 0, 0)));
      FrameComponent var1 = new FrameComponent(false);
      var1.onRendererHandling(new PoseRenderer(0.0, 3.0, 5000, 1, new PoseMatrix(0, 2, 2, 2)));
      var1.setWidth(125.0);
      this.addGuiComponent(var1);
      this.c5268 = new FrameComponent(false);
      var1.addComponent(new ModButton(Vape.instance.getModManager().getMod(Search.class)));
      var1.addComponent(new ModButton(Vape.instance.getModManager().getMod(XRay.class)));
      this.nbc = ColorValue.create(this, "new block color", Color.RED);
      this.nbc.c992();
      var1.addComponent(this.nbc.getComponent());

      SquareButton var2 = new SquareButton("Add", false);
      var2.onOffset(12.0);
      var2.setWidth(20.0);
      var2.addAction(new c5921(this));
      this.c5005 = new c1162(this, 64, var2);
      this.c5005.onOffset(12.0);
      this.c5005.c7057("<block name>");
      this.c5268.onRendererHandling(new PoseRenderer(1.0, 1.0, 1, 2, new PoseMatrix(0, 0, 1, 0)));
      this.c5268.addComponent(this.c5005);
      this.c5268.addComponent(var2);
      var1.addComponent(this.c5268);
      this.c5 = new IntractiveComponent("", RenderFlag.Centered, 0.8);
      this.c5.onOffset(15.0);
      this.c5.setDisplayable(false);
      var1.addComponent(this.c5);
      this.c6163 = new SliderInFrame(false);
      this.c6163.onOffset(130.0);
      var1.addComponent(this.c6163);
      this.setWidth(125.0);
      this.onOffset(20.0);
   }

   public void c7057(String var1) {
      String var2 = var1.replace(" ", "_");
      if (var2.contains(":")) {
         var2 = var2.split(":")[0];
      }

      Block var3 = Block.c2509(var2);
      this.c1166.reset();
      if (var3 == null) {
         this.c5.setName("Could not find block");
      } else {
         Color var4 = this.nbc.getAsColor();
         this.nbc.c992();
         this.c5005.c8589().setName("");
         this.c5.setName("Added " + var1);
         this.c8006(var1, var4);
      }
   }

   public void draw() {
      super.draw();
      if (this.c5.displayable() && this.c1166.hasTimeElapsed(2000L)) {
         this.c5.setName("");
         this.c1166.reset();
      }

      this.c5.setDisplayable(!this.c5.getName().isEmpty());

   }

   public void setWidth(double var1) {
      super.setWidth(var1);
      double var3 = var1 - 9.0;
      Iterator var5 = this.getFramePage().getComponents().iterator();

      while(true) {
         IGuiComponent var6;
         IGuiComponent var8;
         do {
            do {
               if (!var5.hasNext()) {
                  this.c5005.setWidth(var3 - 20.0);
                  var5 = this.c6163.c6047().getComponents().iterator();

                  while(var5.hasNext()) {
                     var6 = (IGuiComponent)var5.next();
                     FrameComponent var10 = (FrameComponent)var6;
                     var8 = var10.getComponents().get(0);
                     IGuiComponent var9 = var10.getComponents().get(1);
                     var8.setWidth(var3 - 18.0 - 5.0);
                     var9.setWidth(18.0);
                  }

                  return;
               }

               var6 = (IGuiComponent)var5.next();
               var6.setWidth(var3);
            } while(!(var6 instanceof GuiComponent));
         } while(var6.equals(this.c6163));

         Iterator var7 = ((GuiComponent)var6).getComponents().iterator();

         while(var7.hasNext()) {
            var8 = (IGuiComponent)var7.next();
            var8.setWidth(var6.getWidth());
         }
      }
   }

   public void c8006(String var1, Color var2) {
      SearchBlock var3 = new SearchBlock(var1, var2.getRGB());
      this.c6140(var3);
      Vape.instance.getSearch().c7224(var3);
   }

   public void c6140(SearchBlock var1) {
      FrameComponent var2 = new FrameComponent(false);
      var2.setWidth(this.getWidth() - 28.0);
      var2.onRendererHandling(new PoseRenderer(1.0, 1.0, 2, 2, new PoseMatrix(0, 2, 0, 0)));
      FrameClosable var3 = new FrameClosable(var2, var1);
      var1.c2950(var3);
      this.c6163.c8120(var2);
   }

   public void c5915(FrameClosable var1) {
      FrameComponent var2 = this.c6163.c6047();
      var2.c4043(var1.c6944());
   }

   // $FF: synthetic method
   static TextComponent c2656(FrameSearch var0) {
      return var0.c5005;
   }

   // $FF: synthetic method
   static void c8811(FrameSearch var0, String var1) {
      var0.c7057(var1);
   }
}
