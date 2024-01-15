package gg.vape.ui.click.frame.impl;

import gg.vape.Vape;
import gg.vape.module.utility.InvCleaner;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.component.value.NumberComponent;
import gg.vape.ui.click.component.value.TextComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.unmap.ModButton;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.ui.unmap.SliderInFrame;
import gg.vape.unmap.ItemLimitData;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.TimerUtil;
import gg.vape.utils.render.PoseMatrix;

import java.util.Iterator;

public class FrameInvCleaner extends Frame {
   public final IntractiveComponent c4412;
   public final TimerUtil c3233 = new TimerUtil();
   public final SliderInFrame c4145;

   public FrameInvCleaner() {
      super("InvCleaner", false);
      this.getFramePage().onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      this.setWidth(100.0);
      this.onOffset(20.0);
      InvCleaner var1 = Vape.instance.getModManager().getMod(InvCleaner.class);
      FrameComponent var2 = new FrameComponent(false);
      var2.onRendererHandling(new PoseRenderer(0.0, 3.0, 5000, 1, new PoseMatrix(0, 2, 2, 2)));
      var2.setWidth(this.getWidth());
      this.addGuiComponent(var2);
      double var3 = var2.getWidth() - 8.0;
      var2.addComponent(new ModButton(Vape.instance.getModManager().getMod(InvCleaner.class))).setWidth(var3);
      TextComponent var5 = new TextComponent(64);
      var5.setWidth(var3);
      var5.onOffset(12.0);
      var5.c7057("<item name>");
      var2.addComponent(var5);
      NumberComponent var6 = new NumberComponent(10.0, 1.0, "", " stacks", "Allowed Stacks");
      var6.c8030(1.0);
      var6.setWidth(var3);
      var6.onOffset(8.0);
      var2.addComponent(var6);
      FrameComponent var7 = new FrameComponent(false);
      var7.c7363(false);
      var7.setColor(hoveringColor);
      var7.onRendererHandling(new PoseRenderer(2.0, 0.0, 1, 2, new PoseMatrix(0, 0, 0, 0)));
      var7.setWidth(var3);
      var2.addComponent(var7);
      SquareButton var8 = new SquareButton("Whitelist", true);
      var8.setWidth(var7.getWidth() / 2.0);
      var8.onOffset(12.0);
      var8.getGuiButton().c7363(false);
      var8.setText("Allow the item to be in your inventory.\nIt will only drop if it exceeds the allowed stack limits.");
      //todo var8.c862(new iReSqtkUVgEyMiReSqtkUVg(this, var5, var1, var6));
      var7.addComponent(var8);
      SquareButton var9 = new SquareButton("Blacklist", true);
      var9.setWidth(var7.getWidth() / 2.0 - 2.0);
      var9.onOffset(12.0);
      var9.getGuiButton().c7363(false);
      var9.setText("Always remove this item from your inventory,\nregardless of item stacks");
      var9.addAction(new c7971(this, var5, var1));
      var7.addComponent(var9);
      this.c4145 = new SliderInFrame(false);
      this.c4145.onOffset(80.0);
      this.c4145.setWidth(var3 - 2.0);
      this.addGuiComponent(this.c4145);
      this.c4412 = new IntractiveComponent("", RenderFlag.Centered, 0.8);
      this.c4412.setWidth(var3);
      this.c4412.onOffset(15.0);
      this.c4412.setDisplayable(false);
      this.addGuiComponent(this.c4412);
   }

   class c7971 implements IButtonOnClick {
      // $FF: synthetic field
      final TextComponent c1944;
      // $FF: synthetic field
      final InvCleaner c6992;
      // $FF: synthetic field
      final FrameInvCleaner c8144;

      c7971(FrameInvCleaner var1, TextComponent var2, InvCleaner var3) {
         this.c8144 = var1;
         this.c1944 = var2;
         this.c6992 = var3;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         String var4 = this.c1944.c8589().getName();
         if (!this.c6992.c3647().c8634(var4) && !this.c6992.c5241().c8634(var4)) {
            this.c1944.c8589().setName("");
            this.c6992.c5241().c200(var4, -1);
         } else {
            FrameInvCleaner.c2468(this.c8144).reset();
            FrameInvCleaner.c4501(this.c8144).setName("This item already exists.");
         }
      }
   }
   public void draw() {
      super.draw();
      if (this.c4412.displayable() && this.c3233.hasTimeElapsed(2000L)) {
         this.c4412.setName("");
         this.c3233.reset();
      }

      this.c4412.setDisplayable(!this.c4412.getName().isEmpty());

   }

   public void c4925(ItemLimitData var1) {
      double var2 = this.getWidth() - 24.0;
      FrameComponent var4 = new FrameComponent(false);
      var4.setWidth(var2);
      var4.onRendererHandling(new PoseRenderer(1.0, 1.0, 2, 2, new PoseMatrix(0, 2, 0, 0)));
      this.c4145.c8120(var4);
   }

   public void c354(ItemLimitData var1) {
      IGuiComponent var2 = null;
      Iterator var3 = this.c4145.c6047().getComponents().iterator();

      while(true) {
         while(true) {
            IGuiComponent var4;
            do {
               if (!var3.hasNext()) {
                  if (var2 != null) {
                     this.c4145.c6047().c4043(var2);
                  }

                  return;
               }

               var4 = (IGuiComponent)var3.next();
            } while(!(var4 instanceof FrameComponent));

            FrameComponent var5 = (FrameComponent)var4;
            Iterator var6 = var5.getComponents().iterator();

            while(var6.hasNext()) {
               IGuiComponent var7 = (IGuiComponent)var6.next();
               if (var7 instanceof FrameLimitManager) {
                  FrameLimitManager var8 = (FrameLimitManager)var7;
                  if (var8.c1507().equals(var1) || var8.c1507().getName().equalsIgnoreCase(var1.getName())) {
                     var2 = var4;
                     break;
                  }
               }
            }
         }
      }
   }

   // $FF: synthetic method
   static TimerUtil c2468(FrameInvCleaner var0) {
      return var0.c3233;
   }

   // $FF: synthetic method
   static IntractiveComponent c4501(FrameInvCleaner var0) {
      return var0.c4412;
   }
}
