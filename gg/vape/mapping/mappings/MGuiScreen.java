package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MGuiScreen extends Mapping {
   public final MappingMethod c130;
   public final MappingMethod c4028;
   public final MappingMethod c1450;
   public final MappingMethod c461;
   public final MappingMethod c2872;
   public final MappingMethod c6244;
   public final MappingMethod c7185;
   public final MappingMethod c7238;
   public final MappingField c7259;
   public final MappingField c2491;

   public MGuiScreen() {
      super(MappedClasses.GuiScreen);
      this.c7259 = this.getMappingFieldNoRemap("width", true, Integer.TYPE);
      this.c2491 = this.getMappingFieldNoRemap("height", true, Integer.TYPE);
      this.c130 = this.getMappingMethodNoRemap("initGui", true, Void.TYPE);
      this.c4028 = this.getMappingMethodNoRemap("onGuiClosed", true, Void.TYPE);
      this.c1450 = this.getMappingMethodNoRemap("updateScreen", true, Void.TYPE);
      this.c461 = this.getMappingMethodNoRemap("keyTyped", true, Void.TYPE, Character.TYPE, Integer.TYPE);
      this.c2872 = this.getMappingMethodNoRemap("mouseClicked", true, Void.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
      if (ForgeVersion.minorVersion() == 13) {
         this.c6244 = this.getMappingMethodNoRemap("mouseMovedOrUp", true, Void.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
      } else {
         this.c6244 = this.getMappingMethodNoRemap("mouseReleased", true, Void.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
      }

      this.c7185 = this.getMappingMethodNoRemap("handleMouseInput", true, Void.TYPE);
      this.c7238 = this.getMappingMethodNoRemap("drawScreen", true, Void.TYPE, Integer.TYPE, Integer.TYPE, Float.TYPE);
   }

   public void c716(Object var1) {
      this.c130.c3039(var1);
   }

   public void c6265(Object var1) {
      this.c4028.c3039(var1);
   }

   public void c7511(Object var1) {
      this.c1450.c3039(var1);
   }

   public void c5485(Object var1, char var2, int var3) {
      this.c461.c3039(var1, var2, var3);
   }

   public void c2725(Object var1, int var2, int var3, int var4) {
      this.c2872.c3039(var1, var2, var3, var4);
   }

   public void c6804(Object var1, int var2, int var3, int var4) {
      this.c6244.c3039(var1, var2, var3, var4);
   }

   public void c5234(Object var1) {
      this.c7185.c3039(var1);
   }

   public void c2600(Object var1, int var2, int var3, float var4) {
      this.c7238.c3039(var1, var2, var3, var4);
   }

   public int c3817(Object var1) {
      return this.c7259.getInt(var1);
   }

   public int c2521(Object var1) {
      return this.c2491.getInt(var1);
   }

   // $FF: synthetic method
   public static int c6747(MGuiScreen var0, Object var1) {
      return var0.c3817(var1);
   }

   // $FF: synthetic method
   public static int c3642(MGuiScreen var0, Object var1) {
      return var0.c2521(var1);
   }
}
