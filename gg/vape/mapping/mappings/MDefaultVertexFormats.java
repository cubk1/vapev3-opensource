package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MDefaultVertexFormats extends Mapping {
   public final MappingField POSITION_COLOR;
   public final MappingField POSITION;
   public MDefaultVertexFormats() {
      super(MappedClasses.DefaultVertexFormats);
      this.POSITION_COLOR = this.getMappingField("POSITION_COLOR", true, MappedClasses.VertexFormat);
      this.POSITION = this.getMappingField("POSITION", true, MappedClasses.VertexFormat);
   }

   public Object POSITION_COLOR() {
      return this.POSITION_COLOR.getObject(null);
   }
   public Object POSITION() {
      return this.POSITION.getObject(null);
   }

}
