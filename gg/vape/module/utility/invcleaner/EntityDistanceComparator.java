package gg.vape.module.utility.invcleaner;

import gg.vape.module.render.Tracers;
import gg.vape.wrapper.impl.EntityLivingBase;
import gg.vape.wrapper.impl.EntityPlayerSP;

import java.util.Comparator;

public class EntityDistanceComparator implements Comparator {
   // $FF: synthetic field
   final EntityPlayerSP c3882;
   // $FF: synthetic field
   final Tracers c364;

   public EntityDistanceComparator(Tracers var1, EntityPlayerSP var2) {
      this.c364 = var1;
      this.c3882 = var2;
   }

   public int c7560(EntityLivingBase var1, EntityLivingBase var2) {
      double var3 = var1.getDistanceToEntity(this.c3882);
      double var5 = var2.getDistanceToEntity(this.c3882);
      if (var3 == var5) {
         return 0;
      } else {
         return var3 > var5 ? 1 : -1;
      }
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.c7560((EntityLivingBase)var1, (EntityLivingBase)var2);
   }
}
