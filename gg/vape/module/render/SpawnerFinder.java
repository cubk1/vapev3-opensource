package gg.vape.module.render;

import gg.vape.event.impl.EventRender3D;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.none.ClientSettings;
import gg.vape.utils.RotationUtil;
import gg.vape.utils.render.RenderUtil;
import gg.vape.value.BooleanValue;
import gg.vape.value.LimitValue;
import gg.vape.value.NumberValue;
import gg.vape.value.OptionalLimitValue;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.RenderManager;
import gg.vape.wrapper.impl.TileEntityMobSpawner;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.Iterator;

public class SpawnerFinder extends Mod {
   public final RenderManager c8553;
   public final Color c7601 = new Color(20, 20, 20, 128);
   public final NumberValue c3374 = NumberValue.create(this, "Scale", "#.#", "", 0.1, 1.0, 1.5, 0.1);
   public final BooleanValue c2218 = BooleanValue.create(this, "Show distance", true);
   public final OptionalLimitValue c34;

   public SpawnerFinder() {
      super("SpawnerFinder", 9976573, Category.Render);
      this.c34 = OptionalLimitValue.c5397(this, "Spawner names-whitelist", "Spawners", LimitValue.allowed, "Zombie", "Skeleton", "Creeper", "Spider");
      this.c8553 = Minecraft.c5612();
      this.addValue(this.c3374, this.c2218, this.c34);
   }

   public void onRender3D(EventRender3D event) {
      boolean var2 = GL11.glIsEnabled(GL11.GL_BLEND);
      Minecraft.c2698().c6766(1.0);
      GL11.glPushMatrix();
      if (!var2) {
         GL11.glEnable(GL11.GL_BLEND);
      }

      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.5F);
      GL11.glDisable(GL11.GL_TEXTURE_2D);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      double var3 = this.c8553.c1779();
      double var5 = this.c8553.c7584();
      double var7 = this.c8553.c63();
      EntityPlayerSP var9 = Minecraft.thePlayer();
      Iterator var10 = Minecraft.theWorld().c1445().iterator();

      while(var10.hasNext()) {
         Object var11 = var10.next();
         if (MappedClasses.TileEntityMobSpawner.isInstance(var11)) {
            TileEntityMobSpawner var12 = new TileEntityMobSpawner(var11);
            String var13 = var12.c439().c6376();
            if (this.c34.c6984(var13)) {
               String var14 = "";
               if (this.c2218.getValue()) {
                  String var15 = ClientSettings.colorPrefix + "a[" + ClientSettings.colorPrefix + "f" + (int)var9.c7689(var12.c1744(), var12.c3715(), var12.c7544()) + ClientSettings.colorPrefix + "a]" + ClientSettings.colorPrefix + "r";
                  var14 = var14 + var15 + " ";
               }

               var14 = var14 + var13 + " spawner";
               RenderUtil.c4684(var14, (double)var12.c1744() - var3 + 0.5, (double)var12.c3715() - var5 - 1.0, (double)var12.c7544() - var7 + 0.5, this.c3374.getValue(), RotationUtil.c582(var9, var12.c1744(), var12.c3715(), var12.c7544()), -1, this.c7601, 1.4);
            }
         }
      }

      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glEnable(GL11.GL_TEXTURE_2D);
      GL11.glDisable(2848);
      if (!var2) {
         GL11.glDisable(GL11.GL_BLEND);
      }

      GL11.glPopMatrix();
      Minecraft.c2698().c4997(1.0);
   }
}
