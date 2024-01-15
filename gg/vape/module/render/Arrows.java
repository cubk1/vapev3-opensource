package gg.vape.module.render;

import gg.vape.event.impl.EventPreRenderLivingEvent;
import gg.vape.event.impl.EventRender3D;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.none.ClientSettings;
import gg.vape.unmap.ColorUtil;
import gg.vape.utils.render.ImageRenderer;
import gg.vape.utils.render.RenderUtil;
import gg.vape.utils.render.RenderUtils;
import gg.vape.value.BooleanValue;
import gg.vape.value.ColorValue;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.*;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Arrows extends Mod {
   public final ColorValue c2259 = ColorValue.create(this, "Color", new Color(255, 0, 0));
   public final BooleanValue c5482 = BooleanValue.create(this, "Show Distance", false, "Renders the distance next to the arrow.");
   public final BooleanValue c7853 = BooleanValue.create(this, "Scale Opacity", false, "Lowers the opacity the farther they are.");
   public final BooleanValue c4032 = BooleanValue.create(this, "Healthbar", false, "Renders a healthbar under the distance.");
   public final NumberValue c6329 = NumberValue.create(this, "Radius Scale", "#.##", "%", 0.0, 0.5, 1.0, 0.05);
   public final Map c2549 = new HashMap();

   public Arrows() {
      super("Arrows", 14223934, Category.Render, "Draws arrows on screen when players\nare out of your field of view.");
      this.addValue(this.c2259, this.c6329, this.c5482, this.c7853);
   }

   public void onRender3D(EventRender3D event) {
      this.c2549.clear();
      RenderManager var2 = Minecraft.c5612();
      Iterator var3 = Minecraft.theWorld().loadedEntityList().iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         if (MappedClasses.EntityPlayer.isAssignableFrom(var4.getClass()) && !MappedClasses.EntityPlayerSP.isAssignableFrom(var4.getClass())) {
            EntityPlayer var5 = new EntityPlayer(var4);
            double var6 = var5.c5823() + (var5.posX() - var5.c5823()) * (double) event.getPartialTicks() - var2.c1779();
            double var8 = var5.c8561() + (var5.posY() - var5.c8561()) * (double) event.getPartialTicks() - var2.c7584();
            double var10 = var5.c7002() + (var5.posZ() - var5.c7002()) * (double) event.getPartialTicks() - var2.c63();
            double[] var12 = RenderUtil.c6964(var6, var8, var10);
            this.c2549.put(var5, var12);
         }
      }

   }

   public void onPreRenderLiving(EventPreRenderLivingEvent event) {
      if (!Minecraft.theWorld().isNull()) {
         Entity var2 = event.c4766();
         if (var2.isInstance(MappedClasses.EntityPlayer)) {
            if (!ClientSettings.not1710 || !var2.isInstance(MappedClasses.MouseEvent)) {
               EntityPlayer var3 = new EntityPlayer(var2.getObject());
               double var4 = event.c8077();
               double var6 = event.c6847();
               double var8 = event.c6093();
               double[] var10 = RenderUtil.c6964(var4, var6, var8);
               this.c2549.put(var3, var10);
            }
         }
      }
   }

   public void onRender2D(RenderGameOverlayEvent event) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      if (!var2.isNull() && !var2.getWorld().isNull()) {
         if (!event.isCancelable() && event.c2913()) {
            ScaledResolution var3 = ScaledResolution.create(new Minecraft(), Minecraft.displayWidth(), Minecraft.displayHeight());
            float var4 = (float)(var3.getScaledWidth() / 2);
            float var5 = (float)(var3.getScaledHeight() / 2);
            double var6 = (double)var5 * this.c6329.getValue();
            RenderUtils.drawRect(Color.WHITE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
            FontRenderer var8 = Minecraft.getFontRenderer();
            Iterator var9 = this.c2549.keySet().iterator();

            while(true) {
               Entity var10;
               double[] var11;
               double var12;
               double var14;
               do {
                  if (!var9.hasNext()) {
                     this.c2549.clear();
                     return;
                  }

                  var10 = (Entity)var9.next();
                  var11 = (double[])this.c2549.get(var10);
                  var12 = var11[0];
                  var14 = (double) Minecraft.displayHeight() - var11[1];
               } while(var11[2] < 1.0 && this.c1720(var12, var14, var3));

               float var16 = this.c7587(var4, var12 / (double)var3.c1744(), var5, var14 / (double)var3.c1744()) + (float)(var11[2] > 1.0 ? 180 : 0);
               double var17 = var6 * Math.cos(Math.toRadians(var16));
               double var19 = var6 * Math.sin(Math.toRadians(var16));
               int var21 = (int)(var2.getDistanceToEntity(var10) * 2.0F);
               if (var21 > 255) {
                  var21 = 255;
               }

               Color var23;
               if (this.c5482.getValue() && var21 < 225) {
                  GL11.glPushMatrix();
                  String var22 = (int)var2.getDistanceToEntity(var10) + "m";
                  GL11.glTranslated(var17 + (double)(var3.getScaledWidth() / 2), var19 + (double)(var3.getScaledHeight() / 2), 0.0);
                  GL11.glScaled(0.5, 0.5, 0.0);
                  GlStateManager.enableBlend();
                  var23 = new Color(255, 255, 255, 255 - (this.c7853.getValue() ? var21 : 0));
                  var8.drawStringWithShadow(var22, -var8.getStringWidth(var22) / 2, -var8.c3988(var22), ColorUtil.c5639(var23.getRed(), var23.getGreen(), var23.getBlue(), var23.getAlpha()));
                  GlStateManager.disableBlend();
                  GL11.glPopMatrix();
               }

               GL11.glPushMatrix();
               GL11.glTranslated(var17 + (double)(var3.getScaledWidth() / 2), var19 + (double)(var3.getScaledHeight() / 2), 0.0);
               GL11.glRotatef(var16 - 90.0F, 0.0F, 0.0F, 1.0F);
               GL11.glScaled(0.375, 0.5, 0.0);
               Color var24 = this.c2259.getAsColor();
               var23 = new Color(var24.getRed(), var24.getGreen(), var24.getBlue(), 255 - (this.c7853.getValue() ? var21 : 0));
               ImageRenderer.drawResWithShadow(var23, -16.0F, 0.0F, "exo", 1.0F, false);
               GL11.glPopMatrix();
            }
         }
      }
   }

   public boolean c1720(double var1, double var3, ScaledResolution var5) {
      return var1 > 0.0 && var3 > 0.0 && var1 < (double) Minecraft.displayWidth() && var3 < (double) Minecraft.displayHeight();
   }

   public float c7587(double var1, double var3, double var5, double var7) {
      return (float)Math.toDegrees(Math.atan2(var7 - var5, var3 - var1));
   }
}
