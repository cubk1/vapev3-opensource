package gg.vape.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import gg.vape.Vape;
import gg.vape.module.none.ClientSettings;
import gg.vape.unmap.Bendable;

import java.util.UUID;

public class Profile extends Bendable {
   public UUID c5445 = UUID.randomUUID();
   public String c7222;
   public String c319;
   public JsonObject profile;
   public String c2099 = "";
   public boolean c3126;
   public JsonObject c6801 = new JsonObject();

   public Profile(String var1, String var2) {
      this.c7222 = var1;
      this.c319 = var2;
   }

   public Profile(String var1, String var2, boolean var3) {
      this.c7222 = var1;
      this.c319 = var2;
      this.c3126 = var3;
   }

   public void loadConfigs() {
      if (this.profile.get("modules") != null && !this.profile.get("modules").isJsonNull()) {
         Vape.instance.getModManager().loadJson(this.profile.get("modules").getAsJsonArray());
      }

      if (this.profile.get("values") != null && !this.profile.get("values").isJsonNull()) {
         Vape.instance.getValueManager().loadJson(this.profile.get("values").getAsJsonArray());
      }

      if (this.profile.get("macros") != null && !this.profile.get("macros").isJsonNull()) {
         Vape.instance.getMacrosManager().loadJson(this.profile.get("macros").getAsJsonArray());
      }

      JsonArray tmp;
      if (this.profile.get("search") != null && !this.profile.get("search").isJsonNull()) {
         tmp = this.profile.get("search").getAsJsonArray();
         Vape.instance.getSearch().loadJson(tmp);
      }

      if (Vape.instance.needAutoLoad().autoLoadState.getValue()) {
         this.c1703();
      }

      if (this.profile.get("frames") != null && !this.profile.get("frames").isJsonNull()) {
         tmp = this.profile.get("frames").getAsJsonArray();
         JsonArray var2 = new JsonArray();
         var2.add(tmp);
         Vape.instance.getFrameManager().loadFrames(var2);
      }

   }

   public void c1703() {
      Vape.instance.getModManager().c1288(this.c6801);
   }

   public void c4702() {
      this.c6801 = Vape.instance.getModManager().getJsonObj();
   }

   public void c5864() {
      this.c319 = "3.25";
      this.profile = Vape.instance.getManagerJson();
      this.profile.add("enabled", this.c6801);
   }

   public JsonObject c6931() {
      return this.profile;
   }

   public void c3055(JsonObject var1) {
      this.profile = var1;
   }

   public UUID c208() {
      return this.c5445;
   }

   public void c7575(UUID var1) {
      this.c5445 = var1;
   }

   public String c1754() {
      return this.c7222;
   }

   public String c2580() {
      return this.c319;
   }

   public Profile c8870(JsonObject var1) {
      if (var1.get("id") != null && !var1.get("id").isJsonNull()) {
         this.c5445 = UUID.fromString(var1.get("id").getAsString());
      }

      if (var1.get("name") != null && !var1.get("name").isJsonNull()) {
         this.c7222 = var1.get("name").getAsString();
      }

      if (var1.get("version") != null && !var1.get("version").isJsonNull()) {
         this.c319 = var1.get("version").getAsString();
      }

      if (var1.get("data") != null && !var1.get("data").isJsonNull() && var1.get("data").isJsonObject()) {
         this.profile = var1.get("data").getAsJsonObject();
         if (this.profile.get("keybinds") != null && !this.profile.get("keybinds").isJsonNull()) {
            this.readBind(this.profile.get("keybinds").getAsJsonArray());
         }

         if (this.profile.has("enabled")) {
            this.c6801 = this.profile.getAsJsonObject("enabled");
         }
      }

      return this;
   }

   public JsonObject c927() {
      JsonObject json = new JsonObject();
      json.addProperty("id", this.c5445.toString());
      json.addProperty("name", this.c7222);
      json.addProperty("version", this.c319);
      this.profile.add("keybinds", this.toJson());
      json.add("data", this.profile);
      return json;
   }

   public String c4968() {
      return this.c2099;
   }

   public void c4135(String var1) {
      this.c2099 = var1;
   }

   public boolean c5319() {
      return this.c3126;
   }

   public void c8827(boolean var1) {
      this.c3126 = var1;
   }

   public void c8471() {
      Vape.instance.getProfilesManager().c4349(this);
   }

   public String c407() {
      return String.format(" %s7[%sr%s%s7]%sr %s", ClientSettings.colorPrefix, ClientSettings.colorPrefix, this.getBindName(), ClientSettings.colorPrefix, ClientSettings.colorPrefix, this.c1754());
   }
}
