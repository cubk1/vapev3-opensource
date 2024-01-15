package gg.vape.wrapper.impl;

import java.util.Set;

public class WorldClient extends World {
   public WorldClient(Object var1) {
      super(var1);
   }

   public Set c4424() {
      return vape.getMappings().worldClient.c1062(this.obj);
   }

   public Entity c7325(int var1) {
      Object var2 = vape.getMappings().worldClient.c2260(this.obj, var1);
      return var2 == null ? null : new Entity(var2);
   }

   public void c1082(int var1, Entity var2) {
      vape.getMappings().worldClient.c4415(this.obj, var1, var2);
   }
}
