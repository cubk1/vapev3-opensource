package gg.vape.ui.click.frame.impl.profile;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import func.skidline.NumberData;
import func.skidline.c5711;
import gg.vape.Vape;
import gg.vape.config.PublicProfile;
import gg.vape.manager.FrameManager;
import gg.vape.module.Mod;
import gg.vape.module.blatant.HitBoxes;
import gg.vape.module.blatant.KillAura;
import gg.vape.module.combat.*;
import gg.vape.module.utility.Refill;
import gg.vape.module.utility.Throwpot;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.frame.ButtonGroup;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.component.value.BooleanComponent;
import gg.vape.ui.click.component.value.NumberComponent;
import gg.vape.ui.click.component.value.RandomComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.unmap.SliderInFrame;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.value.BooleanValue;
import gg.vape.value.NumberValue;
import gg.vape.value.RandomValue;
import gg.vape.value.Value;
import pub.nextsense.Tweaker;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FrameViewer extends Frame {
   public FrameComponent c7855;
   public SliderInFrame c6142;
   public final IntractiveComponent c7480;
   public PublicProfile c1819;
   public final Mod[] mods;
   public final boolean[] modStates;

   public FrameViewer() {
      super("viewer", false);
      this.c7480 = new IntractiveComponent("Profile preview", RenderFlag.Centered, 0.7);
      this.mods = new Mod[]{Vape.instance.getModManager().getMod(AutoClicker.class), Vape.instance.getModManager().getMod(AimAssist.class), Vape.instance.getModManager().getMod(Reach.class), Vape.instance.getModManager().getMod(Velocity.class), Vape.instance.getModManager().getMod(WTap.class), Vape.instance.getModManager().getMod(Throwpot.class), Vape.instance.getModManager().getMod(Refill.class), Vape.instance.getModManager().getMod(HitBoxes.class), Vape.instance.getModManager().getMod(KillAura.class)};
      this.modStates = new boolean[this.mods.length];
      this.getFramePage().onRendererHandling(new c5711(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      this.c270();
      this.setWidth(90.0);
      this.onOffset(200.0);
      this.addAction(_$->{});
   }


   public void c270() {
      this.c7855 = new FrameComponent(false);
      this.c7855.onRendererHandling(new c5711(0.0, 0.0, 5000, 1, new PoseMatrix(0, 2, 0, 0)));
      this.addGuiComponent(this.c7855);
      this.c7480.setWidth(65.0);
      this.c7480.onOffset(12.0);
      this.c7855.addComponent(this.c7480);
      this.c6142 = new SliderInFrame(false);
      this.c6142.setWidth(80.0);
      this.c6142.onOffset(210.0);
      this.addGuiComponent(this.c6142);
   }

   public void draw() {
      this.setDisplayable(this.c1819 != null);
      this.setDragState(false);
      this.setCloseStatus(false);
      this.c3488().setDisplayable(false);
      this.c1042(FrameManager.c3462.getX() - this.getWidth());
      this.c467(FrameManager.c3462.getY());
      this.c6142.onOffset(198.0);
      super.draw();
   }

   public void render(boolean flag) {
      super.render(false);
   }

   public void getProfile(PublicProfile var1) {
      this.c1819 = var1;
      if (var1 != null) {
         this.c6142.c6047().c756();
         this.c7480.setName(var1.c1754());
         String var2 = Tweaker.post("/config/pub/get.individual.php", "profile_id=" + var1.c208().toString() + "&owns=0");//post??
         if (var2.length() != 0) {
            JsonReader var3 = new JsonReader(new StringReader(var2));
            var3.setLenient(true);
            JsonElement var4 = (new Gson()).fromJson(var3, JsonElement.class);
            if (var4 != null && !var4.isJsonNull() && var4.isJsonArray()) {
               JsonArray var5 = var4.getAsJsonArray();
               if (var5.size() != 0) {
                  JsonObject var6 = var5.get(0).getAsJsonObject();
                  this.renderModsByJson(var6);
               }
            }
         }
      }
   }

   public void renderModsByJson(JsonObject var1) {
      JsonObject data = var1.get("data").getAsJsonObject();
      JsonArray modules = data.get("modules").getAsJsonArray();
      int index = 0;

      for (Mod mod : this.mods) {
         try {
            Iterator<JsonElement> var9 = modules.iterator();

            while (var9.hasNext()) {
               try {
                  JsonElement jsonElement = var9.next();
                  JsonObject jsonObject = jsonElement.getAsJsonObject();
                  String var12 = jsonObject.get("name").getAsString();
                  if (var12.equals(mod.getName())) {
                     this.renderMod(mod, jsonObject.get("values").getAsJsonArray(), index);
                  }
               } catch (Exception var13) {
               }
            }
         } catch (Exception var14) {
         }

         ++index;
      }

   }

   public void renderMod(Mod mod, JsonArray jsonArray, int index) {
      FrameComponent framec = new FrameComponent(false);
      framec.setColor(hoveringColor);
      framec.c7363(false);
      framec.onRendererHandling(new c5711(0.0, 4.0, 5000, 1, new PoseMatrix(0, 2, 0, 2)));
      framec.onOffset(15.0);
      framec.setWidth(80.0);
      FrameComponent framc2 = new FrameComponent(false);
      framc2.onRendererHandling(new c5711(0.0, 4.0, 5000, 1, new PoseMatrix(1, 0, 1, 0)));
      framc2.setWidth(80.0);
      framc2.onOffset(15.0);
      ArrayList var6 = new ArrayList();
      ArrayList<GuiComponent> components = new ArrayList<>();
      Iterator var8 = jsonArray.iterator();

      while(true) {
         JsonObject var10;
         String var11;
         do {
            if (!var8.hasNext()) {
               ModUnion modU = new ModUnion(index, mod.getName(), components);
               if (this.modStates[index]) {
                  modU.toggle();
               }

               modU.Frame().c8923(true);
               modU.expandBn().c8923(true);
               modU.setWidth(80.0);
               modU.onOffset(12.0);
               framec.addComponent(modU);
               framc2.addComponent(framec);
               this.c6142.c8120(framc2);
               return;
            }

            JsonElement var9 = (JsonElement)var8.next();
            var10 = var9.getAsJsonObject();
            var11 = var10.get("id").getAsString();
         } while(var6.contains(var11));

         for (Value<?, ?> value : mod.getValues()) {
            if (value.getParent() == null && var11.equals(value.getID())) {
               this.renderValue(components, value, var10, jsonArray);
               break;
            }
         }

         var6.add(var11);
      }
   }

   class ModUnion extends ButtonGroup {
      int c5616;

      public ModUnion(int var1, String var2, List var3) {
         super(var2, var3);
         this.c5616 = var1;
      }

      public void toggle() {
         this.expandBn().getClickEvent().onClick(0, 0, 0);
         FrameViewer.c101(FrameManager.c6371)[this.c5616] = !this.isClosed();
      }

      public boolean c2346() {
         return false;
      }

      public void c8121(boolean var1) {
      }
   }

   public void renderValue(List<GuiComponent> var1, Value<?,?> renderingValue, JsonObject var3, JsonArray var4) {
      double var6;
      if (renderingValue instanceof RandomValue) {
         RandomValue var5 = (RandomValue)renderingValue;
         var6 = var3.get("minimum").getAsDouble();
         double var8 = var3.get("maximum").getAsDouble();
         RandomComponent c = new RandomComponent(((RandomComponent)var5.getComponent()).c3425(), ((RandomComponent)var5.getComponent()).c5358(), "#.#", "", var5.getName());
         c.setColor(Vape.instance.getSettings().guiColor.getAsColor());
         c.c4983(true);
         RandomValue var11 = new RandomValue(null, renderingValue.getID(), c);
         var11.setValue(new NumberData[]{new NumberData(var6), new NumberData(var8)});
         c.c8376(var11);
         c.c8030(var6);
         c.c7591(var8);
         c.setWidth(78.0);
         c.onOffset(7.0);
         var1.add(c);
      }

      if (renderingValue instanceof NumberValue) {
         NumberValue var15 = (NumberValue)renderingValue;
         var6 = var3.get("value").getAsDouble();
         NumberComponent var18 = new NumberComponent(((NumberComponent)var15.getComponent()).c858(), ((NumberComponent)var15.getComponent()).c5846(), "#.#", "", var15.getName());
         var18.setColor(Vape.instance.getSettings().guiColor.getAsColor());
         var18.c4983(true);
         NumberValue var9 = new NumberValue(null, renderingValue.getName(), var18);
         var9.setValue(var6);
         var18.c8376(var9);
         var18.c8030(var6);
         var18.setWidth(78.0);
         var18.onOffset(7.0);
         var1.add(var18);
      }

      if (renderingValue instanceof BooleanValue) {
         BooleanValue var16 = (BooleanValue)renderingValue;
         boolean var17 = var3.get("value").getAsBoolean();
         BooleanComponent var7 = new BooleanComponent(renderingValue.getName(), 10.0);
         var7.c4983(true);
         var7.setColor(Vape.instance.getSettings().guiColor.getAsColor());
         BooleanValue var19 = new BooleanValue(null, renderingValue.getName(), var7);
         var19.setValue(var17);
         var7.c8376(var19);
         var7.onOffset(10.0);
         var1.add(var7);
         if (var17) {

            for (Value<?, ?> value : var16.getLimits()) {

               for (JsonElement var12 : var4) {
                  JsonObject var13 = var12.getAsJsonObject();
                  String var14 = var13.get("id").getAsString();
                  if (var14.equals(value.getID())) {
                     this.renderValue(var1, value, var13, var4);
                  }
               }
            }
         }
      }

   }

   public PublicProfile c952() {
      return this.c1819;
   }

   // $FF: synthetic method
   static boolean[] c101(FrameViewer var0) {
      return var0.modStates;
   }
}
