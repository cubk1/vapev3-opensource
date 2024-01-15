package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MCPacketUseEntityOne extends Mapping {
   public final MappingMethod c210;
   public MappingField c3542;
   public MappingField c8957;

   public MCPacketUseEntityOne() {
      super(MappedClasses.CPacketUseEntity);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c210 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.Entity);
      } else {
         this.c210 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.Entity, MappedClasses.CPacketUseEntity$Action);
         this.c3542 = this.getMappingFieldNoRemap("action", true, MappedClasses.CPacketUseEntity$Action);
         this.c8957 = this.getMappingFieldNoRemap("hitVec", true, MappedClasses.Vec3d);
      }

   }

   public Object c1352(Object var1, Object var2) {
      return this.c210.c4955(var1, var2);
   }

   public Object c6780(Object var1) {
      return this.c210.c4955(var1);
   }

   public Object c8903(Object var1) {
      return this.c3542.getObject(var1);
   }

   public Object c5327(Object var1) {
      return this.c8957.getObject(var1);
   }

   public void c5700(Object var1, Object var2) {
      this.c8957.setObject(var1, var2);
   }

}
