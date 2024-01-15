package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MEnchantment extends Mapping {
   public MappingField c589;
   public MappingField c3652;
   public MappingField c8907;
   public MappingField c266;
   public MappingField c984;
   public MappingField c8137;
   public MappingField c3864;
   public MappingField c2818;
   public MappingField c4189;
   public MappingField c88;
   public MappingField c6516;
   public MappingField c8398;
   public MappingField c847;
   public MappingField c781;
   public MappingField c5221;
   public MappingField c5109;
   public final MappingMethod c2044;
   public MappingMethod c5383;

   public MEnchantment() {
      super(MappedClasses.Enchantment);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c5109 = this.getMappingField("REGISTRY", true, MappedClasses.RegistryNamespaced);
         this.c5383 = this.getMappingMethod("getEnchantmentByID", true, MappedClasses.Enchantment, Integer.TYPE);
      } else {
         this.c589 = this.getMappingFieldNoRemap("effectId", true, Integer.TYPE);
         this.c5221 = this.getMappingField("enchantmentsList", true, "[Lnet/minecraft/enchantment/Enchantment;");
      }

      this.c2044 = this.getMappingMethodNoRemap("getTranslatedName", true, String.class, Integer.TYPE);
   }

   public int c7740(Object var1) {
      return this.c589.getInt(var1);
   }

   public Object[] c7079() {
      return this.c5221.getObjectArray(null);
   }

   public String c1686(Object var1, int var2) {
      return (String)this.c2044.invoke(var1, var2);
   }

   public Object c8737(int var1) {
      return this.c5383.invoke(null, var1);
   }

   public Object c7468() {
      return this.c5109.getObject(null);
   }

}