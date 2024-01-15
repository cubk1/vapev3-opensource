package gg.vape.module.blatant;

import gg.vape.event.impl.EventPacketSend;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.Packet;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class BeanerNet extends Mod {
   public final NumberValue c3741 = NumberValue.create(this, "Delay", "#", "", 1.0, 100.0, 1000.0, 10.0);
   public final List c4434 = new CopyOnWriteArrayList();
   public final Queue c1004 = new ConcurrentLinkedQueue();

   public BeanerNet() {
      super("BeanerNet", 8919359, Category.Blatant, "Delays packets sent, simulates lag and causes high ping");
      this.addValue(this.c3741);
   }

   public void onEnable() {
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onPacketSend(EventPacketSend event) {
      if (Minecraft.thePlayer().getObject() != null && !Minecraft.thePlayer().isDead()) {
         Object var2 = event.getPacket().getObject();
         if (this.c4434.contains(var2)) {
            this.c4434.remove(var2);
         } else {
            while(true) {
               c3760 var3 = (c3760)this.c1004.peek();
               if (var3 == null || !var3.c4329(this.c3741.getValue().longValue())) {
                  this.c1004.add(new c3760(var2));
                  event.setCancelled(true);
                  return;
               }

               var3 = (c3760)this.c1004.poll();
               this.c4434.add(var3.c1065());
               Minecraft.thePlayer().sendQueue().addToSendQueue(new Packet(var3.c1065()));
            }
         }
      }
   }
}
class c3760 {
   public final Object c5120;
   public final long c2789;

   public c3760(Object var1) {
      this.c5120 = var1;
      this.c2789 = System.currentTimeMillis();
   }

   public Object c1065() {
      return this.c5120;
   }

   public boolean c4329(long var1) {
      long var3 = System.currentTimeMillis();
      return var3 - this.c2789 > var1;
   }
}
