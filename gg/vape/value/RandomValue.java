package gg.vape.value;

import com.google.gson.JsonObject;
import func.skidline.NumberData;
import gg.vape.ui.click.component.value.RandomComponent;

import java.util.Random;

public class RandomValue extends Value<NumberData[], RandomComponent> {
   public final Random c780 = new Random();

   public RandomValue(Object var1, String var2, RandomComponent var3) {
      super(var1, var2, var3);
   }

   public static RandomValue c6897(Object var0, String var1, String var2, String var3, String var4, double var5, double var7, double var9, double var11) {
      RandomComponent var13 = new RandomComponent(var11, var5, var3, var4, var2);
      var13.onOffset(7.0);
      var13.c7591(var9);
      var13.c8030(var7);
      RandomValue var14 = new RandomValue(var0, var1, var13);
      var14.c2026(new NumberData[]{new NumberData(var7), new NumberData(var9)});
      var13.c8376(var14);
      return var14;
   }

   public static RandomValue create(Object var0, String var1, String var2, String var3, double var4, double var6, double var8, double var10) {
      RandomComponent var12 = new RandomComponent(var10, var4, var2, " " + var3, var1);
      var12.onOffset(7.0);
      var12.c7591(var8);
      var12.c8030(var6);
      RandomValue var13 = new RandomValue(var0, var1, var12);
      var13.c2026(new NumberData[]{new NumberData(var6), new NumberData(var8)});
      var12.c8376(var13);
      return var13;
   }

   public static RandomValue c5023(Object var0, String var1, String var2, String var3, double var4, double var6, double var8, double var10, String var12) {
      RandomComponent var13 = new RandomComponent(var10, var4, var2, " " + var3, var1);
      var13.onOffset(7.0);
      var13.c7591(var8);
      var13.c8030(var6);
      RandomValue var14 = new RandomValue(var0, var1, var13);
      var13.c8376(var14);
      var14.c2026(new NumberData[]{new NumberData(var6), new NumberData(var8)});
      var13.setText(var12);
      return var14;
   }

   public NumberData[] getValue() {
      return new NumberData[]{new NumberData(((RandomComponent)this.getComponent()).c7481()), new NumberData(((RandomComponent)this.getComponent()).c1826())};
   }

   public void setValue(NumberData[] var1) {
      if (this.c1672() == null) {
         this.c2026(var1);
      }

      ((RandomComponent)this.getComponent()).c8030(var1[0].doubleValue());
      ((RandomComponent)this.getComponent()).c7591(var1[1].doubleValue());
   }

   public void parse(String var1) {
   }

   public JsonObject toJson() {
      JsonObject var1 = super.toJson();
      var1.remove("value");
      var1.addProperty("minimum", this.getValue()[0]);
      var1.addProperty("maximum", this.getValue()[1]);
      return var1;
   }

   public boolean loadJson(JsonObject var1) {
      if (var1.get("id").getAsString().equalsIgnoreCase(this.getID())) {
         if (!var1.has("minimum")) {
            return false;
         } else {
            double var2 = var1.get("minimum").getAsDouble();
            double var4 = var1.get("maximum").getAsDouble();
            this.setValue(new NumberData[]{new NumberData(var2), new NumberData(var4)});
            return true;
         }
      } else {
         return false;
      }
   }

   public String c4968() {
      return ((RandomComponent)this.getComponent()).c610().c3316(this.getValue()[0]);
   }

   public String c5400() {
      return ((RandomComponent)this.getComponent()).c610().c3316(this.getValue()[1]);
   }

   public double c7470() {
      double var1 = this.getValue()[0].doubleValue();
      double var3 = this.getValue()[1].doubleValue();
      return var1 + (var3 - var1) * this.c780.nextDouble();
   }

   public double c6465() {
      return this.getValue()[0].doubleValue();
   }

   public double c22() {
      return this.getValue()[1].doubleValue();
   }

   // $FF: synthetic method
   public Object c2908() {
      return this.getValue();
   }
}
