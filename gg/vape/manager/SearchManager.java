package gg.vape.manager;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import gg.vape.Vape;
import gg.vape.module.none.Search;
import gg.vape.ui.click.frame.impl.FrameClosable;
import gg.vape.ui.unmap.SearchBlock;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SearchManager {
   public final Set c513 = new HashSet();

   public void c7224(SearchBlock var1) {
      this.c513.add(var1);
      Search var2 = Vape.instance.getModManager().getMod(Search.class);
      var2.c6140(var1);
   }

   public void c207(FrameClosable var1) {
      SearchBlock var2 = null;
      Iterator var3 = this.c513.iterator();

      while(var3.hasNext()) {
         SearchBlock var4 = (SearchBlock)var3.next();
         if (var4.equals(var1.c305())) {
            var2 = var4;
         }
      }

      if (var2 != null) {
         Search var5 = Vape.instance.getModManager().getMod(Search.class);
         var5.c4868(var2);
         FrameManager.frameSearch.c5915(var1);
         this.c513.remove(var2);
      }

   }

   public void c5253() {
      Iterator var1 = (new HashSet(this.c513)).iterator();

      while(var1.hasNext()) {
         SearchBlock var2 = (SearchBlock)var1.next();
         this.c207(var2.c8745());
      }

   }

   public boolean c5122(int var1) {
      Iterator var2 = this.c513.iterator();

      SearchBlock var3;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         var3 = (SearchBlock)var2.next();
      } while(var3.c2801() != var1);

      return true;
   }

   public JsonArray toJson() {
      JsonArray var1 = new JsonArray();
      Iterator var2 = this.c513.iterator();

      while(var2.hasNext()) {
         SearchBlock var3 = (SearchBlock)var2.next();
         var1.add(var3.c1007());
      }

      return var1;
   }

   public void loadJson(JsonArray var1) {
      this.c5253();

      for(int var2 = 0; var2 < var1.size(); ++var2) {
         JsonElement var3 = var1.get(var2);
         if (var3.isJsonObject() && !var3.isJsonNull()) {
            SearchBlock var4 = (new SearchBlock("", 0)).c1966(var3.getAsJsonObject());
            this.c7224(var4);
         }
      }

   }
}
