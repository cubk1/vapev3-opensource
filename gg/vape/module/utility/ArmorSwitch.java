package gg.vape.module.utility;

import gg.vape.event.impl.EventPlayerTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.UtilityMod;
import gg.vape.unmap.ModeSelection;
import gg.vape.utils.TimerUtil;
import gg.vape.value.ModeValue;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArmorSwitch extends UtilityMod {
   public final HashMap c4632 = new HashMap();
   public final ModeValue c226;
   public final ModeValue c5205;
   public final NumberValue c3561 = NumberValue.create(this, "Delay", "#", "", 0.0, 100.0, 200.0);
   public boolean c8065;
   public boolean c8010;
   public boolean c4086;
   public ArmorMaterial c3496;
   public final TimerUtil c968 = new TimerUtil();
   public int c4437;
   public int c53;
   public final Map c1593 = new HashMap();

   public ArmorSwitch() {
      super("ArmorSwitch", "Switches between armor sets");
      ModeSelection var1 = new ModeSelection("Diamond");
      ModeSelection var2 = new ModeSelection("Gold");
      ModeSelection var3 = new ModeSelection("Iron");
      ModeSelection var4 = new ModeSelection("Leather");
      ModeSelection var5 = new ModeSelection("Chain");
      this.c4632.put(var1, ArmorMaterial.DIAMOND());
      this.c4632.put(var2, ArmorMaterial.GOLD());
      this.c4632.put(var3, ArmorMaterial.IRON());
      this.c4632.put(var4, ArmorMaterial.CLOTH());
      this.c4632.put(var5, ArmorMaterial.CHAIN());
      this.c226 = ModeValue.create(this, "Set 1", var1, (ModeSelection[])this.c4632.keySet().toArray(new ModeSelection[this.c4632.size()]));
      this.c5205 = ModeValue.create(this, "Set 2", var2, (ModeSelection[])this.c4632.keySet().toArray(new ModeSelection[this.c4632.size()]));
      this.addValue(this.c226, this.c5205, this.c3561);
   }

   public void onTick(EventPlayerTick event) {
      if (this.c8065) {
         this.setState(false);
      } else {
         int var4;
         if (!Minecraft.currentScreen().isInstance(MappedClasses.GuiInventory)) {
            var4 = Minecraft.gameSettings().c6987().getKeyCode();
            KeyBinding.setKeyBindState(var4, true);
            KeyBinding.onTick(var4);
            KeyBinding.setKeyBindState(var4, false);
            this.c8010 = true;
         } else if (this.c4086 && this.c968.hasTimeElapsed(this.c3561.getValue().longValue())) {
            this.c968.reset();
            var4 = (Integer)this.c1593.get(this.c4437);
            this.c4447(this.c4437, var4);
            if (this.c4437 > 8) {
               this.c8065 = true;
            }

         } else {
            boolean var2 = this.c5373();
            if (this.c8010 && var2 && !this.c4086) {
               boolean var3 = this.c3496.equals(this.c4632.get(this.c226.getValue()));
               if (this.Value(var3 ? (ArmorMaterial)this.c4632.get(this.c5205.getValue()) : (ArmorMaterial)this.c4632.get(this.c226.getValue()))) {
                  this.c4086 = true;
               } else {
                  this.setState(false);
               }
            }

            if (!var2) {
               this.setState(false);
            }

         }
      }
   }

   public void c4447(int var1, int var2) {
      int var3 = var2;
      if (this.c53 == 1) {
         var3 = var1;
      }

      Minecraft.playerController().c7098(Minecraft.thePlayer().c7368().c3715(), var3, 1, 0, Minecraft.thePlayer());
      ++this.c53;
      if (this.c53 >= 3) {
         this.c53 = 0;
         ++this.c4437;
      }

   }

   public boolean c5373() {
      EntityPlayerSP var1 = Minecraft.thePlayer();
      Container var2 = var1.c7368();
      List var3 = var2.c7580();

      for(int var4 = 5; var4 < 9; ++var4) {
         Slot var5 = (Slot)var3.get(var4);
         if (var5.c5354() && var5.c4981().getItem().isInstance(MappedClasses.ItemArmor)) {
            ItemArmor var6 = new ItemArmor(var5.c4981().getItem());
            this.c3496 = var6.c7332();
            return true;
         }
      }

      return false;
   }

   public boolean Value(ArmorMaterial var1) {
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      EntityPlayerSP var6 = Minecraft.thePlayer();
      Container var7 = var6.c7368();
      List var8 = var7.c7580();

      for(int var9 = 9; var9 < 45; ++var9) {
         Slot var10 = (Slot)var8.get(var9);
         if (var10.c5354()) {
            Item var11 = var10.c4981().getItem();
            if (var11.isInstance(MappedClasses.ItemArmor)) {
               ItemArmor var12 = new ItemArmor(var11);
               if (var12.c7332().equals(var1)) {
                  switch (var12.c3715()) {
                     case 0:
                        var2 = var9;
                        break;
                     case 1:
                        var3 = var9;
                        break;
                     case 2:
                        var4 = var9;
                        break;
                     case 3:
                        var5 = var9;
                  }
               }
            }
         }
      }

      this.c1593.put(5, var2);
      this.c1593.put(6, var3);
      this.c1593.put(7, var4);
      this.c1593.put(8, var5);
      return var2 != 0 && var3 != 0 && var4 != 0 && var5 != 0;
   }

   public void onEnable() {
      this.c4437 = 5;
      this.c53 = 0;
      this.c4086 = false;
      this.c8065 = false;
      this.c8010 = false;
   }

   public void onDisable() {
      if (Minecraft.currentScreen().isInstance(MappedClasses.GuiInventory)) {
         Minecraft.thePlayer().c4088();
      }

   }
}
