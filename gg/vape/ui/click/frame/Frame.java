package gg.vape.ui.click.frame;

import com.google.gson.JsonObject;
import func.skidline.*;
import gg.vape.Vape;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.ICloseable;
import gg.vape.ui.click.actions.ActionExpand;
import gg.vape.ui.click.actions.ActionRescaleFrame;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.IGuiCompontHandler;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.frame.ButtonGroup;
import gg.vape.ui.click.component.gui.ImageButton;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.unmap.ComponentCloseHandler;
import gg.vape.unmap.INamed;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.utils.render.RenderUtils;
import gg.vape.wrapper.impl.ScaledResolution;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Frame extends FrameComponent implements c7011, INamed, ICloseable {
   protected static final int c3290 = 2;
   public final boolean c9;
   public final FrameComponent frame;
   public final IntractiveComponent c97;
   public final IntractiveComponent expander;
   public final FrameComponent page;
   public final FrameComponent c8486;
   public final ImageButton c8126;
   public final ImageButton pinBn;
   public final RectData rect = new RectData(0.0, 0.0, 0.0, 0.0);
   public final RectData c2266;
   public RectData c4367;
   public boolean c8376 = false;
   public boolean c6645 = false;
   public boolean c854 = true;
   public boolean c328 = false;
   public boolean closeState = false;
   public double c3420 = 0.0;
   public final List<IGuiComponent> guiComponents = new ArrayList<>();
   public int c7711 = -1;
   public boolean c5706 = true;
   public boolean c1057;
   public FrameButtonGroup renderer;
   public final SquareButton c6008;
   public boolean c5376;

   public Frame(String title, boolean var2) {
      super(false);
      this.c9 = var2;
      this.onRendererHandling(new PoseRenderer(0.0, 0.0, 2, 1, new PoseMatrix(0, 0, 0, 0)));

      this.frame = new FrameComponent(true);
      this.frame.setColor(accentColor);
      this.frame.onRendererHandling(new PoseRenderer(0.0, 0.0, 1, 3, new PoseMatrix(0, 0, 0, 0)));

      this.c97 = new IntractiveComponent(title, RenderFlag.Centered, 1.0);
      this.frame.addComponent(this.c8126 = new ImageButton(this.c97.getName(), 0.4F, true));
      this.c8126.c1920(3.0F);
      this.c8126.c51(3.0F);
      this.pinBn = new ImageButton("pin", 0.3F, true);
      this.pinBn.c51(-23.0F);
      this.pinBn.c1920(4.0F);
      this.pinBn.addAction(new c4702(this));
      this.c97.c5305(c6836.c2682);

      this.expander = new IntractiveComponent("+", RenderFlag.Centered, 1.0);
      this.expander.c5305(c6836.c2682);
      this.expander.addAction(new ActionExpand(this));

      this.frame.addComponent(this.c97);
      //if(this.components.size() >2)
      //{
      //+-器
         this.frame.addComponent(this.expander);
      //}
      this.frame.c2888(null, new c4394(this));//todo ???
      this.frame.c2888(this.c2266 = new c2853(this, 0.0, 0.0, 0.0, 0.0), new c6809(this));
      if (this.c9) {
         this.frame.c2888(this.c4367 = new c2783(this, 0.0, 0.0, 0.0, 0.0), new c5354(this));
      }

      this.c8486 = new FrameComponent(false);
      this.c8486.onRendererHandling(new PoseRenderer(0.0, 0.0, 1, 1, new PoseMatrix(0, 2, 0, 2)));
      this.page = new FrameComponent(true);
      this.page.setColor(backGroundColor);
      this.c8486.addComponent(this.page);
      this.addComponent(this.frame);
      this.addComponent(this.c8486);
      this.setCloseStatus(true);
      this.c6008 = new SquareButton(this.getName(), true);
      this.c6008.addAction(new ActionRescaleFrame(this));
   }

   public boolean loadRenderer() {
      this.renderer = new FrameButtonGroup(this);
      return true;
   }

   public GuiComponent c4907() {
      return this.renderer;
   }

   public void renderFrame() {
      GL11.glEnable(GL11.GL_BLEND);
      GL11.glDisable(GL11.GL_TEXTURE_2D);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(0.15F, 0.15F, 0.15F, 0.3F);
      GL11.glLineWidth(1.0F);
      GL11.glEnable(2848);
      GL11.glBegin(2);
      GL11.glVertex2d(this.frame.getX(), this.frame.getY());
      GL11.glVertex2d(this.frame.getX() + this.frame.getWidth(), this.frame.getY());
      GL11.glVertex2d(this.frame.getX() + this.frame.getWidth(), this.frame.getY() + this.frame.getHeight());
      GL11.glVertex2d(this.frame.getX(), this.frame.getY() + this.frame.getHeight());
      GL11.glEnd();
      GL11.glDisable(2848);
      GL11.glEnable(GL11.GL_TEXTURE_2D);
      GL11.glDisable(GL11.GL_BLEND);
   }

   public void render(boolean flag) {
      if (this.displayable()) {

         for (IGuiComponent component : this.getComponents()) {
            if (component.equals(this.c8486)) {
               if (this.c5706) {
                  RenderUtils.c2266(0.0, this.getY(), 999999.0, (this.c8486.getHeight() + this.frame.getHeight()) * (this.c3420 / 100.0));
               }

               IntBuffer buf = BufferUtils.createIntBuffer(16);
               GL11.glGetInteger(GL11.GL_SCISSOR_BOX, buf);
               this.rect.setX(buf.get());
               this.rect.c798(buf.get());
               this.rect.setWidth(buf.get());
               this.rect.setHeight(buf.get());
               this.c8486.render(flag);
               this.setWidth(frame.getWidth());
               GL11.glDisable(3089);
            } else {
               component.render(flag);
            }
         }
      }

      if (this.displayable()) {
         if (this.frame.displayable()) {
            this.renderFrame();
            c5423 var5 = RenderUtils.c7719();
            RectData var6 = this.c2266.c1796(this.getX(), this.getY());
            if (var6.c325(var5)) {
               RenderUtils.c403(var6.getX(), var6.c4028(), var6.getX() + var6.getWidth(), var6.c4028() + var6.height(), 1.0, 1.0, 1.0, 0.3);
            }

            if (this.c9) {
               RectData var7 = this.c4367.c1796(this.getX(), this.getY());
               this.pinBn.render(false);
               if (var7.c325(var5)) {
                  RenderUtils.c403(var7.getX(), var7.c4028(), var7.getX() + var7.getWidth(), var7.c4028() + var7.height(), 1.0, 1.0, 1.0, 0.3);
               }
            }
         }

         this.frame.setDisplayable(!flag);
      }

   }

   public void setWidth(double var1) {
      super.setWidth(var1);
      this.frame.setWidth(var1);
      this.c97.setWidth(var1);
      this.expander.setWidth(-16.0);
      this.pinBn.setWidth(-16.0);
   }

   public void onOffset(double var1) {
      super.onOffset(var1);
      this.c8126.onOffset(var1);
      this.c97.onOffset(var1);
      this.expander.onOffset(var1 - 1.5);
      this.pinBn.onOffset(var1 - 1.5);
   }

   public void c5942() {
      this.page.setDisplayable(this.c3420 != 0.0);
      this.c8486.setDisplayable(this.page.displayable());
      if (this.c328) {
         if (this.c7711 != Vape.instance.getModManager().getMod(ClickGui.class).c7974) {
            this.c7711 = Vape.instance.getModManager().getMod(ClickGui.class).c7974;
            if (this.closeState) {
               this.c3420 -= 6.0;
            } else {
               this.c3420 += 6.0;
            }
         }

         if (this.closeState) {
            this.c3420 = 0.0;
         } else {
            this.c3420 = 100.0;
         }


      }

   }

   public void draw() {
      super.draw();
      this.c5942();
      if (this.c9) {
         this.pinBn.draw();
      }

      if (this.isDragin()) {
         double var1 = this.getX() + (double)this.c7090();
         double var3 = this.getY() + (double)this.c152();
         if (Keyboard.isKeyDown(42)) {

            for (Frame frame : Vape.instance.getFrameManager().getFrames()) {
               if (frame.displayable() && !frame.equals(this) && var1 + this.getWidth() >= frame.getX() && var1 <= frame.getX() + frame.getWidth() && var3 + this.getHeight() >= frame.getY() && var3 <= frame.getY() + frame.getHeight()) {
                  return;
               }
            }
         }

         this.c1042(var1);
         this.c467(var3);
      }

   }

   public boolean isDragin() {
      return this.c8376;
   }

   public void setDragState(boolean var1) {
      this.c8376 = var1;
   }

   public boolean isClosed() {
      return !this.page.displayable();
   }

   public void setCloseStatus(boolean status) {
      this.c328 = true;
      this.closeState = status;

      for (IGuiComponent component : this.getFramePage().getComponents()) {
         for (ComponentCloseHandler value : component.getCloseHandler()) {
            value.onClose(!status);
         }
      }

   }

   public boolean c30() {
      return this.c6645 && this.c9;
   }

   public void c8923(boolean var1) {
      this.c6645 = var1;
   }

   public boolean c121() {
      return this.c854;
   }

   public void c7988(boolean var1) {
      this.c854 = var1;
      this.setDisplayable(!var1);
   }

   public IntractiveComponent c7694() {
      return this.c97;
   }

   public IGuiComponent addGuiComponent(IGuiComponent var1) {
      this.page.addComponent(var1);
      return var1;
   }

   public IGuiComponent[] addGuiComponents(IGuiComponent[] guiComponents) {
      for (IGuiComponent var5 : guiComponents) {
         this.page.addComponent(var5);
      }
      return guiComponents;
   }

   public FrameComponent getFramePage() {
      return this.page;
   }

   public List<IGuiComponent> getComponentList() {
      return this.guiComponents;
   }

   public FrameComponent c3488() {
      return this.frame;
   }

   public Color c4391(Color var1, IGuiComponent var2, boolean var3, float var4) {
      ArrayList<IGuiComponent> components = new ArrayList<>();
      if (var2 instanceof ButtonGroup) {
         ButtonGroup var6 = (ButtonGroup)var2;
         if (!var6.c2346() && var6.isClosed()) {
            return var2.getColor();
         }

         components.addAll(((ButtonGroup)var2).subComponents().getComponents());
      } else if (var2 instanceof Frame) {
         components.addAll(((Frame)var2).getFramePage().getComponents());
      } else if (var2 instanceof IGuiCompontHandler) {
         components.addAll(((IGuiCompontHandler)var2).getComponents());
      }

      if (components.isEmpty()) {
         return var1;
      } else {
         float[] var10 = new float[3];
         var10 = Color.RGBtoHSB(var1.getRed(), var1.getGreen(), var1.getBlue(), var10);
         Color var7 = var1;
         for (IGuiComponent component : components) {
            if (component.c399()) {
               if (var3) {
                  var4 -= 0.025F;
                  if (var4 <= 0.0F) {
                     var4 = 1.0F;
                  }

                  var10[0] = var4;
                  var7 = new Color(Color.HSBtoRGB(var4, var10[1], var10[2]));
               }

               component.setColor(var7);
            }

            if (component.displayable()) {
               var7 = this.c4391(var7, component, var3, var4);
            }
         }

         return var7;
      }
   }

   public Color c6446(Color var1, boolean var2) {
      if (this.getComponents().size() <= 0) {
         return var1;
      } else {
         float[] var3 = new float[3];
         var3 = Color.RGBtoHSB(var1.getRed(), var1.getGreen(), var1.getBlue(), var3);
         return this.c4391(var1, this, var2, var3[0]);
      }
   }

   public void c3055(JsonObject var1) {
      if (var1.get("x") != null && !var1.get("x").isJsonNull()) {
         this.c1042(var1.get("x").getAsDouble());
      }

      if (var1.get("y") != null && !var1.get("y").isJsonNull()) {
         this.c467(var1.get("y").getAsDouble());
      }

      if (var1.get("minimized") != null && !var1.get("minimized").isJsonNull()) {
         this.setCloseStatus(var1.get("minimized").getAsBoolean());
      }

      if (var1.get("visible") != null && !var1.get("visible").isJsonNull()) {
         this.setDisplayable(var1.get("visible").getAsBoolean());
      }

      if (var1.get("pinned") != null && !var1.get("pinned").isJsonNull()) {
         this.c8923(var1.get("pinned").getAsBoolean());
      }

      if (var1.get("hidden") != null && !var1.get("hidden").isJsonNull() && this.renderer != null) {
         this.renderer.c5615().c8121(!var1.get("hidden").getAsBoolean());
      }

   }

   public JsonObject c2868() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("title", this.c7694().getName());
      var1.addProperty("x", this.getX());
      var1.addProperty("y", this.getY());
      var1.addProperty("minimized", this.isClosed());
      var1.addProperty("visible", this.displayable());
      if (this.c9) {
         var1.addProperty("pinned", this.c30());
      }

      if (this.renderer != null) {
         var1.addProperty("hidden", !this.renderer.c5615().c2346());
      }

      return var1;
   }

   public String getName() {
      return this.c7694().getName();
   }

   public void setDisplayable(boolean displayable) {
      super.setDisplayable(displayable);
      Iterator var2 = this.getFramePage().getComponents().iterator();

      while(var2.hasNext()) {
         IGuiComponent var3 = (IGuiComponent)var2.next();
         Iterator var4 = var3.getCloseHandler().iterator();

         while(var4.hasNext()) {
            ComponentCloseHandler var5 = (ComponentCloseHandler)var4.next();
            var5.onClose(displayable);
         }
      }

   }

   public void c2367(boolean var1) {
      this.c5706 = var1;
   }

   public boolean c4546() {
      return this.c1057;
   }

   public void c840(boolean var1) {
      this.c1057 = var1;
   }

   public double c4270(ScaledResolution var1) {
      return (double)var1.getScaledWidth() - this.getWidth() * 0.25;
   }

   public double c3093(ScaledResolution var1) {
      return -(this.getWidth() * 0.75);
   }

   public boolean c7532(ScaledResolution var1) {
      double var2 = this.c4270(var1);
      return this.getX() > var2;
   }

   public double c2251(ScaledResolution var1) {
      double var2 = this.c4270(var1);
      double var4 = this.c3093(var1);
      if (this.getX() < var4) {
         return var4;
      } else {
         return this.getX() > var2 ? var2 : this.getX();
      }
   }

   public void c888(ScaledResolution var1) {
      if (this.c7532(var1)) {
         this.c1042(this.c2251(var1));
      }

   }

   public double c6571(ScaledResolution var1) {
      return -(this.c7694().getHeight() * 0.75);
   }

   public double c6338(ScaledResolution var1) {
      return (double)var1.getScaledHeight() - this.c7694().getHeight() * 0.5;
   }

   public boolean c6119(ScaledResolution var1) {
      double var2 = this.c6571(var1);
      double var4 = this.c6338(var1);
      return this.getY() < var2 || this.getY() > var4;
   }

   public double c1822(ScaledResolution var1) {
      double var2 = this.c6571(var1);
      double var4 = this.c6338(var1);
      if (this.getY() < var2) {
         return var2;
      } else {
         return this.getY() > var4 ? var4 : this.getY();
      }
   }

   public void c6393(ScaledResolution var1) {
      if (this.c6119(var1)) {
         this.c467(this.c1822(var1));
      }

   }

   public SquareButton c826() {
      return this.c6008;
   }

   public boolean c4828(int var1, int var2, int var3) {
      this.c6008.c4828(var1, var2, var3);
      return super.c4828(var1, var2, var3);
   }

   public void c3664(boolean var1) {
      this.c5376 = var1;
   }

   public boolean c1417() {
      return this.c5376;
   }

   // $FF: synthetic method
   public static ImageButton getButton(Frame var0) {
      return var0.pinBn;
   }

   // $FF: synthetic method
   public static IntractiveComponent c6910(Frame var0) {
      return var0.expander;
   }

   // $FF: synthetic method
   public static FrameComponent c1052(Frame var0) {
      return var0.frame;
   }

   // $FF: synthetic method
   public static IntractiveComponent c1174(Frame var0) {
      return var0.c97;
   }

   // $FF: synthetic method
   public static boolean c1569(Frame var0) {
      return var0.c9;
   }
}
