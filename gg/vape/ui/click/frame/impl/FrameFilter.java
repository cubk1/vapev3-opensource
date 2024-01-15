package gg.vape.ui.click.frame.impl;

import func.skidline.RectData;
import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.IGuiCompontHandler;
import gg.vape.ui.click.component.gui.ExpandableButton;
import gg.vape.ui.click.component.value.TextComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.unmap.ModButton;
import gg.vape.ui.unmap.SliderInFrame;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.wrapper.impl.Minecraft;
import org.lwjgl.input.Keyboard;

import java.util.*;

public class FrameFilter extends Frame {
   public final TextComponent c2994;
   public final SliderInFrame c4252;
   public String c8422 = "";
   public final Map c1972 = new HashMap();
   public final Map c1094 = new HashMap();

   public FrameFilter() {
      super("Filter", false);
      this.getFramePage().onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      FrameComponent var1 = new FrameComponent(false);
      var1.onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 2, new PoseMatrix(0, 0, 0, 0)));
      this.addGuiComponent(var1);
      ExpandableButton var2 = new ExpandableButton("magnify", 0.35F, 2.0F, 3.5F, true);
      var2.getGuiButton().c7363(false);
      var1.addComponent(var2);
      this.c2994 = new TextComponent(33);
      this.c2994.c7057("Search within GUI");
      var1.addComponent(this.c2994);
      this.setWidth(125.0);
      this.onOffset(20.0);
      this.c2994.onOffset(20.0);
      this.c2994.setWidth(150.0);
      this.c4252 = new SliderInFrame(false);
      this.addGuiComponent(this.c4252);
      this.c4252.setWidth(100.0);
      this.c4252.onOffset(130.0);
      var2.setWidth(15.0);
      var2.onOffset(20.0);
      this.c840(true);
   }

   public void renderFrame() {
      Iterator var1 = this.c1972.entrySet().iterator();

      while(var1.hasNext()) {
         Map.Entry var2 = (Map.Entry)var1.next();
         this.c4252.c6047().c4043((IGuiComponent)var2.getKey());
         GuiComponent var3 = (GuiComponent)var2.getKey();
         c925 var4 = (c925)var2.getValue();
         var4.c841().addComponent(var3);
         List var5 = var4.c841().getComponents();
         var5.clear();
         var5.addAll((Collection)this.c1094.get(var4.c841()));
         var3.c4446(var4.c7513());
         var1.remove();
      }

      this.c1972.clear();
      this.c1094.clear();
      this.c4252.c6047().c756();
   }
   class c925 {
      public final GuiComponent c6495;
      public final IGuiCompontHandler c6584;
      public final RectData c8606;

      c925(GuiComponent var1) {
         this.c6495 = var1;
         this.c6584 = var1.handler();
         this.c8606 = var1.c1607();
      }

      public GuiComponent c2066() {
         return this.c6495;
      }

      IGuiCompontHandler c841() {
         return this.c6584;
      }

      RectData c7513() {
         return this.c8606;
      }
   }


   public void c2207(GuiComponent var1) {
      if (!this.c1972.containsKey(var1)) {
         IGuiCompontHandler var2 = var1.handler();
         if (!this.c1094.containsKey(var2)) {
            this.c1094.put(var2, new ArrayList(var2.getComponents()));
         }

         this.c1972.put(var1, new c925(var1));
         var2.c4043(var1);
         var1.c4446(null);
         this.c4252.c8120(var1);
      }

   }

   public void render(boolean flag) {
      super.render(true);
      this.setCloseStatus(false);
      this.c1042((double)(Minecraft.c4912().getScaledWidth() / 2) - this.getWidth() / 2.0);
      this.c467(0.0);
      if (Keyboard.isKeyDown(29) && Keyboard.isKeyDown(33)) {
         this.c2994.setEditing(true);
      }

      String var2 = this.c2994.c7232().getName().toLowerCase();
      if (!var2.equals(this.c8422)) {
         this.renderFrame();
      }

      this.c8422 = var2;
      if (!var2.equals("")) {
         this.c4252.setDisplayable(true);
         Iterator var3 = Vape.instance.getModManager().collectMods().iterator();

         while(var3.hasNext()) {
            Mod var4 = (Mod)var3.next();
            String var5 = var4.getName().toLowerCase();
            if (var5.toLowerCase().contains(var2) && var4.getButton() != null) {
               ModButton var6 = var4.getButton();
               this.c2207(var6);
            }
         }
      } else {
         this.c4252.setDisplayable(false);
      }

   }
}
