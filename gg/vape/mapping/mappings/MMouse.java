package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import org.lwjgl.input.Mouse;

import java.nio.ByteBuffer;

public class MMouse extends Mapping {
   public final MappingField c8111 = this.getMappingField("buttons", false, ByteBuffer.class);

   public MMouse() {
      super(Mouse.class);
   }

   public ByteBuffer c6920(Object var1) {
      return (ByteBuffer)this.c8111.getObject(var1);
   }
}
