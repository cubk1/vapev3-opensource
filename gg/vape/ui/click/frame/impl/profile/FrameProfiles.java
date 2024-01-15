package gg.vape.ui.click.frame.impl.profile;

import func.skidline.KeyBindRunner;
import gg.vape.Vape;
import gg.vape.config.Profile;
import gg.vape.config.PublicProfile;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.ExpandableButton;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.component.value.TextComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.ui.unmap.SliderInFrame;
import gg.vape.unmap.Bendable;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class FrameProfiles extends Frame {
   public static final double c7257 = 20.0;
   public static final double c3646 = 14.0;
   public static final double c2288 = 12.0;
   public final SliderInFrame c5996;
   public final TextComponent c1718;
   class c4804 extends FrameComponent {
      // $FF: synthetic field
      final FrameProfiles c7122;

      c4804(FrameProfiles var1, boolean var2) {
         super(var2);
         this.c7122 = var1;
      }

      public double getHeight() {
         return super.getHeight() + 2.0;
      }
   }
   class c575 implements IButtonOnClick {
      // $FF: synthetic field
      final FrameProfiles c912;

      c575(FrameProfiles var1) {
         this.c912 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         String var4 = FrameProfiles.c6061(this.c912).c8589().getName();
         if (!var4.isEmpty()) {
            Profile var5 = Vape.instance.getProfilesManager().c5972(var4);
            if (var5 == null) {
               FrameProfiles.c6061(this.c912).c8589().setName("");
               var5 = new Profile(var4, "3.25");
               var5.c5864();
               Vape.instance.getProfilesManager().c2321(var5);
            }
         }
      }
   }
   class c4543 extends TextComponent {
      // $FF: synthetic field
      final SquareButton c2575;
      // $FF: synthetic field
      final FrameProfiles c3405;

      c4543(FrameProfiles var1, int var2, SquareButton var3) {
         super(var2);
         this.c3405 = var1;
         this.c2575 = var3;
      }

      public boolean c3210(char var1, int var2) {
         if (this.isEditing() && var2 == 28) {
            this.c2575.getClickEvent().onClick(0, 0, 0);
            return true;
         } else {
            return super.c3210(var1, var2);
         }
      }
   }
   class c6372 implements IButtonOnClick {
      // $FF: synthetic field
      final FrameProfiles c5690;

      c6372(FrameProfiles var1) {
         this.c5690 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         ClickGui.c6033(null);
         Vape.instance.getModManager().getMod(ClickGui.class).c6601();
      }
   }

   public FrameProfiles() {
      super("Profiles", false);
      this.getFramePage().onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      FrameComponent var1 = new FrameComponent(false);
      var1.onRendererHandling(new PoseRenderer(0.0, 3.0, 5000, 1, new PoseMatrix(0, 2, 2, 2)));
      var1.setWidth(120.0);
      this.addGuiComponent(var1);
      c4804 var2 = new c4804(this, false);
      SquareButton var3 = new SquareButton("Add", false);
      var3.onOffset(12.0);
      var3.setWidth(20.0);
      var3.addAction(new c575(this));
      this.c1718 = new c4543(this, 16, var3);
      this.c1718.onOffset(12.0);
      this.c1718.c7057("<name>");
      ExpandableButton var4 = new ExpandableButton("world", 0.3F, 1.0F, 1.0F);
      var4.setText("Open public profiles");
      var4.onOffset(12.0);
      var4.setWidth(12.0);
      var4.addAction(new c6372(this));
      var2.onRendererHandling(new PoseRenderer(1.0, 0.0, 1, 3, new PoseMatrix(0, 0, 0, 0)));
      var2.addComponent(var4);
      var2.addComponent(this.c1718);
      var2.addComponent(var3);
      var1.addComponent(var2);
      this.c5996 = new SliderInFrame(false);
      this.c5996.onOffset(150.0);
      var1.addComponent(this.c5996);
      this.setWidth(120.0);
      this.onOffset(20.0);
      this.c7694().setText("Hold SHIFT and RIGHT CLICK a profile button to save the state of currently enabled modules.\nRIGHT CLICK to enable those modules again.");
   }

   public void setWidth(double var1) {
      super.setWidth(var1);
      var1 -= 12.0;
      double var3 = var1 - 10.0;
      double var5 = var1 - 14.0;
      this.c5996.setWidth(var3);
      this.c1718.setWidth(var3 - 20.0);
      Iterator var7 = this.c5996.c6047().getComponents().iterator();

      while(var7.hasNext()) {
         IGuiComponent var8 = (IGuiComponent)var7.next();
         FrameComponent var9 = (FrameComponent)var8;
         IGuiComponent var10 = var9.getComponents().get(0);
         IGuiComponent var11 = var9.getComponents().get(1);
         var10.setWidth(var5 - 14.0 - 5.0 - 20.0);
         var11.setWidth(-6.0);
      }

   }
   class c3630 extends KeyBindRunner {
      // $FF: synthetic field
      final Profile c7706;
      // $FF: synthetic field
      final FrameProfiles c2206;

      c3630(FrameProfiles var1, Bendable var2, IGuiComponent var3, Profile var4) {
         super(var2, var3);
         this.c2206 = var1;
         this.c7706 = var4;
      }

      public void c8071() {
         this.c7213(this.c7706.c1754());
      }
   }
   class c2101 implements IButtonOnClick {
      // $FF: synthetic field
      final Profile c615;
      // $FF: synthetic field
      final FrameProfiles c5919;

      c2101(FrameProfiles var1, Profile var2) {
         this.c5919 = var1;
         this.c615 = var2;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (Vape.instance.getProfilesManager().c6161().size() != 1) {
            if (!(this.c615 instanceof PublicProfile) || !((PublicProfile)this.c615).c2239()) {
               Vape.instance.getProfilesManager().c7522(this.c615);
               ClickGui.c6033(null);
            }
         }
      }
   }

   public void c7644(Profile var1) {
      String var2 = var1.c1754();
      AtomicBoolean var3 = new AtomicBoolean(false);
      FrameComponent var4 = new FrameComponent(false);
      var4.onRendererHandling(new PoseRenderer(0.0, 0.0, 1, 2, new PoseMatrix(0, 2, 0, 0)));
      c3630 var5 = new c3630(this, var1, var4, var1);
      c2281 var6 = new c2281(this, var2, RenderFlag.Regular, 1.0, var5, var3, var1, var2);
      var6.onOffset(12.0);
      var6.setWidth(this.getWidth() - 14.0 - 5.0 - 10.0);
      var4.addComponent(var6);
      SquareButton var7 = new SquareButton("x", false);
      var7.onOffset(12.0);
      var7.setWidth(14.0);
      var7.addAction(new c2101(this, var1));
      var4.addComponent(var7);
      if (var1 instanceof PublicProfile) {
         PublicProfile var8 = (PublicProfile)var1;
         if (var8.c2239()) {
            var4.setText("This profile is public!\nYou cannot remove this unless you\nunpublic the profile!");
         } else {
            var4.setText("You've downloaded this profile!");
         }
      }

      this.c5996.c8120(var4);
      this.c5996.draw();
   }

   class c2281 extends IntractiveComponent {
      // $FF: synthetic field
      final KeyBindRunner c6723;
      // $FF: synthetic field
      final AtomicBoolean c5190;
      // $FF: synthetic field
      final Profile c4609;
      // $FF: synthetic field
      final String c2158;
      // $FF: synthetic field
      final FrameProfiles c921;

      c2281(FrameProfiles var1, String var2, int var3, double var4, KeyBindRunner var6, AtomicBoolean var7, Profile var8, String var9) {
         super(var2, var3, var4);
         this.c921 = var1;
         this.c6723 = var6;
         this.c5190 = var7;
         this.c4609 = var8;
         this.c2158 = var9;
      }

      public void draw() {
         super.draw();
         if (!this.c6723.c3709()) {
            if (Keyboard.isKeyDown(15)) {
               if (!this.c5190.get() && this.c4609.c3344()) {
                  this.setName(this.c4609.c407());
                  this.c2404(RenderFlag.Regular);
                  this.c5190.set(true);
               }
            } else if (this.c5190.get()) {
               this.c5190.set(false);
               this.setName(this.c4609.c1754());
               this.c2404(RenderFlag.Regular);
            }
         }

         if (Vape.instance.getProfilesManager().c7171().equals(this.c4609)) {
            this.c7363(true);
         } else {
            this.setColor(Color.WHITE);
            this.c7363(false);
         }

      }

      public boolean c4828(int var1, int var2, int var3) {
         if (this.isHovering()) {
            if (var3 != 1) {
               if (var3 == 0) {
                  if (Keyboard.isKeyDown(42)) {
                     this.c6723.run();
                  } else {
                     Vape.instance.getProfilesManager().c4349(this.c4609);
                  }
               }

               return true;
            } else {
               if (!this.c6723.c3709() && Keyboard.isKeyDown(42)) {
                  this.c4609.c4702();
                  FrameProfiles.c8686(this.c921, this, "Saved enabled", this.c2158, 1000L);
               } else {
                  this.c4609.c1703();
                  FrameProfiles.c8686(this.c921, this, "Loaded enabled", this.c2158, 1000L);
               }

               return true;
            }
         } else {
            return super.c4828(var1, var2, var3);
         }
      }
   }

   public void c1865(IntractiveComponent var1, String var2, String var3, long var4) {
      (new c4183(this, var1, var2, var4, var3)).start();
   }
   class c4183 extends Thread {
      // $FF: synthetic field
      final IntractiveComponent c5319;
      // $FF: synthetic field
      final String c7585;
      // $FF: synthetic field
      final long c3227;
      // $FF: synthetic field
      final String c7816;
      // $FF: synthetic field
      final FrameProfiles c5552;

      c4183(FrameProfiles var1, IntractiveComponent var2, String var3, long var4, String var6) {
         this.c5552 = var1;
         this.c5319 = var2;
         this.c7585 = var3;
         this.c3227 = var4;
         this.c7816 = var6;
      }

      public void run() {
         this.c5319.setName(this.c7585);

         try {
            Thread.sleep(this.c3227);
         } catch (InterruptedException var2) {
            var2.printStackTrace();
         }

         this.c5319.setName(this.c7816);
      }
   }
   public void c7057(String var1) {
      FrameComponent var2 = null;
      FrameComponent var3 = this.c5996.c6047();
      String var4 = null;
      Iterator var5 = var3.getComponents().iterator();

      while(var5.hasNext()) {
         IGuiComponent var6 = (IGuiComponent)var5.next();
         FrameComponent var7 = (FrameComponent)var6;
         IntractiveComponent var8 = (IntractiveComponent)var7.getComponents().get(0);
         var4 = var8.c7304();
         if (var4.equals(var1)) {
            var2 = var7;
            break;
         }
      }

      if (var2 != null) {
         Vape.instance.getProfilesManager().c6161().remove(var4);
         var3.c4043(var2);
      }

   }

   // $FF: synthetic method
   static TextComponent c6061(FrameProfiles var0) {
      return var0.c1718;
   }

   // $FF: synthetic method
   static void c8686(FrameProfiles var0, IntractiveComponent var1, String var2, String var3, long var4) {
      var0.c1865(var1, var2, var3, var4);
   }
}
