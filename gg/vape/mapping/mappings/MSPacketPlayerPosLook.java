package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MSPacketPlayerPosLook extends Mapping {
   public final MappingField c2263;
   public final MappingField c6984;
   public final MappingField c6929;
   public final MappingField c801;
   public final MappingField c3182;

   public MSPacketPlayerPosLook() {
      super(MappedClasses.SPacketPlayerPosLook);
      this.c2263 = this.getMappingFieldNoRemap("field_148940_a", false, Double.TYPE);
      this.c6984 = this.getMappingFieldNoRemap("field_148938_b", false, Double.TYPE);
      this.c6929 = this.getMappingFieldNoRemap("field_148939_c", false, Double.TYPE);
      this.c801 = this.getMappingFieldNoRemap("field_148936_d", false, Float.TYPE);
      this.c3182 = this.getMappingFieldNoRemap("field_148937_e", false, Float.TYPE);
   }

   public float c8820(Object var1) {
      return this.c801.getFloat(var1);
   }

   public float c7751(Object var1) {
      return this.c3182.getFloat(var1);
   }

   public void c7180(Object var1, float var2) {
      this.c801.setFloat(var1, var2);
   }

   public void c3962(Object var1, float var2) {
      this.c3182.setFloat(var1, var2);
   }
}
