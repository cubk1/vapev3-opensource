package gg.vape.ui.click.frame.impl;

import gg.vape.Vape;
import gg.vape.module.Macro;
import gg.vape.module.macro.BaseMacroImpl;
import gg.vape.module.macro.RodMacro;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.component.value.RandomComponent;
import gg.vape.ui.click.component.value.TextComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.ui.unmap.SliderInFrame;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;

import java.util.Iterator;
import java.util.function.Consumer;

public class FrameMacros extends Frame {
   public static final double c2381 = 20.0;
   public FrameComponent c7648;
   public TextComponent c957;
   public SquareButton c1388;
   public FrameComponent c5682;
   public FrameComponent c3519;
   public FrameComponent c8044;
   public FrameComponent c4279;
   public SliderInFrame c8721;
   public Macro c6973 = null;
   public Macro c7835 = null;
   public boolean c6398 = false;
   public boolean c8487 = false;

   public FrameMacros() {
      super("Macros", false);
      this.getFramePage().onRendererHandling(new PoseRenderer(0.0, 0.0, 4, 1, new PoseMatrix(0, 0, 0, 0)));
      FrameComponent var1 = new FrameComponent(false);
      var1.onRendererHandling(new PoseRenderer(0.0, 3.0, 5000, 1, new PoseMatrix(0, 2, 2, 2)));
      var1.setWidth(125.0);
      this.addGuiComponent(var1);
      this.c4827(var1);
      this.c7997(var1);
      this.c364(var1);
      this.setWidth(100.0);
      this.onOffset(20.0);
   }

   class c4291 implements IButtonOnClick {
      // $FF: synthetic field
      final FrameMacros c8578;

      c4291(FrameMacros var1) {
         this.c8578 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         String var4 = FrameMacros.c4171(this.c8578).c8589().getName();
         if (!var4.isEmpty() && Vape.instance.getMacrosManager().c3590(var4) == null) {
            FrameMacros.c4171(this.c8578).c8589().setName("");
            if (var4.startsWith("/")) {
               FrameMacros.c7104(this.c8578, new BaseMacroImpl(var4));
            }

            if (var4.equalsIgnoreCase("fishing rod")) {
               FrameMacros.c8921(this.c8578, new RodMacro(var4));
               FrameMacros.c2940(this.c8578, true);
            } else {
               FrameMacros.c8921(this.c8578, new Macro(var4));
               FrameMacros.c2940(this.c8578, true);
            }

         }
      }
   }
   class c7297 extends TextComponent {
      // $FF: synthetic field
      final FrameMacros c6671;

      c7297(FrameMacros var1, int var2) {
         super(var2);
         this.c6671 = var1;
      }

      public boolean c3210(char var1, int var2) {
         if (this.isEditing() && var2 == 28) {
            FrameMacros.c5784(this.c6671).getClickEvent().onClick(0, 0, 0);
            return true;
         } else {
            return super.c3210(var1, var2);
         }
      }
   }
   class c6910 implements IGuiCallback {
      // $FF: synthetic field
      final FrameMacros c1001;

      c6910(FrameMacros var1) {
         this.c1001 = var1;
      }

      public void call(IGuiComponent inst) {
         FrameMacros.c3641(this.c1001).setDisplayable(FrameMacros.c2315(this.c1001) == null && FrameMacros.c6079(this.c1001) == null);
      }
   }

   public void c4827(FrameComponent var1) {
      this.c5682 = new FrameComponent(false);
      this.c5682.onRendererHandling(new PoseRenderer(0.0, 2.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      this.c5682.onOffset(70.0);
      this.c7648 = new FrameComponent(false);
      this.c7648.onRendererHandling(new PoseRenderer(0.0, 0.0, 1, 2, new PoseMatrix(0, 0, 0, 0)));
      this.c1388 = new SquareButton("Add", false);
      this.c1388.onOffset(12.0);
      this.c1388.setWidth(20.0);
      this.c1388.addAction(new c4291(this));
      this.c957 = new c7297(this, 16);
      this.c957.onOffset(12.0);
      this.c957.c7057("<item name>");
      this.c7648.addComponent(this.c957);
      this.c7648.addComponent(this.c1388);
      this.c8721 = new SliderInFrame(false);
      this.c8721.onOffset(130.0);
      this.c5682.addComponent(this.c7648);
      this.c5682.addComponent(this.c8721);
      this.c5682.addAction(new c6910(this));
      var1.addComponent(this.c5682);
   }
   class c7990 implements IGuiCallback {
      // $FF: synthetic field
      final FrameMacros c4850;

      c7990(FrameMacros var1) {
         this.c4850 = var1;
      }

      public void call(IGuiComponent inst) {
         FrameMacros.c931(this.c4850).setDisplayable(FrameMacros.c6079(this.c4850) != null);
      }
   }

   class c3037 implements IGuiCallback {
      // $FF: synthetic field
      final FrameMacros c3937;

      c3037(FrameMacros var1) {
         this.c3937 = var1;
      }

      public void call(IGuiComponent inst) {
         if (FrameMacros.c2845(this.c3937) && FrameMacros.c2315(this.c3937) != null) {
            FrameMacros.c2940(this.c3937, false);
            FrameMacros.c1325(this.c3937).getComponents().clear();
            FrameMacros.c1325(this.c3937).setDisplayable(!(FrameMacros.c2315(this.c3937) instanceof BaseMacroImpl));

            FrameMacros.c1325(this.c3937).addComponent(FrameMacros.c2315(this.c3937).c2102().getComponent());
            FrameMacros.c1325(this.c3937).addComponent(FrameMacros.c2315(this.c3937).c2906().getComponent());
            FrameMacros.c1325(this.c3937).addComponent(FrameMacros.c2315(this.c3937).c6968().getComponent());
            Iterator var2 = FrameMacros.c1325(this.c3937).getComponents().iterator();

            while(var2.hasNext()) {
               IGuiComponent var3 = (IGuiComponent)var2.next();
               var3.setWidth(FrameMacros.c1325(this.c3937).getWidth());
               if (var3 instanceof RandomComponent) {
                  var3.onOffset(6.0);
               } else {
                  var3.onOffset(10.0);
               }
            }
         }

      }
   }


   public void c7997(FrameComponent var1) {
      this.c4279 = new FrameComponent(false);
      this.c4279.onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      this.c4279.onOffset(70.0);
      IntractiveComponent var2 = new IntractiveComponent("Press a key", RenderFlag.Centered, 1.0);
      var2.setWidth(50.0);
      var2.onOffset(10.0);
      this.c4279.addComponent(var2);
      this.c4279.addAction(new c7990(this));
      var1.addComponent(this.c4279);
   }

   public void c364(FrameComponent var1) {
      this.c3519 = new FrameComponent(false);
      this.c3519.onRendererHandling(new PoseRenderer(0.0, 2.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      this.c3519.onOffset(70.0);
      this.c8044 = new FrameComponent(false);
      this.c8044.onRendererHandling(new PoseRenderer(0.0, 2.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      this.c8044.onOffset(70.0);
      this.c8044.addAction(new c3037(this));
      IntractiveComponent var2 = new IntractiveComponent("<macro name>", RenderFlag.Centered, 0.9);
      var2.setWidth(50.0);
      var2.onOffset(10.0);
      var2.addAction(new c7612(this, var2));
      SquareButton var3 = new SquareButton("Add", false);
      var3.setWidth(50.0);
      var3.onOffset(10.0);
      var3.addAction(new c1138(this));
      var3.addAction(new c427(this, var3));
      SquareButton var4 = new SquareButton("Cancel", false);
      var4.setWidth(50.0);
      var4.onOffset(10.0);
      var4.addAction(new c2640(this));
      SquareButton var5 = new SquareButton("Delete Macro", false);
      var5.setWidth(50.0);
      var5.onOffset(10.0);
      var5.addAction(new c692(this));
      var5.addAction(new c1377(this, var5));
      this.c3519.addComponent(var2);
      this.c3519.addComponent(this.c8044);
      this.c3519.addComponent(var3);
      this.c3519.addComponent(var4);
      this.c3519.addComponent(var5);
      this.c3519.addAction(new c373(this));
      var1.addComponent(this.c3519);
   }
   class c7612 implements IGuiCallback {
      // $FF: synthetic field
      final IntractiveComponent c8883;
      // $FF: synthetic field
      final FrameMacros c6499;

      c7612(FrameMacros var1, IntractiveComponent var2) {
         this.c6499 = var1;
         this.c8883 = var2;
      }

      public void call(IGuiComponent inst) {
         if (FrameMacros.c2315(this.c6499) != null) {
            this.c8883.setName(FrameMacros.c2315(this.c6499).c3731());
         } else {
            this.c8883.setName("N/A");
         }

      }
   }
   class c1138 implements IButtonOnClick {
      // $FF: synthetic field
      final FrameMacros c1230;

      c1138(FrameMacros var1) {
         this.c1230 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (FrameMacros.c2315(this.c1230) != null) {
            if (FrameMacros.c5600(this.c1230)) {
               FrameMacros.c2643(this.c1230, false);
               FrameMacros.c8921(this.c1230, null);
            } else {
               FrameMacros.c2643(this.c1230, false);
               FrameMacros.c2940(this.c1230, false);
               FrameMacros.c7104(this.c1230, FrameMacros.c2315(this.c1230));
               FrameMacros.c8921(this.c1230, null);
            }

         }
      }
   }

   class c427 implements IGuiCallback {
      // $FF: synthetic field
      final SquareButton c8757;
      // $FF: synthetic field
      final FrameMacros c8498;

      c427(FrameMacros var1, SquareButton var2) {
         this.c8498 = var1;
         this.c8757 = var2;
      }

      public void call(IGuiComponent inst) {
         if (FrameMacros.c5600(this.c8498)) {
            this.c8757.getGuiButton().setName("Update");
         } else {
            this.c8757.getGuiButton().setName("Add");
         }

      }
   }

   class c2640 implements IButtonOnClick {
      // $FF: synthetic field
      final FrameMacros c1849;

      c2640(FrameMacros var1) {
         this.c1849 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         FrameMacros.c8921(this.c1849, null);
         FrameMacros.c2643(this.c1849, false);
      }
   }

   class c692 implements IButtonOnClick {
      // $FF: synthetic field
      final FrameMacros c7505;

      c692(FrameMacros var1) {
         this.c7505 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (FrameMacros.c2315(this.c7505) != null) {
            Vape.instance.getMacrosManager().c3000(FrameMacros.c2315(this.c7505));
            FrameMacros.c2643(this.c7505, false);
            FrameMacros.c8921(this.c7505, null);
         }
      }
   }

   class c1377 implements IGuiCallback {
      // $FF: synthetic field
      final SquareButton c866;
      // $FF: synthetic field
      final FrameMacros c293;

      c1377(FrameMacros var1, SquareButton var2) {
         this.c293 = var1;
         this.c866 = var2;
      }

      public void call(IGuiComponent inst) {
         this.c866.setDisplayable(FrameMacros.c5600(this.c293));
      }
   }

   class c373 implements IGuiCallback {
      // $FF: synthetic field
      final FrameMacros c5948;

      c373(FrameMacros var1) {
         this.c5948 = var1;
      }

      public void call(IGuiComponent inst) {
         FrameMacros.c1104(this.c5948).setDisplayable(FrameMacros.c2315(this.c5948) != null);
      }
   }

   class c1503 implements Consumer {
      // $FF: synthetic field
      final double c5134;
      // $FF: synthetic field
      final FrameMacros c2202;

      c1503(FrameMacros var1, double var2) {
         this.c2202 = var1;
         this.c5134 = var2;
      }

      public void c4373(IGuiComponent var1) {
         if (!var1.equals(this.c2202.getFramePage())) {
            var1.setWidth(this.c5134 - 8.0);
         }
      }

      // $FF: synthetic method
      public void accept(Object var1) {
         this.c4373((IGuiComponent)var1);
      }
   }

   public void setWidth(double var1) {
      super.setWidth(var1);
      this.c8669(this.getFramePage(), new c1503(this, var1));
      this.c957.setWidth(var1 - 8.0 - 20.0);
      this.c1388.setWidth(20.0);
   }

   public void c1396(Macro var1) {
      FrameComponent var2 = new FrameComponent(false);
      var2.setWidth(this.getWidth() - 16.0);
      var2.onRendererHandling(new PoseRenderer(1.0, 1.0, 2, 2, new PoseMatrix(0, 1, 0, 0)));
      new FrameMacrosEditor(var2, this, var1);
      this.c8721.c8120(var2);
   }

   public void c2756(Macro var1) {
      FrameComponent var2 = this.c8721.c6047();
      var2.c4043(var1.c7672());
   }

   public boolean c3210(char var1, int var2) {
      if (this.c7835 != null) {
         this.c7835.c6122(var2);
         Vape.instance.getMacrosManager().c1123(this.c7835);
         this.c7835 = null;
         return true;
      } else {
         return super.c3210(var1, var2);
      }
   }

   public boolean c4828(int var1, int var2, int var3) {
      if (this.c7835 != null) {
         this.c7835.c6122(-100 + var3);
         Vape.instance.getMacrosManager().c1123(this.c7835);
         this.c7835 = null;
         return true;
      } else {
         return super.c4828(var1, var2, var3);
      }
   }

   public void c5470(boolean var1) {
      this.c6398 = var1;
   }

   public void c2085(boolean var1) {
      this.c8487 = var1;
   }

   public void c5559(Macro var1) {
      this.c6973 = var1;
   }

   // $FF: synthetic method
   static TextComponent c4171(FrameMacros var0) {
      return var0.c957;
   }

   // $FF: synthetic method
   static Macro c7104(FrameMacros var0, Macro var1) {
      return var0.c7835 = var1;
   }

   // $FF: synthetic method
   static Macro c8921(FrameMacros var0, Macro var1) {
      return var0.c6973 = var1;
   }

   // $FF: synthetic method
   static boolean c2940(FrameMacros var0, boolean var1) {
      return var0.c8487 = var1;
   }

   // $FF: synthetic method
   static SquareButton c5784(FrameMacros var0) {
      return var0.c1388;
   }

   // $FF: synthetic method
   static Macro c2315(FrameMacros var0) {
      return var0.c6973;
   }

   // $FF: synthetic method
   static Macro c6079(FrameMacros var0) {
      return var0.c7835;
   }

   // $FF: synthetic method
   static FrameComponent c3641(FrameMacros var0) {
      return var0.c5682;
   }

   // $FF: synthetic method
   static FrameComponent c931(FrameMacros var0) {
      return var0.c4279;
   }

   // $FF: synthetic method
   static boolean c2845(FrameMacros var0) {
      return var0.c8487;
   }

   // $FF: synthetic method
   static FrameComponent c1325(FrameMacros var0) {
      return var0.c8044;
   }

   // $FF: synthetic method
   static boolean c5600(FrameMacros var0) {
      return var0.c6398;
   }

   // $FF: synthetic method
   static boolean c2643(FrameMacros var0, boolean var1) {
      return var0.c6398 = var1;
   }

   // $FF: synthetic method
   static FrameComponent c1104(FrameMacros var0) {
      return var0.c3519;
   }
}
