package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MVec3d extends Mapping {
   public final MappingMethod c7591;
   public final MappingMethod c546;
   public final MappingMethod c4339;
   public final MappingMethod squareDistanceTo;
   public final MappingField c5592;
   public final MappingField c3195;
   public final MappingField c4591;

   public MVec3d() {
      super(MappedClasses.Vec3d);
      this.c5592 = this.getMappingFieldNoRemap("xCoord", true, Double.TYPE);
      this.c3195 = this.getMappingFieldNoRemap("yCoord", true, Double.TYPE);
      this.c4591 = this.getMappingFieldNoRemap("zCoord", true, Double.TYPE);
      this.c546 = this.getMappingMethodNoRemap("addVector", true, MappedClasses.Vec3d, Double.TYPE, Double.TYPE, Double.TYPE);
      this.c4339 = this.getMappingMethodNoRemap("distanceTo", true, Double.TYPE, MappedClasses.Vec3d);
      if (ForgeVersion.minorVersion() >= 23) {
         this.squareDistanceTo = this.getMappingMethodNoRemap("func_72436_e", false, Double.TYPE, MappedClasses.Vec3d);
      } else {
         this.squareDistanceTo = this.getMappingMethodNoRemap("squareDistanceTo", true, Double.TYPE, MappedClasses.Vec3d);
      }

      this.c7591 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, Double.TYPE, Double.TYPE, Double.TYPE);
   }

   public Object c1466(Object var1, double var2, double var4, double var6) {
      return this.c546.invoke(var1, var2, var4, var6);
   }

   public double squareDistanceTo(Object var1, Object var2) {
      return this.squareDistanceTo.c4409(var1, var2);
   }

   public double c3661(Object var1) {
      return this.c5592.getDouble(var1);
   }

   public double c83(Object var1) {
      return this.c3195.getDouble(var1);
   }

   public double c3650(Object var1) {
      return this.c4591.getDouble(var1);
   }

   public double c3970(Object var1, Object var2) {
      return this.c4339.c4409(var1, var2);
   }

   public Object c4583(double var1, double var3, double var5) {
      return this.c7591.c4955(var1, var3, var5);
   }
}
