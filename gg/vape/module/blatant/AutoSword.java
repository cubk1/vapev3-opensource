package gg.vape.module.blatant;

import gg.vape.event.impl.EventAttack;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.value.BooleanValue;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.Item;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.S09PacketHeldItemChange;

public class AutoSword extends Mod {
   public final BooleanValue c7527 = BooleanValue.create(this, "Players only", true, "Only swap when attacking players.");
   public final BooleanValue c7785 = BooleanValue.create(this, "Hand only", false, "Only swap when holding nothing.");

   public AutoSword() {
      super("AutoSword", 6485058, Category.Blatant, "Automatically equips your sword when attacking entities.");
      this.addValue(this.c7527, this.c7785);
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onAttack(EventAttack event) {
      if ((!this.c7527.getValue() || event.c7685().isInstance(MappedClasses.EntityOtherPlayerMP)) && !event.isPre() && Minecraft.currentScreen().isNull()) {
         EntityPlayerSP var2 = Minecraft.thePlayer();
         if (!this.c7785.getValue() || var2.getHeldItemHand().isNull() || var2.getHeldItemHand().getItem().isNull()) {
            for(int var3 = 36; var3 < 45; ++var3) {
               if (var2.c7368().c8687(var3).c5354()) {
                  Item var4 = var2.c7368().c8687(var3).c4981().getItem();
                  if (var4.isInstance(MappedClasses.ItemSword) && var2.c89().c1744() != var3 - 36) {
                     var2.c89().c33(var3 - 36);
                     var2.sendQueue().addToSendQueue(S09PacketHeldItemChange.c134(var3 - 36));
                     Minecraft.playerController().c7235();
                     break;
                  }
               }
            }
         }
      }

   }
}
