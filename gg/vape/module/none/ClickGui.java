package gg.vape.module.none;

import func.skidline.c4499;
import gg.vape.Vape;
import gg.vape.event.impl.EventTick;
import gg.vape.manager.FrameManager;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.actions.ActionToggleSmoothFont;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.component.value.BooleanComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.impl.FrameSettings;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.unmap.ModeSelection;
import gg.vape.utils.BlurBuffer;
import gg.vape.utils.render.ImageRenderer;
import gg.vape.utils.render.RenderUtils;
import gg.vape.value.*;
import gg.vape.wrapper.impl.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import pub.nextsense.Tweaker;
import pub.nextsense.common.d;
import pub.nextsense.common.iReSqtkUVgHIRiReSqtkUVg;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClickGui extends Mod {
   public static final int c5564 = 2;
   public static Color c3367;
   public static ShaderGroup c6021;
   public static IntractiveComponent c7880;
   public static GuiComponent c1724;
   public static final int c5654;
   public static boolean c313;
   public int c7974 = 0;

   public NumberValue radius = NumberValue.create(this, "Blur Radius", "#", "", 20.0, 20, 100,1);
   public BooleanValue blur = BooleanValue.create(this, "Blur Frame", true, "Blur the frame of the GUI");


   public BooleanValue reScale = BooleanValue.create(this, "Rescale", true, "Rescales the GUI");
   public BooleanValue multiKeybinding = BooleanValue.create(this, "Multi-Keybinding", false, "Allows you to set multiple keys to be held together\nto toggle modules");//public BooleanValue multiKeybinding = BooleanValue.create(this, "Enable Multi-Keybinding", false, "Allows you to set multiple keys to be held together\nto toggle modules");
   //public BooleanValue editGui = BooleanValue.create(this, "Edit GUI", false, "Check this to enable or disable the visibility of modules included in the GUI");
   public BooleanValue guiBindIndicator = BooleanValue.create(this, "GUI bind indicator", true, "Displays a message indicating your GUI keybind upon injecting.\nI.E. \"Press RSHIFT to open GUI\"");//public BooleanValue guiBindIndicator = BooleanValue.create(this, "GUI bind indicator", true, "Displays a message indicating your GUI keybind upon injecting.\nI.E. \"Press RSHIFT to open GUI\"");
   public BooleanValue smooth_font = BooleanValue.create(this, "Smooth font", true);

   public final ModeSelection logoVape = new ModeSelection("Vape");
   public final ModeSelection logoVapu = new ModeSelection("Vapu");
   public final ModeSelection logoRape = new ModeSelection("Rape");
   public final ModeValue logoMode = ModeValue.create(this, "Logo Mode",logoVape , logoVape,logoVapu,logoRape);;
   public BooleanValue big_logo = BooleanValue.create(this, "Logo", true);


   public boolean toolTip = true;
   public boolean c636 = false;
   public int scalef = -1;
   public static final List c4227;
   public boolean inEdit;
   public static boolean smoothFont;
   public static boolean c5438;
   public c4499 c2396;
   public c4499 c8168;
   public c4499 c5951;

   /*
   public class EditFunc implements IGuiCallback {
      // $FF: synthetic field
      final ClickGui c2980;

      public EditFunc(ClickGui var1) {
         this.c2980 = var1;
      }

      public void call(IGuiComponent inst) {
         ClickGui.c8689(this.c2980, ((BooleanComponent)this.c2980.editGui.getComponent()).getCheckBox().c2346());
      }
   }
   public class ActionEditGUI implements IButtonOnClick {
      // $FF: synthetic field
      final ClickGui c2603;

      public ActionEditGUI(ClickGui var1) {
         this.c2603 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (mouseBn == 0) {
            ((BooleanComponent)this.c2603.editGui.getComponent()).getCheckBox().toggle();
         }

      }
   }*/

   public ClickGui() {
      super("GUI", 54, 0, Category.None, "Shift click any module button to bind it to a key.\n(You can shift click this to bind the GUI)\nHold TAB to view modules binds.");
     /*((BooleanComponent)this.editGui.getComponent()).getCheckBox().addAction((mouseX, mouseY, mouseBn) ->{
         if (mouseBn == 0) {
            ((BooleanComponent)this.editGui.getComponent()).getCheckBox().toggle();
         }
      });
      */
    //  ((BooleanComponent)this.editGui.getComponent()).getCheckBox().addAction(new EditFunc(this));
      this.scalef = Minecraft.gameSettings().c5203();
      this.smooth_font.getComponent().addAction(new ActionToggleSmoothFont(this));
      this.blur.limitValues(radius);
      big_logo.limitValues(logoMode);
      this.addValue(big_logo,logoMode,this.radius,this.blur, this.reScale, this.multiKeybinding//, this.editGui
              , this.guiBindIndicator, this.smooth_font);
   }

   public void c2582(c4499 var1) {
      this.c5951 = var1;
   }

   public void c8116() {
      this.c2582(this.c2396);
   }

   public void c6601() {
      FrameManager.c3462.c270();
      this.c2582(this.c8168);
   }

   public static void c3934() {
      c5438 = true;
      if (Minecraft.gameSettings().c8495() <= 0 && Minecraft.gameSettings().c521()) {
         c313 = Minecraft.gameSettings().c1173();
         if (c313) {
            Minecraft.gameSettings().c335(false);
            Minecraft.getFrameBuffer().createBindFramebuffer(Minecraft.displayWidth(), Minecraft.displayHeight());
            if (!Minecraft.c2698().isNull()) {
               Minecraft.c2698().c4879(Minecraft.displayWidth(), Minecraft.displayHeight());
            }

            Minecraft.c7806().c6395();
         }

         c6021 = ShaderGroup.c2339(Minecraft.c7094(), Minecraft.c2698().getEntityRenderer(), Minecraft.getFrameBuffer(), new ResourceLocation(EntityRenderer.c2542()[c5654]));
         Minecraft.c2698().c5199(c6021);
         c6021.c4879(Minecraft.displayWidth(), Minecraft.displayHeight());
         Minecraft.c2698().c175(true);
      }

   }
   public static void c2272() {
      if (Minecraft.gameSettings().c8495() <= 0 && Minecraft.gameSettings().c521()) {
         if (c313) {
            Minecraft.getFrameBuffer().createBindFramebuffer(Minecraft.displayWidth(), Minecraft.displayHeight());
            if (!Minecraft.c2698().isNull()) {
               Minecraft.c2698().c4879(Minecraft.displayWidth(), Minecraft.displayHeight());
            }

            Minecraft.c7806().c6395();
            Minecraft.gameSettings().c335(true);
         }

         if (c6021 != null) {
            Minecraft.c2698().c175(false);
            Minecraft.c2698().c5199(new ShaderGroup(null));
            c6021.c6395();
            c6021 = null;
         }
      }

   }
   public static void c6033(IntractiveComponent var0) {
      c7880 = var0;
   }

   public static void c7218(IntractiveComponent var0) {
      c5438 = false;
      if (c7880 != null && c7880.equals(var0)) {
         c7880.setDisplayable(false);
         c7880 = null;
      }

   }

   public static void c3684() {
      if (c7880 != null && Vape.instance.getSettings().showTooltips.getValue() && c7880.displayable()) {
         RenderUtils.c403(c7880.getX() - 1.0, c7880.getY() - 2.0, c7880.getX() + c7880.getWidth() + 2.0, c7880.getY() + c7880.getHeight() + 1.0, 0.0, 0.0, 0.0, 0.9);
         c7880.render(true);
      }

   }

   public static void c6857() {
      if (c1724 != null) {
         c1724.c1042(c1724.handler().getX() + c1724.handler().getWidth() + 6.0);
         c1724.c467(c1724.handler().getY());
         c1724.draw();
         c1724.render(true);
      }

   }

   public static GuiComponent c8213() {
      return c1724;
   }

   public static void c2207(GuiComponent var0) {
      c1724 = var0;
   }

   public void c141() {
      super.c141();
      if (this.getState()) {
         if (this.reScale.getValue() && this.toolTip) {
            this.scalef = Minecraft.gameSettings().c5203();
            Minecraft.gameSettings().c2062(2);
         }

         Minecraft.c8115(new GuiScreen(d.getGuiObject()));
         this.toolTip = false;
      } else {
         this.toolTip = true;
      }

   }

   public void processTick(EventTick eventTick) {
      if (this.reScale.getValue()) {
         if (this.scalef == -1) {
            this.scalef = Minecraft.gameSettings().c5203();
            Minecraft.gameSettings().c2062(2);
         }
      } else if (this.scalef != -1) {
         Minecraft.gameSettings().c2062(this.scalef);
         this.scalef = -1;
      }

      if (this.c7974++ > 20) {
         this.c7974 = 0;
      }

      if (eventTick.getType() == EventType.PRE) {
         if (Tweaker.isBlatantMode()) {
            if (this.c636) {
               if (c3367.getBlue() < 190) {
                  this.c636 = false;
               } else {
                  c3367 = new Color(c3367.getRed(), c3367.getGreen() - 2, c3367.getBlue() - 2);
               }
            } else if (c3367.getBlue() >= 230) {
               this.c636 = true;
            } else {
               c3367 = new Color(c3367.getRed(), c3367.getGreen() + 2, c3367.getBlue() + 2);
            }
         }

         for (Value<?,?> value : Vape.instance.getValueManager().getValues()) {
            if (value instanceof ColorValue) {
               ColorValue cv = (ColorValue) value;
               if (cv.rainbow()) {
                  cv.continueHue();
               }
            }
         }
      }

   }

   public static void c1024(iReSqtkUVgHIRiReSqtkUVg var0) {
      c4227.add(var0);
   }

   public void render(RenderGameOverlayEvent var1) {
      BlurBuffer.onRenderGameOverlay(Minecraft.getFrameBuffer(), ScaledResolution.create(new Minecraft(), Minecraft.displayWidth(), Minecraft.displayHeight()));

      if (Minecraft.currentScreen().isNull() || !Minecraft.currentScreen().getObject().getClass().isInstance(d.getGuiObject())) {
         boolean var2 = this.reScale.getValue() && FrameManager.textGui.rescale.getValue();
         float var3 = 0.0F;
         if (var2) {
            ScaledResolution var4 = ScaledResolution.create(new Minecraft(), Minecraft.displayWidth(), Minecraft.displayHeight());
            int var5 = var4.c1744();
            float var6 = (float)(var5 == 5 ? 0.4 : (var5 == 4 ? 0.5 : (var5 == 3 ? 0.66666 : (var5 == 2 ? 1.0 : (var5 == 1 ? 2.0 : (var5 == 0 ? 0.5 : 1.0))))));
            var3 = 1.0F / var6;
            GL11.glScalef(var6, var6, var6);
         }

         this.c8072();
         if (var2) {
            GL11.glScalef(var3, var3, var3);
         }
      }

   }

   public Color c1862(Object var1) {
      if (!MappedClasses.EntityLivingBase.isInstance(var1)) {
         return null;
      } else if (var1.equals(Minecraft.thePlayer())) {
         return null;
      } else {
         EntityLivingBase var2 = new EntityLivingBase(var1);
         float var3 = var2.getDistanceToEntity(Minecraft.thePlayer());
         if (!MappedClasses.EntityOtherPlayerMP.isInstance(var1)) {
            return null;
         } else {
            return Vape.instance.getFriendManager().c4194(var2.getName()) && Vape.instance.getFriendManager().useColor.getValue() ? Vape.instance.getFriendManager().friendsColor.getAsColor() : Color.WHITE;
         }
      }
   }

   public void c8072() {
      Iterator var1 = Vape.instance.getFrameManager().getFrames().iterator();

      while(var1.hasNext()) {
         Frame var2 = (Frame)var1.next();
         if (var2.c30()) {
            var2.draw();
            var2.render(true);
         } else if (var2 instanceof FrameSettings) {
            ((FrameSettings)var2).c5470(true);
         }
      }

   }

   public List getMods() {
      return new CopyOnWriteArrayList(this.c5951.c1136());
   }


   public void renderList(ScaledResolution scaledResolution) {
      List list = this.getMods();
      Collections.reverse(list);
      ArrayList lst = new ArrayList();
      Iterator var4 = list.iterator();

      while(true) {
         while(var4.hasNext()) {
            Frame frame = (Frame)var4.next();
            if (!frame.displayable()) {
               if (frame.c1417()) {
                  frame.draw();
               }
            } else {
               frame.draw();
               frame.render(false);
               if (Keyboard.isKeyDown(62)) {
                  frame.c888(scaledResolution);
                  frame.c6393(scaledResolution);
               }

               boolean var6 = frame.c7532(scaledResolution);
               boolean var7 = frame.c6119(scaledResolution);
               if (var6 || var7) {
                  String var8 = frame.getName();
                  double var9 = Minecraft.getFontRenderer().getStringWidth(var8);
                  double var11 = Minecraft.getFontRenderer().FONT_HEIGHT(var8);
                  double var13 = var6 ? (double)scaledResolution.getScaledWidth() - var9 : frame.getX();
                  double var15 = var7 ? (double)scaledResolution.getScaledHeight() - var11 : frame.getY();
                  SquareButton squareButton = frame.c826();
                  squareButton.c1042(var13 - 4.0);
                  squareButton.c467(var15);
                  squareButton.setWidth(squareButton.getGuiButton().getNameWidth() + 4.0);
                  squareButton.onOffset(10.0);
                  squareButton.setDisplayable(true);
                  lst.add(squareButton);
               }
            }
         }

         var4 = lst.iterator();

         while(var4.hasNext()) {
            SquareButton var18 = (SquareButton)var4.next();
            var18.draw();
            var18.render(true);
         }

         return;
      }
   }

   public void c2026(Object var1) {
      Vape.instance.getMappings().guiScreen.c6265(var1);
      c7218(c7880);
      if (this.c5951.equals(this.c8168)) {
         this.c8116();
         Vape.instance.c8477(true);
      } else {
         if (this.reScale.getValue() && this.scalef != -1) {
            Minecraft.gameSettings().c2062(this.scalef);
         }


         if (!Vape.instance.destructed) {
            this.c141();
         }
      }

   }

   public boolean c2855() {
      return this.toolTip;
   }

   public void setEditState(boolean var1) {
      this.inEdit = var1;
      //((BooleanComponent)this.editGui.getComponent()).getCheckBox().c8121(this.inEdit);
   }

   public boolean getEditState() {
      return this.inEdit;
   }

   public void c8731() {
      smoothFont = this.smooth_font.getValue();
      this.c5951 = this.c2396 = new c4499(Vape.instance.getFrameManager().getFrames());
      this.c8168 = new c4499(FrameManager.c3462, FrameManager.c1600, FrameManager.c6371);
   }
   
   public void drawScreen() {

      ScaledResolution var1 = ScaledResolution.create(new Minecraft(), Minecraft.displayWidth(), Minecraft.displayHeight());
      int var2 = Minecraft.displayWidth();
      int var3 = Minecraft.displayHeight();
      int var4 = var1.c1744();
      FontRenderer frObj = Minecraft.getFontRenderer();

      this.renderList(var1);

      //logo
      if(big_logo.getValue()){
         switch (logoMode.getValue().getName()){
            case "Vape":{
               String verStr = "v3.29";
               frObj.drawStringWithShadow(verStr, (var1.getScaledWidth() - frObj.getStringWidth(verStr) - 10), (var1.getScaledHeight() - 10), c3367);
               ImageRenderer.drawResWithShadow(c3367, (float)(var2 / var4 - 100), (float)(var3 / var4 - 80), "vape", 2.8F, false);
               break;
            }
            case "Vapu":{
               String verStr = "v3.29";
               frObj.drawStringWithShadow(verStr, (var1.getScaledWidth() - frObj.getStringWidth(verStr) - 10), (var1.getScaledHeight() - 10), c3367);
               ImageRenderer.drawResWithShadow(c3367, (float)(var2 / var4 - 100), (float)(var3 / var4 - 80), "vapu", 2.8F, false);
               break;
            }
            case "Rape":{
               String verStr = "v3.25";
               frObj.drawStringWithShadow(verStr, (var1.getScaledWidth() - frObj.getStringWidth(verStr) - 10), (var1.getScaledHeight() - 10), c3367);
               ImageRenderer.drawResWithShadow(c3367, (float)(var2 / var4 - 100), (float)(var3 / var4 - 80), "logos/rape.png", 2.8F, false);
               break;
            }
         }
      }else{
         //ver
         String verStr = "v3.29";
         frObj.drawStringWithShadow(verStr, (var1.getScaledWidth() - frObj.getStringWidth(verStr) - 10), (var1.getScaledHeight() - 10), c3367);
      }
      FrameManager.frameSettings.c5470(false);
      c6857();
      c3684();
   }


   public static boolean c8689(ClickGui var0, boolean var1) {
      return var0.inEdit = var1;
   }

   static {
      c3367 = Color.WHITE;
      c5654 = 18;
      c4227 = new ArrayList();
   }
}
