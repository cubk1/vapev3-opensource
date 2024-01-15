package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.wrapper.impl.ForgeVersion;

public class MEntityViewRenderEvent extends Mapping {
   public final MappingField c7562;
   public final MappingField c4119;
   public final MappingField c7911;
   public final MappingField c887;

   public MEntityViewRenderEvent() {
      super("net/minecraftforge/client/event/EntityViewRenderEvent");
      this.c7562 = this.getMappingFieldNoRemap("renderer", false, MappedClasses.EntityRenderer);
      this.c4119 = this.getMappingFieldNoRemap("entity", false, MappedClasses.Entity);
      this.c887 = this.getMappingFieldNoRemap("renderPartialTicks", false, Double.TYPE);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c7911 = this.getMappingFieldNoRemap("state", false, MappedClasses.IBlockState);
      } else {
         this.c7911 = this.getMappingFieldNoRemap("block", false, MappedClasses.Block);
      }

   }

   public Object c6780(Object var1) {
      return this.c7562.getObject(var1);
   }

   public Object c8903(Object var1) {
      return this.c4119.getObject(var1);
   }

   public Object c5327(Object var1) {
      return this.c7911.getObject(var1);
   }

   public double c6749(Object var1) {
      return this.c887.getFloat(var1);
   }

   // $FF: synthetic method
   public static Object c4737(MEntityViewRenderEvent var0, Object var1) {
      return var0.c6780(var1);
   }

   // $FF: synthetic method
   public static Object c1002(MEntityViewRenderEvent var0, Object var1) {
      return var0.c8903(var1);
   }

   // $FF: synthetic method
   public static Object c7705(MEntityViewRenderEvent var0, Object var1) {
      return var0.c5327(var1);
   }

   // $FF: synthetic method
   public static double c7747(MEntityViewRenderEvent var0, Object var1) {
      return var0.c6749(var1);
   }
}
