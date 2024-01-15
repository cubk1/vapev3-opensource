package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.wrapper.impl.ForgeVersion;

public class MMovementInput extends Mapping {
   public final MappingField moveStrafe;
   public final MappingField moveForward;
   public final MappingField c6916;
   public final MappingField c3253;
   public MappingField c2739;
   public MappingField c268;
   public MappingField c995;
   public MappingField c1625;

   public MMovementInput() {
      super("net/minecraft/util/MovementInput");
      this.c6916 = this.getMappingFieldNoRemap("jump", true, Boolean.TYPE);
      this.c3253 = this.getMappingFieldNoRemap("sneak", true, Boolean.TYPE);
      this.moveStrafe = this.getMappingFieldNoRemap("moveStrafe", true, Float.TYPE);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c2739 = this.getMappingFieldNoRemap("forwardKeyDown", true, Boolean.TYPE);
         this.c268 = this.getMappingFieldNoRemap("backKeyDown", true, Boolean.TYPE);
         this.c995 = this.getMappingFieldNoRemap("leftKeyDown", true, Boolean.TYPE);
         this.c1625 = this.getMappingFieldNoRemap("rightKeyDown", true, Boolean.TYPE);
         this.moveForward = this.getMappingFieldNoRemap("field_192832_b", false, Float.TYPE);
      } else {
         this.moveForward = this.getMappingFieldNoRemap("moveForward", true, Float.TYPE);
      }

   }

   public boolean c4246(Object var1) {
      return this.c2739.getBoolean(var1);
   }

   public void c3896(Object var1, boolean var2) {
      this.c2739.setBoolean(var1, var2);
   }

   public boolean c5419(Object var1) {
      return this.c268.getBoolean(var1);
   }

   public void c2771(Object var1, boolean var2) {
      this.c268.setBoolean(var1, var2);
   }

   public boolean c2418(Object var1) {
      return this.c995.getBoolean(var1);
   }

   public void c879(Object var1, boolean var2) {
      this.c995.setBoolean(var1, var2);
   }

   public boolean c2116(Object var1) {
      return this.c2739.getBoolean(var1);
   }

   public void c473(Object var1, boolean var2) {
      this.c1625.setBoolean(var1, var2);
   }

   public boolean c2569(Object var1) {
      return this.c6916.getBoolean(var1);
   }

   public boolean c2162(Object var1) {
      return this.c3253.getBoolean(var1);
   }

   public void c8178(Object var1, boolean var2) {
      this.c6916.setBoolean(var1, var2);
   }

   public void c3677(Object var1, boolean var2) {
      this.c3253.setBoolean(var1, var2);
   }

   public float c443(Object var1) {
      return this.moveStrafe.getFloat(var1);
   }

   public float c1721(Object var1) {
      return this.moveForward.getFloat(var1);
   }

   public void c7180(Object var1, float var2) {
      this.moveStrafe.setFloat(var1, var2);
   }

   public void c3962(Object var1, float var2) {
      this.moveForward.setFloat(var1, var2);
   }

   // $FF: synthetic method
   public static boolean c1266(MMovementInput var0, Object var1) {
      return var0.c4246(var1);
   }

   // $FF: synthetic method
   public static void c3724(MMovementInput var0, Object var1, boolean var2) {
      var0.c3896(var1, var2);
   }

   // $FF: synthetic method
   public static boolean c2398(MMovementInput var0, Object var1) {
      return var0.c5419(var1);
   }

   // $FF: synthetic method
   public static void c1064(MMovementInput var0, Object var1, boolean var2) {
      var0.c2771(var1, var2);
   }

   // $FF: synthetic method
   public static boolean c1265(MMovementInput var0, Object var1) {
      return var0.c2418(var1);
   }

   // $FF: synthetic method
   public static void c1970(MMovementInput var0, Object var1, boolean var2) {
      var0.c879(var1, var2);
   }

   // $FF: synthetic method
   public static boolean c4906(MMovementInput var0, Object var1) {
      return var0.c2116(var1);
   }

   // $FF: synthetic method
   public static void c5536(MMovementInput var0, Object var1, boolean var2) {
      var0.c473(var1, var2);
   }

   // $FF: synthetic method
   public static float c7265(MMovementInput var0, Object var1) {
      return var0.c443(var1);
   }

   // $FF: synthetic method
   public static float c7135(MMovementInput var0, Object var1) {
      return var0.c1721(var1);
   }

   // $FF: synthetic method
   public static void c6453(MMovementInput var0, Object var1, float var2) {
      var0.c7180(var1, var2);
   }

   // $FF: synthetic method
   public static void moveForward(MMovementInput var0, Object var1, float var2) {
      var0.c3962(var1, var2);
   }

   // $FF: synthetic method
   public static boolean c8303(MMovementInput var0, Object var1) {
      return var0.c2569(var1);
   }

   // $FF: synthetic method
   public static boolean c6710(MMovementInput var0, Object var1) {
      return var0.c2162(var1);
   }

   // $FF: synthetic method
   public static void c7333(MMovementInput var0, Object var1, boolean var2) {
      var0.c8178(var1, var2);
   }

   // $FF: synthetic method
   public static void c7018(MMovementInput var0, Object var1, boolean var2) {
      var0.c3677(var1, var2);
   }
}
