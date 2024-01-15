package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

import java.util.List;

public class MItemPotion extends Mapping {
   public final MappingMethod c4030;
   public final MappingMethod c4103;

   public MItemPotion() {
      super(MappedClasses.ItemPotion);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c4030 = this.getMappingMethod(MappedClasses.PotionUtils, "getEffectsFromStack", true, List.class, MappedClasses.ItemStack);
      } else {
         this.c4030 = this.getMappingMethodNoRemap("getEffects", true, List.class, MappedClasses.ItemStack);
      }

      this.c4103 = this.getMappingMethodNoRemap("getItemStackDisplayName", true, String.class, MappedClasses.ItemStack);
   }

   public List c640(Object var1, Object var2) {
      return (List)this.c4030.invoke(var1, var2);
   }

   public String c7849(Object var1, Object var2) {
      return (String)this.c4103.invoke(var1, var2);
   }

   // $FF: synthetic method
   public static List c3808(MItemPotion var0, Object var1, Object var2) {
      return var0.c640(var1, var2);
   }

   // $FF: synthetic method
   public static String c2012(MItemPotion var0, Object var1, Object var2) {
      return var0.c7849(var1, var2);
   }
}
