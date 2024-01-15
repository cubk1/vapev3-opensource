package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.wrapper.impl.ForgeVersion;

import java.util.List;

public class MEffectRenderer extends Mapping {
   public MappingField c8165;
   public final MappingField c4017;

   public MEffectRenderer() {
      super(MappedClasses.EffectRenderer);
      if (ForgeVersion.minorVersion() > 13) {
         this.c8165 = this.getMappingFieldNoRemap("particleEmitters", true, List.class);
         this.c4017 = this.getMappingFieldNoRemap("fxLayers", true, "[[Ljava/util/List;");
      } else {
         this.c4017 = this.getMappingFieldNoRemap("fxLayers", true, "[Ljava/util/List;");
      }

   }

   public List c7156(Object var1) {
      return (List)this.c8165.getObject(var1);
   }

   public List[][] c2461(Object var1) {
      return var1 != null && this.c4017 != null && !this.c4017.hasField() ? (List[][]) this.c4017.getObjectArray(var1) : new List[0][];
   }

   public List[] c4487(Object var1) {
      return (List[]) this.c4017.getObjectArray(var1);
   }

}
