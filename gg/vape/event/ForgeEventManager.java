package gg.vape.event;

import gg.vape.event.forge.*;
import gg.vape.event.hook.IHook;
import gg.vape.event.hook.hooks.TickEventHook;
import gg.vape.wrapper.impl.ForgeVersion;

import java.util.HashMap;
import java.util.Map;

public class ForgeEventManager {
   public final Map<Class<?>, IHook> hooks = new HashMap<>();
   public final Map<Class<?>,Integer> classIntegerMap = new HashMap<>();
   public int c4658 = 0;
   public boolean c8767;
   public ForgeRenderTickEvent c7721;

   public void c8727() {
      this.putEventHook(this.c7721 = new ForgeRenderTickEvent());
   }

   public void c3072() {
      this.c7721.setHookProcessor(new TickEventHook(this.c7721));
      this.putEventHook(new ForgeKeyInputEvent());
      this.putEventHook(new ForgePostRenderGameOverlayEvent());
      this.putEventHook(new ForgePlayerTickEvent());
      this.putEventHook(new ForgeLivingUpdateEvent());
      this.putEventHook(new ForgeMouseEvent());
      this.putEventHook(new ForgeRenderWorldLastEvent());
      this.putEventHook(new ForgePreRenderLivingEventPre());
      this.putEventHook(new ForgePreSpecialsRenderPlayerEvent());
      this.putEventHook(new ForgeSetArmorModelRenderPlayerEvent());
      this.putEventHook(new ForgeRenderHandEvent());
      this.putEventHook(new ForgeClientTickEvent());
      this.putEventHook(new ForgeRenderBlockOverlayEvent());
      this.putEventHook(new ForgeNameFormatEvent());
      this.putEventHook(new ForgeClientChatReceivedEvent());
      this.putEventHook(new ForgeEntityJoinWorldEvent());
      this.putEventHook(new ForgePlaySoundAtEntityEvent());
      this.putEventHook(new ForgePlayerInteractEvent());
      this.putEventHook(new ForgePreRenderLivingEvent());
      this.putEventHook(new ForgePostRenderLivingEvent());
      this.putEventHook(new ForgePreRenderPlayerEvent());
      this.putEventHook(new ForgePostRenderPlayerEvent());
      if (ForgeVersion.minorVersion() > 13) {
         this.putEventHook(new ForgeEntityViewRenderEvent());
         this.putEventHook(new ForgeFogDensityEntityViewRenderEvent());
         this.putEventHook(new ForgeRenderFogEventEntityViewRenderEvent());
      }

   }

   public void putEventHook(IHook hook) {
      this.hooks.put(hook.getTarget(), hook);
      this.classIntegerMap.put(hook.getTarget(), this.c4658++);
   }

   public void call(Object event) {
      Class<?> var2 = event.getClass();
      if (this.hooks.containsKey(var2)) {
         IHook hook = this.hooks.get(var2);
         hook.call(event);
      }

   }

   public void c5069(boolean var1) {
      this.c8767 = var1;
   }

   public boolean c6011() {
      return this.c8767;
   }
}
