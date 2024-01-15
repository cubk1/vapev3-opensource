package gg.vape.manager;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gg.vape.module.Macro;
import gg.vape.module.macro.BaseMacroImpl;
import gg.vape.module.macro.RodMacro;

import java.util.*;

public class MacroManager {
   public final Set c7052 = new HashSet();

   public void c1123(Macro var1) {
      this.c7052.add(var1);
      FrameManager.frameMacros.c1396(var1);
   }

   public void c3000(Macro var1) {
      this.c7052.remove(var1);
      FrameManager.frameMacros.c2756(var1);
   }

   public Macro c3590(String var1) {
      Iterator var2 = this.c7052.iterator();

      Macro var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (Macro)var2.next();
      } while(!var3.c3731().equalsIgnoreCase(var1));

      return var3;
   }

   public Macro c720(int var1) {
      Iterator var2 = this.c7052.iterator();

      Macro var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (Macro)var2.next();
      } while(var3.c7728() != var1);

      return var3;
   }

   public List c7377(int var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.c7052.iterator();

      while(var3.hasNext()) {
         Macro var4 = (Macro)var3.next();
         if (var4.c7728() == var1) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public void c4084() {
      Iterator var1 = (new HashSet(this.c7052)).iterator();

      while(var1.hasNext()) {
         Macro var2 = (Macro)var1.next();
         this.c3000(var2);
      }

   }

   public void loadJson(JsonArray var1) {
      this.c4084();

      for(int var2 = 0; var2 < var1.size(); ++var2) {
         JsonElement var3 = var1.get(var2);
         if (var3.isJsonObject() && !var3.isJsonNull()) {
            JsonObject var4 = var3.getAsJsonObject();
            if (var4.get("name") != null && !var4.get("name").isJsonNull()) {
               String var5 = var4.get("name").getAsString();
               Object var6;
               if (var5.startsWith("/")) {
                  var6 = new BaseMacroImpl(var5);
               } else if (var5.equalsIgnoreCase("fishing rod")) {
                  var6 = new RodMacro(var5);
               } else {
                  var6 = new Macro(var5);
               }

               ((Macro)var6).loadJson(var4);
               this.c1123((Macro)var6);
            }
         }
      }

   }

   public JsonArray toJson() {
      JsonArray var1 = new JsonArray();
      Iterator var2 = this.c7052.iterator();

      while(var2.hasNext()) {
         Macro var3 = (Macro)var2.next();
         var1.add(var3.c223());
      }

      return var1;
   }
}
