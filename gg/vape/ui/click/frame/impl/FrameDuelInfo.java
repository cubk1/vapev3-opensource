package gg.vape.ui.click.frame.impl;

import func.skidline.c2905;
import gg.vape.mapping.MappedClasses;
import gg.vape.ui.click.actions.ActionHandleDuelInfo;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.frame.DuelInfoBar;
import gg.vape.ui.click.component.gui.ExpandableButton;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.unmap.HealItemUtil;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.wrapper.impl.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FrameDuelInfo extends Frame {
   double c247;
   double c6020;
   double c4464;
   public World c7787;
   public int c8769;
   public int c3836;
   public int c4143;
   public int c6091;
   public int c6598;
   public EntityPlayer c8937;
   public final IntractiveComponent c5377;
   public final DuelInfoBar c8079;
   public final DuelInfoBar c7046;

   public FrameDuelInfo() {
      super("Duel Info", true);
      this.getFramePage().onRendererHandling(new PoseRenderer(0.0, 2.0, 5000, 1, new PoseMatrix(2, 2, 2, 2)));
      this.setWidth(130.0);
      double var1 = this.getWidth() - 8.0;
      FrameComponent var3 = new FrameComponent(true);
      var3.onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 2, new PoseMatrix(0, 0, 0, 0)));
      var3.setColor(l);
      var3.c7363(false);
      var3.onOffset(15.0);
      ExpandableButton var4 = new ExpandableButton("di_target", 0.45F, 0.0F, 0.0F);
      var4.setText("Current target");
      var4.c8923(true);
      var4.onOffset(15.0);
      var4.setWidth(15.0);
      var3.addComponent(var4);
      this.c5377 = new IntractiveComponent("Archyb0t", RenderFlag.Centered, 1.0);
      this.c5377.onOffset(15.0);
      this.c5377.setWidth(var1 - var4.getWidth());
      this.c5377.c7363(false);
      var3.addComponent(this.c5377);
      this.addGuiComponent(var3);
      FrameComponent var5 = new FrameComponent(true);
      var5.onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 2, new PoseMatrix(0, 0, 0, 0)));
      var5.setColor(l);
      var5.c7363(false);
      var5.onOffset(15.0);
      ExpandableButton var6 = new ExpandableButton("di_pot", 0.45F, 0.0F, 0.0F);
      var6.setText("Difference of potions used");
      var6.c8923(true);
      var6.onOffset(15.0);
      var6.setWidth(15.0);
      var5.addComponent(var6);
      FrameComponent var7 = new FrameComponent(false);
      var7.onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 1, new PoseMatrix(0, 2, 0, 2)));
      this.c8079 = new DuelInfoBar();
      var7.addComponent(this.c8079);
      this.c8079.setWidth(var1 - var6.getWidth() - 4.0);
      this.c8079.onOffset(15.0);
      this.c8079.c7363(false);
      this.c8079.c8923(true);
      this.c8079.addAction(new c2905(this, var5));
      var5.addComponent(var7);
      this.addGuiComponent(var5);
      FrameComponent var8 = new FrameComponent(true);
      var8.onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 2, new PoseMatrix(0, 0, 0, 0)));
      var8.setColor(l);
      var8.c7363(false);
      var8.onOffset(15.0);
      ExpandableButton var9 = new ExpandableButton("di_hit", 0.45F, 0.0F, 0.0F);
      var9.setText("Difference of hits landed");
      var9.c8923(true);
      var9.onOffset(15.0);
      var9.setWidth(15.0);
      var8.addComponent(var9);
      var7 = new FrameComponent(false);
      var7.onRendererHandling(new PoseRenderer(0.0, 0.0, 5000, 1, new PoseMatrix(0, 2, 0, 2)));
      this.c7046 = new DuelInfoBar();
      var7.addComponent(this.c7046);
      this.c7046.setWidth(var1 - var9.getWidth() - 4.0);
      this.c7046.onOffset(15.0);
      this.c7046.c7363(false);
      this.c7046.addAction(new ActionHandleDuelInfo(this, var8));
      var8.addComponent(var7);
      this.addGuiComponent(var8);
      this.c270();
      this.setWidth(130.0);
      this.onOffset(20.0);
      this.c2367(false);
   }

   public void setWidth(double var1) {
      super.setWidth(var1);
      Iterator var3 = this.getFramePage().getComponents().iterator();

      while(var3.hasNext()) {
         IGuiComponent var4 = (IGuiComponent)var3.next();
         var4.setWidth(var1 - 8.0);
      }

   }

   public boolean c5326() {
      WorldClient var1 = Minecraft.theWorld();
      if (this.c7787 == null) {
         this.c7787 = var1;
         return true;
      } else {
         boolean var2 = var1.isNotNull() && !var1.getObject().equals(this.c7787.getObject());
         this.c7787 = var1;
         return var2;
      }
   }

   public void c270() {
      this.c5377.setName("Searching...");
      this.c8937 = null;
      this.c8769 = 0;
      this.c3836 = 0;
      this.c6598 = 0;
      this.c4143 = 0;
      this.c6091 = 0;
      this.c8079.c6219(0, 0);
      this.c8079.setColor(null);
      this.c7046.c6219(0, 0);
      this.c7046.setColor(null);
   }

   public void c4452() {
      this.c8079.c6219(this.c8769, this.c3836);
      this.c7046.c6219(this.c4143, this.c6091);
   }

   public void c6239() {
      if (!Minecraft.theWorld().isNull()) {
         if (!Minecraft.thePlayer().isNull()) {
            this.c5377.setName("Searching...");
            CopyOnWriteArrayList var1 = new CopyOnWriteArrayList(Minecraft.theWorld().c8905());
            ArrayList var2 = new ArrayList();
            Iterator var3 = var1.iterator();

            while(var3.hasNext()) {
               Object var4 = var3.next();
               if (MappedClasses.EntityPlayer.isInstance(var4)) {
                  EntityPlayer var5 = new EntityPlayer(var4);
                  if (!var5.c320() && !var5.getObject().equals(Minecraft.thePlayer().getObject()) && !var5.isDead() && var5.getEntityID() != -420) {
                     var2.add(var5);
                  }
               }
            }

            if (var2.size() > 1) {
               this.c5377.setName("More than one target");
            } else if (var2.size() == 1) {
               this.c8937 = (EntityPlayer)var2.get(0);
               this.c5377.setName(this.c8937.getName());
               this.c4452();
            }

         }
      }
   }

   public void c2975(PlaySoundAtEntityEvent var1) {
      if (this.c8937 != null && !this.c8937.isNull()) {
         if (var1.c6376().equals("game.player.hurt")) {
            if (!(Minecraft.thePlayer().getDistanceToEntity(this.c8937) > 6.0F)) {
               if (var1.c4451().getObject().equals(Minecraft.thePlayer().getObject())) {
                  ++this.c6091;
               }

               if (var1.c4451().getObject().equals(this.c8937.getObject())) {
                  ++this.c4143;
               }

               this.c4452();
            }
         }
      }
   }

   public void c5473(EntityJoinWorldEvent var1) {
      if (var1.c4451().isInstance(MappedClasses.EntityPotion)) {
         if (this.c8937 != null && !this.c8937.isNull()) {
            if (!Minecraft.thePlayer().isNull()) {
               EntityPotion var2 = new EntityPotion(var1.c4451());
               if (!var2.c4981().isNull()) {
                  boolean var3 = HealItemUtil.c573(var2.c4981());
                  if (var3) {
                     if (this.c6598 > 0) {
                        ++this.c8769;
                        --this.c6598;
                     } else {
                        ++this.c3836;
                     }

                     this.c4452();
                  }
               }
            }
         }
      }
   }

   public void c8925(PlayerInteractEvent var1) {
      if (this.c8937 != null && !this.c8937.isNull()) {
         if (var1.c1744() == 0 && var1.c3715() == 0 && var1.c7544() == 0 && var1.c7219() == -1 && var1.c2485().equals("RIGHT_CLICK_AIR")) {
            ItemStack var2 = Minecraft.thePlayer().c6156();
            if (var2.isNotNull() && MappedClasses.ItemPotion.isInstance(var2.getItem().getObject()) && HealItemUtil.c573(var2)) {
               ++this.c6598;
            }
         }

      }
   }

   public void draw() {
      super.draw();

      try {
         EntityPlayerSP var1 = Minecraft.thePlayer();
         if (this.c30() && !this.isClosed()) {
            if (!Minecraft.thePlayer().isNull()) {
               boolean var2 = Math.abs(var1.posX() - this.c247) > 120.0 || Math.abs(var1.posY() - this.c6020) > 120.0 || Math.abs(var1.posZ() - this.c4464) > 120.0;
               this.c247 = var1.posX();
               this.c6020 = var1.posY();
               this.c4464 = var1.posZ();
               if (!this.c5326() && !var2) {
                  if (!Minecraft.theWorld().isNull()) {
                     if (this.c8937 != null && !this.c8937.isNull()) {
                        if (var1.isDead() || this.c8937.isDead()) {
                           this.c270();
                           return;
                        }

                        boolean var3 = false;
                        Iterator var4 = Minecraft.theWorld().c8905().iterator();

                        while(var4.hasNext()) {
                           Object var5 = var4.next();
                           if (this.c8937.getObject().equals(var5)) {
                              var3 = true;
                              break;
                           }

                           EntityPlayer var6 = new EntityPlayer(var5);
                           if (!this.c8937.getObject().equals(var6.getObject()) && this.c8937.getName().equalsIgnoreCase(var6.getName())) {
                              this.c8937 = var6;
                           }
                        }

                        if (!var3) {
                           this.c8937 = null;
                           this.c6239();
                        }
                     } else {
                        this.c6239();
                     }

                  }
               } else {
                  this.c270();
               }
            }
         } else {
            this.c270();
         }
      } catch (Exception var7) {
         var7.printStackTrace();
      }
   }

   // $FF: synthetic method
   public static DuelInfoBar c5875(FrameDuelInfo var0) {
      return var0.c8079;
   }

   // $FF: synthetic method
   public static DuelInfoBar c2334(FrameDuelInfo var0) {
      return var0.c7046;
   }
}
