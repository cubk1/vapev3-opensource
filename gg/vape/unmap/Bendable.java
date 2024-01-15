package gg.vape.unmap;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import gg.vape.module.none.ClickGui;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Bendable {
   public String c3219;
   public final List c5049 = new CopyOnWriteArrayList();

   public abstract void c8471();

   public List c8399() {
      return this.c5049;
   }

   public void c2585(List var1) {
      this.c5049.clear();
      this.c5049.addAll(var1);
      if (this instanceof ClickGui && !this.c3344()) {
         this.c2585(Collections.singletonList(54));
      }

   }

   public boolean c3059(int var1) {
      if (this.c8399().isEmpty()) {
         return false;
      } else {
         if (this.c8399().size() == 1) {
            if (this.c8399().contains(var1)) {
               this.c8471();
               return true;
            }
         } else {
            int var2 = 0;
            Iterator var3 = this.c8399().iterator();

            while(var3.hasNext()) {
               int var4 = (Integer)var3.next();
               if (var4 == var1) {
                  ++var2;
               } else if (var4 < 0) {
                  if (Mouse.isButtonDown(100 + var4)) {
                     ++var2;
                  }
               } else if (Keyboard.isKeyDown(var4)) {
                  ++var2;
               }
            }

            if (var2 == this.c8399().size()) {
               this.c8471();
               return true;
            }
         }

         return false;
      }
   }

   public String getBindName() {
      StringBuilder var1 = new StringBuilder();

      for(int var2 = 0; var2 < this.c5049.size(); ++var2) {
         int var3 = (Integer)this.c5049.get(var2);
         if (var3 != 0) {
            var1.append(this.c4666(var3));
            if (var2 != this.c5049.size() - 1) {
               var1.append("+");
            }
         }
      }

      return var1.toString();
   }

   public boolean c3344() {
      boolean var1 = !this.c5049.isEmpty();
      Iterator var2 = this.c5049.iterator();

      while(var2.hasNext()) {
         Integer var3 = (Integer)var2.next();
         if (var3 == 0) {
            var1 = false;
            break;
         }
      }

      return var1;
   }

   public String c7686() {
      return this.c3219;
   }

   public String c4666(int var1) {
      return var1 >= 0 ? Keyboard.getKeyName(var1) : "M" + (101 + var1);
   }

   public void c1287(int var1) {
      if (this instanceof ClickGui && var1 == 0) {
         var1 = 54;
      }

      if (var1 >= 0) {
         this.c3219 = Keyboard.getKeyName(var1);
      } else {
         this.c3219 = "M" + (101 + var1);
      }

   }

   public JsonArray toJson() {
      JsonArray var1 = new JsonArray();

      for (Object o : this.c8399()) {
         Integer var3 = (Integer) o;
         var1.add((new Gson()).toJsonTree(var3));
      }

      return var1;
   }

   public void readBind(JsonArray var1) {
      this.c8399().clear();

      for (JsonElement var3 : var1) {
         int var4 = var3.getAsInt();
         if (var4 != 0) {
            this.c8399().add(var4);
         }
      }

   }

   public abstract String c407();
}
