package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MBlockPos extends Mapping {
   public final MappingMethod c1980;
   public final MappingMethod c6770;
   public final MappingMethod c6876;
   public final MappingMethod c486;
   public final MappingMethod offset;

   public MBlockPos() {
      super(MappedClasses.BlockPos);
      this.c1980 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.Vec3d);
      this.c6770 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
      this.c6876 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, Double.TYPE, Double.TYPE, Double.TYPE);
      this.c486 = this.getMappingMethodNoRemap("down", true, MappedClasses.BlockPos);
      this.offset = this.getMappingMethodNoRemap("offset", true, MappedClasses.BlockPos, MappedClasses.EnumFacing, Integer.TYPE);
   }

   public Object offset(Object var1, Object var2, int var3) {
      return this.offset.invoke(var1, var2, var3);
   }

   public Object c6780(Object var1) {
      return this.c1980.c4955(var1);
   }

   public Object c4854(int var1, int var2, int var3) {
      return this.c6770.c4955(var1, var2, var3);
   }

   public Object c4583(double var1, double var3, double var5) {
      return this.c6876.c4955(var1, var3, var5);
   }

   public Object c8903(Object var1) {
      return this.c486.invoke(var1);
   }

}
