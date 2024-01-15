package gg.vape.mapping.mappings;

import gg.vape.asm.helper.DescUtils;
import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;
import net.minecraft.util.EnumFacing;

public class MEnumFacing extends Mapping {
   public MappingField c2869;
   public MappingField order_b;
   public MappingField c8340;
   public MappingField c5560;
   public MappingField c4172;
   public MappingField c6676;
   public MappingMethod getOpposite;
   public MappingMethod c2394;
   public MappingMethod values;
   public MappingMethod c5864;
   public MappingMethod c6038;

   public MEnumFacing() {
      super("net/minecraft/util/EnumFacing");
      if (ForgeVersion.minorVersion() > 13) {
         this.values = this.getMappingMethod("values", false, DescUtils.getArrayType(MappedClasses.EnumFacing));
         this.getOpposite = this.getMappingMethodNoRemap("getOpposite", true, MappedClasses.EnumFacing);
         this.c6038 = this.getMappingMethodNoRemap("ordinal", false, Integer.TYPE);
         this.c2394 = this.getMappingMethodNoRemap("getDirectionVec", true, MappedClasses.Vec3i);
      } else {
         this.c2869 = this.getMappingField("faceList", true, "[Lnet/minecraft/util/EnumFacing;");
         this.order_b = this.getMappingFieldNoRemap("order_b", true, Integer.TYPE);
         this.c8340 = this.getMappingFieldNoRemap("order_a", true, Integer.TYPE);
         this.c5560 = this.getMappingFieldNoRemap("frontOffsetX", true, Integer.TYPE);
         this.c4172 = this.getMappingFieldNoRemap("frontOffsetY", true, Integer.TYPE);
         this.c6676 = this.getMappingFieldNoRemap("frontOffsetZ", true, Integer.TYPE);
      }

   }

   public int c7740(Object var1) {
      return this.c6038.c2555(var1);
   }

   public Object c8903(Object var1) {
      return this.c5864.invoke(var1);
   }

   public Object[] values() {
      if(true){
         return EnumFacing.values();
      }
      return this.values.invokeObjectArray(null);
   }

   public Object[] c2851() {
      return this.c2869.getObjectArray(null);
   }

   public Object c5327(Object var1) {
      return this.c2394.invoke(var1);
   }

   public Object getOpposite(Object var1) {
      System.out.println(getOpposite == null);
      return this.getOpposite.invoke(var1);
   }

   public int order_b(Object var1) {
      return this.order_b.getInt(var1);
   }

   public int c2521(Object var1) {
      return this.c8340.getInt(var1);
   }

   public int c4526(Object var1) {
      return this.c5560.getInt(var1);
   }

   public int c5581(Object var1) {
      return this.c4172.getInt(var1);
   }

   public int c3984(Object var1) {
      return this.c6676.getInt(var1);
   }

   // $FF: synthetic method
   public static int c1788(MEnumFacing var0, Object var1) {
      return var0.c2521(var1);
   }

   // $FF: synthetic method

   // $FF: synthetic method
   public static int c3506(MEnumFacing var0, Object var1) {
      return var0.c4526(var1);
   }

   // $FF: synthetic method
   public static int c6245(MEnumFacing var0, Object var1) {
      return var0.c5581(var1);
   }

   // $FF: synthetic method
   public static int c7564(MEnumFacing var0, Object var1) {
      return var0.c3984(var1);
   }
}
