package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.wrapper.impl.ForgeVersion;

public class MItems extends Mapping {
   public final MappingField c8577;
   public final MappingField c4907;

   public MItems() {
      super(MappedClasses.Items);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c8577 = this.getMappingField("WOODEN_SWORD", true, MappedClasses.Item);
         this.c4907 = this.getMappingField("POTIONITEM", true, MappedClasses.ItemPotion);
      } else {
         this.c8577 = this.getMappingField("wooden_sword", true, MappedClasses.Item);
         this.c4907 = this.getMappingField("potionitem", true, MappedClasses.ItemPotion);
      }

   }

   public Object c6031() {
      return this.c8577.getObject(null);
   }

   public Object c7468() {
      return this.c4907.getObject(null);
   }

   // $FF: synthetic method
   public static Object c2336(MItems var0) {
      return var0.c6031();
   }

   // $FF: synthetic method
   public static Object c1631(MItems var0) {
      return var0.c7468();
   }
}
