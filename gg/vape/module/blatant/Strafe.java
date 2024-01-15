package gg.vape.module.blatant;

import gg.vape.Vape;
import gg.vape.event.impl.EventPlayerTick;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.combat.AimAssist;
import gg.vape.utils.RotationUtil;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.EntityLivingBase;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.KeyBinding;
import gg.vape.wrapper.impl.Minecraft;
import org.lwjgl.input.Keyboard;

public class Strafe extends Mod {
   public AimAssist c8011;
   public boolean c3834;
   public final NumberValue distance = NumberValue.create(this, "Distance", "#.#", "", 0.1, 3.3, 6.0, 1.0);
   public final NumberValue speed = NumberValue.create(this, "Speed", "#.#", "", 0.1, 0.5, 1.0);
   public final NumberValue targetMinAngle = NumberValue.create(this, "Target minimum angle", "#", "", 1.0, 120.0, 360.0);
   public final NumberValue selfMinAngle = NumberValue.create(this, "Your minimum angle", "#", "", 1.0, 90.0, 360.0);

   public Strafe() {
      super("Strafe", -256, Category.Blatant);
      this.addValue(this.distance, this.speed, this.targetMinAngle, this.selfMinAngle);
      this.c5375(10L, true);
   }

   public void c8731() {
      this.c8011 = Vape.instance.getModManager().getMod(AimAssist.class);
   }

   public void onTick(EventPlayerTick event) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      if (this.c3834) {
         var2.setSprinting(false);
         this.c3834 = false;
      }

   }

   public void c756() {
      if (!Minecraft.currentScreen().isNotNull()) {
         EntityPlayerSP var1 = Minecraft.thePlayer();
         int var2 = Minecraft.gameSettings().c1091().getKeyCode();
         boolean var3 = Keyboard.isKeyDown(var2);
         KeyBinding.setKeyBindState(var2, var3);
         double var4 = this.distance.getValue();
         double var6 = this.speed.getValue() / 5.0;
         var6 *= 0.1;
         boolean var8 = this.c8011.getState() && this.c8011.c7208() != null;
         EntityLivingBase var9 = new EntityLivingBase(this.c8011.c7208());
         if (!var9.isNull()) {
            boolean var10 = RotationUtil.c7639(var1, var9, this.targetMinAngle.getValue() / 2.0);
            boolean var11 = RotationUtil.c7639(var9, var1, this.selfMinAngle.getValue() / 2.0);
            if (var8 && var10 && var11) {
               double var12 = var1.getDistanceToEntity(var9);
               if (var12 < var4 && !var1.isInWater() && !var1.isCollidedHorizontally() && !var1.isOnLadder() && var1.onGround() && !var1.isBlocking()) {
                  double var14 = var9.posX();
                  double var16 = var9.posZ();
                  if (var1.posX() - var14 > 0.5) {
                     var1.motionX(var1.c6344() + var6);
                  }

                  if (var1.posX() - var14 < 0.5) {
                     var1.motionX(var1.c6344() - var6);
                  }

                  if (var1.posZ() - var16 > 0.5) {
                     var1.motionZ(var1.c612() + var6);
                  }

                  if (var1.posZ() - var16 < 0.5) {
                     var1.motionZ(var1.c612() - var6);
                  }

                  this.c3834 = true;
               }
            }

         }
      }
   }
}
