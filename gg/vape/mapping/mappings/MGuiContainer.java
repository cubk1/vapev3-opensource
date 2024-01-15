package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

import java.util.Set;

public class MGuiContainer extends Mapping {
   public final MappingField c6777;
   public final MappingField c5622;
   public final MappingField c3880;
   public final MappingField c3285;
   public final MappingField c5562;
   public final MappingField c6306;
   public final MappingField c8851;
   public final MappingField c1910;
   public final MappingField c7952;
   public final MappingField c6757;
   public final MappingField c6768;
   public final MappingField c4653;
   public final MappingField c4770;
   public final MappingField c4509;
   public final MappingField c7039;
   public final MappingMethod c3395;
   public final MappingMethod c5646;

   public MGuiContainer() {
      super(MappedClasses.GuiContainer);
      this.c6777 = this.getMappingFieldNoRemap("inventorySlots", true, MappedClasses.Container);
      this.c5622 = this.getMappingFieldNoRemap("field_146993_M", false, Boolean.TYPE);
      this.c3880 = this.getMappingFieldNoRemap("field_146995_H", false, Boolean.TYPE);
      this.c3285 = this.getMappingFieldNoRemap("guiLeft", true, Integer.TYPE);
      this.c5562 = this.getMappingFieldNoRemap("guiTop", true, Integer.TYPE);
      this.c6306 = this.getMappingFieldNoRemap("xSize", true, Integer.TYPE);
      this.c8851 = this.getMappingFieldNoRemap("ySize", true, Integer.TYPE);
      this.c1910 = this.getMappingFieldNoRemap("field_146994_N", false, MappedClasses.ItemStack);
      this.c7952 = this.getMappingFieldNoRemap("field_146998_K", false, MappedClasses.Slot);
      this.c6757 = this.getMappingFieldNoRemap("field_146997_J", false, Long.TYPE);
      this.c6768 = this.getMappingFieldNoRemap("field_146992_L", false, Integer.TYPE);
      this.c4653 = this.getMappingFieldNoRemap("field_147007_t", false, Boolean.TYPE);
      this.c4770 = this.getMappingFieldNoRemap("field_146988_G", false, Integer.TYPE);
      this.c4509 = this.getMappingFieldNoRemap("field_147008_s", false, Set.class);
      this.c7039 = this.getMappingFieldNoRemap("field_146987_F", false, Integer.TYPE);
      this.c3395 = this.getMappingMethodNoRemap("getSlotAtPosition", true, MappedClasses.Slot, Integer.TYPE, Integer.TYPE);
      if (ForgeVersion.minorVersion() >= 23) {
         this.c5646 = this.getMappingMethodNoRemap("handleMouseClick", true, Void.TYPE, MappedClasses.Slot, Integer.TYPE, Integer.TYPE, MappedClasses.ClickType);
      } else {
         this.c5646 = this.getMappingMethodNoRemap("handleMouseClick", true, Void.TYPE, MappedClasses.Slot, Integer.TYPE, Integer.TYPE, Integer.TYPE);
      }

   }

   public Object c6780(Object var1) {
      return this.c6777.getObject(var1);
   }

   public Object c672(Object var1, int var2, int var3) {
      return this.c3395.invoke(var1, var2, var3);
   }

   public void c3896(Object var1, boolean var2) {
      this.c5622.setBoolean(var1, var2);
   }

   public void c2771(Object var1, boolean var2) {
      this.c3880.setBoolean(var1, var2);
   }

   public int c4023(Object var1) {
      return this.c3285.getInt(var1);
   }

   public int c6882(Object var1) {
      return this.c5562.getInt(var1);
   }

   public int c2099(Object var1) {
      return this.c6306.getInt(var1);
   }

   public int c3817(Object var1) {
      return this.c8851.getInt(var1);
   }

   public Object c6347(Object var1) {
      return this.c1910.getObject(var1);
   }

   public void c6771(Object var1, Object var2) {
      this.c1910.setObject(var1, var2);
   }

   public void c2544(Object var1, Object var2, int var3, int var4, int var5) {
      this.c5646.c2642(var1, var2, var3, var4, var5);
   }

   public void c3194(Object var1, Object var2, int var3, int var4, Object var5) {
      this.c5646.c2642(var1, var2, var3, var4, var5);
   }

   public void c5700(Object var1, Object var2) {
      this.c7952.setObject(var1, var2);
   }

   public void c1918(Object var1, long var2) {
      this.c6757.setLong(var1, var2);
   }

   public void c7403(Object var1, int var2) {
      this.c6768.setInt(var1, var2);
   }

   public void c879(Object var1, boolean var2) {
      this.c4653.setBoolean(var1, var2);
   }

   public void c2803(Object var1, int var2) {
      this.c4770.setInt(var1, var2);
   }

   public Set c961(Object var1) {
      return (Set)this.c4509.getObject(var1);
   }

   public void c2185(Object var1, int var2) {
      this.c7039.setInt(var1, var2);
   }

   // $FF: synthetic method
   public static Object c1605(MGuiContainer var0, Object var1, int var2, int var3) {
      return var0.c672(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void c3065(MGuiContainer var0, Object var1, boolean var2) {
      var0.c3896(var1, var2);
   }

   // $FF: synthetic method
   public static void c3798(MGuiContainer var0, Object var1, boolean var2) {
      var0.c2771(var1, var2);
   }

   // $FF: synthetic method
   public static int c7250(MGuiContainer var0, Object var1) {
      return var0.c4023(var1);
   }

   // $FF: synthetic method
   public static int c218(MGuiContainer var0, Object var1) {
      return var0.c6882(var1);
   }

   // $FF: synthetic method
   public static int c3419(MGuiContainer var0, Object var1) {
      return var0.c2099(var1);
   }

   // $FF: synthetic method
   public static int c6714(MGuiContainer var0, Object var1) {
      return var0.c3817(var1);
   }

   // $FF: synthetic method
   public static Object c5364(MGuiContainer var0, Object var1) {
      return var0.c6347(var1);
   }

   // $FF: synthetic method
   public static void c4663(MGuiContainer var0, Object var1, Object var2) {
      var0.c6771(var1, var2);
   }

   // $FF: synthetic method
   public static void c2403(MGuiContainer var0, Object var1, Object var2, int var3, int var4, int var5) {
      var0.c2544(var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   public static void c4423(MGuiContainer var0, Object var1, Object var2, int var3, int var4, Object var5) {
      var0.c3194(var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   public static void c6768(MGuiContainer var0, Object var1, Object var2) {
      var0.c5700(var1, var2);
   }

   // $FF: synthetic method
   public static void c8059(MGuiContainer var0, Object var1, long var2) {
      var0.c1918(var1, var2);
   }

   // $FF: synthetic method
   public static void c4453(MGuiContainer var0, Object var1, int var2) {
      var0.c7403(var1, var2);
   }

   // $FF: synthetic method
   public static void c2349(MGuiContainer var0, Object var1, boolean var2) {
      var0.c879(var1, var2);
   }

   // $FF: synthetic method
   public static void c5611(MGuiContainer var0, Object var1, int var2) {
      var0.c2803(var1, var2);
   }

   // $FF: synthetic method
   public static Set c8060(MGuiContainer var0, Object var1) {
      return var0.c961(var1);
   }

   // $FF: synthetic method
   public static void c1080(MGuiContainer var0, Object var1, int var2) {
      var0.c2185(var1, var2);
   }
}
