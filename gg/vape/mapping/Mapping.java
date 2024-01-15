package gg.vape.mapping;

import pub.nextsense.Tweaker;

public class Mapping {
   protected Class<?> owner;

   public Mapping(String var1) {
      this.owner = Tweaker.getClazz(var1);
      Mapper.mappings.add(this);
   }

   public Mapping(Class<?> owner) {
      this.owner = owner;
      Mapper.mappings.add(this);
   }

   protected MappingMethod getMappingMethodNoRemap(String name, boolean var2, Class<?> var3, Class<?>... var4) {
      return new MappingMethod(this.owner, name, var2, false, var3, var4);
   }

   protected MappingMethod getMappingMethodNoRemap(Class<?> owner, String name, boolean var3, Class<?> var4, Class<?>... var5) {
      return new MappingMethod(owner, name, var3, false, var4, var5);
   }

   protected MappingMethod getMappingMethod(String name, boolean var2, Class<?> var3, Class<?>... var4) {
      return new MappingMethod(this.owner, name, var2, true, var3, var4);
   }

   protected MappingMethod getMappingMethod(Class<?> owner, String name, boolean var3, Class<?> var4, Class<?>... var5) {
      return new MappingMethod(owner, name, var3, true, var4, var5);
   }

   protected MappingField getMappingFieldNoRemap(String var1, boolean var2, Class<?> type) {
      return new MappingField(this.owner, var1, var2, false, type);
   }

   protected MappingField getMappingFieldNoRemap(String var1, boolean var2, String var3) {
      return new MappingField(this.owner, var1, var2, false, var3);
   }

   protected MappingField getMappingField(String name, boolean isStatic, Class<?> type) {
      return new MappingField(this.owner, name, isStatic, true, type);
   }

   protected MappingField getMappingField(Class<?> owner, String name, boolean isStatic, Class<?> type) {
      return new MappingField(owner, name, isStatic, true, type);
   }

   protected MappingField getMappingField(String name, boolean isStatic, String desc) {
      return new MappingField(this.owner, name, isStatic, true, desc);
   }
}
