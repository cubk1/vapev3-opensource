package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MModelBiped extends Mapping {
   public final MappingField c1242;
   public final MappingField c1273;
   public final MappingField c3665;
   public final MappingField c1530;
   public final MappingField c4684;
   public final MappingField c2281;

   public MModelBiped() {
      super("net/minecraft/client/model/ModelBiped");
      this.c1242 = this.getMappingFieldNoRemap("bipedHead", true, MappedClasses.ModelRenderer);
      this.c1273 = this.getMappingFieldNoRemap("bipedHeadwear", true, MappedClasses.ModelRenderer);
      this.c3665 = this.getMappingFieldNoRemap("bipedRightArm", true, MappedClasses.ModelRenderer);
      this.c1530 = this.getMappingFieldNoRemap("bipedLeftArm", true, MappedClasses.ModelRenderer);
      this.c4684 = this.getMappingFieldNoRemap("bipedRightLeg", true, MappedClasses.ModelRenderer);
      this.c2281 = this.getMappingFieldNoRemap("bipedLeftLeg", true, MappedClasses.ModelRenderer);
   }

   public Object c6780(Object var1) {
      return this.c1242.getObject(var1);
   }

   public Object c8903(Object var1) {
      return this.c1273.getObject(var1);
   }

   public Object c5327(Object var1) {
      return this.c3665.getObject(var1);
   }

   public Object c5143(Object var1) {
      return this.c1530.getObject(var1);
   }

   public Object c5156(Object var1) {
      return this.c4684.getObject(var1);
   }

   public Object c6347(Object var1) {
      return this.c2281.getObject(var1);
   }

   // $FF: synthetic method
   public static Object c91(MModelBiped var0, Object var1) {
      return var0.c6780(var1);
   }

   // $FF: synthetic method
   public static Object c8864(MModelBiped var0, Object var1) {
      return var0.c8903(var1);
   }

   // $FF: synthetic method
   public static Object c4380(MModelBiped var0, Object var1) {
      return var0.c5327(var1);
   }

   // $FF: synthetic method
   public static Object c4097(MModelBiped var0, Object var1) {
      return var0.c5143(var1);
   }

   // $FF: synthetic method
   public static Object c1508(MModelBiped var0, Object var1) {
      return var0.c5156(var1);
   }

   // $FF: synthetic method
   public static Object c3112(MModelBiped var0, Object var1) {
      return var0.c6347(var1);
   }
}
