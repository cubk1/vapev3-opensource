package gg.vape.ui.click.component;

import func.skidline.RectData;
import func.skidline.c5423;
import func.skidline.c5711;
import func.skidline.c7011;
import gg.vape.Vape;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.*;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.component.value.BooleanComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.font.SmoothFontRenderer;
import gg.vape.ui.unmap.SliderInFrame;
import gg.vape.unmap.ComponentCloseHandler;
import gg.vape.utils.render.RenderUtils;
import gg.vape.value.Value;
import org.lwjgl.input.Mouse;
import pub.nextsense.Tweaker;

import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.function.Consumer;

public abstract class GuiComponent implements IGuiCompontHandler, IGuiComponent, Cloneable {
   public List<IGuiComponent> components = new ArrayList();
   public final Map c3750 = new LinkedHashMap();
   public Color c5044;
   protected IGuiRenderer parent;
   protected c5423 c5587;
   protected int c6804;
   protected int c6918;
   protected Set<IGuiCallback> c2987;
   protected Set c2528;
   public final RectData mainData;
   public RectData c2979;
   public Color bgCol;
   public boolean displayable;
   public IGuiCompontHandler c4098;
   public Value<?,?> c696;
   public boolean c4171;
   public IntractiveComponent tipObj;
   public String tips;
   public long c2494;
   public boolean c711;
   public boolean c6447;

   public GuiComponent() {
      this.c5044 = accentColor;
      this.c6804 = 0;
      this.c6918 = 0;
      this.c2987 = new HashSet<>();
      this.c2528 = new HashSet<>();
      this.mainData = new RectData(-10000.0, -10000.0, 0.0, 0.0);
      this.c2979 = null;
      this.bgCol = backGroundColor;
      this.displayable = true;
      this.c4171 = true;
      this.tips = "";
   }

   public GuiComponent c7995() {
      try {
         GuiComponent var1 = (GuiComponent)super.clone();
         var1.components = new ArrayList<>();
         for (IGuiComponent var3 : this.components) {
            if (var3 instanceof GuiComponent) {
               GuiComponent var4 = (GuiComponent) var3;
               var1.components.add(var4.c7995());
            }
         }
         return var1;
      } catch (Exception var5) {
         Vape.throwEx(var5);
         return null;
      }
   }

   public void render(boolean var1) {
      if (this.displayable()) {
         for (IGuiComponent var3 : this.components) {
            var3.render(var1);
         }
      }

   }

   public void draw() {
      if (this.tipObj == null) {
         this.tipObj = new ToolTips(this, this.tips, RenderFlag.Regular, 0.8);
         this.tipObj.c8923(true);
         this.tipObj.onOffset(10.0);
         this.tipObj.setWidth(this.getWidth());
      }

      for (Object value : this.c2987) {
         IGuiCallback var2 = (IGuiCallback) value;
         var2.call(this);
      }

      if (this.displayable()) {
         c5423 var3;
         if (this.c5587 != null) {
            var3 = RenderUtils.c7719();
            this.c6918 = var3.c8041 - this.c5587.c8041;
            this.c6804 = var3.c535 - this.c5587.c535;
         }

         if (!(this.parent instanceof c5711) && this.parent != null) {
            this.parent.c8084();
         }

         if (this instanceof c7011 && !Mouse.isButtonDown(0)) {
            ((c7011)this).setDragState(false);
         }

         Iterator var1 = this.components.iterator();

         while(var1.hasNext()) {
            IGuiComponent var4 = (IGuiComponent)var1.next();
            var4.draw();
         }

         if (this.tipObj != null) {
            if (this.tipObj.getName() != null && !this.tipObj.getName().isEmpty()) {
               if (this.isHovering()) {
                  if (this.c2494++ >= 25L) {
                     this.tipObj.setDisplayable(true);
                     var3 = RenderUtils.c7719();
                     this.tipObj.c1042(var3.c535 + 2);
                     this.tipObj.c467((double)var3.c8041 - this.tipObj.getHeight() / 2.0 - 2.0);
                     this.tipObj.setWidth(this.getFont().getStringWidth(this.tipObj.getName()) * 0.7);
                     ClickGui.c6033(this.tipObj);
                  }
               } else {
                  this.c2494 = 0L;
                  ClickGui.c7218(this.tipObj);
               }
            } else {
               ClickGui.c7218(this.tipObj);
            }
         }

         this.c5587 = RenderUtils.c7719();
         if (this.parent instanceof c5711 && this.parent != null) {
            this.parent.c8084();
         }
      }

   }

   public double getX() {
      return this.mainData.getX();
   }

   public void c1042(double var1) {
      this.mainData.setX(var1);
   }

   public double getY() {
      return this.mainData.c4028();
   }

   public void c467(double var1) {
      this.mainData.c798(var1);
   }

   public RectData c740() {
      return this.mainData;
   }

   public IGuiCompontHandler handler() {
      return this.c4098;
   }

   public void setParent(IGuiCompontHandler var1) {
      this.c4098 = var1;
   }

   public boolean c3210(char var1, int var2) {
      if (!this.displayable()) {
         return false;
      } else {
         Iterator var3 = this.getComponents().iterator();

         IGuiComponent var4;
         do {
            if (!var3.hasNext()) {
               return false;
            }

            var4 = (IGuiComponent)var3.next();
         } while(!var4.displayable() || !var4.c3210(var1, var2));

         return true;
      }
   }

   public void c4368(IGuiComponent var1, IGuiComponent var2) {
      if (!var2.equals(var1)) {
         if (var2 instanceof IEditable) {
            IEditable var3 = (IEditable)var2;
            var3.setEditing(false);
         }

         if (var2 instanceof IGuiCompontHandler) {
            IGuiCompontHandler var6 = (IGuiCompontHandler)var2;
            Iterator var4 = var6.getComponents().iterator();

            while(var4.hasNext()) {
               IGuiComponent var5 = (IGuiComponent)var4.next();
               this.c4368(var1, var5);
            }
         }

      }
   }

   public boolean c4828(int var1, int var2, int var3) {
      if (this.displayable()) {

         for (IGuiComponent var5 : this.components) {
            if (var5.c4828(var1, var2, var3)) {
               for (IGuiComponent var7 : this.components) {
                  this.c4368(var5, var7);
               }

               return true;
            }
         }

         if (this.isHovering()) {
            ListIterator var8 = (new ArrayList(this.c3750.entrySet())).listIterator(this.c3750.size());

            while(var8.hasPrevious()) {
               Map.Entry var9 = (Map.Entry)var8.previous();
               RectData var10 = (RectData)var9.getKey();
               IActionComponent var11 = (IActionComponent)var9.getValue();
               if (var11 == null) {
                  return true;
               }

               if (var10 == null) {
                  var11.c4493(this, var1, var2, var3);
                  return true;
               }

               if (var10.c1796(this.getX(), this.getY()).c325(RenderUtils.c7719())) {
                  var11.c4493(this, var1, var2, var3);
                  return true;
               }
            }
         }
      }

      return false;
   }

   public Set getCloseHandler() {
      return this.c2528;
   }

   public boolean c905(int var1, int var2) {
      return this.mainData.c2926(var1, var2);
   }

   public boolean displayable() {
      return this.displayable;
   }

   public void setDisplayable(boolean displayable) {
      this.displayable = displayable;
   }

   public Set c5535() {
      return this.c3750.keySet();
   }

   public void c2888(RectData var1, IActionComponent var2) {
      this.c3750.put(var1, var2);
   }

   public SmoothFontRenderer getFont() {
      return Vape.instance.getF18();
   }

   public double getWidth() {
      return this.mainData.getWidth();
   }

   public void setWidth(double var1) {
      this.mainData.setWidth(var1);
   }

   public void setX(double var1) {
      this.mainData.setX(var1);
   }
   protected double getMX() {
      return this.mainData.getX();
   }
   public double getHeight() {
      return this.mainData.height();
   }

   public void onOffset(double var1) {
      this.mainData.setHeight(var1);
   }

   public Color getColor() {
      return this.c5044;
   }

   public void setColor(Color var1) {
      this.c5044 = var1;
   }

   public Color getBackGroundColor() {
      return this.bgCol;
   }

   public void setBackGroundColor(Color color) {
      this.bgCol = color;
   }

   public List<IGuiComponent> getComponents() {
      return this.components;
   }

   public List<IGuiComponent> getDisplayableComponents() {
      ArrayList<IGuiComponent> result = new ArrayList<>();
      for (IGuiComponent component : this.components) {
         if (component.displayable()) {
            result.add(component);
         }
      }
      return result;
   }

   public IGuiComponent c6970(Value var1) {
      Iterator var2 = this.components.iterator();

      IGuiComponent var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (IGuiComponent)var2.next();
      } while(!var3.c5999().equals(var1));

      return var3;
   }

   public IGuiComponent addComponent(IGuiComponent component) {
      component.setParent(this);
      this.components.add(component);
      return component;
   }

   public IGuiComponent[] c5227(IGuiComponent[] var1) {
      IGuiComponent[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         IGuiComponent var5 = var2[var4];
         var5.setParent(this);
         this.components.add(var5);
      }

      return var1;
   }

   public IGuiComponent c1202(int var1, IGuiComponent var2) {
      this.components.add(var1, var2);
      return var2;
   }

   public void c4043(IGuiComponent var1) {
      this.components.remove(var1);
   }

   public void c756() {
      this.components.clear();
   }

   public IGuiRenderer getParent() {
      return this.parent;
   }

   public void onRendererHandling(IGuiRenderer renderer) {
      renderer.adaptHandler(this);
      this.parent = renderer;
   }

   public void c4446(RectData var1) {
      for (IGuiComponent component : this.components) {
         if (component instanceof GuiComponent) {
            ((GuiComponent) component).c4446(var1);
         }
      }

      this.c2979 = var1;
   }

   public RectData c1607() {
      return this.c2979;
   }

   public boolean isHovering() {
      c5423 var1 = RenderUtils.c7719();
      if (this.c2979 != null) {
         int var2 = Mouse.getX();
         int var3 = Mouse.getY();
         return (double) var2 > this.c2979.getX() && (double) var3 > this.c2979.c4028() && (double) var2 < this.c2979.getX() + this.c2979.getWidth() && (double) var3 < this.c2979.c4028() + this.c2979.height() && this.c905(var1.c535, var1.c8041);
      } else {
         return this.c905(var1.c535, var1.c8041);
      }
   }

   public int c7090() {
      return this.c6804;
   }

   public int c152() {
      return this.c6918;
   }

   public Set c6740() {
      return this.c2987;
   }

   public void addAction(IGuiCallback var1) {
      this.c2987.add(var1);
   }

   public void onClose(ComponentCloseHandler var1) {
      this.c2528.add(var1);
   }

   public Value<?,?> c5999() {
      return this.c696;
   }

   public void c8376(Value value) {
      this.c696 = value;
   }

   public boolean c399() {
      return this.c4171;
   }

   public void c7363(boolean var1) {
      this.c4171 = var1;
   }

   public IntractiveComponent c4520() {
      return this.tipObj;
   }

   public void setText(String tips) {
      if (this.tipObj != null) {
         this.tipObj.setName(tips);
      } else {
         this.tips = tips;
      }

   }

   public boolean c2877() {
      return this.c3617() && !Tweaker.isBlatantMode() || this.c711;
   }

   public void c4983(boolean var1) {
      this.c711 = var1;
   }

   public boolean c3617() {
      return this.c6447;
   }

   public void c4804(boolean var1) {
      this.c6447 = var1;
   }

   public void c8669(IGuiComponent var1, Consumer var2) {
      var2.accept(var1);
      if (!(var1 instanceof IClickable) && !(var1 instanceof BooleanComponent)) {
         Iterator var3;
         IGuiComponent var4;
         if (var1 instanceof SliderInFrame) {
            var3 = ((SliderInFrame)var1).c6047().getComponents().iterator();

            while(var3.hasNext()) {
               var4 = (IGuiComponent)var3.next();
               this.c8669(var4, var2);
            }
         } else if (var1 instanceof Frame) {
            var3 = ((Frame)var1).getFramePage().getComponents().iterator();

            while(var3.hasNext()) {
               var4 = (IGuiComponent)var3.next();
               this.c8669(var4, var2);
            }
         } else if (var1 instanceof IGuiCompontHandler) {
            var3 = ((IGuiCompontHandler)var1).getComponents().iterator();

            while(var3.hasNext()) {
               var4 = (IGuiComponent)var3.next();
               this.c8669(var4, var2);
            }
         }

      }
   }

   // $FF: synthetic method
   public Object clone() {
      return this.c7995();
   }

   // $FF: synthetic method
   public IGuiComponent c8735() {
      return this.c7995();
   }

}
