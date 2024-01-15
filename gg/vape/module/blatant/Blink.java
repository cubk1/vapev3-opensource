package gg.vape.module.blatant;

import gg.vape.event.impl.EventPacketSend;
import gg.vape.event.impl.EventRender3D;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.utils.Vec3d;
import gg.vape.utils.render.RenderUtil;
import gg.vape.value.BooleanValue;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.Packet;
import gg.vape.wrapper.impl.RenderManager;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Blink extends Mod {
   public final List c2899 = new CopyOnWriteArrayList();
   public final List c6764 = new CopyOnWriteArrayList();
   public RenderManager c4785 = Minecraft.c5612();
   public final BooleanValue c206 = BooleanValue.create(this, "Breadcrumbs", false, "Drops breadcrumbs in case you forgot where you came from.");
   public int c2200;

   public Blink() {
      super("Blink", 8919359, Category.Blatant, "Chokes packets until disabled.");
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onRender3D(EventRender3D event) {
      if (!this.c6764.isEmpty()) {
         Minecraft.c2698().c6766(1.0);
         GL11.glPushMatrix();
         GL11.glEnable(GL11.GL_BLEND);
         GL11.glBlendFunc(770, 771);
         GL11.glLineWidth(1.5F);
         GL11.glDisable(GL11.GL_TEXTURE_2D);
         GL11.glEnable(2848);
         GL11.glDisable(2929);
         GL11.glDepthMask(false);
         double var2 = this.c4785.c1779();
         double var4 = this.c4785.c7584();
         double var6 = this.c4785.c63();

         Vec3d var9;
         Color var10;
         for(Iterator var8 = this.c6764.iterator(); var8.hasNext(); RenderUtil.c2609(var9.xCoord - 0.025, var9.yCoord - 0.025, var9.zCorrd - 0.025, 0.05, 0.05, 0.05, 0.0, Color.WHITE, var10, var2, var4, var6)) {
            var9 = (Vec3d)var8.next();
            var10 = Color.WHITE;
            if (var9 == this.c6764.get(0)) {
               var10 = Color.GREEN;
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

   public void onPacketSend(EventPacketSend event) {
      Packet var2 = event.getPacket();
      if (!var2.getObject().getClass().toString().contains("play.server") && !var2.getObject().toString().contains("SPacket")) {
         if (!var2.isInstance(MappedClasses.CPacketKeepAlive)) {
            if (var2.isInstance(MappedClasses.CPacketPlayer) && !this.c5373()) {
               event.setCancelled(true);
            } else {
               if (var2.isInstance(MappedClasses.CPacketPlayer)) {
                  ++this.c2200;
                  if (this.c2200 >= 5) {
                     EntityPlayerSP var3 = Minecraft.thePlayer();
                     this.c6764.add(new Vec3d(var3.posX(), var3.posY(), var3.posZ()));
                     this.c2200 = 0;
                  }
               }

               this.c2899.add(var2);
               event.setCancelled(true);
            }

            this.setSuffix(String.valueOf(this.c2899.size()));
         }

      }
   }

   public boolean c5373() {
      EntityPlayerSP var1 = Minecraft.thePlayer();
      return var1.c6344() != 0.0 || var1.c612() != 0.0;
   }

   public void onEnable() {
      this.c2200 = 0;
      this.c2899.clear();
      this.c6764.clear();
   }

   public void onDisable() {
      EntityPlayerSP var1 = Minecraft.thePlayer();
      Iterator var2 = this.c2899.iterator();

      while(var2.hasNext()) {
         Packet var3 = (Packet)var2.next();
         var1.sendQueue().addToSendQueue(var3);
         this.c2899.remove(var3);
      }

      this.c2200 = 0;
      this.c2899.clear();
      this.c6764.clear();
   }
}
