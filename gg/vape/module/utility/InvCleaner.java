package gg.vape.module.utility;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import gg.vape.event.impl.EventPlayerTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.UtilityMod;
import gg.vape.module.utility.invcleaner.OldItemStackComparator;
import gg.vape.unmap.InvComparator;
import gg.vape.unmap.ItemComparator;
import gg.vape.unmap.ItemLimitData;
import gg.vape.unmap.ItemStackComparator;
import gg.vape.utils.TimerUtil;
import gg.vape.value.BooleanValue;
import gg.vape.value.LimitValue;
import gg.vape.value.RandomValue;
import gg.vape.wrapper.impl.*;

import java.util.*;

public class InvCleaner extends UtilityMod {
   public final Map c1854 = new HashMap();
   public ItemStack[] c201;
   public ItemStack c568;
   public ItemStack c8939;
   public ItemStack c3508;
   public ItemStack c277;
   public final TimerUtil c5643 = new TimerUtil();
   public final RandomValue c7264 = RandomValue.create(this, "Delay", "#", "", 1.0, 60.0, 80.0, 200.0);
   public final BooleanValue c2794 = BooleanValue.create(this, "Best Items", true, "Keeps the best set of armor, sword, axe, pickaxe and bow");
   public final BooleanValue c5668 = BooleanValue.create(this, "Remove Negative Potions", true, "Will always throw out negative potions");
   public final BooleanValue c4663 = BooleanValue.create(this, "Remove Food", true, "Remove Food except for Golden Apples");
   public final BooleanValue c7692 = BooleanValue.create(this, "Open Inventory", true, "Opens your inventory when cleaning.");
   public final LimitValue c8282;
   public final LimitValue c8509;

   public InvCleaner() {
      super("InvCleaner", "Cleans blacklisted items from your inventory.\nDoes not throw out whitelisted items.");
      this.c8282 = LimitValue.c1915(this, "invcleaner-whitelisted", "Whitelisted", LimitValue.allowed, 1, Collections.emptyList());
      this.c8509 = LimitValue.create(this, "invcleaner-blacklisted", "Blacklisted", LimitValue.blocked, Collections.emptyList());
      this.addValue(this.c7264, this.c7692, this.c2794, this.c5668, this.c4663, this.c8282, this.c8509);
   }

   public void c992() {
      super.c992();
      this.c8282.c200("344", 1);
      this.c8282.c200("384", 1);
      this.c8282.c200("332", 1);
      this.c8282.c200("346", 1);
      this.c8282.c200("368", 1);
      this.c8509.c200("280", -1);
      this.c8509.c200("287", -1);
      this.c8509.c200("318", -1);
      this.c8509.c200("345", -1);
      this.c8509.c200("288", -1);
      this.c8509.c200("374", -1);
      this.c8509.c200("116", -1);
      this.c8509.c200("54", -1);
      this.c8509.c200("145", -1);
   }

   public void onDisable() {
      this.c1854.clear();
   }

   public void onTick(EventPlayerTick event) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      if (!Minecraft.currentScreen().isInstance(MappedClasses.GuiContainer) && this.c7692.getValue()) {
         int var14 = Minecraft.gameSettings().c6987().getKeyCode();
         KeyBinding.setKeyBindState(var14, true);
         KeyBinding.onTick(var14);
         KeyBinding.setKeyBindState(var14, false);
      } else {
         if (this.c5643.hasTimeElapsed((long)this.c7264.c7470())) {
            this.c1854.clear();
            this.c201 = this.c5280();
            this.c568 = this.c7554(MappedClasses.ItemSword, new OldItemStackComparator(this));
            this.c8939 = this.c7554(MappedClasses.ItemPickaxe, new ItemStackComparator(this));
            this.c277 = this.c7554(MappedClasses.ItemPickaxe, new InvComparator(this));
            this.c3508 = this.c7554(MappedClasses.ItemAxe, new ItemComparator(this));
            boolean var3 = false;
            if (var2.c7368().isNull()) {
               return;
            }

            Iterator var4 = var2.c7368().c7580().iterator();

            label121:
            while(var4.hasNext()) {
               Slot var5 = (Slot)var4.next();

               try {
                  if (var5.c5354() && !var5.c4981().isNull()) {
                     Object[] var6 = var2.c89().c2542();
                     int var7 = var6.length;

                     for(int var8 = 0; var8 < var7; ++var8) {
                        Object var9 = var6[var8];
                        if (var9 != null && var9.equals(var5.c4981())) {
                           continue label121;
                        }
                     }

                     Item var15 = var5.c4981().getItem();
                     var7 = Item.c1501(var15);
                     ItemLimitData var16 = this.c8282.c4768(var5.c4981().getItem().c3715() + "");
                     if (var16 == null) {
                        var16 = this.c8282.c4768(var5.c4981().getItem().c2090(var5.c4981()));
                     }

                     if (var16 != null && var16.c276()) {
                        Set var17 = (Set)this.c1854.get(var7);
                        if (var17 == null) {
                           HashSet var18 = new HashSet();
                           var18.add(var5.c3715());
                           this.c1854.put(var7, var18);
                           continue;
                        }

                        var17.add(var5.c3715());
                        if (var5.c4981().equals(var2.getHeldItemHand())) {
                           continue;
                        }

                        if (var17.size() > var16.c6483()) {
                           Iterator var10 = var17.iterator();

                           label103:
                           while(true) {
                              Integer var11;
                              do {
                                 do {
                                    if (!var10.hasNext()) {
                                       break label103;
                                    }

                                    var11 = (Integer)var10.next();
                                 } while(var11 == var5.c3715());
                              } while(var17.size() <= var16.c6483());

                              ItemStack var12 = var2.c7368().c8687(var11).c4981();
                              if (!var12.equals(var2.getHeldItemHand()) && this.c3239(var5.c4981()) >= this.c3239(var12)) {
                                 this.c5305(var11);
                              } else {
                                 this.c5305(var5.c3715());
                              }

                              var3 = true;
                           }
                        }
                     }

                     if (this.c3858(var5.c4981())) {
                        this.c5305(var5.c3715());
                        var3 = true;
                        break;
                     }
                  }
               } catch (Exception var13) {
               }
            }

            if (!var3) {
               this.setState(false);
               if (this.c7692.getValue()) {
                  var2.c4088();
               }
            }

            if (var2.capabilities().isCreativeMode() && Minecraft.currentScreen().isInstance(MappedClasses.GuiContainer)) {
               this.setState(false);
            }

            this.c5643.reset();
         }

      }
   }

   public void c5305(int var1) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      Minecraft.playerController().c7098(var2.c7368().c3715(), var1, 0, 0, var2);
      Minecraft.playerController().c7098(var2.c7368().c3715(), -999, 0, 0, var2);
   }

   public boolean c3858(ItemStack var1) {
      Item var2 = var1.getItem();
      if (var2.isInstance(MappedClasses.ItemArmor)) {
         ItemArmor var3 = new ItemArmor(var2);
         if (this.c201[var3.c3715()] != null && !this.c201[var3.c3715()].equals(var1)) {
            return true;
         }
      }

      boolean var4 = true;
      if (this.c2794.getValue()) {
         var4 = var2.isInstance(MappedClasses.ItemBow) && !this.c277.equals(var1) || var2.isInstance(MappedClasses.ItemPickaxe) && !this.c8939.equals(var1) || var2.isInstance(MappedClasses.ItemSword) && !this.c568.equals(var1) || var2.isInstance(MappedClasses.ItemAxe) && !this.c3508.equals(var1);
      }

      return this.c8509.isValid(var1) || var4 || this.c4663.getValue() && var2.isInstance(MappedClasses.ItemFood) && !var2.isInstance(MappedClasses.ItemAppleGold) || this.c5668.getValue() && var2.isInstance(MappedClasses.ItemPotion) && this.c6318(var1);
   }

   public ItemStack c7554(Class var1, Comparator var2) {
      ArrayList var3 = new ArrayList();
      Iterator var4 = Minecraft.thePlayer().c7368().c7580().iterator();

      while(var4.hasNext()) {
         Slot var5 = (Slot)var4.next();
         if (var5.c5354() && var5.c4981().isNotNull() && var5.c4981().getItem().isInstance(var1)) {
            var3.add(var5.c4981());
         }
      }

      var3.sort(var2);
      Collections.reverse(var3);
      if (var3.isEmpty()) {
         return null;
      } else {
         return (ItemStack)var3.get(0);
      }
   }

   public ItemStack[] c5280() {
      ItemStack[] var1 = new ItemStack[4];
      ArrayList var2 = new ArrayList();
      List var3 = Minecraft.thePlayer().c7368().c7580();
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         Slot var5 = (Slot)var4.next();
         if (var5.c5354() && var5.c4981().getItem().isInstance(MappedClasses.ItemArmor)) {
            var2.add(var5.c4981());
         }
      }

      var4 = var2.iterator();

      while(true) {
         ItemArmor var6;
         ItemStack var7;
         ItemStack var8;
         do {
            if (!var4.hasNext()) {
               return var1;
            }

            var8 = (ItemStack)var4.next();
            var6 = new ItemArmor(var8.getItem());
            var7 = var1[var6.c3715()];
         } while(var7 != null && !(this.c4922(var8) > this.c4922(var7)));

         var1[var6.c3715()] = var8;
      }
   }

   public double c4922(ItemStack var1) {
      int var2 = 0;
      if (var1.getItem().isInstance(MappedClasses.ItemArmor)) {
         ItemArmor var3 = new ItemArmor(var1.getItem());
         var2 = var3.c1744();
      }

      var2 += EnchantmentHelper.c3182(new ItemStack[]{var1}, DamageSource.c3654(Minecraft.thePlayer()));
      return var2;
   }

   public boolean c6318(ItemStack var1) {
      if (!var1.getItem().isInstance(MappedClasses.ItemPotion)) {
         return false;
      } else {
         ItemSplashPotion var2 = new ItemSplashPotion(var1.getItem());
         List var3 = var2.c3477(var1);
         Iterator var4 = var3.iterator();

         Potion var6;
         do {
            if (!var4.hasNext()) {
               return false;
            }

            PotionEffect var5 = (PotionEffect)var4.next();
            var6 = Potion.c6875(var5.c3715());
         } while(!var6.c3624());

         return true;
      }
   }

   public double c3239(ItemStack var1) {
      double var2 = this.c4922(var1);
      var2 += EnchantmentHelper.c7113(32, var1);
      var2 += EnchantmentHelper.c7113(16, var1);
      var2 += EnchantmentHelper.c7113(19, var1);
      var2 += EnchantmentHelper.c7113(20, var1);
      var2 += EnchantmentHelper.c7113(48, var1);
      var2 += EnchantmentHelper.c7113(34, var1);
      return var2;
   }

   public LimitValue c3647() {
      return this.c8282;
   }

   public LimitValue c5241() {
      return this.c8509;
   }

   public void loadJson(JsonObject var1) {
      super.loadJson(var1);
      JsonArray var2;
      JsonObject var3;
      if (var1.get("whitelisted-items") != null) {
         var2 = var1.get("whitelisted-items").getAsJsonArray();
         var3 = new JsonObject();
         var3.addProperty("id", this.c8282.getID());
         var3.add("value", var2);
         this.c8282.loadJson(var3);
      }

      if (var1.get("blacklisted-items") != null) {
         var2 = var1.get("blacklisted-items").getAsJsonArray();
         var3 = new JsonObject();
         var3.addProperty("id", this.c8509.getID());
         var3.add("value", var2);
         this.c8509.loadJson(var3);
      }

   }
}
