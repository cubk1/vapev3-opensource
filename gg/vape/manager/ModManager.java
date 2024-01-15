package gg.vape.manager;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gg.vape.module.Mod;
import gg.vape.module.blatant.Timer;
import gg.vape.module.blatant.*;
import gg.vape.module.combat.*;
import gg.vape.module.none.*;
import gg.vape.module.other.AntiAFK;
import gg.vape.module.other.Crasher;
import gg.vape.module.other.Disabler;
import gg.vape.module.other.SelfDestruct;
import gg.vape.module.render.*;
import gg.vape.module.render.proj.Projectiles;
import gg.vape.module.utility.*;
import gg.vape.module.world.ChestSteal;
import gg.vape.module.world.FastPlace;
import gg.vape.wrapper.impl.ForgeVersion;

import java.util.*;

public class ModManager {
   public final Map<Class<? extends Mod>, Mod> modMap = new HashMap<>();
   public final HashSet<Mod> mods = new HashSet<>();

   public void init() {
      this.addModule(new SelfDestruct());
      this.addModule(new ClickGui());
      this.addModule(new AutoClicker());
      this.addModule(new Velocity());
      this.addModule(new Reach());
      this.addModule(new Throwpot());
      this.addModule(new Refill());
      this.addModule(new Tracers());
      this.addModule(new NameTags());
      this.addModule(new Search());
      this.addModule(new XRay());
      this.addModule(new Animation());
      this.addModule(new ESP());
      this.addModule(new ChestSteal());
      this.addModule(new Timer());
      this.addModule(new KeepSprint());
      this.addModule(new Macros());
      this.addModule(new FastPlace());
      this.addModule(new HitBoxes());
      this.addModule(new NoFall());
      this.addModule(new AntiFML());
      this.addModule(new AutoSword());
      this.addModule(new Crasher());
      this.addModule(new SpawnerFinder());
      this.addModule(new StorageESP());
      //this.addModule(new Freecam());
      this.addModule(new Scaffold());
      this.addModule(new BeanerNet(), false);
      this.addModule(new Fullbright());
      this.addModule(new Sprint());
      this.addModule(new WTap());
      this.addModule(new AutoArmor());
      this.addModule(new Strafe(), false);
      this.addModule(new InvCleaner());
      this.addModule(new ThrowDebuff());
      this.addModule(new AutoTool());
      this.addModule(new AimAssist());
      this.addModule(new Friends());
      this.addModule(new Trajectories());
      this.addModule(new AntiDebuff(), false);
      this.addModule(new SafeWalk());
      this.addModule(new AntiBot());
      this.addModule(new DuelInfo());
      this.addModule(new Clutch(), false);
      this.addModule(new Projectiles());
      if (ForgeVersion.minorVersion() > 13) {
         this.addModule(new Fly());
      }

      this.addModule(new Speed());
      this.addModule(new NoRotate(), false);
      this.addModule(new KillAura());
      this.addModule(new NoSlow());
      this.addModule(new Chams());
      this.addModule(new Disabler());
      this.addModule(new AntiFall());
      this.addModule(new LongJump());
      this.addModule(new Criticals());
      this.addModule(new InvWalk(), false);
      this.addModule(new Arrows());
      this.addModule(new PotionSaver(), false);
      this.addModule(new Blink(), false);
      this.addModule(new FastConsume(), false);
      this.addModule(new AutoPearl());
      this.addModule(new Panic());
      this.addModule(new AntiAFK());
      this.addModule(new BowAimbot());
      this.addModule(new ArmorSwitch());
      this.addModule(new Phase());
   }

   public void c3110() {

      for (Mod var2 : this.modMap.values()) {
         var2.c992();
      }

   }

   public void c4397() {
      for (Mod mod : this.modMap.values()) {
         mod.c8731();
      }
   }

   public void addModule(Mod var1, boolean var2) {
      this.modMap.put(var1.getClass(), var1);
      var1.init(var2);
   }

   public void addModule(Mod var1) {
      this.addModule(var1, true);
   }

   public Collection<Mod> collectMods() {
      return this.modMap.values();
   }

   @SuppressWarnings("all")
   public <T extends Mod> T getMod(Class<T> var1) {
      return (T)this.modMap.get(var1);
   }



   public boolean getState(Class<?> target) {
      Iterator<Mod> var2 = this.collectMods().iterator();
      Mod instance;
      do {
         if (!var2.hasNext()) {
            return false;
         }
         instance = var2.next();
      } while(!instance.getClass().equals(target));
      return instance.getState();
   }

   public void loadJson(JsonArray json) {
      for(int i = 0; i < json.size(); ++i) {
         JsonElement element = json.get(i);
         if (element.isJsonObject() && !element.isJsonNull()) {
            JsonObject jsonObject = element.getAsJsonObject();
            if (jsonObject.get("name") != null && !jsonObject.get("name").isJsonNull()) {
               for (Mod mod : this.collectMods()) {
                  if (mod.getName().equalsIgnoreCase(jsonObject.get("name").getAsString())) {
                     mod.loadJson(jsonObject);
                  }
               }
            }
         }
      }

   }

   public Mod getMod(String name){
      for(Class<? extends Mod> mod : modMap.keySet()){
         if(modMap.get(mod).getName().equalsIgnoreCase(name))
            return modMap.get(mod);
      }
      return null;
   }

   public void c2410(Mod var1) {
      if (var1.getState()) {
         this.mods.add(var1);
      } else {
         this.mods.remove(var1);
      }

      for (Mod mod : this.getMods()) {
         mod.c1458(var1);
      }

   }

   public HashSet<Mod> getMods() {
      return this.mods;
   }

   public JsonArray toJson() {
      JsonArray var1 = new JsonArray();

      for (Object o : this.collectMods()) {
         Mod var3 = (Mod) o;
         var1.add(var3.c2690());
      }

      return var1;
   }

   public void c1288(JsonObject var1) {
      for (Object o : this.collectMods()) {
         Mod var3 = (Mod) o;
         if (var1.has(var3.getName())) {
            if (var3.getButton() != null && var3.getButton().c5615() != null && var3.getButton().c5615().c2346()) {
               var3.setState(var1.get(var3.getName()).getAsBoolean());
            }
         } else if (!(var3 instanceof ClickGui) && var3.getState()) {
            var3.c141();
         }
      }

   }

   public JsonObject getJsonObj() {
      JsonObject var1 = new JsonObject();
      for (Object o : this.collectMods()) {
         Mod var3 = (Mod) o;
         if (var3.getState()) {
            var1.addProperty(var3.getName(), var3.getState());
         }
      }

      return var1;
   }
}
