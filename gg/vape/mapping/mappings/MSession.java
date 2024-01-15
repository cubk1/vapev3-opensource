package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MSession extends Mapping {
   public final MappingField c1596 = this.getMappingFieldNoRemap("username", true, String.class);

   public MSession() {
      super(MappedClasses.Session);
   }

   public String c68(Object var1) {
      return (String)this.c1596.getObject(var1);
   }
}
