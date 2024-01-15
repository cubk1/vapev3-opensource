package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MPlayerEvent_NameFormat extends Mapping {
   public final MappingField c2729 = this.getMappingFieldNoRemap("username", false, String.class);
   public final MappingField c7176 = this.getMappingFieldNoRemap("displayname", false, String.class);

   public MPlayerEvent_NameFormat() {
      super("net/minecraftforge/event/entity/player/PlayerEvent$NameFormat");
   }

   public String c68(Object var1) {
      return this.c2729.getObject(var1).toString();
   }

   public String c4340(Object var1) {
      return this.c2729.getObject(var1).toString();
   }

   public void c2338(Object var1, String var2) {
      this.c7176.setObject(var1, var2);
   }
}
