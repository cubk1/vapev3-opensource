package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MITextComponent extends Mapping {
   public final MappingMethod c6891 = this.getMappingMethodNoRemap("getFormattedText", true, String.class);
   public final MappingMethod c7044 = this.getMappingMethodNoRemap("getUnformattedText", true, String.class);

   public MITextComponent() {
      super(MappedClasses.ITextComponent);
   }

   public String c68(Object var1) {
      return (String)this.c6891.invoke(var1);
   }

   public String c4340(Object var1) {
      return (String)this.c7044.invoke(var1);
   }

   // $FF: synthetic method
   public static String c5439(MITextComponent var0, Object var1) {
      return var0.c68(var1);
   }

   // $FF: synthetic method
   public static String c8090(MITextComponent var0, Object var1) {
      return var0.c4340(var1);
   }
}
