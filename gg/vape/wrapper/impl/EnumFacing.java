package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MEnumFacing;
import gg.vape.wrapper.Wrapper;

public class EnumFacing extends Wrapper {
   public EnumFacing(Object var1) {
      super(var1);
   }

   public int c1744() {
      return ForgeVersion.minorVersion() > 13 ? vape.getMappings().enumFacing.c7740(this.obj) : MEnumFacing.c1788(vape.getMappings().enumFacing, this.obj);
   }

   public EnumFacing getOpposite() {
      return ForgeVersion.minorVersion() > 13 ? new EnumFacing(vape.getMappings().enumFacing.getOpposite(this.obj)) : values()[vape.getMappings().enumFacing.order_b(this.obj)];
   }

   public Vec3i c4271() {
      return new Vec3i(vape.getMappings().enumFacing.c5327(this.obj));
   }

   public static EnumFacing[] values() {
      Object[] var0;
      if (ForgeVersion.minorVersion() > 13) {
         var0 = vape.getMappings().enumFacing.values();
      } else {
         var0 = vape.getMappings().enumFacing.c2851();
      }

      EnumFacing[] var1 = new EnumFacing[6];

      for(int var2 = 0; var2 < var0.length; ++var2) {
         var1[var2] = new EnumFacing(var0[var2]);
      }

      return var1;
   }

   public String c8945() {
      return String.valueOf(vape.getMappings().enumFacing.c8903(this.obj));
   }

   public int c7219() {
      return MEnumFacing.c3506(vape.getMappings().enumFacing, this.obj);
   }

   public int c5705() {
      return MEnumFacing.c6245(vape.getMappings().enumFacing, this.obj);
   }

   public int c7217() {
      return MEnumFacing.c7564(vape.getMappings().enumFacing, this.obj);
   }
}
