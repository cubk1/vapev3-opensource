package gg.vape.module.blatant;

import gg.vape.Vape;
import gg.vape.event.impl.EventAttack;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.unmap.ModeSelection;
import gg.vape.value.ModeValue;
import gg.vape.wrapper.impl.*;

import java.awt.*;

public class Criticals extends Mod {
   public final ModeSelection c7090 = new ModeSelection("Packet");
   public final ModeSelection c1473 = new ModeSelection("Hypixel");
   public final ModeValue c2341;

   public Criticals() {
      super("Criticals", (new Color(193, 183, 92)).getRGB(), Category.Blatant, "Forces critical hit every attack\nMay not bypass anti-cheats");
      this.c2341 = ModeValue.create(this, "Mode", "Criticals bypass method\nPacket - May not bypass anti-cheats, watchdog detected.\nHypixel - Watchdog bypassing Criticals mode.\nHypixel mode does not work separate from Killaura.", this.c7090, this.c7090, this.c1473);
      this.addValue(this.c2341);
      this.c2341.getComponent().addAction(new c6602(this));
   }

   public boolean shouldCrit() {
      return this.c2341.getValue() == this.c1473 && this.getState() && ForgeVersion.minorVersion() > 13;
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onAttack(EventAttack event) {
      if (this.c2341.getValue() == this.c7090 && event.getType() == EventType.PRE) {
         Vape var2 = Vape.instance;
         EntityPlayerSP var3 = Minecraft.thePlayer();
         if (var3.isCollidedVertically()) {
            if (var2.getModManager().getState(Speed.class) || var2.getModManager().getState(Fly.class) || var2.getModManager().getState(LongJump.class)) {
               return;
            }

            if (!event.c7685().isNull() && event.c7685().isInstance(MappedClasses.EntityLivingBase)) {
               EntityLivingBase var4 = new EntityLivingBase(event.c7685().getObject());
               if (var4.isInstance(MappedClasses.EntityOtherPlayerMP) && var2.getFriendManager().isFriend(var4)) {
                  return;
               }

               this.c3339(var3);
            }
         }
      }

   }

   public void c3339(EntityPlayerSP var1) {
      double[] var2 = new double[]{0.0654223451234, 5.78128675E-4};
      int var3 = var2.length;

      for (double var5 : var2) {
         if (ForgeVersion.minorVersion() > 13) {
            var1.sendQueue().addToSendQueue(C04PacketPlayerPosition.newInstance(var1.posX(), var1.posY() + var5, var1.posZ(), false));
         } else {
            var1.sendQueue().addToSendQueue(C04PacketPlayerPosition.newInstance(var1.posX(), var1.boundingBox().minY() + var5, var1.posY() + var5, var1.posZ(), false));
         }
      }

   }

   // $FF: synthetic method
   static ModeValue c271(Criticals var0) {
      return var0.c2341;
   }
}

class c6602 implements IGuiCallback {
   // $FF: synthetic field
   final Criticals c6470;

   c6602(Criticals var1) {
      this.c6470 = var1;
   }

   public void call(IGuiComponent inst) {
      ((Mod) Criticals.c271(this.c6470).getOwner()).setSuffix(Criticals.c271(this.c6470).getValue().getName());
   }
}
