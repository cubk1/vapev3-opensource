package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MRenderLivingEvent extends Mapping {
   public final MappingField c4797;
   public final MappingField c5699;
   public final MappingField c818;
   public final MappingField c8952;
   public final MappingField c916;

   public MRenderLivingEvent() {
      super("net/minecraftforge/client/event/RenderLivingEvent");
      this.c5699 = this.getMappingFieldNoRemap("renderer", false, MappedClasses.RenderLivingBase);
      this.c4797 = this.getMappingFieldNoRemap("entity", false, MappedClasses.EntityLivingBase);
      this.c818 = this.getMappingFieldNoRemap("x", false, Double.TYPE);
      this.c8952 = this.getMappingFieldNoRemap("y", false, Double.TYPE);
      this.c916 = this.getMappingFieldNoRemap("z", false, Double.TYPE);
   }

   public Object c6780(Object var1) {
      return this.c4797.getObject(var1);
   }

   public Object c8903(Object var1) {
      return this.c5699.getObject(var1);
   }

   public double c3650(Object var1) {
      return this.c818.getDouble(var1);
   }

   public double c6749(Object var1) {
      return this.c8952.getDouble(var1);
   }

   public double c5722(Object var1) {
      return this.c916.getDouble(var1);
   }

   // $FF: synthetic method
   public static Object c2872(MRenderLivingEvent var0, Object var1) {
      return var0.c6780(var1);
   }

   // $FF: synthetic method
   public static Object c2377(MRenderLivingEvent var0, Object var1) {
      return var0.c8903(var1);
   }

   // $FF: synthetic method
   public static double c3403(MRenderLivingEvent var0, Object var1) {
      return var0.c3650(var1);
   }

   // $FF: synthetic method
   public static double c2483(MRenderLivingEvent var0, Object var1) {
      return var0.c6749(var1);
   }

   // $FF: synthetic method
   public static double c5879(MRenderLivingEvent var0, Object var1) {
      return var0.c5722(var1);
   }
}
