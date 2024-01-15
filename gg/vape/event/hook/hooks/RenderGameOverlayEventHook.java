package gg.vape.event.hook.hooks;

import gg.vape.Vape;
import gg.vape.event.forge.ForgePostRenderGameOverlayEvent;
import gg.vape.event.hook.HookProcessor;
import gg.vape.module.Mod;
import gg.vape.module.none.ClickGui;
import gg.vape.wrapper.impl.Minecraft;
import gg.vape.wrapper.impl.RenderGameOverlayEvent;

import java.awt.*;

public class RenderGameOverlayEventHook extends HookProcessor {
   public final ClickGui clickGui;
   public int alphaValue = 0;

   public RenderGameOverlayEventHook(ForgePostRenderGameOverlayEvent event) {
      super(event);
      this.clickGui = Vape.instance.getModManager().getMod(ClickGui.class);
   }

   public void draw() {
      ClickGui clickGui1 = Vape.instance.getModManager().getMod(ClickGui.class);
      if (clickGui1.guiBindIndicator.getValue()) {
         Color color = new Color(-16720972);
         if (this.alphaValue > 200) {
            int var3 = 300 - this.alphaValue;
            int alpha = (int)((double)var3 / 100.0 * 255.0);
            if (alpha <= 10) {
               alpha = 10;
            }

            color = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
         }

         Minecraft.getFontRenderer().drawStringWithShadow("Press " + clickGui1.getBindName() + " to open GUI", 2.0, 65.0, color);
      }
   }

   public void c6176(Object object) {
      RenderGameOverlayEvent event = new RenderGameOverlayEvent(object);
      if (!event.isCancelable() && event.c2913()) {
         if (Vape.instance.c4762() && this.alphaValue < 300) {
            this.draw();
            ++this.alphaValue;
         }

         this.clickGui.render(event);

         for (Mod module : Vape.instance.getModManager().getMods()) {
            module.onRender2D(event);
         }


         if (this.alphaValue >= 300) {
            this.c8478().setHookProcessor(new GuiRenderEventHook(this.c8478()));
         }

      } else {
         if (event.isCancelable()) {
            event.setCancelled(true);
         }

      }
   }
}
