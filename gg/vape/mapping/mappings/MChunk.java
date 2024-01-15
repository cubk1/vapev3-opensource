package gg.vape.mapping.mappings;

import com.google.common.base.Predicate;
import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

import java.util.List;

public class MChunk extends Mapping {
   public final MappingMethod c2645;

   public MChunk() {
      super("net/minecraft/world/chunk/Chunk");
      if (ForgeVersion.minorVersion() == 13) {
         this.c2645 = this.getMappingMethodNoRemap("getEntitiesWithinAABBForEntity", true, Void.TYPE, MappedClasses.Entity, MappedClasses.AxisAlignedBB, List.class, MappedClasses.IEntitySelector);
      } else {
         this.c2645 = this.getMappingMethodNoRemap("getEntitiesWithinAABBForEntity", true, Void.TYPE, MappedClasses.Entity, MappedClasses.AxisAlignedBB, List.class, Predicate.class);
      }

   }

   public void c2280(Object var1, Object var2, Object var3, List var4, Object var5) {
      this.c2645.c2642(var1, var2, var3, var4, var5);
   }
}
