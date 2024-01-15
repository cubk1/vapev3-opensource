package gg.vape;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import gg.vape.asm.transform.TransformManager;
import gg.vape.config.Profile;
import gg.vape.event.ForgeEventManager;
import gg.vape.manager.*;
import gg.vape.manager.client.FriendManager;
import gg.vape.manager.client.IndependentSettingsManager;
import gg.vape.manager.client.ProfilesManager;
import gg.vape.mapping.Mapper;
import gg.vape.module.blatant.AntiBot;
import gg.vape.module.none.AutoLoadValue;
import gg.vape.module.none.ClientSettings;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.component.value.BooleanComponent;
import gg.vape.ui.font.SmoothFontRenderer;
import gg.vape.unmap.GLUtils;
import gg.vape.unmap.ItemHelper;
import gg.vape.utils.Base64Util;
import gg.vape.utils.destruct.DestructThread;
import gg.vape.utils.destruct.Destructor;
import gg.vape.wrapper.impl.ForgeVersion;
import gg.vape.wrapper.impl.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.NetworkManager;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import pub.nextsense.Config;
import pub.nextsense.Tweaker;
import pub.nextsense.alt.IASConfig;
import pub.nextsense.common.d;
import pub.nextsense.util.PacketHandler;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Vape {
   public static final boolean c3566 = false;
   public static final boolean c7740 = false;
   public static final String version = "3.28";
   public static boolean transformed = false;
   public static Vape instance;
   public Destructor destructor;
   public boolean destructed;
   public Mapper mapper;
   public ValueManager valueManager;
   public ModManager modManager;
   public ForgeEventManager forgeEventManager;
   public GLUtils glUtils;
   public FriendManager friendManager;
   public ProfilesManager profilesManager;
   public FrameManager frameManager;
   public MacroManager macroManager;
   public SearchManager searchManager;
   public ClientSettings clientSettings;
   public AutoLoadValue autoLoadValue;
   public IndependentSettingsManager independentSettingsManager;
   public ItemHelper itemHelper;
   public Config ntrConfig;
   public boolean c3266;
   public boolean c6253;
   //1.7 1.8 1.12
   public static final int[] mcVersions = new int[]{13, 15, 23};
   public final SmoothFontRenderer f18 = new SmoothFontRenderer(18);
   public final SmoothFontRenderer f10 = new SmoothFontRenderer(10);
   public final ConcurrentMap<Integer, SmoothFontRenderer> fonts = new ConcurrentHashMap<>();
   public TransformManager transformManager;

   public Vape() {
      instance = this;
      this.destructor = new Destructor();

      try {
         this.destructor.c2508();
      } catch (Exception var2) {
      }

   }

   public static void lout(String msg) {
      Tweaker.println(String.format("[%02d] %s", System.currentTimeMillis(), msg));
   }

   public static void throwEx(Exception ex) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      ex.printStackTrace(pw);
      String msg = "\n" + sw;
      lout(msg);
   }

   public void loadMappings() {
      this.mapper = new Mapper();
      this.mapper.loadMappings();
      Mapper.mappings.clear();
      this.mapper = new Mapper();
      this.mapper.loadMappings();
   }

   public void initial() {
      this.glUtils = new GLUtils();
      this.glUtils.c6803(24, 1);
      this.forgeEventManager = new ForgeEventManager();
      this.forgeEventManager.c8727();

/*      while(!this.forgeEventManager.c6011()) {
         try {
            Thread.sleep(10L);
         } catch (InterruptedException var2) {
            var2.printStackTrace();
         }
      }*/

      this.valueManager = new ValueManager();
      this.independentSettingsManager = new IndependentSettingsManager();
      this.friendManager = new FriendManager();
      this.macroManager = new MacroManager();
      this.searchManager = new SearchManager();
      this.clientSettings = new ClientSettings();
      this.autoLoadValue = new AutoLoadValue();
      this.modManager = new ModManager();
      this.modManager.init();
      this.clientSettings.theAntiBot = this.modManager.getMod(AntiBot.class);
      this.frameManager = new FrameManager();
      this.frameManager.c8674();
      this.profilesManager = new ProfilesManager();
      this.profilesManager.loadProfiles(null);
      this.modManager.c3110();
      this.ntrConfig = new Config("Profile");
      this.ntrConfig.readConfig();
      this.c6324();
      this.modManager.c4397();
      IASConfig.load();
      this.forgeEventManager.c3072();
      if (this.clientSettings.enableOnLoad.getValue() && isSupportedVersion()) {
         ((BooleanComponent)this.clientSettings.blatantMode.getComponent()).c8121(true);
         Tweaker.loadBlatantMode();
         this.c6324();
         ((BooleanComponent)this.clientSettings.blatantMode.getComponent()).c8121(true);
      }

      this.itemHelper = new ItemHelper();
   }

   public Mapper getMappings() {
      return this.mapper;
   }

   public void destruct(boolean var1) {
      (new DestructThread(this, var1)).start();
   }

   public ModManager getModManager() {
      return this.modManager;
   }

   public ValueManager getValueManager() {
      return this.valueManager;
   }

   public ForgeEventManager getEventManager() {
      return this.forgeEventManager;
   }

   public boolean isDestroyed() {
      return this.destructed;
   }

   public GLUtils c8466() {
      return this.glUtils;
   }

   public TransformManager getTransformManager() {
      return this.transformManager;
   }

   public FriendManager getFriendManager() {
      return this.friendManager;
   }

   public ProfilesManager getProfilesManager() {
      return this.profilesManager;
   }

   public MacroManager getMacrosManager() {
      return this.macroManager;
   }

   public FrameManager getFrameManager() {
      return this.frameManager;
   }

   public void loadJson(JsonObject jsonObj) {
      JsonArray json;
      if (jsonObj.get("independentSettings") != null && !jsonObj.get("independentSettings").isJsonNull()) {
         json = jsonObj.get("independentSettings").getAsJsonArray();
         this.independentSettingsManager.loadIndependentSettings(json);
      }

      if (jsonObj.get("friends") != null && !jsonObj.get("friends").isJsonNull()) {
         json = jsonObj.get("friends").getAsJsonArray();
         this.friendManager.loadFriends(json);
      }

      if (jsonObj.get("profiles") != null && !jsonObj.get("profiles").isJsonNull()) {
         json = jsonObj.get("profiles").getAsJsonArray();
         this.profilesManager.loadProfiles(json);
      }

      if (jsonObj.get("frames") != null && !jsonObj.get("frames").isJsonNull()) {
         json = jsonObj.get("frames").getAsJsonArray();
         this.frameManager.loadFrames(json);
      }

   }

   public JsonObject getManagerJson() {
      JsonObject json = new JsonObject();
      json.add("modules", this.modManager.toJson());
      json.add("values", this.valueManager.toJson());
      json.add("macros", this.macroManager.toJson());
      json.add("search", this.searchManager.toJson());
      json.add("frames", this.frameManager.toJson());
      return json;
   }

   public JsonObject getClientSettingsJson() {
      JsonObject json = new JsonObject();
      json.add("independentSettings", this.independentSettingsManager.toJson());
      json.add("friends", this.friendManager.toJson());
      json.add("profiles", this.profilesManager.toJson());
      return json;
   }

   public void c6324() {
      try {
         String var1 = new String(Base64Util.decodeBase64(Tweaker.get()));
         JsonReader var2 = new JsonReader(new StringReader(var1));
         var2.setLenient(true);
         JsonObject var3 = (new Gson()).fromJson(var2, JsonObject.class);
         if (var3 != null) {
            instance.loadJson(var3);
         }
      } catch (Exception var4) {
      }

   }

   public void c6703() {
      try {
         if (instance.getProfilesManager().c7171() != null) {
            instance.getProfilesManager().c7171().c5864();
         }

         JsonObject var1 = instance.getClientSettingsJson();
         Iterator var2 = this.profilesManager.c6161().iterator();

         while(var2.hasNext()) {
            Profile var3 = (Profile)var2.next();
            var3.c8827(true);
         }
      } catch (Exception var4) {
      }

   }

   public ClientSettings getSettings() {
      return this.clientSettings;
   }

   public SearchManager getSearch() {
      return this.searchManager;
   }

   public boolean c4762() {
      return this.c3266;
   }

   public void c8678(boolean var1) {
      this.c3266 = var1;
   }

   public boolean c7302() {
      return this.c6253;
   }

   public void c8477(boolean var1) {
      this.c6253 = var1;
   }

   public AutoLoadValue needAutoLoad() {
      return this.autoLoadValue;
   }

   public IndependentSettingsManager getSettingsManager() {
      return this.independentSettingsManager;
   }

   public ItemHelper getItemHelper() {
      return this.itemHelper;
   }

   public static boolean isSupportedVersion() {
      for (int ver : mcVersions) {
         if (ver == ForgeVersion.minorVersion()) {
            return true;
         }
      }
      return false;
   }

   public void enableBlatant() {
      transformed = true;
      this.transformManager = new TransformManager();
      this.transformManager.doTransform();
   }


   public static void start() {
      Vape instance = new Vape();
      instance.loadMappings();
      instance.initial();
      instance.c8678(true);
   }

   public static void call(Object event) {
      if (Vape.instance != null) {
         if (event instanceof TickEvent.ClientTickEvent) {
            NetHandlerPlayClient netHandler = net.minecraft.client.Minecraft.getMinecraft().getNetHandler();
            if (netHandler != null) {
               NetworkManager manager = netHandler.getNetworkManager();
               if (manager != null && manager.channel().pipeline().get("nig") == null) {
                  manager.channel().pipeline().addBefore("packet_handler", "nig", new PacketHandler(manager));
               }
            }
         }

         if (Vape.instance.getEventManager() != null && !Vape.instance.isDestroyed()) {
            Vape.instance.getEventManager().call(event);
         }

      }
   }

   public void retransform() {
      this.transformManager.transformToOrig();
   }

   public void c4956() {
      this.fonts.put(18, this.f18);
      this.fonts.put(10, this.f10);
   }

   public SmoothFontRenderer getF18() {
      return this.f18;
   }

   public SmoothFontRenderer getF10() {
      return this.f10;
   }

   public SmoothFontRenderer getFont(double size) {
      int var3 = (int)(18.0 * size);
      if (!this.fonts.containsKey(var3)) {
         SmoothFontRenderer var4 = new SmoothFontRenderer(var3);
         this.fonts.put(var3, var4);
         return var4;
      } else {
         return this.fonts.get(var3);
      }
   }

   public void reloadGui() {
      d.onGuiClosed(d.getGuiObject());
      Minecraft.currentScreen(null);
      ClickGui var1 = this.getModManager().getMod(ClickGui.class);
      var1.c141();
      this.getFrameManager().c8674();
      var1.c8731();
      this.c6324();
   }
}
