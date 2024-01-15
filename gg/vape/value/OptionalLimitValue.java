package gg.vape.value;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.NameInputComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.click.frame.impl.FrameItemLimitList;
import gg.vape.ui.unmap.SliderInFrame;
import gg.vape.ui.unmap.exButton;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;

import java.awt.*;
import java.util.List;
import java.util.*;

public class OptionalLimitValue extends Value<List<FrameItemLimitList>, exButton> {
   public static final Color c2432 = new Color(0, 170, 0);
   public static final Color c252 = new Color(170, 170, 170);
   public static final Color c5521 = new Color(170, 0, 0);
   public final Color c4905;
   protected SliderInFrame c4450;
   public final List<FrameItemLimitList> c1139 = new ArrayList<>();
   public final HashMap c4645 = new HashMap();

   public OptionalLimitValue(Object var1, String var2, Color var3, exButton var4) {
      super(var1, var2, var4);
      this.c4905 = var3;
   }

   public static OptionalLimitValue c5397(Object var0, String var1, String var2, Color var3, String... var4) {
      return c4993(var0, var1, var2, var3, Arrays.asList(var4));
   }

   public static OptionalLimitValue c4993(Object var0, String var1, String var2, Color var3, List var4) {
      exButton var5 = new exButton(var2, null);
      var5.onOffset(10.0);
      OptionalLimitValue var6 = new OptionalLimitValue(var0, var1, var3, var5);
      var5.c8376(var6);
      c3361(var5, var6);
      Iterator var7 = var4.iterator();

      while(var7.hasNext()) {
         String var8 = (String)var7.next();
         var6.c3429(var8);
      }

      var6.c2026(new ArrayList(var6.getValue()));
      return var6;
   }

   public static void c3361(exButton var0, OptionalLimitValue var1) {
      FrameComponent var2 = new FrameComponent(true);
      var2.c7363(false);
      var2.setColor(GuiComponent.hoveringColor);
      var2.onRendererHandling(new PoseRenderer(0.0, 1.0, 5000, 1, new PoseMatrix(0, 2, 2, 2)));
      var2.setWidth(118.0);
      var2.setDisplayable(true);
      var0.c2207(var2);
      var2.setParent(var0);
      IntractiveComponent var3 = new IntractiveComponent(var0.getGuiButton().getName(), RenderFlag.Centered, 1.0);
      var3.setWidth(var2.getWidth());
      var3.onOffset(10.0);
      var3.setDisplayable(true);
      var2.addComponent(var3);
      NameInputComponent var4 = new NameInputComponent(64, var1);
      var4.c7057("<name>");
      var4.setWidth(var2.getWidth());
      var4.onOffset(12.0);
      var4.setDisplayable(true);
      var2.addComponent(var4);
      SliderInFrame var5 = new SliderInFrame(true);
      var1.c4450 = var5;
      var5.setColor(GuiComponent.l);
      var5.setWidth(var2.getWidth());
      var5.onOffset(60.0);
      var2.addComponent(var5);
      var2.c2888(var2.c740(), null);
   }

   public Color c5443() {
      return this.c4905;
   }

   public List<FrameItemLimitList> getValue() {
      return this.c1139;
   }

   public void setValue(List<FrameItemLimitList> var1) {
      ArrayList var2 = new ArrayList(this.c1139);
      this.c1139.clear();
      Iterator var3 = var2.iterator();

      FrameItemLimitList var4;
      while(var3.hasNext()) {
         var4 = (FrameItemLimitList)var3.next();
         this.c536(var4);
      }

      var3 = var1.iterator();

      while(var3.hasNext()) {
         var4 = (FrameItemLimitList)var3.next();
         this.c3429(var4.getName());
      }

   }

   public void parse(String var1) {
   }

   public FrameItemLimitList c3429(String var1) {
      FrameComponent var2 = new FrameComponent(false);
      var2.setWidth(95.0);
      var2.onRendererHandling(new PoseRenderer(1.0, 1.0, 2, 2, new PoseMatrix(0, 5, 0, 0)));
      FrameItemLimitList var3 = new FrameItemLimitList(var2, var1, this);
      this.getValue().add(var3);
      this.c4450.c8120(var2);
      this.c4645.put(var3, var2);
      return var3;
   }

   public void c536(FrameItemLimitList var1) {
      try {
         this.getValue().remove(var1);
      } catch (Exception var3) {
      }

      if (this.c4645.containsKey(var1)) {
         this.c4450.c6047().c4043((IGuiComponent)this.c4645.get(var1));
      }

   }

   public boolean loadJson(JsonObject var1) {
      if (!var1.get("id").getAsString().equalsIgnoreCase(this.getID())) {
         return super.loadJson(var1);
      } else {
         if (var1.get("value").isJsonArray()) {
            JsonArray var2 = var1.get("value").getAsJsonArray();
            ArrayList var3 = new ArrayList(this.getValue());
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               FrameItemLimitList var5 = (FrameItemLimitList)var4.next();
               this.c536(var5);
            }

            var4 = var2.iterator();

            while(var4.hasNext()) {
               JsonElement var8 = (JsonElement)var4.next();

               try {
                  FrameItemLimitList var6 = this.c3429("");
                  var6.c3055(var8.getAsJsonObject());
               } catch (Exception var7) {
               }
            }
         }

         return true;
      }
   }

   public JsonObject toJson() {
      JsonObject var1 = super.toJson();
      JsonArray var2 = new JsonArray();
      Iterator var3 = this.getValue().iterator();

      while(var3.hasNext()) {
         FrameItemLimitList var4 = (FrameItemLimitList)var3.next();
         var2.add(var4.toJson());
      }

      var1.add("value", var2);
      return var1;
   }

   public boolean c6984(String var1) {
      Iterator var2 = this.getValue().iterator();

      FrameItemLimitList var3;
      do {
         if (!var2.hasNext()) {
            return this.getValue().isEmpty();
         }

         var3 = (FrameItemLimitList)var2.next();
      } while(!var3.c2346() || !var3.getName().equalsIgnoreCase(var1));

      return true;
   }

}
