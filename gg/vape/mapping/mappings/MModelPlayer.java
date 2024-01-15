package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MModelPlayer extends Mapping {
   public final MappingField c1276;
   public final MappingField c6135;
   public final MappingField c8925;
   public final MappingField c3408;
   public final MappingField c8055;

   public MModelPlayer() {
      super(MappedClasses.ModelPlayer);
      this.c8055 = this.getMappingFieldNoRemap("field_178730_v", false, MappedClasses.ModelRenderer);
      this.c3408 = this.getMappingFieldNoRemap("field_178732_b", false, MappedClasses.ModelRenderer);
      this.c8925 = this.getMappingFieldNoRemap("field_178734_a", false, MappedClasses.ModelRenderer);
      this.c6135 = this.getMappingFieldNoRemap("field_178731_d", false, MappedClasses.ModelRenderer);
      this.c1276 = this.getMappingFieldNoRemap("field_178733_c", false, MappedClasses.ModelRenderer);
   }

   public Object c6780(Object var1) {
      return this.c8055.getObject(var1);
   }

   public Object c8903(Object var1) {
      return this.c6135.getObject(var1);
   }

   public Object c5327(Object var1) {
      return this.c3408.getObject(var1);
   }

   public Object c5143(Object var1) {
      return this.c1276.getObject(var1);
   }

   public Object c5156(Object var1) {
      return this.c8925.getObject(var1);
   }
}
