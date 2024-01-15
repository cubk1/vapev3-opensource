package gg.vape.manager.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gg.vape.value.Value;

import java.util.ArrayList;
import java.util.List;

public class IndependentSettingsManager {
   public final List<Value<?,?>> values = new ArrayList<>();

   public void regValue(Value<?,?> value) {
      this.values.add(value);
   }

   public JsonArray toJson() {
      JsonArray json = new JsonArray();
      for (Value<?,?> value : this.values) {
         json.add(value.toJson());
      }
      return json;
   }

   public void loadIndependentSettings(JsonArray json) {
      if (json.size() != 0) {
         for(int i = 0; i < json.size(); ++i) {
            JsonElement element = json.get(i);
            if (element.isJsonObject() && !element.isJsonNull()) {
               JsonObject jsonObject = element.getAsJsonObject();
               if (jsonObject.get("id") != null && !jsonObject.get("id").isJsonNull()) {
                  for (Value<?,?> values : this.values) {
                     if (values.getID().equalsIgnoreCase(jsonObject.get("id").getAsString())) {
                        values.loadJson(jsonObject);
                     }
                  }
               }
            }
         }

      }
   }

   public List<Value<?,?>> values() {
      return this.values;
   }
}
