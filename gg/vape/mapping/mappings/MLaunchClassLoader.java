package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

import java.util.Map;

public class MLaunchClassLoader extends Mapping {
   public final MappingField classLoader;
   public final MappingField cachedClasses;

   public MLaunchClassLoader() {
      super(MappedClasses.LaunchClassLoader);
      this.classLoader = this.getMappingField(MappedClasses.Launch, "classLoader", false, MappedClasses.LaunchClassLoader);
      this.cachedClasses = this.getMappingFieldNoRemap("cachedClasses", false, Map.class);
   }

   public Object getInstance() {
      return this.classLoader.getObject(null);
   }

   @SuppressWarnings("all")
   public Map<String,Class<?>> cachedClasses(Object instance) {
      return (Map<String,Class<?>>)this.cachedClasses.getObject(instance);
   }
}
