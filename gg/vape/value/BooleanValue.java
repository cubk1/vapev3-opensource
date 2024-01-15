package gg.vape.value;

import gg.vape.ui.click.actions.ActionSetComponentDisplayable;
import gg.vape.ui.click.component.value.BooleanComponent;
import pub.nextsense.Tweaker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BooleanValue extends Value<Boolean, BooleanComponent> {
   public final List<Value<?,?>> limits = new ArrayList();
   public BooleanComponent c4097;

   public BooleanValue(Object var1, String var2, BooleanComponent var3) {
      super(var1, var2, var3);
   }

   public static BooleanValue c7943(Object var0, String var1, String var2, boolean var3) {
      BooleanComponent var4 = new BooleanComponent(var2, 10.0);
      var4.onOffset(10.0);
      var4.c8121(var3);
      BooleanValue value = new BooleanValue(var0, var1, var4);
      value.c2026(var3);
      var4.c8376(value);
      var4.c6740().add(new ActionSetComponentDisplayable());
      return value;
   }

   public static BooleanValue create(Object var0, String var1, boolean var2, String tt) {
      BooleanValue var4 = c7943(var0, var1, var1, var2);
      ((BooleanComponent)var4.getComponent()).setText(tt);
      return var4;
   }

   public static BooleanValue create(Object var0, String var1, boolean var2) {
      return c7943(var0, var1, var1, var2);
   }

   public Boolean getValue() {
      return ((BooleanComponent)this.getComponent()).c2346();
   }

   public void setValue(Boolean var1) {
      if (this.c1672() == null) {
         this.c2026(var1);
      }

      ((BooleanComponent)this.getComponent()).c8121(var1);
   }

   public Boolean checkValue() {
      if (((BooleanComponent)this.getComponent()).c3617()) {
         return Tweaker.isBlatantMode() ? this.getValue() : false;
      } else {
         return this.getValue();
      }
   }

   public BooleanValue setBlatant(boolean var1) {
      ((BooleanComponent)this.getComponent()).c4804(var1);
      return this;
   }

   public void parse(String var1) {
      this.setValue(Boolean.parseBoolean(var1));
   }

   public List<Value<?,?>> getLimits() {
      return this.limits;
   }

   public Value<?,?> getALimit() {
      Iterator<Value<?, ?>> limitsIter = this.getLimits().iterator();

      Value<?,?> value;
      do {
         if (!limitsIter.hasNext()) {
            return null;
         }

         value = limitsIter.next();
      } while(!value.equals(this.getLimits().get(this.getLimits().size() - 1)));

      if (value instanceof BooleanValue) {
         BooleanValue bv = (BooleanValue)value;
         if (!bv.getLimits().isEmpty()) {
            Value<?, ?> alimit = bv.getLimits().get(bv.getLimits().size() - 1);
            if (!bv.getLimits().isEmpty()) {
               return bv.getALimit();
            } else {
               return alimit;
            }
         } else {
            return value;
         }
      } else {
         return value;
      }
   }

   public BooleanValue limitValues(Value<?,?>... values) {
      for (Value<?, ?> value : values) {
         value.setParent(this);
      }
      this.limits.addAll(Arrays.asList(values));
      return this;
   }

}
