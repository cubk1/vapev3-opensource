package gg.vape.module.utility;

import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.none.ClientSettings;
import gg.vape.wrapper.impl.*;
import org.lwjgl.input.Mouse;

public class AutoTool extends Mod {
   public AutoTool() {
      super("AutoTool", 6485058, Category.World, "Automatically swaps your hand to the appropriate tool.");
   }

   public void c756() {
      if (!Minecraft.c1367().isNull() && Mouse.isButtonDown(0) && !Minecraft.currentScreen().isNotNull()) {
         RayTraceResult var1 = Minecraft.c1367();
         if (var1.c4157().isNull() && !var1.c213().equals(RayTraceResult_type.c3161())) {
            Block var11 = var1.c4337();
            float var12 = 1.0F;
            int var13 = -1;
            Container var14 = Minecraft.thePlayer().c7368();

            for(int var15 = 44; var15 >= 9; --var15) {
               ItemStack var16 = var14.c8687(var15).c4981();
               if (!var16.isNull()) {
                  float var8 = var16.c4126(var1.c2021(), var1.c341(), var1.c7219());
                  Item var9 = var16.getItem();
                  if (var9.isNotNull() && var9.isInstance(MappedClasses.ItemTool)) {
                     ItemTool var10 = new ItemTool(var9);
                     if (var10.c8473().equals(ToolMaterial.c8473())) {
                        var8 = 1.5F;
                     }
                  }

                  if (var8 > var12) {
                     var12 = var8;
                     var13 = var15;
                  }
               }
            }

            if (var13 >= 36 && var13 <= 44) {
               Minecraft.thePlayer().c89().c33(var13 - 36);
            }
         } else if (var1.c4157().isNotNull()) {
            float var2 = 1.0F;
            int var3 = -1;
            Container var4 = Minecraft.thePlayer().c7368();

            for(int var5 = 44; var5 >= 9; --var5) {
               ItemStack var6 = var4.c8687(var5).c4981();
               if (!var6.isNull()) {
                  float var7 = (float) ClientSettings.c7384(var6);
                  if (var7 > var2) {
                     var2 = var7;
                     var3 = var5;
                  }
               }
            }

            if (var3 >= 36 && var3 <= 44) {
               Minecraft.thePlayer().c89().c33(var3 - 36);
            }
         }

      }
   }

   public void onEnable() {
      this.c5375(50L, true);
   }
}
