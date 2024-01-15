package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.wrapper.impl.ForgeVersion;

public class MTimer extends Mapping {
   public MappingField c8002;
   public final MappingField c5420;
   public final MappingField c7426;

   public MTimer() {
      super(MappedClasses.Timer);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c7426 = this.getMappingFieldNoRemap("field_194148_c", false, Float.TYPE);
      } else {
         this.c8002 = this.getMappingFieldNoRemap("timerSpeed", true, Float.TYPE);
         this.c7426 = this.getMappingFieldNoRemap("elapsedPartialTicks", true, Float.TYPE);
      }

      this.c5420 = this.getMappingFieldNoRemap("renderPartialTicks", true, Float.TYPE);
   }

   public void c7180(Object var1, float var2) {
      this.c8002.setFloat(var1, var2);
   }

   public float c8820(Object var1) {
      return this.c5420.getFloat(var1);
   }

   public float c7751(Object var1) {
      return this.c7426.getFloat(var1);
   }

   // $FF: synthetic method
   public static void c3255(MTimer var0, Object var1, float var2) {
      var0.c7180(var1, var2);
   }

   // $FF: synthetic method
   public static float c8872(MTimer var0, Object var1) {
      return var0.c8820(var1);
   }

   // $FF: synthetic method
   public static float c750(MTimer var0, Object var1) {
      return var0.c7751(var1);
   }
}
