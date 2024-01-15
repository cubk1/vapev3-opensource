package gg.vape.module.render;

import gg.vape.event.impl.EventPlayerTick;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.ui.click.actions.ActionToggleFullbright;
import gg.vape.unmap.ModeSelection;
import gg.vape.value.ModeValue;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.PotionEffect;

public class Fullbright extends Mod {
   public final ModeSelection c1797 = new ModeSelection("Night Vision");
   public final ModeSelection c5636 = new ModeSelection("Gamma");
   public final ModeValue c4053;
   public float c8694;

   public Fullbright() {
      super("Fullbright", -256, Category.Render);
      this.c4053 = ModeValue.create(this, "Mode", this.c1797, this.c1797, this.c5636);
      this.c8694 = -1.0F;
      this.addValue(this.c4053);
      this.c4053.getComponent().addAction(new ActionToggleFullbright(this));
   }

   public void onTick(EventPlayerTick event) {
      if (this.c4053.getValue().equals(this.c1797)) {
         Minecraft.thePlayer().c2324(PotionEffect.c2829(16, 5220, 0));
      } else {
         Minecraft.gameSettings().c6025(10.0F);
      }

   }

   public void onEnable() {
      this.c8694 = Minecraft.gameSettings().c5716();
   }

   public void onDisable() {
      Minecraft.thePlayer().c4326(16);
      Minecraft.gameSettings().c6025(this.c8694);
   }

   // $FF: synthetic method
   public static ModeSelection c3513(Fullbright var0) {
      return var0.c5636;
   }

   // $FF: synthetic method
   public static ModeValue c8277(Fullbright var0) {
      return var0.c4053;
   }

   // $FF: synthetic method
   public static float c6762(Fullbright var0) {
      return var0.c8694;
   }
}
