package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MGlStateManager;
import gg.vape.wrapper.Wrapper;
import org.lwjgl.opengl.GL11;

public class GlStateManager extends Wrapper {
   public GlStateManager(Object var1) {
      super(var1);
   }

   public static void bindTexture(int var0) {
      if (ForgeVersion.minorVersion() == 13) {
         GL11.glBindTexture(3553, var0);
      } else {
         MGlStateManager.c5898(vape.getMappings().glStateManager, var0);
      }
   }

   public static void disableAlpha() {
      if (ForgeVersion.minorVersion() != 13) {
         MGlStateManager.c3726(vape.getMappings().glStateManager);
      }
   }

   public static void enableLighting() {
      if (ForgeVersion.minorVersion() == 13) {
         GL11.glEnable(2896);
      } else {
         MGlStateManager.c2548(vape.getMappings().glStateManager);
      }
   }

   public static void disableLighting() {
      if (ForgeVersion.minorVersion() == 13) {
         GL11.glDisable(2896);
      } else {
         MGlStateManager.c1564(vape.getMappings().glStateManager);
      }
   }

   public static void depthMask(boolean var0) {
      if (ForgeVersion.minorVersion() == 13) {
         GL11.glDepthMask(var0);
      } else {
         MGlStateManager.c3620(vape.getMappings().glStateManager, var0);
      }
   }

   public static void enableDepth() {
      if (ForgeVersion.minorVersion() == 13) {
         GL11.glEnable(2929);
      } else {
         MGlStateManager.c7139(vape.getMappings().glStateManager);
      }
   }

   public static void disableDepth() {
      if (ForgeVersion.minorVersion() == 13) {
         GL11.glDisable(2929);
      } else {
         MGlStateManager.c4357(vape.getMappings().glStateManager);
      }
   }

   public static void enableBlend() {
      if (ForgeVersion.minorVersion() == 13) {
         GL11.glDisable(GL11.GL_BLEND);
      } else {
         MGlStateManager.c8542(vape.getMappings().glStateManager);
      }
   }

   public static void disableBlend() {
      if (ForgeVersion.minorVersion() == 13) {
         GL11.glEnable(GL11.GL_BLEND);
      } else {
         MGlStateManager.c7589(vape.getMappings().glStateManager);
      }
   }

   public static void tryBlendFuncSeparate(int var0, int var1, int var2, int var3) {
      if (ForgeVersion.minorVersion() == 13) {
         GL11.glBlendFunc(var0, var1);
      } else {
         MGlStateManager.c7089(vape.getMappings().glStateManager, var0, var1, var2, var3);
      }
   }

   public static void enableTexture2D() {
      if (ForgeVersion.minorVersion() == 13) {
         GL11.glEnable(GL11.GL_TEXTURE_2D);
      } else {
         MGlStateManager.c241(vape.getMappings().glStateManager);
      }
   }

   public static void disableTexture2D() {
      if (ForgeVersion.minorVersion() == 13) {
         GL11.glDisable(GL11.GL_TEXTURE_2D);
      } else {
         MGlStateManager.c6162(vape.getMappings().glStateManager);
      }
   }

   public static void func_179131_c(float var0, float var1, float var2, float var3) {
      if (ForgeVersion.minorVersion() == 13) {
         GL11.glColor4f(var0, var1, var2, var3);
      } else {
         MGlStateManager.c6197(vape.getMappings().glStateManager, var0, var1, var2, var3);
      }
   }

   public static void enableAlpha() {
      if (ForgeVersion.minorVersion() == 13) {
         GL11.glDisable(3008);
      } else {
         MGlStateManager.c2722(vape.getMappings().glStateManager);
      }
   }

   public static void setActiveTexture(int var0) {
      if (ForgeVersion.minorVersion() != 13) {
         MGlStateManager.c5922(vape.getMappings().glStateManager, var0);
      }
   }
}
