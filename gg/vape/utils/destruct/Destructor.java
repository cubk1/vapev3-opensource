package gg.vape.utils.destruct;

import gg.vape.mapping.MappingField;
import pub.nextsense.Tweaker;

import java.security.ProtectionDomain;
import java.util.*;

public class Destructor {
   Class<?> launchClassLoader;
   Class<?> launchWrapperClass;
   MappingField classLoader;
   MappingField negativeResourceCache;
   MappingField invalidClasses;
   Set<Set<?>> classSet;
   MappingField classes;
   MappingField defaultDomain;
   MappingField packageManifests;
   MappingField loader;
   MappingField packages;
   MappingField domains;

   public void c2508() {
      this.launchWrapperClass = Tweaker.getClassInJava("Lnet/minecraft/launchwrapper/Launch;");
      this.launchClassLoader = Tweaker.getClassInJava("Lnet/minecraft/launchwrapper/LaunchClassLoader;");
      this.classLoader = new MappingField(this.launchWrapperClass, "classLoader", false, true, "Lnet/minecraft/launchwrapper/LaunchClassLoader;");
      this.negativeResourceCache = new MappingField(this.launchClassLoader, "negativeResourceCache", false, false, Set.class);
      this.classSet = new HashSet<>();
      this.classSet.addAll((Set)this.negativeResourceCache.getObject(this.classLoader.getObject(null)));
      this.invalidClasses = new MappingField(this.launchClassLoader, "invalidClasses", false, false, Set.class);
      this.classes = new MappingField(ClassLoader.class, "classes", false, false, Vector.class);
      this.defaultDomain = new MappingField(ClassLoader.class, "defaultDomain", false, false, ProtectionDomain.class);
      this.packageManifests = new MappingField(this.launchClassLoader, "packageManifests", false, false, Map.class);
      this.loader = new MappingField(Package.class, "loader", false, false, ClassLoader.class);
      this.packages = new MappingField(ClassLoader.class, "packages", false, false, HashMap.class);
      this.domains = new MappingField(ClassLoader.class, "domains", false, false, Set.class);
   }

   public void c5772() {
      Set var1 = (Set)this.invalidClasses.getObject(this.classLoader.getObject(null));
      var1.clear();
      System.gc();
   }

   public void c2098(ClassLoader var1) {
      this.defaultDomain.setObject(var1, null);
      this.c4267(Tweaker.class);
   }

   public void c4267(Class var1) {
      Package var2 = var1.getPackage();
      if (var2 != null) {
         this.loader.setObject(var2, null);
      }

   }

   public void c8530() {
      Set var1 = (Set)this.negativeResourceCache.getObject(this.classLoader.getObject(null));
      new ArrayList();
      var1.clear();
      System.gc();
   }

   public void c1398() {
   }

   public void c7650() {
   }

   public void c1695(ClassLoader var1) {
      Set var2 = (Set)this.domains.getObject(var1);
      var2.clear();
   }

   public void c8940() {
   }

   public void c6182() {
      Vector var1 = (Vector)this.classes.getObject(Destructor.class.getClassLoader());
      var1.clear();
   }
}
