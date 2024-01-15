package gg.vape.module.render.esp;

import gg.vape.event.impl.EventPreRenderLivingEvent;
import gg.vape.module.Mod;
import gg.vape.module.SubModule;
import gg.vape.module.render.ESP;
import gg.vape.utils.render.RenderUtil;
import gg.vape.utils.render.RenderUtils;
import gg.vape.wrapper.impl.Entity;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.RenderGameOverlayEvent;
import gg.vape.wrapper.impl.ScaledResolution;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ESP2D extends SubModule {
   public final ESP c5216 = (ESP)this.getParent();
   public final List c7987 = new ArrayList();

   public ESP2D(Mod var1, String var2) {
      super(var1, var2);
   }

   public void onPreRenderLiving(EventPreRenderLivingEvent event) {
      if (!Minecraft.theWorld().isNull()) {
         Entity var2 = event.c4766();
         double var3 = event.c8077();
         double var5 = event.c6847();
         double var7 = event.c6093();
         double var9 = var2.c1998() / 2.0F;
         double[] var11 = RenderUtil.c6964(var3, var5 - var9, var7);
         double[] var12 = RenderUtil.c6964(var3, var5 + var9, var7);
         Color var13 = this.c5216.c1862(var2.getObject());
         if (var13 != null) {
            if (!(var11[2] < 0.9) && !(var12[2] < 0.9)) {
               this.c7987.add(new double[]{var11[0], var11[1], var12[0], var12[1], (double)(var2.c8958() / var2.c1998()), (double)var13.getRGB()});
            }
         }
      }
   }

   public void onRender2D(RenderGameOverlayEvent event) {
      Iterator var2 = this.c7987.iterator();

      while(var2.hasNext()) {
         double[] var3 = (double[])var2.next();
         ScaledResolution var4 = ScaledResolution.create(new Minecraft(), Minecraft.displayWidth(), Minecraft.displayHeight());
         float var5 = (float) Minecraft.displayHeight();
         double var6 = ((double)var5 - var3[1]) / (double)var4.c1744();
         double var8 = var3[2] / (double)var4.c1744();
         double var10 = ((double)var5 - var3[3]) / (double)var4.c1744();
         double var12 = var10 - var6;
         double var14 = var12 * var3[4] / 2.0;
         var6 += var12 / 2.0;
         var10 += var12 / 2.0;
         GL11.glDisable(GL11.GL_TEXTURE_2D);
         GL11.glBlendFunc(770, 771);
         RenderUtils.setColor(new Color((int)var3[5]));
         GL11.glLineWidth(1.5F);
         GL11.glEnable(2848);
         GL11.glBegin(2);
         GL11.glVertex2d(var8 - var14, var6);
         GL11.glVertex2d(var8 + var14, var6);
         GL11.glVertex2d(var8 + var14, var10);
         GL11.glVertex2d(var8 - var14, var10);
         GL11.glEnd();
         GL11.glDisable(2848);
         GL11.glEnable(GL11.GL_TEXTURE_2D);
      }

      this.c7987.clear();
   }
}
