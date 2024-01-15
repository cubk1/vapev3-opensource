package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

import java.util.UUID;

public class MGameProfile extends Mapping {
   public final MappingMethod c8708 = this.getMappingMethodNoRemap("getId", false, UUID.class);

   public MGameProfile() {
      super(MappedClasses.GameProfile);
   }

   public UUID c817(Object var1) {
      return (UUID)this.c8708.invoke(var1);
   }

   // $FF: synthetic method
   public static UUID getUUID(MGameProfile var0, Object var1) {
      return var0.c817(var1);
   }
}
