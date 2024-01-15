package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MRenderManager extends Mapping {
   public final MappingField c4547;
   public final MappingField c4629;
   public final MappingField c7537;
   public final MappingField c2415;
   public final MappingField c2183;
   public final MappingField c5347;
   public final MappingField c7747;
   public final MappingField c3256;
   public final MappingMethod c1493;
   public MappingField c8504;

   public MRenderManager() {
      super("net/minecraft/client/renderer/entity/RenderManager");
      if (ForgeVersion.minorVersion() > 13) {
         this.c4547 = this.getMappingFieldNoRemap("renderPosX", true, Double.TYPE);
         this.c4629 = this.getMappingFieldNoRemap("renderPosY", true, Double.TYPE);
         this.c7537 = this.getMappingFieldNoRemap("renderPosZ", true, Double.TYPE);
      } else {
         this.c4547 = this.getMappingField("renderPosX", true, Double.TYPE);
         this.c4629 = this.getMappingField("renderPosY", true, Double.TYPE);
         this.c7537 = this.getMappingField("renderPosZ", true, Double.TYPE);
         this.c8504 = this.getMappingField("instance", true, MappedClasses.RenderManager);
      }

      this.c2415 = this.getMappingFieldNoRemap("playerViewX", true, Float.TYPE);
      this.c2183 = this.getMappingFieldNoRemap("playerViewY", true, Float.TYPE);
      this.c5347 = this.getMappingFieldNoRemap("viewerPosX", true, Double.TYPE);
      this.c7747 = this.getMappingFieldNoRemap("viewerPosY", true, Double.TYPE);
      this.c3256 = this.getMappingFieldNoRemap("viewerPosZ", true, Double.TYPE);
      this.c1493 = this.getMappingMethodNoRemap("getEntityRenderObject", true, MappedClasses.Render, MappedClasses.Entity);
   }

   public double c3661(Object var1) {
      return this.c4547.getDouble(var1);
   }

   public double c83(Object var1) {
      return this.c4629.getDouble(var1);
   }

   public double c3650(Object var1) {
      return this.c7537.getDouble(var1);
   }

   public Object c6031() {
      return this.c8504.getObject(null);
   }

   public float c735(Object var1) {
      return this.c2415.getFloat(var1);
   }

   public float c2374(Object var1) {
      return this.c2183.getFloat(var1);
   }

   public double c7233(Object var1) {
      return this.c5347.getDouble(var1);
   }

   public double c8153(Object var1) {
      return this.c7747.getDouble(var1);
   }

   public double c112(Object var1) {
      return this.c3256.getDouble(var1);
   }

   public Object c1352(Object var1, Object var2) {
      return this.c1493.invoke(var1, var2);
   }

   // $FF: synthetic method
   public static Object c6913(MRenderManager var0) {
      return var0.c6031();
   }

   // $FF: synthetic method
   public static double c4698(MRenderManager var0, Object var1) {
      return var0.c3661(var1);
   }

   // $FF: synthetic method
   public static double c4274(MRenderManager var0, Object var1) {
      return var0.c83(var1);
   }

   // $FF: synthetic method
   public static double c4871(MRenderManager var0, Object var1) {
      return var0.c3650(var1);
   }

   // $FF: synthetic method
   public static float c8190(MRenderManager var0, Object var1) {
      return var0.c735(var1);
   }

   // $FF: synthetic method
   public static float c7353(MRenderManager var0, Object var1) {
      return var0.c2374(var1);
   }

   // $FF: synthetic method
   public static double c4034(MRenderManager var0, Object var1) {
      return var0.c7233(var1);
   }

   // $FF: synthetic method
   public static double c8769(MRenderManager var0, Object var1) {
      return var0.c8153(var1);
   }

   // $FF: synthetic method
   public static double c863(MRenderManager var0, Object var1) {
      return var0.c112(var1);
   }

   // $FF: synthetic method
   public static Object c6307(MRenderManager var0, Object var1, Object var2) {
      return var0.c1352(var1, var2);
   }
}
