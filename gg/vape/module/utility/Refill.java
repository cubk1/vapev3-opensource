package gg.vape.module.utility;

import gg.vape.event.impl.EventPlayerTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.UtilityMod;
import gg.vape.unmap.HealItemUtil;
import gg.vape.unmap.ModeSelection;
import gg.vape.value.BooleanValue;
import gg.vape.value.ModeValue;
import gg.vape.value.RandomValue;
import gg.vape.wrapper.impl.*;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Refill extends UtilityMod {
   public final ModeSelection c1241 = new ModeSelection("Both");
   public final ModeSelection c2808 = new ModeSelection("Pots");
   public final ModeSelection c8345 = new ModeSelection("Soup");
   public final ModeValue c263;
   public GuiContainer c4829;
   public final BooleanValue c7109;
   public final BooleanValue c6736;
   public final BooleanValue c258;
   public final RandomValue c3369;
   public final Queue c8020;
   public boolean c1571;
   public final Random c2915;

   public Refill() {
      super("Refill");
      this.c263 = ModeValue.create(this, "Type", this.c1241, this.c1241, this.c2808, this.c8345);
      this.c7109 = BooleanValue.create(this, "Vertical", false);
      this.c6736 = BooleanValue.create(this, "Scatter", false);
      this.c258 = BooleanValue.create(this, "Hotbar clear", false, "Clears junk from your hotbar to refill.");
      this.c3369 = RandomValue.create(this, "Delay", "#", "ms", 0.0, 75.0, 125.0, 200.0);
      this.c8020 = new ConcurrentLinkedQueue();
      this.c2915 = new Random();
      this.addValue(this.c7109, this.c6736, this.c258, this.c3369, this.c263);
   }

   public void onEnable() {
      if (this.c5201().size() == 0) {
         this.setState(false);
      } else if (!this.c5373()) {
         this.setState(false);
      } else {
         int var1 = Minecraft.gameSettings().c6987().getKeyCode();
         KeyBinding.setKeyBindState(var1, true);
         KeyBinding.onTick(var1);
         KeyBinding.setKeyBindState(var1, false);
         this.c5375(0L, false);
      }
   }

   public void c6846(int var1, int var2, int var3, int var4) {
      this.c8020.add(new c7294(var1, var2, var3, var4, null));
   }

   public void c756() {
      try {
         int var1 = 0;

         while(true) {
            Thread.sleep(10L);
            ++var1;
            if (var1 > 5) {
               break;
            }

            if (Minecraft.currentScreen().isInstance(MappedClasses.GuiContainer)) {
               this.c4829 = new GuiContainer(Minecraft.currentScreen().getObject());
               break;
            }
         }

         if (!Minecraft.currentScreen().isInstance(MappedClasses.GuiContainer)) {
            this.c1571 = true;
            return;
         }

         ArrayList var2 = new ArrayList();
         ArrayList var3 = new ArrayList();
         int var4 = 0;
         List var5 = this.c5201();
         int var6 = 9;

         while(var6 < 36) {
            Slot var7 = (Slot)this.c4829.c7455().c7580().get(var6);
            ItemStack var8 = var7.c4981();
            if (!var8.isNull()) {
               Item var9 = var8.getItem();
               if (!var9.isNull() && HealItemUtil.c5367(var8, this.c263.getValue().equals(this.c8345) || this.c263.getValue().equals(this.c1241))) {
                  var2.add(var6);
               }
            }

            if (this.c7109.getValue()) {
               var6 += 9;
               ++var4;
               if (var4 == 3) {
                  ++var6;
                  var6 -= 27;
                  var4 = 0;
               }
            } else {
               ++var6;
            }
         }

         if (var2.isEmpty()) {
            this.c1571 = true;
            return;
         }

         if (this.c6736.getValue()) {
            Collections.shuffle(var2);
         }

         for(var6 = 0; var6 < var5.size() && var6 < var2.size(); ++var6) {
            var3.add(var2.get(var6));
         }

         var6 = 0;
         Iterator var14 = var3.iterator();

         while(true) {
            if (!var14.hasNext()) {
               while(!this.c8020.isEmpty()) {
                  Thread.sleep(5L);
               }

               this.c1571 = true;
               break;
            }

            Integer var15 = (Integer)var14.next();
            if (this.c4829.isNull() || !Minecraft.currentScreen().equals(this.c4829)) {
               this.c1571 = true;
               return;
            }

            boolean var16 = false;
            int var10 = 0;
            if (this.c258.getValue()) {
               var10 = (Integer)var5.get(var6);
               ItemStack var11 = Minecraft.thePlayer().c89().c5272(var10);
               if (var11.isNotNull()) {
                  Item var12 = var11.getItem();
                  if (var12.isNotNull()) {
                     var16 = true;
                  }
               }
            }

            if (var16) {
               this.c6846(this.c4829.c7455().c3715(), var15, 0, 0);
               Thread.sleep((long)this.c3369.c7470());
               this.c6846(this.c4829.c7455().c3715(), 36 + var10, 0, 0);
               Thread.sleep((long)this.c3369.c7470());
               this.c6846(this.c4829.c7455().c3715(), var15, 0, 0);
               Thread.sleep((long)this.c3369.c7470());
            } else {
               Thread.sleep((long)this.c3369.c7470() + (long)this.c2915.nextInt(10));
               this.c6846(this.c4829.c7455().c3715(), var15, 0, 1);
            }

            ++var6;
         }
      } catch (Exception var13) {
      }

   }

   public void onTick(EventPlayerTick event) {
      if (this.c1571) {
         if (!Minecraft.currentScreen().isNull()) {
            Minecraft.thePlayer().c4088();
         }

         this.c1571 = false;
         this.setState(false);
      } else {
         while(!this.c8020.isEmpty()) {
            c7294 var2 = (c7294)this.c8020.poll();
            var2.c5472();
         }
      }

   }

   public boolean c5373() {
      boolean var1 = false;

      for(int var2 = 9; var2 < 36; ++var2) {
         ItemStack var3 = Minecraft.thePlayer().c89().c5272(var2);
         if (!var3.isNull()) {
            Item var4 = var3.getItem();
            if (!var4.isNull() && HealItemUtil.c5367(var3, this.c263.getValue().equals(this.c8345) || this.c263.getValue().equals(this.c1241))) {
               var1 = true;
            }
         }
      }

      return var1;
   }

   public List c5201() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      Object[] var3 = Minecraft.thePlayer().c89().c596();

      for(int var4 = 0; var4 < 9; ++var4) {
         ItemStack var5 = new ItemStack(var3[var4]);
         if (var5.isNull()) {
            var2.add(var4);
         } else if (this.c258.getValue()) {
            if (this.c3711(var5.getItem(), var5, var1)) {
               var2.add(var4);
            }
         } else if (var5.toString().contains("tile.air")) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public boolean c197(ItemStack var1, List var2) {
      Iterator var3 = var2.iterator();

      ItemStack var4;
      do {
         if (!var3.hasNext()) {
            return false;
         }

         var4 = (ItemStack)var3.next();
      } while(var1.equals(var4) || !var1.getItem().getObject().getClass().isInstance(var4.getItem().getObject()));

      return true;
   }

   public boolean c3711(Item var1, ItemStack var2, List var3) {
      if (HealItemUtil.c5367(var2, this.c263.getValue().equals(this.c8345) || this.c263.getValue().equals(this.c1241))) {
         return false;
      } else if (MappedClasses.ItemEnderPearl.isInstance(var1.getObject())) {
         if (!this.c197(var2, var3)) {
            var3.add(var2);
            return false;
         } else {
            return true;
         }
      } else if (MappedClasses.ItemFood.isInstance(var1.getObject())) {
         if (!this.c197(var2, var3)) {
            var3.add(var2);
            return false;
         } else {
            return true;
         }
      } else if (MappedClasses.ItemSword.isInstance(var1.getObject())) {
         if (!this.c197(var2, var3)) {
            var3.add(var2);
            return false;
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   class c7294 {
      public final int c6530;
      public final int c5688;
      public final int c4982;
      public final int c2998;

      public c7294(int var1, int var2, int var3, int var4) {
         this.c6530 = var1;
         this.c5688 = var2;
         this.c4982 = var3;
         this.c2998 = var4;
      }

      public void c5472() {
         Minecraft.playerController().c7098(this.c6530, this.c5688, this.c4982, this.c2998, Minecraft.thePlayer());
      }

      // $FF: synthetic method
      c7294(int var1, int var2, int var3, int var4, Object var5) {
         this(var1, var2, var3, var4);
      }
   }

}
