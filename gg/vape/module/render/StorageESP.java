package gg.vape.module.render;

import gg.vape.event.impl.EventRender3D;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.utils.datas.HSBAData;
import gg.vape.utils.datas.HSBData;
import gg.vape.utils.render.RenderUtil;
import gg.vape.value.BooleanValue;
import gg.vape.value.ColorValue;
import gg.vape.wrapper.impl.*;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.Iterator;

public class StorageESP extends Mod {
   public final RenderManager c6382;
   public final BooleanValue c1398 = BooleanValue.create(this, "Outline open", true, "Outlines open chests by contrasting color");
   public final BooleanValue c8184 = BooleanValue.create(this, "Render Chests", true);
   public final BooleanValue c7993 = BooleanValue.create(this, "Render Enderchests", false);
   public final BooleanValue c1173 = BooleanValue.create(this, "Render Hopper", false);
   public final BooleanValue c6591 = BooleanValue.create(this, "Render Furnace", false);
   public final BooleanValue c4161 = BooleanValue.create(this, "Render Dispenser", false);
   public final BooleanValue c2376 = BooleanValue.create(this, "Render Dropper", false);
   public final ColorValue c171 = ColorValue.create(this, "Chest Color", new Color(1, 255, 146, 100));
   public final ColorValue c1052 = ColorValue.create(this, "Ender Chest Color", new Color(1, 255, 146, 100));
   public final ColorValue c4755 = ColorValue.create(this, "Hopper Color", new Color(1, 255, 146, 100));
   public final ColorValue c4678 = ColorValue.create(this, "Furnace Color", new Color(1, 255, 146, 100));
   public final ColorValue c6529 = ColorValue.create(this, "Dispenser Color", new Color(1, 255, 146, 100));
   public final ColorValue c2318 = ColorValue.create(this, "Dropper Color", new Color(1, 255, 146, 100));

   public StorageESP() {
      super("StorageESP", 3465010, Category.Render);
      this.c8184.getLimits().add(this.c171);
      this.c7993.getLimits().add(this.c1052);
      this.c1173.getLimits().add(this.c4755);
      this.c6591.getLimits().add(this.c4678);
      this.c4161.getLimits().add(this.c6529);
      this.c2376.getLimits().add(this.c2318);
      this.addValue(this.c1398, this.c8184, this.c171, this.c7993, this.c1052, this.c1173, this.c4755, this.c6591, this.c4678, this.c4161, this.c6529, this.c2376, this.c2318);
      this.c6382 = Minecraft.c5612();
   }

   public void onRender3D(EventRender3D event) {
      Minecraft.c2698().c6766(1.0);
      GL11.glPushMatrix();
      GL11.glEnable(GL11.GL_BLEND);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.5F);
      GL11.glDisable(GL11.GL_TEXTURE_2D);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      double var2 = this.c6382.c1779();
      double var4 = this.c6382.c7584();
      double var6 = this.c6382.c63();
      Iterator var8 = Minecraft.theWorld().c1445().iterator();

      while(var8.hasNext()) {
         Object var9 = var8.next();
         Color var10 = null;
         Object var11 = null;
         if (this.c8184.getValue() && MappedClasses.TileEntityChest.isInstance(var9)) {
            var10 = this.c171.getAsColor();
            var11 = new TileEntityOpenedChest(var9);
         } else if (this.c7993.getValue() && MappedClasses.TileEntityEnderChest.isInstance(var9)) {
            var10 = this.c1052.getAsColor();
            var11 = new TileEntityChest(var9);
         } else if (this.c1173.getValue() && MappedClasses.TileEntityHopper.isInstance(var9)) {
            var10 = this.c4755.getAsColor();
         } else if (this.c6591.getValue() && MappedClasses.TileEntityFurnace.isInstance(var9)) {
            var10 = this.c4678.getAsColor();
         } else if (this.c2376.getValue() && MappedClasses.TileEntityDropper.isInstance(var9)) {
            var10 = this.c2318.getAsColor();
         } else if (this.c4161.getValue() && MappedClasses.TileEntityDispenser.isInstance(var9)) {
            var10 = this.c6529.getAsColor();
         }

         if (var10 != null) {
            if (var11 == null) {
               var11 = new TileEntity(var9);
            }

            var10 = new Color(var10.getRed(), var10.getGreen(), var10.getBlue(), 100);
            Object var12;
            if (var11 instanceof TileEntityOpenedChest) {
               TileEntityOpenedChest var13 = (TileEntityOpenedChest)var11;
               if (this.c1398.getValue()) {
                  var12 = new HSBAData(((TileEntity)var11).c1744(), ((TileEntity)var11).c3715(), ((TileEntity)var11).c7544(), -1, var10, var13.c8901());
               } else {
                  var12 = new HSBData(((TileEntity)var11).c1744(), ((TileEntity)var11).c3715(), ((TileEntity)var11).c7544(), -1, var10);
               }
            } else if (var11 instanceof TileEntityChest) {
               TileEntityChest var14 = (TileEntityChest)var11;
               var12 = new HSBAData(((TileEntity)var11).c1744(), ((TileEntity)var11).c3715(), ((TileEntity)var11).c7544(), -1, var10, var14.c8901());
            } else {
               var12 = new HSBData(((TileEntity)var11).c1744(), ((TileEntity)var11).c3715(), ((TileEntity)var11).c7544(), -1, var10);
            }

            RenderUtil.c5751(var2, var4, var6, (HSBData)var12, var10);
         }
      }

      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glEnable(GL11.GL_TEXTURE_2D);
      GL11.glDisable(2848);
      GL11.glDisable(GL11.GL_BLEND);
      GL11.glPopMatrix();
      Minecraft.c2698().c4997(1.0);
   }
}
