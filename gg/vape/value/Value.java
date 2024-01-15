package gg.vape.value;

import com.google.gson.JsonObject;
import gg.vape.Vape;
import gg.vape.module.Mod;
import gg.vape.module.none.AutoLoadValue;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.unmap.INamed;

public abstract class Value<K, C extends IGuiComponent> implements INamed {
   public final Object owner;
   public final String name;
   public IGuiComponent guiComponent;
   public K c5419;
   public Value<?,?> paraent;
   public boolean toggleable = true;

   public Value(Object owner, String name, C guiComponent) {
      this.owner = owner;
      this.name = name;
      this.guiComponent = guiComponent;
      if (owner != null) {
         if (owner instanceof AutoLoadValue) {
            Vape.instance.getSettingsManager().regValue(this);
         } else if (!(owner instanceof Mod)) {
            Vape.instance.getValueManager().c6297(this);
         }
      }

   }

   public String getName() {
      return this.name;
   }

   public abstract K getValue();

   public abstract void setValue(K var1);

   public abstract void parse(String var1);

   public K c1672() {
      return this.c5419;
   }

   public void c2026(K var1) {
      this.c5419 = var1;
   }

   public IGuiComponent getComponent() {
      return this.guiComponent;
   }

   protected void c6301(IGuiComponent var1) {
      this.guiComponent = var1;
   }

   public Value<?,?> getParent() {
      return this.paraent;
   }

   public void setParent(Value<?,?> value) {
      this.paraent = value;
   }

   public String getID() {
      return this.paraent != null ? this.paraent.name + "-" + this.name : this.name;
   }

   public Object getOwner() {
      return this.owner;
   }

   public JsonObject toJson() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("id", this.getID());
      if (this.getValue() != null) {
         var1.addProperty("value", this.getValue().toString());
      }

      return var1;
   }

   public boolean loadJson(JsonObject var1) {
      try {
         if (var1.get("id").getAsString().equalsIgnoreCase(this.getID())) {
            this.parse(var1.get("value").getAsString());
            return true;
         } else {
            return false;
         }
      }catch (Exception e){
         e.printStackTrace();
         return false;
      }
   }

   public boolean isToggleable() {
      return this.toggleable;
   }

   public void setToggleable(boolean flag) {
      this.toggleable = flag;
   }
}
