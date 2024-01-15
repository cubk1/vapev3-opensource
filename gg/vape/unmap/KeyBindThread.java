package gg.vape.unmap;

import func.skidline.KeyBindRunner;
import gg.vape.Vape;
import gg.vape.module.none.ClickGui;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.util.ArrayList;

public class KeyBindThread extends Thread {
   // $FF: synthetic field
   final KeyBindRunner text;

   public KeyBindThread(KeyBindRunner var1) {
      this.text = var1;
   }

   public void run() {
      ClickGui var1 = Vape.instance.getModManager().getMod(ClickGui.class);
      this.text.c7213("Press a key");
      long var2 = Keyboard.getEventNanoseconds();
      long var4 = Mouse.getEventNanoseconds();
      ArrayList var7 = new ArrayList();
      int var8 = -1;
      int var9 = -1;

      while(true) {
         if (Thread.interrupted()) {
            return;
         }

         if (var8 != -1 && !Keyboard.isKeyDown(var8) || var9 != -1 && !Mouse.isButtonDown(var9) || var7.size() >= 3) {
            break;
         }

         int key;
         if (var2 != Keyboard.getEventNanoseconds() && !Keyboard.isRepeatEvent() && Keyboard.getEventKeyState()) {
            var2 = Keyboard.getEventNanoseconds();
            key = Keyboard.getEventKey();
            if (!var7.contains(key)) {
               var7.add(key);
               if (var8 == -1) {
                  var8 = key;
               }

               if (this.text.c7729().startsWith("Bound")) {
                  this.text.c7213(this.text.c7729() + " + " + Keyboard.getKeyName(key));
               } else {
                  this.text.c7213("Bound to " + Keyboard.getKeyName(key));
               }

               if (!var1.multiKeybinding.getValue()) {
                  break;
               }

               Keyboard.next();
            }
         } else {
            Keyboard.next();
            if (!Keyboard.isKeyDown(42)) {
               if (var4 != Mouse.getEventNanoseconds() && Mouse.getEventButtonState()) {
                  var4 = Mouse.getEventNanoseconds();
                  if (this.text.c7729().startsWith("Bound")) {
                     this.text.c7213(this.text.c7729() + " + M" + (Mouse.getEventButton() + 1));
                  } else {
                     this.text.c7213("Bound to M" + (Mouse.getEventButton() + 1));
                  }

                  key = -100 + Mouse.getEventButton();
                  if (var9 == -1) {
                     var9 = Mouse.getEventButton();
                  }

                  if (!var7.contains(key)) {
                     var7.add(key);
                     if (!var1.multiKeybinding.getValue()) {
                        break;
                     }

                     Mouse.next();
                  }
               } else {
                  Mouse.next();
               }
            }
         }
      }

      KeyBindRunner.c6626(this.text).c2585(var7);

      try {
         Thread.sleep(1000L);
      } catch (InterruptedException var11) {
         return;
      }

      this.text.c8071();
   }

   // $FF: synthetic method
   public KeyBindThread(KeyBindRunner var1, Object var2) {
      this(var1);
   }
}
