package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MMaterial extends Mapping {
   public final MappingField c4627;
   public final MappingField c8852;
   public final MappingMethod c7777;

   public MMaterial() {
      super(MappedClasses.Material);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c4627 = this.getMappingField("AIR", true, MappedClasses.Material);
         this.c8852 = this.getMappingField("WATER", true, MappedClasses.Material);
      } else {
         this.c4627 = this.getMappingField("air", true, MappedClasses.Material);
         this.c8852 = this.getMappingField("water", true, MappedClasses.Material);
      }

      this.c7777 = this.getMappingMethodNoRemap("isReplaceable", true, Boolean.TYPE);
   }

   public boolean c4246(Object var1) {
      return this.c7777.c5509(var1);
   }

   public Object c6031() {
      return this.c4627.getObject(null);
   }

   public Object c7468() {
      return this.c8852.getObject(null);
   }
}
