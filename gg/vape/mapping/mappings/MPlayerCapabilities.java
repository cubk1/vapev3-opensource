package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MPlayerCapabilities extends Mapping {
   public final MappingField c4067;
   public final MappingField c6346;

   public MPlayerCapabilities() {
      super(MappedClasses.PlayerCapabilities);
      this.c4067 = this.getMappingFieldNoRemap("isCreativeMode", true, Boolean.TYPE);
      this.c6346 = this.getMappingFieldNoRemap("isFlying", true, Boolean.TYPE);
   }

   public boolean c4246(Object var1) {
      return this.c4067.getBoolean(var1);
   }

   public boolean c5419(Object var1) {
      return this.c6346.getBoolean(var1);
   }

   // $FF: synthetic method
   public static boolean c3695(MPlayerCapabilities var0, Object var1) {
      return var0.c4246(var1);
   }

   // $FF: synthetic method
   public static boolean c3180(MPlayerCapabilities var0, Object var1) {
      return var0.c5419(var1);
   }
}
