package gg.vape.ui.click.frame.impl;

import com.google.gson.JsonObject;
import func.skidline.c7721;
import gg.vape.Vape;
import gg.vape.ui.click.actions.ActionRemoveFormList;
import gg.vape.ui.click.actions.ActionToggleItemCheck;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.IFrameComponent;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.ImageRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.utils.render.RenderUtils;
import gg.vape.value.OptionalLimitValue;
import gg.vape.wrapper.impl.FontRenderer;
import gg.vape.wrapper.impl.Minecraft;
import org.lwjgl.opengl.GL11;

public class FrameItemLimitList extends SquareButton implements IFrameComponent {
   public String name;
   public final OptionalLimitValue c8489;
   public boolean checked = true;

   public FrameItemLimitList(c7721 var1, String var2, OptionalLimitValue var3) {
      super("", false);
      this.c8489 = var3;
      this.name = var2;
      this.onRendererHandling(new PoseRenderer(2.0, 10.0, 1, 1, new PoseMatrix(0, 0, 0, 0)));
      this.onOffset(12.0);
      this.setWidth(var1.getWidth());
      this.addAction(new ActionToggleItemCheck(this));
      SquareButton var4 = new SquareButton("x", true);
      var4.onOffset(12.0);
      var4.setWidth(12.0);
      var4.addAction(new ActionRemoveFormList(this, var3));
      var1.addComponent(this);
      var1.addComponent(var4);
      IntractiveComponent var5 = new IntractiveComponent("", RenderFlag.Regular, 1.0);
      var5.onOffset(2.0);
      var1.addComponent(var5);
   }

   public void render(boolean flag) {
      super.render(flag);
      FontRenderer var2 = Minecraft.getFontRenderer();
      String var3 = this.name;
      RenderUtils.c2096(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight(), this.isHovering() ? this.c8489.c5443().darker() : this.c8489.c5443());
      GL11.glColor4d(1.0, 1.0, 1.0, 1.0);
      var2.c3769(var3, this.getX() + 15.0, this.getY() + 4.0, -1, 0.5);
      RenderUtils.c7048(this.getX(), this.getY(), this.getX() + 12.0, this.getY() + 12.0, -16777216);
      if (this.c2346()) {
         ImageRenderer.drawRes(Vape.instance.getSettings().guiColor.getAsColor(), (float)this.getX() + 1.0F, (float)this.getY() - 1.0F, "check", 0.38F);
      }

   }

   public void toggle() {
      this.checked = !this.checked;
   }

   public boolean c2346() {
      return this.checked;
   }

   public void c8121(boolean var1) {
      this.checked = var1;
   }

   public String getName() {
      return this.name;
   }

   public JsonObject toJson() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("item-id", this.name);
      var1.addProperty("enabled", this.checked);
      return var1;
   }

   public void c3055(JsonObject var1) {
      if (var1.get("item-id") != null) {
         this.name = var1.get("item-id").getAsString();
      }

      if (var1.get("enabled") != null) {
         this.checked = var1.get("enabled").getAsBoolean();
      }

   }
}
