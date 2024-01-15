package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MWorldRenderer extends Mapping {
   public final MappingMethod begin;
   public final MappingMethod pos;
   public final MappingMethod color;
   public final MappingMethod endVertex;
   public MappingMethod c5487;
   public MappingMethod c1495;

   public MWorldRenderer() {
      super(MappedClasses.BufferBuilder);
      this.begin = this.getMappingMethodNoRemap("begin", true, Void.TYPE, Integer.TYPE, MappedClasses.VertexFormat);
      this.pos = this.getMappingMethodNoRemap("pos", true, MappedClasses.BufferBuilder, Double.TYPE, Double.TYPE, Double.TYPE);
      this.color = this.getMappingMethodNoRemap("color", true, MappedClasses.BufferBuilder, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
      this.endVertex = this.getMappingMethodNoRemap("endVertex", true, Void.TYPE);
      if (ForgeVersion.minorVersion() > 13) {
      }

   }

   public void c3188(Object var1, int var2, Object var3) {
      this.begin.c2642(var1, var2, var3);
   }

   public Object c1466(Object var1, double var2, double var4, double var6) {
      return this.pos.invoke(var1, var2, var4, var6);
   }

   public Object color(Object var1, float var2, float var3, float var4, float var5) {
      return this.color.invoke(var1, var2, var3, var4, var5);
   }

   public void c716(Object var1) {
      this.endVertex.c2642(var1);
   }

   // $FF: synthetic method
   public static void begin(MWorldRenderer var0, Object var1, int var2, Object var3) {
      var0.c3188(var1, var2, var3);
   }

   // $FF: synthetic method
   public static Object pos(MWorldRenderer var0, Object var1, double var2, double var4, double var6) {
      return var0.c1466(var1, var2, var4, var6);
   }

   // $FF: synthetic method
   public static Object color(MWorldRenderer var0, Object var1, float var2, float var3, float var4, float var5) {
      return var0.color(var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   public static void c2504(MWorldRenderer var0, Object var1) {
      var0.c716(var1);
   }
}
