package gg.vape.mapping.mappings;

import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MGlStateManager extends Mapping {
   public final MappingMethod bindTexture;
   public final MappingMethod disableAlpha;
   public final MappingMethod enableLighting;
   public final MappingMethod disableLighting;
   public final MappingMethod depthMask;
   public final MappingMethod disableDepth;
   public final MappingMethod enableBlend;
   public final MappingMethod tryBlendFuncSeparate;
   public final MappingMethod enableTexture2D;
   public final MappingMethod enableDepth;
   public final MappingMethod disableBlend;
   public final MappingMethod func_179131_c;
   public final MappingMethod disableTexture2D;
   public final MappingMethod enableAlpha;
   public final MappingMethod setActiveTexture;

   public MGlStateManager() {
      super("net/minecraft/client/renderer/GlStateManager");
      this.bindTexture = this.getMappingMethod("bindTexture", true, Void.TYPE, Integer.TYPE);
      this.disableAlpha = this.getMappingMethod("disableAlpha", true, Void.TYPE);
      this.enableLighting = this.getMappingMethod("enableLighting", true, Void.TYPE);
      this.disableLighting = this.getMappingMethod("disableLighting", true, Void.TYPE);
      this.depthMask = this.getMappingMethod("depthMask", true, Void.TYPE, Boolean.TYPE);
      this.disableDepth = this.getMappingMethod("disableDepth", true, Void.TYPE);
      this.enableBlend = this.getMappingMethod("enableBlend", true, Void.TYPE);
      this.tryBlendFuncSeparate = this.getMappingMethod("tryBlendFuncSeparate", true, Void.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
      this.enableTexture2D = this.getMappingMethod("enableTexture2D", true, Void.TYPE);
      this.disableTexture2D = this.getMappingMethod("disableTexture2D", true, Void.TYPE);
      this.enableDepth = this.getMappingMethod("enableDepth", true, Void.TYPE);
      this.disableBlend = this.getMappingMethod("disableBlend", true, Void.TYPE);
      this.func_179131_c = this.getMappingMethod("func_179131_c", false, Void.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
      this.enableAlpha = this.getMappingMethod("enableAlpha", true, Void.TYPE);
      this.setActiveTexture = this.getMappingMethod("setActiveTexture", true, Void.TYPE, Integer.TYPE);
   }

   public void c2327(int var1) {
      this.setActiveTexture.c2642(null, var1);
   }

   public void c8481() {
      this.enableAlpha.c2642(null);
   }

   public void c6690(int var1) {
      this.bindTexture.c2642(null, var1);
   }

   public void c7951() {
      this.disableAlpha.c2642(null);
   }

   public void c7641() {
      this.enableLighting.c2642(null);
   }

   public void c7214() {
      this.disableLighting.c2642(null);
   }

   public void c8011(boolean var1) {
      this.depthMask.c2642(null, var1);
   }

   public void c2220() {
      this.disableDepth.c2642(null);
   }

   public void c2529() {
      this.enableBlend.c2642(null);
   }

   public void c5306(int var1, int var2, int var3, int var4) {
      this.tryBlendFuncSeparate.c2642(null, var1, var2, var3, var4);
   }

   public void c8772() {
      this.enableTexture2D.c2642(null);
   }

   public void c4607() {
      this.disableTexture2D.c2642(null);
   }

   public void c6986() {
      this.enableDepth.c2642(null);
   }

   public void c531() {
      this.disableBlend.c2642(null);
   }

   public void c5055(float var1, float var2, float var3, float var4) {
      this.func_179131_c.c2642(null, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static void c5898(MGlStateManager var0, int var1) {
      var0.c6690(var1);
   }

   // $FF: synthetic method
   public static void c3726(MGlStateManager var0) {
      var0.c7951();
   }

   // $FF: synthetic method
   public static void c2548(MGlStateManager var0) {
      var0.c7641();
   }

   // $FF: synthetic method
   public static void c1564(MGlStateManager var0) {
      var0.c7214();
   }

   // $FF: synthetic method
   public static void c3620(MGlStateManager var0, boolean var1) {
      var0.c8011(var1);
   }

   // $FF: synthetic method
   public static void c7139(MGlStateManager var0) {
      var0.c6986();
   }

   // $FF: synthetic method
   public static void c4357(MGlStateManager var0) {
      var0.c2220();
   }

   // $FF: synthetic method
   public static void c8542(MGlStateManager var0) {
      var0.c2529();
   }

   // $FF: synthetic method
   public static void c7589(MGlStateManager var0) {
      var0.c531();
   }

   // $FF: synthetic method
   public static void c7089(MGlStateManager var0, int var1, int var2, int var3, int var4) {
      var0.c5306(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static void c241(MGlStateManager var0) {
      var0.c8772();
   }

   // $FF: synthetic method
   public static void c6162(MGlStateManager var0) {
      var0.c4607();
   }

   // $FF: synthetic method
   public static void c6197(MGlStateManager var0, float var1, float var2, float var3, float var4) {
      var0.c5055(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static void c2722(MGlStateManager var0) {
      var0.c8481();
   }

   // $FF: synthetic method
   public static void c5922(MGlStateManager var0, int var1) {
      var0.c2327(var1);
   }
}
