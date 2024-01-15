package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;
import pub.nextsense.Tweaker;

public class MMinecraft extends Mapping {
   public final MappingMethod c7155;
   public final MappingMethod c2840;
   public final MappingMethod c945;
   public final MappingMethod c673;
   public final MappingMethod c8237;
   public final MappingMethod c4214;
   public final MappingMethod c6931;
   public final MappingField c4945;
   public final MappingField c6268;
   public final MappingField c5541;
   public final MappingField c5371;
   public final MappingField c8294;
   public final MappingField c6129;
   public final MappingField c1090;
   public final MappingField c4022;
   public final MappingField c6181;
   public final MappingField c4535;
   public final MappingField c7600;
   public final MappingField c1309;
   public final MappingField c1437;
   public final MappingField c3536;
   public final MappingField c4780;
   public final MappingField c3664;
   public MappingField c7447;
   public MappingField c6123;
   public MappingField c8659;
   public final MappingField c1270;

   public MMinecraft() {
      super(MappedClasses.Minecraft);
      if (ForgeVersion.minorVersion() == 13) {
         this.c4945 = this.getMappingFieldNoRemap("thePlayer", true, Tweaker.getClazz("net/minecraft/client/entity/EntityClientPlayerMP"));
         this.c5371 = this.getMappingFieldNoRemap("fontRenderer", true, MappedClasses.FontRenderer);
      } else {
         if (ForgeVersion.minorVersion() >= 23) {
            this.c4945 = this.getMappingFieldNoRemap("player", true, MappedClasses.EntityPlayerSP);
         } else {
            this.c4945 = this.getMappingFieldNoRemap("thePlayer", true, MappedClasses.EntityPlayerSP);
         }

         this.c5371 = this.getMappingFieldNoRemap("fontRendererObj", true, MappedClasses.FontRenderer);
         this.c7447 = this.getMappingFieldNoRemap("renderManager", true, MappedClasses.RenderManager);
         this.c6123 = this.getMappingFieldNoRemap("renderItem", true, MappedClasses.RenderItem);
      }

      if (ForgeVersion.minorVersion() >= 23) {
         this.c5541 = this.getMappingFieldNoRemap("world", true, MappedClasses.WorldClient);
      } else {
         this.c5541 = this.getMappingFieldNoRemap("theWorld", true, MappedClasses.WorldClient);
      }

      this.c1270 = this.getMappingFieldNoRemap("inGameHasFocus", true, Boolean.TYPE);
      this.c6268 = this.getMappingFieldNoRemap("currentScreen", true, MappedClasses.GuiScreen);
      this.c8294 = this.getMappingFieldNoRemap("gameSettings", true, MappedClasses.GameSettings);
      this.c6129 = this.getMappingFieldNoRemap("renderViewEntity", true, ForgeVersion.minorVersion() == 13 ? MappedClasses.EntityLivingBase : MappedClasses.Entity);
      this.c1090 = this.getMappingFieldNoRemap("playerController", true, MappedClasses.PlayerControllerMP);
      this.c4022 = this.getMappingFieldNoRemap("objectMouseOver", true, MappedClasses.RayTraceResult);
      this.c6181 = this.getMappingFieldNoRemap("pointedEntity", true, MappedClasses.Entity);
      this.c4535 = this.getMappingFieldNoRemap("entityRenderer", true, MappedClasses.EntityRenderer);
      this.c7600 = this.getMappingFieldNoRemap("displayHeight", true, Integer.TYPE);
      this.c1309 = this.getMappingFieldNoRemap("displayWidth", true, Integer.TYPE);
      this.c1437 = this.getMappingFieldNoRemap("timer", true, MappedClasses.Timer);
      this.c3536 = this.getMappingFieldNoRemap("renderGlobal", true, MappedClasses.RenderGlobal);
      this.c4780 = this.getMappingFieldNoRemap("rightClickDelayTimer", true, Integer.TYPE);
      this.c3664 = this.getMappingFieldNoRemap("mouseHelper", true, MappedClasses.MouseHelper);
      if (ForgeVersion.minorVersion() <= 15) {
         this.c8659 = this.getMappingFieldNoRemap("effectRenderer", true, MappedClasses.EffectRenderer);
      }

      this.c7155 = this.getMappingMethod("getMinecraft", true, MappedClasses.Minecraft);
      this.c2840 = this.getMappingMethodNoRemap("shutdown", true, Void.TYPE);
      this.c945 = this.getMappingMethodNoRemap("displayGuiScreen", true, Void.TYPE, MappedClasses.GuiScreen);
      this.c673 = this.getMappingMethodNoRemap("setIngameFocus", true, Void.TYPE);
      this.c8237 = this.getMappingMethodNoRemap("getTextureManager", true, MappedClasses.TextureManager);
      this.c4214 = this.getMappingMethodNoRemap("getFramebuffer", true, MappedClasses.Framebuffer);
      this.c6931 = this.getMappingMethod("getSystemTime", true, Long.TYPE);
   }

   public Object c6031() {
      return this.c7155.invoke(null);
   }

   public Object c6780(Object var1) {
      return this.c4945.getObject(var1);
   }

   public void c6265(Object var1) {
      this.c2840.c2642(var1);
   }

   public Object c5327(Object var1) {
      return this.c6268.getObject(var1);
   }

   public void c6771(Object var1, Object var2) {
      this.c6268.setObject(var1, var2);
   }

   public Object c5143(Object var1) {
      return this.c5541.getObject(var1);
   }

   public void c5700(Object var1, Object var2) {
      this.c945.c2642(var1, var2);
   }

   public Object c5156(Object var1) {
      return this.c5371.getObject(var1);
   }

   public Object c6347(Object var1) {
      return this.c8294.getObject(var1);
   }

   public Object c6946(Object var1) {
      return this.c6129.getObject(var1);
   }

   public void c5919(Object var1, Object var2) {
      this.c6129.setObject(var1, var2);
   }

   public Object c3024(Object var1) {
      return this.c1090.getObject(var1);
   }

   public Object c984(Object var1) {
      return this.c4022.getObject(var1);
   }

   public void c4067(Object var1, Object var2) {
      this.c4022.setObject(var1, var2);
   }

   public Object c2141(Object var1) {
      return this.c6181.getObject(var1);
   }

   public void c3702(Object var1, Object var2) {
      this.c6181.setObject(var1, var2);
   }

   public Object c593(Object var1) {
      return this.c4535.getObject(var1);
   }

   public int c7198(Object var1) {
      return this.c1309.getInt(var1);
   }

   public int c7434(Object var1) {
      return this.c7600.getInt(var1);
   }

   public void c7403(Object var1, int var2) {
      this.c1309.setInt(var1, var2);
   }

   public void c2803(Object var1, int var2) {
      this.c7600.setInt(var1, var2);
   }

   public Object c3649(Object var1) {
      return this.c7447.getObject(var1);
   }

   public void c2694(Object var1) {
      this.c673.c2642(var1);
   }

   public boolean c7071(Object var1) {
      return this.c673.c5509(var1);
   }

   public Object c8637(Object var1) {
      return this.c8237.invoke(var1);
   }

   public Object c8457(Object var1) {
      return this.c4214.invoke(var1);
   }

   public Object c6519(Object var1) {
      return this.c6123.getObject(var1);
   }

   public Object c6842(Object var1) {
      return this.c1437.getObject(var1);
   }

   public Object c8709(Object var1) {
      return this.c3536.getObject(var1);
   }

   public int c8644(Object var1) {
      return this.c4780.getInt(var1);
   }

   public void c2185(Object var1, int var2) {
      this.c4780.setInt(var1, var2);
   }

   public long c1472() {
      return this.c6931.c7032(null);
   }

   public Object c5161(Object var1) {
      return this.c3664.getObject(var1);
   }

   public boolean c5657(Object var1) {
      return this.c1270.getBoolean(var1);
   }

   public Object c8534(Object var1) {
      return this.c8659.getObject(var1);
   }

   // $FF: synthetic method
   public static Object c8482(MMinecraft var0, Object var1) {
      return var0.c6519(var1);
   }

   // $FF: synthetic method
   public static Object c1215(MMinecraft var0, Object var1) {
      return var0.c8709(var1);
   }

   // $FF: synthetic method
   public static int c365(MMinecraft var0, Object var1) {
      return var0.c8644(var1);
   }

   // $FF: synthetic method
   public static void c6215(MMinecraft var0, Object var1, int var2) {
      var0.c2185(var1, var2);
   }

   // $FF: synthetic method
   public static Object c7546(MMinecraft var0, Object var1) {
      return var0.c6842(var1);
   }

   // $FF: synthetic method
   public static long c4581(MMinecraft var0) {
      return var0.c1472();
   }

   // $FF: synthetic method
   public static Object c7853(MMinecraft var0, Object var1) {
      return var0.c5161(var1);
   }

   // $FF: synthetic method
   public static Object c2684(MMinecraft var0, Object var1) {
      return var0.c8534(var1);
   }
}
