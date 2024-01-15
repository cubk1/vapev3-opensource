package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.wrapper.impl.ForgeVersion;

public class MGameSettings extends Mapping {
   public final MappingField c6654;
   public final MappingField c7700;
   public final MappingField c7620;
   public final MappingField c5743;
   public final MappingField c1480;
   public final MappingField c8550;
   public final MappingField c5414;
   public final MappingField c3599;
   public final MappingField c7759;
   public final MappingField c5225;
   public final MappingField c4595;
   public final MappingField c3201;
   public final MappingField c4159;
   public final MappingField c2427;
   public final MappingField c7000;
   public final MappingField c2681;
   public final MappingField c4983;
   public final MappingField c5971;
   public final MappingField c4569;
   public final MappingField c5293;
   public final MappingField c719;

   public MGameSettings() {
      super(MappedClasses.GameSettings);
      this.c6654 = this.getMappingFieldNoRemap("keyBindAttack", true, MappedClasses.KeyBinding);
      this.c7700 = this.getMappingFieldNoRemap("keyBindUseItem", true, MappedClasses.KeyBinding);
      this.c7620 = this.getMappingFieldNoRemap("guiScale", true, Integer.TYPE);
      this.c5743 = this.getMappingFieldNoRemap("keyBindInventory", true, MappedClasses.KeyBinding);
      this.c1480 = this.getMappingFieldNoRemap("viewBobbing", true, Boolean.TYPE);
      this.c4569 = this.getMappingFieldNoRemap("ofFastRender", false, Boolean.TYPE);
      this.c4159 = this.getMappingFieldNoRemap("gammaSetting", true, Float.TYPE);
      this.c719 = this.getMappingFieldNoRemap("ofAaLevel", true, Integer.TYPE);
      this.c5971 = this.getMappingFieldNoRemap("fboEnable", true, Boolean.TYPE);
      this.c8550 = this.getMappingFieldNoRemap("keyBindForward", true, MappedClasses.KeyBinding);
      this.c5414 = this.getMappingFieldNoRemap("keyBindBack", true, MappedClasses.KeyBinding);
      this.c3599 = this.getMappingFieldNoRemap("keyBindLeft", true, MappedClasses.KeyBinding);
      this.c7759 = this.getMappingFieldNoRemap("keyBindRight", true, MappedClasses.KeyBinding);
      this.c5225 = this.getMappingFieldNoRemap("keyBindJump", true, MappedClasses.KeyBinding);
      this.c4595 = this.getMappingFieldNoRemap("keyBindSneak", true, MappedClasses.KeyBinding);
      this.c2427 = this.getMappingFieldNoRemap("keyBindSprint", true, MappedClasses.KeyBinding);
      this.c7000 = this.getMappingFieldNoRemap("keyBindDrop", true, MappedClasses.KeyBinding);
      this.c4983 = this.getMappingFieldNoRemap("hideGUI", true, Boolean.TYPE);
      this.c5293 = this.getMappingFieldNoRemap("thirdPersonView", true, Integer.TYPE);
      this.c2681 = this.getMappingFieldNoRemap("mouseSensitivity", true, Float.TYPE);
      if (ForgeVersion.minorVersion() > 13) {
         this.c3201 = this.getMappingFieldNoRemap("clouds", true, Integer.TYPE);
      } else {
         this.c3201 = this.getMappingFieldNoRemap("clouds", true, Boolean.TYPE);
      }

   }

   public Object c6780(Object var1) {
      return this.c6654.getObject(var1);
   }

   public Object c8903(Object var1) {
      return this.c7700.getObject(var1);
   }

   public Object c5327(Object var1) {
      return this.c8550.getObject(var1);
   }

   public Object c5143(Object var1) {
      return this.c5414.getObject(var1);
   }

   public Object c5156(Object var1) {
      return this.c3599.getObject(var1);
   }

   public Object c6347(Object var1) {
      return this.c7759.getObject(var1);
   }

   public Object c6946(Object var1) {
      return this.c5225.getObject(var1);
   }

   public Object c3024(Object var1) {
      return this.c4595.getObject(var1);
   }

   public Object c984(Object var1) {
      return this.c2427.getObject(var1);
   }

   public Object c2141(Object var1) {
      return this.c7000.getObject(var1);
   }

   public int c6192(Object var1) {
      return this.c7620.getInt(var1);
   }

   public void c7403(Object var1, int var2) {
      this.c7620.setInt(var1, var2);
   }

   public Object c2100(Object var1) {
      return this.c5743.getObject(var1);
   }

   public boolean c4402(Object var1) {
      return this.c1480.getBoolean(var1);
   }

   public void c3896(Object var1, boolean var2) {
      this.c1480.setBoolean(var1, var2);
   }

   public boolean c7358(Object var1) {
      return !this.c4569.hasField() && this.c4569.getBoolean(var1);
   }

   public void c2771(Object var1, boolean var2) {
      if (!this.c4569.hasField()) {
         this.c4569.setBoolean(var1, var2);
      }
   }

   public int c1094(Object var1) {
      return this.c719.hasField() ? 0 : this.c719.getInt(var1);
   }

   public void c879(Object var1, boolean var2) {
      this.c3201.setBoolean(var1, var2);
   }

   public boolean c7071(Object var1) {
      return this.c3201.getBoolean(var1);
   }

   public void c2803(Object var1, int var2) {
      this.c3201.setInt(var1, var2);
   }

   public int c7832(Object var1) {
      return this.c3201.getInt(var1);
   }

   public float c2612(Object var1) {
      return this.c4159.getFloat(var1);
   }

   public void c7180(Object var1, float var2) {
      this.c4159.setFloat(var1, var2);
   }

   public boolean c5657(Object var1) {
      return this.c4983.getBoolean(var1);
   }

   public void c473(Object var1, boolean var2) {
      this.c4983.setBoolean(var1, var2);
   }

   public int c1823(Object var1) {
      return this.c5293.getInt(var1);
   }

   public void c2185(Object var1, int var2) {
      this.c5293.setInt(var1, var2);
   }

   public float c6379(Object var1) {
      return this.c2681.getFloat(var1);
   }

   public boolean c8402(Object var1) {
      return this.c5971.getBoolean(var1);
   }

   // $FF: synthetic method
   public static Object c8188(MGameSettings var0, Object var1) {
      return var0.c6780(var1);
   }

   // $FF: synthetic method
   public static Object c8804(MGameSettings var0, Object var1) {
      return var0.c8903(var1);
   }

   // $FF: synthetic method
   public static Object c937(MGameSettings var0, Object var1) {
      return var0.c2100(var1);
   }

   // $FF: synthetic method
   public static Object c7753(MGameSettings var0, Object var1) {
      return var0.c5327(var1);
   }

   // $FF: synthetic method
   public static Object c6366(MGameSettings var0, Object var1) {
      return var0.c5143(var1);
   }

   // $FF: synthetic method
   public static Object c748(MGameSettings var0, Object var1) {
      return var0.c5156(var1);
   }

   // $FF: synthetic method
   public static Object c933(MGameSettings var0, Object var1) {
      return var0.c6347(var1);
   }

   // $FF: synthetic method
   public static Object c3570(MGameSettings var0, Object var1) {
      return var0.c6946(var1);
   }

   // $FF: synthetic method
   public static Object c2379(MGameSettings var0, Object var1) {
      return var0.c3024(var1);
   }

   // $FF: synthetic method
   public static int c5431(MGameSettings var0, Object var1) {
      return var0.c6192(var1);
   }

   // $FF: synthetic method
   public static boolean c4477(MGameSettings var0, Object var1) {
      return var0.c4402(var1);
   }

   // $FF: synthetic method
   public static void c2246(MGameSettings var0, Object var1, boolean var2) {
      var0.c3896(var1, var2);
   }

   // $FF: synthetic method
   public static boolean c2701(MGameSettings var0, Object var1) {
      return var0.c7358(var1);
   }

   // $FF: synthetic method
   public static void c7958(MGameSettings var0, Object var1, boolean var2) {
      var0.c2771(var1, var2);
   }

   // $FF: synthetic method
   public static int c4982(MGameSettings var0, Object var1) {
      return var0.c7832(var1);
   }

   // $FF: synthetic method
   public static boolean c4558(MGameSettings var0, Object var1) {
      return var0.c7071(var1);
   }

   // $FF: synthetic method
   public static void c4262(MGameSettings var0, Object var1, int var2) {
      var0.c2803(var1, var2);
   }

   // $FF: synthetic method
   public static void c1946(MGameSettings var0, Object var1, boolean var2) {
      var0.c879(var1, var2);
   }

   // $FF: synthetic method
   public static float c1924(MGameSettings var0, Object var1) {
      return var0.c2612(var1);
   }

   // $FF: synthetic method
   public static void c5181(MGameSettings var0, Object var1, float var2) {
      var0.c7180(var1, var2);
   }

   // $FF: synthetic method
   public static Object c7759(MGameSettings var0, Object var1) {
      return var0.c984(var1);
   }

   // $FF: synthetic method
   public static Object c6160(MGameSettings var0, Object var1) {
      return var0.c2141(var1);
   }

   // $FF: synthetic method
   public static void c7657(MGameSettings var0, Object var1, int var2) {
      var0.c7403(var1, var2);
   }

   // $FF: synthetic method
   public static boolean c2174(MGameSettings var0, Object var1) {
      return var0.c5657(var1);
   }

   // $FF: synthetic method
   public static void c254(MGameSettings var0, Object var1, boolean var2) {
      var0.c473(var1, var2);
   }

   // $FF: synthetic method
   public static int c6188(MGameSettings var0, Object var1) {
      return var0.c1823(var1);
   }

   // $FF: synthetic method
   public static void c3364(MGameSettings var0, Object var1, int var2) {
      var0.c2185(var1, var2);
   }

   // $FF: synthetic method
   public static float c6317(MGameSettings var0, Object var1) {
      return var0.c6379(var1);
   }

   // $FF: synthetic method
   public static int c2686(MGameSettings var0, Object var1) {
      return var0.c1094(var1);
   }

   // $FF: synthetic method
   public static boolean c1498(MGameSettings var0, Object var1) {
      return var0.c8402(var1);
   }
}
