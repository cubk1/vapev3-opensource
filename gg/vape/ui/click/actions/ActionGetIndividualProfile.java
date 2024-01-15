package gg.vape.ui.click.actions;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import gg.vape.Vape;
import gg.vape.config.Profile;
import gg.vape.config.PublicProfile;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.frame.impl.profile.FrameProfilesExplorer;
import pub.nextsense.Tweaker;

import java.io.StringReader;

public class ActionGetIndividualProfile implements IButtonOnClick {
   // $FF: synthetic field
   final FrameProfilesExplorer c6293;

   public ActionGetIndividualProfile(FrameProfilesExplorer var1) {
      this.c6293 = var1;
   }

   public void onClick(int mouseX, int mouseY, int mouseBn) {
      Profile var4 = Vape.instance.getProfilesManager().c6990(FrameProfilesExplorer.c7230(this.c6293).c208());
      String var5 = Tweaker.post("/config/pub/get.individual.php", "profile_id=" + FrameProfilesExplorer.c7230(this.c6293).c208().toString() + "&owns=" + (var4 != null ? "1" : "0"));
      if (var5.length() != 0) {
         try {
            JsonReader var6 = new JsonReader(new StringReader(var5));
            var6.setLenient(true);
            JsonElement var7 = (new Gson()).fromJson(var6, JsonElement.class);
            if (var7 == null || var7.isJsonNull() || !var7.isJsonArray()) {
               return;
            }

            JsonArray var8 = var7.getAsJsonArray();
            if (var8.size() == 0) {
               return;
            }

            JsonObject var9 = var8.get(0).getAsJsonObject();
            if (var4 != null) {
               var4.c8870(var9);
            } else {
               PublicProfile var10 = new PublicProfile("", "");
               var10.c8870(var9);
               Vape.instance.getProfilesManager().c2321(var10);
            }
         } catch (Exception var11) {
            var11.printStackTrace();
         }

      }
   }
}
