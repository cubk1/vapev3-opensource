package gg.vape.module.render;

import com.google.common.collect.Lists;
import gg.vape.Vape;
import gg.vape.event.impl.*;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.utility.invcleaner.EventPreRenderPlayer;
import gg.vape.utils.render.RenderUtils;
import gg.vape.value.BooleanValue;
import gg.vape.value.ColorValue;
import gg.vape.wrapper.impl.*;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;

public class Chams extends Mod {
   public final BooleanValue c3827 = BooleanValue.create(this, "Hide Bots", false, "Doesn't apply chams on bots.");
   public final BooleanValue c4169 = BooleanValue.create(this, "Colored", false, "Colors entities.");
   public final ColorValue c8874 = ColorValue.create(this, "Visible Color", new Color(255, 0, 0));
   public final BooleanValue c3153 = BooleanValue.create(this, "Color Behind Walls", true, "Renders a different color when\nplayers are behind walls.");
   public final ColorValue c8046 = ColorValue.create(this, "Invisible Color", new Color(255, 255, 0));
   public boolean c2312;
   public EntityLivingBase c6454;
   public int c2716;

   public Chams() {
      super("Chams", -16711936, Category.Render, "Render players through walls.");
      this.addValue(this.c3827, this.c4169.limitValues(this.c8874, this.c3153.limitValues(this.c8046)), this.c8874, this.c3153, this.c8046);
   }

   public void onSpecPreRenderLiving(EventPreRenderPlayerSpec event) {
      if (!event.c4894().isInstance(MappedClasses.EntityPlayerSP)) {
         RenderPlayerEventSpecialsPre var2 = (RenderPlayerEventSpecialsPre) event.c6796();
         if (this.c2312) {
            if (!Minecraft.theWorld().isNull()) {
               event.c6796().setCancelled(true);
               var2.c335(false);
               var2.c175(false);
               var2.c2112(false);
            }
         }
      }
   }

   public void onPreRenderLiving(EventPreRenderLivingEvent event) {
      if (this.c2312) {
         if (!Minecraft.theWorld().isNull()) {
            EntityPlayerSP var2 = Minecraft.thePlayer();
            Entity var3 = event.c4766();
            if (!var3.equals(var2)) {
               event.c6796().setCancelled(true);
            }
         }
      }
   }

   public void onSetArmor(EventSetArmorModel event) {
      if (this.c2312) {
         if (Minecraft.theWorld().isNull()) {
            return;
         }

         RenderPlayerEvent_setArmorModel var2 = (RenderPlayerEvent_setArmorModel) event.c6796();
         var2.c33(0);
      }

   }

   public void onPreRenderLiving(EventPreRenderLiving event) {
      if (event.c6138().isInstance(MappedClasses.EntityPlayer) && !event.c6138().isInstance(MappedClasses.EntityPlayerSP) && this.c4169.getValue() && this.c2312) {
         if (this.c2716 == 1) {
            RenderUtils.setColor(this.c3153.getValue() ? this.c8046.getAsColor() : this.c8874.getAsColor());
         }

         if (this.c2716 == 2) {
            RenderUtils.setColor(this.c8874.getAsColor());
         }
      }

   }

   public void onPreRenderPlayer(EventPreRenderPlayer event) {
      if (!Vape.instance.getSettings().c2159(event.c4894()) || !this.c3827.getValue()) {
         ESP var2 = Vape.instance.getModManager().getMod(ESP.class);
         if (!this.c2312 && this.c2716 != 3 && (!var2.getState() || !var2.c5373())) {
            if (!this.c4169.getValue()) {
               if (event.c4894().isInstance(MappedClasses.EntityPlayer) && !event.c4894().isInstance(MappedClasses.EntityPlayerSP)) {
                  GL11.glEnable(32823);
                  GL11.glPolygonOffset(1.0F, -1100000.0F);
               }
            } else if (event.c4894().isNotNull() && event.c7576().isNotNull() && !event.c4894().isInstance(MappedClasses.EntityPlayerSP)) {
               if (ForgeVersion.minorVersion() == 13) {
                  event.c6796().setCancelled(true);
               }

               EntityPlayer var3 = event.c4894();
               double var4 = var3.c5823() + (var3.posX() - var3.c5823()) * (double) event.c2202() - Minecraft.c5612().c1779();
               double var6 = var3.c8561() + (var3.posY() - var3.c8561()) * (double) event.c2202() - Minecraft.c5612().c7584();
               double var8 = var3.c7002() + (var3.posZ() - var3.c7002()) * (double) event.c2202() - Minecraft.c5612().c63();
               float var10 = var3.c3825() + (var3.rotationYaw() - var3.c3825()) * event.c2202();
               GL11.glPushMatrix();
               GL11.glDisable(2929);
               GL11.glDisable(GL11.GL_TEXTURE_2D);
               GlStateManager.disableLighting();
               RenderUtils.setColor(this.c3153.getValue() ? this.c8046.getAsColor() : this.c8874.getAsColor());
               ArrayList var11 = null;
               if (ForgeVersion.minorVersion() > 13) {
                  var11 = Lists.newArrayList(event.c7576().c1445());
                  event.c7576().c1445().clear();
               }

               try {
                  this.c2312 = true;
                  this.c2716 = 1;
                  event.c7576().c3744(var3, var4, var6, var8, var10, event.c2202());
               } catch (Exception var14) {
               }

               this.c2312 = false;
               GL11.glEnable(2929);
               GL11.glEnable(GL11.GL_TEXTURE_2D);
               if (ForgeVersion.minorVersion() == 13) {
                  this.c2716 = 3;
                  GL11.glPushMatrix();
                  GL11.glEnable(2896);
                  event.c7576().c3744(var3, var4, var6, var8, var10, event.c2202());
                  GL11.glDepthMask(false);
                  GL11.glDisable(2896);
                  GL11.glPopMatrix();
               }

               this.c2312 = true;
               RenderUtils.setColor(this.c8874.getAsColor());
               GL11.glDisable(GL11.GL_TEXTURE_2D);

               try {
                  this.c2716 = 2;
                  event.c7576().c3744(var3, var4, var6, var8, var10, event.c2202());
                  this.c2312 = false;
               } catch (Exception var13) {
               }

               if (ForgeVersion.minorVersion() > 13) {
                  event.c7576().c1460(var11);
               }

               GL11.glEnable(GL11.GL_TEXTURE_2D);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               GlStateManager.enableLighting();
               GL11.glPopMatrix();
               this.c2716 = -1;
               if (!var3.c320()) {
                  this.c6454 = var3;
                  var3.c4992(true);
               }
            }

         }
      }
   }

   public void onPostRenderPlayer(EventPostRenderPlayer event) {
      if (!Vape.instance.getSettings().c2159(event.c4894()) || !this.c3827.getValue()) {
         if (this.c4169.getValue()) {
            if (this.c6454 != null) {
               EntityPlayer var2 = event.c4894();
               var2.c4992(false);
               this.c6454 = null;
            }

         } else {
            if (event.c4894().isInstance(MappedClasses.EntityPlayer) && !event.c4894().isInstance(MappedClasses.EntityPlayerSP)) {
               GL11.glDisable(32823);
               GL11.glPolygonOffset(1.0F, 1100000.0F);
            }

         }
      }
   }
}
