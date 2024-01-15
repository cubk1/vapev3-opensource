package gg.vape.mapping.mappings;

import gg.vape.wrapper.impl.Entity;
import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;

import java.util.Set;

public class MWorldClient extends Mapping {
   public final MappingField c3434 = this.getMappingFieldNoRemap("entityList", true, Set.class);
   public final MappingMethod c2986;
   public final MappingMethod c4223;

   public MWorldClient() {
      super(MappedClasses.WorldClient);
      this.c2986 = this.getMappingMethodNoRemap("getEntityByID", true, MappedClasses.Entity, Integer.TYPE);
      this.c4223 = this.getMappingMethodNoRemap("addEntityToWorld", true, Void.TYPE, Integer.TYPE, MappedClasses.Entity);
   }

   public Set c1062(Object var1) {
      return (Set)this.c3434.getObject(var1);
   }

   public Object c2260(Object var1, int var2) {
      return this.c2986.invoke(var1, var2);
   }

   public void c4415(Object var1, int var2, Entity var3) {
      this.c4223.c2642(var1, var2, var3.getObject());
   }
}
