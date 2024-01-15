package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MIWorldNameable extends Mapping {
   public final MappingMethod c1184 = this.getMappingMethodNoRemap("getName", true, String.class);
   public final MappingMethod c1186;
   public final MappingMethod c7318;

   public MIWorldNameable() {
      super("net/minecraft/world/IWorldNameable");
      this.c1186 = this.getMappingMethodNoRemap("hasCustomName", true, Boolean.TYPE);
      this.c7318 = this.getMappingMethodNoRemap("getDisplayName", true, MappedClasses.ITextComponent);
   }

   public String c68(Object var1) {
      return this.c1184.invoke(var1).toString();
   }

   public boolean c5419(Object var1) {
      return this.c1186.c5509(var1);
   }

   public Object c5327(Object var1) {
      return this.c7318.invoke(var1);
   }
}
