package gg.vape.ui.click.frame.impl;

import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.ui.click.ISettable;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.value.NumberComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.font.SmoothFontRenderer;
import gg.vape.ui.font.TrueTypeFontRenderer;
import gg.vape.unmap.ModeSelection;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.AnimationUtils;
import gg.vape.utils.render.ImageRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.utils.render.RenderUtils;
import gg.vape.value.*;
import gg.vape.wrapper.impl.FontRenderer;
import gg.vape.wrapper.impl.Minecraft;
import org.lwjgl.opengl.GL11;
import pub.nextsense.common.d;
import pub.nextsense.util.ResourceManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class FrameTextGUI extends Frame implements ISettable {
   public final ModeSelection lenSortMode = new ModeSelection("Length");
   public final ModeSelection abcSortMode = new ModeSelection("Alphabetical");
   public final ModeValue sortMode;

   public final ModeSelection logoVape = new ModeSelection("V3");
   public final ModeSelection logoV325 = new ModeSelection("V3.25");
   public final ModeSelection logoV4 = new ModeSelection("V3.30");
   public final ModeSelection logoV4x = new ModeSelection("V4");

   public final ModeSelection logoNig = new ModeSelection("Coder");
   public final ModeSelection logoWin = new ModeSelection("Windows");
   //public final ModeSelection logoNig = new ModeSelection("Coder");

   public final ModeValue waterMarkMode;
   public final BooleanValue shadow;
   public final BooleanValue cateColor;
   public final BooleanValue watermark;
   public BooleanValue rescale;
   public BooleanValue bg;
   public BooleanValue side;
   public BooleanValue blur;

   public NumberValue scale = NumberValue.create(this, "Scale", "#","", 1.0, 10, 30,1,"Scale of Text GUI");

   public FrameTextGUI() {
      super("Text GUI", true);
      this.sortMode = ModeValue.create(this, "Sort", this.lenSortMode, this.lenSortMode, this.abcSortMode);
      this.shadow = BooleanValue.create(this, "Shadow", true, "Renders shadowed text.");
      this.cateColor = BooleanValue.create(this, "Use Category Color", false);

      this.waterMarkMode = ModeValue.create(this, "Watermark Mode", this.logoVape, logoVape,logoV325,this.logoV4, this.logoV4x,logoNig,logoWin);

      this.watermark = BooleanValue.create(this, "Watermark", true, "Renders a vape watermark");
      this.watermark.limitValues(waterMarkMode);

      this.rescale = BooleanValue.create(this, "Rescale", false, "Rescales Text GUI");
      rescale.limitValues(scale);
      this.bg = BooleanValue.create(this, "Background", true, "Text GUI text background");
      this.side = BooleanValue.create(this, "Side bar", true, "Text GUI Sidebar");
      this.blur = BooleanValue.create(this, "Blur Background", true, "Blur TextGui background");
      this.getFramePage().onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      this.opened(false);
      this.getFramePage().opened(false);
      this.setWidth(100.0);
      this.onOffset(20.0);
      this.setCloseStatus(false);
      this.c8923(true);
      this.getComponentList().add(this.shadow.getComponent());
      this.getComponentList().add(this.cateColor.getComponent());
      this.getComponentList().add(this.watermark.getComponent());
      this.getComponentList().add(this.waterMarkMode.getComponent());
      this.getComponentList().add(this.rescale.getComponent());
      this.getComponentList().add(this.scale.getComponent());
      this.getComponentList().add(this.sortMode.getComponent());
      this.getComponentList().add(this.bg.getComponent());
      this.getComponentList().add(this.side.getComponent());
      this.getComponentList().add(this.blur.getComponent());
   }

   @Override
   public List<Value> getValues() {
      ArrayList<Value> values = new ArrayList<>();
      values.add(shadow);
      values.add(cateColor);
      values.add(watermark);
      values.add(waterMarkMode);
      values.add(rescale);
      values.add(sortMode);
      values.add(bg);
      values.add(side);
      values.add(blur);
      return values;
   }


   class AlphabeticalComparator implements Comparator {
      public AlphabeticalComparator() {
      }

      public int c7971(Mod var1, Mod var2) {
         FontRenderer fontRenderer = Minecraft.getFontRenderer();
         return Integer.compare(fontRenderer.getStringWidth(var2.getName() + var2.getSuffix()), fontRenderer.getStringWidth(var1.getName() + var1.getSuffix()));
      }

      public int compare(Object var1, Object var2) {
         return this.c7971((Mod)var1, (Mod)var2);
      }
   }




   //  @InsnComment(
  //    At_60 = "INVOKESTATIC iReSqtkUVgeLLiReSqtkUVg.f()LiReSqtkUVgMiPiReSqtkUVg;\nINVOKEVIRTUAL iReSqtkUVgMiPiReSqtkUVg.a()Ljava/lang/Object;\nINVOKEVIRTUAL java/lang/Object.getClass()Ljava/lang/Class;\nINVOKESTATIC a/d.getGuiObject()Ljava/lang/Object;\nINVOKEVIRTUAL java/lang/Class.isInstance(Ljava/lang/Object;)Z"
  // )
  // @InsnComment(
  //    At_63 = "IFNE J\nALOAD this\nINVOKEVIRTUAL iReSqtkUVgJrJiReSqtkUVg.e_()D\nLDC 11.0D\nDADD\nGOTO K\nDSTORE 2\nJ:\nALOAD this\nINVOKEVIRTUAL iReSqtkUVgJrJiReSqtkUVg.e_()D\nLDC 11.0D\nDSUB\nK:"
  // )
   public void draw() {

      super.draw();
      if (!this.isClosed() && this.displayable()) {
         ArrayList<Mod> modList = new ArrayList<>(Vape.instance.getModManager().collectMods());
         if (this.sortMode.getValue() == this.lenSortMode) {
            modList.sort((o1, o2) -> {
               SmoothFontRenderer font = getFont();
               return Float.compare(font.getStringWidth(format(o2)), font.getStringWidth(format(o1)));//(int) (font.getStringWidth(format(o2)) - font.getStringWidth(format(o1)));
            });
            //modList.sort(new AlphabeticalComparator());
         } else//else if (this.sortMode.getValue() == this.abcSortMode)
         {            //abc
            modList.sort((o1, o2) -> {
            String s1 = o1.getName().toLowerCase();
            String s2 = o2.getName().toLowerCase();
            return s1.compareTo(s2);
         });

         }

         //double y = ResourceManager.gy(Minecraft.currentScreen().isNull(), this.getY());
         double y = ResourceManager.gy(
                 ! (Minecraft.currentScreen().isNotNull() && Minecraft.currentScreen().getObject().getClass().isInstance(d.getGuiObject()))
                 , this.getY());
         boolean inRight = this.getX() >= (double) (Minecraft.c4912().getScaledWidth() / 2);

         float[] hsb = new float[3];
         ColorValue var6 = Vape.instance.getSettings().guiColor;
         hsb = Color.RGBtoHSB(var6.getAsColor().getRed(), var6.getAsColor().getGreen(), var6.getAsColor().getBlue(), hsb);
         float rainbow = hsb[0];
         if (this.watermark.getValue()) {
            String version = "v" + Vape.version;
            SmoothFontRenderer var9 = Vape.instance.getFont(1.1f);//1.2);//SmoothFontRenderer var9 = Vape.instance.getFont(1.1f);//1.2);
            double x = inRight ? this.getX() + 100.0 - (var9.getStringWidth(version) + 50.0) : this.getX();
            GL11.glPushMatrix();

            switch (waterMarkMode.getValue().getName()){
               case "V3":{
                  if (this.shadow.getValue()) {
                     var9.drawStringWithShadow(version, x + 50.0, 3.0 + (y += 11.0), Color.lightGray);
                  } else {
                     var9.drawString(version, x + 50.0, 3.0 + (y += 11.0), Color.lightGray);
                  }
                  ImageRenderer.drawResWithShadow(var6.getAsColor(), (float)x, (float)y - 3.0F, "logo", 0.5F, true);
                  break;
               }
               case "V3.25":{
                  if (this.shadow.getValue()) {
                     var9.drawStringWithShadow("v3.25", x + 50.0, 3.0 + (y += 11.0), Color.lightGray);
                  } else {
                     var9.drawString("v3.25", x + 50.0, 3.0 + (y += 11.0), Color.lightGray);
                  }
                  ImageRenderer.drawResWithShadow(var6.getAsColor(), (float)x, (float)y - 3.0F, "logos/325.png", 0.5F, true);
                  break;
               }
               case "V3.30":{
                  if (this.shadow.getValue()) {
                     var9.drawStringWithShadow("v3.25", x + 50.0, 3.0 + (y += 11.0), Color.lightGray);
                  } else {
                     var9.drawString("v3.25", x + 50.0, 3.0 + (y += 11.0), Color.lightGray);
                  }
                  ImageRenderer.drawResWithShadow(var6.getAsColor(), (float)x, (float)y - 3.0F, "logos/v4.png", 0.5F, true);
                  break;
               }
               case "V4":{
                  x = inRight ? this.getX() + 100.0 - (var9.getStringWidth(version) + 49) : this.getX();
                  y += 11.0;
                  ImageRenderer.drawResWithShadow(var6.getAsColor(), (float)x+52, (float)y - 3.0F, "logos/v4_vape.png", 0.5F, true);
                  ImageRenderer.drawResWithShadow(var6.getAsColor(), (float)x, (float)y - 3.0F, "logos/v4.png", 0.5F, true);
                  //ImageRenderer.drawResWithShadow(var6.getAsColor(), (float)x-30, (float)y - 3.0F, "v4", 0.5F, true);
                  //ImageRenderer.drawResWithShadow(var6.getAsColor(), (float)x, (float)y - 3.0F, "v4Ready", 0.5F, true);
                  break;
               }
               case "Coder":{
                  x = inRight ? this.getX() + 100.0 - (var9.getStringWidth(version) +49) : this.getX();
                  y += 11.0;
                  ImageRenderer.drawResWithShadow(var6.getAsColor(), (float) (inRight ? this.getX() + 100.0 - (var9.getStringWidth(version)) : this.getX()), (float)y - 3.0F, "coder", 0.5F, true);
                  break;
               }
               case "Windows":{
                  x = inRight ? this.getX() + 100.0 - (var9.getStringWidth(version) +49) : this.getX();
                  y += 11.0;
                  ImageRenderer.drawResWithShadow(var6.getAsColor(), (float)x, (float)y - 3.0F, "logos/windows.png", 0.5F, true);
                  break;
               }
               case "Rape":{
                  y += 11.0;
                  ImageRenderer.drawResWithShadow(var6.getAsColor(), (float)x, (float)y - 3.0F, "raped", 0.5F, true);
                  break;
               }
            }

            GL11.glPopMatrix();
            y += 5.0;
         }

         ColorValue guiColor = Vape.instance.clientSettings.guiColor;
         for (Mod module : modList) {
            if (module.getState() && module.c5275() != 0) {
               String format = module.getName() + module.getSuffix();
               double x = inRight ? this.getX() + 100.0 - this.getFont().getStringWidth(format) : this.getX() + 1.0;
               Color color = new Color(this.cateColor.getValue() ? module.getCategory().getColor() : module.c5275());
               if (var6.rainbow()) {
                  rainbow -= 0.025F;
                  if (rainbow <= 0.0F) {
                     rainbow = 1.0F;
                  }

                  hsb[0] = rainbow;
                  color = new Color(Color.HSBtoRGB(rainbow, guiColor.getS(), guiColor.getB()));//color = new Color(Color.HSBtoRGB(rainbow, 1.0F, 1.0F));
               }
               if(!rescale.getValue()){
                  y += 11;
                  module.setArrayX(AnimationUtils.animate((float) module.getArrayX(), (float) x,0.5f));
                  module.setArrayY(AnimationUtils.animate((float) module.getArrayY(), (float) y,0.5f));

                  if(blur.getValue()){
                     RenderUtils.drawBlurRect(module.getArrayX(),module.getArrayY(),module.getArrayX() + this.getFont().getStringWidth(format) + (inRight ? 3 : 4) ,module.getArrayY() + 11);
                  }
                  if(bg.getValue()){
                     RenderUtils.drawRect(module.getArrayX(),module.getArrayY(),module.getArrayX() + this.getFont().getStringWidth(format) + (inRight ? 3 : 4) ,module.getArrayY() + 11.0,new Color(0,0,0,100).getRGB());
                  }
                  if(side.getValue()){
                     if(!inRight){
                        RenderUtils.drawRect(module.getArrayX() - 1,module.getArrayY(),module.getArrayX() ,module.getArrayY() + 11.0,color.getRGB());
                     }else {
                        RenderUtils.drawRect(module.getArrayX() + this.getFont().getStringWidth(format) + 3,module.getArrayY(),module.getArrayX() + this.getFont().getStringWidth(format) + 4 ,module.getArrayY() + 11.0,color.getRGB());
                     }
                  }


                  if (this.shadow.getValue()) {
                     this.getFont().drawStringWithShadow(format, module.getArrayX() + (bg.getValue() ? (inRight ? 1 : 2) : 0), module.getArrayY() + (bg.getValue() ? 2 : 0), color);
                  } else {
                     this.getFont().drawString(format, module.getArrayX() + (bg.getValue() ? (inRight ? 1 : 2) : 0), module.getArrayY() + (bg.getValue() ? 2 : 0), color);
                  }
               }else {
                  SmoothFontRenderer aFont = getAFont();
                  x = inRight ? this.getX() + 100.0 - (aFont.getStringWidth(format)) : this.getX();
                  double sh = aFont.getStringHeight(format)*2;
                  y += sh;
                  module.setArrayX(AnimationUtils.animate((float) module.getArrayX(), (float) x,0.5f));
                  module.setArrayY(AnimationUtils.animate((float) module.getArrayY(), (float) y,0.5f));

                  if(blur.getValue()){
                     RenderUtils.drawBlurRect(module.getArrayX(),module.getArrayY(),module.getArrayX() + this.getAFont().getStringWidth(format) + (inRight ? 3 : 4) ,module.getArrayY() + sh);
                  }
                  if(bg.getValue()){
                     RenderUtils.drawRect(module.getArrayX(),module.getArrayY(),module.getArrayX() + this.getAFont().getStringWidth(format) + (inRight ? 3 : 4) ,module.getArrayY() + sh,new Color(0,0,0,100).getRGB());
                  }
                  if(side.getValue()){
                     if(!inRight){
                        RenderUtils.drawRect(module.getArrayX() - 1,module.getArrayY(),module.getArrayX() ,module.getArrayY() + sh,color.getRGB());
                     }else {
                        RenderUtils.drawRect(module.getArrayX() + this.getAFont().getStringWidth(format) + 3,module.getArrayY(),module.getArrayX() + this.getAFont().getStringWidth(format) + 4 ,module.getArrayY() + sh,color.getRGB());
                     }
                  }


                  if (this.shadow.getValue()) {
                     aFont.drawStringWithShadow(format, module.getArrayX() + (bg.getValue() ? (inRight ? 1 : 2) : 0), module.getArrayY() + (bg.getValue() ? 2 : 0), color);
                  } else {
                     aFont.drawString(format, module.getArrayX() + (bg.getValue() ? (inRight ? 1 : 2) : 0), module.getArrayY() + (bg.getValue() ? 2 : 0), color);
                  }
               }

            }
         }

      }
   }

   private SmoothFontRenderer getAFont() {
      return Vape.instance.getFont(scale.getValue().floatValue()/10f);
   }

   private String format(Mod mod) {
      return mod.getName() + mod.getSuffix();
   }

   public void setWidth(double var1) {
      super.setWidth(var1);
      for (IGuiComponent var4 : this.getFramePage().getComponents()) {
         var4.setWidth(var1 - 4.0);
      }

   }
}
