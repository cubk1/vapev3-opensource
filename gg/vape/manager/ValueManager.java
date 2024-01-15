package gg.vape.manager;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gg.vape.Vape;
import gg.vape.module.Macro;
import gg.vape.module.Mod;
import gg.vape.module.UtilityMod;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.frame.impl.FrameSearch;
import gg.vape.value.Value;

import java.util.*;

public class ValueManager {
   public final List c7341 = Arrays.asList(Mod.class, UtilityMod.class, Macro.class, FrameSearch.class);
   public final List c4267 = Collections.singletonList(ClickGui.class);
   public final List<Value<?,?>> c4377 = new ArrayList<>();

   public void c6297(Value var1) {
      this.c4377.add(var1);
   }

   public List<Value<?,?>> getValues() {
      return this.c4377;
   }

   public void loadJson(JsonArray var1) {
      label61:
      for(int var2 = 0; var2 < var1.size(); ++var2) {
         JsonElement var3 = var1.get(var2);
         if (var3.isJsonObject() && !var3.isJsonNull()) {
            JsonObject var4 = var3.getAsJsonObject();
            if (var4.get("id") != null && !var4.get("id").isJsonNull()) {
               Iterator var5 = this.getValues().iterator();

               while(true) {
                  Value var6;
                  do {
                     if (!var5.hasNext()) {
                        var5 = Vape.instance.getSettingsManager().values().iterator();

                        while(true) {
                           if (!var5.hasNext()) {
                              continue label61;
                           }

                           var6 = (Value)var5.next();
                           if (var6.getID().equalsIgnoreCase(var4.get("id").getAsString()) && !Vape.instance.c4762()) {
                              var6.loadJson(var4);
                           }
                        }
                     }

                     var6 = (Value<?,?>)var5.next();
                  } while(!this.c4267.contains(var6.getOwner().getClass().getSuperclass()) && !this.c4267.contains(var6.getOwner().getClass()) && this.c7341.contains(var6.getOwner().getClass().getSuperclass()));

                  if (!this.c7341.contains(var6.getOwner().getClass()) && var6.getID().equalsIgnoreCase(var4.get("id").getAsString())) {
                     var6.loadJson(var4);
                  }
               }
            }
         }
      }

   }

   public JsonArray toJson() {
      JsonArray var1 = new JsonArray();
      Iterator var2 = this.getValues().iterator();

      Value var3;
      while(var2.hasNext()) {
         var3 = (Value)var2.next();
         if (!this.c7341.contains(var3.getOwner().getClass()) && var3.isToggleable()) {
            var1.add(var3.toJson());
         }
      }

      var2 = Vape.instance.getSettingsManager().values().iterator();

      while(var2.hasNext()) {
         var3 = (Value)var2.next();
         if (var3.isToggleable()) {
            var1.add(var3.toJson());
         }
      }

      return var1;
   }
}
