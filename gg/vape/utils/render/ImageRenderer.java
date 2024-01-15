package gg.vape.utils.render;

import func.skidline.c3843;
import org.lwjgl.opengl.GL11;
import pub.nextsense.Tweaker;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;

public class ImageRenderer {
   public static int c131 = 0;
   public static HashMap c5781 = new HashMap();

   public static void drawRes(Color var0, float var1, float var2, String var3, float var4) {
      drawResWithShadow(var0, var1, var2, var3, var4, true);
   }

   public static void drawResWithShadow(Color var0, float var1, float var2, String var3, float var4, boolean var5) {
      GL11.glPushMatrix();
      boolean var6 = GL11.glIsEnabled(GL11.GL_BLEND);
      boolean var7 = GL11.glIsEnabled(GL11.GL_TEXTURE_2D);
      if (!var6) {
         GL11.glEnable(GL11.GL_BLEND);
      }

      if (!var7) {
         GL11.glEnable(GL11.GL_TEXTURE_2D);
      }

      double var8 = 1.0 / (double)var4;
      var1 = (float)((double)var1 * var8);
      var2 = (float)((double)var2 * var8);
      GL11.glScaled(var4, var4, var4);
      c3843 var10 = c4618(var3);
      if (var5) {
         RenderUtils.setColor(new Color(0, 0, 0, 150));
         c3843.c6277(var10, var1 + 1.0F, var2 + 1.0F, 32.0F, 32.0F);
      }

      RenderUtils.setColor(var0);
      c3843.c6277(var10, var1, var2, 32.0F, 32.0F);
      RenderUtils.setColor(Color.white);
      GL11.glScaled(1.0, 1.0, 1.0);
      if (!var6) {
         GL11.glDisable(GL11.GL_BLEND);
      }

      if (!var7) {
         GL11.glDisable(GL11.GL_TEXTURE_2D);
      }

      GL11.glPopMatrix();
   }

   public static c3843 c4618(String var0) {
      var0 = var0.toLowerCase();
      var0 = c5079(var0, c131);
      c3843 var1 = null;
      if (c5781.containsKey(var0)) {
         var1 = (c3843)c5781.get(var0);
      } else {
         try {
            byte[] var2 = Tweaker.getAssets(var0);
            if (var2 == null) {
               return c4618("world");
            }

            c5781.put(var0, new c3843(new ByteArrayInputStream(var2)));
            var1 = (c3843)c5781.get(var0);
         } catch (IOException var3) {
         }
      }

      return var1;
   }

   public static String c5079(String var0, int var1) {
      String var2 = "";

      for(int var3 = 0; var3 < var0.length(); ++var3) {
         char var4 = var0.charAt(var3);
         var2 = var2 + (char) (var4 ^ var1);
      }

      return var2;
   }
}
