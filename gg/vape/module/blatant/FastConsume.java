package gg.vape.module.blatant;

import gg.vape.event.impl.EventPlayerTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.value.BooleanValue;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.C03PacketPlayer;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.Item;
import gg.vape.wrapper.impl.Minecraft;

public class FastConsume extends Mod {
   public final BooleanValue fastBow = BooleanValue.create(this, "Fast Bow", false, "Makes you shoot your bow faster.");
   public final NumberValue ticks = NumberValue.create(this, "Ticks", "#", "", 1.0, 14.0, 20.0, 1.0, "The amount of ticks you have to use an item to consume.");

   public FastConsume() {
      super("FastConsume", -256, Category.Blatant, "Use/Consume items quicker.");
      this.addValue(this.ticks, this.fastBow);
   }

   public void onTick(EventPlayerTick event) {
      EntityPlayerSP player = Minecraft.thePlayer();
      if ((double)player.getItemInUseMaxCount() == this.ticks.getValue() && this.limit(player.getHeldItemHand().getItem())) {
         for(int i = 0; i < 30; ++i) {
            player.sendQueue().addToSendQueue(C03PacketPlayer.newInstance(true));
         }

         Minecraft.playerController().onStoppedUsingItem(player);
      }

   }

   public boolean limit(Item item) {
      return !item.isInstance(MappedClasses.ItemSword) && (this.fastBow.getValue() || !item.isInstance(MappedClasses.ItemBow));
   }
}
