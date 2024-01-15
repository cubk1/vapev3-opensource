package gg.vape.unmap;

import com.google.gson.JsonObject;
import gg.vape.Vape;
import gg.vape.wrapper.impl.Item;
import gg.vape.wrapper.impl.ItemStack;
import gg.vape.wrapper.impl.Minecraft;

public class ItemLimitData {
   public String name;
   public int c2416;
   public boolean c977;
   public int c798;

   public ItemLimitData(String name, int var2) {
      this.c977 = true;
      this.c798 = -1;
      this.name = name;
      this.c2416 = var2;
      this.c5163();
   }

   public void c5163() {
      if (this.name.contains(":")) {
         String[] var1 = this.name.split(":");
         this.name = var1[0];

         try {
            this.c798 = Integer.parseInt(var1[1]);
         } catch (Exception var3) {
         }
      }

   }

   public ItemLimitData(String var1) {
      this(var1, 1);
   }

   public String getName() {
      return this.name;
   }

   public void c252(String var1) {
      this.name = var1;
   }

   public int c6483() {
      return this.c2416;
   }

   public void c5708(int var1) {
      this.c2416 = var1;
   }

   public boolean c276() {
      return this.c977;
   }

   public void c5492(boolean var1) {
      this.c977 = var1;
   }

   public Item c3876() {
      return Item.c8459(this.getName());
   }

   public boolean c6497(ItemStack var1) {
      if (!this.c276()) {
         return false;
      } else {
         if (this.getName().toLowerCase().startsWith("slot")) {
            int var2 = 0;

            try {
               var2 = Integer.parseInt(this.getName().substring(4));
            } catch (Exception var4) {
            }

            if (var2 >= 1 && Minecraft.thePlayer().c89().c1744() + 1 == var2) {
               return true;
            }
         }

         if (this.c7007(var1)) {
            return true;
         } else if (!var1.isNull() && !var1.getItem().isNull()) {
            boolean var5 = this.c379(var1);
            if (var5 && this.c798 != -1) {
               int var3 = var1.c2021();
               if (this.c798 != var3) {
                  var5 = false;
               }
            }

            return var5;
         } else {
            return false;
         }
      }
   }

   public boolean c7007(ItemStack var1) {
      return Vape.instance.getItemHelper().c1943(this.getName().toLowerCase(), var1);
   }

   public boolean c379(ItemStack var1) {
      String var2 = this.getName().toLowerCase();
      Item var3 = var1.getItem();
      if (var2.equals(String.valueOf(var3.c3715()))) {
         return true;
      } else {
         return var2.equals(var3.c2090(var1).toLowerCase());
      }
   }

   public int c7976() {
      return this.c798;
   }

   public JsonObject toJson() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("item-id", this.name);
      var1.addProperty("total-stacks", this.c2416);
      var1.addProperty("enabled", this.c977);
      return var1;
   }

   public void c777(JsonObject var1) {
      if (var1.get("item-id") != null) {
         this.name = var1.get("item-id").getAsString();
         this.c5163();
      }

      if (var1.get("total-stacks") != null) {
         this.c2416 = var1.get("total-stacks").getAsInt();
      }

      if (var1.get("enabled") != null) {
         this.c977 = var1.get("enabled").getAsBoolean();
      }

   }
}
