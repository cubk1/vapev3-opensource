package gg.vape.module.render;

import func.skidline.c3530;
import gg.vape.Vape;
import gg.vape.event.impl.EventRender3D;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.utility.invcleaner.EntityDistanceComparator;
import gg.vape.utils.RotationUtil;
import gg.vape.utils.Vec3d;
import gg.vape.utils.render.RenderUtils;
import gg.vape.value.BooleanValue;
import gg.vape.value.ColorValue;
import gg.vape.value.RandomValue;
import gg.vape.wrapper.impl.*;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.List;
import java.util.*;

public class Tracers extends Mod {
   public final BooleanValue c4884 = BooleanValue.create(this, "Render Players", true);
   public final BooleanValue c3094 = BooleanValue.create(this, "Render Mobs", false);
   public final BooleanValue c3231 = BooleanValue.create(this, "Render Animals", false);
   public final BooleanValue c7189 = BooleanValue.create(this, "Distance Check", false);
   public final BooleanValue c8315 = BooleanValue.create(this, "Distance Check", false);
   public final BooleanValue c5390 = BooleanValue.create(this, "Distance Check", false);
   public final BooleanValue c6270 = BooleanValue.create(this, "Invisibles", false);
   public final BooleanValue c7148 = BooleanValue.create(this, "Color by distance", false);
   public final BooleanValue c3507 = BooleanValue.create(this, "Highlight if focusing", false, "If another player is looking at you their tracer will be highlighted");
   public final RandomValue c3472 = RandomValue.create(this, "Player Distance", "#", "", 0.0, 0.0, 32.0, 256.0);
   public final RandomValue c4341 = RandomValue.create(this, "Mob Distance", "#", "", 0.0, 0.0, 32.0, 256.0);
   public final RandomValue c5606 = RandomValue.create(this, "Animal Distance", "#", "", 0.0, 0.0, 32.0, 256.0);
   public final ColorValue c3079 = ColorValue.c7407(this, "Player Color", 0.0);
   public final ColorValue c4567 = ColorValue.c7407(this, "Mob Color", 0.0);
   public final ColorValue c8670 = ColorValue.c7407(this, "Animal Color", 0.0);
   public double c6196;
   public final Map c1366 = new HashMap();
   public List c6724;

   public Tracers() {
      super("Tracers", -12274966, Category.Render);
      this.c4884.limitValues(this.c7189, this.c3079);
      this.c3094.limitValues(this.c8315, this.c4567);
      this.c3231.limitValues(this.c5390, this.c8670);
      this.c7189.limitValues(this.c3472);
      this.c8315.limitValues(this.c4341);
      this.c5390.limitValues(this.c5606);
      this.addValue(this.c6270, this.c7148, this.c3507, this.c4884, this.c7189, this.c3472, this.c3079, this.c3231, this.c5390, this.c5606, this.c8670, this.c3094, this.c8315, this.c4341, this.c4567);
   }

   public void c8116() {
      if (this.c7148.getValue()) {
         EntityPlayerSP var1 = Minecraft.thePlayer();
         Iterator var2 = this.c6724.iterator();

         while(var2.hasNext()) {
            EntityLivingBase var3 = (EntityLivingBase)var2.next();
            double var4 = var1.getDistanceToEntity(var3);
            float var6 = 0.35F;
            double var7 = (double)(Math.round(var4 / 3.0) * 3L) - this.c6196 / 3.0;
            float var9 = (float)((double)var6 * (var7 / this.c6196));
            if (var4 > this.c6196) {
               var9 = var6;
            }

            Color var10 = new Color(Color.HSBtoRGB(var9, 1.0F, 1.0F));
            int var11 = 255;
            if (var4 > this.c6196) {
               var11 = (int)(255.0 / (var4 / this.c6196));
               if (var11 < 150) {
                  var11 = 150;
               }
            }

            var10 = new Color(var10.getRed(), var10.getGreen(), var10.getBlue(), var11);
            ((c3530)this.c1366.get(var3)).c793(var10);
         }
      }

   }

   public void c6601() {
      if (this.c3507.getValue()) {
         ArrayList var1 = new ArrayList();
         EntityPlayerSP var2 = Minecraft.thePlayer();
         Iterator var3 = this.c6724.iterator();

         EntityLivingBase var4;
         while(var3.hasNext()) {
            var4 = (EntityLivingBase)var3.next();
            if (var4.canEntityBeSeen(var2) && RotationUtil.c4566(var4, var2) < 5.0) {
               var1.add(var4);
            }
         }

         if (!var1.isEmpty()) {
            var3 = this.c6724.iterator();

            while(var3.hasNext()) {
               var4 = (EntityLivingBase)var3.next();
               c3530 var5 = (c3530)this.c1366.get(var4);
               if (var1.contains(var4)) {
                  var5.c8720(3.0);
                  var5.c8234(true);
               } else {
                  var5.c8720(0.75);
               }
            }
         }
      }

   }

   public void c3934() {
      EntityPlayerSP var1 = Minecraft.thePlayer();
      Collections.sort(this.c6724, new EntityDistanceComparator(this, var1));
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.c1366.entrySet().iterator();

      while(var3.hasNext()) {
         Map.Entry var4 = (Map.Entry)var3.next();
         EntityLivingBase var5 = (EntityLivingBase)var4.getKey();
         var2.add((double)var1.getDistanceToEntity(var5));
      }

      Collections.sort(var2);
      this.c6196 = (Double)var2.get(var2.size() / 2);
   }

   public void onRender(EventRender3D event) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      RenderManager var3 = Minecraft.c5612();
      this.c2272();
      if (this.c1366.size() != 0) {
         GL11.glPushMatrix();
         GL11.glDisable(2929);
         Minecraft.c2698().c6766(0.0);
         double var4 = var3.c1779();
         double var6 = var3.c7584();
         double var8 = var3.c63();
         double var10 = ForgeVersion.minorVersion() > 13 ? (double)var2.getEyeHeight() : 0.0;
         this.c6724 = new ArrayList(this.c1366.keySet());
         this.c3934();
         this.c8116();
         this.c6601();
         Collections.reverse(this.c6724);

         EntityLivingBase var13;
         c3530 var14;
         Color var15;
         for(Iterator var12 = this.c6724.iterator(); var12.hasNext(); this.c3507(var13, var15, (float)var14.c1386(), event.getPartialTicks(), var4, var6, var8, var10, var14.c1103())) {
            var13 = (EntityLivingBase)var12.next();
            var14 = (c3530)this.c1366.get(var13);
            var15 = var14.c8861();
            if (Vape.instance.getSettings().c5510(var13) && Vape.instance.getFriendManager().useColor.getValue()) {
               var15 = Color.BLUE;
            }
         }

         GL11.glColor3d(1.0, 1.0, 1.0);
         Minecraft.c2698().c4997(0.0);
         GL11.glEnable(2929);
         GL11.glPopMatrix();
         this.c1366.clear();
      }
   }

   public void c2272() {
      Iterator var1 = Minecraft.theWorld().loadedEntityList().iterator();

      while(true) {
         while(true) {
            EntityLivingBase var4;
            float var5;
            do {
               while(true) {
                  Entity var3;
                  do {
                     do {
                        do {
                           do {
                              if (!var1.hasNext()) {
                                 return;
                              }

                              Object var2 = var1.next();
                              var3 = new Entity(var2);
                           } while(!var3.isInstance(MappedClasses.EntityLivingBase));
                        } while(var3.equals(Minecraft.thePlayer()));

                        var4 = new EntityLivingBase(var3);
                     } while(!this.c6270.getValue() && RotationUtil.c8871(var4));
                  } while(Vape.instance.getSettings().c2159(var4));

                  var5 = var4.getDistanceToEntity(Minecraft.thePlayer());
                  if (this.c4884.getValue() && var3.isInstance(MappedClasses.EntityOtherPlayerMP)) {
                     break;
                  }

                  if (this.c3094.getValue() && var3.isInstance(MappedClasses.EntityMob)) {
                     if (!this.c8315.getValue() || !((double)var5 < this.c4341.getValue()[0].doubleValue()) && !((double)var5 > this.c4341.getValue()[1].doubleValue())) {
                        this.c1366.put(var4, new c3530(this.c4567.getAsColor(), null));
                     }
                  } else if (this.c3231.getValue() && var3.isInstance(MappedClasses.EntityAnimal) && (!this.c5390.getValue() || !((double)var5 < this.c5606.getValue()[0].doubleValue()) && !((double)var5 > this.c5606.getValue()[1].doubleValue()))) {
                     this.c1366.put(var4, new c3530(this.c8670.getAsColor(), null));
                  }
               }
            } while(this.c7189.getValue() && ((double)var5 < this.c3472.getValue()[0].doubleValue() || (double)var5 > this.c3472.getValue()[1].doubleValue()));

            if (Vape.instance.getFriendManager().c4194(var4.getName()) && Vape.instance.getFriendManager().useColor.getValue()) {
               this.c1366.put(var4, new c3530(Vape.instance.getFriendManager().friendsColor.getAsColor(), null));
            } else {
               this.c1366.put(var4, new c3530(this.c3079.getAsColor(), null));
            }
         }
      }
   }

   public void c3507(Entity var1, Color var2, float var3, float var4, double var5, double var7, double var9, double var11, boolean var13) {
      double var14 = var1.c5823() + (var1.posX() - var1.c5823()) * (double)var4 - var5;
      double var16 = var1.c8561() + (var1.posY() - var1.c8561()) * (double)var4 - var7;
      double var18 = var1.c7002() + (var1.posZ() - var1.c7002()) * (double)var4 - var9;
      boolean var20 = GL11.glIsEnabled(GL11.GL_BLEND);
      boolean var21 = GL11.glIsEnabled(2896);
      GL11.glBlendFunc(770, 771);
      if (!var20) {
         GL11.glEnable(GL11.GL_BLEND);
      }

      if (var21) {
         GL11.glDisable(2896);
      }

      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glDisable(GL11.GL_TEXTURE_2D);
      double var22 = 0.0;
      double var24 = 0.0;
      if (ForgeVersion.minorVersion() >= 23) {
         EntityPlayerSP var26 = Minecraft.thePlayer();
         Vec3d var27 = new Vec3d(0.0, 0.0, 1.0);
         var27.c2566((float)(-Math.toRadians(var26.rotationPitch())));
         var27.c2294((float)(-Math.toRadians(var26.rotationYaw())));
         var22 = var27.c8935();
         var11 += var27.c6718();
         var24 = var27.c4080();
      }

      if (var13) {
         GL11.glLineWidth(var3 + var3 * 0.5F);
         GL11.glBegin(1);
         RenderUtils.setColor(Color.black);
         GL11.glVertex3d(var22, var11, var24);
         GL11.glVertex3d(var14, var16 + (double)var1.getEyeHeight(), var18);
         GL11.glEnd();
      }

      GL11.glLineWidth(var3);
      GL11.glBegin(1);
      RenderUtils.setColor(var2);
      GL11.glVertex3d(var22, var11, var24);
      GL11.glVertex3d(var14, var16 + (double)var1.getEyeHeight(), var18);
      GL11.glEnd();
      if (var21) {
         GL11.glEnable(2896);
      }

      if (!var20) {
         GL11.glDisable(GL11.GL_BLEND);
      }

      GL11.glEnable(GL11.GL_TEXTURE_2D);
      GL11.glDisable(2848);
   }
}
