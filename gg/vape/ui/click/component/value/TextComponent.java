package gg.vape.ui.click.component.value;

import func.skidline.c963;
import gg.vape.ui.click.IActionComponent;
import gg.vape.ui.click.IEditable;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.TimerUtil;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.utils.render.RenderUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

public class TextComponent extends GuiComponent implements IEditable, c963 {
   public static final int c4332 = 2;
   public final IntractiveComponent c3116;
   public final IntractiveComponent c2387;
   public final TimerUtil c8209;
   public final TimerUtil c5188;
   public String c3192;
   public int c1332;
   public double c3562;
   public boolean c8603;

   public TextComponent(int var1) {
      this.c3116 = new IntractiveComponent("", RenderFlag.Regular, 1.0);
      this.c2387 = new IntractiveComponent("_", RenderFlag.Regular, 1.0);
      this.c8209 = new TimerUtil();
      this.c5188 = new TimerUtil();
      this.c3192 = "";
      this.c3562 = 0.0;
      this.c8603 = false;
      this.c1332 = var1;
      PoseRenderer var2 = new PoseRenderer(0.0, 0.0, 1, 3, new PoseMatrix(0, 2, 0, 2));
      var2.c4895();
      this.onRendererHandling(var2);
      this.c3116.c7363(false);
      this.addComponent(this.c3116);
      this.c2387.setWidth(this.getFont().getStringWidth("_"));
      this.c2387.c7363(false);
      this.addComponent(this.c2387);
      this.c2888(null, new c7732(this));
   }
   class c7732 implements IActionComponent {
      // $FF: synthetic field
      final TextComponent c7256;

      c7732(TextComponent var1) {
         this.c7256 = var1;
      }

      public void c4493(IGuiComponent var1, int var2, int var3, int var4) {
         if (var4 == 0) {
            this.c7256.setEditing(true);
         }

      }
   }
   public TextComponent() {
      this(1000);
   }

   public IntractiveComponent c7232() {
      return this.c3116;
   }

   public void render(boolean flag) {
      if (this.displayable()) {
         RenderUtils.c2266(this.getX(), this.getY(), this.getWidth(), this.getHeight());
         GL11.glEnable(GL11.GL_BLEND);
         GL11.glDisable(GL11.GL_TEXTURE_2D);
         GL11.glBlendFunc(770, 771);
         RenderUtils.drawComponentSquare(this.getColor(), this.c755(), this, 4);
         RenderUtils.drawComponent(this.isEditing() ? hoveringColor.darker() : hoveringColor.brighter().brighter().brighter(), this);
         GL11.glEnable(GL11.GL_TEXTURE_2D);
         GL11.glDisable(GL11.GL_BLEND);
         super.render(flag);
         if (!this.c3192.isEmpty() && !this.isEditing() && this.c3116.getName().isEmpty()) {
            this.c3116.drawStr(this.c3192, this.c3116.getX(), this.c3116.getY(), Color.LIGHT_GRAY);
         }

         GL11.glDisable(3089);
      }

   }

   public void draw() {
      super.draw();
      if (this.isEditing()) {
         String var1;
         if (this.c8209.hasTimeElapsed(600L)) {
            this.c8209.reset();
            var1 = this.c2387.getName();
            this.c2387.setName(var1.equals("_") ? "" : "_");
         }

         if (Keyboard.isKeyDown(14) && this.c5188.hasTimeElapsed(100L)) {
            this.c2387.setName("_");
            this.c5188.reset();
            var1 = this.c3116.getName();
            if (var1.length() > 0) {
               this.c3116.setName(var1.substring(0, var1.length() - 1));
            }
         }
      } else {
         this.c2387.setName("");
      }

      this.c3116.setWidth(this.getFont().getStringWidth(this.c3116.getName()));
      double var3 = this.c3116.getWidth() - this.getWidth();
      if (var3 > 0.0) {
         this.c3116.c1042(this.getX() - var3);
      }

   }

   public void onOffset(double var1) {
      super.onOffset(var1);
      this.c3116.onOffset(var1);
      this.c2387.onOffset(var1);
   }

   public boolean c3210(char var1, int var2) {
      if (!this.isEditing()) {
         return super.c3210(var1, var2);
      } else if (var2 == 1) {
         this.setEditing(false);
         return true;
      } else {
         if (var1 == 22 && Keyboard.isKeyDown(29)) {
            Transferable var3 = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            if (var3 != null && var3.isDataFlavorSupported(DataFlavor.stringFlavor)) {
               try {
                  this.c3116.setName((String)var3.getTransferData(DataFlavor.stringFlavor));
               } catch (Exception var5) {
                  var5.printStackTrace();
               }
            }
         }

         if ((var1 == 167 || var1 < ' ' || var1 == 127) && var2 != 0) {
            return true;
         } else {
            String var6 = this.c3116.getName();
            if (var6.length() <= this.c1332 && var2 != 14 && var1 != 0) {
               this.c3116.setName(var6 + var1);
            }

            return true;
         }
      }
   }

   public boolean c4828(int var1, int var2, int var3) {
      if (!this.isHovering()) {
         this.setEditing(false);
      }

      if (this.isHovering() && var3 == 1) {
         this.c3116.setName("");
      }

      return super.c4828(var1, var2, var3);
   }

   public double c755() {
      return this.c3562;
   }

   public void c707(double var1) {
      this.c3562 = var1;
   }

   public IntractiveComponent c8589() {
      return this.c3116;
   }

   public int c1696() {
      return this.c1332;
   }

   public void c5305(int var1) {
      this.c1332 = var1;
   }

   public boolean isEditing() {
      return this.c8603;
   }

   public void setEditing(boolean editing) {
      this.c8603 = editing;
   }

   public String c6948() {
      return this.c3192;
   }

   public void c7057(String var1) {
      this.c3192 = var1;
   }
}
