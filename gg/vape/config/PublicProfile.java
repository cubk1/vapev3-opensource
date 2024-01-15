package gg.vape.config;

import com.google.gson.JsonObject;
import gg.vape.config.Profile;

public class PublicProfile extends Profile {
   public int c2614;
   public boolean c3577 = false;
   public boolean c5623;
   public boolean c1287;
   public int c2930;
   public int c1264;

   public PublicProfile(String var1, String var2) {
      super(var1, var2);
   }

   public int c8382() {
      return this.c2614;
   }

   public void c5305(int var1) {
      this.c2614 = var1;
   }

   public Profile c8870(JsonObject var1) {
      super.c8870(var1);
      if (var1.get("usages") != null) {
         this.c2614 = var1.get("usages").getAsInt();
      }

      if (var1.get("last_updated") != null) {
         this.c4135(var1.get("last_updated").getAsString());
      }

      if (var1.get("likes") != null) {
         this.c2404(var1.get("likes").getAsInt());
      }

      if (var1.get("dislikes") != null) {
         this.c5014(var1.get("dislikes").getAsInt());
      }

      if (var1.get("liked") != null) {
         int var2 = var1.get("liked").getAsInt();
         if (var2 == 1) {
            this.c5623 = true;
         }

         if (var2 == 2) {
            this.c1287 = true;
         }
      }

      return this;
   }

   public JsonObject c927() {
      JsonObject var1 = super.c927();
      return var1;
   }

   public boolean c2239() {
      return this.c3577;
   }

   public void c8121(boolean var1) {
      this.c3577 = var1;
   }

   public int c581() {
      return this.c2930;
   }

   public double c1956() {
      double var1 = 1.0;
      if (this.c581() > 0 && this.c3883() > 0) {
         var1 = (double)this.c581() / ((double)this.c581() + (double)this.c3883());
      }

      return var1;
   }

   public int c5136() {
      double var1 = this.c1956();
      int var3 = (int)((double)this.c8382() * var1 * 1.2);
      if (this.c3883() > 0) {
         var3 = (int)((double)var3 / ((double)this.c3883() * var1 * (double)this.c581()));
      }

      var3 = (int)((double)var3 + (double)this.c581() * 1.5);
      var3 += this.c8382();
      return var3;
   }

   public void c2404(int var1) {
      this.c2930 = var1;
   }

   public int c3883() {
      return this.c1264;
   }

   public void c5014(int var1) {
      this.c1264 = var1;
   }

   public boolean c199() {
      return this.c5623;
   }

   public void c7363(boolean var1) {
      this.c5623 = var1;
   }

   public boolean c6051() {
      return this.c1287;
   }

   public void c4983(boolean var1) {
      this.c1287 = var1;
   }

   public void c7829() {
      if (this.c1287) {
         this.c1287 = false;
         this.c5014(this.c3883() - 1);
      }

      if (this.c5623) {
         this.c2404(this.c581() - 1);
      } else {
         this.c2404(this.c581() + 1);
      }

      this.c5623 = !this.c5623;
   }

   public void c122() {
      if (this.c5623) {
         this.c5623 = false;
         this.c2404(this.c581() - 1);
      }

      if (this.c1287) {
         this.c5014(this.c3883() - 1);
      } else {
         this.c5014(this.c3883() + 1);
      }

      this.c1287 = !this.c1287;
   }
}
