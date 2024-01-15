package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.wrapper.impl.ForgeVersion;

public class MPlayerInteractEvent extends Mapping {
   public MappingField c4515;
   public MappingField c7554;
   public MappingField c5150;
   public MappingField c8697;
   public final MappingField c6479;
   public MappingField c8901;
   public MappingField c6048;

   public MPlayerInteractEvent() {
      super("net/minecraftforge/event/entity/player/PlayerInteractEvent");
      if (ForgeVersion.minorVersion() < 23) {
         this.c4515 = this.getMappingFieldNoRemap("action", false, MappedClasses.PlayerInteractEvent$Action);
      }

      if (ForgeVersion.minorVersion() == 13) {
         this.c7554 = this.getMappingFieldNoRemap("x", false, Integer.TYPE);
         this.c5150 = this.getMappingFieldNoRemap("y", false, Integer.TYPE);
         this.c8697 = this.getMappingFieldNoRemap("z", false, Integer.TYPE);
         this.c6479 = this.getMappingFieldNoRemap("face", false, Integer.TYPE);
      } else {
         this.c8901 = this.getMappingFieldNoRemap("pos", false, MappedClasses.BlockPos);
         this.c6479 = this.getMappingFieldNoRemap("face", false, MappedClasses.EnumFacing);
      }

   }

   public int c7740(Object var1) {
      return this.c7554.getInt(var1);
   }

   public int c4023(Object var1) {
      return this.c5150.getInt(var1);
   }

   public int c6882(Object var1) {
      return this.c8697.getInt(var1);
   }

   public int c2099(Object var1) {
      return this.c6479.getInt(var1);
   }

   public Object c5156(Object var1) {
      return this.c6479.getObject(var1);
   }

   public Object c6347(Object var1) {
      return this.c8901.getObject(var1);
   }

   public String c3424(Object var1) {
      Object var2 = this.c4515.getObject(var1);
      return var2 == null ? "" : var2.toString();
   }

   // $FF: synthetic method
   public static int c7739(MPlayerInteractEvent var0, Object var1) {
      return var0.c7740(var1);
   }

   // $FF: synthetic method
   public static int c2934(MPlayerInteractEvent var0, Object var1) {
      return var0.c4023(var1);
   }

   // $FF: synthetic method
   public static int c8904(MPlayerInteractEvent var0, Object var1) {
      return var0.c6882(var1);
   }

   // $FF: synthetic method
   public static int c295(MPlayerInteractEvent var0, Object var1) {
      return var0.c2099(var1);
   }

   // $FF: synthetic method
   public static Object c39(MPlayerInteractEvent var0, Object var1) {
      return var0.c6347(var1);
   }

   // $FF: synthetic method
   public static Object c1681(MPlayerInteractEvent var0, Object var1) {
      return var0.c5156(var1);
   }

   // $FF: synthetic method
   public static String c2221(MPlayerInteractEvent var0, Object var1) {
      return var0.c3424(var1);
   }
}
