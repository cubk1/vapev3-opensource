package gg.vape.module.none;

import func.skidline.c1426;
import gg.vape.event.impl.EventRender3D;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.ui.unmap.SearchBlock;
import gg.vape.utils.RotationUtil;
import gg.vape.utils.datas.HSBData;
import gg.vape.utils.processors.SearchProcessor;
import gg.vape.utils.render.RenderUtil;
import gg.vape.value.BooleanValue;
import gg.vape.value.NumberValue;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.RenderManager;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class XRay extends Mod {
   public final List c3895 = new ArrayList();
   public final RenderManager c3995 = Minecraft.c5612();
   public final CopyOnWriteArrayList c1981 = new CopyOnWriteArrayList();
   public SearchProcessor c1917;
   public SearchProcessor c4843;
   public final NumberValue c2992 = NumberValue.create(this, "Range", "#", "", 1.0, 50.0, 100.0, 1.0);
   public final NumberValue c2916 = NumberValue.create(this, "-", "-", "-", 5.0, 5.0, 5.0, 1.0);
   public final BooleanValue c2905 = BooleanValue.create(this, "Only caves", false, "Only looks for ores exposed to air");
   public final NumberValue op = NumberValue.create(this, "Opacity", "#", "", 1.0, 80.0, 255, 1.0);
   public XRay() {
      super("XRay", -16737793, Category.None, "Draws outline around selected blocks\nAdd blocks in Search frame");
      this.addValue(this.c2992, this.c2905,op);
     // this.c2905.getComponent().addAction(new c1426(this));
   }

   public void c6140(SearchBlock var1) {
      this.c3895.add(var1);
   }

   public void c4868(SearchBlock var1) {
      this.c3895.remove(var1);
      Iterator var2 = this.c1981.iterator();

      while(var2.hasNext()) {
         HSBData var3 = (HSBData)var2.next();
         if (var1.c2801() == var3.c2810) {
            this.c1981.remove(var3);
         }
      }

   }

   public void onRender3D(EventRender3D event) {
      Minecraft.c2698().c6766(1.0);
      GL11.glPushMatrix();
      GL11.glEnable(GL11.GL_BLEND);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.5F);
      GL11.glDisable(GL11.GL_TEXTURE_2D);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      EntityPlayerSP var2 = Minecraft.thePlayer();
      double var3 = this.c3995.c1779();
      double var5 = this.c3995.c7584();
      double var7 = this.c3995.c63();
      Iterator var9 = this.c1981.iterator();

      while(var9.hasNext()) {
         HSBData var10 = (HSBData)var9.next();
         double var11 = RotationUtil.c582(var2, var10.c4291, var10.c6771, var10.c8812);
         if (var11 <= this.c2992.getValue()) {
            RenderUtil.c1806(var10, var3, var5, var7);
         } else if (var11 > this.c2992.getValue() + 10.0) {
            this.c1981.remove(var10);
         }
      }

      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glEnable(GL11.GL_TEXTURE_2D);
      GL11.glDisable(2848);
      GL11.glDisable(GL11.GL_BLEND);
      GL11.glPopMatrix();
      Minecraft.c2698().c4997(1.0);
   }

   public void onEnable() {
      this.c1917 = new SearchProcessor(this.c1981, this.c3895, this.c2992);
      this.c1917.c1028();
      this.c4843 = new SearchProcessor(this.c1981, this.c3895, this.c2916);
      this.c4843.c1028();
   }

   public void onDisable() {
      this.c1917.c3944();
      this.c4843.c3944();
      this.c1981.clear();
   }

   // $FF: synthetic method
   public static SearchProcessor c575(XRay var0) {
      return var0.c1917;
   }

   // $FF: synthetic method
   public static BooleanValue c8842(XRay var0) {
      return var0.c2905;
   }

   // $FF: synthetic method
   public static SearchProcessor c4560(XRay var0) {
      return var0.c4843;
   }
}
