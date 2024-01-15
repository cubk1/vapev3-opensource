package gg.vape.ui.click.frame.impl;

import func.skidline.c5314;
import func.skidline.c7721;
import gg.vape.Vape;
import gg.vape.mapping.MappedClasses;
import gg.vape.ui.click.actions.ActionRemoveLimit;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.IFrameComponent;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.unmap.ItemLimitData;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.ImageRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.utils.render.RenderUtils;
import gg.vape.value.LimitValue;
import gg.vape.wrapper.impl.*;
import org.lwjgl.opengl.GL11;

import java.util.Iterator;

public class FrameLimitManager extends SquareButton implements IFrameComponent {
   public final ItemLimitData c2421;
   public final LimitValue c8732;

   public FrameLimitManager(c7721 var1, ItemLimitData var2, LimitValue var3) {
      super("", false);
      this.c8732 = var3;
      this.c2421 = var2;
      this.onRendererHandling(new PoseRenderer(2.0, 10.0, 1, 1, new PoseMatrix(0, 0, 0, 0)));
      this.onOffset(12.0);
      this.setWidth(var1.getWidth());
      this.addAction(new c5314(this));
      SquareButton var4 = new SquareButton("x", true);
      var4.onOffset(12.0);
      var4.setWidth(12.0);
      var4.addAction(new ActionRemoveLimit(this, var3, var2));
      var1.addComponent(this);
      var1.addComponent(var4);
      IntractiveComponent var5 = new IntractiveComponent("", RenderFlag.Regular, 1.0);
      var5.onOffset(2.0);
      var1.addComponent(var5);
   }

   public void render(boolean flag) {
      super.render(flag);
      FontRenderer var2 = Minecraft.getFontRenderer();
      Item var3 = null;
      String var4 = null;

      try {
         var3 = Item.c8896(Integer.parseInt(this.c2421.getName()));
      } catch (Exception var6) {
         var3 = getItemByName(this.c2421.getName());
      }

      if (var3 != null && var3.isNotNull()) {
         var4 = var3.c2090(ItemStack.c8898(var3));
         if (this.c2421.c7976() != -1) {
            var4 = this.c2421.getName() + ":" + this.c2421.c7976();
         }
      }

      RenderUtils.c2096(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight(), this.isHovering() ? this.c8732.c5443().darker() : this.c8732.c5443());
      GL11.glColor4d(1.0, 1.0, 1.0, 1.0);
      if (var4 != null) {
         var2.c3769(var4, this.getX() + 15.0, this.getY() + 4.0, -1, 0.5);
      } else {
         var2.c3769(this.c2421.getName(), this.getX() + 15.0, this.getY() + 4.0, -1, 0.5);
      }

      if (this.c2421.c6483() != -1) {
         var2.drawStringWithShadow(this.c2421.c6483() + "", this.getX() + this.getWidth() - (double)var2.getStringWidth(this.c2421.c6483() + "") - 2.0, this.getY() + 2.0, -1);
      }

      RenderUtils.c7048(this.getX(), this.getY(), this.getX() + 12.0, this.getY() + 12.0, -16777216);
      if (this.c2346()) {
         ImageRenderer.drawRes(Vape.instance.getSettings().guiColor.getAsColor(), (float)this.getX() + 1.0F, (float)this.getY() - 1.0F, "check", 0.38F);
      }

   }

   public static Item getItemByName(String name) {
      Iterator<?> iterator = Item.c7128().c4424().iterator();
      String itemName = "";

      while (iterator.hasNext()) {
         Object item = null;
         if (ForgeVersion.minorVersion() == 13) {
            itemName = (String) iterator.next();
            item = Item.c7128().c1233(itemName);
         } else {
            ResourceLocation resourceLocation = new ResourceLocation(iterator.next());
            itemName = resourceLocation.c6376();
            item = Item.c7128().c1233(resourceLocation.getObject());
         }

         itemName = itemName.replace("minecraft:", "").toLowerCase();
         assert MappedClasses.Item != null;
         if (MappedClasses.Item.isInstance(item)) {
            Item newItem = new Item(item);
            if (itemName.equalsIgnoreCase(name)) {
               return newItem;
            }
         }
      }

      return null;
   }

   public void toggle() {
      this.c2421.c5492(!this.c2421.c276());
   }

   public boolean c2346() {
      return this.c2421.c276();
   }

   public void c8121(boolean var1) {
      this.c2421.c5492(var1);
   }

   public ItemLimitData c1507() {
      return this.c2421;
   }
}
