package gg.vape.wrapper.impl;

import gg.vape.mapping.MappingField;
import gg.vape.wrapper.Wrapper;
import pub.nextsense.Tweaker;

import java.lang.reflect.Field;

public class ForgeVersion extends Wrapper {
   public static MappingField c2027;
   public static int c2533 = 0;

   public ForgeVersion() {
      super(null);
   }

   public static int minorVersion() {
      try {
         Class var1 = Tweaker.getClazz("net/minecraftforge/common/ForgeVersion");
         Field var2 = var1.getDeclaredField("minorVersion");
         var2.setAccessible(true);
         int var0 = (Integer)var2.get(null);
         return var0;
      } catch (Exception var3) {
         var3.printStackTrace();
         return c2533 != 0 ? c2533 : (c2533 = c2027.getInt(null));
      }
   }

   static {
      try {
         c2027 = new MappingField(Tweaker.getClazz("net/minecraftforge/common/ForgeVersion"), "minorVersion", false, true, Integer.TYPE);
      } catch (Exception var1) {
         var1.printStackTrace();
      }

   }
}
