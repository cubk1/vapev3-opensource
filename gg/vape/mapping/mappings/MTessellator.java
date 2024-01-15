package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MTessellator extends Mapping {
   public final MappingField c661;
   public MappingField c6515;
   public final MappingMethod draw;
   public MappingMethod c6875;
   public MappingMethod c7377;
   public MappingMethod c3968;
   public MappingMethod c1355;

   public MTessellator() {
      super(MappedClasses.Tessellator);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c661 = this.getMappingField("INSTANCE", true, MappedClasses.Tessellator);
      } else {
         this.c661 = this.getMappingField("instance", true, MappedClasses.Tessellator);
      }

      if (ForgeVersion.minorVersion() > 13) {
         this.c6515 = this.getMappingFieldNoRemap("worldRenderer", true, MappedClasses.BufferBuilder);
         this.draw = this.getMappingMethodNoRemap("draw", true, Void.TYPE);
      } else {
         this.c6875 = this.getMappingMethodNoRemap("startDrawingQuads", true, Void.TYPE);
         this.c7377 = this.getMappingMethodNoRemap("addVertex", true, Void.TYPE, Double.TYPE, Double.TYPE, Double.TYPE);
         this.draw = this.getMappingMethodNoRemap("draw", true, Integer.TYPE);
         this.c3968 = this.getMappingMethodNoRemap("startDrawing", true, Void.TYPE, Integer.TYPE);
         this.c1355 = this.getMappingMethodNoRemap("addVertexWithUV", true, Void.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE);
      }

   }

   public Object c6031() {
      return this.c661.getObject(null);
   }

   public Object c6780(Object var1) {
      return this.c6515.getObject(var1);
   }

   public void c6265(Object var1) {
      this.draw.c2642(var1);
   }

   public void c7511(Object var1) {
      this.c6875.c2642(var1);
   }

   public void c737(Object var1, double var2, double var4, double var6) {
      this.c7377.c2642(var1, var2, var4, var6);
   }

   public void c7929(Object var1, double var2, double var4, double var6, double var8, double var10) {
      this.c1355.c2642(var1, var2, var4, var6, var8, var10);
   }

   public void c7403(Object var1, int var2) {
      this.c3968.c2642(var1, var2);
   }

   // $FF: synthetic method
   public static Object c1005(MTessellator var0) {
      return var0.c6031();
   }

   // $FF: synthetic method
   public static Object c7502(MTessellator var0, Object var1) {
      return var0.c6780(var1);
   }

   // $FF: synthetic method
   public static void draw(MTessellator var0, Object var1) {
      var0.c6265(var1);
   }

   // $FF: synthetic method
   public static void c7145(MTessellator var0, Object var1) {
      var0.c7511(var1);
   }

   // $FF: synthetic method
   public static void c6941(MTessellator var0, Object var1, double var2, double var4, double var6) {
      var0.c737(var1, var2, var4, var6);
   }

   // $FF: synthetic method
   public static void c1889(MTessellator var0, Object var1, int var2) {
      var0.c7403(var1, var2);
   }

   // $FF: synthetic method
   public static void c3716(MTessellator var0, Object var1, double var2, double var4, double var6, double var8, double var10) {
      var0.c7929(var1, var2, var4, var6, var8, var10);
   }
}
