package gg.vape.module.utility;

import gg.vape.value.BooleanValue;
import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.module.UtilityMod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Panic extends UtilityMod {
   public final BooleanValue c3575 = BooleanValue.create(this, "Re-enable", false, "Re-enables all previously enabled modules upon pressing bind a second time");
   public final List c2126 = new ArrayList();
   public boolean c3960 = false;

   public Panic() {
      super("Panic", "Disables all currently enabled modules");
      this.addValue(this.c3575);
   }

   public void onEnable() {
      this.setState(false);
      Iterator var1;
      Mod var2;
      if (this.c3575.getValue()) {
         this.c3960 = !this.c3960;
         if (!this.c3960) {
            var1 = this.c2126.iterator();

            while(var1.hasNext()) {
               var2 = (Mod)var1.next();
               var2.setState(true);
            }

            this.c2126.clear();
            return;
         }
      } else {
         this.c3960 = false;
      }

      var1 = Vape.instance.getModManager().collectMods().iterator();

      while(var1.hasNext()) {
         var2 = (Mod)var1.next();
         if (var2.getState() && var2 != this) {
            var2.setState(false);
            if (this.c3575.getValue()) {
               this.c2126.add(var2);
            }
         }
      }

   }

   public void c1458(Mod var1) {
      if (var1 != this) {
         this.c3960 = false;
         this.c2126.clear();
      }

   }
}
