package gg.vape.ui.click.actions;

import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.value.BooleanValue;
import gg.vape.value.Value;

import java.util.Iterator;

public class ActionSetComponentDisplayable implements IGuiCallback {
   public void call(IGuiComponent inst) {
      if (inst.c5999() != null && inst.c5999() instanceof BooleanValue) {
         BooleanValue var2 = (BooleanValue) inst.c5999();
         Iterator var3 = var2.getLimits().iterator();

         while(var3.hasNext()) {
            Value var4 = (Value)var3.next();
            IGuiComponent var5 = var4.getComponent();
            if (var5 != null) {
               if (!inst.displayable()) {
                  var5.setDisplayable(false);
               } else {
                  var4.getComponent().setDisplayable(var2.getValue());
               }
            }
         }
      }

   }
}
