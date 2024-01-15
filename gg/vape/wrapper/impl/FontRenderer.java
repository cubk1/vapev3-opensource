package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class FontRenderer extends Wrapper {
   public FontRenderer(Object var1) {
      super(var1);
   }

   public int drawStringWithShadow(String var1, double var2, double var4, int var6) {
      return ForgeVersion.minorVersion() > 13 ? vape.getMappings().fontRenderer.drawStringWithShadow(this.obj, var1, (float)var2, (float)var4, var6) : vape.getMappings().fontRenderer.c7312(this.obj, var1, (int)var2, (int)var4, var6);
   }


   public int drawStringWithShadow(String var1, double var2, double var4, Color var6) {
      return this.drawStringWithShadow(var1, var2, var4, var6.getRGB());
   }

   public int c8629(String var1, double var2, double var4, int var6) {
      return vape.getMappings().fontRenderer.c2145(this.obj, var1, (int)var2, (int)var4, var6);
   }

   public int c8742(String var1, double var2, double var4, Color var6) {
      return this.c8629(var1, var2, var4, var6.getRGB());
   }

   public int c3769(String var1, double var2, double var4, int var6, double var7) {
      double var9 = 1.0 / var7;
      GL11.glScaled(var7, var7, var7);
      int var11 = this.c8629(var1, var2 * var9, var4 * var9, var6);
      GL11.glScaled(var9, var9, var9);
      return var11;
   }

   public int getStringWidth(String var1) {
      return vape.getMappings().fontRenderer.c2000(this.obj, var1);
   }

   public int c3812(String var1, double var2, double var4, int var6) {
      return this.c8629(var1, (int)var2 - this.getStringWidth(var1) / 2, (int)var4, var6);
   }

   public int c6377(String var1, double var2, double var4, int var6) {
      return this.drawStringWithShadow(var1, var2 - (double)(this.getStringWidth(var1) / 2), var4, var6);
   }

   public int c3218(String var1, double var2, double var4, Color var6) {
      return this.c3812(var1, var2, var4, var6.getRGB());
   }

   public int c8646(String var1, double var2, double var4, Color var6) {
      return this.c6377(var1, var2, var4, var6.getRGB());
   }

   public int c1744() {
      return vape.getMappings().fontRenderer.c7740(this.obj);
   }

   public int c3715() {
      return this.c1744() / 2;
   }

   public ResourceLocation c956() {
      return new ResourceLocation(vape.getMappings().fontRenderer.c8903(this.obj));
   }

   public int FONT_HEIGHT(String var1) {
      return this.c1744();
   }

   public double c3988(String var1) {
      return this.c3715();
   }
}
