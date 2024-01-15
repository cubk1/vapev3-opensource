package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MRegistrySimple;
import gg.vape.wrapper.Wrapper;

import java.util.Set;

public class RegistrySimple extends Wrapper {
   public RegistrySimple(Object var1) {
      super(var1);
   }

   public Set c4424() {
      return vape.getMappings().registrySimple.c1062(this.obj);
   }

   public Object c1233(Object var1) {
      return MRegistrySimple.c5183(vape.getMappings().registrySimple, this.obj, var1);
   }
}
