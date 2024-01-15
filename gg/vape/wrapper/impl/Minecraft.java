package gg.vape.wrapper.impl;

import gg.vape.Vape;
import gg.vape.mapping.mappings.MMinecraft;
import gg.vape.wrapper.Wrapper;

public class Minecraft extends Wrapper {
   public static EntityPlayerSP c2118;

   public Minecraft() {
      super(Vape.instance.getMappings().minecraft.c6031());
   }

   public static Object c5366() {
      return vape.getMappings().minecraft.c6031();
   }

   public static EntityPlayerSP thePlayer() {
      return new EntityPlayerSP(Vape.instance.getMappings().minecraft.c6780(c5366()));
   }

   public static GuiScreen currentScreen() {
      return new GuiScreen(vape.getMappings().minecraft.c5327(c5366()));
   }

   public static void currentScreen(Object var0) {
      vape.getMappings().minecraft.c6771(c5366(), var0);
   }

   public static WorldClient theWorld() {
      return new WorldClient(vape.getMappings().minecraft.c5143(c5366()));
   }

   public static void c8115(GuiScreen var0) {
      vape.getMappings().minecraft.c5700(c5366(), var0.getObject());
   }

   public static FontRenderer getFontRenderer() {
      return new FontRenderer(vape.getMappings().minecraft.c5156(c5366()));
   }

   public static GameSettings gameSettings() {
      return new GameSettings(vape.getMappings().minecraft.c6347(c5366()));
   }

   public static EntityLivingBase c2991() {
      return new EntityLivingBase(vape.getMappings().minecraft.c6946(c5366()));
   }

   public static void c4087(EntityLivingBase var0) {
      vape.getMappings().minecraft.c5919(c5366(), var0 == null ? null : var0.getObject());
   }

   public static PlayerControllerMP playerController() {
      return new PlayerControllerMP(vape.getMappings().minecraft.c3024(c5366()));
   }

   public static RayTraceResult c1367() {
      return new RayTraceResult(vape.getMappings().minecraft.c984(c5366()));
   }

   public static void c6810(RayTraceResult var0) {
      vape.getMappings().minecraft.c4067(c5366(), var0.getObject());
   }

   public static Entity c6298() {
      return new Entity(vape.getMappings().minecraft.c2141(c5366()));
   }

   public static void c7364(Entity var0) {
      vape.getMappings().minecraft.c3702(c5366(), var0.getObject());
   }

   public static EntityRenderer c2698() {
      return new EntityRenderer(vape.getMappings().minecraft.c593(c5366()));
   }

   public static ScaledResolution c4912() {
      return ScaledResolution.create(new Minecraft(), displayWidth(), displayHeight());
   }

   public static int displayWidth() {
      return vape.getMappings().minecraft.c7198(c5366());
   }

   public static int displayHeight() {
      return vape.getMappings().minecraft.c7434(c5366());
   }

   public static void c33(int var0) {
      vape.getMappings().minecraft.c7403(c5366(), var0);
   }

   public static void c2062(int var0) {
      vape.getMappings().minecraft.c2803(c5366(), var0);
   }

   public static void setIngameFocus() {
      vape.getMappings().minecraft.c2694(c5366());
   }

   public static RenderManager c5612() {
      return ForgeVersion.minorVersion() == 13 ? RenderManager.c816() : new RenderManager(vape.getMappings().minecraft.c3649(c5366()));
   }

   public static TextureManager c7094() {
      return new TextureManager(vape.getMappings().minecraft.c8637(c5366()));
   }

   public static Framebuffer getFrameBuffer() {
      return new Framebuffer(vape.getMappings().minecraft.c8457(c5366()));
   }

   public static RenderItem c5718() {
      return ForgeVersion.minorVersion() == 13 ? RenderItem.c5211() : new RenderItem(MMinecraft.c8482(vape.getMappings().minecraft, c5366()));
   }

   public static RenderGlobal c7806() {
      return new RenderGlobal(MMinecraft.c1215(vape.getMappings().minecraft, c5366()));
   }

   public static int c8838() {
      return MMinecraft.c365(vape.getMappings().minecraft, c5366());
   }

   public static void c5732(int var0) {
      MMinecraft.c6215(vape.getMappings().minecraft, c5366(), var0);
   }

   public static boolean c8917() {
      return vape.getMappings().minecraft.c7071(c5366());
   }

   public static Timer getTimer() {
      return new Timer(MMinecraft.c7546(vape.getMappings().minecraft, c5366()));
   }

   public static long c657() {
      return MMinecraft.c4581(vape.getMappings().minecraft);
   }

   public static MouseHelper c4753() {
      return new MouseHelper(MMinecraft.c7853(vape.getMappings().minecraft, c5366()));
   }

   public static boolean c577() {
      return vape.getMappings().minecraft.c5657(c5366());
   }

   public static EffectRenderer c6818() {
      return new EffectRenderer(MMinecraft.c2684(vape.getMappings().minecraft, c5366()));
   }
}
