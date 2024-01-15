package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MCPacketHeldItemChange extends Mapping {
   public final MappingMethod c1765;
   public final MappingField c6501;

   public MCPacketHeldItemChange() {
      super(MappedClasses.CPacketHeldItemChange);
      if (ForgeVersion.minorVersion() == 15) {
         this.c6501 = this.getMappingFieldNoRemap("slotId", true, Integer.TYPE);
      } else {
         this.c6501 = this.getMappingFieldNoRemap("field_149615_a", false, Integer.TYPE);
      }

      this.c1765 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, Integer.TYPE);
   }

   public Object c8737(int var1) {
      return this.c1765.c4955(var1);
   }

   public void c7403(Object var1, int var2) {
      this.c6501.setInt(var1, var2);
   }

   public int c7740(Object var1) {
      return this.c6501.getInt(var1);
   }
}
