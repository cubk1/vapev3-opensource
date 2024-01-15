package gg.vape.friend;

import com.google.gson.JsonObject;
import gg.vape.Vape;

public class Friend {
   public String c2488;
   public String c117;
   public boolean c635 = true;

   public Friend(String name, String alias) {
      this.c2488 = name;
      this.c117 = alias;
   }

   public String c3125() {
      return this.c2488;
   }

   public String c3501() {
      return Vape.instance.getFriendManager().useAlias.getValue() ? this.c5811() : this.c2488;
   }

   public void c384(String var1) {
      this.c117 = var1;
   }

   public String c5811() {
      return this.c117;
   }

   public boolean inFriends() {
      return this.c635;
   }

   public void c7228(boolean var1) {
      this.c635 = var1;
      Vape.instance.getFriendManager().c2618();
   }

   public Friend loadJson(JsonObject var1) {
      if (var1.get("name") != null && !var1.get("name").isJsonNull()) {
         this.c2488 = var1.get("name").getAsString();
      }

      if (var1.get("alias") != null && !var1.get("alias").isJsonNull()) {
         this.c117 = var1.get("alias").getAsString();
      }

      if (var1.get("target") != null && !var1.get("target").isJsonNull()) {
         this.c635 = var1.get("target").getAsBoolean();
      }

      return this;
   }

   public JsonObject toJson() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("name", this.c2488);
      var1.addProperty("alias", this.c117);
      var1.addProperty("target", this.c635);
      return var1;
   }
}
