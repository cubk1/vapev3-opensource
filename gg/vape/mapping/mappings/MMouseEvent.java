package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MMouseEvent extends Mapping {
   public final MappingField c8389;
   public final MappingField c8701;

   public MMouseEvent() {
      super(MappedClasses.MouseEvent);
      this.c8389 = this.getMappingFieldNoRemap("button", false, Integer.TYPE);
      this.c8701 = this.getMappingFieldNoRemap("buttonstate", false, Boolean.TYPE);
   }

   public void c7403(Object var1, int var2) {
      this.c8389.setInt(var1, var2);
   }

   public int c7740(Object var1) {
      return this.c8389.getInt(var1);
   }

   public void c3896(Object var1, boolean var2) {
      this.c8701.setBoolean(var1, var2);
   }

   public boolean c5419(Object var1) {
      return this.c8701.getBoolean(var1);
   }
}
