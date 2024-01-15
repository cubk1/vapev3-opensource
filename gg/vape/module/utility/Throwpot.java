package gg.vape.module.utility;

import gg.vape.event.impl.EventTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.UtilityMod;
import gg.vape.module.utility.invcleaner.ItemDataComparator;
import gg.vape.unmap.HealItemUtil;
import gg.vape.unmap.ModeSelection;
import gg.vape.utils.datas.ItemStackData;
import gg.vape.value.BooleanValue;
import gg.vape.value.ModeValue;
import gg.vape.value.NumberValue;
import gg.vape.value.RandomValue;
import gg.vape.wrapper.impl.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Throwpot extends UtilityMod {
   public final ModeSelection c5803 = new ModeSelection("Both");
   public final ModeSelection c6254 = new ModeSelection("Pots");
   public final ModeSelection c731 = new ModeSelection("Soup");
   public final ModeValue c7818;
   public final ModeSelection c2305;
   public final ModeSelection c7528;
   public final ModeValue c473;
   public final NumberValue c3070;
   public final RandomValue c3799;
   public final BooleanValue c6703;
   public final BooleanValue c5712;
   public final BooleanValue c2153;
   public int c4003;
   public final CopyOnWriteArrayList c5000;
   public boolean c3798;

   public Throwpot() {
      super("Throwpot", "Throws or consumes healing items upon pressing keybind");
      this.c7818 = ModeValue.create(this, "Type", this.c5803, this.c5803, this.c6254, this.c731);
      this.c2305 = new ModeSelection("Dynamic");
      this.c7528 = new ModeSelection("Single");
      this.c473 = ModeValue.create(this, "Mode", "Dynamic - uses only as many items as needed to heal as much as possible without over-healing\nSingle - Always uses one item, regardless of health", this.c2305, this.c2305, this.c7528);
      this.c3070 = NumberValue.create(this, "Scroll delay", "#", "ms", 0.0, 100.0, 200.0);
      this.c3799 = RandomValue.create(this, "Delay", "#", "ms", 0.0, 80.0, 115.0, 200.0);
      this.c6703 = BooleanValue.create(this, "Scroll", false);
      this.c5712 = BooleanValue.create(this, "Random", false);
      this.c2153 = BooleanValue.create(this, "Throw bowls", true, "Throws soup bowls after consuming");
      this.c5000 = new CopyOnWriteArrayList();
      this.c6703.limitValues(this.c3070);
      this.addValue(this.c7818, this.c473, this.c3799, this.c6703, this.c3070, this.c5712, this.c2153);
   }

   public void onEnable() {
      if (this.c3798) {
         this.setState(false);
      } else {
         InventoryPlayer var1 = Minecraft.thePlayer().c89();
         this.c4003 = var1.c1744();
         if (this.c5373()) {
            this.c3798 = true;
            this.c5375(0L, false);
         } else {
            this.setState(false);
         }

      }
   }

   public void onDisable() {
      this.c5000.clear();
   }

   public void c5305(int var1) {
      if (!this.c6703.getValue()) {
         Minecraft.thePlayer().c89().c33(var1);
      } else {
         int var2 = Minecraft.thePlayer().c89().c1744();

         while(true) {
            Minecraft.thePlayer().c89().c33(var2);

            try {
               Thread.sleep(this.c3070.getValue().longValue());
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

   public void c756() {
      if (this.c3798) {
         int var1 = Minecraft.gameSettings().c3763().getKeyCode();
         int var2 = Minecraft.gameSettings().c3503().getKeyCode();

         try {
            this.c5000.sort(new ItemDataComparator(this.c4003));
            Iterator var3 = this.c5000.iterator();

            while(var3.hasNext()) {
               ItemStackData var4 = (ItemStackData)var3.next();
               this.c5305(var4.c4518());
               Thread.sleep(10L);
               KeyBinding.setKeyBindState(var1, true);
               KeyBinding.onTick(var1);
               Thread.sleep((long)this.c3799.c7470());
               KeyBinding.setKeyBindState(var1, false);
               if (this.c2153.getValue() && var4.c4255().getItem().isInstance(MappedClasses.ItemSoup)) {
                  KeyBinding.setKeyBindState(var2, true);
                  KeyBinding.onTick(var2);
                  Thread.sleep((long)this.c3799.c7470());
                  KeyBinding.setKeyBindState(var2, false);
               }
            }
         } catch (Exception var5) {
            var5.printStackTrace();
         }

         this.c5305(this.c4003);
         this.c3798 = false;
      }
   }

   public void onTick(EventTick event) {
      if (!this.c3798 && this.getState()) {
         this.setState(false);
      }

   }

   public boolean c5373() {
      ArrayList var1 = new ArrayList();

      for(int var2 = 0; var2 < 9; ++var2) {
         var1.add(var2);
      }

      if (this.c5712.getValue()) {
         Collections.shuffle(var1);
      }

      Object[] var12 = Minecraft.thePlayer().c89().c596();
      int var3 = 0;
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         Integer var5 = (Integer)var4.next();
         ItemStack var6 = new ItemStack(var12[var5]);
         if (!var6.isNull()) {
            Item var7 = var6.getItem();
            if (!var7.isNull()) {
               boolean var8 = this.c7818.getValue().equals(this.c731) || this.c7818.getValue().equals(this.c5803);
               boolean var9 = this.c7818.getValue().equals(this.c6254) || this.c7818.getValue().equals(this.c5803);
               if (MappedClasses.ItemSoup.isInstance(var7.getObject()) && var8) {
                  if (this.c473.getValue().equals(this.c7528)) {
                     this.c5000.add(new ItemStackData(var5, var6));
                     break;
                  }

                  byte var10 = 8;
                  if ((double)(var3 + var10) + Math.floor(Minecraft.thePlayer().getHealth()) > (double) Minecraft.thePlayer().c6680()) {
                     continue;
                  }

                  var3 += var10;
                  this.c5000.add(new ItemStackData(var5, var6));
               }

               if (MappedClasses.ItemPotion.isInstance(var7.getObject()) && var9) {
                  if (this.c473.getValue().equals(this.c7528)) {
                     this.c5000.add(new ItemStackData(var5, var6));
                     break;
                  }

                  ItemSplashPotion var13 = new ItemSplashPotion(var7.getObject());
                  if (HealItemUtil.c573(var6)) {
                     int var11 = 0;
                     if (var13.c5965(var6).get(0).toString().contains(" x ")) {
                        var11 += 4 * Integer.parseInt(var13.c5965(var6).get(0).toString().split(" x ")[1].split(",")[0]);
                     } else {
                        var11 += 4;
                     }

                     if (!((double)(var3 + var11) + Math.floor(Minecraft.thePlayer().getHealth()) > (double) Minecraft.thePlayer().c6680())) {
                        var3 += var11;
                        this.c5000.add(new ItemStackData(var5, var6));
                     }
                  }
               }
            }
         }
      }

      return !this.c5000.isEmpty();
   }
}
