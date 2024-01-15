package gg.vape.module.utility;

import func.skidline.c7361;
import gg.vape.event.impl.EventPlayerTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.utils.TimerUtil;
import gg.vape.value.BooleanValue;
import gg.vape.value.RandomValue;
import gg.vape.wrapper.impl.*;

public class AutoArmor extends Mod {
   public final int[] c4970 = new int[]{313, 309, 317, 305, 301};
   public final int[] c7177 = new int[]{311, 307, 315, 303, 299};
   public final int[] c5872 = new int[]{310, 306, 314, 302, 298};
   public final int[] c5906 = new int[]{312, 308, 316, 304, 300};
   public final BooleanValue c3250 = BooleanValue.create(this, "Open Inventory", true, "Opens your inventory when you can equip armor.");
   public final BooleanValue c1106 = BooleanValue.create(this, "Inventory Only", false, "Only equip armor when in inventory.");
   public final BooleanValue c3560 = BooleanValue.create(this, "Check Durability", true, "Always puts on the armor with the highest durability.");
   public final BooleanValue c8751 = BooleanValue.create(this, "Drop Equipped", false, "Drops worse equipped armor for better armor when active.");
   public final BooleanValue c778 = BooleanValue.create(this, "Combat check", false, "Won't equip armor while in combat");
   public final RandomValue c1659 = RandomValue.create(this, "Delay", "#", "", 1.0, 100.0, 120.0, 200.0);
   public boolean c3384;
   public boolean c3615;
   public int c8017 = 4;
   public final TimerUtil c4059 = new TimerUtil();
   public final c7361 c4570 = new c7361(20);

   public AutoArmor() {
      super("AutoArmor", -12399628, Category.Utility, "Automatically equips armor when needed.");
      this.addValue(this.c3250, this.c1106, this.c3560, this.c8751, this.c778, this.c1659);
   }

   public void onDisable() {
      super.onDisable();
      this.c3615 = false;
      this.c3384 = false;
      this.c8017 = 4;
   }

   public void onTick(EventPlayerTick event) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      if (!this.c8297(var2)) {
         if (this.c3615) {
            var2.c4088();
            this.c3384 = false;
            this.c3615 = false;
         }

         if (this.c3384) {
            this.c3615 = true;
         }

      } else if (!var2.capabilities().isCreativeMode() && (var2.c5465().isNull() || var2.c5465().c3715() == 0)) {
         if (this.c778.getValue()) {
            this.c4570.c3335(var2);
            if (this.c4570.c8460()) {
               return;
            }
         }

         if (this.c4059.hasTimeElapsed((long)this.c1659.c7470())) {
            ++this.c8017;
            if (this.c8017 > 8) {
               this.c8017 = 4;
            }

            int var3 = this.c3414(this.c8017, this.c3560.getValue());
            if (var3 != -1) {
               if (this.c3250.getValue() && !Minecraft.currentScreen().isInstance(MappedClasses.GuiInventory)) {
                  int var4 = Minecraft.gameSettings().c6987().getKeyCode();
                  KeyBinding.setKeyBindState(var4, true);
                  KeyBinding.onTick(var4);
                  KeyBinding.setKeyBindState(var4, false);
                  this.c3384 = true;
                  return;
               }

               if (this.c1106.getValue() && !Minecraft.currentScreen().isInstance(MappedClasses.GuiInventory)) {
                  return;
               }

               if (var2.c7368().c8687(var3).c4981().isNotNull()) {
                  if (this.c8751.getValue()) {
                     Minecraft.playerController().c7098(var2.c7368().c3715(), this.c8017, 0, 0, var2);
                     Minecraft.playerController().c7098(var2.c7368().c3715(), -999, 0, 0, var2);
                  } else {
                     Minecraft.playerController().c7098(var2.c7368().c3715(), this.c8017, 0, 1, var2);
                  }
               }

               Minecraft.playerController().c7098(0, var3, 0, 1, var2);
               this.c3615 = true;
            }

            this.c4059.reset();
         }

      }
   }

   public boolean c8297(EntityPlayer var1) {
      for(int var2 = 5; var2 <= 8; ++var2) {
         for(int var3 = 9; var3 < 45; ++var3) {
            if (var1.c7368().c8687(var3).c4981().isNotNull()) {
               ItemStack var4 = var1.c7368().c8687(var3).c4981();
               if (this.c2075(var4) != -1 && this.c2075(var4) == var2 && this.c3414(var2, false) != -1) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public int c1001(int var1) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      return var2.c7368().c8687(var1).c4981().isNotNull() ? var2.c7368().c8687(var1).c4981().c2021() : 999;
   }

   public int c3414(int var1, boolean var2) {
      int var3 = -1;
      EntityPlayerSP var4 = Minecraft.thePlayer();
      ItemStack var5 = var4.c7368().c8687(var1).c4981();
      double var6 = 0.0;
      double var8 = 999.0;
      if (var5.isNotNull()) {
         var6 = this.c4922(var5);
         var8 = this.c1001(var1);
      }

      double var10 = var6;
      double var12 = var8;

      for(int var14 = 9; var14 < 45; ++var14) {
         if (var4.c7368().c8687(var14).c4981().isNotNull()) {
            ItemStack var15 = var4.c7368().c8687(var14).c4981();
            if (this.c2075(var15) != -1 && this.c2075(var15) == var1) {
               double var16 = this.c4922(var15);
               double var18 = this.c1001(var14);
               if (var16 > var10) {
                  var10 = var16;
                  var3 = var14;
                  var12 = var18;
               } else if (var2 && var16 == var10 && var18 < var12) {
                  var12 = var18;
                  var3 = var14;
               }
            }
         }
      }

      return var3;
   }

   public int c2075(ItemStack var1) {
      int[] var2 = this.c4970;
      int var3 = var2.length;

      int var4;
      int var5;
      for(var4 = 0; var4 < var3; ++var4) {
         var5 = var2[var4];
         if (var1.getItem().c3715() == var5) {
            return 8;
         }
      }

      var2 = this.c5906;
      var3 = var2.length;

      for(var4 = 0; var4 < var3; ++var4) {
         var5 = var2[var4];
         if (var1.getItem().c3715() == var5) {
            return 7;
         }
      }

      var2 = this.c7177;
      var3 = var2.length;

      for(var4 = 0; var4 < var3; ++var4) {
         var5 = var2[var4];
         if (var1.getItem().c3715() == var5) {
            return 6;
         }
      }

      var2 = this.c5872;
      var3 = var2.length;

      for(var4 = 0; var4 < var3; ++var4) {
         var5 = var2[var4];
         if (var1.getItem().c3715() == var5) {
            return 5;
         }
      }

      return -1;
   }

   public double c4922(ItemStack var1) {
      if (var1.isNotNull() && var1.getItem().isInstance(MappedClasses.ItemArmor)) {
         ItemArmor var2 = new ItemArmor(var1.getItem());
         int var3 = var2.c1744();
         return (double)var3 + (double)((100 - var3 * 4) * EnchantmentHelper.c7113(0, var1) * 4) * 0.0075;
      } else {
         return 0.0;
      }
   }
}
