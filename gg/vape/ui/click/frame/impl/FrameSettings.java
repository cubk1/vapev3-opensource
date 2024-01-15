package gg.vape.ui.click.frame.impl;

import func.skidline.c7721;
import gg.vape.Vape;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.unmap.ModButton;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.value.Value;
import gg.vape.wrapper.impl.Minecraft;
import pub.nextsense.Tweaker;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FrameSettings extends Frame {
   public boolean c482;
   public long c4986 = 0L;
   public final c7721 c7054;

   class c2574 implements IButtonOnClick {
      // $FF: synthetic field
      final FrameSettings c6030;

      c2574(FrameSettings var1) {
         this.c6030 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         Iterator var4 = Vape.instance.getModManager().collectMods().iterator();

         while(var4.hasNext()) {
            Mod var5 = (Mod)var4.next();
            if (var5.getCategory() != Category.None && var5.getState()) {
               var5.setState(false);
            }

            var5.c8399().clear();
            if (var5.c5136() != 0) {
               var5.c8399().add(var5.c5136());
            }

            if (var5.getButton() != null && var5.getButton().c5615() != null) {
               var5.getButton().c5615().c8121(var5.available());
            }

            for (Value value : var5.getValues()) {
               if (value.c1672() != null) {
                  value.setValue(value.c1672());
               }
            }
         }

         var4 = Vape.instance.getValueManager().getValues().iterator();

         while(var4.hasNext()) {
            Value var8 = (Value)var4.next();
            if (var8.c1672() != null) {
               var8.setValue(var8.c1672());
            }
         }

      }
   }
   class c6123 implements IButtonOnClick {
      // $FF: synthetic field
      final FrameSettings c3631;

      c6123(FrameSettings var1) {
         this.c3631 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         Vape.instance.getFrameManager().c4309();
      }
   }

   class c8337 implements Comparator {
      // $FF: synthetic field
      final c6324 c1256;

      c8337(c6324 var1) {
         this.c1256 = var1;
      }

      public int c8522(Frame var1, Frame var2) {
         if (var1.getHeight() == var2.getHeight()) {
            return 0;
         } else {
            return var1.getHeight() > var2.getHeight() ? -1 : 1;
         }
      }

      // $FF: synthetic method
      public int compare(Object var1, Object var2) {
         return this.c8522((Frame)var1, (Frame)var2);
      }
   }

   class c6324 implements IButtonOnClick {
      // $FF: synthetic field
      final ClickGui c6361;
      // $FF: synthetic field
      final FrameSettings c7252;

      c6324(FrameSettings var1, ClickGui var2) {
         this.c7252 = var1;
         this.c6361 = var2;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (mouseBn == 0) {
            List var4 = this.c6361.getMods();
            var4.sort(new c8337(this));
            double var5 = 2.0;
            double var7 = 20.0;
            double var9 = 0.0;
            Iterator var11 = var4.iterator();

            while(var11.hasNext()) {
               Frame var12 = (Frame)var11.next();
               if (!var12.c4546() && var12.displayable()) {
                  if (var5 + var12.getWidth() > (double) Minecraft.c4912().getScaledWidth()) {
                     var5 = 2.0;
                     var7 += var9 + 2.0;
                     var9 = 0.0;
                  }

                  if (var12.getHeight() > var9) {
                     var9 = var12.getHeight();
                  }

                  var12.c1042(var5);
                  var12.c467(var7);
                  var5 += var12.getWidth() + 2.0;
               }
            }
         }

      }
   }
   public FrameSettings() {
      super("Settings", false);
      this.getFramePage().onRendererHandling(new PoseRenderer(0.0, 1.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      this.c7054 = new FrameComponent(false);
      this.c7054.onRendererHandling(new PoseRenderer(0.0, 1.0, 5000, 1, new PoseMatrix(0, 2, 0, 2)));
      ClickGui guiMod = Vape.instance.getModManager().getMod(ClickGui.class);
      ModButton ModBN = new ModButton(guiMod);
      ModBN.setWidth(82.0);
      ModBN.onOffset(12.0);
      SquareButton var3 = new SquareButton("Reset Profile", false);
      var3.addAction(new c2574(this));
      var3.setText("This will set your current profile to\nthe default settings of Vape");
      var3.onOffset(10.0);
      SquareButton var4 = new SquareButton("Reset GUI", false);
      var4.addAction(new c6123(this));
      var4.setText("This will reset your GUI back to the default");
      var4.onOffset(10.0);
      SquareButton var5 = new SquareButton("Sort", false);
      var5.addAction(new c6324(this, guiMod));
      var5.setText("Sorts GUI by size");
      var5.onOffset(10.0);
      SquareButton var6 = new SquareButton("Edit", false);
      var6.addAction((x,y,b)->{
         if(b == 0){
            guiMod.setEditState(!guiMod.getEditState());
         }
      });
      var6.setText("Check this to enable or disable the visibility of modules included in the GUI");
      var6.onOffset(10.0);
      ModBN.addSubComponent(var3);
      ModBN.addSubComponent(var4);
      ModBN.addSubComponent(var5);
      ModBN.addSubComponent(var6);
      ModBN.addSubComponent(guiMod.big_logo.getComponent());
      ModBN.addSubComponent(guiMod.logoMode.getComponent());
      ModBN.addSubComponent(guiMod.blur.getComponent());
      ModBN.addSubComponent(guiMod.radius.getComponent());
      ModBN.addSubComponent(guiMod.reScale.getComponent());
      ModBN.addSubComponent(guiMod.multiKeybinding.getComponent());
      ModBN.addSubComponent(Vape.instance.needAutoLoad().autoLoadState.getComponent());
      //ModBN.addSubComponent(guiMod.editGui.getComponent());
      ModBN.addSubComponent(guiMod.guiBindIndicator.getComponent());

      for (Value<?, ?> value : guiMod.getValues()) {
         if (value.getComponent() != null) {
            ModBN.addSubComponent(value.getComponent());
         }
      }

      Vape.instance.getSettings().guiColor.getComponent().setWidth(82.0);
      this.c7054.setWidth(85.0);
      this.addGuiComponent(ModBN);
      IGuiComponent[] var10 = Vape.instance.getSettings().c3408();
      int var12 = var10.length;

      for(int var8 = 0; var8 < var12; ++var8) {
         IGuiComponent var9 = var10[var8];
         this.c7054.addComponent(var9);
      }

      SquareButton syncButton = Vape.instance.getSettings().syncSettingsButton;
      syncButton.onOffset(15.0);
      syncButton.setText("Save your settings");
      syncButton.addAction(new c2428(this));
      syncButton.setText("Saves your profiles to the cloud.\nClick this every time you change your settings.");
      syncButton.addAction(new c7194(this, syncButton));
      this.addGuiComponent(this.c7054);
      this.addGuiComponent(syncButton);
      SquareButton reloadButton = new SquareButton("Reload", true);
      reloadButton.addAction(new ActionReload(this));
      reloadButton.onOffset(15.0);
      reloadButton.setWidth(this.getWidth());
      this.addGuiComponent(reloadButton);
      SquareButton reloadGuiButton = new SquareButton("Reload GUI", true);
      reloadGuiButton.addAction(new ActionReloadGUI(this));
      reloadGuiButton.onOffset(15.0);
      reloadGuiButton.setWidth(this.getWidth());
      this.addGuiComponent(reloadGuiButton);
      this.setWidth(90.0);
      this.onOffset(20.0);
   }
   class c6211 implements IGuiCallback {
      // $FF: synthetic field
      final SquareButton c2958;
      // $FF: synthetic field
      final FrameSettings c715;

      c6211(FrameSettings var1, SquareButton var2) {
         this.c715 = var1;
         this.c2958 = var2;
      }

      public void call(IGuiComponent inst) {
         this.c2958.setDisplayable(false);
      }
   }

   class ActionReloadGUI implements IButtonOnClick {
      // $FF: synthetic field
      final FrameSettings c3931;

      ActionReloadGUI(FrameSettings var1) {
         this.c3931 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (mouseBn == 0) {
            Vape.instance.reloadGui();
         }

      }
   }

   class c1741 implements IGuiCallback {
      // $FF: synthetic field
      final SquareButton c3802;
      // $FF: synthetic field
      final FrameSettings c5138;

      c1741(FrameSettings var1, SquareButton var2) {
         this.c5138 = var1;
         this.c3802 = var2;
      }

      public void call(IGuiComponent inst) {
         this.c3802.setDisplayable(false);
      }
   }
   class ActionReload implements IButtonOnClick {
      // $FF: synthetic field
      final FrameSettings c7869;

      ActionReload(FrameSettings var1) {
         this.c7869 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (mouseBn == 0) {
            Tweaker.reload();
         }

      }
   }

   class c7194 implements IGuiCallback {
      // $FF: synthetic field
      final SquareButton c2506;
      // $FF: synthetic field
      final FrameSettings c1942;

      c7194(FrameSettings var1, SquareButton var2) {
         this.c1942 = var1;
         this.c2506 = var2;
      }

      public void call(IGuiComponent inst) {
         long var2 = FrameSettings.c5062(this.c1942) - System.currentTimeMillis();
         if (var2 > 0L) {
            if (var2 >= 57000L) {
               this.c2506.getGuiButton().setName("Saved!");
            } else {
               this.c2506.getGuiButton().setName("Wait " + var2 / 1000L + " second" + (var2 >= 1000L && var2 < 2000L ? "" : "s"));
            }
         } else {
            this.c2506.getGuiButton().setName("Sync Settings");
         }

      }
   }

   class c2428 implements IButtonOnClick {
      // $FF: synthetic field
      final FrameSettings c1809;

      c2428(FrameSettings var1) {
         this.c1809 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (System.currentTimeMillis() >= FrameSettings.c5062(this.c1809)) {
            Vape.instance.c6703();
            FrameSettings.c8612(this.c1809, System.currentTimeMillis() + 60000L);
         }
      }
   }

   public void c5470(boolean var1) {

      for (Frame frame : Vape.instance.getFrameManager().getFrames()) {
         frame.c3488().setColor(Vape.instance.getSettings().guiColor.getAsColor());
         if (frame instanceof FrameTextGUI) {
            if (!Vape.instance.getSettings().guiColor.rainbow()) {
               if (this.c482) {
                  this.c482 = false;
               }
               continue;
            }

            this.c482 = true;
         }

         if (!var1 || frame.c30()) {
            frame.c6446(Vape.instance.getSettings().guiColor.getAsColor(), Vape.instance.getSettings().guiColor.rainbow());
         }
      }


   }

   public void setWidth(double var1) {
      super.setWidth(var1);
      Iterator var3 = this.getFramePage().getComponents().iterator();

      IGuiComponent var4;
      while(var3.hasNext()) {
         var4 = (IGuiComponent)var3.next();
         var4.setWidth(var1 - 4.0);
      }

      var3 = this.c7054.getComponents().iterator();

      while(var3.hasNext()) {
         var4 = (IGuiComponent)var3.next();
         var4.setWidth(var1 - 8.0);
      }

   }

   // $FF: synthetic method
   static long c5062(FrameSettings var0) {
      return var0.c4986;
   }

   // $FF: synthetic method
   static long c8612(FrameSettings var0, long var1) {
      return var0.c4986 = var1;
   }
}
