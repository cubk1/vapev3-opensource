package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

import java.util.UUID;

public class MAttributeModifier extends Mapping {
   public final MappingMethod getID = this.getMappingMethodNoRemap("getID", true, UUID.class);
   public final MappingMethod getAmount;

   public MAttributeModifier() {
      super(MappedClasses.AttributeModifier);
      this.getAmount = this.getMappingMethodNoRemap("getAmount", true, Double.TYPE);
   }

   public UUID getID(Object var1) {
      return (UUID)this.getID.invoke(var1);
   }

   public double getAmount(Object var1) {
      return this.getAmount.c4409(var1);
   }

   // $FF: synthetic method
   public static UUID getID(MAttributeModifier var0, Object var1) {
      return var0.getID(var1);
   }
}
