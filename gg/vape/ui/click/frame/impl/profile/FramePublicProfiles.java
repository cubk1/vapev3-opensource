package gg.vape.ui.click.frame.impl.profile;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import func.skidline.c5711;
import gg.vape.config.PublicProfile;
import gg.vape.manager.FrameManager;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.ExpandableButton;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.component.value.TextComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.ScaledResolution;
import pub.nextsense.Tweaker;

import java.awt.*;
import java.io.StringReader;
import java.util.List;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FramePublicProfiles extends Frame {
   public final FrameComponent c7590;
   public final FrameComponent c1362;
   public final FrameComponent c5059;
   public final FrameComponent c5309;
   public final List c3260 = new ArrayList();
   public final AtomicInteger c8293 = new AtomicInteger(0);
   public final AtomicInteger c1845 = new AtomicInteger(0);

   class c2717 extends TextComponent {
      // $FF: synthetic field
      final SquareButton c8845;
      // $FF: synthetic field
      final FramePublicProfiles c6938;

      c2717(FramePublicProfiles var1, int var2, SquareButton var3) {
         super(var2);
         this.c6938 = var1;
         this.c8845 = var3;
      }

      public boolean c3210(char var1, int var2) {
         if (var2 == 28) {
            this.c8845.getClickEvent().onClick(0, 0, 0);
            return true;
         } else {
            return super.c3210(var1, var2);
         }
      }
   }

   public FramePublicProfiles() {
      super("Public Profiles", false);
      this.getFramePage().onRendererHandling(new c5711(0.0, 5.0, 5000, 1, new PoseMatrix(0, 5, 0, 5)));
      this.getFramePage().onOffset(210.0);
      ((c5711)this.getFramePage().getParent()).c2598();
      this.setWidth(400.0);
      this.onOffset(20.0);
      double var1 = this.getWidth() * 0.3 + 5.0;
      FrameComponent var3 = new FrameComponent(false);
      var3.setWidth(this.getWidth());
      var3.onOffset(20.0);
      var3.onRendererHandling(new c5711(2.0, 0.0, 5000, 3, new PoseMatrix(2, 0, 0, 0)));
      IntractiveComponent var4 = new IntractiveComponent("Public Profiles", RenderFlag.Regular, 1.5);
      var4.setWidth(128.0);
      var4.onOffset(20.0);
      var4.c7363(false);
      var3.addComponent(var4);
      ExpandableButton var5 = new ExpandableButton("magnify", 0.35F, 6.0F, 0.0F, true);
      c2717 var6 = new c2717(this, 32, var5);
      var6.c7057("Profile Name/UUID");
      var6.setWidth(232.0);
      var6.onOffset(12.0);
      var6.c7363(false);
      var3.addComponent(var6);
      var5.setWidth(25.0);
      var5.onOffset(12.0);
      var5.getGuiButton().c7363(false);
      var5.addAction(new c7158(this, var6));
      var3.addComponent(var5);
      this.getFramePage().addComponent(var3);
      this.c7590 = new FrameComponent(false);
      this.c7590.setWidth(this.getWidth());
      this.c7590.c7363(false);
      this.c7590.onRendererHandling(new c5711(0.0, 5.0, 5000, 1, new PoseMatrix(5, 0, 0, 0)));
      this.getFramePage().addComponent(this.c7590);
      this.c1362 = new FrameComponent(false);
      this.c1362.setWidth(this.getWidth());
      this.c1362.c7363(false);
      this.c1362.setDisplayable(false);
      this.c1362.onRendererHandling(new c5711(0.0, 5.0, 5000, 1, new PoseMatrix(5, 0, 0, 0)));
      this.getFramePage().addComponent(this.c1362);
      this.c5309 = new FrameComponent(false);
      this.c5309.setDisplayable(true);
      this.c5059 = new FrameComponent(false);
      this.c5059.setDisplayable(false);
      FrameComponent var7 = new FrameComponent(false);
      var7.onRendererHandling(new c5711(0.0, 0.0, 5000, 1, new PoseMatrix(0, (int)this.getWidth() / 3, 0, 0)));
      var7.setWidth(this.getWidth());
      var7.onOffset(20.0);
      var7.addComponent(this.c5309);
      var7.addComponent(this.c5059);
      this.getFramePage().addComponent(var7);
   }
   class c7158 implements IButtonOnClick {
      // $FF: synthetic field
      final TextComponent c8671;
      // $FF: synthetic field
      final FramePublicProfiles c2904;

      c7158(FramePublicProfiles var1, TextComponent var2) {
         this.c2904 = var1;
         this.c8671 = var2;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (this.c8671.c8589().getName().length() > 0) {
            ArrayList var4 = new ArrayList(FramePublicProfiles.c7863(this.c2904));
            Iterator var5 = var4.iterator();

            while(var5.hasNext()) {
               PublicProfile var6 = (PublicProfile)var5.next();
               String var7 = this.c8671.c8589().getName().toLowerCase();
               if (!var6.c1754().toLowerCase().contains(var7) && !var6.c208().toString().toLowerCase().contains(var7)) {
                  var5.remove();
               }
            }

            if (var4.isEmpty()) {
               FramePublicProfiles.c125(this.c2904).setDisplayable(false);
               FramePublicProfiles.c1905(this.c2904).setDisplayable(false);
               FramePublicProfiles.c3615(this.c2904).setDisplayable(false);
               FramePublicProfiles.c2353(this.c2904).setDisplayable(false);
            } else {
               FramePublicProfiles.c635(this.c2904, var4, FramePublicProfiles.c3615(this.c2904), FramePublicProfiles.c2353(this.c2904));
               FramePublicProfiles.c125(this.c2904).setDisplayable(false);
               FramePublicProfiles.c1905(this.c2904).setDisplayable(false);
               FramePublicProfiles.c3615(this.c2904).setDisplayable(true);
               FramePublicProfiles.c2353(this.c2904).setDisplayable(true);
            }
         } else {
            FramePublicProfiles.c125(this.c2904).setDisplayable(true);
            FramePublicProfiles.c1905(this.c2904).setDisplayable(true);
            FramePublicProfiles.c3615(this.c2904).setDisplayable(false);
            FramePublicProfiles.c2353(this.c2904).setDisplayable(false);
         }

      }
   }
   public void renderFrame() {
      this.c117(this.c3260, this.c7590, this.c5309);
      this.c117(this.c3260, this.c1362, this.c5059);
   }

   public void c117(List var1, FrameComponent var2, FrameComponent var3) {
      var2.setWidth(this.getWidth());
      var2.onOffset(185.0);
      var2.onRendererHandling(new c5711(0.0, 5.0, 5000, 1, new PoseMatrix(5, 0, 0, 0)));
      var3.onRendererHandling(new c5711(0.0, 0.0, 5000, 7, new PoseMatrix(0, 0, 0, 0)));
      var3.setWidth(this.getWidth() / 3.0);
      var3.onOffset(20.0);
      var2.getComponents().clear();
      var2.draw();
      var3.getComponents().clear();
      var3.draw();
      double var4 = this.getWidth() * 0.3;
      if (var1 != null && !var1.isEmpty()) {
         FrameComponent var6 = null;
         Iterator var7 = var1.iterator();

         while(var7.hasNext()) {
            PublicProfile var8 = (PublicProfile)var7.next();
            if (var6 == null || var6.getComponents().size() >= 9) {
               var6 = new FrameComponent(false);
               var6.setWidth(var2.getWidth());
               var6.onOffset(160.0);
               var6.onRendererHandling(new c5711(5.0, 5.0, 5000, 3, new PoseMatrix(0, 0, 0, 0)));
               ((c5711)var6.getParent()).c2598();
               var6.setDisplayable(false);
               var2.addComponent(var6);
            }

            FrameProfilesExplorer var9 = new FrameProfilesExplorer(var8, var4);
            var6.addComponent(var9);
            var6.draw();
            var6.getParent().c8084();
         }

         AtomicInteger var12 = new AtomicInteger(0);
         ArrayList var13 = new ArrayList();

         SquareButton var10;
         for(int var14 = 0; var14 < var2.getComponents().size(); ++var14) {
            var10 = new SquareButton(var14 + 1 + "", false);
            var13.add(var10);
            var10.addAction(new c5909(this, var13, var10, var2, var12, var14));
            var10.setWidth(20.0);
            var10.onOffset(20.0);
            var3.addComponent(var10);
            if (var14 >= 5) {
               var10.setDisplayable(false);
            }
         }

         AtomicInteger var15 = var3 == this.c1362 ? this.c1845 : this.c8293;
         var15.set(0);
         if (var13.size() >= 5) {
            var10 = new SquareButton("<", false);
            var10.setWidth(20.0);
            var10.onOffset(20.0);
            var10.setParent(var3);
            var10.addAction(new c4613(this, var10, var13));
            var10.addAction(new c7116(this, var13, var15));
            var3.getComponents().add(0, var10);
            SquareButton var11 = new SquareButton(">", false);
            var11.setWidth(20.0);
            var11.onOffset(20.0);
            var11.addAction(new c3355(this, var11, var15, var13));
            var11.addAction(new c7348(this, var15, var13));
            var3.addComponent(var11);
            var3.addAction(new c6171(this, var13, var10, var11));
         }

         if (!var13.isEmpty()) {
            ((SquareButton)var13.get(0)).getClickEvent().onClick(0, 0, 0);
         }

      }
   }
   class c6171 implements IGuiCallback {
      // $FF: synthetic field
      final List c7182;
      // $FF: synthetic field
      final SquareButton c5020;
      // $FF: synthetic field
      final SquareButton c902;
      // $FF: synthetic field
      final FramePublicProfiles c501;

      c6171(FramePublicProfiles var1, List var2, SquareButton var3, SquareButton var4) {
         this.c501 = var1;
         this.c7182 = var2;
         this.c5020 = var3;
         this.c902 = var4;
      }

      public void call(IGuiComponent inst) {
         SquareButton var2 = null;
         Iterator var3 = this.c7182.iterator();

         while(var3.hasNext()) {
            SquareButton var4 = (SquareButton)var3.next();
            if (var4.getGuiButton().c399()) {
               var2 = var4;
               break;
            }
         }

         if (var2 != null) {
            String var6 = var2.getGuiButton().getName();
            int var7 = this.c7182.size();
            String var5 = var6 + "/" + var7;
            this.c5020.setText(var5);
            this.c5020.getGuiButton().setText(var5);
            this.c902.setText(var5);
            this.c902.getGuiButton().setText(var5);
         }
      }
   }

   class c7348 implements IButtonOnClick {
      // $FF: synthetic field
      final AtomicInteger c1246;
      // $FF: synthetic field
      final List c6699;
      // $FF: synthetic field
      final FramePublicProfiles c680;

      c7348(FramePublicProfiles var1, AtomicInteger var2, List var3) {
         this.c680 = var1;
         this.c1246 = var2;
         this.c6699 = var3;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (this.c1246.get() + 4 < this.c6699.size() - 1) {
            SquareButton var4 = null;
            Iterator var5 = this.c6699.iterator();

            while(var5.hasNext()) {
               SquareButton var6 = (SquareButton)var5.next();
               if (var6.displayable()) {
                  var4 = var6;
                  break;
               }
            }

            if (var4 != null) {
               int var7 = Integer.parseInt(var4.getGuiButton().getName());
               this.c1246.set(var7);
               var4.setDisplayable(false);
               ((SquareButton)this.c6699.get(this.c1246.get() + 4)).setDisplayable(true);
            }
         }
      }
   }

   class c3355 implements IGuiCallback {
      // $FF: synthetic field
      final SquareButton c3971;
      // $FF: synthetic field
      final AtomicInteger c1131;
      // $FF: synthetic field
      final List c3015;
      // $FF: synthetic field
      final FramePublicProfiles c6983;

      c3355(FramePublicProfiles var1, SquareButton var2, AtomicInteger var3, List var4) {
         this.c6983 = var1;
         this.c3971 = var2;
         this.c1131 = var3;
         this.c3015 = var4;
      }

      public void call(IGuiComponent inst) {
         this.c3971.getGuiButton().c7363(this.c1131.get() + 4 < this.c3015.size() - 1);
         this.c3971.c8923(this.c3971.getGuiButton().c399());
         if (!this.c3971.getGuiButton().c399()) {
            this.c3971.getGuiButton().setColor(Color.WHITE);
         }

      }
   }

   class c7116 implements IButtonOnClick {
      // $FF: synthetic field
      final List c2672;
      // $FF: synthetic field
      final AtomicInteger c6779;
      // $FF: synthetic field
      final FramePublicProfiles c428;

      c7116(FramePublicProfiles var1, List var2, AtomicInteger var3) {
         this.c428 = var1;
         this.c2672 = var2;
         this.c6779 = var3;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (!((SquareButton)this.c2672.get(0)).displayable()) {
            SquareButton var4 = null;

            for(int var5 = this.c2672.size() - 1; var5 > 0; --var5) {
               SquareButton var6 = (SquareButton)this.c2672.get(var5);
               if (var6.displayable()) {
                  var4 = var6;
                  break;
               }
            }

            SquareButton var9 = null;
            Iterator var10 = this.c2672.iterator();

            while(var10.hasNext()) {
               SquareButton var7 = (SquareButton)var10.next();
               if (var7.displayable()) {
                  int var8 = this.c2672.indexOf(var7);
                  var9 = (SquareButton)this.c2672.get(var8 - 1);
                  break;
               }
            }

            if (var4 != null && var9 != null) {
               int var11 = Integer.parseInt(var9.getGuiButton().getName());
               this.c6779.set(var11 - 1);
               var4.setDisplayable(false);
               var9.setDisplayable(true);
            }
         }
      }
   }

   class c4613 implements IGuiCallback {
      // $FF: synthetic field
      final SquareButton c6682;
      // $FF: synthetic field
      final List c3017;
      // $FF: synthetic field
      final FramePublicProfiles c1167;

      c4613(FramePublicProfiles var1, SquareButton var2, List var3) {
         this.c1167 = var1;
         this.c6682 = var2;
         this.c3017 = var3;
      }

      public void call(IGuiComponent inst) {
         this.c6682.getGuiButton().c7363(!((SquareButton)this.c3017.get(0)).displayable());
         this.c6682.c8923(this.c6682.getGuiButton().c399());
         if (!this.c6682.getGuiButton().c399()) {
            this.c6682.getGuiButton().setColor(Color.WHITE);
         }

      }
   }

   class c5909 implements IButtonOnClick {
      // $FF: synthetic field
      final List c2135;
      // $FF: synthetic field
      final SquareButton c8302;
      // $FF: synthetic field
      final FrameComponent c5298;
      // $FF: synthetic field
      final AtomicInteger c870;
      // $FF: synthetic field
      final int c6150;
      // $FF: synthetic field
      final FramePublicProfiles c2517;

      c5909(FramePublicProfiles var1, List var2, SquareButton var3, FrameComponent var4, AtomicInteger var5, int var6) {
         this.c2517 = var1;
         this.c2135 = var2;
         this.c8302 = var3;
         this.c5298 = var4;
         this.c870 = var5;
         this.c6150 = var6;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         Iterator var4 = this.c2135.iterator();

         while(var4.hasNext()) {
            SquareButton var5 = (SquareButton)var4.next();
            if (var5 == this.c8302) {
               var5.getGuiButton().c7363(true);
               var5.c8923(true);
            } else {
               var5.getGuiButton().c7363(false);
               var5.getGuiButton().setColor(Color.WHITE);
               var5.c8923(false);
            }
         }

         this.c5298.getComponents().get(this.c870.get()).setDisplayable(false);
         this.c5298.getComponents().get(this.c6150).setDisplayable(true);
         this.c5298.getParent().c8084();
         this.c870.set(this.c6150);
      }
   }

   public void draw() {
      this.setDragState(false);
      this.setCloseStatus(false);
      this.c3488().setDisplayable(false);
      ScaledResolution var1 = Minecraft.c4912();
      this.c1042((double)(var1.getScaledWidth() / 2) - this.getWidth() / 2.0 - FrameManager.c1600.getWidth() / 2.0);
      this.c467((double)(var1.getScaledHeight() / 2) - this.getHeight() / 2.0);
      super.draw();
   }

   public void render(boolean flag) {
      super.render(false);
   }

   public void c270() {
      String var1 = Tweaker.post("/config/pub/get.all.php", "");
      if (var1.length() == 0) {
         this.c3260.clear();
         this.c7590.getComponents().clear();
         IntractiveComponent var11 = new IntractiveComponent("Failed to load profiles", RenderFlag.Regular, 1.0);
         var11.setColor(Color.RED);
         this.c7590.addComponent(var11);
      } else {
         try {
            JsonReader var2 = new JsonReader(new StringReader(var1));
            var2.setLenient(true);
            JsonElement var3 = (new Gson()).fromJson(var2, JsonElement.class);
            if (var3 == null || var3.isJsonNull() || !var3.isJsonArray()) {
               this.setDisplayable(false);
               return;
            }

            this.c3260.clear();
            JsonArray var4 = var3.getAsJsonArray();
            ArrayList var5 = new ArrayList();
            Iterator var6 = var4.iterator();

            while(var6.hasNext()) {
               JsonElement var7 = (JsonElement)var6.next();
               if (var7.isJsonObject()) {
                  try {
                     PublicProfile var8 = new PublicProfile("", "");
                     var8.c8870(var7.getAsJsonObject());
                     var5.add(var8);
                  } catch (Exception var9) {
                  }
               }
            }

            var5.sort(new c7128(this));
            var6 = var5.iterator();

            while(var6.hasNext()) {
               PublicProfile var12 = (PublicProfile)var6.next();
               this.c3260.add(var12);
            }

            this.c117(this.c3260, this.c7590, this.c5309);
         } catch (Exception var10) {
            var10.printStackTrace();
            System.out.println(var1);
         }

      }
   }
   class c7128 implements Comparator {
      // $FF: synthetic field
      final FramePublicProfiles c3892;

      c7128(FramePublicProfiles var1) {
         this.c3892 = var1;
      }

      public int c4234(PublicProfile var1, PublicProfile var2) {
         if (var1.c8382() == var2.c8382()) {
            return 0;
         } else {
            return var1.c8382() > var2.c8382() ? -1 : 1;
         }
      }

      // $FF: synthetic method
      public int compare(Object var1, Object var2) {
         return this.c4234((PublicProfile)var1, (PublicProfile)var2);
      }
   }

   public List c8255() {
      return this.c3260;
   }

   public void c7575(UUID var1) {
      Iterator var2 = this.c3260.iterator();

      while(var2.hasNext()) {
         PublicProfile var3 = (PublicProfile)var2.next();
         if (var3.c208().toString().equalsIgnoreCase(var1.toString())) {
            var2.remove();
         }
      }

   }

   // $FF: synthetic method
   static List c7863(FramePublicProfiles var0) {
      return var0.c3260;
   }

   // $FF: synthetic method
   static FrameComponent c125(FramePublicProfiles var0) {
      return var0.c7590;
   }

   // $FF: synthetic method
   static FrameComponent c1905(FramePublicProfiles var0) {
      return var0.c5309;
   }

   // $FF: synthetic method
   static FrameComponent c3615(FramePublicProfiles var0) {
      return var0.c1362;
   }

   // $FF: synthetic method
   static FrameComponent c2353(FramePublicProfiles var0) {
      return var0.c5059;
   }

   // $FF: synthetic method
   static void c635(FramePublicProfiles var0, List var1, FrameComponent var2, FrameComponent var3) {
      var0.c117(var1, var2, var3);
   }
}
