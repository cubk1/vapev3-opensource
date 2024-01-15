package gg.vape.module.render.esp;

import gg.vape.Vape;
import gg.vape.event.impl.EventRender3D;
import gg.vape.module.Mod;
import gg.vape.module.SubModule;
import gg.vape.module.blatant.HitBoxes;
import gg.vape.module.render.ESP;
import gg.vape.utils.render.RenderUtil;
import gg.vape.wrapper.impl.AxisAlignedBB;
import gg.vape.wrapper.impl.Entity;
import gg.vape.wrapper.impl.Minecraft;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.Iterator;

public class ESP3D extends SubModule {
   public final ESP c6592 = (ESP)this.getParent();
   public HitBoxes c7211;

   public ESP3D(Mod var1, String var2) {
      super(var1, var2);
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
      double var2 = this.c6592.c3224.c1779();
      double var4 = this.c6592.c3224.c7584();
      double var6 = this.c6592.c3224.c63();
      if (this.c7211 == null) {
         this.c7211 = Vape.instance.getModManager().getMod(HitBoxes.class);
      }

      Iterator var8 = Minecraft.theWorld().loadedEntityList().iterator();

      while(true) {
         Entity var10;
         Color var11;
         do {
            Object var9;
            do {
               if (!var8.hasNext()) {
                  GL11.glDepthMask(true);
                  GL11.glEnable(2929);
                  GL11.glEnable(GL11.GL_TEXTURE_2D);
                  GL11.glDisable(2848);
                  GL11.glDisable(GL11.GL_BLEND);
                  GL11.glPopMatrix();
                  Minecraft.c2698().c4997(1.0);
                  return;
               }

               var9 = var8.next();
               var10 = new Entity(var9);
            } while(Vape.instance.getSettings().c2159(var10) && this.c6592.hideBots.getValue());

            var11 = this.c6592.c1862(var9);
         } while(var11 == null);

         double var12 = var10.c5823() + (var10.posX() - var10.c5823()) * (double) event.getPartialTicks();
         double var14 = var10.c8561() + (var10.posY() - var10.c8561()) * (double) event.getPartialTicks();
         double var16 = var10.c7002() + (var10.posZ() - var10.c7002()) * (double) event.getPartialTicks();
         float var18 = var10.c3849() + (this.c6592.hitBox.getValue() && this.c7211.getState() ? this.c7211.c1764() : 0.0F);
         AxisAlignedBB var19 = var10.boundingBox().c6096(var18, var18, var18);
         RenderUtil.c2609(var12 - (var19.minX() - var19.c63()) / 2.0, var14 - (var14 - var19.minY()), var16 - (var19.c7584() - var19.c1898()) / 2.0, var19.c7584() - var19.c1898(), var19.c8246() - var19.minY(), var19.minX() - var19.c63(), 0.1, var11, null, var2, var4, var6);
         if (this.c7211.c8217() > 0.0F && this.c6592.hitBox.getValue() && this.c6592.showNormal.getValue()) {
            var19 = var10.boundingBox().c6096(var18 -= this.c7211.c1764(), var18, var18);
            Color var20 = new Color(255 - var11.getRed(), 255 - var11.getGreen(), 255 - var11.getBlue(), 70);
            RenderUtil.c2609(var12 - (var19.minX() - var19.c63()) / 2.0, var14 - (var14 - var19.minY()), var16 - (var19.c7584() - var19.c1898()) / 2.0, var19.c7584() - var19.c1898(), var19.c8246() - var19.minY(), var19.minX() - var19.c63(), 0.1, var20, null, var2, var4, var6);
         }
      }
   }
}
