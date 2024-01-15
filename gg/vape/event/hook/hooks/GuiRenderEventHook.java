package gg.vape.event.hook.hooks;

import gg.vape.Vape;
import gg.vape.event.forge.ForgeEventHook;
import gg.vape.event.hook.HookProcessor;
import gg.vape.module.Mod;
import gg.vape.module.none.ClickGui;
import gg.vape.wrapper.impl.RenderGameOverlayEvent;

import java.util.Iterator;

public class GuiRenderEventHook extends HookProcessor {
   public final ClickGui c153;

   public GuiRenderEventHook(ForgeEventHook var1) {
      super(var1);
      this.c153 = Vape.instance.getModManager().getMod(ClickGui.class);
   }

   public void c6176(Object var1) {
      RenderGameOverlayEvent var2 = new RenderGameOverlayEvent(var1);
      if (!var2.isCancelable() && var2.c2913()) {
         this.c153.render(var2);
         Iterator var3 = Vape.instance.getModManager().getMods().iterator();

         while(var3.hasNext()) {
            Mod var4 = (Mod)var3.next();
            var4.onRender2D(var2);
         }

      } else {
         if (var2.isCancelable()) {
            var2.setCancelled(true);
         }

      }
   }
}
