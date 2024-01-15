package gg.vape.module.blatant;

import gg.vape.event.impl.EventPlayerTick;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.value.NumberValue;
import gg.vape.value.RandomValue;

public class OmniSprint extends Mod {
   public final RandomValue c2207 = RandomValue.create(this, "Rate", "#.#", "", 0.0, 1.0, 3.0, 10.0);
   public final NumberValue c4647 = NumberValue.create(this, "Rate Change", "#.#", "", 0.0, 1.0, 5.0);
   public float c5231;
   public long c7147;

   public OmniSprint() {
      super("OmniSprint", -256, Category.Blatant);
      this.addValue(this.c2207, this.c4647);
   }

   public void onTick(EventPlayerTick event) {
   }
}
