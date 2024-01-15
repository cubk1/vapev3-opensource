package gg.vape.module.blatant;

import gg.vape.Vape;
import gg.vape.event.impl.EventAttack;
import gg.vape.event.impl.EventPlayerTick;
import gg.vape.event.impl.EventSetSprinting;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.*;

public class KeepSprint extends Mod {
   public double c483;
   public double c4772;
   public Scaffold c2526;
   public AttributeModifier c3478;

   public KeepSprint() {
      super("KeepSprint", 14828276, Category.Blatant, "Prevents you from losing sprint when attacking.");
   }

   public void onAttack(EventAttack event) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      if (this.c2526 == null) {
         this.c2526 = Vape.instance.getModManager().getMod(Scaffold.class);
      }

      if (!this.c2526.shouldStopSprinting()) {
         if (event.getType() == EventType.PRE) {
            this.c483 = var2.c6344();
            this.c4772 = var2.c612();
         }

         if (event.getType() == EventType.POST && var2.c6344() == (this.c483 *= 0.6) && var2.c612() == (this.c4772 *= 0.6) && !var2.isCollidedHorizontally()) {
            var2.motionX(var2.c6344() / 0.6);
            var2.motionZ(var2.c612() / 0.6);
            var2.setSprinting(true);
         }

      }
   }

   public void onTick(EventPlayerTick event) {
      if (this.c2526 == null) {
         this.c2526 = Vape.instance.getModManager().getMod(Scaffold.class);
      }

      if (!this.c2526.shouldStopSprinting()) {
         AttributeInstance var2 = Minecraft.thePlayer().c3853(SharedMonsterAttributes.c660());
         if (Minecraft.thePlayer().isSprinting() && var2.getModifier(EntityLivingBase.c8952().c6604()).isNull()) {
            var2.c7209(EntityLivingBase.c8952());
         }

      }
   }

   public void onSetSprinting(EventSetSprinting event) {
      if (this.c2526 == null) {
         this.c2526 = Vape.instance.getModManager().getMod(Scaffold.class);
      }

      if (!this.c2526.shouldStopSprinting()) {
         if (event.c5925().equals(Minecraft.thePlayer())) {
            if (!event.c1446()) {
               if (this.c2088(Minecraft.thePlayer())) {
                  event.setCancelled(true);
               }

            }
         }
      }
   }

   public boolean isBlatantMod() {
      return true;
   }

   public boolean c2088(EntityPlayerSP var1) {
      return !this.c2526.shouldStopSprinting() && var1.moveForward() > 0.0F && !var1.isSneaking() && var1.c7791().c1744() > 6 && !var1.isCollidedHorizontally();
   }
}
