package gg.vape.module;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gg.vape.Vape;
import gg.vape.event.impl.*;
import gg.vape.module.none.ClientSettings;
import gg.vape.module.utility.invcleaner.EventPreRenderPlayer;
import gg.vape.notification.Notification;
import gg.vape.notification.NotificationManager;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.unmap.ModButton;
import gg.vape.unmap.Bendable;
import gg.vape.unmap.INamed;
import gg.vape.utils.processors.DisableModProcessor;
import gg.vape.value.Value;
import gg.vape.wrapper.impl.*;
import lombok.Getter;
import lombok.Setter;
import pub.nextsense.Tweaker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Mod extends Bendable implements INamed {
   public static net.minecraft.client.Minecraft mc  = net.minecraft.client.Minecraft.getMinecraft();
   public final String c7327;
   public String suffix;
   protected Category c2343;
   public final int c2114;
   public final int c8436;
   public boolean state;
   public boolean c7397;
   public final List<Value<?,?>> c7005;
   public final List<IGuiComponent> c4968;
   public boolean c769;
   public String c3941;
   public DisableModProcessor c4311;
   public ModButton c6467;
   public boolean modInited;
   public final List<Mod> subMods;
   @Getter @Setter
   private double arrayX, arrayY;
   public Mod(String var1, int var2, int var3, Category var4, String var5) {
      this.c7005 = new ArrayList();
      this.c4968 = new ArrayList();
      this.c769 = false;
      this.modInited = true;
      this.subMods = new ArrayList();
      this.c7327 = var1;
      this.c2114 = var2;
      this.c8436 = var3;
      this.c2343 = var4;
      this.c3941 = var5;
      if (var2 != 0) {
         this.c8399().add(var2);
      }

   }

   public Mod(String var1, int var2, Category var3) {
      this(var1, 0, var2, var3, null);
   }

   public Mod(String var1, int var2, Category var3, String var4) {
      this(var1, 0, var2, var3, var4);
   }

   public Mod(String var1, int var2) {
      this(var1, var2, 0, Category.None, null);
   }

   public Mod(String var1) {
      this(var1, 0, Category.None);
   }

   public void c141() {
      if (!this.isBlatantMod() || Tweaker.isBlatantMode()) {
         if (!this.c199() || !this.c8399().isEmpty()) {
            this.setState(!this.state);
         }
      }
   }

   public boolean getState() {
      return this.state;
   }

   public void setState(boolean state) {
      if (!this.isBlatantMod() || Tweaker.isBlatantMode()) {
         this.state = state;
         if (this.state) {
            NotificationManager.Instance.addNotification(new Notification("Module Toggled","Module " + getName() + " has been Enabled!", Notification.NotificationType.SUCCESS,2000));
            this.onEnable();
         } else {
            NotificationManager.Instance.addNotification(new Notification("Module Toggled","Module " + getName() + " has been Disabled!", Notification.NotificationType.SUCCESS,2000));

            this.onDisable();
         }

         Vape.instance.getModManager().c2410(this);
      }
   }

   public String getName() {
      return this.c7327;
   }

   public String getSuffix() {
      return this.suffix != null ? ClientSettings.colorPrefix + "7 " + this.suffix : "";
   }

   public void setSuffix(String var1) {
      this.suffix = var1;
   }

   public int c5275() {
      return this.c8436;
   }

   public Category getCategory() {
      return this.c2343;
   }

   public boolean isBlatantMod() {
      return false;
   }

   public void c6085(EventKeyPress var1) {
      if (var1.c6502() > 0) {
         if (!this.c8399().isEmpty()) {
            if (var1.c4942() && Minecraft.currentScreen().getObject() == null) {
               this.c3059(var1.c6502());
            }

         }
      }
   }

   public void onMouse(EventMouse event) {
   }

   public void onEnable() {
      this.subMods.forEach(Mod::onEnable);
   }

   public void onDisable() {
      this.subMods.forEach(Mod::onDisable);
   }

   public void onTick(EventPlayerTick event) {
   }

   public void onPlayerTick(EventPlayerTick event) {
   }

   public void onUpdate(EventLivingUpdate event) {
   }

   public void onRender3D(EventRender3D event) {
   }

   public void onRender(EventRender3D event) {
   }

   public void onPreRenderLiving(EventPreRenderLivingEvent event) {
   }

   public void onSpecPreRenderLiving(EventPreRenderPlayerSpec event) {
   }

   public void onSetArmor(EventSetArmorModel event) {
   }

   public void onPreRenderLiving(EventPreRenderLiving event) {
   }

   public void onPostRenderLiving(EventPostRenderLiving event) {
   }

   public void onPreRenderPlayer(EventPreRenderPlayer event) {
   }

   public void onPostRenderPlayer(EventPostRenderPlayer event) {
   }

   public void onFogColors(EventFogColors event) {
   }

   public void onRenderFog(EventRenderFog event) {
   }

   public void onFogDensity(EventFogDensity event) {
   }

   public void onMove(EventMove event) {
   }

   public void onMotionUpdate(EventMotion event) {
   }

   public void onStep(EventStep event) {
   }

   public void c2965(EventRenderHand var1) {
   }

   public void onRender2D(RenderGameOverlayEvent event) {
   }

   public void onTick(EventTick event) {
   }

   public void onSetSprinting(EventSetSprinting event) {
   }

   public void onAttack(EventAttack event) {
   }

   public void onRenderTick(EventRenderTick event) {
   }

   public void onPostRenderTick(EventRenderTick event) {
   }

   public void onRenderBlockOverlay(EventRenderBlockOverlay event) {
   }

   public void onPacketSend(EventPacketSend event) {
   }

   public void onPacketReceive(EventPacketReceive event) {
   }

   public void onNameFormat(EventNameFormat event) {
   }

   public void onChat(EventChat event) {
   }

   public void onJoinWorld(EntityJoinWorldEvent event) {
   }

   public void onPlaySoundAtEntity(PlaySoundAtEntityEvent event) {
   }

   public void onInteract(PlayerInteractEvent event) {
   }

   public void c8731() {
   }

   public void c992() {
   }

   public void c1458(Mod var1) {
   }

   public List<Mod> getSubMods() {
      return this.subMods;
   }

   public List<Value<?,?>> getValues() {
      return this.c7005;
   }

   public SubModule c4529(String var1) {
      Iterator<Mod> var2 = this.getSubMods().iterator();

      SubModule var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (SubModule)var2.next();
      } while(!var3.getName().equalsIgnoreCase(var1));

      return var3;
   }

   public Value<?,?> getValue(String var1) {
      Iterator<Value<?,?>> var2 = this.getValues().iterator();

      Value<?,?> var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = var2.next();
      } while(!var3.getID().equalsIgnoreCase(var1) && !var3.getName().equalsIgnoreCase(var1));

      return var3;
   }

   public void c4720(SubModule... var1) {
      this.getSubMods().addAll(Arrays.asList(var1));
   }

   public void addValue(Value<?,?>... var1) {
      this.getValues().addAll(Arrays.asList(var1));
   }

   public List c5526() {
      if (!this.c769) {
         this.c8116();
      }

      return this.c4968;
   }

   public void c8116() {

      for (Value<?,?> value : this.getValues()) {
         if (value.getComponent() != null) {
            this.c4968.add(value.getComponent());
         }
      }

      this.c769 = true;
   }

   public JsonObject c2690() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("name", this.getName());
      var1.add("keybinds", this.toJson());
      JsonArray jsonArray = new JsonArray();

      for (Value<?, ?> value : this.c7005) {
         if (value.isToggleable()) {
            jsonArray.add(value.toJson());
         }
      }

      var1.add("values", jsonArray);
      if (this.c6467 != null) {
         var1.addProperty("visible", this.c6467.c5615().c2346());
      }

      return var1;
   }

   public void loadJson(JsonObject var1) {
      this.c8399().clear();
      if (var1.get("name") != null && !var1.get("name").isJsonNull() && var1.get("name").getAsString().equalsIgnoreCase(this.getName())) {
         if (var1.get("keybind") != null && !var1.get("keybind").isJsonNull()) {
            this.c1287(var1.get("keybind").getAsInt());
            this.c8399().add(this.c5136());
         } else if (var1.get("keybinds") != null && var1.get("keybinds").isJsonArray()) {
            try {
               this.readBind(var1.getAsJsonArray("keybinds"));
            } catch (Exception var7) {
            }
         } else {
            this.c8399().clear();
            this.c8399().add(this.c2114);
         }

         JsonArray var2 = var1.getAsJsonArray("values");

         for (JsonElement jsonElement : var2) {
            JsonObject var4 = jsonElement.getAsJsonObject();

            for (Value<?, ?> value : this.c7005) {
               if (value.getID().equalsIgnoreCase(var4.get("id").getAsString())) {
                  value.loadJson(var4);
               }
            }
         }

         if (var1.get("visible") != null && !var1.get("visible").isJsonNull() && this.c6467 != null) {
            boolean var8 = var1.get("visible").getAsBoolean();
            this.c6467.c5615().c8121(var8);
         }
      }

   }

   public String c2139() {
      return this.c3941;
   }

   public void c6039(String var1) {
      this.c3941 = var1;
   }

   public int c5136() {
      return this.c2114;
   }

   public void c756() {
   }

   public void c5375(long var1, boolean var3) {
      if (this.c4311 != null) {
         this.c4311.c4818(false);
      }

      this.c4311 = new DisableModProcessor(this, var1, var3);
      (new Thread(this.c4311)).start();
   }

   public boolean c199() {
      return this.c7397;
   }

   public String c407() {
      return String.format(" %s7[%sr%s%s7]%sr %s", ClientSettings.colorPrefix, ClientSettings.colorPrefix, this.getBindName(), ClientSettings.colorPrefix, ClientSettings.colorPrefix, this.getName());
   }

   public void c8471() {
      this.c141();
   }

   public void bindTo(ModButton var1) {
      this.c6467 = var1;
   }

   public boolean available() {
      return this.modInited;
   }

   public void init(boolean var1) {
      this.modInited = var1;
   }

   public ModButton getButton() {
      return this.c6467;
   }

   public boolean isDisplayable() {
      return this.c6467.c5615().c2346();
   }
}
