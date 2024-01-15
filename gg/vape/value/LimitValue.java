package gg.vape.value;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.InputBox;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.component.value.NumberComponent;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.click.frame.impl.FrameLimitManager;
import gg.vape.ui.unmap.SliderInFrame;
import gg.vape.ui.unmap.exButton;
import gg.vape.unmap.ItemLimitData;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.wrapper.impl.ItemStack;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LimitValue extends Value<List<ItemLimitData>, exButton> {
   public static final Color allowed = new Color(0, 170, 0);
   public static final Color item = new Color(170, 170, 170);
   public static final Color blocked = new Color(170, 0, 0);
   public final Color c5185;
   protected SliderInFrame c7636;
   public List<ItemLimitData> c4221 = new ArrayList<>();
   public final int c5336;

   public LimitValue(Object var1, String var2, Color var3, int var4, exButton var5) {
      super(var1, var2, var5);
      this.c5185 = var3;
      this.c5336 = var4;
   }

   public static LimitValue create(Object var0, String var1, String var2, Color var3, List var4) {
      return c1915(var0, var1, var2, var3, -1, var4);
   }

   public static LimitValue create(Object var0, String var1, String var2, Color var3, ItemLimitData... var4) {
      return c1915(var0, var1, var2, var3, -1, Arrays.asList(var4));
   }

   public static LimitValue c1915(Object var0, String var1, String var2, Color var3, int var4, List var5) {
      exButton var6 = new exButton(var2, null);
      var6.onOffset(10.0);
      LimitValue var7 = new LimitValue(var0, var1, var3, var4, var6);
      var7.c2026(var5);
      var6.c8376(var7);
      c7387(var6, var7, var4 != -1);
      var7.c4221.addAll(var5);
      return var7;
   }

   public static void c7387(exButton var0, LimitValue var1, boolean var2) {
      FrameComponent var3 = new FrameComponent(true);
      var3.setText("Common item names: hand, swords, shovels, axes, pickaxes, blocks, slot[1-9]");
      var3.c7363(false);
      var3.setColor(GuiComponent.hoveringColor);
      var3.onRendererHandling(new PoseRenderer(0.0, 1.0, 5000, 1, new PoseMatrix(0, 2, 2, 2)));
      var3.setWidth(118.0);
      var3.setDisplayable(true);
      var0.c2207(var3);
      var3.setParent(var0);
      IntractiveComponent var4 = new IntractiveComponent(var0.getGuiButton().getName(), RenderFlag.Centered, 1.0);
      var4.setWidth(var3.getWidth());
      var4.onOffset(10.0);
      var4.setDisplayable(true);
      var3.addComponent(var4);
      NumberComponent var5 = new NumberComponent(10.0, 1.0, "", " stacks", "Allowed Stacks");
      var5.c8030(var1.c5848());
      var5.setWidth(var3.getWidth());
      var5.onOffset(8.0);
      if (var2) {
         var3.addComponent(var5);
      }

      InputBox var6 = new InputBox(64, var2, var1, var5);
      var6.c7057("<item name / id>");
      var6.setWidth(var3.getWidth());
      var6.onOffset(12.0);
      var6.setDisplayable(true);
      var3.addComponent(var6);
      SliderInFrame var7 = new SliderInFrame(true);
      var1.c7636 = var7;
      var7.setColor(GuiComponent.l);
      var7.setWidth(var3.getWidth());
      var7.onOffset(60.0);
      var3.addComponent(var7);
      var3.c2888(var3.c740(), null);
   }

   public Color c5443() {
      return this.c5185;
   }

   public List<ItemLimitData> getValue() {
      return this.c4221;
   }

   public void setValue(List<ItemLimitData> var1) {
      this.c4221 = var1;
   }

   public void parse(String var1) {
   }

   public ItemLimitData c200(String var1, int var2) {
      return this.c230(new ItemLimitData(var1, var2));
   }

   public ItemLimitData c230(ItemLimitData var1) {
      this.getValue().add(var1);
      if (this.c5336 == -1) {
         var1.c5708(-1);
      }

      FrameComponent var2 = new FrameComponent(false);
      var2.setWidth(95.0);
      var2.onRendererHandling(new PoseRenderer(1.0, 1.0, 2, 2, new PoseMatrix(0, 5, 0, 0)));
      new FrameLimitManager(var2, var1, this);
      this.c7636.c8120(var2);
      return var1;
   }

   public void c354(ItemLimitData var1) {
      try {
         this.getValue().remove(var1);
      } catch (Exception var9) {
      }

      IGuiComponent var2 = null;
      Iterator var3 = this.c7636.c6047().getComponents().iterator();

      while(true) {
         while(true) {
            IGuiComponent var4;
            do {
               if (!var3.hasNext()) {
                  if (var2 != null) {
                     this.c7636.c6047().c4043(var2);
                  }

                  return;
               }

               var4 = (IGuiComponent)var3.next();
            } while(!(var4 instanceof FrameComponent));

            FrameComponent var5 = (FrameComponent)var4;
            Iterator var6 = var5.getComponents().iterator();

            while(var6.hasNext()) {
               IGuiComponent var7 = (IGuiComponent)var6.next();
               if (var7 instanceof FrameLimitManager) {
                  FrameLimitManager var8 = (FrameLimitManager)var7;
                  if (var8.c1507().equals(var1) || var8.c1507().getName().equalsIgnoreCase(var1.getName())) {
                     var2 = var4;
                     break;
                  }
               }
            }
         }
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
               ItemLimitData var5 = (ItemLimitData)var4.next();
               this.c354(var5);
            }

            var4 = var2.iterator();

            while(var4.hasNext()) {
               JsonElement var8 = (JsonElement)var4.next();

               try {
                  ItemLimitData var6 = new ItemLimitData("", -1);
                  var6.c777(var8.getAsJsonObject());
                  this.c230(var6);
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
         ItemLimitData var4 = (ItemLimitData)var3.next();
         var2.add(var4.toJson());
      }

      var1.add("value", var2);
      return var1;
   }

   public boolean isValid(ItemStack var1, boolean var2) {
      if (var2 && this.c4221.isEmpty()) {
         return false;
      } else {
         Iterator var3 = this.getValue().iterator();

         ItemLimitData var4;
         do {
            if (!var3.hasNext()) {
               return false;
            }

            var4 = (ItemLimitData)var3.next();
         } while(!var4.c6497(var1));

         return true;
      }
   }

   public boolean isValid(ItemStack var1) {
      return this.isValid(var1, false);
   }

   public boolean c8634(String var1) {
      boolean var2 = true;
      Iterator var3 = this.c4221.iterator();

      while(var3.hasNext()) {
         ItemLimitData var4 = (ItemLimitData)var3.next();
         if (var4.c276()) {
            if (var4.getName().equalsIgnoreCase(var1)) {
               return true;
            }

            var2 = false;
         }
      }

      return var2;
   }

   public ItemLimitData c4768(String var1) {
      Iterator var2 = this.c4221.iterator();

      ItemLimitData var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (ItemLimitData)var2.next();
      } while(!var3.getName().equalsIgnoreCase(var1));

      return var3;
   }

   public int c5848() {
      return this.c5336;
   }

   // $FF: synthetic method
   public Object c2908() {
      return this.getValue();
   }
}
