package gg.vape.module.world;

import gg.vape.event.impl.EventPlayerTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.utils.RandomUtil;
import gg.vape.utils.TimerUtil;
import gg.vape.value.BooleanValue;
import gg.vape.value.LimitValue;
import gg.vape.value.RandomValue;
import gg.vape.wrapper.impl.*;

import java.util.ArrayList;
import java.util.Collections;

public class ChestSteal extends Mod {
   public final BooleanValue c5360 = BooleanValue.create(this, "Check in Menu", false, "This will attempt to ignore Menus such as\nServer selectors, and settings inventory menus\nThis may not work 100% on all servers");
   public final BooleanValue c3925 = BooleanValue.create(this, "Keep open", false, "Keep chest open after clearing");
   public final BooleanValue c3513 = BooleanValue.create(this, "Shuffle", false, "Take items in a random order");
   public final RandomValue c8089 = RandomValue.create(this, "Click Delay", "#", "", 0.0, 75.0, 125.0, 300.0);
   public final LimitValue c5708;
   public final TimerUtil c1478;

   public ChestSteal() {
      super("ChestSteal", -208, Category.World, "Take items upon opening a chest");
      this.c5708 = LimitValue.create(this, "cheatsteal-blacklisted", "Blacklisted", LimitValue.blocked, Collections.emptyList());
      this.c1478 = new TimerUtil();
      this.addValue(this.c5360, this.c3925, this.c3513, this.c8089, this.c5708);
   }

   public void onTick(EventPlayerTick event) {
      if (Minecraft.currentScreen().isInstance(MappedClasses.GuiChest)) {
         GuiChest var2 = new GuiChest(Minecraft.currentScreen());
         if (this.c5360.getValue() && !this.c5187(var2)) {
            return;
         }

         if (!this.c3925.getValue() && this.c5373()) {
            Minecraft.thePlayer().c4088();
            return;
         }

         ArrayList var3 = new ArrayList();
         Inventory var4 = var2.c7049();

         for(int var5 = 0; var5 < var4.c3715(); ++var5) {
            ItemStack var6 = var4.c4875(var5);
            if (!var6.isNull() && !var6.toString().contains("tile.air") && !this.c5708.isValid(var6, true)) {
               var3.add(var5);
            }
         }

         if (!var3.isEmpty()) {
            if (this.c3513.getValue()) {
               Collections.shuffle(var3);
            }

            if (this.c1478.hasTimeElapsed(RandomUtil.c8609(this.c8089))) {
               Minecraft.playerController().c7098(var2.c7455().c3715(), (Integer)var3.get(0), 0, 1, Minecraft.thePlayer());
               Minecraft.playerController().c7098(var2.c7455().c3715(), (Integer)var3.get(0), 0, 1, Minecraft.thePlayer());
               this.c1478.reset();
            }
         } else if (!this.c3925.getValue()) {
            Minecraft.thePlayer().c4088();
         }
      }

   }

   public boolean c5187(GuiChest var1) {
      Inventory var2 = var1.c7049();
      String var3 = var1.c7049().c6376();
      return !var2.c5354() || var3.equalsIgnoreCase(TextComponentTranslation.c86("container.chest").c376().toLowerCase());
   }

   public boolean c2230(GuiChest var1) {
      Inventory var2 = var1.c7049();

      for(int var3 = 0; var3 <= var2.c3715(); ++var3) {
         ItemStack var4 = var2.c4875(var3);
         if (!var4.isNull() && !this.c5708.isValid(var4)) {
            return false;
         }
      }

      return true;
   }

   public boolean c5373() {
      Container var1 = Minecraft.thePlayer().c7368();

      for(int var2 = 9; var2 <= 44; ++var2) {
         ItemStack var3 = var1.c8687(var2).c4981();
         if (var3.isNull() || var3.toString().contains("tile.air")) {
            return false;
         }
      }

      return true;
   }
}
