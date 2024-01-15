package gg.vape.wrapper.impl;


import gg.vape.wrapper.Wrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EffectRenderer extends Wrapper {
   public EffectRenderer(Object var1) {
      super(var1);
   }

   public List[][] c1763() {
      int var3;
      int var5;
      if (ForgeVersion.minorVersion() > 13) {
          List[][] var14 = vape.getMappings().effectRenderer.c2461(this.obj);
         ArrayList[][] var15 = new ArrayList[4][];
         var3 = 0;
         List[][] var16 = var14;
         var5 = var14.length;

         for(int var17 = 0; var17 < var5; ++var17) {
            List[] var18 = var16[var17];
            ArrayList[] var19 = new ArrayList[var18.length];

            for(int var20 = 0; var20 < var18.length; ++var20) {
               List var10 = var18[var20];
               ArrayList var11 = new ArrayList();
               Iterator var12 = var10.iterator();

               while(var12.hasNext()) {
                  Object var13 = var12.next();
                  var11.add(new EntityFX(var13));
               }

               var19[var20] = var11;
            }

            var15[var3] = var19;
            ++var3;
         }

         return var15;
      } else {
         ArrayList[][] var1 = new ArrayList[1][];
         List[] var2 = vape.getMappings().effectRenderer.c4487(this.obj);
         var3 = 0;
         ArrayList[] var4 = new ArrayList[4];

         for(var5 = 0; var5 < var2.length; ++var5) {
            List var6 = var2[var5];
            ArrayList var7 = new ArrayList();
            Iterator var8 = var6.iterator();

            while(var8.hasNext()) {
               Object var9 = var8.next();
               var7.add(new EntityFX(var9));
            }

            var4[var5] = var7;
         }

         var1[var3] = var4;
         return var1;
      }
   }
}
