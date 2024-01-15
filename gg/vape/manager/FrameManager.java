package gg.vape.manager;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gg.vape.Vape;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.actions.ActionSetFrameDisplayable;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.impl.*;
import gg.vape.ui.click.frame.impl.profile.FrameProfiles;
import gg.vape.ui.click.frame.impl.profile.FramePublicProfiles;
import gg.vape.ui.click.frame.impl.profile.FramePublicPublishProfiles;
import gg.vape.ui.click.frame.impl.profile.FrameViewer;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class FrameManager {
   public static FrameGUI frameGUI;
   public static FrameFriends frameFriends;
   public static FrameProfiles frameProfiles;
   public static FrameMacros frameMacros;
   public static FrameSearch frameSearch;
   public static FramePublicProfiles c3462 = new FramePublicProfiles();
   public static FramePublicPublishProfiles c1600 = new FramePublicPublishProfiles();
   public static FrameViewer c6371 = new FrameViewer();
   public static FrameFilter frameFilter;
   //public static iReSqtkUVgNruiReSqtkUVg c7676;
   public static FrameTextGUI textGui;
   public static FrameSettings frameSettings;
   public final List<Frame> c3768 = new CopyOnWriteArrayList<>();

   public static void c5483() {
      frameGUI = null;
      frameFriends = null;
      frameProfiles = null;
      frameMacros = null;
      frameSearch = null;
      c3462 = null;
      c1600 = null;
      c6371 = null;
      textGui = null;
      frameSettings = null;
   }

   public void c8674() {//init?
      List<Category> var1 = Category.values();
      var1.sort(Comparator.comparing(Category::getName));//c2010
      this.getFrames().clear();
      this.getFrames().add(textGui = new FrameTextGUI());
      Iterator<Category> var2 = var1.iterator();

      while(true) {
         Category category;
         do {
            if (!var2.hasNext()) {//todo
               this.getFrames().add(frameSettings = new FrameSettings());
               this.getFrames().add(frameFriends = new FrameFriends());
               this.getFrames().add(frameFilter = new FrameFilter());
               this.getFrames().add(frameSearch = new FrameSearch());
               this.getFrames().add(frameProfiles = new FrameProfiles());
               this.getFrames().add(frameMacros = new FrameMacros());
               this.getFrames().add(new FrameDuelInfo());
               this.getFrames().add(frameGUI = new FrameGUI());
               this.getFrames().add(new FrameEdit());
               this.getFrames().sort(Comparator.comparing(Frame::getName));

               for (Frame frame : this.getFrames()) {
                  if (frame.loadRenderer()) {//todo
                     frameGUI.getFramePage().addComponent(frame.c4907());
                  }
               }

               c1600.addAction(new ActionSetFrameDisplayable(this));
               this.c4309();
               return;
            }

            category = var2.next();
         } while(category.equals(Category.None));

         FrameCategory var4 = new FrameCategory(category);
         ArrayList<Mod> modsArr = new ArrayList<>(Vape.instance.getModManager().collectMods());
         Collections.sort(modsArr, Comparator.comparing(Mod::getName));//c2010

         for (Mod mod : modsArr) {
            if (mod.getCategory() == category) {
               var4.c1458(mod);
            }
         }

         var4.c270();
         if (var4.getFramePage().getComponents().size() > 0) {
            this.getFrames().add(var4);
         }
      }
   }

   public void c4309() {
      int var1 = 0;
      Iterator var2 = this.getFrames().iterator();

      while(var2.hasNext()) {
         Frame var3 = (Frame)var2.next();
         if (!var3.equals(frameGUI)) {
            var3.setDisplayable(false);
            var3.setCloseStatus(true);
            var3.c1042(20.0);
            var1 += 20;
            var3.c467(var1);
         } else {
            var3.setDisplayable(true);
            var3.setCloseStatus(false);
            var3.c1042(100.0);
            var3.c467(20.0);
         }
      }

      ClickGui.c6033(null);
   }

   public Frame c48(String var1) {
      Iterator var2 = this.getFrames().iterator();

      Frame var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (Frame)var2.next();
      } while(!var3.c7694().getName().equalsIgnoreCase(var1));

      return var3;
   }

   public List<Frame> getFrames() {
      return this.c3768;
   }

   public void loadFrames(JsonArray var1) {
      if (var1.size() != 0) {
         var1 = var1.get(0).getAsJsonArray();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            try {
               JsonElement var3 = var1.get(var2);
               if (var3.isJsonObject() && !var3.isJsonNull()) {
                  JsonObject var4 = var3.getAsJsonObject();
                  if (var4.get("title") != null && !var4.get("title").isJsonNull()) {
                     Frame var5 = this.c48(var4.get("title").getAsString());
                     if (var5 != null) {
                        var5.c3055(var4);
                     }
                  }
               }
            } catch (Exception var6) {
            }
         }

      }
   }

   public JsonArray toJson() {
      JsonArray var1 = new JsonArray();

      for (Frame var3 : this.getFrames()) {
         var1.add(var3.c2868());
      }

      return var1;
   }
}
