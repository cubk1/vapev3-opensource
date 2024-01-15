package gg.vape.ui.click.frame.impl;

import gg.vape.Vape;
import gg.vape.friend.Friend;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.value.TextComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.ui.unmap.SliderInFrame;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;

import java.util.function.Consumer;

public class FrameFriends extends Frame {
   public static final double c4988 = 20.0;
   public static final double c2920 = 18.0;
   public final SliderInFrame c1814;
   public final FrameComponent c5689;
   public final FrameComponent c3671;
   public final TextComponent c3819;
   public final SquareButton c2227;

   public FrameFriends() {
      super("Friends", false);
      this.getFramePage().onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      FrameComponent var1 = new FrameComponent(false);
      var1.onRendererHandling(new PoseRenderer(0.0, 3.0, 5000, 1, new PoseMatrix(0, 2, 2, 2)));
      var1.setWidth(125.0);
      this.addGuiComponent(var1);
      this.c5689 = new FrameComponent(false);
      this.c5689.onRendererHandling(new PoseRenderer(0.0, 1.0, 5000, 1, new PoseMatrix(2, 0, 1, 0)));
      this.c5689.addComponent(Vape.instance.getFriendManager().friendsColor.getComponent());
      this.c5689.addComponent(Vape.instance.getFriendManager().useColor.getComponent());
      this.c5689.addComponent(Vape.instance.getFriendManager().useFriends.getComponent());
      this.c5689.addComponent(Vape.instance.getFriendManager().useAlias.getComponent());
      this.c5689.addComponent(Vape.instance.getFriendManager().forceAlias.getComponent());
      var1.addComponent(this.c5689);
      this.c3671 = new c8643(this, false);
      this.c2227 = new SquareButton("Add", false);
      this.c2227.onOffset(12.0);
      this.c2227.setWidth(20.0);
      this.c2227.addAction(new c3140(this));
      this.c3819 = new c2108(this, 33);
      this.c3819.onOffset(12.0);
      this.c3819.c7057("<username> [alias]");
      this.c3671.onRendererHandling(new PoseRenderer(1.0, 1.0, 1, 2, new PoseMatrix(0, 0, 1, 0)));
      this.c3671.addComponent(this.c3819);
      this.c3671.addComponent(this.c2227);
      var1.addComponent(this.c3671);
      this.c1814 = new SliderInFrame(false);
      this.c1814.onOffset(130.0);
      var1.addComponent(this.c1814);
      this.setWidth(125.0);
      this.onOffset(20.0);
   }
   class c2108 extends TextComponent {
      // $FF: synthetic field
      final FrameFriends c7241;

      c2108(FrameFriends var1, int var2) {
         super(var2);
         this.c7241 = var1;
      }

      public boolean c3210(char var1, int var2) {
         if (this.isEditing() && var2 == 28) {
            FrameFriends.c886(this.c7241).getClickEvent().onClick(0, 0, 0);
            return true;
         } else {
            return super.c3210(var1, var2);
         }
      }
   }

   class c3140 implements IButtonOnClick {
      // $FF: synthetic field
      final FrameFriends c3635;

      c3140(FrameFriends var1) {
         this.c3635 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         String var4 = FrameFriends.c4908(this.c3635).c8589().getName();
         if (!var4.isEmpty()) {
            String[] var5 = var4.split(" ");
            if (var4.contains(":")) {
               var5 = var4.split(":");
            }

            var4 = var5[0];
            String var6 = var5.length > 1 ? var5[1] : var5[0];
            FrameFriends.c4908(this.c3635).c8589().setName("");
            Friend var7 = Vape.instance.getFriendManager().c2989(var4);
            if (var7 != null) {
               Vape.instance.getFriendManager().c2616(var7);
            }

            var7 = new Friend(var4, var6);
            Vape.instance.getFriendManager().c8533(var7);
         }
      }
   }
   class c8643 extends FrameComponent {
      // $FF: synthetic field
      final FrameFriends c8031;

      c8643(FrameFriends var1, boolean var2) {
         super(var2);
         this.c8031 = var1;
      }

      public double getHeight() {
         return super.getHeight() + 2.0;
      }
   }

   public void setWidth(double var1) {
      super.setWidth(var1);
      double var3 = var1 - 9.0;
      this.c8669(this.getFramePage(), new c5434(this, var3));
      this.c3819.setWidth(var3 - 20.0);
      this.c2227.setWidth(20.0);

      for (IGuiComponent var6 : this.c1814.c6047().getComponents()) {
         FrameComponent var7 = (FrameComponent) var6;
         IGuiComponent var8 = var7.getComponents().get(0);
         IGuiComponent var9 = var7.getComponents().get(1);
         var8.setWidth(var3 - 18.0 - 5.0);
         var9.setWidth(18.0);
      }

   }
   class c5434 implements Consumer {
      // $FF: synthetic field
      final double c2458;
      // $FF: synthetic field
      final FrameFriends c7078;

      c5434(FrameFriends var1, double var2) {
         this.c7078 = var1;
         this.c2458 = var2;
      }

      public void c3481(IGuiComponent var1) {
         var1.setWidth(this.c2458);
      }

      // $FF: synthetic method
      public void accept(Object var1) {
         this.c3481((IGuiComponent)var1);
      }
   }

   public void c3423(Friend var1) {
      FrameComponent var2 = new FrameComponent(false);
      var2.setWidth(this.getWidth() - 28.0);
      var2.onRendererHandling(new PoseRenderer(1.0, 1.0, 2, 2, new PoseMatrix(0, 2, 0, 0)));
      new FrameFriend(var2, var1);
      this.c1814.c8120(var2);
   }

   public void c7057(String var1) {
      FrameComponent var2 = null;
      FrameComponent var3 = this.c1814.c6047();
      String var4 = null;

      for (IGuiComponent var6 : var3.getComponents()) {
         FrameComponent var7 = (FrameComponent) var6;
         FrameFriend var8 = (FrameFriend) var7.getComponents().get(0);
         var4 = var8.c4393();
         if (var4.equals(var1)) {
            var2 = var7;
            break;
         }
      }

      if (var2 != null) {
         Vape.instance.getFriendManager().getFriends().remove(var4);
         var3.c4043(var2);
      }

   }

   // $FF: synthetic method
   static TextComponent c4908(FrameFriends var0) {
      return var0.c3819;
   }

   // $FF: synthetic method
   static SquareButton c886(FrameFriends var0) {
      return var0.c2227;
   }
}
