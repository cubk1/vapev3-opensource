package gg.vape.event.forge;

import gg.vape.event.impl.EventKeyPress;
import gg.vape.mapping.MappedClasses;
import gg.vape.wrapper.impl.ForgeVersion;
import org.lwjgl.input.Keyboard;

public class ForgeKeyInputEvent extends ForgeEventHook {
   public ForgeKeyInputEvent() {
      super(MappedClasses.InputEvent$KeyInputEvent, ForgeVersion.minorVersion() == 13 ? 3 : 0);
   }

   public void call(Object var1) {
      if (!Keyboard.isRepeatEvent()) {
         EventKeyPress var2 = new EventKeyPress(Keyboard.getEventKey(), Keyboard.getEventKeyState());
         var2.fire();
      }
   }
}
