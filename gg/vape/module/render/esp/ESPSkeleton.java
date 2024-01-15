package gg.vape.module.render.esp;

import gg.vape.Vape;
import gg.vape.event.impl.EventRender3D;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Mod;
import gg.vape.module.SubModule;
import gg.vape.module.render.ESP;
import gg.vape.utils.render.RenderUtils;
import gg.vape.wrapper.impl.*;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.Iterator;

public class ESPSkeleton extends SubModule {
   public final ESP c1359 = (ESP)this.getParent();

   public ESPSkeleton(Mod var1, String var2) {
      super(var1, var2);
   }

   public void onRender3D(EventRender3D event) {
      float var2 = 57.29578F;
      RenderManager var3 = Minecraft.c5612();
      GL11.glPushMatrix();
      GL11.glDisable(2929);
      Minecraft.c2698().c6766(0.0);
      double var4 = var3.c1779();
      double var6 = var3.c7584();
      double var8 = var3.c63();
      Iterator var10 = Minecraft.theWorld().loadedEntityList().iterator();

      while(true) {
         Color var12;
         EntityPlayer var13;
         do {
            Object var11;
            do {
               do {
                  if (!var10.hasNext()) {
                     GL11.glColor3d(1.0, 1.0, 1.0);
                     Minecraft.c2698().c4997(0.0);
                     GL11.glEnable(2929);
                     GL11.glPopMatrix();
                     return;
                  }

                  var11 = var10.next();
               } while(!MappedClasses.EntityPlayer.isAssignableFrom(var11.getClass()));

               var12 = this.c1359.c1862(var11);
            } while(var12 == null);

            var13 = new EntityPlayer(var11);
         } while(Vape.instance.getSettings().c2159(var13) && this.c1359.hideBots.getValue());

         if (Vape.instance.getSettings().c5510(var13)) {
            var12 = Color.BLUE;
         }

         double var14 = var13.c5823() + (var13.posX() - var13.c5823()) * (double) event.getPartialTicks() - var4;
         double var16 = var13.c8561() + (var13.posY() - var13.c8561()) * (double) event.getPartialTicks() - var6;
         double var18 = var13.c7002() + (var13.posZ() - var13.c7002()) * (double) event.getPartialTicks() - var8;
         boolean var20 = GL11.glIsEnabled(GL11.GL_BLEND);
         GL11.glPushMatrix();
         GL11.glBlendFunc(770, 771);
         if (!var20) {
            GL11.glEnable(GL11.GL_BLEND);
         }

         GL11.glBlendFunc(770, 771);
         RenderUtils.setColor(var12);
         GL11.glEnable(2848);
         GL11.glLineWidth(4.0F);
         GL11.glDisable(GL11.GL_TEXTURE_2D);
         GL11.glTranslated(var14, var16, var18);
         Render var21 = this.c1359.c3224.c225(var13);
         if (var21.isInstance(MappedClasses.RenderPlayer)) {
            RenderPlayer var22 = new RenderPlayer(var21.getObject());
            ModelBase var23 = var22.c2490();
            if (var23.isNotNull() && var23.isInstance(MappedClasses.ModelBiped)) {
               ModelBiped var24 = new ModelBiped(var23.getObject());
               boolean var25 = var13.isSneaking();
               float var26 = var25 ? 0.6F : 0.75F;
               GL11.glRotatef(var13.c3796(), 0.0F, -999.0F, 0.0F);
               double var27 = var25 ? -0.2 : 0.0;
               GL11.glTranslated(-0.15, var26, var27);
               float var29 = var24.c3060().c6299() * var2;
               float var30 = var24.c3060().c6767() * var2;
               float var31 = var24.c3060().c3455() * var2;
               GL11.glRotatef(var29, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(-var30, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-var31, 0.0F, 0.0F, 1.0F);
               GL11.glBegin(1);
               GL11.glVertex3d(0.0, 0.0, 0.0);
               GL11.glVertex3d(0.0, -var26, 0.0);
               GL11.glEnd();
               GL11.glRotatef(var31, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(var30, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-var29, 1.0F, 0.0F, 0.0F);
               GL11.glTranslated(0.3, 0.0, 0.0);
               var29 = var24.c8677().c6299() * var2;
               var30 = var24.c8677().c6767() * var2;
               var31 = var24.c8677().c3455() * var2;
               GL11.glRotatef(var29, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(-var30, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-var31, 0.0F, 0.0F, 1.0F);
               GL11.glBegin(1);
               GL11.glVertex3d(0.0, 0.0, 0.0);
               GL11.glVertex3d(0.0, -var26, 0.0);
               GL11.glEnd();
               GL11.glRotatef(var31, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(var30, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-var29, 1.0F, 0.0F, 0.0F);
               GL11.glTranslated(-0.15, 0.0, 0.0);
               GL11.glBegin(1);
               GL11.glVertex3d(0.15, 0.0, 0.0);
               GL11.glVertex3d(-0.15, 0.0, 0.0);
               GL11.glEnd();
               if (var13.isSneaking()) {
                  GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
               }

               GL11.glBegin(1);
               GL11.glVertex3d(0.0, 0.0, 0.0);
               GL11.glVertex3d(0.0, 0.65, 0.0);
               GL11.glEnd();
               GL11.glTranslated(0.0, 0.65, 0.0);
               GL11.glBegin(1);
               GL11.glVertex3d(0.35, 0.0, 0.0);
               GL11.glVertex3d(-0.35, 0.0, 0.0);
               GL11.glEnd();
               GL11.glTranslated(-0.35, 0.0, 0.0);
               var29 = var24.c2407().c6299() * var2;
               var30 = var24.c2407().c6767() * var2;
               var31 = var24.c2407().c3455() * var2;
               GL11.glRotatef(var29, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(-var30, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-var31, 0.0F, 0.0F, 1.0F);
               GL11.glBegin(1);
               GL11.glVertex3d(0.0, 0.0, 0.0);
               GL11.glVertex3d(0.0, -0.6, 0.0);
               GL11.glEnd();
               GL11.glRotatef(var31, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(var30, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-var29, 1.0F, 0.0F, 0.0F);
               GL11.glTranslated(0.7, 0.0, 0.0);
               var29 = var24.c6752().c6299() * var2;
               var30 = var24.c6752().c6767() * var2;
               var31 = var24.c6752().c3455() * var2;
               GL11.glRotatef(var29, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(-var30, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-var31, 0.0F, 0.0F, 1.0F);
               GL11.glBegin(1);
               GL11.glVertex3d(0.0, 0.0, 0.0);
               GL11.glVertex3d(0.0, -0.6, 0.0);
               GL11.glEnd();
               GL11.glRotatef(var31, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(var30, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-var29, 1.0F, 0.0F, 0.0F);
               GL11.glTranslated(-0.35, 0.0, 0.0);
               GL11.glRotatef(-var13.c3796(), 0.0F, -999.0F, 0.0F);
               double var32 = 0.4;
               GL11.glRotated(var13.rotationYaw(), 0.0, -999.0, 0.0);
               GL11.glRotated(var13.rotationPitch(), 999.0, 0.0, 0.0);
               GL11.glBegin(1);
               GL11.glVertex3d(0.0, 0.0, 0.0);
               GL11.glVertex3d(0.0, var32, 0.0);
               GL11.glEnd();
               GL11.glBegin(1);
               GL11.glVertex3d(0.0, var32, 0.0);
               GL11.glVertex3d(0.0, var32, 0.25);
               GL11.glEnd();
               GL11.glRotated(var13.rotationPitch(), 999.0, 0.0, 0.0);
               GL11.glRotated(-var13.rotationYaw(), 0.0, 999.0, 0.0);
            }
         }

         if (!var20) {
            GL11.glDisable(GL11.GL_BLEND);
         }

         GL11.glEnable(GL11.GL_TEXTURE_2D);
         GL11.glDisable(2848);
         GL11.glPopMatrix();
      }
   }
}
