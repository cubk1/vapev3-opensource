package gg.vape.module.blatant;

import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.value.NumberValue;

public class HitBoxes extends Mod {
   public final NumberValue c7433 = NumberValue.create(this, "Expand amount", "#.##", "", 0.0, 0.35, 1.0, 0.01);

   public HitBoxes() {
      super("HitBoxes", -16711707, Category.Blatant, "Expands entities hitboxes");
      this.addValue(this.c7433);
   }

   public float c8217() {
      return !this.getState() ? 0.0F : this.c7433.getValue().floatValue();
   }

   public float c1764() {
      return this.c7433.getValue().floatValue();
   }
}
