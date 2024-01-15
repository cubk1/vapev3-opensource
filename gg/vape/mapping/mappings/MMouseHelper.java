package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MMouseHelper extends Mapping {
   public final MappingField c4462;
   public final MappingField c7781;

   public MMouseHelper() {
      super(MappedClasses.MouseHelper);
      this.c4462 = this.getMappingFieldNoRemap("deltaX", true, Integer.TYPE);
      this.c7781 = this.getMappingFieldNoRemap("deltaY", true, Integer.TYPE);
   }

   public int c7740(Object var1) {
      return this.c4462.getInt(var1);
   }

   public int c4023(Object var1) {
      return this.c7781.getInt(var1);
   }

   // $FF: synthetic method
   public static int c2247(MMouseHelper var0, Object var1) {
      return var0.c7740(var1);
   }

   // $FF: synthetic method
   public static int c4851(MMouseHelper var0, Object var1) {
      return var0.c4023(var1);
   }
}
