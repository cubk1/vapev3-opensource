package gg.vape.ui.unmap;

import func.skidline.RectData;
import func.skidline.c7011;
import gg.vape.Vape;
import gg.vape.manager.ModManager;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.utils.render.RenderUtils;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.nio.IntBuffer;

public class SliderInFrame extends FrameComponent implements c7011 {
   public static final double c5153 = 5.0;
   public final SquareButton drager = new SquareButton("", true);
   public final RectData c3587 = new RectData(0.0, 0.0, 0.0, 0.0);
   public double c1288 = 0.0;
   public double c2967 = 0.0;
   public double c3429 = 0.0;
   public final FrameComponent Back = new c4616(this, false);
   public boolean drag = false;
   class c4616 extends FrameComponent {
      // $FF: synthetic field
      final SliderInFrame c4660;

      c4616(SliderInFrame var1, boolean var2) {
         super(var2);
         this.c4660 = var1;
      }

      public void c467(double var1) {
         super.c467(var1 - SliderInFrame.c1751(this.c4660));
      }

      public void c4043(IGuiComponent var1) {
         super.c4043(var1);
         this.c4660.setWheel((int)(-var1.getHeight()));
      }
   }

   public SliderInFrame(boolean var1) {
      super(var1);
      this.onRendererHandling(new PoseRenderer(0.0, 0.0, 1, 2, new PoseMatrix(0, 0, 0, 0)));
      this.drager.setBackGroundColor(hoveringColor);
      this.drager.setWidth(5.0);
      this.drager.addAction((mouseX, mouseY, mouseBn) ->{
         if (mouseBn == 0) {
            this.setDragState(true);
         }
      });
      PoseRenderer bar = new PoseRenderer(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0));
      bar.c2598();
      this.Back.onRendererHandling(bar);
      this.addComponent(this.Back);
      this.addComponent(this.drager);
   }

   public void render(boolean flag) {
      this.drager.setBackGroundColor(Vape.instance.clientSettings.guiColor.getAsColor(120));
      RenderUtils.c2266(this.getX(), this.getY(), this.getWidth(), this.getHeight());
      IntBuffer var2 = BufferUtils.createIntBuffer(16);
      GL11.glGetInteger(3088, var2);
      this.c3587.setX(var2.get());
      this.c3587.c798(var2.get());
      this.c3587.setWidth(var2.get());
      this.c3587.setHeight(var2.get());
      this.c4446(this.c3587);
      super.render(flag);
      GL11.glDisable(3089);
   }

   public void draw() {
      super.draw();
      if (this.isHovering()) {
         int dWheel = Mouse.getDWheel();
         if (dWheel != 0) {
            this.setWheel(dWheel > 0 ? -2 : 2);
         }
      }

      double var9 = this.c830();
      double var3 = this.getHeight() / var9;
      if (var9 > this.c3429) {
         double var5 = this.c1288;
         double var7 = var9 - this.Back.getHeight();
         this.c1288 = var5;
         if (this.c1288 > var7) {
            this.c1288 = var7;
         } else if (this.c1288 < 0.0) {
            this.c1288 = 0.0;
         }
      }

      if (var9 > this.c3429) {
         this.onOffset(this.c3429);
         this.drager.onOffset(var3 * this.getHeight());
         this.drager.setDisplayable(true);
         this.Back.onOffset(this.getHeight());
      } else {
         this.c1288 = 0.0;
         this.c2967 = 0.0;
         this.drager.onOffset(0.0);
         this.drager.setDisplayable(false);
         this.Back.onOffset(var9 + 2.0);
      }

      this.Back.c467(this.Back.getY() + this.c1288);
      this.drager.c467(this.drager.getY() + this.c2967);
      if (this.isDragin()) {
         this.setWheel(this.c152());
      }

   }

   public void setWidth(double var1) {
      super.setWidth(var1);

      for (IGuiComponent var4 : this.Back.getComponents()) {
         var4.setWidth(this.getWidth() - 5.0);
      }

   }

   public void onOffset(double var1) {
      super.onOffset(var1);
      this.c3429 = var1;
      this.Back.onOffset(var1);
   }

   public boolean isDragin() {
      return this.drag;
   }

   public void setDragState(boolean var1) {
      this.drag = var1;
   }

   public boolean c4828(int var1, int var2, int var3) {
      return super.c4828(var1, var2, var3);
   }

   public void c8120(IGuiComponent var1) {
      this.Back.addComponent(var1);
      this.draw();
   }

   public FrameComponent c6047() {
      return this.Back;
   }

   public double c830() {
      double var1 = 0.0;

      for (IGuiComponent var4 : this.Back.getComponents()) {
         if (var4.displayable()) {
            var1 += var4.getHeight();
         }
      }

      return var1;
   }

   public void setWheel(int delta) {
      double var2 = this.c830();
      double var4 = this.getHeight() / var2;
      if (var2 > this.c3429) {
         double var6 = (double)delta / var4 + this.c1288;
         double var8 = var2 - this.Back.getHeight();
         this.c1288 = var6;
         if (this.c1288 > var8) {
            this.c1288 = var8;
         } else if (this.c1288 < 0.0) {
            this.c1288 = 0.0;
         }

         double var10 = this.c2967 + (double)delta;
         double var12 = this.getHeight() - this.drager.getHeight();
         this.c2967 = var10;
         if (this.c2967 > var12) {
            this.c2967 = var12;
         } else if (this.c2967 < 0.0) {
            this.c2967 = 0.0;
         }
      }

   }

   public boolean c2855() {
      return this.drager.displayable();
   }

   // $FF: synthetic method
   static double c1751(SliderInFrame var0) {
      return var0.c1288;
   }
}
