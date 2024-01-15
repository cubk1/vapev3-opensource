package gg.vape.module.none;

import gg.vape.Vape;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.impl.FrameDuelInfo;
import gg.vape.wrapper.impl.EntityJoinWorldEvent;
import gg.vape.wrapper.impl.PlaySoundAtEntityEvent;
import gg.vape.wrapper.impl.PlayerInteractEvent;

import java.util.Iterator;

public class DuelInfo extends Mod {
   public DuelInfo() {
      super("DuelInfo", 0, 0, Category.None, null);
   }

   public void c8731() {
      this.c141();
   }

   public FrameDuelInfo c5329() {
      Iterator var1 = Vape.instance.getFrameManager().getFrames().iterator();

      Frame var2;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         var2 = (Frame)var1.next();
      } while(!(var2 instanceof FrameDuelInfo));

      return (FrameDuelInfo)var2;
   }

   public void onJoinWorld(EntityJoinWorldEvent event) {
      FrameDuelInfo var2 = this.c5329();
      if (var2 != null) {
         var2.c5473(event);
      }
   }

   public void onPlaySoundAtEntity(PlaySoundAtEntityEvent event) {
      FrameDuelInfo var2 = this.c5329();
      if (var2 != null) {
         var2.c2975(event);
      }
   }

   public void onInteract(PlayerInteractEvent event) {
      FrameDuelInfo var2 = this.c5329();
      if (var2 != null) {
         var2.c8925(event);
      }
   }
}
