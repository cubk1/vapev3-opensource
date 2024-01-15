package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

import java.util.UUID;

public class MIAttributeInstance extends Mapping {
   public final MappingMethod getModifier;
   public final MappingMethod applyModifier;

   public MIAttributeInstance() {
      super(MappedClasses.IAttributeInstance);
      this.getModifier = this.getMappingMethodNoRemap("getModifier", true, MappedClasses.AttributeModifier, UUID.class);
      this.applyModifier = this.getMappingMethodNoRemap("applyModifier", true, Void.TYPE, MappedClasses.AttributeModifier);
   }

   public Object getModifier(Object var1, UUID var2) {
      return this.getModifier.invoke(var1, var2);
   }

   public void applyModifier(Object var1, Object var2) {
      this.applyModifier.c2642(var1, var2);
   }

   // $FF: synthetic method
   public static Object getModifier(MIAttributeInstance var0, Object var1, UUID var2) {
      return var0.getModifier(var1, var2);
   }

   // $FF: synthetic method
   public static void applyModifier(MIAttributeInstance var0, Object var1, Object var2) {
      var0.applyModifier(var1, var2);
   }
}
