package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MTickEvent_Phase extends Mapping {
   public final MappingField c1407;
   public final MappingField c143;

   public MTickEvent_Phase() {
      super(MappedClasses.TickEventPhase);
      this.c1407 = this.getMappingField("START", false, this.owner);
      this.c143 = this.getMappingField("END", false, this.owner);
   }

   public Object c6031() {
      return this.c1407.getObject(null);
   }

   public Object c7468() {
      return this.c143.getObject(null);
   }

   // $FF: synthetic method
   public static Object c2308(MTickEvent_Phase var0) {
      return var0.c6031();
   }

   // $FF: synthetic method
   public static Object c8424(MTickEvent_Phase var0) {
      return var0.c7468();
   }
}
