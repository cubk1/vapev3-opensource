package gg.vape.module.world;

import gg.vape.event.impl.EventTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.unmap.HealItemUtil;
import gg.vape.unmap.ModeSelection;
import gg.vape.value.ModeValue;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.EventType;
import gg.vape.wrapper.impl.ItemStack;
import gg.vape.wrapper.impl.Minecraft;

public class FastPlace extends Mod {
   public final NumberValue c326 = NumberValue.create(this, "Delay", "#", "", 0.0, 1.0, 4.0, 1.0);
   public final ModeSelection c2051 = new ModeSelection("All");
   public final ModeSelection c8935 = new ModeSelection("Blocks");
   public final ModeSelection c7102 = new ModeSelection("Projectiles");
   public final ModeValue c5749;

   public FastPlace() {
      super("FastPlace", -16384224, Category.World, "Changes the block place delay.");
      this.c5749 = ModeValue.create(this, "Held Item", "What kind of items should FastPlace function with?\nAll - All items/blocks\nBlocks - All blocks\nProjectiles - Snowballs & Eggs", this.c2051, this.c2051, this.c8935, this.c7102);
      this.addValue(this.c5749, this.c326);
   }

   public void onTick(EventTick event) {
      if (event.getType() == EventType.PRE) {
         if (!Minecraft.thePlayer().isNull()) {
            ItemStack var2 = Minecraft.thePlayer().getHeldItemHand();
            if (this.c5749.getValue() != this.c8935 || !var2.isNotNull() || !var2.getItem().isNotNull() || var2.getItem().isInstance(MappedClasses.ItemBlock)) {
               if (this.c5749.getValue() != this.c7102 || !var2.isNotNull() || !var2.getItem().isNotNull() || HealItemUtil.c7037(var2.getItem())) {
                  if ((double) Minecraft.c8838() > this.c326.getValue()) {
                     Minecraft.c5732(this.c326.getValue().intValue());
                  }

               }
            }
         }
      }
   }
}
