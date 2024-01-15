package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MModelBase extends Mapping {
   public final MappingMethod c3919;
   public final MappingMethod c2765;
   public final MappingMethod c8589;

   public MModelBase() {
      super(MappedClasses.ModelBase);
      this.c2765 = this.getMappingMethodNoRemap("setLivingAnimations", true, Void.TYPE, MappedClasses.EntityLivingBase, Float.TYPE, Float.TYPE, Float.TYPE);
      this.c3919 = this.getMappingMethodNoRemap("setRotationAngles", true, Void.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, MappedClasses.Entity);
      this.c8589 = this.getMappingMethodNoRemap("render", true, Void.TYPE, MappedClasses.Entity, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
   }

   public void c6153(Object var1, Object var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.c8589.c2642(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void c1618(Object var1, Object var2, float var3, float var4, float var5) {
      this.c2765.c2642(var1, var2, var3, var4, var5);
   }

   public void c3152(Object var1, float var2, float var3, float var4, float var5, float var6, float var7, Object var8) {
      this.c3919.c2642(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   // $FF: synthetic method
   public static void c3265(MModelBase var0, Object var1, Object var2, float var3, float var4, float var5) {
      var0.c1618(var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   public static void c5461(MModelBase var0, Object var1, float var2, float var3, float var4, float var5, float var6, float var7, Object var8) {
      var0.c3152(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   // $FF: synthetic method
   public static void c5067(MModelBase var0, Object var1, Object var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      var0.c6153(var1, var2, var3, var4, var5, var6, var7, var8);
   }
}
