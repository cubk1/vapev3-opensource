package gg.vape.module.blatant;

import gg.vape.event.impl.EventMove;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.value.BooleanValue;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.Minecraft;

public class SafeWalk extends Mod {
   public final BooleanValue c1937 = BooleanValue.create(this, "Direction Check", true, "Checks if you're walking forwards and it'll allow you to walk off the edge");
   public boolean c6756;

   public SafeWalk() {
      super("SafeWalk", -9176515, Category.Blatant, "Helps you from falling off the edge.");
      this.getValues().add(this.c1937);
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onMove(EventMove event) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      if (event.isPre()) {
         this.c6756 = var2.movementInput().c5315();
         boolean var3 = !this.c1937.getValue() || var2.isSneaking() || !(var2.moveForward() > 0.0F) || var2.moveStrafe() != 0.0F;

         if (var3) {
            var2.movementInput().c7118(true);
         }
      } else {
         var2.movementInput().c7118(this.c6756);
      }

   }
}
