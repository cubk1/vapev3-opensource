package gg.vape.module.render;

import gg.vape.Vape;
import gg.vape.event.impl.EventPreRenderLivingEvent;
import gg.vape.event.impl.EventRender3D;
import gg.vape.friend.Friend;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.none.ClientSettings;
import gg.vape.unmap.NumberFormat;
import gg.vape.utils.RotationUtil;
import gg.vape.utils.render.RenderUtils;
import gg.vape.value.BooleanValue;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.*;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.Iterator;

public class NameTags extends Mod {
   public final Color c4598 = new Color(20, 20, 20, 64);
   public final Color c1227 = new Color(115, 0, 4, 128);
   public final BooleanValue c3558 = BooleanValue.create(this, "Ignore Invisibles", false, "Determines if we draw a nametag\nfor invisible entities");
   public final BooleanValue c6175 = BooleanValue.create(this, "Render Players", true);
   public final BooleanValue c75 = BooleanValue.create(this, "Health", false);
   public final BooleanValue c7003 = BooleanValue.create(this, "Distance", false);
   public final BooleanValue c3581 = BooleanValue.create(this, "Equipment", false);
   public final BooleanValue c562 = BooleanValue.create(this, "Render Animals", false);
   public final BooleanValue c1140 = BooleanValue.create(this, "Health", false);
   public final BooleanValue c1447 = BooleanValue.create(this, "Distance", false);
   public final BooleanValue c5961 = BooleanValue.create(this, "Render Mobs", false);
   public final BooleanValue c5326 = BooleanValue.create(this, "Health", false);
   public final BooleanValue c3348 = BooleanValue.create(this, "Distance", false);
   public final BooleanValue c7383 = BooleanValue.create(this, "Hide bots", true, "Hides bots if you're using antibot");
   public final NumberValue c8941 = NumberValue.create(this, "Scale", "#.#", "", 0.1, 1.0, 1.5, 0.1);
   public final NumberFormat c1662 = new NumberFormat(1);
   public final Enchantment[] c5607 = new Enchantment[]{Enchantment.c8837(), Enchantment.c8276(), Enchantment.c5437(), Enchantment.c1317(), Enchantment.c107(), Enchantment.c3365(), Enchantment.c6820(), Enchantment.c8208(), Enchantment.c7838(), Enchantment.c6364(), Enchantment.c5219(), Enchantment.c390(), Enchantment.c1910()};
   public final Enchantment[] c2881 = Enchantment.c2188();

   public NameTags() {
      super("NameTags", -16711936, Category.Render, "Renders nametags on entities through walls.");
      this.c6175.limitValues(this.c75, this.c7003, this.c3581);
      this.c562.limitValues(this.c1140, this.c1447);
      this.c5961.limitValues(this.c5326, this.c3348);
      this.addValue(this.c3558, this.c8941, this.c7383, this.c6175, this.c75, this.c7003, this.c3581, this.c562, this.c1140, this.c1447, this.c5961, this.c5326, this.c3348);
   }

   public void onPreRenderLiving(EventPreRenderLivingEvent event) {
      if (!Minecraft.theWorld().isNull()) {
         EntityPlayerSP var2 = Minecraft.thePlayer();
         Entity var3 = event.c4766();
         if (this.c3177(var3)) {
            event.c6796().setCancelled(true);
         }
      }
   }

   public boolean c3177(Entity var1) {
      if (Minecraft.theWorld().isNull()) {
         return false;
      } else {
         EntityPlayerSP var2 = Minecraft.thePlayer();
         if (MappedClasses.MouseEvent != null && var1.isInstance(MappedClasses.MouseEvent)) {
            return false;
         } else if (var2.getObject().equals(var1.getObject())) {
            return false;
         } else if (Vape.instance.getSettings().c2159(var1) && this.c7383.getValue()) {
            return false;
         } else if (!Minecraft.theWorld().loadedEntityList().contains(var1.getObject())) {
            return false;
         } else if (var1.isNull()) {
            return false;
         } else if (!var1.isInstance(MappedClasses.EntityLivingBase)) {
            return false;
         } else if (this.c3558.getValue() && var1.c320()) {
            return false;
         } else {
            return !var1.isInstance(MappedClasses.EntityPlayer) || this.c6175.getValue();
         }
      }
   }

   void c1456(String var1, int var2, int var3, double var4) {
      double var6 = 1.0 / var4;
      GL11.glPushMatrix();
      boolean var8 = GL11.glIsEnabled(2896);
      if (var8) {
         GL11.glDisable(2896);
      }

      GL11.glScaled(var4, var4, var4);
      Minecraft.getFontRenderer().drawStringWithShadow(var1, var2, var3, -1);
      GL11.glScaled(var6, var6, var6);
      if (var8) {
         GL11.glEnable(2896);
      }

      GL11.glPopMatrix();
   }

   public void c4036(ItemStack var1, int var2, int var3) {
      TagList var4 = var1.c7173();
      if (!var4.isNull()) {
         try {
            int var5 = 0;

            for(int var6 = 0; var6 < var4.c1744(); ++var6) {
               short var7 = var4.c5365(var6).c3599("id");
               short var8 = var4.c5365(var6).c3599("lvl");
               if (var7 < this.c2881.length - 1) {
                  Enchantment var9 = this.c2881[var7];
                  if (!var9.isNull()) {
                     Enchantment[] var10 = this.c5607;
                     int var11 = var10.length;

                     for(int var12 = 0; var12 < var11; ++var12) {
                        Enchantment var13 = var10[var12];
                        if (var9.equals(var13)) {
                           String var14 = var9.c6150(var8).substring(0, 1).toLowerCase();
                           if (var8 > 99) {
                              var14 = var14 + "99+";
                           } else {
                              var14 = var14 + var8;
                           }

                           double var15 = 0.7;
                           double var17 = 1.0 / var15;
                           this.c1456(var14, (int)((double)var2 * var17), (int)((double)(-2 + var3 + var5) * var17), var15);
                           var5 += 6;
                           break;
                        }
                     }
                  }
               }
            }
         } catch (Exception var19) {
         }

      }
   }

   public void onRender3D(EventRender3D event) {
      double var2 = Minecraft.c5612().c1779();
      double var4 = Minecraft.c5612().c7584();
      double var6 = Minecraft.c5612().c63();
      boolean var8 = GL11.glIsEnabled(GL11.GL_BLEND);
      EntityPlayerSP var9 = Minecraft.thePlayer();
      Iterator var10 = Minecraft.theWorld().loadedEntityList().iterator();

      while(true) {
         Entity var12;
         do {
            do {
               if (!var10.hasNext()) {
                  return;
               }

               Object var11 = var10.next();
               var12 = new Entity(var11);
            } while(!this.c3177(var12));
         } while(!var12.isInstance(MappedClasses.EntityLivingBase));

         GL11.glPushMatrix();
         EntityLivingBase var13 = new EntityLivingBase(var12);
         double var14 = var13.c5823() + (var13.posX() - var13.c5823()) * (double) event.getPartialTicks() - var2;
         double var16 = var13.c8561() + (var13.posY() - var13.c8561()) * (double) event.getPartialTicks() - var4;
         double var18 = var13.c7002() + (var13.posZ() - var13.c7002()) * (double) event.getPartialTicks() - var6;
         if (var12.isInstance(MappedClasses.EntityPlayer) && this.c6175.getValue()) {
            this.c4985(var9, var13, var14, var16, var18, this.c75.getValue(), this.c7003.getValue(), this.c3581.getValue());
         } else if (RotationUtil.c2980(var12) && this.c562.getValue()) {
            this.c4985(var9, var13, var14, var16, var18, this.c1140.getValue(), this.c1447.getValue(), false);
         } else if (RotationUtil.c3232(var12) && this.c5961.getValue()) {
            this.c4985(var9, var13, var14, var16, var18, this.c5326.getValue(), this.c3348.getValue(), false);
         }

         GL11.glPopMatrix();
      }
   }

   public void c5274(EntityPlayer var1, boolean var2, int var3) {
      Minecraft.c2698().c6766(1.0);
      double var4 = 1.1;
      double var6 = 1.0 / var4;
      GL11.glPushMatrix();
      GL11.glScaled(var4, var4, var4);
      int var8 = -5;
      byte var9 = -26;
      Object[] var10 = var1.c89().c2542();
      Object[] var11 = var10;
      int var12 = var10.length;

      for(int var13 = 0; var13 < var12; ++var13) {
         Object var14 = var11[var13];
         if (var14 != null) {
            var8 -= 10;
         }
      }

      GlStateManager.disableLighting();
      if (!var1.c6156().isNull()) {
         var8 += 5;
         if (!var1.c6156().getItem().isNull()) {
            if (!var2) {
               Minecraft.c5718().c413(Minecraft.getFontRenderer(), Minecraft.c7094(), ItemStack.c8898(var1.c6156().getItem()), var8, var9);
            } else {
               Minecraft.c5718().c7826(Minecraft.getFontRenderer(), Minecraft.c7094(), var1.c6156(), var8, var9);
               this.c4036(var1.c6156(), var8, var9);
            }

            GL11.glEnable(3008);
         }
      }

      var8 += 5;

      for(int var15 = var10.length - 1; var15 > -1; --var15) {
         ItemStack var16 = new ItemStack(var10[var15]);
         if (!var16.isNull()) {
            var8 += 15;
            if (!var2) {
               Minecraft.c5718().c413(Minecraft.getFontRenderer(), Minecraft.c7094(), ItemStack.c8898(var16.getItem()), var8, var9);
            } else {
               Minecraft.c5718().c7826(Minecraft.getFontRenderer(), Minecraft.c7094(), var16, var8, var9);
               this.c4036(var16, var8, var9);
            }

            GL11.glEnable(3008);
         }
      }

      GL11.glScaled(var6, var6, var6);
      GL11.glPopMatrix();
      Minecraft.c2698().c4997(1.0);
   }

   public void c4985(EntityPlayer var1, EntityLivingBase var2, double var3, double var5, double var7, boolean var9, boolean var10, boolean var11) {
      String var12 = var2.c7053().c693();
      String var13 = ClientSettings.colorPrefix + "a" + ClientSettings.colorPrefix + "r" + var12;
      FontRenderer var14 = Minecraft.getFontRenderer();
      Minecraft.c2698().c6766(1.0);
      boolean var15 = var2.isInstance(MappedClasses.EntityPlayer);
      int var16 = 16777215;
      if (Vape.instance.getSettings().c5510(var2) && Vape.instance.getFriendManager().useColor.getValue()) {
         var16 = -12417292;
      }

      if (var2.c320()) {
         var16 = 65530;
      }

      if (var15) {
         Friend var17 = Vape.instance.getFriendManager().getFriend(var2.getName());
         if (var17 != null) {
            var13 = var17.c3501();
            if (Vape.instance.getFriendManager().useColor.getValue()) {
               var16 = Vape.instance.getFriendManager().friendsColor.HSBtoRGB();
            } else {
               char[] var18 = var12.toCharArray();
               int var19 = var12.indexOf(var13);

               for(int var20 = var19; var20 > 0; --var20) {
                  char var21 = var18[var20];
                  if (var21 == 167) {
                     var21 = var18[var20 + 1];
                     String var22 = String.valueOf(var21);
                     var13 = '§' + var22 + var13;
                     break;
                  }
               }
            }
         }
      }

      if (var10) {
         var13 = ClientSettings.colorPrefix + "a[" + ClientSettings.colorPrefix + "f" + (int)var1.getDistanceToEntity(var2) + ClientSettings.colorPrefix + "a]" + ClientSettings.colorPrefix + "r " + var13;
      }

      Color var34 = var2.isSneaking() ? this.c1227 : this.c4598;
      if (var2.isInstance(MappedClasses.EntityPlayer)) {
         EntityPlayer var35 = new EntityPlayer(var2);
         if (var35.capabilities().isCreativeMode()) {
            var13 = ClientSettings.colorPrefix + "a[C] " + ClientSettings.colorPrefix + "r" + var13;
         }
      }

      double var36 = var2.getHealth() / 2.0F;
      double var37 = var2.c6680() / 2.0F;
      double var38 = 100.0 * (var36 / var37);
      String var24;
      if (var38 > 75.0) {
         var24 = "2";
      } else if (var38 > 50.0) {
         var24 = "e";
      } else if (var38 > 25.0) {
         var24 = "6";
      } else {
         var24 = "4";
      }

      String var25 = this.c1662.c8033(Math.floor((var36 + 0.25) / 0.5) * 0.5);
      if (var9) {
         var13 = String.format("%s %s%s%s", var13, ClientSettings.colorPrefix, var24, var25);
      }

      float var26 = var1.getDistanceToEntity(var2);
      float var27 = var26 / 5.0F <= 2.0F ? 2.0F : var26 / 5.0F;
      float var28 = (float)(0.01666666753590107 * (double)var27 * this.c8941.getValue());
      GL11.glPushMatrix();
      RenderHelper.c3035();
      GL11.glTranslated(var3 + 0.0, var5 + (double)var2.c1998() + 0.5, var7);
      GL11.glNormal3f(0.0F, 1.0F, 0.0F);
      if (Minecraft.gameSettings().c8517() == 2) {
         GL11.glRotatef(-Minecraft.c5612().c4311(), 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(Minecraft.c5612().c8901(), -1.0F, 0.0F, 0.0F);
      } else {
         GL11.glRotatef(-Minecraft.c5612().c4311(), 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(Minecraft.c5612().c8901(), 1.0F, 0.0F, 0.0F);
      }

      GL11.glScalef(-var28, -var28, var28);
      GlStateManager.disableLighting();
      GlStateManager.depthMask(false);
      GlStateManager.disableDepth();
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      int var29 = var14.getStringWidth(var13) / 2;
      int var30 = -(var14.FONT_HEIGHT(var13) - 1);
      GlStateManager.disableLighting();
      RenderUtils.c2096((double)(-var29) - 2.0, var30, (double)var29 + 2.0, 2.0, var34);
      GlStateManager.enableTexture2D();
      var14.c8629(var13, -var29, var30 + 2, var16);
      if (var11) {
         GL11.glPushMatrix();
         if (var2.isInstance(MappedClasses.EntityPlayer)) {
            EntityPlayer var31 = new EntityPlayer(var2);
            GL11.glPushMatrix();
            if (ForgeVersion.minorVersion() > 13) {
               float var32 = -110.0F;
               float var33 = Minecraft.c5718().c6767();
               if (var33 != 0.0F) {
                  var32 -= var33 + 20.0F;
               }

               GL11.glTranslated(0.0, 0.0, var32);
            }

            this.c5274(var31, false, (int)var27);
            GL11.glPopMatrix();
            this.c5274(var31, true, (int)var27);
         }

         GL11.glPopMatrix();
      }

      GlStateManager.enableLighting();
      GlStateManager.enableDepth();
      GlStateManager.depthMask(true);
      GlStateManager.enableLighting();
      GlStateManager.disableBlend();
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      RenderHelper.c6395();
      GL11.glPopMatrix();
      Minecraft.c2698().c4997(1.0);
   }
}
