package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

import java.util.List;

public class MRenderLivingBase extends Mapping {
   public MappingField c5916;
   public MappingField c6386;
   public MappingMethod c1759;
   public MappingMethod c7337;
   public MappingMethod c3500;

   public MRenderLivingBase() {
      super(MappedClasses.RenderLivingBase);
      if (ForgeVersion.minorVersion() == 13) {
         this.c5916 = this.getMappingFieldNoRemap("mainModel", true, MappedClasses.ModelBase);
      } else {
         this.c1759 = this.getMappingMethodNoRemap("getMainModel", true, MappedClasses.ModelBase);
         this.c6386 = this.getMappingFieldNoRemap("field_177097_h", false, List.class);
         this.c7337 = this.getMappingMethodNoRemap("unsetBrightness", true, Void.TYPE);
         this.c3500 = this.getMappingMethodNoRemap("setBrightness", true, Boolean.TYPE, MappedClasses.EntityLivingBase, Float.TYPE, Boolean.TYPE);
      }

   }

   public Object c6780(Object var1) {
      return this.c6386.getObject(var1);
   }

   public Object c8903(Object var1) {
      return ForgeVersion.minorVersion() == 13 ? this.c5916.getObject(var1) : this.c1759.invoke(var1);
   }

   public void c6771(Object var1, Object var2) {
      this.c6386.setObject(var1, var2);
   }

   public void c7511(Object var1) {
      this.c7337.c2642(var1);
   }


}
