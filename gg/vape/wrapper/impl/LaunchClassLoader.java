package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

import java.util.Map;

public class LaunchClassLoader extends Wrapper {
   public LaunchClassLoader(Object var1) {
      super(var1);
   }

   public static LaunchClassLoader getLaunchClassLoader() {
      return new LaunchClassLoader(vape.getMappings().launchClassLoader.getInstance());
   }

   public Map<String,Class<?>> cachedClasses() {
      return vape.getMappings().launchClassLoader.cachedClasses(this.obj);
   }
}
