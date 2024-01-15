package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;
//todo #1
public class MEntityOtherPlayerMP extends Mapping {
   public final MappingMethod c2007;

   public MEntityOtherPlayerMP() {
      super(MappedClasses.EntityOtherPlayerMP);
      this.c2007 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.World, MappedClasses.GameProfile);
   }

   public Object c1352(Object var1, Object var2) {
      return this.c2007.c4955(var1, var2);
   }
}
