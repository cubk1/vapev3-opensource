package gg.vape.module.blatant;

import gg.vape.Vape;
import gg.vape.event.impl.EventPacketReceive;
import gg.vape.event.impl.EventPlayerTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.utils.TimerUtil;
import gg.vape.value.BooleanValue;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.S08PacketPlayerPosLook;

public class NoRotate extends Mod {
   public int c1906;
   public final TimerUtil c8596 = new TimerUtil();
   public final TimerUtil c2088 = new TimerUtil();
   public final BooleanValue c2368 = BooleanValue.create(this, "Disable Speed", false, "Disable Speed when flagging.");

   public NoRotate() {
      super("NoRotate", -2420426, Category.Blatant, "Prevents the server from\nsetting your view angles.");
      this.addValue(this.c2368);
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onPacketReceive(EventPacketReceive event) {
      if (event.getPacket().isInstance(MappedClasses.SPacketPlayerPosLook)) {
         Speed var2 = Vape.instance.getModManager().getMod(Speed.class);
         var2.setStep(-5);
         if (this.c2088.hasTimeElapsed(2000L)) {
            ++this.c1906;
            S08PacketPlayerPosLook var3 = new S08PacketPlayerPosLook(event.getPacket());
            EntityPlayerSP var4 = Minecraft.thePlayer();
            if (var4.isNotNull()) {
               var3.c6025(var4.rotationYaw());
               var3.c8528(var4.rotationPitch());
            }
         }
      }

   }

   public void onTick(EventPlayerTick event) {
      if (this.c8596.hasTimeElapsed(750L) && this.c1906 > 3 && this.c2088.hasTimeElapsed(2000L)) {
         this.c2088.reset();
         this.c8596.reset();
         this.c1906 = 0;
         Speed var2 = Vape.instance.getModManager().getMod(Speed.class);
         if (this.c2368.checkValue() && var2.getState()) {
            var2.c141();
         }
      }

   }
}
