package gg.vape.module;

import com.google.gson.JsonObject;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.value.BooleanValue;
import gg.vape.value.RandomValue;

public class Macro {
   public String name;
   public int c6867 = 0;
   public RandomValue delay = RandomValue.create(this, "Delay", "#", "", 1.0, 100.0, 200.0, 1000.0);
   public BooleanValue doubleClick = BooleanValue.create(this, "Double Click", false);
   public RandomValue doubleClickDelay = RandomValue.create(this, "Double Click Delay", "#", "", 1.0, 100.0, 200.0, 1000.0);
   public FrameComponent c2277;

   public Macro(String name) {
      this.name = name;
      this.doubleClick.getLimits().add(this.doubleClickDelay);
   }

   public String c3731() {
      return this.name;
   }

   public int c7728() {
      return this.c6867;
   }

   public void c6122(int var1) {
      this.c6867 = var1;
   }

   public RandomValue c2102() {
      return this.delay;
   }

   public void c3707(RandomValue var1) {
      this.delay = var1;
   }

   public RandomValue c6968() {
      return this.doubleClickDelay;
   }

   public void c6105(RandomValue var1) {
      this.doubleClickDelay = var1;
   }

   public BooleanValue c2906() {
      return this.doubleClick;
   }

   public void c7503(BooleanValue var1) {
      this.doubleClick = var1;
   }

   public JsonObject c223() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("name", this.name);
      var1.addProperty("key", this.c6867);
      var1.add("delay", this.delay.toJson());
      var1.add("double_click_enabled", this.doubleClick.toJson());
      var1.add("double_click", this.doubleClickDelay.toJson());
      return var1;
   }

   public Macro loadJson(JsonObject var1) {
      if (var1.get("name") != null && !var1.get("name").isJsonNull()) {
         this.name = var1.get("name").getAsString();
      }

      if (var1.get("key") != null && !var1.get("key").isJsonNull()) {
         this.c6867 = var1.get("key").getAsInt();
      }

      if (var1.get("double_click_enabled") != null && !var1.get("double_click_enabled").isJsonNull()) {
         this.doubleClick.loadJson(var1.get("double_click_enabled").getAsJsonObject());
      }

      if (var1.get("double_click") != null && !var1.get("delay").isJsonNull()) {
         this.delay.loadJson(var1.get("delay").getAsJsonObject());
      }

      if (var1.get("double_click") != null && !var1.get("double_click").isJsonNull()) {
         this.doubleClickDelay.loadJson(var1.get("double_click").getAsJsonObject());
      }

      return this;
   }

   public FrameComponent c7672() {
      return this.c2277;
   }

   public void c1406(FrameComponent var1) {
      this.c2277 = var1;
   }
}
