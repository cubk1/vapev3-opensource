package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class KeyBinding extends Wrapper {
   public KeyBinding(Object var1) {
      super(var1);
   }

   public static void setKeyBindState(int var0, boolean var1) {
      vape.getMappings().keyBinding.c6094(null, var0, var1);
   }

   public int getKeyCode() {
      return vape.getMappings().keyBinding.c4023(this.obj);
   }

   public boolean isPressed() {
      return vape.getMappings().keyBinding.c2418(this.obj);
   }

   public boolean c5354() {
      return vape.getMappings().keyBinding.c4246(this.obj);
   }

   public static void onTick(int var0) {
      vape.getMappings().keyBinding.c2327(var0);
   }
}
