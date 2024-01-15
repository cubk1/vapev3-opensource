package gg.vape.manager.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gg.vape.Vape;
import gg.vape.config.Profile;
import gg.vape.config.PublicProfile;
import gg.vape.manager.FrameManager;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.value.NumberComponent;
import gg.vape.ui.click.component.value.RandomComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.value.RandomValue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class ProfilesManager {
   public final List c8203 = new ArrayList();
   public Profile c2589;

   public List c6161() {
      return this.c8203;
   }

   public Profile c5972(String var1) {
      Iterator var2 = this.c8203.iterator();

      Profile var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (Profile)var2.next();
      } while(!var3.c1754().equalsIgnoreCase(var1));

      return var3;
   }

   public Profile c6990(UUID var1) {
      Iterator var2 = this.c8203.iterator();

      Profile var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (Profile)var2.next();
      } while(!var3.c208().toString().equalsIgnoreCase(var1.toString()));

      return var3;
   }

   public Profile c7171() {
      if (this.c2589 == null || !this.c6161().contains(this.c2589)) {
         this.c2589 = (Profile)this.c6161().get(0);
         this.c2589.loadConfigs();
      }

      return this.c2589;
   }

   public void c4057(Profile var1) {
      this.c2589 = var1;
      this.c2589.loadConfigs();
   }

   public void c2321(Profile var1) {
      this.c8203.add(var1);
      FrameManager.frameProfiles.c7644(var1);
      FrameManager.c1600.c7644(var1);
   }

   public void c7522(Profile var1) {
      this.c8203.remove(var1);
      FrameManager.frameProfiles.c7057(var1.c1754());
      FrameManager.c1600.c3891(var1);
   }

   public void c6572() {
      this.c8203.clear();
      FrameManager.frameProfiles.c5996.c6047().getComponents().clear();
      FrameManager.c1600.c4033().c6047().getComponents().clear();
      FrameManager.c1600.c1360().c6047().getComponents().clear();
   }

   public void loadProfiles(JsonArray var1) {
      if (var1 != null) {
         this.c6572();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            try {
               JsonElement var3 = var1.get(var2);
               if (var3.isJsonObject() && !var3.isJsonNull()) {
                  JsonObject var4 = var3.getAsJsonObject();
                  Profile var5;
                  if (var4.get("public").getAsBoolean()) {
                     var5 = (new Profile("", "", true)).c8870(var4);
                  } else {
                     var5 = (new PublicProfile("", "")).c8870(var4);
                     if (var4.get("owns") != null && var4.get("owns").getAsBoolean()) {
                        ((PublicProfile)var5).c8121(true);
                     }
                  }

                  this.c2321(var5);
                  if (var2 == 0) {
                     this.c2589 = var5;
                     this.c2589.loadConfigs();
                  }
               }
            } catch (Exception var6) {
            }
         }
      }

      if (var1 == null || var1.size() == 0) {
         Profile var7 = new Profile("default", "3.25");
         var7.c5864();
         this.c2321(var7);
      }

   }

   public JsonArray toJson() {
      JsonArray var1 = new JsonArray();
      Iterator var2 = this.c6161().iterator();

      while(var2.hasNext()) {
         Profile var3 = (Profile)var2.next();
         var1.add(var3.c927());
      }

      return var1;
   }

   public int c3809() {
      int var1 = 0;
      Iterator var2 = this.c8203.iterator();

      while(var2.hasNext()) {
         Profile var3 = (Profile)var2.next();
         if (var3 instanceof PublicProfile && ((PublicProfile)var3).c2239()) {
            ++var1;
         }
      }

      return var1;
   }

   public void c4349(Profile var1) {
      if (this.c7171() != null) {
         this.c7171().c5864();
      }

      this.c4057(var1);
      Iterator var2 = Vape.instance.getFrameManager().getFrames().iterator();

      while(var2.hasNext()) {
         Frame var3 = (Frame)var2.next();
         Iterator var4 = var3.getFramePage().getComponents().iterator();

         while(var4.hasNext()) {
            IGuiComponent var5 = (IGuiComponent)var4.next();
            if (var5 instanceof GuiComponent) {
               this.c2960((GuiComponent)var5);
            }
         }
      }

      this.c4057(var1);
   }

   public void c2960(GuiComponent var1) {
      Iterator var2 = var1.getComponents().iterator();

      while(var2.hasNext()) {
         IGuiComponent var3 = (IGuiComponent)var2.next();
         if (var3 instanceof NumberComponent) {
            NumberComponent var4 = (NumberComponent)var3;
            if (var4.c5999() != null) {
               var4.c8030((Double)var4.c5999().getValue());
               var4.draw();
            }
         }

         if (var3 instanceof RandomComponent) {
            RandomComponent var6 = (RandomComponent)var3;
            if (var6.c5999() != null) {
               RandomValue var5 = (RandomValue)var6.c5999();
               var6.c8030(var5.c6465());
               var6.c7591(var5.c22());
               var6.draw();
            }
         }

         if (var3 instanceof GuiComponent) {
            this.c2960((GuiComponent)var3);
         }
      }

   }
}
