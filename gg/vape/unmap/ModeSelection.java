package gg.vape.unmap;

import gg.vape.value.ModeValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ModeSelection implements INamed {
   public static HashMap c6304 = new HashMap();
   public ModeValue mode;
   public final String current;

   public ModeSelection(String var1) {
      this.current = var1;
   }

   public static ModeSelection c2599(ModeValue var0, String var1) {
      List var2 = (List)c6304.get(var0);
      Iterator var3 = var2.iterator();

      ModeSelection var4;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         var4 = (ModeSelection)var3.next();
      } while(!var4.getName().equalsIgnoreCase(var1));

      return var4;
   }

   public String getName() {
      return this.current;
   }

   public ModeValue getMode() {
      return this.mode;
   }

   public void c2742(ModeValue var1) {
      this.mode = var1;
      if (!c6304.containsKey(var1)) {
         c6304.put(var1, new ArrayList());
      }

      ((List)c6304.get(var1)).add(this);
   }

   public String toString() {
      return this.current;
   }
}
