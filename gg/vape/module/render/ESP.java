package gg.vape.module.render;

import com.google.common.collect.Lists;
import gg.vape.Vape;
import gg.vape.event.impl.*;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.render.esp.ESP2D;
import gg.vape.module.render.esp.ESP3D;
import gg.vape.module.render.esp.ESPSkeleton;
import gg.vape.unmap.ModeSelection;
import gg.vape.utils.RotationUtil;
import gg.vape.utils.render.RenderUtils;
import gg.vape.utils.render.StencilUtil;
import gg.vape.value.BooleanValue;
import gg.vape.value.ColorValue;
import gg.vape.value.ModeValue;
import gg.vape.wrapper.impl.*;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ESP extends Mod {
   public final ModeSelection c4298 = new ModeSelection("3D");
   public final ModeSelection c1240 = new ModeSelection("2D");
   public final ModeSelection c325 = new ModeSelection("Outline");
   public final ModeSelection c8231 = new ModeSelection("Skeleton");
   public final ModeValue mode;
   public final ColorValue playerCol;
   public BooleanValue hideBots;
   public BooleanValue hitBox;
   public BooleanValue showNormal;
   public final BooleanValue invisibles;
   public RenderManager c3224;
   public boolean c8177;
   public int c2249;
   public boolean c222;
   public final ESP3D e3d;
   public final ESP2D e2d;
   public final ESPSkeleton esk;

   public ESP() {
      super("ESP", -16711936, Category.Render, "Extra Sensory Perception\nRenders an ESP on players.");
      this.mode = ModeValue.create(this, "Mode", this.c4298, this.c4298, this.c1240, this.c8231, this.c325);
      this.playerCol = ColorValue.create(this, "Player Color", Color.BLUE);
      this.hideBots = BooleanValue.create(this, "Hide Bots", false);
      this.hitBox = BooleanValue.create(this, "Hitbox", false, "Shows the current entity hitbox size.\n(HitBoxes expansion visible)\n(3D Only)");
      this.showNormal = BooleanValue.create(this, "Show Normal", false, "Shows the true entity hitbox size.\n(3D Only)");
      this.invisibles = BooleanValue.create(this, "Invisibles", false, "Show invisibles.");
      this.c8177 = false;
      this.c2249 = 0;
      this.e3d = new ESP3D(this, "3D");
      this.e2d = new ESP2D(this, "2D");
      this.esk = new ESPSkeleton(this, "Skeleton");
      this.c3224 = Minecraft.c5612();
      this.hitBox.limitValues(this.showNormal);
      this.addValue(this.playerCol, this.mode, this.hitBox, this.showNormal, this.invisibles, this.hideBots);
   }

   public boolean c5373() {
      return this.mode.getValue() == this.c325 && this.c222;
   }

   public void onSpecPreRenderLiving(EventPreRenderPlayerSpec event) {
      if (!Vape.instance.getSettings().c2159(event.c4894()) || !this.hideBots.getValue()) {
         if (this.mode.getValue() == this.c325) {
            if (Minecraft.theWorld().isNull()) {
               return;
            }

            if (this.c222) {
               event.c6796().setCancelled(true);
               RenderPlayerEventSpecialsPre var2 = (RenderPlayerEventSpecialsPre) event.c6796();
               var2.c335(false);
               var2.c175(false);
               var2.c2112(false);
            }
         }

      }
   }

   public void onRender2D(RenderGameOverlayEvent event) {
      if (this.mode.getValue() == this.c1240) {
         this.e2d.onRender2D(event);
      }

   }

   public void onSetArmor(EventSetArmorModel event) {
      if (!Vape.instance.getSettings().c2159(event.c4766()) || !this.hideBots.getValue()) {
         if (this.mode.getValue() == this.c325) {
            if (Minecraft.theWorld().isNull()) {
               return;
            }

            if (this.c222) {
               RenderPlayerEvent_setArmorModel var2 = (RenderPlayerEvent_setArmorModel) event.c6796();
               var2.c33(0);
            }
         }

      }
   }

   public void onPreRenderLiving(EventPreRenderLivingEvent event) {
      if (!Vape.instance.getSettings().c2159(event.c4766()) || !this.hideBots.getValue()) {
         if (this.mode.getValue() == this.c325) {
            if (!Minecraft.theWorld().isNull()) {
               EntityPlayerSP var2 = Minecraft.thePlayer();
               Entity var3 = event.c4766();
               if (!var3.equals(var2)) {
                  if (this.c222) {
                     event.c6796().setCancelled(true);
                  }

               }
            }
         } else {
            if (this.mode.getValue() == this.c1240) {
               this.e2d.onPreRenderLiving(event);
            }

         }
      }
   }

   public void onRender3D(EventRender3D event) {
      if (this.mode.getValue() != this.c1240) {
         if (this.mode.getValue() == this.c8231) {
            this.esk.onRender3D(event);
         }

         if (this.mode.getValue() == this.c4298) {
            this.e3d.onRender3D(event);
         }

         if (this.mode.getValue() == this.c325 && this.c8177 && this.c2249 >= 10) {
            EntityPlayerSP var2 = Minecraft.thePlayer();
            World var3 = var2.getWorld();
            StencilUtil.c8373();
            int var4 = GL11.glGenLists(1);
            StencilUtil.c7754().c6883();
            GL11.glPushMatrix();
            Minecraft.c2698().c3776(event.getPartialTicks(), 0);
            GL11.glDisable(2929);
            StencilUtil.c7754().c2499(true);
            GL11.glNewList(var4, 4864);
            GL11.glColor4d(0.0, 0.0, 0.0, 1.0);
            Minecraft.c2698().c4997(0.0);
            RenderUtils.c2430(this.playerCol.getAsColor().getRGB());
            Iterator var5 = var3.loadedEntityList().iterator();

            while(true) {
               Entity var7;
               do {
                  if (!var5.hasNext()) {
                     GL11.glEndList();
                     GL11.glPolygonMode(1032, 6913);
                     GL11.glCallList(var4);
                     GL11.glPolygonMode(1032, 6912);
                     GL11.glCallList(var4);
                     StencilUtil.c7754().c2499(false);
                     GL11.glPolygonMode(1032, 6914);
                     GL11.glCallList(var4);
                     StencilUtil.c7754().c6241();
                     GL11.glPolygonMode(1032, 6913);
                     GL11.glCallList(var4);
                     GL11.glPolygonMode(1032, 6912);
                     GL11.glCallList(var4);
                     GL11.glPolygonMode(1032, 6914);
                     StencilUtil.c7754().c482();
                     GL11.glEnable(2929);
                     GL11.glDeleteLists(var4, 1);
                     GL11.glPopMatrix();
                     GL11.glColor4d(1.0, 1.0, 1.0, 1.0);
                     Minecraft.c2698().c4997(1.0);
                     return;
                  }

                  Object var6 = var5.next();
                  var7 = new Entity(var6);
               } while(Vape.instance.getSettings().c2159(var7) && this.hideBots.getValue());

               if (!var7.equals(var2) && var7.isInstance(MappedClasses.EntityPlayer)) {
                  GL11.glPushMatrix();
                  GL11.glLineWidth(3.0F);
                  GL11.glEnable(GL11.GL_BLEND);
                  GL11.glEnable(2848);
                  GL11.glDisable(3008);
                  GL11.glDisable(GL11.GL_TEXTURE_2D);
                  double var8 = var7.c5823() + (var7.posX() - var7.c5823()) * (double) event.getPartialTicks() - Minecraft.c5612().c1779();
                  double var10 = var7.c8561() + (var7.posY() - var7.c8561()) * (double) event.getPartialTicks() - Minecraft.c5612().c7584();
                  double var12 = var7.c7002() + (var7.posZ() - var7.c7002()) * (double) event.getPartialTicks() - Minecraft.c5612().c63();
                  RenderLivingBase var14 = new RenderLivingBase(Minecraft.c5612().c225(var7).getObject());
                  if (var14.isNotNull()) {
                     this.c222 = true;
                     ArrayList var15 = null;
                     if (ForgeVersion.minorVersion() > 13) {
                        var15 = Lists.newArrayList(var14.c1445());
                        var14.c1445().clear();
                     }

                     GL11.glPushMatrix();
                     var14.c3744(var7, var8, var10, var12, event.getPartialTicks(), event.getPartialTicks());
                     GL11.glPopMatrix();
                     if (ForgeVersion.minorVersion() > 13) {
                        var14.c1460(var15);
                     }

                     this.c222 = false;
                  }

                  GL11.glDisable(GL11.GL_BLEND);
                  GL11.glEnable(GL11.GL_TEXTURE_2D);
                  GL11.glEnable(3008);
                  GL11.glPopMatrix();
               }
            }
         }
      }
   }

   public Color c1862(Object var1) {
      if (!MappedClasses.EntityLivingBase.isInstance(var1)) {
         return null;
      } else if (var1.equals(Minecraft.thePlayer())) {
         return null;
      } else if (!this.invisibles.getValue() && RotationUtil.c8871(new EntityLivingBase(var1))) {
         return null;
      } else {
         EntityLivingBase var2 = new EntityLivingBase(var1);
         if (Vape.instance.getSettings().c2159(var2) && this.hideBots.getValue()) {
            return null;
         } else if (Vape.instance.getSettings().c5510(var2)) {
            return Color.blue;
         } else if (MappedClasses.EntityOtherPlayerMP.isInstance(var1)) {
            return Vape.instance.getFriendManager().c4194(var2.getName()) && Vape.instance.getFriendManager().useColor.getValue() ? Vape.instance.getFriendManager().friendsColor.getAsColor() : this.playerCol.getAsColor();
         } else {
            return null;
         }
      }
   }

   public void onPreRenderLiving(EventPreRenderLiving event) {
      if (this.mode.getValue() == this.c325) {
         if (this.c222 && ForgeVersion.minorVersion() == 13) {
            RenderUtils.setColor(this.playerCol.getAsColor());
         } else {
            if (!event.c6138().isInstance(MappedClasses.EntityPlayerSP) && event.c6138().isInstance(MappedClasses.EntityPlayer)) {
               this.c8177 = true;
               ++this.c2249;
            }

         }
      }
   }
}
