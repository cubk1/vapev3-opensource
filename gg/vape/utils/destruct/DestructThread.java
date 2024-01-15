package gg.vape.utils.destruct;

import gg.vape.Vape;
import gg.vape.manager.FrameManager;
import gg.vape.mapping.Mapper;
import gg.vape.module.Category;
import gg.vape.unmap.ModeSelection;
import gg.vape.wrapper.Wrapper;
import gg.vape.wrapper.impl.ForgeVersion;
import pub.nextsense.Tweaker;

public class DestructThread extends Thread {
   // $FF: synthetic field
   final boolean c1952;
   // $FF: synthetic field
   final Vape vape;

   public DestructThread(Vape var1, boolean var2) {
      this.vape = var1;
      this.c1952 = var2;
   }

   public void run() {
      try {
         Thread.sleep(1000L);
         if (Vape.transformed) {
            this.vape.retransform();
         }

         Category.destruct();
         ModeSelection.c6304.clear();
         ModeSelection.c6304 = null;
         ForgeVersion.c2027 = null;
         Mapper.mappings.clear();
         this.vape.destructor.c1398();
         this.vape.destructor.c5772();
         this.vape.destructor.c8530();
         this.vape.destructor.c2098(Destructor.class.getClassLoader());
         this.vape.destructor.c7650();
         this.vape.destructor.c1695(Destructor.class.getClassLoader());
         this.vape.destructor.c8940();
         this.vape.destructor.c6182();
         FrameManager.c5483();
         Wrapper.vape = null;
         Vape.instance = null;
         Tweaker.disconnect();
      } catch (Exception var2) {
      }

   }
}
