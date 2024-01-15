package gg.vape.module.utility;

import gg.vape.event.impl.EventTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.UtilityMod;
import gg.vape.unmap.ModeSelection;
import gg.vape.utils.datas.ItemStackData;
import gg.vape.value.BooleanValue;
import gg.vape.value.ModeValue;
import gg.vape.value.NumberValue;
import gg.vape.value.RandomValue;
import gg.vape.wrapper.impl.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThrowDebuff extends UtilityMod {
   public final CopyOnWriteArrayList c867 = new CopyOnWriteArrayList();
   public final ModeSelection c1799 = new ModeSelection("All");
   public final ModeSelection c3636 = new ModeSelection("One of each");
   public final ModeSelection c6057 = new ModeSelection("First");
   public final ModeValue c4747;
   public final BooleanValue[] c7709;
   public final RandomValue c7009;
   public final BooleanValue c1768;
   public final NumberValue c420;
   public boolean c949;

   public ThrowDebuff() {
      super("ThrowDebuff");
      this.c4747 = ModeValue.create(this, "Mode", "All - Throws all debuffs on hotbar\nOne of each - Throws one of each debuff\nFirst - Throws only first debuff on hotbar", this.c3636, this.c1799, this.c3636, this.c6057);
      this.c7709 = new BooleanValue[]{BooleanValue.create(this, "Harming", true), BooleanValue.create(this, "Weakness", true), BooleanValue.create(this, "Poison", true), BooleanValue.create(this, "Slowness", true)};
      this.c7009 = RandomValue.create(this, "Delay", "#.#", "", 0.0, 70.0, 120.0, 200.0);
      this.c1768 = BooleanValue.create(this, "Scroll", false);
      this.c420 = NumberValue.create(this, "Scroll delay", "#", "ms", 0.0, 100.0, 200.0);
      this.addValue(this.c4747);
      BooleanValue[] var1 = this.c7709;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         BooleanValue var4 = var1[var3];
         this.addValue(var4);
      }

      this.addValue(this.c7009);
      this.c1768.limitValues(this.c420);
      this.addValue(this.c1768);
      this.addValue(this.c420);
   }

   public void c5305(int var1) {
      if (!this.c1768.getValue()) {
         Minecraft.thePlayer().c89().c33(var1);
      } else {
         int var2 = Minecraft.thePlayer().c89().c1744();

         while(true) {
            Minecraft.thePlayer().c89().c33(var2);

            try {
               Thread.sleep(this.c420.getValue().longValue());
            } catch (InterruptedException var4) {
            }

            if (var1 > var2) {
               ++var2;
            } else {
               if (var1 >= var2) {
                  return;
               }

               --var2;
            }
         }
      }
   }

   public boolean c5373() {
      ArrayList var1 = new ArrayList();

      for(int var2 = 0; var2 < 9; ++var2) {
         var1.add(var2);
      }

      Object[] var15 = Minecraft.thePlayer().c89().c596();
      ArrayList var3 = new ArrayList();
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         Integer var5 = (Integer)var4.next();
         ItemStack var6 = new ItemStack(var15[var5]);
         if (!var6.isNull()) {
            Item var7 = var6.getItem();
            if (!var7.isNull() && MappedClasses.ItemPotion.isInstance(var7.getObject())) {
               ItemSplashPotion var8 = new ItemSplashPotion(var7.getObject());
               BooleanValue[] var9 = this.c7709;
               int var10 = var9.length;

               for(int var11 = 0; var11 < var10; ++var11) {
                  BooleanValue var12 = var9[var11];
                  if (!this.c4747.getValue().equals(this.c3636) || !var3.contains(var12)) {
                     String var13 = var8.c8079(var6).toLowerCase();
                     String var14 = var12.getName().toLowerCase();
                     if (var12.getValue() && var13.contains(var14)) {
                        this.c867.add(new ItemStackData(var5, var6));
                        var3.add(var12);
                        if (this.c4747.getValue().equals(this.c6057)) {
                           return !this.c867.isEmpty();
                        }
                        break;
                     }
                  }
               }
            }
         }
      }

      return !this.c867.isEmpty();
   }

   public void c756() {
      EntityPlayerSP var1 = Minecraft.thePlayer();
      InventoryPlayer var2 = var1.c89();
      int var3 = var2.c1744();
      Iterator var4 = this.c867.iterator();

      while(var4.hasNext()) {
         ItemStackData var5 = (ItemStackData)var4.next();

         try {
            this.c5305(var5.c4518());
            int var6 = Minecraft.gameSettings().c3763().getKeyCode();
            KeyBinding.setKeyBindState(var6, true);
            KeyBinding.onTick(var6);
            Thread.sleep(51L);
            KeyBinding.setKeyBindState(var6, false);
            Thread.sleep((long)this.c7009.c7470());
         } catch (Exception var7) {
         }
      }

      this.c5305(var3);
      this.c949 = false;
   }

   public void onTick(EventTick event) {
      if (!this.c949 && this.getState()) {
         this.setState(false);
      }

   }

   public void onEnable() {
      if (this.c5373()) {
         this.c949 = true;
         this.c5375(0L, false);
      } else {
         this.setState(false);
      }

   }

   public void onDisable() {
      this.c867.clear();
   }
}
