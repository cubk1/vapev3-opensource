package gg.vape.module.blatant;

import gg.vape.event.impl.EventMotion;
import gg.vape.event.impl.EventRenderBlockOverlay;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.blatant.phase.HypixelPhase;
import gg.vape.value.ModeValue;
import gg.vape.value.SubModuleValue;
import gg.vape.wrapper.impl.RenderGameOverlayEvent;

import java.awt.*;

public class Phase extends Mod {
   public final SubModuleValue mode = new SubModuleValue("Hypixel", new HypixelPhase(this, "Hypixel"));
   public final ModeValue modeValue;

   public Phase() {
      super("Phase", (new Color(73, 208, 176)).getRGB(), Category.Blatant, "Phase/Clip through walls.");
      this.modeValue = ModeValue.create(this, "Phase Mode", this.mode, this.mode);
      this.addValue(this.modeValue);
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onRender2D(RenderGameOverlayEvent event) {
   }

   public void onMotionUpdate(EventMotion event) {
      this.setSuffix(this.modeValue.getValue().getName());
      this.mode.getInstance().onMotionUpdate(event);
   }

   public void onRenderBlockOverlay(EventRenderBlockOverlay event) {
      if (event.overlayType().toString().equalsIgnoreCase("BLOCK")) {
         event.getNativeEvent().setCancelled(true);
      }

   }
}
